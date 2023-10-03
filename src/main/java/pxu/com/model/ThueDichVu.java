package pxu.com.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "thuedichvu")
public class ThueDichVu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaThueDichVu")
	private Long maThueDichVu;

	@ManyToOne
	@JoinColumn(name = "MaThuePhong")
	private ThuePhong thuePhong;

	@ManyToOne
	@JoinColumn(name = "MaDichVu")
	private DichVu dichVu;

	@ManyToOne
	@JoinColumn(name = "MaNhanVien")
	private NhanVien nhanVien;

	@Column(name = "SoLuong")
	private int soLuong;

	@Column(name = "ThanhTien")
	private BigDecimal thanhTien;

	public BigDecimal getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(BigDecimal thanhTien) {
		this.thanhTien = thanhTien;
	}

	public Long getMaThueDichVu() {
		return maThueDichVu;
	}

	public void setMaThueDichVu(Long maThueDichVu) {
		this.maThueDichVu = maThueDichVu;
	}

	public ThuePhong getThuePhong() {
		return thuePhong;
	}

	public void setThuePhong(ThuePhong thuePhong) {
		this.thuePhong = thuePhong;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public ThueDichVu(Long maThueDichVu, ThuePhong thuePhong, DichVu dichVu, NhanVien nhanVien, int soLuong,
			BigDecimal thanhTien) {
		super();
		this.maThueDichVu = maThueDichVu;
		this.thuePhong = thuePhong;
		this.dichVu = dichVu;
		this.nhanVien = nhanVien;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	public ThueDichVu() {
		super();
	}

	public BigDecimal calculateTotalCost() {
		return thanhTien.multiply(BigDecimal.valueOf(soLuong));
	}

}