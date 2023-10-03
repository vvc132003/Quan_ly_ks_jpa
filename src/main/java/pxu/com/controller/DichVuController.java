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
import pxu.com.service.DichVuService;

@Controller
@RequestMapping("/dichvu")
public class DichVuController {
	@Autowired
	private DichVuService dichVuService;

	@GetMapping("/listDichVu")
	public String listkhoahoc(Model model) {
		List<DichVu> dichVus = dichVuService.getDichVus();
		model.addAttribute("dichVus", dichVus);
		return "list_dichvu";
	}

	@GetMapping("/dichvuform")
	public String login(Model model) {
		DichVu dichVu = new DichVu();
		model.addAttribute("dichVu", dichVu);
		return "dichvu_form";
	}

	@PostMapping(value = "/addDichVu", produces = "text/plain;charset=UTF-8")
	public String addDichVu(@ModelAttribute("dichVu") DichVu dichVu) {
		dichVuService.saveDichVu(dichVu);
		return "redirect:/dichvu/listDichVu";
	}

	@GetMapping("/deleteDichVu")
	public String deleteDichVu(@RequestParam("dichvuID") Long id) {
		dichVuService.deleteDichVu(id);
		return "redirect:/dichvu/listDichVu";
	}

	@GetMapping("/updateDichVu")
	public String updateDichVu(@RequestParam("dichvuID") Long id, Model theModel) {
		Optional<DichVu> dichvuOptional = dichVuService.getDichVu(id);
		theModel.addAttribute("dichvuOptional", dichvuOptional);
		return "update_dichvu";
	}

	@PostMapping("/editkhoahoc")
	public String updateProduct(@ModelAttribute("maDichVu") DichVu dichVu) {
		dichVuService.updateDichVu(dichVu.getMaDichVu(), dichVu);
		return "redirect:/dichvu/listDichVu";
	}

//	@GetMapping("/thongke")
//    public String thongKe(Model model) {
//        List<Object[]> thongKeData = dichVuService.thongKeDichVuDuocThueNhieuNhat();
//        model.addAttribute("thongKeData", thongKeData);
//        return "thongke"; // Tên trang JSP
//    }

}