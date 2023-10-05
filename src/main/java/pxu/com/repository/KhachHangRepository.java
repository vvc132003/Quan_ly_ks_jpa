package pxu.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pxu.com.model.KhachHang;

@Repository("khachHangRepository")
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
	@Query("SELECT k FROM KhachHang k ORDER BY k.maKhachHang DESC")
	KhachHang findLastKhachHangWithLimit();

	KhachHang findByTaiKhoanAndMatKhau(String taiKhoan, String matKhau);

	@Query("SELECT kh FROM KhachHang kh ORDER BY kh.maKhachHang DESC")
	List<KhachHang> findAllOrderByCreatedAtDesc();
	
    KhachHang findByCccd(String cccd);
	
    KhachHang findByMaKhachHang(Long maKhachHang);


}