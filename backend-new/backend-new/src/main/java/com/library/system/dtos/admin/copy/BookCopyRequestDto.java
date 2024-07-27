
package com.library.system.dtos.admin.copy;

        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
public class BookCopyRequestDto {
    private int id;
    private String copyNumber;
    private boolean isAvailable;
}
