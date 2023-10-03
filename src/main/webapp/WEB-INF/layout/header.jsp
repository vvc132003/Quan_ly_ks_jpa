<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Sidebar  -->
<nav id="sidebar">
	<div class="sidebar_blog_1">
		<div class="sidebar-header">
			<div class="logo_section">
				<a href="index.html"><img class="logo_icon img-responsive"
					src="<c:out value="${image}" />" alt="#" /></a>
			</div>
		</div>
		<div class="sidebar_user_info">
			<div class="icon_setting"></div>
			<div class="user_profle_side">
				<div class="user_img">
					<img class="img-responsive" src="<c:out value="${image}" />"
						alt="#" />
				</div>
				<div class="user_info">
					<h6>
						<c:out value="${namee}" />
					</h6>
					<p>
						<span class="online_animation"></span> Online
					</p>
				</div>
			</div>
		</div>
	</div>
	<div class="sidebar_blog_2">
		<h4>General</h4>
		<ul class="list-unstyled components">
			<li class="active"><a href="#dashboard" data-toggle="collapse"
				aria-expanded="false" class="dropdown-toggle"><i
					class="fa fa-dashboard yellow_color"></i> <span>Dashboard</span></a>
				<ul class="collapse list-unstyled" id="dashboard">
					<li><a href="${pageContext.request.contextPath}/room/listroom">>
							<span>Dashboard</span>
					</a></li>
					<li><a href="dashboard_2.html">> <span>Dashboard
								style 2</span></a></li>
				</ul></li>
			<!-- nhân viên  -->
			<li><a href="${pageContext.request.contextPath}/room/listroom"><i
					class="fa fa-clock-o orange_color"></i> <span>Phòng</span></a></li>
			<li><a
				href="${pageContext.request.contextPath}/nhanvien/listnhanvien"><i
					class="fa fa-clock-o orange_color"></i> <span>Nhân Viên</span></a></li>
			<!-- KHÁCH HÀNG-->
			<li><a
				href="${pageContext.request.contextPath}/khachhang/listkhachhang"><i
					class="fa fa-paper-plane red_color"></i> <span>Khách Hàng</span></a></li>

			<!-- dịch vụ -->
			<li><a
				href="${pageContext.request.contextPath}/dichvu/listDichVu"><i
					class="fa fa-table purple_color2"></i> <span>Dịch vụ</span></a></li>
			<!--đơn -->

			<li><a href="#apps" data-toggle="collapse" aria-expanded="false"
				class="dropdown-toggle"><i
					class="fa fa-object-group blue2_color"></i> <span>Các loại
						đơn</span></a>
				<ul class="collapse list-unstyled" id="apps">
					<li><a href="email.html">> <span>Đơn nhận phòng</span></a></li>
					<li><a href="calendar.html">> <span>Đơn đặt phòng</span></a></li>
					<li><a href="media_gallery.html">> <span>Đơn thuê
								phòng </span></a></li>
				</ul></li>

			<li><a href="charts.html"><i
					class="fa fa-bar-chart-o green_color"></i> <span>Thống kê</span></a></li>
			<li><a href="${pageContext.request.contextPath}/room/logout"><i
					class="fa fa-cog yellow_color"></i> <span>Logout</span></a></li>
		</ul>
	</div>
</nav>