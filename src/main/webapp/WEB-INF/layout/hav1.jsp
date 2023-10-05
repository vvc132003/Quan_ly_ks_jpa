<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="cover_about cover_dm">
	<div class="tieude_dm">Phòng khách sạn</div>
	<div class="ten_dm wrap1200">
		<!-- <div class="tieude2_dm active" data-iddm="4">
			<img src="http://kimnganhotel.com/upload/sanpham/dm3-6808-90530.png" />
			<p>Phòng Đơn</p>
		</div> -->
		<div class="tieude2_dm " data-iddm="2">
			<img src="http://kimnganhotel.com/upload/sanpham/dm3-6808.png" />
			<p>Phòng</p>
		</div>
	</div>
	<div class="cover_sp">
		<div class="wrap1200 ajax_kq">
			<div class="wrap_item">
				<c:forEach var="room" items="${rooms}" varStatus="status">
					<div class="box_item">
						<div class="item">
							<a class="img zoom_hinh" href="phong-don-3"> <img
								onerror="src='thumb/380x295/1/images/noimage.png'"
								src="http://kimnganhotel.com/thumb/380x295/1/upload/sanpham/phongdon5-kimngan-1920.png"
								alt="Phòng đơn 3" />
							</a>
							<div class="des des_unhover">
								<a class="ten" href="phong-don-3"> Phòng ${room.maPhong} </a>
								<div class="gia">Liên hệ</div>
								<div class="chatluong">...</div>
							</div>
							<div class="des box_des_hover">
								<div class="des_hover">
									<a class="ten" href="phong-don-3"> Phòng ${room.maPhong} </a>
									<div class="gia">Liên hệ</div>
									<div class="chatluong">...</div>
									<div class="mota">Lưu ý: Giá phòng trên website áp dụng
										cho những ngày thường. Các dịp lễ tết giá phòng sẽ có sự thay
										đổi. Quý khách vui...</div>
									<a class="xemthem2"
										href="${pageContext.request.contextPath}/thuephong/datphong?idPhong=${room.maPhong}">Thuê
										Phòng </a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>