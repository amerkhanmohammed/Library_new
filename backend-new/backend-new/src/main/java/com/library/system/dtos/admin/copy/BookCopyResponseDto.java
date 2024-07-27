
package com.library.system.dtos.admin.copy;

        import com.library.system.models.BookCopy;
        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
public class BookCopyResponseDto {
    private long id;
    private String copyNumber;
    private boolean isAvailable;

    public BookCopyResponseDto() {}

    public BookCopyResponseDto(BookCopy bookCopy) {
        this.id = bookCopy.getId();
        this.copyNumber = bookCopy.getCopyNumber();
        this.isAvailable = bookCopy.isAvailable();
    }

    public BookCopyResponseDto(BookCopyResponseDto copy) {
    }
}
