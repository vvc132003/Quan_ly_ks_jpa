<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="midde_cont">
	<div style="padding: 22px 38px;">
		<div class="text">
			<div class="room-container">
				<c:forEach var="room" items="${rooms}" varStatus="status">
					<c:set var="statusClass">
						<c:choose>
							<c:when test="${room.status eq 'có khách'}">
                cokhach			
            </c:when>
							<c:when test="${room.status eq 'còn trống'}">
                controng
            </c:when>
							<c:when test="${room.status eq 'đang sửa chữa'}">
                dangsua
            </c:when>
							<c:when test="${room.status eq 'đã đặt'}">
                dadat
            </c:when>
							<c:when test="${room.status eq 'chưa dọn'}">
                chuadon
            </c:when>
							<c:otherwise>
                other
            </c:otherwise>
						</c:choose>
					</c:set>
					<div id="table-${status.index}" class="room-box ${statusClass}">
						<p>Số phòng: ${room.id}</p>
						<p>Loại phòng: ${room.room_name}</p>
						<p>Giá: ${room.price}</p>
						<c:choose>
							<c:when test="${room.status eq 'có khách'}">
								<i class="fas fa-bed"></i>
							</c:when>
							<c:when test="${room.status eq 'còn trống'}">
								<i class="fas fa-door-open"></i>
							</c:when>
							<c:when test="${room.status eq 'đã đặt'}">
								<i class="fas fa-calendar-check"></i>
							</c:when>
							<c:when test="${room.status eq 'đang sửa chữa'}">
								<i class="fas fa-wrench"></i>
							</c:when>
							<c:when test="${room.status eq 'chưa dọn'}">
								<i class="fas fa-exclamation-circle"></i>
							</c:when>
							<c:otherwise>
								<i class="fas fa-question-circle"></i>
							</c:otherwise>
						</c:choose>
						<div class="context-menu">
							<c:choose>
								<c:when test="${room.status eq 'có khách'}">
									<a href="rooms?roomId=${room.id}">Xem Phiếu Thuê Phòng</a>
								</c:when>
								<c:when test="${room.status eq 'còn trống'}">
									<a href="updatestartroom?roomId=${room.id}">Thuê phòng</a>
<%-- 									<a href="updatestartroom?roomId=${room.id}">Thuê phòng</a>
 --%>								</c:when>
								<c:when test="${room.status eq 'đã đặt'}">
									<a href="" data-bs-toggle="modal" data-bs-target="#addModall"
										class="rent-room-link" data-room-id="${room.id}">Check
										nhận phòng</a>
								</c:when>
								<c:when test="${room.status eq 'đang sửa chữa'}">
									<a href="updatecontrong?roomId=${room.id}">Hoàn tất sửa
										chữa</a>
								</c:when>
							</c:choose>
						</div>
					</div>
					<!-- Add a div to display student information -->
					<div class="student-info" id="student-info-${room.id}"></div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>

<style>
/* CSS cho biểu tượng trong trạng thái 'có khách' */
.room-box .fa-bed {
	color: #00FF00; /* Màu sắc */
	font-size: 50px; /* Kích thước font */
	/* Thêm các thuộc tính khác tùy ý */
}

/* CSS cho biểu tượng trong trạng thái 'còn trống' */
.room-box .fa-door-open {
	color: #FF0000;
	font-size: 50px;
	/* Thêm các thuộc tính khác tùy ý */
}

/* CSS cho biểu tượng trong trạng thái 'đã đặt' */
.room-box .fa-calendar-check {
	color: #3498DB;
	font-size: 50px;
	/* Thêm các thuộc tính khác tùy ý */
}

/* CSS cho biểu tượng trong trạng thái 'đang sửa chữa' */
.room-box .fa-wrench {
	color: #8B4513;
	font-size: 50px;
	/* Thêm các thuộc tính khác tùy ý */
}

/* CSS cho biểu tượng trong trạng thái 'chưa dọn' */
.room-box .fa-exclamation-circle {
	color: #FF9900;
	font-size: 50px;
	/* Thêm các thuộc tính khác tùy ý */
}

/* CSS mặc định cho biểu tượng nếu không khớp với bất kỳ trạng thái nào */
.room-box .fa-question-circle {
	color: #95A5A6;
	font-size: 50px;
	/* Thêm các thuộc tính khác tùy ý */
}
</style>
<script type="text/javascript">
//JavaScript to handle opening the modal and populating the room ID
const modal = document.getElementById('roomModal');
const span = document.getElementsByClassName('close')[0];

// When the "Thuê phòng" link is clicked
const rentRoomLinks = document.getElementsByClassName('rent-room-link');
Array.from(rentRoomLinks).forEach(link => {
	link.addEventListener('click', function(event) {
		event.preventDefault();
		const roomId = this.getAttribute('data-room-id');
		const roomIdd = this.getAttribute('data-room-id');
		document.getElementById('roomid').value = roomId;
		document.getElementById('roomidd').value = roomIdd; 
	});
});

</script>