package pxu.com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.com.model.ThuePhong;
import pxu.com.repository.ThueRepository;

@Service
public class PhieuThuePhongService {

//	private final ThueRepository phieuThuePhongRepository;

//	@Autowired
//	public PhieuThuePhongService(ThueRepository phieuThuePhongRepository) {
//		this.phieuThuePhongRepository = phieuThuePhongRepository;
//	}
//	
//	@Transactional
//	public List<ThuePhong> getPhieuThuePhongByRoomId(Long roomId) {
//		return phieuThuePhongRepository.findChuaThanhToanByRoomId(roomId);
//	}
//
//	@Transactional
//	public void updatetrangthaithue(Long idthue) {
//		phieuThuePhongRepository.updatetrangthaithue(idthue);
//	}
}