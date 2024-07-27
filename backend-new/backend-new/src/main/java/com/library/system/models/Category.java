package com.library.system.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books;

    @Column(nullable = true)
    private String description;

    public void setBookId(long bookId) {
        // Assuming this method is meant to link a book by its ID
        Book book = new Book();
        book.setId(bookId);
        this.books.add(book);
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Returns a list of book IDs associated with this category
    public Set<Long> getBookIds() {
        if (this.books == null) {
            return Set.of(); // Return an empty set if books is null
        }
        return this.books.stream()
                .map(Book::getId) // Map each Book to its ID
                .collect(Collectors.toSet()); // Collect IDs into a Set
    }

    // Returns the name of the category
    public String getName() {
        return this.name;
    }

    // Sets the name of the category
    public void setName(String name) {
        this.name = name;
    }
}
