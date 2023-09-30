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
					<form:form action="addthuephong" method="POST"
						modelAttribute="thuePhong">
						<div class="mb-3">
							<form:input type="" path="phong.maPhong" id="maPhong"
								class="form-control" required="required" />
						</div>
						<label for="">Khách hàng:</label>
						<select class="form-control" id="khachHang"
							name="khachHang.maKhachHang" required>
							<c:forEach items="${listHangs}" var="listHang">
								<option value="${listHang.maKhachHang}">${listHang.hoVaTenDem}</option>
							</c:forEach>
						</select>
						<div class="mb-3">
							<form:input type="" path="nhanVien.maNhanVien"
								value="${fullName}" id="maNhanVien"
								class="form-control" required="required" />
						</div>
						<%-- <div class="mb-3">
							<label for="ngayNhanPhong">Ngày nhận phòng:</label>
							<form:input type="date" path="ngayNhanPhong" id="ngayNhanPhong"
								class="form-control" required="required" />
						</div>
						<div class="mb-3">
							<label for="ngayTraPhong">Ngày trả phòng:</label>
							<form:input type="date" path="ngayTraPhong" id="ngayTraPhong"
								class="form-control" required="required" />
						</div> --%>
						<div class="mb-3">
							<label for="tongTien">Tổng tiền:</label>
							<form:input path="tongTien" id="tongTien" class="form-control"
								required="required" />
						</div>
						<div class="mb-3">
							<label for="trangThai">Trạng thái:</label>
							<form:input path="trangThai" id="trangThai" class="form-control"
								required="required" />
						</div>
						<input type="submit" value="Thuê phòng" class="btn btn-primary" />
						
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