<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/file/css.jsp"%>
<%@ include file="/WEB-INF/file/js.jsp"%>
</head>
<body class="dashboard dashboard_1">
	<div class="full_container">
		<div class="inner_container">
			<%@ include file="/WEB-INF/layout/header.jsp"%>
			<div id="content">
				<%@ include file="/WEB-INF/layout/navbar.jsp"%>
				<br>
				<div class="row">
					<!-- thong tin khách hàng -->
					<div class="col-7">
						<div class="text-bg-success  p-2">Chi tiết thuê phòng</div>
						<div class="row table-container">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>ID</th>
										<th>Tên khách hàng</th>
										<th>Thời gian nhận phòng</th>
										<th>Thời gian dự kiến trả phòng</th>
										<th>Trạng thái</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${phieuThuePhongList}" var="phieuThuePhong">
										<tr>
											<td>${phieuThuePhong.maThuePhong}</td>
											<td>${phieuThuePhong.khachHang.hoVaTenDem}</td>
											<td>${phieuThuePhong.ngayNhanPhong}</td>
											<td>${phieuThuePhong.ngayTraPhong}</td>
											<td>${phieuThuePhong.trangThai}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<hr>

						<!-- chi tiết dịch vụ -->

						<div class="text-bg-success  p-2">Chi tiết dịch vụ</div>
						<div class="row table-container">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>ID</th>
										<th>Số lượng</th>
										<th>Tên dịch vụ</th>
										<th>Thành tiền</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${thueDichVus}" var="thueDichVu"
										varStatus="loop">
										<tr>
											<td>${loop.index + 1}</td>
											<td>${thueDichVu.soLuong}</td>
											<td>${thueDichVu.dichVu.tenDichVu}</td>
											<td>${thueDichVu.thanhTien}</td>
											<c:forEach items="${phieuThuePhongList}" var="phieuThuePhong">
												<td><a
													href="deleteThueDichVu?thuedichvuID=${thueDichVu.maThueDichVu}&maPhong=${phieuThuePhong.phong.maPhong}"
													class="btn btn-danger"> <i class="fas fa-minus"></i>
												</a> <a
													href="updateThueDichVu?thuedichvuID=${thueDichVu.maThueDichVu}&maPhong=${phieuThuePhong.phong.maPhong}"
													class="btn btn-warning"> <i class="fas fa-plus"></i>
												</a></td>
											</c:forEach>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>






						<hr>
						<!--THANH TOÁN  -->
						<div class="text-bg-primary  p-2">Thanh toán</div>
						<div class="payment-section">
							<div class="payment-details">
								<form:form action="addtraphong" method="post"
									modelAttribute="traphong">
									<input type="hidden" name="tongTien" value="${totalCost}" />
									<c:forEach items="${phieuThuePhongList}" var="phieuThuePhong">
										<p>Tổng Tiền Thuê Dịch Vụ: ${totalCost} VNĐ</p>
										<p>Tổng Tiền Phòng: ${phieuThuePhong.phong.giaTien} VNĐ</p>
										<p>Tiền đặt cọc: ${phieuThuePhong.tienDatCoc} VNĐ</p>
										<input type="hidden" name="tienDatCoc"
											value="${phieuThuePhong.tienDatCoc}" />
										<p style="font-size: 20px; font-weight: 500;">Tổng Thanh
											Toán: ${phieuThuePhong.phong.giaTien + totalCost - phieuThuePhong.tienDatCoc
											}
											VNĐ</p>
										<input type="hidden" name="maNhanVien"
											value="${phieuThuePhong.nhanVien.maNhanVien}" />
										<input type="hidden" name="maThuePhong"
											value="${phieuThuePhong.maThuePhong}" />
										<input type="hidden" name="maPhong"
											value="${phieuThuePhong.phong.maPhong}" />
										<input type="hidden" name="giaTien"
											value="${phieuThuePhong.phong.giaTien}" />
									</c:forEach>
									<button type="submit" class="payment-button">Thanh
										toán</button>
								</form:form>
							</div>
						</div>
						<br>
					</div>




					<!--dịch vụ  -->
					<div class="col-5 ">
						<div class="text-bg-primary  p-2">Dịch vụ</div>
						<br>
						<div class=" text-center ">
							<c:forEach var="dichVu" items="${dichVus}" varStatus="status">
								<div class="card text-center"
									style="width: 10rem; display: inline-block; margin-right: 10px;">
									<br> <img src="${dichVu.image}" alt="${dichVu.tenDichVu}"
										style="width: 60%; height: 60px" />
									<div class="card-body text-center" id="dichvu">
										<p>${dichVu.tenDichVu}</p>
										<form:form action="addThueDichVu" method="post"
											modelAttribute="thueDichVu">
											<input type="hidden" name="maDichVu"
												value="${dichVu.maDichVu}" />
											<c:forEach items="${phieuThuePhongList}" var="phieuThuePhong">
												<input type="hidden" name="maThuePhong"
													value="${phieuThuePhong.maThuePhong}" />
												<input type="hidden" name="maPhong"
													value="${phieuThuePhong.phong.maPhong}" />
												<input type="hidden" name="maNhanVien"
													value="${phieuThuePhong.nhanVien.maNhanVien}" />
												<button type="submit" class="custom-button">Thuê
													dịch vụ</button>
											</c:forEach>
										</form:form>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>





</body>
<style>
/* CSS cho phần "Thanh toán" */
.payment-section {
	background-color: #f8f8f8; /* Màu nền */
	padding: 20px;
	border-radius: 5px; /* Độ cong viền */
	/* 	box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.5); /* Đổ bóng */
	*/
}

.payment-title {
	font-size: 24px;
	color: #333; /* Màu chữ */
}

.payment-details {
	margin-top: 10px;
}

/* CSS cho nút thanh toán */
.payment-button {
	background-color: #007BFF; /* Màu nền */
	color: #fff; /* Màu chữ */
	padding: 10px 20px; /* Khoảng cách bên trong nút */
	border: none; /* Loại bỏ viền nút */
	border-radius: 5px; /* Độ cong viền */
	cursor: pointer; /* Thay đổi hình dạng con trỏ khi di chuột vào nút */
}

.payment-button:hover {
	background-color: #0056b3; /* Màu nền khi di chuột vào nút */
}

.table-container {
	text-align: center;
	margin: 0 auto;
}

.table thead th {
	text-align: center;
}

.table {
	border: 1px solid #ccc;
	border-collapse: collapse;
}

.table thead th {
	border: 1px solid #000;
}

.table tbody td {
	border: 1px solid #ccc;
}

#dichvu .p {
	color: rgb(0, 0, 0);
	font-size: 20px;
}

.custom-form {
	/* Thêm các thuộc tính CSS tùy chỉnh cho form */
	
}

.custom-button {
	background-color: #007BFF; /* Màu nền của nút */
	color: #fff; /* Màu chữ của nút */
	padding: 2px 4px; /* Khoảng cách bên trong nút */
	border: none; /* Loại bỏ viền nút */
	cursor: pointer; /* Thay đổi hình dạng con trỏ khi di chuột vào nút */
}

.custom-button:hover {
	background-color: #0056b3; /* Màu nền khi di chuột vào nút */
}
</style>
</html>