package pxu.com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.com.model.PhieuThuePhong;
import pxu.com.repository.ThueRepository;

@Service
public class PhieuThuePhongService {

	private final ThueRepository phieuThuePhongRepository;

	@Autowired
	public PhieuThuePhongService(ThueRepository phieuThuePhongRepository) {
		this.phieuThuePhongRepository = phieuThuePhongRepository;
	}
	
	@Transactional
	public List<PhieuThuePhong> getPhieuThuePhongByRoomId(int roomId) {
		return phieuThuePhongRepository.findChuaThanhToanByRoomId(roomId);
	}

	@Transactional
	public void updatetrangthaithue(int idthue) {
		phieuThuePhongRepository.updatetrangthaithue(idthue);
	}
}