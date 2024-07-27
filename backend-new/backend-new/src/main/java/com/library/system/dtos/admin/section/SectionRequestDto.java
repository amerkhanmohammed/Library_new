
package com.library.system.dtos.admin.section;

        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
public class SectionRequestDto {
    private long bookId;
    private String sectionName;
    private String description;
}
