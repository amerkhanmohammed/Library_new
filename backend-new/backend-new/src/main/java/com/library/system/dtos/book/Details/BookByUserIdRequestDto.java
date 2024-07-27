package com.library.system.dtos.book.Details;

public class BookByUserIdRequestDto {
    private long userId;
    private String title;  // Add this field if it's required
    private String author; // Add this field if it's required

    // Constructor
    public BookByUserIdRequestDto(long userId, String title, String author) {
        this.userId = userId;
        this.title = title;
        this.author = author;
    }

    // Getter and Setter for userId
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BookByUserIdRequestDto{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
