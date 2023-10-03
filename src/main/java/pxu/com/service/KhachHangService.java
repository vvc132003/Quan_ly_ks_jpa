package pxu.com.service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.com.model.DichVu;
import pxu.com.model.KhachHang;
import pxu.com.model.NhanVien;
import pxu.com.repository.KhachHangRepository;

@Service
public class KhachHangService {
	@Autowired
	private KhachHangRepository khachHangRepository;

	@Transactional
	public KhachHang findByTenDangNhapAndMatKhau(String taiKhoan, String matKhau) {
		return khachHangRepository.findByTaiKhoanAndMatKhau(taiKhoan, matKhau);
	}

	@Transactional
	public void savekhachhang(KhachHang khachHang) {
		khachHangRepository.save(khachHang);
	}

	@Transactional
	public List<KhachHang> getkhachhang() {
		return khachHangRepository.findAll();
	}

	@Transactional
	public Optional<KhachHang> getKhachhang(Long maKhachHang) {
		return khachHangRepository.findById(maKhachHang);
	}

	@Transactional
	public void deletekhachhang(Long maKhachHang) {
		khachHangRepository.deleteById(maKhachHang);
	}

	public Optional<KhachHang> updateDichVu(Long maKhachHang, KhachHang khachHang) {
		if (!khachHangRepository.existsById(maKhachHang)) {
			return Optional.empty();
		}
		khachHang.setMaKhachHang(maKhachHang);
		return Optional.of(khachHangRepository.save(khachHang));
	}

}