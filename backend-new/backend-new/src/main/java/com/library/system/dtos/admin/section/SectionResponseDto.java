package com.library.system.dtos.admin.section;

        import com.library.system.models.Section;
        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
public class SectionResponseDto {
    private long id;
    private String sectionName;
    private String description;
    private long bookId;

    public SectionResponseDto() {
    }

    public SectionResponseDto(Section section) {
        this.id = section.getId();
        this.sectionName = section.getName();
        this.description = section.getDescription();
        this.bookId = section.getBook().getId(); // assuming Section has a reference to Book
    }
}
