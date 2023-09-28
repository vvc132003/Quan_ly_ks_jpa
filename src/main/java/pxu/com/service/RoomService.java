package pxu.com.service;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.com.exception.ResourceNotFoundException;
import pxu.com.model.PhieuThuePhong;
import pxu.com.model.Room;
import pxu.com.repository.RoomRepository;
import pxu.com.repository.ThueRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Transactional
	public void updattrangthaiphong(int roomId) {
		roomRepository.markRoomAsRented(roomId);
	}

	@Transactional
	public void updatedadat(int roomId) {
		roomRepository.updatedadat(roomId);
	}

	@Transactional
	public void updatesuachua(int roomId) {
		roomRepository.updatesuachua(roomId);
	}

	@Transactional
	public void updatecontrong(int roomId) {
		roomRepository.updatecontrong(roomId);
	}

	public List<Room> getRooms() {
		return roomRepository.findAll();
	}

}
