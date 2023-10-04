<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add SinhVien</title>
<%@ include file="/WEB-INF/file/css.jsp"%>
<%@ include file="/WEB-INF/file/js.jsp"%>
<!-- Add Bootstrap CSS via CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="dashboard dashboard_1">
	<div class="full_container">
		<div class="inner_container">
			<%@ include file="/WEB-INF/layout/header.jsp"%>
			<div id="content">
				<%@ include file="/WEB-INF/layout/navbar.jsp"%>
				<br>
				<div class="container w-50">
					<h1 class="mt-5 mb-4 text-center">Thuê Phòng</h1>
					<c:forEach items="${thuePhongList}" var="thuePhong">
						<tr>
							<td>${thuePhong.phong.maPhong}</td>
							<td>${thuePhong.maThuePhong}</td>
							<td>${thuePhong.khachHang.hoVaTenDem}
							<td>${thuePhong.ngayNhanPhong}</td>
							<td>${thuePhong.ngayTraPhong}</td>
							<td>${thuePhong.trangThai}</td>
							<td>
								<form action="addnhanphong" method="POST">
									<input type="" name="maThuePhong"
										value="${thuePhong.maThuePhong}">
									<div class="form-group">
										<label for="roomId">Mã Phòng:</label> <input type="text"
											id="roomId" name="roomId" value="${thuePhong.phong.maPhong}"
											readonly>
									</div>
									<div class="form-group">
										<label for="roomId">Khách hàng:</label> <input type="text"
											id="roomId" name="roomId"
											value="${thuePhong.khachHang.maKhachHang}" readonly>
									</div>
									<div class="form-group">
										<label for="tienDatCoc">Tiền đặt cọc:</label> <input
											type="text" id="tienDatCoc" name="tienDatCoc"
											value="${thuePhong.tienDatCoc}" class="form-control" required>
									</div>
									<div class="form-group">
										<input type="submit" value="Nhận phòng" class="btn-primary">
									</div>
								</form>
							</td>
						</tr>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<!-- Add Bootstrap JavaScript and Popper.js via CDN (required for some Bootstrap features) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@2.9.3/dist/umd/popper.min.js"></script>
</body>
</html>