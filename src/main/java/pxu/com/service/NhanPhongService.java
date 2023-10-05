package pxu.com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.com.model.NhanPhong;
import pxu.com.model.NhanVien;
import pxu.com.model.ThuePhong;
import pxu.com.repository.NhanPhongRepository;
import pxu.com.repository.ThuePhongRepository;

@Service
public class NhanPhongService {
	@Autowired
	private NhanPhongRepository nhanPhongRepository;

	public void nhanPhong(NhanPhong nhanPhong) {
		nhanPhongRepository.save(nhanPhong);
	}

	@Transactional
	public List<NhanPhong> getNhanPhong() {
		return nhanPhongRepository.findAllOrderByMaNhanPhongDesc();
	}
}
