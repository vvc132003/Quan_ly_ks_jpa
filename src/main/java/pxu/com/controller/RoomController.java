package pxu.com.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pxu.com.model.ThuePhong;
import pxu.com.model.DichVu;
import pxu.com.model.NhanVien;
import pxu.com.model.Phong;
import pxu.com.model.ThueDichVu;
import pxu.com.service.DichVuService;
import pxu.com.service.NhanVienService;
import pxu.com.service.RoomService;
import pxu.com.service.ThueDichVuService;
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

	@Autowired
	private ThueDichVuService thueDichVuService;

	@Autowired
	private NhanVienService nhanVienService;

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
		// Lấy danh sách thuê phòng dựa trên mã phòng
		List<ThuePhong> phieuThuePhongList = thuePhongService.findAllByMaPhong(roomId);

		// Lấy danh sách dịch vụ
		List<DichVu> dichVus = dichVuService.getDichVus();
		model.addAttribute("dichVus", dichVus);

		// Truy vấn thông tin thuê dịch vụ dựa trên mã thuê phòng và thêm vào danh sách
		// thuê phòng
		for (ThuePhong thuePhong : phieuThuePhongList) {
			Long maThuePhong = thuePhong.getMaThuePhong();
			List<ThueDichVu> thueDichVus = thueDichVuService.getThueDichVusByMaThuePhong(maThuePhong);
			thuePhong.setDanhSachThueDichVu(thueDichVus);
			BigDecimal totalCost = thueDichVuService.calculateTotalCostByMaThuePhong(maThuePhong);
			model.addAttribute("thueDichVus", thueDichVus);
			model.addAttribute("totalCost", totalCost);
		}

		model.addAttribute("phieuThuePhongList", phieuThuePhongList);
		return "chitietthuephong";
	}

	@GetMapping("/listThueDichVu")
	public String listThueDichVu(Model model) {
		List<ThueDichVu> thueDichVus = thueDichVuService.getThueDichVu();
		model.addAttribute("thueDichVus", thueDichVus);
		return "list_thuedichvu";
	}

	@PostMapping("/addThueDichVu")
	public String addDichVu(@ModelAttribute("thueDichVu") ThueDichVu thueDichVu,
			@RequestParam("maDichVu") Long maDichVu, @RequestParam("maThuePhong") Long maThuePhong,
			@RequestParam("maPhong") Long maPhong, @RequestParam("maNhanVien") Long maNhanVien) {
		ThuePhong thuePhong = thuePhongService.getThuePhong(maThuePhong);
		DichVu dichVu = dichVuService.getDichVuById(maDichVu);
		NhanVien nhanVien = nhanVienService.getNhanvienById(maNhanVien);
		thueDichVu.setThuePhong(thuePhong);
		thueDichVu.setDichVu(dichVu);
		thueDichVu.setNhanVien(nhanVien);
		thueDichVu.setSoLuong(1);
		/// tính ttieenf
		BigDecimal soLuong = BigDecimal.valueOf(thueDichVu.getSoLuong());
		BigDecimal gia = dichVu.getGia();
		BigDecimal thanhTien = soLuong.multiply(gia);
		thueDichVu.setThanhTien(thanhTien);
		thueDichVuService.saveThueDichVu(thueDichVu);
		return "redirect:/room/rooms?roomId=" + maPhong;
	}

	@GetMapping("/deleteThueDichVu")
	public String deleteDichVu(@RequestParam("thuedichvuID") Long id, @RequestParam("maPhong") Long maPhong) {
		thueDichVuService.deleteThueDichVu(id);
		return "redirect:/room/rooms?roomId=" + maPhong;
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