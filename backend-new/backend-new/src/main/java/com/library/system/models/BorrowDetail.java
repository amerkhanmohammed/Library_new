
package com.library.system.models;

        import jakarta.persistence.Entity;
        import jakarta.persistence.ManyToOne;
        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
@Entity
public class BorrowDetail extends BaseModel {
    @ManyToOne
    private Book book;
    @ManyToOne
    private BorrowRecord borrowRecord;
    private int duration;
    private boolean isReturned;

    public BorrowDetail() {
        this.isReturned = false;
    }

    public BorrowDetail(BorrowRecord borrowRecord, Book book, int duration) {
        this.book = book;
        this.borrowRecord = borrowRecord;
        this.duration = duration;
        this.isReturned = false;
    }
}
