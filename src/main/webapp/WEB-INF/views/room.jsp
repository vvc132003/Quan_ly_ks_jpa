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
                reserved			
            </c:when>
							<c:when test="${room.status eq 'còn trống'}">
                available
            </c:when>
							<c:when test="${room.status eq 'đang sửa chữa'}">
                under-repair
            </c:when>
							<c:when test="${room.status eq 'đã đặt'}">
                booked
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
						<div class="context-menu">
							<c:choose>
								<c:when test="${room.status eq 'có khách'}">
									<a href="<c:url value='/room/students/${room.id}'/>">Xem
										thông tin thuê phòng</a>
								</c:when>
								<c:when test="${room.status eq 'còn trống'}">
									<a href="" data-bs-toggle="modal" data-bs-target="#addModal"
										class="rent-room-link" data-room-id="${room.id}">Thuê
										phòng</a>
								</c:when>
								<c:when test="${room.status eq 'đã đặt'}">
									<a href="" data-bs-toggle="modal" data-bs-target="#addModall"
										class="rent-room-link" data-room-id="${room.id}">Check
										nhận phòng</a>
								</c:when>
								<c:when test="${room.status eq 'đang sửa chữa'}">
									<a href="" data-bs-toggle="modal" data-bs-target="#addModall"
										class="rent-room-link" data-room-id="${room.id}">Hoàn tất
										sửa chữa</a>
								</c:when>
							</c:choose>
						</div>
					</div>
					<!-- Add a div to display student information -->
					<div class="student-info" id="student-info-${room.id}"></div>
				</c:forEach>

			</div>
			<!-- Add Product Modal -->
			<div class="modal fade" id="addModal" tabindex="-1"
				aria-labelledby="addModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="addModalLabel">Nhập thông tin
								sinh viên muốn thuê phòng</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<form action="studentController" method="POST">
								<input type="text" name="roomid" id="roomid" />
								<div class="row">
									<div class="col-6">
										<div class="mb-3">
											<label for="student_id" class="form-label">Mã sinh
												viên:</label> <input type="text" class="form-control"
												id="student_id" name="student_id">
										</div>
										<div class="mb-3">
											<label for="student_name" class="form-label">Họ tên
												sinh viên:</label> <input type="text" class="form-control"
												id="student_name" name="student_name">
										</div>
										<div class="mb-3">
											<label for="faculty" class="form-label">Khoa:</label> <select
												class="form-select" id="faculty" name="faculty">
												<option selected disabled>Chọn khoa</option>
												<option value="CN-KD">CN-KD</option>
												<option value="DL-LH">DL-LH</option>
											</select>
										</div>
										<div class="mb-3">
											<label for="major" class="form-label">Ngành:</label> <select
												class="form-select" id="major" name="major">
												<option selected disabled>Chọn ngành</option>
												<option value="Công nghệ thông tin">Công nghệ thông
													tin</option>
												<option value="Công nghệ ô tô">Công nghệ ô tô</option>
											</select>
										</div>
										<div class="mb-3">
											<label for="birth_date" class="form-label">Ngày sinh:</label>
											<input type="date" class="form-control" id="birth_date"
												name="birth_date">
										</div>
									</div>
									<div class="col-6">
										<div class="mb-3">
											<label for="phone_number" class="form-label">SĐT:</label> <input
												type="text" class="form-control" id="phone_number"
												name="phone_number">
										</div>
										<div class="mb-3">
											<label for="hometown" class="form-label">Địa chỉ:</label> <input
												type="text" class="form-control" id="hometown"
												name="hometown">
										</div>
										<div class="mb-3">
											<label for="gender" class="form-label">Gioi tính:</label> <select
												class="form-select" id="gender" name="gender">
												<option selected disabled>Chọn giới tính</option>
												<option value="Nam">Nam</option>
												<option value="Nữ">Nữ</option>
											</select>
										</div>
										<div class="mb-3">
											<label for="id_card" class="form-label">Gmail:</label> <input
												type="text" class="form-control" id="id_card" name="id_card">
										</div>
										<div class="mb-3">
											<label for="check_in_date" class="form-label">Ngày
												vào:</label> <input type="date" class="form-control"
												id="check_in_date" name="check_in_date">
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn " style="background: red;"
										data-bs-dismiss="modal">Huỷ</button>
									<button type="submit" style="background: rgb(0, 128, 0);"
										class="btn">Thuê phòng</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- Add Product Modal -->
			<div class="modal fade" id="addModall" tabindex="-1"
				aria-labelledby="addModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="addModalLabel">Nhập thông tin
								phòng</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<form action="addphongConntroller" method="POST">
								<div class="mb-3">
									<label for="roomid" class="form-label">Mã phòng:</label> <input
										type="text" class="form-control" name="roomid" id="roomid" />
								</div>
								<div class="mb-3">
									<label for="room_type" class="form-label">Loại phòng:</label> <select
										class="form-select" id="room_type" name="room_type">
										<option selected disabled>Chọn phòng</option>
										<option value="VIP">VIP</option>
										<option value="THƯỜNG">THƯỜNG</option>
									</select>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn " style="background: red;"
										data-bs-dismiss="modal">Huỷ</button>
									<button type="submit" style="background: rgb(0, 128, 0);"
										class="btn">Thêm phòng</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
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
