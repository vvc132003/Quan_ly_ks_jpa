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
					<h1 class="mt-5 mb-4 text-center">Thêm Dịch Vụ</h1>
					<form:form action="addDichVu" method="post" modelAttribute="dichVu">
						<form:hidden path="maDichVu" />
						<div class="mb-3">
							<form:label path="tenDichVu" class="form-label">Tên dịch vụ:</form:label>
							<form:input path="tenDichVu" class="form-control" />
							<form:errors path="tenDichVu" class="text-danger" />
						</div>
						<div class="mb-3">
							<form:label path="moTa" class="form-label">Mô tả:</form:label>
							<form:input path="moTa" class="form-control" />
							<form:errors path="moTa" class="text-danger" />
						</div>
						<div class="mb-3">
							<form:label path="gia" class="form-label">Gía bán:</form:label>
							<form:input type="number" path="gia" class="form-control" />
							<form:errors path="gia" class="text-danger" />
						</div>
						<div class="mb-3">
							<form:label path="image" class="form-label">Image:</form:label>
							<form:input path="image" class="form-control" />
							<form:errors path="image" class="text-danger" />
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