package pxu.com.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pxu.com.model.ThuePhong;
import pxu.com.model.TraPhong;
import pxu.com.repository.NhanVienRepository;
import pxu.com.model.DichVu;
import pxu.com.model.KhachHang;
import pxu.com.model.NhanVien;
import pxu.com.model.Phong;
import pxu.com.model.ThueDichVu;
import pxu.com.service.DichVuService;
import pxu.com.service.KhachHangService;
import pxu.com.service.NhanVienService;
import pxu.com.service.RoomService;
import pxu.com.service.ThueDichVuService;
import pxu.com.service.ThuePhongService;
import pxu.com.service.TraPhongService;
import pxu.com.service.NhanVienService;

@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService roomService;

	@Autowired
	private ThuePhongService thuePhongService;

	@Autowired
	private DichVuService dichVuService;

	@Autowired
	private ThueDichVuService thueDichVuService;

	@Autowired
	private NhanVienService nhanVienService;

	@Autowired
	private KhachHangService khachHangService;

	@Autowired
	private TraPhongService traPhongService;

	@GetMapping("/login")
	public String login(Model model) {
		NhanVien nhanVien = new NhanVien();
		model.addAttribute("nhanVien", nhanVien);
		return "login";
	}

	@GetMapping("/listroom")
	public String listCustomers(@RequestParam(name = "maPhong", required = false) Long maPhong, Model theModel) {
		List<Phong> phongs;
		if (maPhong != null) {
			Phong phong = roomService.findRoomByMaPhong(maPhong);
			if (phong != null) {
				phongs = Collections.singletonList(phong);
			} else {
				phongs = new ArrayList<>();
			}
		} else {
			phongs = roomService.getRooms();
		}
		long soPhongDangThue = roomService.countPhongDangThue();
		long soPhongTrong = roomService.countPhongTrong();
		theModel.addAttribute("rooms", phongs);
		theModel.addAttribute("soPhongDangThue", soPhongDangThue);
		theModel.addAttribute("soPhongTrong", soPhongTrong);
		return "homeee";
	}

//	@GetMapping("/searchRoomByMaPhong")
//	public String searchRoomByMaPhong(@RequestParam(name = "maPhong") Long maPhong, Model model) {
//		List<Phong> phongs = (List<Phong>) roomService.findRoomByMaPhong(maPhong);
//		model.addAttribute("rooms", phongs);
//		return "homeee";
//	}

