package com.library.system.controllers;


import com.library.system.dtos.book.Details.BookByUserIdResponseDto;
import com.library.system.dtos.book.Details.BookByUserIdRequestDto;

import com.library.system.dtos.admin.book.BookResponseDto;
import com.library.system.services.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/library")
public class BookController {

        private final LibraryService libraryService;

        public BookController(LibraryService libraryService) {
                this.libraryService = libraryService;
        }

        @PostMapping("/user/{userId}/book/{bookId}")
        public String assignBooksToUser(@PathVariable long userId,
                                        @PathVariable long bookId) {
                return libraryService.assignBooksToUserId(userId, bookId);
        }

        @GetMapping("/user/{userId}/books")
        public List<BookByUserIdResponseDto> getAllBooksByUserId(@PathVariable long userId) {
                return libraryService.getAllBooksByUserId(userId);
        }



        @PutMapping("/book/{bookId}")
        public BookByUserIdResponseDto updateBookById(@PathVariable long bookId,
                                                      @RequestBody BookByUserIdRequestDto book) {
                return libraryService.updateBookById(bookId, book);
        }

        // New Methods

        @GetMapping("/books")
        public List<BookResponseDto> getAllBooks() {
                return libraryService.getAllBooks();
        }

        @GetMapping("/book/{bookId}")
        public BookResponseDto getBookById(@PathVariable long bookId) {
                return libraryService.getBookById(bookId);
        }

        @GetMapping("/section/{sectionId}/books")
        public List<BookResponseDto> getAllBooksBySectionId(@PathVariable long sectionId) {
                return libraryService.getAllBooksBySectionId(sectionId);
        }
}
