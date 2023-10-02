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
					<h1 class="mt-5 mb-4 text-center">Thống kê</h1>
					<div class="table-container">
						<c:forEach items="${thongKeData}" var="row">
							<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
							<script>
								var thongKeData = $
								{
									thongKeData
								}; // Dữ liệu từ Controller

								var labels = [];
								var data = [];

								thongKeData.forEach(function(row) {
									labels.push(row[0]);
									data.push(row[1]);
								});

								var ctx = document.getElementById("pieChart")
										.getContext("2d");
								var pieChart = new Chart(ctx, {
									type : "pie",
									data : {
										labels : labels,
										datasets : [ {
											data : data,
											backgroundColor : [ "#FF5733",
													"#33FF57", "#3366FF",
													"#FF33FF", "#FFFF33" ]
										} ]
									},
									options : {
										responsive : true
									}
								});
							</script>

						</c:forEach>
					</div>
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