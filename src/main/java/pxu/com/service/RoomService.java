package pxu.com.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.com.exception.ResourceNotFoundException;
import pxu.com.model.ThuePhong;
import pxu.com.model.DichVu;
import pxu.com.model.Phong;
import pxu.com.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Transactional
	public void updattrangthaiphong(Long maPhong) {
		roomRepository.markRoomAsRented(maPhong);
	}

	@Transactional
	public Phong findRoomByMaPhong(Long maPhong) {
		return roomRepository.findByMaPhong(maPhong);
	}

//
//	@Transactional
//	public void updatedadat(Long roomId) {
//		roomRepository.updatedadat(roomId);
//	}
//
	@Transactional
	public void updatesuachua(Long roomId) {
		roomRepository.updatesuachua(roomId);
	}

	@Transactional
	public void updatedangsuachua(Long roomId) {
		roomRepository.updatedangsuachua(roomId);
	}

	@Transactional
	public void updatecontrong(Long maPhong) {
		roomRepository.updatecontrong(maPhong);
	}

	@Transactional
	public List<Phong> getRooms() {
		return roomRepository.findAll();
	}

	@Transactional
	public Optional<Phong> getphong(Long id) {
		return roomRepository.findById(id);
	}

	@Transactional
	public long countPhongDangThue() {
		return roomRepository.countPhongDangThue();
	}

	@Transactional
	public long countPhongTrong() {
		return roomRepository.countPhongTrong();
	}

}