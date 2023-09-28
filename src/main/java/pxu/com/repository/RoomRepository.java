package pxu.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pxu.com.model.Room;

@Repository("roomRepository")
public interface RoomRepository extends JpaRepository<Room, Integer> {

	@Modifying
	@Query("UPDATE Room r SET r.status = 'có khách' WHERE r.id = :roomId")
	void markRoomAsRented(@Param("roomId") int roomId);

	@Modifying
	@Query("UPDATE Room r SET r.status = 'đang sửa chữa' WHERE r.id = :roomId")
	void updatesuachua(@Param("roomId") int roomId);

	@Modifying
	@Query("UPDATE Room r SET r.status = 'còn trống' WHERE r.id = :roomId")
	void updatecontrong(@Param("roomId") int roomId);

	@Modifying
	@Query("UPDATE Room r SET r.status = 'đã đặt' WHERE r.id = :roomId")
	void updatedadat(@Param("roomId") int roomId);
}
