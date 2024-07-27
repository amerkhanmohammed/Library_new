package com.library.system.dtos.admin.request;



import com.library.system.dtos.admin.copy.BookCopyRequestDto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestDto {
    private long id;
    private long sectionId;
    private String title;
    private String author;
    private Set<BookCopyRequestDto> copies;
}
