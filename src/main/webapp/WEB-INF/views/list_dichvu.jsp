<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dịch Vụ List</title>
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
					<h1 class="mt-5 mb-4 text-center">Danh sách Dịch Vụ</h1>
					<div class="d-flex justify-content-between">

						<a href="${pageContext.request.contextPath}/dichvu/dichvuform"
							class="btn btn-primary mb-4 ml-auto"><i class="fas fa-plus"></i>
							Thêm mới</a>
					</div>
					<div class="table-container">
						<table class="table table-striped" id="productTable">
							<thead>
								<tr>
									<th>ID</th>
									<th>Tên dịch vụ</th>
									<th>Mô tả</th>
									<th>Gía bán</th>
									<th>Ảnh</th>
									<th>Hành động</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${dichVus}" var="khoahoc" varStatus="status">
									<tr>
										<td>${status.index + 1}</td>
										<td>${khoahoc.tenDichVu}</td>
										<td>${khoahoc.moTa}</td>
										<td>${khoahoc.gia}</td>
										<td><img class="small-image" src="${khoahoc.image}"
											alt="Ảnh dịch vụ"></td>
										<td><a class="btn btn-danger"
											href="deleteDichVu?dichvuID=${khoahoc.maDichVu}"> <i
												class="fas fa-trash-alt"></i>
										</a> <a class="btn btn-warning"
											href="updateDichVu?dichvuID=${khoahoc.maDichVu}"><i
												class="fas fa-edit"></i></a></td>
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
	width: 50px;
	height: 50px;
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
	border: 1px solid #ccc; /
	padding: 8px;
}
</style>

	<!-- Add Bootstrap JavaScript and Popper.js via CDN (required for some Bootstrap features) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@2.9.3/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>