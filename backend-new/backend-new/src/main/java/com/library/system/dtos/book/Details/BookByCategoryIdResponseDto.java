package com.library.system.dtos.book.Details;



import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookByCategoryIdResponseDto {

    private long categoryId;
    private String categoryName;
    private List<BookDto> books;

    @Getter
    @Setter
    public static class BookDto {
        private long id;
        private String title;
        private String author;
        private String isbn;
        private int publicationYear;
    }
}
