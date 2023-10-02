package pxu.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pxu.com.model.DichVu;
import pxu.com.model.Phong;

@Repository("dichVuRepository")
public interface DichVuRepository extends JpaRepository<DichVu, Long> {

//	@Query("SELECT d.tenDichVu, SUM(td.soLuong) " + "FROM DichVu d " + "JOIN ThueDichVu td ON d.maDichVu = td.maDichVu "
//			+ "GROUP BY d.tenDichVu " + "ORDER BY SUM(td.soLuong) DESC")
//	List<Object[]> thongKeDichVuDuocThueNhieuNhat();

}
