
package com.library.system.models;

        import jakarta.persistence.Entity;
        import jakarta.persistence.ManyToOne;
        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
@Entity
public class BorrowRecord extends BaseModel {
    @ManyToOne
    private Book book;

    @ManyToOne
    private User member;

    private int borrowDuration;

    public BorrowRecord() {}

    public BorrowRecord(User member, Book book, int borrowDuration) {
        this.book = book;
        this.member = member;
        this.borrowDuration = borrowDuration;
    }
}
