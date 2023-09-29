<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<form:form method="post" action="loginn" modelAttribute="nhanVien">
		<table>
			<tr>
				<td><label for="taiKhoan">Username:</label></td>
				<td><form:input type="text" path="taiKhoan" id="taiKhoan"
						required="true" /></td>
			</tr>
			<tr>
				<td><label for="matKhau">Password:</label></td>
				<td><form:password path="matKhau" id="matKhau" required="true" /></td>
			</tr>
		</table>
		<input type="submit" value="Login" />
	</form:form>
	<style>
body {
	background-color: #f2f2f2;
	font-family: Arial, sans-serif;
}

/* Tạo khung cho form đăng nhập */
form {
	background-color: #ffffff;
	border: 1px solid #ccc;
	border-radius: 5px;
	width: 300px;
	margin: 0 auto;
	padding: 20px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

/* Thiết lập kiểu cho tiêu đề */
h2 {
	text-align: center;
	color: #333;
}

/* Thiết lập kiểu cho các trường nhập liệu */
label {
	display: block;
	margin-bottom: 8px;
	font-weight: bold;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

/* Thiết lập kiểu cho nút đăng nhập */
input[type="submit"] {
	background-color: #007bff;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

/* Kiểu cho thông báo lỗi */
.error-message {
	color: #ff0000;
	font-size: 14px;
}
</style>
</body>
</html>
