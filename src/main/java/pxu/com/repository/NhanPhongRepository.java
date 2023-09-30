package pxu.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pxu.com.model.DichVu;
import pxu.com.model.KhachHang;
import pxu.com.model.NhanPhong;
import pxu.com.model.Phong;
import pxu.com.model.ThuePhong;

@Repository("nhanPhongRepository")
public interface NhanPhongRepository extends JpaRepository<NhanPhong, Long> {

}
