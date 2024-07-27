package com.library.system.models;
import com.library.system.enums.BookStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book_copies")
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "barcode", nullable = false, unique = true)
    private String barcode;

    @Column(name = "added_on")
    private String addedOn;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    public BookCopy() {
    }

    public BookCopy(Book book, String barcode, String addedOn, BookStatus status) {
        this.book = book;
        this.barcode = barcode;
        this.addedOn = addedOn;
        this.status = status;
    }

    public String getCopyNumber() {
        return this.barcode;
    }

    public boolean isAvailable() {
        return this.status == BookStatus.AVAILABLE;
    }
}
