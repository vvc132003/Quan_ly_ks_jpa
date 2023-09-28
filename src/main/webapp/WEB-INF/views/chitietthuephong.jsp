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
					<div class="col-6"></div>
					<div class="col-6">
						<table>
							<thead>
								<tr>
									<th>ID Phiếu Thuê</th>
									<th>Tên Phiếu Thuê</th>
									<th>status</th>
									<th>ID ROOM</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="phieuThuePhong" items="${phieuThuePhongList}">
									<tr>
										<td>${phieuThuePhong.id_thue}</td>
										<td>${phieuThuePhong.name}</td>
										<td>${phieuThuePhong.status}</td>
										<td>${phieuThuePhong.room.id}</td>
									</tr>
									<a
										href="updatedangsuachua?roomId=${phieuThuePhong.room.id}&idthue=${phieuThuePhong.id_thue}">Hoàn
										tất sửa chữa và Cập nhật trạng thái thuê</a>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>