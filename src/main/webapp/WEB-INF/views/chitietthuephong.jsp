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
						<div class="row">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>ID</th>
										<th>Tên khách hàng</th>
										<th>Ngày nhận phòng</th>
										<th>Ngày trả phòng</th>
										<th>Tổng tiền</th>
										<th>Trạng thái</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${phieuThuePhongList}" var="phieuThuePhong">
										<tr>
											<td>${phieuThuePhong.maThuePhong}</td>
											<td>${phieuThuePhong.khachHang.hoVaTenDem}</td>
											<td>${phieuThuePhong.ngayNhanPhong}</td>
											<td>${phieuThuePhong.ngayTraPhong}</td>
											<td>${phieuThuePhong.tongTien}</td>
											<td>${phieuThuePhong.trangThai}</td>
											<td><a
												href="updateDichVu?dichvuID=${phieuThuePhong.maThuePhong}">Trả
													phòng</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<hr>




						<div class="text-bg-success  p-2">Chi tiết dịch vụ</div>
						<div class="row">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>ID</th>
										<th>Số lượng</th>
										<th>Tên dịch vụ</th>
										<th>Tên nhân viên</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${thueDichVus}" var="thueDichVu">
										<tr>
											<td>${thueDichVu.maThueDichVu}</td>
											<td>${thueDichVu.soLuong}</td>
											<td>${thueDichVu.dichVu.tenDichVu}</td>
											<td>${thueDichVu.nhanVien.hoVaTenDem}</td>
											<c:forEach items="${phieuThuePhongList}" var="phieuThuePhong">
												<td><a
													href="deleteThueDichVu?thuedichvuID=${thueDichVu.maThueDichVu}&maPhong=${phieuThuePhong.phong.maPhong}">Delete</a></td>
											</c:forEach>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>


					<!--dịch vụ  -->
					<div class="col-5">
						<div class="text-bg-primary sss p-2">Chi tiết dịch vụ</div>
						<c:forEach var="dichVu" items="${dichVus}" varStatus="status">
							<div class="hhh">
								<div class="card" style="width: 10rem;">
									<img src="${dichVu.image}" alt="${dichVu.tenDichVu}"
										style="width: 50%; height: 50px" />
									<div class="card-body text-center" id="dichvu">
										<h5 class="p">${dichVu.tenDichVu}</h5>
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
												<button type="submit">Thuê dịch vụ</button>
											</c:forEach>
										</form:form>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<style>
#dichvu .p {
	color: rgb(0, 0, 0);
	font-size: 20px;
}
</style>
</html>