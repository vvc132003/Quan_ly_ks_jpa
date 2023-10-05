<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KhoaHoc List</title>
<%@ include file="/WEB-INF/file/css.jsp"%>
<%@ include file="/WEB-INF/file/js.jsp"%>
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
				<div class="container">
					<h1 class="mt-5 mb-4 text-center">Danh sách trả phòng</h1>
					<div class="d-flex justify-content-between">
						<%-- <a
							href="${pageContext.request.contextPath}/khachhang/khachhangform"
							class="btn btn-primary mb-4 ml-auto"><i class="fas fa-plus"></i>
							Thêm mới</a> --%>
					</div>
					<div class="table-container">
						<table class="table table-striped" id="productTable" ne>
							<thead>
								<tr>
									<th>ID</th>
									<th>Ngày trả phòng</th>
									<th>Tên nhân viên</th>
									<th>Tổng tiền</th>
									<th>Mã thuê phòng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${traPhongs}" var="traPhongs"
									varStatus="status">
									<tr>
										<td>${status.index + 1}</td>
										<td>${traPhongs.ngayTraPhong}</td>
										<td>${traPhongs.nhanVien.hoVaTenDem}</td>
										<td>${traPhongs.tongTien}</td>
										<td>${traPhongs.thuePhong.maThuePhong}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<style>
.small-image {
	width: 100px;
	height: 100px;
}

.table-container {
	text-align: center;
	margin: 0 auto;
}

.table thead th {
	text-align: center;
	background-color: #999999;
	color: white;
}

.table {
	border: 1px solid #ccc;
	border-collapse: collapse;
}

.table th, .table td {
	border: 1px solid #ccc; /* Đường viền 1px màu xám cho các ô */
	padding: 8px; /* Khoảng cách bên trong ô */
}
</style>
	<!-- Add Bootstrap JavaScript and Popper.js via CDN (required for some Bootstrap features) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@2.9.3/dist/umd/popper.min.js"></script>
</body>
</html>