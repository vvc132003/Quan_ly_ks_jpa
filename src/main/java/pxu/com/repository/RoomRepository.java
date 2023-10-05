package pxu.com.repository;

import java.util.List;

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
	@Query("UPDATE Phong r SET r.tinhTrangPhong = 'chưa dọn' WHERE r.maPhong = :maPhong")
	void updatesuachua(@Param("maPhong") Long maPhong);

	@Modifying
	@Query("UPDATE Phong r SET r.tinhTrangPhong = 'đang sửa chữa' WHERE r.maPhong = :maPhong")
	void updatedangsuachua(@Param("maPhong") Long maPhong);

	@Modifying
	@Query("UPDATE Phong r SET r.tinhTrangPhong = 'còn trống' WHERE r.maPhong = :maPhong")
	void updatecontrong(@Param("maPhong") Long maPhong);

	@Modifying
	@Query("UPDATE Phong r SET r.tinhTrangPhong = 'đã đặt' WHERE r.maPhong = :maPhong")
	void updatedadat(@Param("maPhong") Long maPhong);

	Phong findByMaPhong(Long maPhong);

	@Query("SELECT COUNT(p) FROM Phong p WHERE p.tinhTrangPhong = 'có khách'")
	long countPhongDangThue();

	@Query("SELECT COUNT(p) FROM Phong p WHERE p.tinhTrangPhong = 'đã đặt'")
	long countPhongDaDat();

	@Query("SELECT COUNT(p) FROM Phong p WHERE p.tinhTrangPhong = 'còn trống'")
	long countPhongTrong();

	@Query("SELECT COUNT(p) FROM Phong p WHERE p.tinhTrangPhong = 'đang sửa chữa'")
	long countPhongDangSuaChua();

	@Query("SELECT COUNT(p) FROM Phong p WHERE p.tinhTrangPhong = 'chưa dọn'")
	long countPhongDangChuaDon();

	@Query("SELECT p FROM Phong p WHERE p.tinhTrangPhong = 'còn trống'")
	List<Phong> findAllPhongConTrong();

}