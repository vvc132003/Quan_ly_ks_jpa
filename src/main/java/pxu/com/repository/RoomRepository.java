package pxu.com.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pxu.com.model.Phong;

@Repository("roomRepository")
public interface RoomRepository extends JpaRepository<Phong, Long> {

	@Modifying
	@Transactional
	@Query("UPDATE Phong p SET p.tinhTrangPhong = 'có khách' WHERE p.maPhong = :maPhong")
	void markRoomAsRented(@Param("maPhong") Long maPhong);

	@Modifying
	@Query("UPDATE Phong r SET r.tinhTrangPhong = 'dang sua chua' WHERE r.maPhong = :maPhong")
	void updatesuachua(@Param("maPhong") Long maPhong);

	@Modifying
	@Query("UPDATE Phong r SET r.tinhTrangPhong = 'còn trống' WHERE r.maPhong = :maPhong")
	void updatecontrong(@Param("maPhong") Long maPhong);
//
//	@Modifying
//	@Query("UPDATE phong r SET r.TinhTrangPhong = 'đã đặt' WHERE r.MaPhong = :roomId")
//	void updatedadat(@Param("roomId") Long roomId);
}
