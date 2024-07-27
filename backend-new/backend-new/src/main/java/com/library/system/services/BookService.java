package com.library.system.services;

import com.library.system.exceptions.BookNotFoundException;
import com.library.system.models.Book;
import com.library.system.models.User;
import com.library.system.models.UserBook;
import com.library.system.repositories.BookRepository;
import com.library.system.repositories.UserBookRepository;
import com.library.system.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserBookRepository userBookRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserBookRepository userBookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userBookRepository = userBookRepository;
        this.userRepository = userRepository;
    }

    public List<Book> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();

        if (bookList.isEmpty()) {
            throw new BookNotFoundException();
        }

        return bookList;
    }

    public Book getBookById(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isEmpty()) {
            throw new BookNotFoundException();
        }

        return bookOptional.get();
    }

    public Book createNewBook(String title,
                              String author,
                              String isbn
                             ) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);


        book = bookRepository.save(book);

        return book;
    }

    public Book modifyBook(Book book) {
        if (!bookRepository.existsById((long) book.getId())) {
            throw new BookNotFoundException();
        }
        book = bookRepository.save(book);
        return book;
    }

    public Book deleteBook(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isEmpty()) {
            throw new BookNotFoundException();
        }

        Book book = bookOptional.get();
        bookRepository.delete(book);

        return book;
    }

    public List<Book> getAllBooksBySectionId(long sectionId) {
        // Assuming you have a method in the repository to find books by sectionId
        return bookRepository.findAllBySectionId(sectionId);
    }

    public List<Book> getAllBooksByUserId(long userId) {
        // Assuming you have a method in the repository to find books by userId
        return bookRepository.findAllByUserId(userId);
    }



    public boolean isBookAssignedToUser(Book book, User user) {
        // Check if the book is assigned to the user
        return userBookRepository.existsByBookAndUser(book, user);
    }

    public void assignBooksToUser(User user, Book book) {
        // Create a new UserBook entity to represent the relationship
        UserBook userBook = new UserBook();
        userBook.setUser(user);
        userBook.setBook(book);

        userBookRepository.save(userBook);
    }

    public List<UserBook> getAllUserBooks() {
        // Retrieve all user-book relationships
        return userBookRepository.findAll();
    }

    public void assignBookToUser(User user, Book book) {
        // This method is similar to assignBooksToUser
        // Ensure it has a distinct purpose or merge with assignBooksToUser
        UserBook userBook = new UserBook();
        userBook.setUser(user);
        userBook.setBook(book);

        userBookRepository.save(userBook);
    }

    public List<Book> getAllBooksByCategoryId(long categoryId) {
        // Assuming you have a method in the repository to find books by categoryId
        return bookRepository.findAllByCategoryId(categoryId);
    }

    public void assignBooksToUserId(long userId, Book book) {
        // Find the user by ID
        Optional<User> userOptional = userRepository.findById(userId);



        User user = userOptional.get();

        // Create a new UserBook entity to represent the relationship
        UserBook userBook = new UserBook();
        userBook.setUser(user);
        userBook.setBook(book);

        // Save the relationship
        userBookRepository.save(userBook);
    }

}
