package pxu.com.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "traphong")
public class TraPhong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaTraPhong")
	private Long maTraPhong;

	@ManyToOne
	@JoinColumn(name = "MaThuePhong")
	private ThuePhong thuePhong;

	@Column(name = "NgayTraPhong")
	private Date ngayTraPhong;

	@Column(name = "TongTien")
	private BigDecimal tongTien;

	@ManyToOne
	@JoinColumn(name = "MaNhanVien")
	private NhanVien nhanVien;

	public Long getMaTraPhong() {
		return maTraPhong;
	}

	public void setMaTraPhong(Long maTraPhong) {
		this.maTraPhong = maTraPhong;
	}

	public ThuePhong getThuePhong() {
		return thuePhong;
	}

	public void setThuePhong(ThuePhong thuePhong) {
		this.thuePhong = thuePhong;
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

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public TraPhong(Long maTraPhong, ThuePhong thuePhong, Date ngayTraPhong, BigDecimal tongTien, NhanVien nhanVien) {
		super();
		this.maTraPhong = maTraPhong;
		this.thuePhong = thuePhong;
		this.ngayTraPhong = ngayTraPhong;
		this.tongTien = tongTien;
		this.nhanVien = nhanVien;
	}

	public TraPhong() {
		super();
	}

}
