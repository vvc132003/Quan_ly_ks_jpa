<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file="/WEB-INF/file/css.jsp"%>
<%@ include file="/WEB-INF/file/js.jsp"%>
<!-- Add Bootstrap CSS via CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="dashboard dashboard_1">

	<div class="modal fade" id="paymentSuccessModal" tabindex="-1"
		role="dialog" aria-labelledby="paymentSuccessModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<p id="thuephongErrorMessage">${thuephongErrorMessage}</p>
					<i class="fas fa-times fa-5x" style="color: red;"></i>
				</div>
			</div>
		</div>
	</div>
	<div class="full_container">
		<div class="inner_container">
			<%@ include file="/WEB-INF/layout/header.jsp"%>
			<div id="content">
				<%@ include file="/WEB-INF/layout/navbar.jsp"%>
				<br>
				<div class="container w-50">
					<h1 class="mt-5 mb-4 text-center">Nhận Phòng</h1>
					<c:forEach items="${thuePhongList}" var="thuePhong">
						<%-- <tr>
							<td>${thuePhong.phong.maPhong}</td>
							<td>${thuePhong.maThuePhong}</td>
							<td>${thuePhong.khachHang.hoVaTenDem}
							<td>${thuePhong.ngayNhanPhong}</td>
							<td>${thuePhong.ngayTraPhong}</td>
							<td>${thuePhong.trangThai}</td>
							<td> --%>
						<form
							action="${pageContext.request.contextPath}/nhanphong/addnhanphong"
							method="POST">
							<input type="hidden" name="maThuePhong"
								value="${thuePhong.maThuePhong}">
							<div class="form-group">
								<input type="hidden" id="roomId" name="maPhong"
									value="${thuePhong.phong.maPhong}" readonly>
							</div>
							<div class="form-group">
								<label for="customerId">Tên Khách hàng:</label> <input
									type="text" id="hoVaTenDem" name="hoVaTenDem"
									value="${thuePhong.khachHang.hoVaTenDem}" readonly> <input
									type="hidden" id="maKhachHang" name="maKhachHang"
									value="${thuePhong.khachHang.maKhachHang}" readonly>
							</div>
							<div class="form-group">
								<label for="cccd">CCCD:</label> <input type="text" id="cccd"
									name="cccd" value="">
							</div>
							<div class="form-group">
								<input type="submit" value="Nhận phòng" class="btn-primary">
							</div>
						</form>

						<!-- 	</td>
						</tr> -->
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<style>
/* Áp dụng CSS cho form */
form {
	max-width: 400px;
	margin: 0 auto;
}

.form-group {
	margin-bottom: 20px;
}

label {
	font-weight: bold;
}

input[type="text"], input[type="hidden"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

input[type="submit"] {
	background-color: #007BFF;
	color: #fff;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}

.modal.fade.show {
	display: flex !important;
	align-items: center;
	justify-content: center;
	background: rgba(0, 0, 0, 0.5);
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	z-index: 9999;
	transition: opacity 0.3s ease;
}

.modal-content {
	background-color: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
	text-align: center;
	max-width: 1000px;
	width: 100%;
	text-align: center;
}

.modal-content p {
	font-size: 20px;
	font-weight: bold;
}

#paymentSuccessMessage {
	color: green;
}

#thuephongSuccessMessage {
	color: green;
}
</style>
	<script>
		// JavaScript để hiển thị modal nếu có thông báo thành công
		$(document).ready(function() {
			var thuephongErrorMessage = "${thuephongErrorMessage}";

			if (thuephongErrorMessage !== "") {
				// Hiển thị modal và đặt nội dung thông báo
				$('#thuephongErrorMessage').text(thuephongErrorMessage);
				$('#paymentSuccessModal').modal('show');
			}
		});
	</script>

	<!-- Add Bootstrap JavaScript and Popper.js via CDN (required for some Bootstrap features) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@2.9.3/dist/umd/popper.min.js"></script>
</body>
</html>