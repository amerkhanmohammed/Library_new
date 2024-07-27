package com.library.system.models;


import com.library.system.enums.BookStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserBook extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "borrow_record_id", nullable = false)
    private BorrowRecord borrowRecord;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @Column(name = "score", nullable = true)
    private int score;

    @Column(name = "max_score", nullable = true)
    private int maxScore;

    public UserBook() {
    }

    public UserBook(User user, Book book, BorrowRecord borrowRecord, BookStatus status, int score, int maxScore) {
        this.user = user;
        this.book = book;
        this.borrowRecord = borrowRecord;
        this.status = status;
        this.score = score;
        this.maxScore = maxScore;
    }
}
