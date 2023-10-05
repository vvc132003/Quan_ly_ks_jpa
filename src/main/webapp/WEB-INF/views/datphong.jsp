<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
<link rel="stylesheet"
	href="<c:url value='/resources/css/style1.css' />" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/default.css' />" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/jquery.fancybox.min.css' />" />
</head>
<body>
	<div class="animationload">
		<div class="loader"></div>
	</div>
	<div id="wapper">
		<%@ include file="/WEB-INF/layout/nav1.jsp"%>
		<br> <br>
		<div style="padding: 0px 500px;">
			<form:form action="adddatphongphong" method="POST"
				modelAttribute="thuePhong">
				<div class="mb-3">
					<form:input type="hidden" path="phong.maPhong" id="maPhong"
						class="form-control" required="required" />
				</div>
				<div class="mb-3">
					<form:label path="khachHang.hoVaTenDem" class="form-label">Tên khách hàng</form:label>
					<form:input path="khachHang.hoVaTenDem" class="form-control" />
					<form:errors path="khachHang.hoVaTenDem" class="text-danger" />
				</div>
				<div class="mb-3">
					<form:label path="khachHang.soDienThoai" class="form-label">Số điện thoại:</form:label>
					<form:input path="khachHang.soDienThoai" class="form-control" />
					<form:errors path="khachHang.soDienThoai" class="text-danger" />
				</div>
				<div class="mb-3">
					<form:label path="khachHang.diaChi" class="form-label">Địa chỉ:</form:label>
					<form:input path="khachHang.diaChi" class="form-control" />
					<form:errors path="khachHang.diaChi" class="text-danger" />
				</div>
				<div class="mb-3">
					<form:label path="khachHang.email" class="form-label">Email:</form:label>
					<form:input path="khachHang.email" class="form-control" />
					<form:errors path="khachHang.email" class="text-danger" />
				</div>
				<div class="mb-3">
					<form:label path="khachHang.cccd" class="form-label">CCCD:</form:label>
					<form:input path="khachHang.cccd" class="form-control" />
					<form:errors path="khachHang.cccd" class="text-danger" />
				</div>
				<div class="mb-3">
					<form:input type="hidden" path="nhanVien.maNhanVien" value="1"
						id="maNhanVien" class="form-control" required="required" />
				</div>
				<div class="mb-3">
					<label for="tienDatCoc">Tiền đặt cọc:</label>
					<form:input type="text" path="tienDatCoc" id="tienDatCoc"
						class="form-control" required="required" />
				</div>
				<input type="submit" value="Đặt phòng" class="btn btn-primary" />

			</form:form>
		</div>
	</div>
	<br>
	
	<div class="cover_footer">
		<div class="wrap1200 flex" style="padding: 10px 100px;">
			<div class="col_foot_1">
				<p>
				<p>
					<span style="font-size: 22px;"><span
						style="font-family: courier new, courier, monospace;"><span
							style="color: rgb(255, 255, 0);">KHÁCH SẠN NGHỈ DƯỠNG KIM
								NGÂN</span></span></span>
				</p>

				<p>
					<em>Là một trong những khách sạn có chất lượng dịch vụ tốt tại
						Tp. Vũng Tàu. Sẽ mang lại sự thoải mái cho gia đình và bạn bè khi
						dừng chân tại đây. Với các loại phòng đơn, phòng đôi, phòng ba.
						Chúng tôi sẽ là sự lựa chọn tốt nhất cho bạn.</em>
				</p>

				<p></p>

				<p>
					<span style="font-size: 14px;"><span
						style="font-family: tahoma, geneva, sans-serif;"><span
							style="color: #FFA500;">Địa chỉ</span>: <span
							style="color: #FFA07A;">243 Lê Hồng Phong, Phường 8, Tp.
								Vũng Tàu</span></span></span>
				</p>

				<p>
					<span style="font-size: 14px;"><span
						style="font-family: tahoma, geneva, sans-serif;"><span
							style="color: #FFA500;">Email</span>: <span
							style="color: #FFA07A;">kimnganhotelvt@gmail.com</span></span></span>
				</p>

				<p>
					<span style="font-size: 14px;"><span
						style="font-family: tahoma, geneva, sans-serif;"><span
							style="color: #FFA500;">Phone</span>: <span
							style="color: #FFA07A;">094 824 96 69</span></span></span>
				</p>
				</p>
			</div>

			<div class="col_foot_2">
				<div class="tieude_footer">Fanpage Facebook</div>
				<div class="fb-page"
					data-href="https://www.facebook.com/Kim-Ng%C3%A2n-Hotel-189001161937499/?modal=admin_todo_tour"
					data-tabs="timeline" data-width="500" data-height="185"
					data-small-header="true" data-adapt-container-width="true"
					data-hide-cover="false" data-show-facepile="true">
					<div class="fb-xfbml-parse-ignore">
						<blockquote
							cite="https://www.facebook.com/Kim-Ng%C3%A2n-Hotel-189001161937499/?modal=admin_todo_tour">
							<a
								href="https://www.facebook.com/Kim-Ng%C3%A2n-Hotel-189001161937499/?modal=admin_todo_tour">Facebook</a>
						</blockquote>
					</div>
				</div>
				<div class="mxh">
					<span>FOLLOW US: </span> <a class="item_mxh hover_xoay"
						href="https://www.facebook.com/QiNiShopLeGiaSi/"> <img
						src="upload/hinhanh/mxh2-2858.png">
					</a> <a class="item_mxh hover_xoay"
						href="https://www.facebook.com/QiNiShopLeGiaSi/"> <img
						src="upload/hinhanh/mxh1-4639.png">
					</a> <a class="item_mxh hover_xoay"
						href="https://www.facebook.com/QiNiShopLeGiaSi/"> <img
						src="upload/hinhanh/mxh4-9021.png">
					</a> <a class="item_mxh hover_xoay"
						href="https://www.facebook.com/QiNiShopLeGiaSi/"> <img
						src="upload/hinhanh/mxh3-7226.png">
					</a> <a class="item_mxh hover_xoay" href=""> <img
						src="upload/hinhanh/mxh5-5990.png">
					</a>
				</div>
			</div>

			<div class="col_foot_3">
				<div class="tieude_footer">Bản đồ hướng dẫn</div>
				<div class="map_tt" style="color: #000; font-size: 12px;">
					<script type="text/javascript"
						src="http://maps.google.com/maps/api/js?key=AIzaSyDV7fuGm6yUzPMx9tflEmKT-QGc9SiQ6J4"></script>
					<script>
						function initialize2() {
							var myLatlng = new google.maps.LatLng(10.350160,
									107.091509);
							var mapOptions = {
								zoom : 16,
								scrollwheel : false,
								center : myLatlng
							};

							var map = new google.maps.Map(document
									.getElementById('map_canvas2'), mapOptions);

							var contentString = "<table><tr><th>Khách sạn Kim Ngân Vũng Tàu</th></tr><tr><td  style='color:#F00;font-weight:bold;'>243 Lê Hồng Phong, Phường 8, Thành Phố Vũng Tàu</td></tr></table>";

							var infowindow = new google.maps.InfoWindow({
								content : contentString
							});

							var marker = new google.maps.Marker({
								position : myLatlng,
								map : map,
								title : 'Khách sạn Kim Ngân Vũng Tàu'
							});
							infowindow.open(map, marker);
						}

						google.maps.event.addDomListener(window, 'load',
								initialize2);
					</script>
					<div id="map_canvas2" style="width: 100%; height: 240px;"></div>
					<div class="clear"></div>
				</div>
			</div>
		</div>

		<div class="copyright flex">
			<div class="info">
				Copyright @ 2018 by <span>Khách sạn Kim Ngân Vũng Tàu</span> All
				rights reserved. Design by Nina Co.,Ltd
			</div>
			<div class="thongke">
				<p>
					Online: <span>1</span>
				</p>
				<p>|</p>
				<p>
					Tổng truy cập: <span>47067</span>
				</p>
			</div>
		</div>
	</div>
</body>
<style>
/* Style the form container */
form {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 10px;
	background-color: #f7f7f7;
}

/* Style form labels */
.form-label {
	font-weight: bold;
}

/* Style input fields */
.form-control {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

/* Style error messages */
.text-danger {
	color: red;
	font-size: 12px;
}

/* Style the submit button */
.btn-primary {
	background-color: #007bff;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
}

/* Style the hidden inputs (if needed) */
[type="hidden"] {
	display: none;
}
</style>
<script src="<c:url value='/resources/js/jquery-3.2.1.min.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/resources/js/custom.js' />"></script>
</html>