package pxu.com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.com.model.NhanVien;
import pxu.com.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public NhanVien findBytaiKhoanAndPassword(String taiKhoan) {
		return userRepository.findByTaiKhoan(taiKhoan);
	}
}
