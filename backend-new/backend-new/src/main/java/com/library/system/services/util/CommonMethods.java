package com.library.system.services.util;

import com.library.system.dtos.admin.book.BookRequestDto;

import com.library.system.models.Book;
import com.library.system.models.Category;

import org.springframework.stereotype.Service;

@Service
public class CommonMethods {

    public void updateCategoryFromCategoryReqDto(Category category, Category categoryRequestDto) {
        // Update Category attributes from CategoryRequestDto
        if (categoryRequestDto.getName() != null) {
            category.setName(categoryRequestDto.getName());
        }
        if (categoryRequestDto.getDescription() != null) {
            category.setDescription(categoryRequestDto.getDescription());
        }

    }

    public void updateBookFromBookReqDto(Book book, BookRequestDto bookRequestDto) {
        // Update Book attributes from BookRequestDto
        if (bookRequestDto.getTitle() != null) {
            book.setTitle((String) bookRequestDto.getTitle());
        }
        if (bookRequestDto.getAuthor() != null) {
            book.setAuthor(bookRequestDto.getAuthor());
        }


        if (bookRequestDto.getDescription() != null) {
            book.setDescription(bookRequestDto.getDescription());
        }

    }
}
