package pxu.com.controller;

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
import pxu.com.service.DichVuService;
import pxu.com.service.KhachHangService;

@Controller
@RequestMapping("/khachhang")
public class KhachHangController {
	@Autowired
	private KhachHangService khachHangService;

	@GetMapping("/listkhachhang")
	public String listkhachhang(Model model) {
		List<KhachHang> khachHangs = khachHangService.getkhachhang();
		model.addAttribute("khachHangs", khachHangs);
		return "list_khachhang";
	}

	@GetMapping("/khachhangform")
	public String khachhangform(Model model) {
		KhachHang khachHang = new KhachHang();
		model.addAttribute("khachHang", khachHang);
		return "khachhang_form";
	}

	@PostMapping("/addkhachhang")
	public String addkhachhang(@ModelAttribute("khachHang") KhachHang khachHang) {
		khachHangService.savekhachhang(khachHang);
		return "redirect:/khachhang/listkhachhang";
	}

	@GetMapping("/deletekhachhang")
	public String deleteDichVu(@RequestParam("khachhangid") Long id) {
		khachHangService.deletekhachhang(id);
		return "redirect:/khachhang/listkhachhang";
	}

}