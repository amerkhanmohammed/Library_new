package com.library.system.dtos.admin.book;

        import com.library.system.models.Book;
        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
public class BookResponseDto {
    private long id;
    private String bookName;
    private String author;
    private String description;
    private int publicationYear;

    public BookResponseDto() {

    }

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.bookName = book.getName();
        this.author = book.getAuthor();
        this.description = book.getDescription();
        this.publicationYear = book.getPublicationYear();
    }
}
