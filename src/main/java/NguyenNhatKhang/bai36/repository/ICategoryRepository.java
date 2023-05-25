package NguyenNhatKhang.bai36.repository;

import NguyenNhatKhang.bai36.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
