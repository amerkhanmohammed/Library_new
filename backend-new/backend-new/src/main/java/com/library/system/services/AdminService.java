package com.library.system.services;

import com.library.system.dtos.admin.book.BookRequestDto;
import com.library.system.dtos.admin.book.BookResponseDto;


import com.library.system.dtos.user.ResultResponseDto;
import com.library.system.dtos.user.UserBookAssignmentResponseDto;
import com.library.system.dtos.user.UserSignupRequestDto;
import com.library.system.dtos.user.UserSignupResponseDto;
import com.library.system.enums.BookStatus;
import com.library.system.exceptions.DataValidationError;
import com.library.system.models.*;
import com.library.system.services.util.CommonMethods;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.JobState;
import java.util.*;

@Service
public class AdminService {
    private final BookService bookService;
    private final CategoryService categoryService;

    private final UserService userService;
    private final CommonMethods commonMethods;
    private final BookService userBookService;

    public AdminService(BookService bookService, CategoryService categoryService,  UserService userService, CommonMethods commonMethods, BookService userBookService) {
        this.bookService = bookService;
        this.categoryService = categoryService;

        this.userService = userService;
        this.commonMethods = commonMethods;
        this.userBookService = userBookService;
    }

    // Book Methods
    public List<BookResponseDto> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        List<BookResponseDto> bookResponseDto = new ArrayList<>();

        for (Book book : books) {
            bookResponseDto.add(new BookResponseDto(book));
        }

        return bookResponseDto;
    }

    public BookResponseDto getBookById(long bookId) {
        Book book = bookService.getBookById(bookId);
        return new BookResponseDto(book);
    }

    public BookResponseDto createBook(BookRequestDto bookRequestDto) {
        Book book = bookService.createNewBook(bookRequestDto.getTitle(),
                bookRequestDto.getAuthor(),
                bookRequestDto.getDescription());
        return new BookResponseDto(book);
    }

    public BookResponseDto modifyBookById(long bookId, BookRequestDto bookRequestDto) {
        Book book = bookService.getBookById(bookId);
        commonMethods.updateBookFromBookReqDto(book, bookRequestDto);
        book = bookService.modifyBook(book);

        return new BookResponseDto(book);
    }

    public BookResponseDto deleteBookById(long bookId) {
        Book book = bookService.deleteBook(bookId);
        return new BookResponseDto(book);
    }

    // Category Methods


    public Category getCategoryById(long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        return category;
      //  return new CategoryResponseDto(category);
    }

    public Category createCategory(Category categoryRequestDto) {
        Category category = categoryService.createNewCategory(
                categoryRequestDto.getName(),
                categoryRequestDto.getDescription());
               return  category;
        //  return new CategoryResponseDto(category);
    }

    public Category modifyCategoryById(long categoryId, Category categoryRequestDto) {
        Category category = categoryService.getCategoryById(categoryId);
        commonMethods.updateCategoryFromCategoryReqDto(category, categoryRequestDto);
        category = categoryService.modifyCategory(category);
        return category;
        //return new CategoryResponseDto(category);
    }

    public Category deleteCategoryById(long categoryId) {
        Category category = categoryService.deleteCategory(categoryId);
        return category;
    
    }


    // User Methods
    public UserSignupResponseDto adminSignup(UserSignupRequestDto userSignupRequestDto) {
        User user = userService.createUser(userSignupRequestDto, "ADMIN");
        return new UserSignupResponseDto(user);
    }

    public List<UserBookAssignmentResponseDto> assignBooksToUsersById(long bookId, List<Long> userIds) {
        Book book = bookService.getBookById(bookId);
        List<UserBookAssignmentResponseDto> responseDtoList = new ArrayList<>();

        for (Long userId : userIds) {
            User user = userService.getUserById(userId);
            if (userBookService.isBookAssignedToUser(book, user)) {
                responseDtoList.add(new UserBookAssignmentResponseDto(user, false));
                continue;
            }
            userBookService.assignBooksToUserId(userId, book);
            responseDtoList.add(new UserBookAssignmentResponseDto(user, true));
        }

        return responseDtoList;
    }

    public List<Category> getCategoriesByBookId(long bookId) {
    }

    class UserBookComparator implements Comparator<UserBook> {
        @Override
        public int compare(UserBook a, UserBook b) {
            return ((b.getScore()) - (a.getScore()));
        }
    }

    public List<ResultResponseDto> getResultOfAllUsers() {
        // TODO : This is a dummy method logic needs to be improved
        List<ResultResponseDto> responseDtoList = new ArrayList<>();
        List<UserBook> userBooks = userBookService.getAllUserBooks();

        userBooks.sort(new UserBookComparator());

        int rank = 0;
        String bookTitle = "";
        for (UserBook userBook : userBooks) {
            if (!bookTitle.equals(userBook.getBook().getTitle())) {
                rank = 0;
                bookTitle = userBook.getBook().getTitle();
            }


            if (userBook.getStatus() == BookStatus.RESERVED) {
                rank++;
                responseDtoList.add(new ResultResponseDto(userBook.getUser(), rank,
                        (String.valueOf(userBook.getScore()) + " / " +
                                String.valueOf(userBook.getMaxScore())),
                        userBook.getBook().getTitle()));
            }
        }

        return responseDtoList;
    }
}
