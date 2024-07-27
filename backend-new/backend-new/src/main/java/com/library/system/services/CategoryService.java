
package com.library.system.services;

        import com.library.system.exceptions.CategoryNotFoundException;
        import com.library.system.models.Book;
        import com.library.system.models.Category;
        import com.library.system.repositories.CategoryRepository;
        import org.springframework.stereotype.Service;

        import java.util.Date;
        import java.util.HashSet;
        import java.util.List;
        import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final BookService bookService;

    public CategoryService(CategoryRepository categoryRepository,
                           BookService bookService) {
        this.categoryRepository = categoryRepository;
        this.bookService = bookService;
    }

    public List<Category> getAllCategoriesByBookId(long bookId) {
        List<Category> categoryList = categoryRepository.findAllByBookId(bookId);

        if (categoryList.isEmpty()) {
            throw new CategoryNotFoundException();
        }

        return categoryList;
    }

    public Category getCategoryById(long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isEmpty()) {
            throw new CategoryNotFoundException();
        }

        return categoryOptional.get();
    }

    public Category createNewCategory(String name,
                                      String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setCreatedOn(new Date());
        category.setActive(true);

        long bookId = 0;
        Book book = bookService.getBookById(bookId);
        category.setBooks(new HashSet<>());
        category.getBooks().add(book);

        category = categoryRepository.save(category);

        return category;
    }

    public Category modifyCategory(Category category) {
        if (!categoryRepository.existsById(category.getId())) {
            throw new CategoryNotFoundException();
        }
        category = categoryRepository.save(category);
        return category;
    }

    public Category deleteCategory(long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isEmpty()) {
            throw new CategoryNotFoundException();
        }

        Category category = categoryOptional.get();
        categoryRepository.delete(category);

        return category;
    }
}
