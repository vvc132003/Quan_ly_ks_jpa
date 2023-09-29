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
@Table(name = "nhanphong")
public class NhanPhong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaNhanPhong")
	private Long maNhanPhong;

	@ManyToOne
	@JoinColumn(name = "MaThuePhong")
	private ThuePhong thuePhong;

	@Column(name = "NgayNhanPhong")
	private Date ngayNhanPhong;

	public Long getMaNhanPhong() {
		return maNhanPhong;
	}

	public void setMaNhanPhong(Long maNhanPhong) {
		this.maNhanPhong = maNhanPhong;
	}

	public ThuePhong getThuePhong() {
		return thuePhong;
	}

	public void setThuePhong(ThuePhong thuePhong) {
		this.thuePhong = thuePhong;
	}

	public Date getNgayNhanPhong() {
		return ngayNhanPhong;
	}

	public void setNgayNhanPhong(Date ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
	}

	public NhanPhong(Long maNhanPhong, ThuePhong thuePhong, Date ngayNhanPhong) {
		super();
		this.maNhanPhong = maNhanPhong;
		this.thuePhong = thuePhong;
		this.ngayNhanPhong = ngayNhanPhong;
	}

	public NhanPhong() {
		super();
	}

	// Constructors, getters, setters

}
