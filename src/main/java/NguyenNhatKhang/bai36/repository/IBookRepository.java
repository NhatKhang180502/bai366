package NguyenNhatKhang.bai36.repository;

import NguyenNhatKhang.bai36.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
}
