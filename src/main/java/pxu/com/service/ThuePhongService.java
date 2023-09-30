package pxu.com.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pxu.com.model.DichVu;
import pxu.com.model.KhachHang;
import pxu.com.model.Phong;
import pxu.com.model.ThuePhong;
import pxu.com.repository.KhachHangRepository;
import pxu.com.repository.ThuePhongRepository;

@Service
public class ThuePhongService {

	@Autowired
	private ThuePhongRepository thuePhongRepository;

	public void thuePhong(ThuePhong thuePhong) {
		thuePhongRepository.save(thuePhong);
	}

	public List<ThuePhong> findAllByMaPhong(Long maPhong) {
		return thuePhongRepository.findAllByMaPhongAndTrangThai(maPhong);
	}
	
	@Transactional
	public ThuePhong getThuePhong(Long maThuePhong) {
		Optional<ThuePhong> tOptional = thuePhongRepository.findById(maThuePhong);
		return tOptional.orElse(null);
	}
}
