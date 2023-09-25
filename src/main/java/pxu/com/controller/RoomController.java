package pxu.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pxu.com.model.Room;
import pxu.com.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService roomService;

	@GetMapping("/listroom")
	public String listCustomers(Model theModel) {
		List<Room> rooms = roomService.getRooms();
		theModel.addAttribute("rooms", rooms);
		return "homeee";
	}
}
