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
import pxu.com.service.NhanVienService;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
	@Autowired
	private NhanVienService nhanVienService;

	@GetMapping("/listnhanvien")
	public String listnhanvien(Model model) {
		List<NhanVien> nhanViens = nhanVienService.getNhanvien();
		model.addAttribute("nhanViens", nhanViens);
		return "list_nhanvien";
	}

//	@GetMapping("/khachhangform")
//	public String khachhangform(Model model) {
//		KhachHang khachHang = new KhachHang();
//		model.addAttribute("khachHang", khachHang);
//		return "nhanvien_form";
//	}

//	@PostMapping("/addnhanvien")
//	public String addkhachhang(@ModelAttribute("khachHang") KhachHang khachHang) {
//		khachHangService.savekhachhang(khachHang);
//		return "redirect:/khachhang/listkhachhang";
//	}
//
//	@GetMapping("/deletenhanvien")
//	public String deleteDichVu(@RequestParam("nhanvienid") Long id) {
//		khachHangService.deletekhachhang(id);
//		return "redirect:/nhanvien/listnhanvien";
//	}

}
