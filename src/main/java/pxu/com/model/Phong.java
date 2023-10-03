package pxu.com.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "phong")
public class Phong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaPhong")
	private Long maPhong;

	@Column(name = "SoPhong")
	private String soPhong;

	@Column(name = "LoaiPhong")
	private String loaiPhong;

	@Column(name = "TinhTrangPhong")
	private String tinhTrangPhong;

	@Column(name = "GiaTien")
	private BigDecimal giaTien;

	// Một phòng có nhiều giao dịch thuê phòng
	@OneToMany(mappedBy = "phong")
	private Collection<ThuePhong> danhSachThuePhong;
	
	
	@OneToMany(mappedBy = "phongMoi")
	private Collection<ChuyenPhong> danhSachChuyenPhong;


	public Long getMaPhong() {
		return maPhong;
	}


	public void setMaPhong(Long maPhong) {
		this.maPhong = maPhong;
	}


	public String getSoPhong() {
		return soPhong;
	}


	public void setSoPhong(String soPhong) {
		this.soPhong = soPhong;
	}


	public String getLoaiPhong() {
		return loaiPhong;
	}


	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}


	public String getTinhTrangPhong() {
		return tinhTrangPhong;
	}


	public void setTinhTrangPhong(String tinhTrangPhong) {
		this.tinhTrangPhong = tinhTrangPhong;
	}


	public BigDecimal getGiaTien() {
		return giaTien;
	}


	public void setGiaTien(BigDecimal giaTien) {
		this.giaTien = giaTien;
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


	public Phong(Long maPhong, String soPhong, String loaiPhong, String tinhTrangPhong, BigDecimal giaTien,
			Collection<ThuePhong> danhSachThuePhong, Collection<ChuyenPhong> danhSachChuyenPhong) {
		super();
		this.maPhong = maPhong;
		this.soPhong = soPhong;
		this.loaiPhong = loaiPhong;
		this.tinhTrangPhong = tinhTrangPhong;
		this.giaTien = giaTien;
		this.danhSachThuePhong = danhSachThuePhong;
		this.danhSachChuyenPhong = danhSachChuyenPhong;
	}


	public Phong() {
		super();
	}
	
}