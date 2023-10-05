package pxu.com.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pxu.com.model.DichVu;
import pxu.com.model.KhachHang;
import pxu.com.model.NhanPhong;
import pxu.com.model.NhanVien;
import pxu.com.model.Phong;
import pxu.com.model.ThueDichVu;
import pxu.com.model.ThuePhong;
import pxu.com.service.KhachHangService;
import pxu.com.service.NhanPhongService;
import pxu.com.service.RoomService;
import pxu.com.service.ThueDichVuService;
import pxu.com.service.ThuePhongService;

@Controller
@RequestMapping("/thuephong")
public class ThuePhongController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private ThuePhongService thuePhongService;

	@Autowired
	private ThueDichVuService thueDichVuService;

	@Autowired
	private NhanPhongService nhanPhongService;

	@Autowired
	private KhachHangService khachHangService;

	@GetMapping("/thuephong")
	public String thuePhongForm(@RequestParam("idPhong") Long idPhong, Model model) {
		Optional<Phong> phongOptional = roomService.getphong(idPhong);
		if (phongOptional.isPresent()) {
			Phong phong = phongOptional.get();
			ThuePhong thuePhong = new ThuePhong();
			thuePhong.setPhong(phong);
			model.addAttribute("thuePhong", thuePhong);
		}
		return "thuephong_form";
	}

	@GetMapping("/datphong")
	public String datphong(@RequestParam("idPhong") Long idPhong, Model model) {
		Optional<Phong> phongOptional = roomService.getphong(idPhong);
		if (phongOptional.isPresent()) {
			Phong phong = phongOptional.get();
			ThuePhong thuePhong = new ThuePhong();
			thuePhong.setPhong(phong);
			model.addAttribute("thuePhong", thuePhong);
		}
		return "datphong";
	}

	@GetMapping("/thongtinndatphong")
	public String getPhieuThuePhongByRoomId(@RequestParam("roomId") Long roomId, Model model) {
		// Retrieve room reservation data by roomId
		List<ThuePhong> thuePhongList = thuePhongService.findAllByMaPhongAndTrangThaiDadat(roomId);
		for (ThuePhong thuePhong : thuePhongList) {
			KhachHang khachHang = khachHangService.getKhachHangByMaKhachHang(thuePhong.getKhachHang().getMaKhachHang());
			Phong phong = roomService.getPhongByMaPhong(thuePhong.getPhong().getMaPhong());
			thuePhong.setKhachHang(khachHang);
			thuePhong.setPhong(phong);
		}
		model.addAttribute("thuePhongList", thuePhongList);
		return "nhanphong";
	}

