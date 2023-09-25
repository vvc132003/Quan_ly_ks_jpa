package pxu.com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.com.model.Room;
import pxu.com.repository.RoomRepository;

@Service
public class RoomServiceLmpl implements RoomService {
	@Autowired
	private RoomRepository roomRepository;

	@Override
	@Transactional
	public List<Room> getRooms() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}

}
