

package com.library.system.dtos.book.Details;

        import com.library.system.dtos.BaseDto;
        import com.library.system.enums.BookStatus;
        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
public class UpdateBookByIdRequestDto extends BaseDto {
    private BookStatus status;
    private long authorId;
}
