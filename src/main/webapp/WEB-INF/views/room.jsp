<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<div class="midde_cont">

	<!-- Modal -->
	<div class="modal fade" id="paymentSuccessModal" tabindex="-1"
		role="dialog" aria-labelledby="paymentSuccessModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<p id="paymentSuccessMessage">${paymentSuccessMessage}</p>
					<p>Thanh toán thành công !!!</p>
					<i class="fas fa-check-circle fa-5x" style="color: green;"></i>
					<!-- Biểu tượng thành công -->
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="thuephongSuccessModal" tabindex="-1"
		role="dialog" aria-labelledby="thuephongSuccessModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<p id="thuephongSuccessMessage">${thuephongSuccessMessage}</p>
					<p>Thuê phòng thành công !!!</p>
					<i class="fas fa-thumbs-up fa-5x" style="color: green;"></i>
					<!-- Biểu tượng thành công -->
				</div>
			</div>
		</div>
	</div>


	<div style="padding: 0px 15px;">
		<form style="padding: 20px 15px;" action="listroom" method="GET">
			<label for="maPhong">Tìm kiếm phòng:</label> <input type="text"
				id="maPhong" name="maPhong"> <input type="submit"
				value="Search">
		</form>
		<div class="text">
			<div class="room-container">
				<c:forEach var="room" items="${rooms}" varStatus="status">
					<c:set var="statusClass">
						<c:choose>
							<c:when test="${room.tinhTrangPhong eq 'có khách'}">
                cokhach			
            </c:when>
							<c:when test="${room.tinhTrangPhong eq 'còn trống'}">
                controng
            </c:when>
							<c:when test="${room.tinhTrangPhong eq 'đang sửa chữa'}">
                dangsua
            </c:when>
							<c:when test="${room.tinhTrangPhong eq 'đã đặt'}">
                dadat
            </c:when>
							<c:when test="${room.tinhTrangPhong eq 'chưa dọn'}">
                chuadon
            </c:when>
							<c:otherwise>
                other
            </c:otherwise>
						</c:choose>
					</c:set>
					<div id="table-${status.index}" class="room-box ${statusClass}">
						<p>Số phòng: ${room.maPhong}</p>
						<p>Loại phòng: ${room.loaiPhong}</p>
						<p>Giá: ${room.giaTien}</p>
						<c:choose>
							<c:when test="${room.tinhTrangPhong eq 'có khách'}">
								<i class="fas fa-bed" style="color: white;"></i>
							</c:when>
							<c:when test="${room.tinhTrangPhong eq 'còn trống'}">
								<i class="fas fa-door-open" style="color: white;"></i>
							</c:when>
							<c:when test="${room.tinhTrangPhong eq 'đã đặt'}">
								<i class="fas fa-calendar-check" style="color: white;"></i>
							</c:when>
							<c:when test="${room.tinhTrangPhong eq 'đang sửa chữa'}">
								<i class="fas fa-wrench" style="color: white;"></i>
							</c:when>
							<c:when test="${room.tinhTrangPhong eq 'chưa dọn'}">
								<i class="fas fa-exclamation-circle" style="color: white;"></i>
							</c:when>
							<c:otherwise>
								<i class="fas fa-question-circle"></i>
							</c:otherwise>
						</c:choose>
						<div class="context-menu">
							<c:choose>
								<c:when test="${room.tinhTrangPhong eq 'có khách'}">
									<a href="rooms?roomId=${room.maPhong}"> <i
										class="fas fa-info-circle"
										style="color: red; font-size: 20px; margin-right: 5px;"></i>
										Thông tin thuê phòng
									</a>
								</c:when>
								<c:when test="${room.tinhTrangPhong eq 'còn trống'}">
									<a
										href="${pageContext.request.contextPath}/thuephong/thuephong?idPhong=${room.maPhong}"><i
										style="font-size: 20px; margin-right: 10px" class="fas fa-bed"></i>
										Thuê phòng</a>
									<a href="updatedangsuachua?maPhong=${room.maPhong}"><i
										style="font-size: 20px; margin-right: 14px"
										class="fas fa-wrench"></i> Sửa phòng</a>
								</c:when>
								<c:when test="${room.tinhTrangPhong eq 'đã đặt'}">
									<a
										href="${pageContext.request.contextPath}/thuephong/thongtinndatphong?roomId=${room.maPhong}"><i
										style="font-size: 20px; margin-right: 14px"
										class="fas fa-check-circle"></i>Check nhận phòng</a>
								</c:when>
								<c:when test="${room.tinhTrangPhong eq 'đang sửa chữa'}">
									<a href="updatecontrong?maPhong=${room.maPhong}"><i
										style="font-size: 20px; margin-right: 2px; color: blue;"
										class="fas fa-check"></i>Hoàn tất sửa chữa</a>
								</c:when>
								<c:when test="${room.tinhTrangPhong eq 'chưa dọn'}">
									<a href="updatecontrong?maPhong=${room.maPhong}"><i
										style="font-size: 20px; margin-right: 10px; color: blue;"
										class="fas fa-check"></i>Dọn xong</a>
									<a href="updatedangsuachua?maPhong=${room.maPhong}"><i
										style="font-size: 20px; margin-right: 10px"
										class="fas fa-wrench"></i> Sửa phòng</a>
								</c:when>
							</c:choose>
						</div>
					</div>
					<!-- Add a div to display student information -->
					<div class="student-info" id="student-info-${room.maPhong}"></div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>

