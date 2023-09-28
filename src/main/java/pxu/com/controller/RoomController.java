package pxu.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pxu.com.exception.ResourceNotFoundException;
import pxu.com.model.PhieuThuePhong;
import pxu.com.model.Room;
import pxu.com.service.PhieuThuePhongService;
import pxu.com.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService roomService;

	@Autowired
	private PhieuThuePhongService phieuThuePhongService;

	@GetMapping("/listroom")
	public String listCustomers(Model theModel) {
		List<Room> rooms = roomService.getRooms();
		theModel.addAttribute("rooms", rooms);
		return "homeee";
	}

	@GetMapping("/rooms")
	public String getPhieuThuePhongByRoomId(@RequestParam("roomId") int roomId, Model model) {
		List<PhieuThuePhong> phieuThuePhongList = phieuThuePhongService.getPhieuThuePhongByRoomId(roomId);
		model.addAttribute("phieuThuePhongList", phieuThuePhongList);
		return "chitietthuephong";
	}

	@GetMapping("/updatestartroom")
	public String updatephong(@RequestParam("roomId") Integer roomId, Model model) {
		roomService.updattrangthaiphong(roomId);
		return "redirect:/room/listroom";
	}

	@GetMapping("/updatecontrong")
	public String updatecontrong(@RequestParam("roomId") Integer roomId, Model model) {
		roomService.updatecontrong(roomId);
		return "redirect:/room/listroom";
	}

	@GetMapping("/updatedangsuachua")
	public String updatedangsuachua(@RequestParam("roomId") Integer roomId, Model model,
			@RequestParam("idthue") Integer idthue) {
		roomService.updatesuachua(roomId);
		phieuThuePhongService.updatetrangthaithue(idthue);
		return "redirect:/room/listroom";
	}

}