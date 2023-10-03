package pxu.com.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.com.model.DichVu;
import pxu.com.model.KhachHang;
import pxu.com.model.NhanVien;
import pxu.com.repository.KhachHangRepository;
import pxu.com.repository.NhanPhongRepository;
import pxu.com.repository.NhanVienRepository;

@Service
public class NhanVienService {
	@Autowired
	private NhanVienRepository nhanVienRepository;

	@Transactional
	public void savenhanvien(NhanVien nhanVien) {
		nhanVienRepository.save(nhanVien);
	}

	@Transactional
	public List<NhanVien> getNhanvien() {
		return nhanVienRepository.findAll();
	}
	@Transactional
	public NhanVien getNhanvienById(Long id) {
		Optional<NhanVien> optionalDichVu = nhanVienRepository.findById(id);
		return optionalDichVu.orElse(null);
	}
//	@Transactional
//	public NhanVien findBytaiKhoanAndPassword(String taiKhoan) {
//		return nhanVienRepository.findByTaiKhoan(taiKhoan);
//	}
	
	@Transactional
	public NhanVien findBytaiKhoanAndPassword(String taiKhoan , String matKhau) {
		return nhanVienRepository.findByTaiKhoanAndMatKhau(taiKhoan, matKhau);
	}

//	@Transactional
//	public Optional<KhachHang> getKhachhang(Long maKhachHang) {
//		return khachHangRepository.findById(maKhachHang);
//	}
//
//	@Transactional
//	public void deletekhachhang(Long maKhachHang) {
//		khachHangRepository.deleteById(maKhachHang);
//	}
//
//	public Optional<KhachHang> updateDichVu(Long maKhachHang, KhachHang khachHang) {
//		if (!khachHangRepository.existsById(maKhachHang)) {
//			return Optional.empty();
//		}
//		khachHang.setMaKhachHang(maKhachHang);
//		return Optional.of(khachHangRepository.save(khachHang));
//	}
}