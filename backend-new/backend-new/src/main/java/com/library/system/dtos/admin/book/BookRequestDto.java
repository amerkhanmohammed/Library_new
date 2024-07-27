package com.library.system.dtos.admin.book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestDto {
    private String bookName;  // Represents the title of the book
    private String author;    // Author of the book
    private String description; // Description of the book
    private int publicationYear; // Publication year of the book

    // Returns the book title (which is stored in bookName)
    public String getTitle() {
        return bookName;
    }

    // Optionally, you can add a setter for title if needed
    public void setTitle(String title) {
        this.bookName = title;
    }
}
