package com.library.system.services;

import com.library.system.dtos.book.Details.BookByUserIdRequestDto;
import com.library.system.dtos.book.Details.BookByUserIdResponseDto;

import com.library.system.dtos.admin.book.BookResponseDto;

import com.library.system.models.*;
import org.springframework.stereotype.Service;
import com.library.system.dtos.book.Details.BookByCategoryIdResponseDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LibraryService {

    private final BookService bookService;
    private final UserService userService;

    public LibraryService(BookService bookService, UserService userService) {

        this.bookService = bookService;
        this.userService = userService;
    }





    public List<BookByCategoryIdResponseDto> getBooksByCategoryId(long categoryId) {
        List<BookByCategoryIdResponseDto> bookList = new ArrayList<>();
        List<Book> books = bookService.getAllBooksByCategoryId(categoryId);

        for (Book book : books) {
            bookList.add(new BookByCategoryIdResponseDto(book));
        }

        return bookList;
    }



    // New methods

    public List<BookResponseDto> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        List<BookResponseDto> bookResponseList = new ArrayList<>();

        for (Book book : books) {
            bookResponseList.add(new BookResponseDto(book));
        }

        return bookResponseList;
    }

    public BookResponseDto getBookById(long bookId) {
        Book book = bookService.getBookById(bookId);
        return new BookResponseDto(book);
    }

    public List<BookResponseDto> getAllBooksBySectionId(long sectionId) {
        List<Book> books = bookService.getAllBooksBySectionId(sectionId);
        List<BookResponseDto> bookResponseList = new ArrayList<>();

        for (Book book : books) {
            bookResponseList.add(new BookResponseDto(book));
        }

        return bookResponseList;
    }

    public String assignBooksToUserId(long userId, long bookId) {
        User user = userService.getUserById(userId);
        Book book = bookService.getBookById(bookId);

        bookService.assignBookToUser(user, book);

        return "Book assigned to user successfully";
    }

    public List<BookByUserIdResponseDto> getAllBooksByUserId(long userId) {
        List<Book> books = bookService.getAllBooksByUserId(userId);
        List<BookByUserIdResponseDto> bookResponseList = new ArrayList<>();

        for (Book book : books) {
            bookResponseList.add(new BookByUserIdResponseDto(book));
        }

        return bookResponseList;
    }



    public BookByUserIdResponseDto updateBookById(long bookId, BookByUserIdRequestDto bookDto) {
        Book book = bookService.getBookById(bookId);
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());


        book = bookService.modifyBook(book);

        return new BookByUserIdResponseDto(book);
    }
}
