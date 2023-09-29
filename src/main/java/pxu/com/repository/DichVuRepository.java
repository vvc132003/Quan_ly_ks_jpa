package pxu.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pxu.com.model.DichVu;
import pxu.com.model.Phong;

@Repository("dichVuRepository")
public interface DichVuRepository extends JpaRepository<DichVu, Long> {

}
