package pxu.com.repository;

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
}
