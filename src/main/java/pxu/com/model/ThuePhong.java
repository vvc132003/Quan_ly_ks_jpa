package pxu.com.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "thuephong")
public class ThuePhong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaThuePhong")
	private Long maThuePhong;

	@ManyToOne
	@JoinColumn(name = "MaKhachHang")
	private KhachHang khachHang;

	@ManyToOne
	@JoinColumn(name = "MaPhong")
	private Phong phong;

	@Column(name = "NgayNhanPhong")
	private Date ngayNhanPhong;

	@Column(name = "NgayTraPhong")
	private Date ngayTraPhong;

	@Column(name = "TongTien")
	private BigDecimal tongTien;
	
	@Column(name = "TrangThai")
	private String trangThai;
	
	@Column(name = "TienDatCoc")
	private BigDecimal tienDatCoc;

	// Một giao dịch thuê phòng có nhiều dịch vụ
	@OneToMany(mappedBy = "thuePhong")
	private Collection<ThueDichVu> danhSachThueDichVu;

	@ManyToOne
	@JoinColumn(name = "MaNhanVien")
	private NhanVien nhanVien;

	
	
	
	public ThuePhong(Long maThuePhong, KhachHang khachHang, Phong phong, Date ngayNhanPhong, Date ngayTraPhong,
			BigDecimal tongTien, String trangThai, BigDecimal tienDatCoc, Collection<ThueDichVu> danhSachThueDichVu,
			NhanVien nhanVien) {
		super();
		this.maThuePhong = maThuePhong;
		this.khachHang = khachHang;
		this.phong = phong;
		this.ngayNhanPhong = ngayNhanPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
		this.tienDatCoc = tienDatCoc;
		this.danhSachThueDichVu = danhSachThueDichVu;
		this.nhanVien = nhanVien;
	}

	public BigDecimal getTienDatCoc() {
		return tienDatCoc;
	}

	public void setTienDatCoc(BigDecimal tienDatCoc) {
		this.tienDatCoc = tienDatCoc;
	}

	public Long getMaThuePhong() {
		return maThuePhong;
	}

	public void setMaThuePhong(Long maThuePhong) {
		this.maThuePhong = maThuePhong;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public Date getNgayNhanPhong() {
		return ngayNhanPhong;
	}

	public void setNgayNhanPhong(Date ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
	}

	public Date getNgayTraPhong() {
		return ngayTraPhong;
	}

	public void setNgayTraPhong(Date ngayTraPhong) {
		this.ngayTraPhong = ngayTraPhong;
	}

	public BigDecimal getTongTien() {
		return tongTien;
	}

	public void setTongTien(BigDecimal tongTien) {
		this.tongTien = tongTien;
	}

	public Collection<ThueDichVu> getDanhSachThueDichVu() {
		return danhSachThueDichVu;
	}

	public void setDanhSachThueDichVu(Collection<ThueDichVu> danhSachThueDichVu) {
		this.danhSachThueDichVu = danhSachThueDichVu;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	

	public ThuePhong() {
		super();
	}


}