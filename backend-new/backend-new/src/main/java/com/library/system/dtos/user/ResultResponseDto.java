package com.library.system.dtos.user;
import com.library.system.models.User;

public class ResultResponseDto {
    private User user;
    private int rank;
    private String score;
    private String bookTitle;

    // Constructor
    public ResultResponseDto(User user, int rank, String score, String bookTitle) {
        this.user = user;
        this.rank = rank;
        this.score = score;
        this.bookTitle = bookTitle;
    }

    // Getters and Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "ResultResponseDto{" +
                "user=" + user +
                ", rank=" + rank +
                ", score='" + score + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }
}
