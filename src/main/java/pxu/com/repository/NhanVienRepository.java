package pxu.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pxu.com.model.KhachHang;
import pxu.com.model.NhanVien;

@Repository("nhanVienRepository")
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
	
}
