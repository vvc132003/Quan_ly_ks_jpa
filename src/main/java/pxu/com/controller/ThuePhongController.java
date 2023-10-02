package pxu.com.controller;

import java.math.BigDecimal;
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

import pxu.com.model.DichVu;
import pxu.com.model.KhachHang;
import pxu.com.model.NhanVien;
import pxu.com.model.Phong;
import pxu.com.model.ThuePhong;
import pxu.com.post.ThuePhonhForm;
import pxu.com.service.KhachHangService;
import pxu.com.service.RoomService;
import pxu.com.service.ThuePhongService;

@Controller
@RequestMapping("/thuephong")
public class ThuePhongController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private ThuePhongService thuePhongService;

	@Autowired
	private KhachHangService khachHangService;

	@GetMapping("/thuephong")
	public String thuePhongForm(@RequestParam("idPhong") Long idPhong, Model model) {
		Optional<Phong> phongOptional = roomService.getphong(idPhong);
		List<KhachHang> listHangs = khachHangService.getkhachhang();
		if (phongOptional.isPresent()) {
			Phong phong = phongOptional.get();
			ThuePhong thuePhong = new ThuePhong();
			thuePhong.setPhong(phong);
			model.addAttribute("thuePhong", thuePhong);
			model.addAttribute("listHangs", listHangs);
		}
		return "thuephong_form";
	}

	@PostMapping("/addthuephong")
	public String luuThuePhong(@ModelAttribute("thuePhong") ThuePhong thuePhong,
			@RequestParam("phong.maPhong") Long maPhong, Model model) {
		thuePhong.setNgayNhanPhong(new Date());
		thuePhong.setNgayTraPhong(new Date());
		thuePhong.setTrangThai("Đang thuê");
		BigDecimal tongtiennn = new BigDecimal("0");
		thuePhong.setTongTien(tongtiennn);
		thuePhongService.thuePhong(thuePhong);
//		thuePhongService.sendEmails();
		roomService.updattrangthaiphong(maPhong);
		return "redirect:/room/listroom";
	}
}
