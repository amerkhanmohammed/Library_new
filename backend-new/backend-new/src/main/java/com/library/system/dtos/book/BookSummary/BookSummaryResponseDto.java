
package com.library.system.dtos.book.BookSummary;

        import com.library.system.dtos.BaseDto;
        import com.library.system.models.Book;
        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
public class BookSummaryResponseDto extends BaseDto {
    private String summaryText;

    public BookSummaryResponseDto() {}

    public BookSummaryResponseDto(Book book) {
        this.id = book.getId();
        this.summaryText = book.getSummary();
    }
}
