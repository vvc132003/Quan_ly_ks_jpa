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
@Table(name = "dichvu")
public class DichVu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaDichVu")
	private Long maDichVu;

	@Column(name = "TenDichVu")
	private String tenDichVu;

	@Column(name = "MoTa")
	private String moTa;

	@Column(name = "Gia")
	private BigDecimal gia;
	
	@Column(name = "Image")
	private String image;

	@OneToMany(mappedBy = "dichVu")
	private Collection<ThueDichVu> danhSachThueDichVu;

	public Long getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(Long maDichVu) {
		this.maDichVu = maDichVu;
	}

	public String getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public BigDecimal getGia() {
		return gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	public Collection<ThueDichVu> getDanhSachThueDichVu() {
		return danhSachThueDichVu;
	}

	public void setDanhSachThueDichVu(Collection<ThueDichVu> danhSachThueDichVu) {
		this.danhSachThueDichVu = danhSachThueDichVu;
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public DichVu(Long maDichVu, String tenDichVu, String moTa, BigDecimal gia, String image,
			Collection<ThueDichVu> danhSachThueDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.moTa = moTa;
		this.gia = gia;
		this.image = image;
		this.danhSachThueDichVu = danhSachThueDichVu;
	}

	public DichVu() {
		super();
	}

	// Constructors, getters, setters

}
