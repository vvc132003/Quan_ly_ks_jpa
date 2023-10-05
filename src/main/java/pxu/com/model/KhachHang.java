package pxu.com.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "khachhang")
public class KhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaKhachHang")
	private Long maKhachHang;

	@Column(name = "HoVaTenDem")
	private String hoVaTenDem;

	@Column(name = "SoDienThoai")
	private String soDienThoai;

	@Column(name = "Email")
	private String email;

	@Column(name = "CCCD")
	private String cccd;

	@Column(name = "DiaChi")
	private String diaChi;

	@Column(name = "TaiKhoan")
	private String taiKhoan;

	public KhachHang(Long maKhachHang, String hoVaTenDem, String soDienThoai, String email, String cccd, String diaChi,
			String taiKhoan, String matKhau, Collection<ThuePhong> danhSachThuePhong) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoVaTenDem = hoVaTenDem;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.cccd = cccd;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.danhSachThuePhong = danhSachThuePhong;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	// Trường mật khẩu cho nhân viên
	@Column(name = "MatKhau")
	private String matKhau;

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	// Một khách hàng có nhiều giao dịch thuê phòng
	@OneToMany(mappedBy = "khachHang")
	private Collection<ThuePhong> danhSachThuePhong;

	public Long getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(Long maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getHoVaTenDem() {
		return hoVaTenDem;
	}

	public void setHoVaTenDem(String hoVaTenDem) {
		this.hoVaTenDem = hoVaTenDem;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Collection<ThuePhong> getDanhSachThuePhong() {
		return danhSachThuePhong;
	}

	public void setDanhSachThuePhong(Collection<ThuePhong> danhSachThuePhong) {
		this.danhSachThuePhong = danhSachThuePhong;
	}

	public KhachHang() {
		super();
	}

}