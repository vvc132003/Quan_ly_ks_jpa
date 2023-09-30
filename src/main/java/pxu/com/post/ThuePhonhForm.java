package pxu.com.post;

import pxu.com.model.KhachHang;
import pxu.com.model.NhanPhong;
import pxu.com.model.NhanVien;
import pxu.com.model.Phong;
import pxu.com.model.ThuePhong;

public class ThuePhonhForm {

	private KhachHang khachHang;
	private Phong phong;
	private ThuePhong thuePhong;
	private NhanPhong nhanPhong;
	private NhanVien nhanVien;
	
	

	public ThuePhonhForm(KhachHang khachHang, Phong phong, ThuePhong thuePhong, NhanPhong nhanPhong,
			NhanVien nhanVien) {
		super();
		this.khachHang = khachHang;
		this.phong = phong;
		this.thuePhong = thuePhong;
		this.nhanPhong = nhanPhong;
		this.nhanVien = nhanVien;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}



	public NhanPhong getNhanPhong() {
		return nhanPhong;
	}

	public void setNhanPhong(NhanPhong nhanPhong) {
		this.nhanPhong = nhanPhong;
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

	public ThuePhong getThuePhong() {
		return thuePhong;
	}

	public void setThuePhong(ThuePhong thuePhong) {
		this.thuePhong = thuePhong;
	}

	public ThuePhonhForm() {
		super();
	}

}
