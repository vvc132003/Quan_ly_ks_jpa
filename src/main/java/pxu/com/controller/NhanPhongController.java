package pxu.com.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pxu.com.model.KhachHang;
import pxu.com.model.NhanPhong;
import pxu.com.model.ThuePhong;
import pxu.com.service.KhachHangService;
import pxu.com.service.NhanPhongService;
import pxu.com.service.RoomService;
import pxu.com.service.ThuePhongService;

@Controller
@RequestMapping("/nhanphong")
public class NhanPhongController {
	@Autowired
	private NhanPhongService nhanPhongService;

	@Autowired
	private ThuePhongService thuePhongService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private KhachHangService khachHangService;

	@GetMapping("listnhanphong")
	public String listnhanphong(Model model) {
		List<NhanPhong> nhanPhongs = nhanPhongService.getNhanPhong();
		model.addAttribute("nhanPhongs", nhanPhongs);
		return "list_nhanphong";
	}

	@PostMapping("/addnhanphong")
	public String addnhanphong(@ModelAttribute("thuePhong") ThuePhong thuePhong, @RequestParam("maPhong") Long maPhong,
			@RequestParam("maThuePhong") Long maThuePhong, @RequestParam("cccd") String cccd, Model model,
			NhanPhong nhanPhong, RedirectAttributes redirectAttributes) {
		KhachHang khachHang = khachHangService.findByCccd(cccd);
		if (khachHang != null) {
			thuePhongService.updateTrangThai(maThuePhong);
			roomService.updattrangthaiphong(maPhong);
			nhanPhong.setThuePhong(thuePhong);
			nhanPhong.setNgayNhanPhong(new Date());
			nhanPhongService.nhanPhong(nhanPhong);
			redirectAttributes.addFlashAttribute("thuephongSuccessMessage", "Thuê phòng thành công!");
			return "redirect:/room/listroom";
		} else {
			redirectAttributes.addFlashAttribute("thuephongErrorMessage", "CCCD không hợp lệ. Vui lòng kiểm tra lại!");
			return "redirect:/thuephong/thongtinndatphong?roomId=" + maPhong;
		}
	}

}
