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
<!-- Đưa script thư viện Chart.js lên trước -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels"></script>

</head>
<body class="dashboard dashboard_1">
	<div class="full_container">
		<div class="inner_container">
			<%@ include file="/WEB-INF/layout/header.jsp"%>
			<div id="content">
				<%@ include file="/WEB-INF/layout/navbar.jsp"%>
				<br> <br>
				<div class="container">
					<canvas id="doanhThuChart" width="900" height="200"></canvas>
					<c:set var="data" value="${data}" />
					<div class="row">
						<div class="col-5">
							<table class="table">
								<thead>
									<tr>
										<th>Tên Dịch Vụ</th>
										<th>Tổng Thành tiền</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${maDichVu}" var="thueDichVu">
										<tr>
											<td>${thueDichVu[0]}</td>
											<td>${thueDichVu[1]}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
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
	<script>
        // Lấy dữ liệu từ biến data và chuyển thành mảng JavaScript
        var doanhThuData = [];
        <c:forEach items="${data}" var="item">
            doanhThuData.push({ thang: '${item[0]}', doanhThu: ${item[1]} });
        </c:forEach>

        // Lấy context của biểu đồ doanh thu
        var ctxDoanhThu = document.getElementById('doanhThuChart').getContext('2d');

        // Tạo mảng chứa tên tháng
        var labelsDoanhThu = doanhThuData.map(function(item) {
            return item.thang;
        });

        // Tạo mảng chứa doanh thu
        var valuesDoanhThu = doanhThuData.map(function(item) {
            return item.doanhThu;
        });

        var doanhThuChartData = {
        	    labels: labelsDoanhThu.map(function(item) {
        	        var dataItem = doanhThuData.find(function(data) {
        	            return data.thang === item;
        	        });
        	        return 'Tháng ' + dataItem.thang;
        	    }),
        	    datasets: [{
        	        label: 'Doanh thu',
        	        data: valuesDoanhThu,
        	        backgroundColor: '#0099FF', // Màu nền
        	        borderColor: '#0099FF', // Màu viền
        	        borderWidth: 1
        	    }]
        	};

        var myBarChartDoanhThu = new Chart(ctxDoanhThu, {
            type: 'bar',
            data: doanhThuChartData,
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                },
                plugins: {
                    legend: {
                        display: true // Hiển thị chú thích
                    },
                    datalabels: { // Cấu hình chú thích
                        display: true,
                        anchor: 'end',
                        align: 'top',
                        font: {
                            size: 12,
                        },
                        formatter: function(value, context) {
                            var dataItem = doanhThuData[context.dataIndex];
                            var month = dataItem.thang; 
                            var day = dataItem.ngay; 

                            return 'Tháng ' + month + ', Ngày ' + day + ': ' + value + ' VNĐ';
                        }
                    }
                },
                layout: {
                    padding: {
                        left: 10,
                        right: 10,
                        top: 10,
                        bottom: 10
                    }
                }
            }
        });
    </script>
</body>
</html>
