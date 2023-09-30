package pxu.com.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.com.model.DichVu;
import pxu.com.model.ThueDichVu;
import pxu.com.repository.DichVuRepository;
import pxu.com.repository.ThueDichVuRepository;

@Service
public class ThueDichVuService {

	@Autowired
	private ThueDichVuRepository thueDichVuRepository;

	@Transactional
	public List<ThueDichVu> getThueDichVu() {
		return thueDichVuRepository.findAll();
	}

	public List<ThueDichVu> getThueDichVusByMaThuePhong(Long maThuePhong) {
		return thueDichVuRepository.findByThuePhongMaThuePhong(maThuePhong);
	}

	@Transactional
	public void saveThueDichVu(ThueDichVu thueDichVu) {
		thueDichVuRepository.save(thueDichVu);
	}

	@Transactional
	public Optional<ThueDichVu> getThueDichVu(Long maThueDichVu) {
		return thueDichVuRepository.findById(maThueDichVu);
	}

	@Transactional
	public void deleteThueDichVu(Long maThueDichVu) {
		thueDichVuRepository.deleteById(maThueDichVu);
	}

	public Optional<ThueDichVu> updateThueDichVu(Long maThueDichVu, ThueDichVu thueDichVu) {
		if (!thueDichVuRepository.existsById(maThueDichVu)) {
			return Optional.empty();
		}
		thueDichVu.setMaThueDichVu(maThueDichVu);
		return Optional.of(thueDichVuRepository.save(thueDichVu));
	}
}