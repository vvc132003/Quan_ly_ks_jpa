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
	<c:if test="${loggedInUser != null}">
		<div class="full_container">
			<div class="inner_container">
				<%@ include file="/WEB-INF/layout/header.jsp"%>
				<div id="content">
					<%@ include file="/WEB-INF/layout/navbar.jsp"%>
					<br>
					<div class="text-center" style="padding: 0px 23px;">
						<div class="square" style="background-color: #2387e0">
							<a>Phòng trống (${soPhongTrong})</a>
						</div>
						<div class="square" style="background-color: #489d41">
							<a>Phòng đã có người ở (${soPhongDangThue})</a>
						</div>
						<div class="square" style="background-color: #cfb890">
							<a>Phòng có người đặt (${soPhongDadat})</a>
						</div>
						<div class="square" style="background-color: #e7574d">
							<a>Phòng đang sửa chữa (${soPhongDangsuachua})</a>
						</div>
						<div class="square" style="background-color: #C0C0C0">
							<a>Phòng đang dọn dẹp (${soPhongDangchuadon})</a>
						</div>
					</div>
					<%@ include file="/WEB-INF/views/room.jsp"%>
				</div>
			</div>
		</div>
	</c:if>
</body>
</html>