package pxu.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pxu.com.model.NhanPhong;
import pxu.com.service.NhanPhongService;

@Controller
@RequestMapping("/nhanphong")
public class NhanPhongController {
	@Autowired
	private NhanPhongService nhanPhongService;

	@GetMapping("listnhanphong")
	public String listnhanphong(Model model) {
		List<NhanPhong> nhanPhongs = nhanPhongService.getNhanPhong();
		model.addAttribute("nhanPhongs", nhanPhongs);
		return "list_nhanphong";
	}
}