<style>
.modal.fade.show {
	display: flex !important;
	align-items: center;
	justify-content: center;
	background: rgba(0, 0, 0, 0.5);
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	z-index: 9999;
	transition: opacity 0.3s ease;
}

.modal-content {
	background-color: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
	text-align: center;
	max-width: 1000px;
	width: 100%;
	text-align: center;
}

.modal-content p {
	font-size: 20px;
	font-weight: bold;
}

#paymentSuccessMessage {
	color: green;
}

#thuephongSuccessMessage {
	color: green;
}

.room-box .fa-bed {
	color: #00FF00; /* Màu sắc */
	font-size: 50px; /* Kích thước font */
	/* Thêm các thuộc tính khác tùy ý */
}

.room-box .fa-door-open {
	color: #FF0000;
	font-size: 50px;
}

.room-box .fa-calendar-check {
	color: #3498DB;
	font-size: 50px;
	/* Thêm các thuộc tính khác tùy ý */
}

.room-box .fa-wrench {
	color: #8B4513;
	font-size: 50px;
	/* Thêm các thuộc tính khác tùy ý */
}

.room-box .fa-exclamation-circle {
	color: #FF9900;
	font-size: 50px;
}

.room-box .fa-question-circle {
	color: #95A5A6;
	font-size: 50px;
	/* Thêm các thuộc tính khác tùy ý */
}

.cokhach {
	background-color: #009900;
	/* Màu đỏ cho phòng có người */
}

.controng {
	background-color: #0099CC;
	/* Màu xanh lá cây cho phòng trống */
}

.dangsua {
	background-color: #990033;
	/* Màu đỏ cho phòng có người */
}

.dadat {
	background-color: #660099;
	/* Màu đỏ cho phòng có người */
}

.chuadon {
	background-color: #C0C0C0;
}

p {
	color: white;
	font-size: 15px;
	font-weight: bold;
	text-align: center
}

.room-box:hover {
	background: rgb(255, 128, 0);
	color: #f9f9f9;
}
</style>
<style>
/* CSS cho container bao quanh biểu mẫu */
.search-container {
	padding: 10px 5px;
	background-color: #f5f5f5;
	border: 1px solid #ddd;
	border-radius: 5px;
	display: inline-block;
}

/* CSS cho nhãn */
label {
	font-weight: bold;
	font-size: 16px;
}

/* CSS cho trường nhập liệu */
input[type="text"] {
	width: 200px;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 16px;
}

/* CSS cho nút "Search" */
input[type="submit"] {
	padding: 10px 20px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
}

/* CSS cho nút "Search" khi được hover */
input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
<script>
    // JavaScript để hiển thị modal nếu có thông báo thành công
    $(document).ready(function() {
        var paymentSuccessMessage = "${paymentSuccessMessage}";

        if (paymentSuccessMessage !== "") {
            // Hiển thị modal và đặt nội dung thông báo
            $('#paymentSuccessMessage').text(paymentSuccessMessage);
            $('#paymentSuccessModal').modal('show');
        }
    });
</script>
<script>
	$(document).ready(function() {
	    var thuephongSuccessMessage = "${thuephongSuccessMessage}";

	    console.log("Debug: JavaScript executed."); // Add this line for debugging

	    if (thuephongSuccessMessage !== "") {
	        // Hiển thị modal và đặt nội dung thông báo
	        $('#thuephongSuccessMessage').text(thuephongSuccessMessage);
	        $('#thuephongSuccessModal').modal('show');
	    }
	});
</script>
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