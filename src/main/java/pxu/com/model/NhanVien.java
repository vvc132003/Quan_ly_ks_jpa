package pxu.com.model;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaNhanVien")
	private Long maNhanVien;

	@Column(name = "HoVaTenDem")
	private String hoVaTenDem;

	@Column(name = "ChucVu")
	private String chucVu;

	@Column(name = "Luong")
	private BigDecimal luong;

	@Column(name = "TaiKhoan")
	private String taiKhoan;

	// Trường mật khẩu cho nhân viên
	@Column(name = "MatKhau")
	private String matKhau;

	// Một nhân viên có thể liên quan đến nhiều giao dịch thuê phòng
	@OneToMany(mappedBy = "nhanVien")
	private Collection<ThuePhong> danhSachThuePhong;

	// Một nhân viên có thể liên quan đến nhiều giao dịch chuyển phòng
	@OneToMany(mappedBy = "nhanVien")
	private Collection<ChuyenPhong> danhSachChuyenPhong;

	// Một nhân viên có thể liên quan đến nhiều giao dịch trả phòng
	@OneToMany(mappedBy = "nhanVien")
	private Collection<TraPhong> danhSachTraPhong;

	// Một nhân viên có thể liên quan đến nhiều giao dịch thuê dịch vụ
	@OneToMany(mappedBy = "nhanVien")
	private Collection<ThueDichVu> danhSachThueDichVu;
	// Constructors, getters, setters

	public Long getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(Long maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoVaTenDem() {
		return hoVaTenDem;
	}

	public void setHoVaTenDem(String hoVaTenDem) {
		this.hoVaTenDem = hoVaTenDem;
	}

	
	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}



	public BigDecimal getLuong() {
		return luong;
	}

	public void setLuong(BigDecimal luong) {
		this.luong = luong;
	}

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

	public Collection<ThuePhong> getDanhSachThuePhong() {
		return danhSachThuePhong;
	}

	public void setDanhSachThuePhong(Collection<ThuePhong> danhSachThuePhong) {
		this.danhSachThuePhong = danhSachThuePhong;
	}

	public Collection<ChuyenPhong> getDanhSachChuyenPhong() {
		return danhSachChuyenPhong;
	}

	public void setDanhSachChuyenPhong(Collection<ChuyenPhong> danhSachChuyenPhong) {
		this.danhSachChuyenPhong = danhSachChuyenPhong;
	}

	public Collection<TraPhong> getDanhSachTraPhong() {
		return danhSachTraPhong;
	}

	public void setDanhSachTraPhong(Collection<TraPhong> danhSachTraPhong) {
		this.danhSachTraPhong = danhSachTraPhong;
	}

	public Collection<ThueDichVu> getDanhSachThueDichVu() {
		return danhSachThueDichVu;
	}

	public void setDanhSachThueDichVu(Collection<ThueDichVu> danhSachThueDichVu) {
		this.danhSachThueDichVu = danhSachThueDichVu;
	}

	

	public NhanVien(Long maNhanVien, String hoVaTenDem, String chucVu, BigDecimal luong, String taiKhoan,
			String matKhau, Collection<ThuePhong> danhSachThuePhong, Collection<ChuyenPhong> danhSachChuyenPhong,
			Collection<TraPhong> danhSachTraPhong, Collection<ThueDichVu> danhSachThueDichVu) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoVaTenDem = hoVaTenDem;
		this.chucVu = chucVu;
		this.luong = luong;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.danhSachThuePhong = danhSachThuePhong;
		this.danhSachChuyenPhong = danhSachChuyenPhong;
		this.danhSachTraPhong = danhSachTraPhong;
		this.danhSachThueDichVu = danhSachThueDichVu;
	}

	public NhanVien() {
		super();
	}

}
