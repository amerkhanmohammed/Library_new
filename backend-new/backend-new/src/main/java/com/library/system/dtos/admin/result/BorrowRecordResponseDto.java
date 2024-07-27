
package com.library.system.dtos.admin.borrow;

        import com.library.system.dtos.BaseDto;
        import com.library.system.models.User;
        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
public class BorrowRecordResponseDto extends BaseDto {
    private String userName;
    private String fullName;
    private String bookTitle;
    private String borrowDate;
    private String returnDate;
    private String status;

    public BorrowRecordResponseDto(User user, String bookTitle, String borrowDate, String returnDate, String status) {
        this.id = user.getId();
        this.userName = user.getUsername();
        this.fullName = user.getFullName();
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }
}
