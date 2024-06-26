package pxu.com.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pxu.com.model.DichVu;
import pxu.com.model.KhachHang;
import pxu.com.model.Phong;
import pxu.com.model.ThuePhong;

@Repository("thuePhongRepository")
public interface ThuePhongRepository extends JpaRepository<ThuePhong, Long> {
	@Query("SELECT tp FROM ThuePhong tp WHERE tp.phong.maPhong = :maPhong AND tp.trangThai = 'Đang thuê'")
	List<ThuePhong> findAllByMaPhongAndTrangThai(@Param("maPhong") Long maPhong);

	@Query("SELECT tp FROM ThuePhong tp WHERE tp.phong.maPhong = :maPhong AND tp.trangThai = 'Đã đặt'")
	List<ThuePhong> findAllByMaPhongAndTrangThaiDadat(@Param("maPhong") Long maPhong);

	@Modifying
	@Query("UPDATE ThuePhong tp SET tp.trangThai = 'Đa tra', tp.tongTien = :tongTien WHERE tp.maThuePhong = :maThuePhong")
	void updateTrangThaiAndTongTien(@Param("tongTien") BigDecimal tongTien, @Param("maThuePhong") Long maThuePhong);

	@Query("SELECT tp FROM ThuePhong tp ORDER BY tp.maThuePhong DESC")
	List<ThuePhong> findAllOrderByMaThuePhongDesc();

	@Query("SELECT MONTH(tp.ngayNhanPhong) AS thang, SUM(tp.tongTien) AS doanhThu FROM ThuePhong tp GROUP BY thang")
	List<Object[]> thongKeDoanhThuTheoThang();
	
	
	@Modifying
	@Query("UPDATE ThuePhong tp SET tp.trangThai = 'Đang thuê' WHERE tp.maThuePhong = :maThuePhong")
	void updateTrangThai(@Param("maThuePhong") Long maThuePhong);

}