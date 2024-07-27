package com.library.system.models;

import com.library.system.dtos.book.Details.BookByUserIdResponseDto;
import jakarta.persistence.*;
import com.library.system.enums.BookStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Book extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private int publishedYear;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @ManyToMany(mappedBy = "books")
    private Set<Category> categories;

    // Getter for name (title)
    public String getName() {
        return this.title;
    }

    // Getter for description
    public String getDescription() {
        return "Description of the book";
    }

    // Getter for publication year
    public int getPublicationYear() {
        return this.publishedYear;
    }

    // Check availability
    public boolean isAvailable() {
        return this.status == BookStatus.AVAILABLE;
    }


    public BookByUserIdResponseDto getSection() {
        return new BookByUserIdResponseDto(this);
    }

    public BookByUserIdResponseDto getLibrarySection() {
        return new BookByUserIdResponseDto(this);
    }

    public int getShelfNumber() {
        return 0;
    }

    public String getSummary() {
        return "Summary of the book";
    }

    public BookByUserIdResponseDto getLibraryCategory() {
        return new BookByUserIdResponseDto(this);
    }


    public BookStatus getStatus() {
        return this.status;
    }


}
