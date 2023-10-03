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
					<h1 class="mt-5 mb-4 text-center">Thêm khách hàng</h1>
					<form:form action="addkhachhang" method="post" modelAttribute="khachHang">
						<form:hidden path="maKhachHang" />
						<div class="mb-3">
							<form:label path="hoVaTenDem" class="form-label">Tên khách hàng</form:label>
							<form:input path="hoVaTenDem" class="form-control" />
							<form:errors path="hoVaTenDem" class="text-danger" />
						</div>
						<div class="mb-3">
							<form:label path="soDienThoai" class="form-label">Số điện thoại:</form:label>
							<form:input path="soDienThoai" class="form-control" />
							<form:errors path="soDienThoai" class="text-danger" />
						</div>
						<div class="mb-3">
							<form:label path="diaChi" class="form-label">Địa chỉ:</form:label>
							<form:input path="diaChi" class="form-control" />
							<form:errors path="diaChi" class="text-danger" />
						</div>
						<div class="mb-3">
							<form:label path="email" class="form-label">Email:</form:label>
							<form:input path="email" class="form-control" />
							<form:errors path="email" class="text-danger" />
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-primary">Thêm</button>
						</div>

					</form:form>
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