//	@PostMapping("/addthuephong")
//	public String luuThuePhong(@ModelAttribute("thuePhong") ThuePhong thuePhong,
//			@RequestParam("phong.maPhong") Long maPhong, Model model) {
//		thuePhong.setNgayNhanPhong(new Date());
////		thuePhong.setNgayTraPhong(new Date());
//		LocalDateTime now = LocalDateTime.now();
//		LocalDateTime ngayTraPhong = now.plus(1, ChronoUnit.HOURS);
//		Date dateNgayTraPhong = java.sql.Timestamp.valueOf(ngayTraPhong);
//		thuePhong.setNgayTraPhong(dateNgayTraPhong);
//		thuePhong.setTrangThai("Đang thuê");
//		BigDecimal tongtiennn = new BigDecimal("0");
//		thuePhong.setTongTien(tongtiennn);
//		thuePhongService.thuePhong(thuePhong);
////		thuePhongService.sendEmails();
//		roomService.updattrangthaiphong(maPhong);
//		return "redirect:/room/listroom";
//	}

	@PostMapping("/addthuephong")
	public String savethuephong(@ModelAttribute("thuePhong") ThuePhong thuePhong, NhanPhong nhanPhong,
			@RequestParam("phong.maPhong") Long maPhong, Model model, RedirectAttributes redirectAttributes) {
		KhachHang khachHang = khachHangService.savekhachhang1(thuePhong.getKhachHang());
		// Lấy mã khách hàng sau khi tạo
		Long maKhachHang = khachHang.getMaKhachHang();
		// Gán mã khách hàng vào đối tượng ThuePhong
		thuePhong.getKhachHang().setMaKhachHang(maKhachHang);
		thuePhong.setNgayNhanPhong(new Date());
//		thuePhong.setNgayTraPhong(new Date());
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime ngayTraPhong = now.plus(1, ChronoUnit.HOURS);
		Date dateNgayTraPhong = java.sql.Timestamp.valueOf(ngayTraPhong);
		thuePhong.setNgayTraPhong(dateNgayTraPhong);
		thuePhong.setTrangThai("Đang thuê");
		BigDecimal tongtiennn = new BigDecimal("0");
		thuePhong.setTongTien(tongtiennn);
		thuePhongService.thuePhong(thuePhong);
//		thuePhongService.sendEmails();
		nhanPhong.setThuePhong(thuePhong);
		nhanPhong.setNgayNhanPhong(new Date());
		nhanPhongService.nhanPhong(nhanPhong);
		roomService.updattrangthaiphong(maPhong);
		redirectAttributes.addFlashAttribute("thuephongSuccessMessage", "Thuê phòng thành công!");
		return "redirect:/room/listroom";
	}

	@PostMapping("/adddatphongphong")
	public String adddatphongphong(@ModelAttribute("thuePhong") ThuePhong thuePhong,
			@RequestParam("phong.maPhong") Long maPhong, Model model, RedirectAttributes redirectAttributes) {
		KhachHang khachHang = khachHangService.savekhachhang1(thuePhong.getKhachHang());
		// Lấy mã khách hàng sau khi tạo
		Long maKhachHang = khachHang.getMaKhachHang();
		// Gán mã khách hàng vào đối tượng ThuePhong
		thuePhong.getKhachHang().setMaKhachHang(maKhachHang);
		thuePhong.setNgayNhanPhong(new Date());
//		thuePhong.setNgayTraPhong(new Date());
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime ngayTraPhong = now.plus(1, ChronoUnit.HOURS);
		Date dateNgayTraPhong = java.sql.Timestamp.valueOf(ngayTraPhong);
		thuePhong.setNgayTraPhong(dateNgayTraPhong);
		thuePhong.setTrangThai("Đã đặt");
		BigDecimal tongtiennn = new BigDecimal("0");
		thuePhong.setTongTien(tongtiennn);
		thuePhongService.thuePhong(thuePhong);
//		thuePhongService.sendEmails();
		roomService.updatedadat(maPhong);
		redirectAttributes.addFlashAttribute("thuephongSuccessMessage", "Thuê phòng thành công!");
		return "redirect:/room/home";
	}

	@GetMapping("/listthuephong")
	public String listthuephong(Model model) {
		List<ThuePhong> thuePhongs = thuePhongService.findAllThuePhongOrderByMaThuePhongDesc();
		model.addAttribute("thuePhongs", thuePhongs);
		return "list_thuephong";
	}

	@GetMapping("/thong-ke-theo-thang")
	public String thongKeDoanhThuTheoThang(Model model) {
		List<Object[]> data = thuePhongService.thongKeDoanhThuTheoThang();
		List<Object[]> result = thueDichVuService.findTotalRevenueByService();
		model.addAttribute("maDichVu", result);
		model.addAttribute("tongThanhTien", result);
		model.addAttribute("data", data);
		return "thongke";
	}

	@GetMapping("listthuedichvu")
	public String listthuedichvu(@RequestParam("maThuePhong") Long maThuePhong, Model model) {
		List<ThueDichVu> thueDichVus = thueDichVuService.getThueDichVusByMaThuePhong(maThuePhong);
		model.addAttribute("thueDichVus", thueDichVus);
		return "list_thuedichvu";
	}

	// Phương thức này chuyển đổi dữ liệu doanh thu thành JSON để sử dụng trong JSP
	/*
	 * private String convertDataToJson(List<Object[]> data) { StringBuilder json =
	 * new StringBuilder("["); for (Object[] item : data) {
	 * json.append("['").append(item[0]).append("', ").append(item[1]).append("], "
	 * ); } if (data.size() > 0) { json.delete(json.length() - 2, json.length()); }
	 * json.append("]"); return json.toString(); }
	 */
}