package com.library.system.dtos.book.Details;
import com.library.system.models.Book;

public class BookByUserIdResponseDto {
    private long id;
    private String title;
    private String author;
    // Add other fields as needed

    // Constructor
    public BookByUserIdResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        // Initialize other fields as needed
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Add getters and setters for other fields

    @Override
    public String toString() {
        return "BookByUserIdResponseDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

