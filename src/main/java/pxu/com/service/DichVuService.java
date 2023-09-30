package pxu.com.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.com.model.DichVu;
import pxu.com.repository.DichVuRepository;

@Service
public class DichVuService {

	@Autowired
	private DichVuRepository dichVuRepository;

	@Transactional
	public List<DichVu> getDichVus() {
		return dichVuRepository.findAll();
	}

	@Transactional
	public void saveDichVu(DichVu dichVu) {
		dichVuRepository.save(dichVu);
	}

	@Transactional
	public DichVu getDichVuById(Long id) {
		Optional<DichVu> optionalDichVu = dichVuRepository.findById(id);
		return optionalDichVu.orElse(null);
	}

	@Transactional
	public Optional<DichVu> getDichVu(Long maDichVu) {
		return dichVuRepository.findById(maDichVu);
	}

	@Transactional
	public void deleteDichVu(Long maDichVu) {
		dichVuRepository.deleteById(maDichVu);
	}

	public Optional<DichVu> updateDichVu(Long maDichVu, DichVu dichVu) {
		if (!dichVuRepository.existsById(maDichVu)) {
			return Optional.empty();
		}
		dichVu.setMaDichVu(maDichVu);
		return Optional.of(dichVuRepository.save(dichVu));
	}
}