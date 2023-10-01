package pxu.com.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pxu.com.model.ThueDichVu;

@Repository("thueDichVuRepository")
public interface ThueDichVuRepository extends JpaRepository<ThueDichVu, Long> {

	List<ThueDichVu> findByThuePhongMaThuePhong(Long maThuePhong);
	
	
	@Query("SELECT SUM(td.thanhTien * td.soLuong) FROM ThueDichVu td WHERE td.thuePhong.maThuePhong = :maThuePhong")
	BigDecimal  calculateTotalCostByMaThuePhong(@Param("maThuePhong")Long maThuePhong);
}
