package pxu.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pxu.com.model.Phong;

@Repository("roomRepository")
public interface RoomRepository extends JpaRepository<Phong, Long> {

//	@Modifying
//	@Query("UPDATE phong r SET r.TinhTrangPhong = 'có khách' WHERE r.MaPhong = :roomId")
//	void markRoomAsRented(@Param("roomId") Long roomId);
//
//	@Modifying
//	@Query("UPDATE phong r SET r.TinhTrangPhong = 'đang sửa chữa' WHERE r.MaPhong = :roomId")
//	void updatesuachua(@Param("roomId") Long roomId);
//
//	@Modifying
//	@Query("UPDATE phong r SET r.TinhTrangPhong = 'còn trống' WHERE r.MaPhong = :roomId")
//	void updatecontrong(@Param("roomId") Long roomId);
//
//	@Modifying
//	@Query("UPDATE phong r SET r.TinhTrangPhong = 'đã đặt' WHERE r.MaPhong = :roomId")
//	void updatedadat(@Param("roomId") Long roomId);
}
