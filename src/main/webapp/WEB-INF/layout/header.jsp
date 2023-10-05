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
		<h4>
			<i class="fas fa-home text-primary"></i> Trang chủ
		</h4>
		<ul class="list-unstyled components">
			<%-- <li class="active"><a href="#dashboard" data-toggle="collapse"
				aria-expanded="false" class="dropdown-toggle"><i
					class="fa fa-dashboard yellow_color"></i> <span>Dashboard</span></a>
				<ul class="collapse list-unstyled" id="dashboard">
					<li><a href="${pageContext.request.contextPath}/room/listroom">>
							<span>Dashboard</span>
					</a></li>
					<li><a href="dashboard_2.html">> <span>Dashboard
								style 2</span></a></li>
				</ul></li> --%>
			<!-- nhân viên  -->
			<li><a href="${pageContext.request.contextPath}/room/listroom"><i
					class="fas fa-bed orange_color"></i> <span>Phòng</span></a></li>
			<li><a
				href="${pageContext.request.contextPath}/nhanvien/listnhanvien"><i
					class="fas fa-user orange_color"></i> <span>Nhân Viên</span></a></li>

			<!-- KHÁCH HÀNG-->
			<li><a
				href="${pageContext.request.contextPath}/khachhang/listkhachhang"><i
					class="fas fa-user-tie red_color"></i> <span>Khách Hàng</span></a></li>

			<!-- dịch vụ -->
			<li><a
				href="${pageContext.request.contextPath}/dichvu/listDichVu"><i
					class="fas fa-concierge-bell purple_color2"></i> <span>Dịch
						vụ</span></a></li>

			<!--đơn -->

			<li><a href="#apps" data-toggle="collapse" aria-expanded="false"
				class="dropdown-toggle"><i
					class="fa fa-object-group blue2_color"></i> <span>Các loại
						đơn</span></a>
				<ul class="collapse list-unstyled" id="apps">
					<li><a
						href="${pageContext.request.contextPath}/thuephong/listthuephong"><i
							class="fas fa-file-alt blue2_color"></i> <span>Đơn thuê
								phòng</span></a></li>

					<li><a
						href="${pageContext.request.contextPath}/nhanphong/listnhanphong"><i
							class="fas fa-file-invoice blue2_color"></i> <span>Đơn
								nhận phòng</span></a></li>
					<li><a
						href="${pageContext.request.contextPath}/traphong/listtraphong"><i
							class="fas fa-file-signature blue2_color"></i> <span>Đơn
								trả phòng</span></a></li>
				</ul></li>
			<li><a
				href="${pageContext.request.contextPath}/thuephong/thong-ke-theo-thang"><i
					class="fa fa-bar-chart-o green_color"></i> <span>Thống kê</span></a></li>
			<li><a href="${pageContext.request.contextPath}/room/logout"><i
					class="fas fa-sign-out-alt yellow_color"></i> <span>Đăng
						Xuất</span></a></li>
		</ul>
	</div>
</nav>
<style>
span {
	color: white;
	font-weight: 600;
}
</style>