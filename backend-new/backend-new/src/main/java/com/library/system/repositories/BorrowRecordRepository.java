
package com.library.system.repositories;

        import com.library.system.models.BorrowRecord;
        import com.library.system.models.Book;
        import com.library.system.models.User;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;
        import java.util.Optional;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    List<BorrowRecord> findAllByUser(User user);
    Optional<BorrowRecord> findByBookAndUser(Book book, User user);
}
