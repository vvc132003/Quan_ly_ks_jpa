package pxu.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pxu.com.model.TraPhong;
import pxu.com.service.TraPhongService;

@Controller
@RequestMapping("/traphong")
public class TraPhongController {

	@Autowired
	TraPhongService traPhongService;

	@GetMapping("listtraphong")
	public String listtraphong(Model model) {
		List<TraPhong> traPhongs = traPhongService.findAllOrderByMmTraPhongDesc();
		model.addAttribute("traPhongs", traPhongs);
		return "list_traphong";
	}

}
