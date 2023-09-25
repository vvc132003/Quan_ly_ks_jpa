package pxu.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pxu.com.model.Room;

@Repository("roomRepository")
public interface RoomRepository extends JpaRepository<Room, Integer>{

}
