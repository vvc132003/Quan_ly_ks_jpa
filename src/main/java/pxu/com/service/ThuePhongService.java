package pxu.com.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pxu.com.model.DichVu;
import pxu.com.model.KhachHang;
import pxu.com.model.Phong;
import pxu.com.model.ThuePhong;
import pxu.com.repository.KhachHangRepository;
import pxu.com.repository.ThuePhongRepository;

@Service
public class ThuePhongService {

	@Autowired
	private ThuePhongRepository thuePhongRepository;

	public void thuePhong(ThuePhong thuePhong) {
		thuePhongRepository.save(thuePhong);
	}

	public List<ThuePhong> findAllByMaPhong(Long maPhong) {
		return thuePhongRepository.findAllByMaPhongAndTrangThai(maPhong);
	}

	@Transactional
	public void updatethuephong(Long maThuePhong, BigDecimal tongTien) {
		thuePhongRepository.updateTrangThaiAndTongTien(tongTien, maThuePhong);
	}

	@Transactional
	public ThuePhong getThuePhong(Long maThuePhong) {
		Optional<ThuePhong> tOptional = thuePhongRepository.findById(maThuePhong);
		return tOptional.orElse(null);
	}

	@Transactional
	public void sendEmails() {
		List<ThuePhong> thuePhongs = thuePhongRepository.findAll();

		for (ThuePhong thuePhong : thuePhongs) {
			try {
				Properties p = new Properties();
				p.put("mail.smtp.auth", "true");
				p.put("mail.smtp.starttls.enable", "true");
				p.put("mail.smtp.host", "smtp.gmail.com");
				p.put("mail.smtp.port", "587");

				Session session = Session.getInstance(p, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("vvc132003@gmail.com", "mwvfwkbyknepohte");
					}
				});

				String from = "vvc132003@gmail.com";
				String to = thuePhong.getKhachHang().getEmail();
				String subject = "Gửi đến bạn";
				String body = "Mã phòng: " + thuePhong.getPhong().getMaPhong() + "\nTên khách hàng: "
						+ thuePhong.getKhachHang().getHoVaTenDem() + "\nNgày thuê: " + thuePhong.getNgayNhanPhong();
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				message.setSubject(subject);
				message.setText(body);

				try (Transport transport = session.getTransport("smtp")) {
					transport.connect("smtp.gmail.com", "vvc132003@gmail.com", "qyqgwwjbbajzrrex");
					transport.sendMessage(message, message.getAllRecipients());
				}
				System.out.println("Email sent successfully to: " + to);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
