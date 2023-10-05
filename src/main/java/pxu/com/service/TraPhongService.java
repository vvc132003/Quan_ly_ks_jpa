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
import pxu.com.model.TraPhong;
import pxu.com.repository.KhachHangRepository;
import pxu.com.repository.ThuePhongRepository;
import pxu.com.repository.TraPhongRepository;

@Service
public class TraPhongService {

	@Autowired
	private TraPhongRepository traPhongRepository;

	public void traphong(TraPhong traPhong) {
		traPhongRepository.save(traPhong);
	}
	
	
	@Transactional
	public List<TraPhong> findAllOrderByMmTraPhongDesc() {
		return traPhongRepository.findAllOrderByMmTraPhongDesc();
	}
}