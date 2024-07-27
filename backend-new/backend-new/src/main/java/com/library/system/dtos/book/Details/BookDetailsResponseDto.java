package com.library.system.dtos.book.Details;

        import com.library.system.dtos.BaseDto;
        import com.library.system.dtos.book.BookSummary.BookSummaryResponseDto;
        import com.library.system.enums.BookStatus;
        import com.library.system.models.Book;

        import lombok.Getter;
        import lombok.Setter;

        import java.util.HashSet;
        import java.util.Set;

@Getter
@Setter
public class BookDetailsResponseDto extends BaseDto {
    private long categoryId;
    private String title;
    private BookStatus status;
    private long authorId;
    private Set<BookSummaryResponseDto> summaries;

    public BookDetailsResponseDto() {}

    public BookDetailsResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.status = book.getStatus();
        this.authorId = Long.parseLong(book.getAuthor());


    }
}

