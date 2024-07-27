package com.library.system.models;

import com.library.system.dtos.book.Details.BookByUserIdResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Section extends BaseModel {
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(
            mappedBy = "section",
            cascade = CascadeType.ALL
    )
    private Set<Book> books;

    @Column(nullable = true)
    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BookByUserIdResponseDto getBook() {
        // Assuming this method is meant to get a single book from the section
        // Placeholder implementation, adjust based on your actual logic
        if (books != null && !books.isEmpty()) {
            Book book = books.iterator().next();
            return new BookByUserIdResponseDto(book);
        }
        return null;
    }
}
