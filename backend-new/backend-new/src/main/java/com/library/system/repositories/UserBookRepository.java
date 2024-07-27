
package com.library.system.repositories;

        import com.library.system.models.Book;
        import com.library.system.models.User;
        import com.library.system.models.UserBook;
        import com.library.system.models.BorrowRecord;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook, Long> {
    List<UserBook> findAllByBorrowRecord(BorrowRecord borrowRecord);

        boolean existsByBookAndUser(Book book, User user);
}
