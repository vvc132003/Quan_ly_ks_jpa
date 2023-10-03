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
					<div style="text-align: center">
						<div class="square" style="background-color: #0099CC">
							<a>Còn trống</a>
						</div>
						<div class="square" style="background-color: #009900">
							<a>Có khách</a>
						</div>
						<div class="square" style="background-color: #660099">
							<a>Khách đặt</a>
						</div>
						<div class="square" style="background-color: #990033">
							<a>Đang sửa chữa</a>
						</div>
						<div class="square" style="background-color: #C0C0C0">
							<a>Chưa dọn</a>
						</div>
					</div>
					<%@ include file="/WEB-INF/views/room.jsp"%>
				</div>
			</div>
		</div>
	</c:if>
</body>
</html>