<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<section class="accomodation_area section_gap">
	<div class="container">
		<div class="row">
			<c:forEach items="${rooms}" var="room" varStatus="status">
				<div class="col-3">
					<div class="accomodation_item text-center">
						<div class="accomodation_item text-center">
							<div class="hotel_img">
								<img
									src="https://149354439.v2.pressablecdn.com/wp-content/uploads/2013/08/home-2.jpg"
									alt=""> <a
									href="${pageContext.request.contextPath}/thuephong/datphong?idPhong=${room.maPhong}"
									class="btn theme_btn button_hover">Phòng ${room.maPhong}</a>
							</div>
							<a href="#"><h4 class="sec_h4">${room.loaiPhong}</h4></a>
							<h5>${room.giaTien}VNĐ</h5>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>