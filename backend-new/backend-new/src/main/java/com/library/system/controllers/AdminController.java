
package com.library.system.controllers;

        import com.library.system.dtos.admin.book.BookRequestDto;
        import com.library.system.dtos.admin.book.BookResponseDto;
        import com.library.system.dtos.admin.section.SectionRequestDto;
        import com.library.system.dtos.admin.section.SectionResponseDto;
        import com.library.system.dtos.user.UserBookAssignmentResponseDto;
        import com.library.system.models.Category;
        import com.library.system.services.*;
        import org.springframework.web.bind.annotation.*;
      import com.library.system.dtos.user.ResultResponseDto;
        import java.util.List;
        import java.util.Set;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Book Endpoints
    @GetMapping("/book")
    public List<BookResponseDto> getAllBooks() {
        return adminService.getAllBooks();
    }

    @GetMapping("/book/{bookId}")
    public BookResponseDto getBookById(@PathVariable long bookId) {
        return adminService.getBookById(bookId);
    }

    @PostMapping("/book")
    public BookResponseDto createBook(@RequestBody BookRequestDto bookRequestDto) {
        return adminService.createBook(bookRequestDto);
    }

    @PutMapping("/book/{bookId}")
    public BookResponseDto modifyBookById(@PathVariable long bookId,
                                          @RequestBody BookRequestDto bookRequestDto) {
        return adminService.modifyBookById(bookId, bookRequestDto);
    }

    @DeleteMapping("/book/{bookId}")
    public BookResponseDto deleteBookById(@PathVariable long bookId) {
        return adminService.deleteBookById(bookId);
    }

    // Category Endpoints
    @GetMapping("/book/{bookId}/category")
    public List<Category> getCategoriesByBookId(@PathVariable long bookId) {
        return adminService.getCategoriesByBookId(bookId);
    }

    @GetMapping("/category/{categoryId}")
    public Category getCategoryById(@PathVariable long categoryId) {
        return adminService.getCategoryById(categoryId);
    }

    @PostMapping("/category")
    public Category createCategory(@RequestBody Category categoryRequestDto) {
        return adminService.createCategory(categoryRequestDto);
    }

    @PutMapping("/category/{categoryId}")
    public Category modifyCategoryById(@PathVariable long categoryId,
                                                  @RequestBody Category categoryRequestDto) {
        return adminService.modifyCategoryById(categoryId, categoryRequestDto);
    }

    @DeleteMapping("/category/{categoryId}")
    public Category deleteCategoryById(@PathVariable long categoryId) {
        return adminService.deleteCategoryById(categoryId);
    }


    @PostMapping("/book/{bookId}/assign")
    public List<UserBookAssignmentResponseDto> assignBooksToUsers(@PathVariable long bookId,
                                                                  @RequestBody List<Long> userIds) {
        return adminService.assignBooksToUsersById(bookId, userIds);
    }

    @GetMapping("/result")
    public List<ResultResponseDto> getResultOfAllUsers() {
        return adminService.getResultOfAllUsers();
    }
}
