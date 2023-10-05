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
<link rel="stylesheet"
	href="<c:url value='/resources/css/style1.css' />" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/responsive.css' />" />
</head>
<body>
<%-- 	<%@ include file="/WEB-INF/layout/headerhome.jsp"%>
 --%>	<div style="padding: 0px 500px;">
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
	<br>
</body>
<script src="<c:url value='/resources/js/jquery-3.2.1.min.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/resources/js/custom.js' />"></script>
</html>