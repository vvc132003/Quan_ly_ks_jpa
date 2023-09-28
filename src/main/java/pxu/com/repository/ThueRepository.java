package pxu.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pxu.com.model.PhieuThuePhong;

@Repository("thueRepository")
public interface ThueRepository extends JpaRepository<PhieuThuePhong, Integer> {

	@Query("SELECT p FROM PhieuThuePhong p WHERE p.id = :roomId AND p.status = 'đang thuê'")
	List<PhieuThuePhong> findChuaThanhToanByRoomId(@Param("roomId") int roomId);

	@Modifying
	@Query("UPDATE PhieuThuePhong r SET r.status = 'dathanhtoan' WHERE r.id_thue = :idthue")
	void updatetrangthaithue(@Param("idthue") int idthue);

}