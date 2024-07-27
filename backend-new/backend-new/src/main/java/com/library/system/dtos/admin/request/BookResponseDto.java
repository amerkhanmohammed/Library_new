
package com.library.system.dtos.admin.request;

        import com.library.system.dtos.admin.copy.BookCopyResponseDto;
        import com.library.system.models.BookCopy;
        import com.library.system.models.Book;
        import lombok.Getter;
        import lombok.Setter;

        import java.util.HashSet;
        import java.util.Set;

@Getter
@Setter
public class BookResponseDto {
    private long id;
    private long sectionId;
    private String title;
    private String author;
    private Set<BookCopyResponseDto> copies;

    public BookResponseDto() {}

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.sectionId = book.getSection().getId();


        if(copies != null) {
            this.copies = new HashSet<>();
            for (BookCopyResponseDto copy : copies) {
                this.copies.add(new BookCopyResponseDto(copy));
            }
        }
    }
}

