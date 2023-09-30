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
import pxu.com.model.NhanVien;
import pxu.com.model.ThueDichVu;
import pxu.com.service.DichVuService;
import pxu.com.service.ThueDichVuService;

@Controller
@RequestMapping("/thuedichvu")
public class ThueDichVuController {
	@Autowired
	private ThueDichVuService thueDichVuService;

	@GetMapping("/listThueDichVu")
	public String listThueDichVu(Model model) {
		List<ThueDichVu> thueDichVus = thueDichVuService.getThueDichVu();
		model.addAttribute("thueDichVus", thueDichVus);
		return "list_thuedichvu";
	}

	@PostMapping("/addThueDichVu")
	public String addDichVu(@ModelAttribute("dichVu") ThueDichVu thueDichVu) {
		thueDichVuService.saveThueDichVu(thueDichVu);
		return "redirect:/thuedichvu/listThueDichVu";
	}

//	@GetMapping("/deleteDichVu")
//	public String deleteDichVu(@RequestParam("dichvuID") Long id) {
//		dichVuService.deleteDichVu(id);
//		return "redirect:/dichvu/listDichVu";
//	}
}
