package pxu.com.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pxu.com.model.ThueDichVu;

@Repository("thueDichVuRepository")
public interface ThueDichVuRepository extends JpaRepository<ThueDichVu, Long> {
    List<ThueDichVu> findByThuePhongMaThuePhong(Long maThuePhong);

}
