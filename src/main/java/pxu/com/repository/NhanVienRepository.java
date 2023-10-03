package pxu.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pxu.com.model.NhanVien;

@Repository("userRepository")
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
//    NhanVien findByTaiKhoan(String taiKhoan);
	NhanVien findByTaiKhoanAndMatKhau(String taiKhoan, String matKhau);

}