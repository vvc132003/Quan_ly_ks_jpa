package pxu.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pxu.com.model.ThuePhong;

@Repository("thueRepository")
public interface ThueRepository extends JpaRepository<ThuePhong, Long> {
//
//	@Query("SELECT p FROM thuephong p WHERE p.MaPhong = :roomId AND p.TrangThai = 'đang thuê'")
//	List<ThuePhong> findChuaThanhToanByRoomId(@Param("roomId") Long roomId);
//
//	@Modifying
//	@Query("UPDATE thuephong r SET r.TrangThai = 'dathanhtoan' WHERE r.MaThuePhong = :idthue")
//	void updatetrangthaithue(@Param("idthue") Long idthue);
}