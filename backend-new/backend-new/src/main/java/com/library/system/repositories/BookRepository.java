

package com.library.system.repositories;

        import com.library.system.models.Book;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Override
    List<Book> findAll();
    List<Book> findAllByCategoryId(long categoryId);

    List<Book> findAllBySectionId(long sectionId);

    List<Book> findAllByUserId(long userId);
}