//	@PostMapping("/loginn")
//	public String login(@RequestParam String taiKhoan, @RequestParam String matKhau, Model model, HttpSession session) {
//		NhanVien nhanVien = nhanVienService.findBytaiKhoanAndPassword(taiKhoan);
//		if (nhanVien != null && nhanVien.getMatKhau().equals(matKhau)) {
//			session.setAttribute("loggedInUser", taiKhoan);
//			session.setAttribute("fullName", nhanVien.getMaNhanVien());
//			session.setAttribute("namee", nhanVien.getHoVaTenDem());
//			session.setAttribute("image", nhanVien.getImage());
//			return "redirect:/room/listroom";
//		} else {
//			return "login";
//		}
//	}

	@PostMapping("/loginn")
	public String processLogin(@RequestParam String taiKhoan, @RequestParam String matKhau, Model model,
			HttpSession session) {
		NhanVien nhanVien = nhanVienService.findBytaiKhoanAndPassword(taiKhoan, matKhau);
		if (nhanVien == null) {
			KhachHang khachHang = khachHangService.findByTenDangNhapAndMatKhau(taiKhoan, matKhau);
			if (khachHang != null) {
				return "redirect:/dichvu/listDichVu";
			}
		} else {
			session.setAttribute("loggedInUser", taiKhoan);
			session.setAttribute("fullName", nhanVien.getMaNhanVien());
			session.setAttribute("namee", nhanVien.getHoVaTenDem());
			session.setAttribute("image", nhanVien.getImage());
			return "redirect:/room/listroom";
		}
		model.addAttribute("error", true);
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/room/login";
	}

	@GetMapping("/rooms")
	public String getPhieuThuePhongByRoomId(@RequestParam("roomId") Long roomId, Model model) {
		// Llay dan g sách dựa tren mã phòng
		List<ThuePhong> phieuThuePhongList = thuePhongService.findAllByMaPhong(roomId);

		// lay đanh sách dịch cụ
		List<DichVu> dichVus = dichVuService.getDichVus();
		model.addAttribute("dichVus", dichVus);

		// tru vấn thông tin thê dịch vụ dựa trên mã thuê phòng và thêm vào danh sách
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

	@PostMapping("/addtraphong")
	public String addtraphong(@ModelAttribute("traphong") TraPhong traPhong,
			@RequestParam("maThuePhong") Long maThuePhong, @RequestParam("maPhong") Long maPhong,
			@RequestParam("tongTien") BigDecimal tongTien, @RequestParam("maNhanVien") Long maNhanVien,
			@RequestParam("giaTien") BigDecimal giaTien, @RequestParam("tienDatCoc") BigDecimal tienDatCoc, Model model,
			RedirectAttributes redirectAttributes) {
		NhanVien nhanVien = nhanVienService.getNhanvienById(maNhanVien);
		ThuePhong thuePhong = thuePhongService.getThuePhong(maThuePhong);
		BigDecimal tongtienkhachhang = tongTien.add(giaTien).subtract(tienDatCoc);
		traPhong.setThuePhong(thuePhong);
		traPhong.setNhanVien(nhanVien);
		traPhong.setTongTien(tongtienkhachhang);
		traPhong.setNgayTraPhong(new Date());
		thuePhongService.updatethuephong(maThuePhong, tongtienkhachhang);
		traPhongService.traphong(traPhong);
		roomService.updatesuachua(maPhong);
		redirectAttributes.addFlashAttribute("paymentSuccessMessage", "Thanh toán thành công!");
		return "redirect:/room/listroom";
	}

//	@GetMapping("/deleteThueDichVu")
//	public String deleteDichVu(@RequestParam("thuedichvuID") Long id, @RequestParam("maPhong") Long maPhong) {
//		thueDichVuService.deleteThueDichVu(id);
//		return "redirect:/room/rooms?roomId=" + maPhong;
//	}

	@GetMapping("/updateThueDichVu")
	public String updateThueDichVu(@RequestParam("thuedichvuID") Long maThueDichVu,
			@RequestParam("maPhong") Long maPhong) {
		Optional<ThueDichVu> optionalThueDichVu = thueDichVuService.getThueDichVu(maThueDichVu);
		optionalThueDichVu.ifPresent(thueDichVu -> {
			int currentSoLuong = thueDichVu.getSoLuong();
			thueDichVu.setSoLuong(currentSoLuong + 1);
			BigDecimal gia = thueDichVu.getDichVu().getGia();
			BigDecimal thanhTien = gia.multiply(BigDecimal.valueOf(thueDichVu.getSoLuong()));
			thueDichVu.setThanhTien(thanhTien);
			thueDichVuService.updateThueDichVu(thueDichVu.getMaThueDichVu(), thueDichVu);
		});
		return "redirect:/room/rooms?roomId=" + maPhong;
	}

	@GetMapping("/deleteThueDichVu")
	public String deleteThueDichVu(@RequestParam("thuedichvuID") Long maThueDichVu,
			@RequestParam("maPhong") Long maPhong) {
		Optional<ThueDichVu> optionalThueDichVu = thueDichVuService.getThueDichVu(maThueDichVu);
		optionalThueDichVu.ifPresent(thueDichVu -> {
			int currentSoLuong = thueDichVu.getSoLuong();
			if (currentSoLuong > 0) {
				thueDichVu.setSoLuong(currentSoLuong - 1);
				if (currentSoLuong - 1 == 0) {
					thueDichVuService.deleteThueDichVu(thueDichVu.getMaThueDichVu());
				} else {
					BigDecimal gia = thueDichVu.getDichVu().getGia();
					BigDecimal thanhTien = gia.multiply(BigDecimal.valueOf(thueDichVu.getSoLuong()));
					thueDichVu.setThanhTien(thanhTien);
					thueDichVuService.updateThueDichVu(thueDichVu.getMaThueDichVu(), thueDichVu);
				}
			}
		});
		return "redirect:/room/rooms?roomId=" + maPhong;
	}

//	@GetMapping("/updatestartroom")
//	public String updatephong(@RequestParam("roomId") Long roomId, Model model) {
//		roomService.updattrangthaiphong(roomId);
//		return "redirect:/room/listroom";
//	}
//
	@GetMapping("/updatecontrong")
	public String updatecontrong(@RequestParam("maPhong") Long maPhong, Model model) {
		roomService.updatecontrong(maPhong);
		return "redirect:/room/listroom";
	}

	@GetMapping("/updatedangsuachua")
	public String updatedangsuachua(@RequestParam("maPhong") Long roomId, Model model) {
		roomService.updatedangsuachua(roomId);
		return "redirect:/room/listroom";
	}

}