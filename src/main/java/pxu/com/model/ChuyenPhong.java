package pxu.com.model;

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
@Table(name = "chuyenphong")
public class ChuyenPhong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaChuyenPhong")
	private Long maChuyenPhong;

	@ManyToOne
	@JoinColumn(name = "MaThuePhong")
	private ThuePhong thuePhong;

	@ManyToOne
	@JoinColumn(name = "MaPhongMoi")
	private Phong phongMoi;

	@Column(name = "NgayChuyenPhong")
	private Date ngayChuyenPhong;

	@ManyToOne
	@JoinColumn(name = "MaNhanVien")
	private NhanVien nhanVien;

	public Long getMaChuyenPhong() {
		return maChuyenPhong;
	}

	public void setMaChuyenPhong(Long maChuyenPhong) {
		this.maChuyenPhong = maChuyenPhong;
	}

	public ThuePhong getThuePhong() {
		return thuePhong;
	}

	public void setThuePhong(ThuePhong thuePhong) {
		this.thuePhong = thuePhong;
	}

	public Phong getPhongMoi() {
		return phongMoi;
	}

	public void setPhongMoi(Phong phongMoi) {
		this.phongMoi = phongMoi;
	}

	public Date getNgayChuyenPhong() {
		return ngayChuyenPhong;
	}

	public void setNgayChuyenPhong(Date ngayChuyenPhong) {
		this.ngayChuyenPhong = ngayChuyenPhong;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public ChuyenPhong(Long maChuyenPhong, ThuePhong thuePhong, Phong phongMoi, Date ngayChuyenPhong,
			NhanVien nhanVien) {
		super();
		this.maChuyenPhong = maChuyenPhong;
		this.thuePhong = thuePhong;
		this.phongMoi = phongMoi;
		this.ngayChuyenPhong = ngayChuyenPhong;
		this.nhanVien = nhanVien;
	}

	public ChuyenPhong() {
		super();
	}

	// Constructors, getters, setters

}