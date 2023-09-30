package pxu.com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pxu.com.model.ThuePhong;
import pxu.com.model.DichVu;
import pxu.com.model.NhanVien;
import pxu.com.model.Phong;
import pxu.com.service.DichVuService;
import pxu.com.service.RoomService;
import pxu.com.service.ThuePhongService;
import pxu.com.service.UserService;

@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService roomService;

	@Autowired
	private ThuePhongService thuePhongService;

	@Autowired
	private UserService userService;

	@Autowired
	private DichVuService dichVuService;

	@GetMapping("/login")
	public String login(Model model) {
		NhanVien nhanVien = new NhanVien();
		model.addAttribute("nhanVien", nhanVien);
		return "login";
	}

	@GetMapping("/listroom")
	public String listCustomers(Model theModel) {
		List<Phong> phongs = roomService.getRooms();
		theModel.addAttribute("rooms", phongs);
		return "homeee";
	}

	@PostMapping("/loginn")
	public String login(@RequestParam String taiKhoan, @RequestParam String matKhau, Model model, HttpSession session) {
		NhanVien nhanVien = userService.findBytaiKhoanAndPassword(taiKhoan);
		if (nhanVien != null && nhanVien.getMatKhau().equals(matKhau)) {
			session.setAttribute("loggedInUser", taiKhoan);
			session.setAttribute("fullName", nhanVien.getMaNhanVien());
			return "redirect:/room/listroom";
		} else {
			return "login";
		}
	}

	@GetMapping("/rooms")
	public String getPhieuThuePhongByRoomId(@RequestParam("roomId") Long roomId, Model model) {
		List<ThuePhong> phieuThuePhongList = thuePhongService.findAllByMaPhong(roomId);
		List<DichVu> dichVus = dichVuService.getDichVus();
		model.addAttribute("dichVus", dichVus);
		model.addAttribute("phieuThuePhongList", phieuThuePhongList);
		return "chitietthuephong";
	}

//	@GetMapping("/updatestartroom")
//	public String updatephong(@RequestParam("roomId") Long roomId, Model model) {
//		roomService.updattrangthaiphong(roomId);
//		return "redirect:/room/listroom";
//	}
//
//	@GetMapping("/updatecontrong")
//	public String updatecontrong(@RequestParam("roomId") Long roomId, Model model) {
//		roomService.updatecontrong(roomId);
//		return "redirect:/room/listroom";
//	}

//	@GetMapping("/updatedangsuachua")
//	public String updatedangsuachua(@RequestParam("roomId") Long roomId, Model model,
//			@RequestParam("idthue") Long idthue) {
//		roomService.updatesuachua(roomId);
//		phieuThuePhongService.updatetrangthaithue(idthue);
//		return "redirect:/room/listroom";
//	}

}