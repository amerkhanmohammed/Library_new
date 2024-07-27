
package com.library.system.dtos.book.Booksection;

import com.library.system.dtos.BaseDto;

import com.library.system.models.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookBySectionIdResponseDto extends BaseDto {
    private long sectionId;
    private int shelfNumber;
    private String title;
    private String author;

    public BookBySectionIdResponseDto() { }

    public BookBySectionIdResponseDto(Book book) {
        this.id = book.getId();
        this.sectionId = book.getLibrarySection().getId();
        this.shelfNumber = book.getShelfNumber();
        this.title = book.getTitle();
        this.author = book.getAuthor();
    }
}
