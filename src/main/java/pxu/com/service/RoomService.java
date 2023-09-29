package pxu.com.service;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.com.exception.ResourceNotFoundException;
import pxu.com.model.ThuePhong;
import pxu.com.model.Phong;
import pxu.com.repository.RoomRepository;
import pxu.com.repository.ThueRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

//	@Transactional
//	public void updattrangthaiphong(Long roomId) {
//		roomRepository.markRoomAsRented(roomId);
//	}
//
//	@Transactional
//	public void updatedadat(Long roomId) {
//		roomRepository.updatedadat(roomId);
//	}
//
//	@Transactional
//	public void updatesuachua(Long roomId) {
//		roomRepository.updatesuachua(roomId);
//	}
//
//	@Transactional
//	public void updatecontrong(Long roomId) {
//		roomRepository.updatecontrong(roomId);
//	}

	@Transactional
	public List<Phong> getRooms() {
		return roomRepository.findAll();
	}

}
