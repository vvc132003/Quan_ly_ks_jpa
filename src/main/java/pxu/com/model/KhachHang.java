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

	@Column(name = "DiaChi")
	private String diaChi;

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

	public KhachHang(Long maKhachHang, String hoVaTenDem,  String soDienThoai, String email, String diaChi,
			Collection<ThuePhong> danhSachThuePhong) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoVaTenDem = hoVaTenDem;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
		this.danhSachThuePhong = danhSachThuePhong;
	}

	public KhachHang() {
		super();
	}

}
