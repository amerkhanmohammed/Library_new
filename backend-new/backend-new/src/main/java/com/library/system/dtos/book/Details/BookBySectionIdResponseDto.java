
package com.library.system.dtos.book.Details;

        import com.library.system.dtos.BaseDto;
        import com.library.system.enums.BookStatus;
        import com.library.system.models.Book;

        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
public class BookBySectionIdResponseDto extends BaseDto {
    private long categoryId;
    private int shelfNumber;
    private BookStatus status;

    public void BookByCategoryIdResponseDto() {}

    public void BookByCategoryIdResponseDto(Book book) {
        this.id = book.getId();
        this.categoryId = book.getLibraryCategory().getId();
        this.shelfNumber = book.getShelfNumber();
        this.status = book.getStatus();
    }
}
