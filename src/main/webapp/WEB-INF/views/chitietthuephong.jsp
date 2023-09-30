<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						</div><hr>
						<div class="text-bg-success  p-2">Chi tiết dịch vụ</div>
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
						
					</div>
					
					
					
					
					<!--dịch vụ  -->
					<div class="col-5">
					<div class="text-bg-primary p-2">Thêm dịch vụ</div>
						<c:forEach var="dichVu" items="${dichVus}" varStatus="status">
							<div id="dichvu" class="text-color:black">
								<p class="p">${dichVu.tenDichVu}</p>
								<p class="p">${dichVu.gia}</p>
								<p class="p">${room.giaTien}</p>
								<img src="${dichVu.image}" alt="${dichVu.tenDichVu}" />
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
    color: rgb(0 0 0);
    font-size: 20px;
}

</style>
</html>