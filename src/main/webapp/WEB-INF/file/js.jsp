<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="<c:url value='/resources/js/jquery.min.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
<script
	src="https://cdn.jsdelivr.net/npm/perfect-scrollbar@1.5.2/dist/perfect-scrollbar.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		var ps = new PerfectScrollbar('#sidebar');
	});
</script>
<script src="<c:url value='/resources/js/custom.js' />"></script>

<script type="text/javascript">
	$(document).ready(function() {
		var table = $('#productTable').DataTable({
			"pagingType" : "simple_numbers",
			"language" : {
				"paginate" : {
					"next" : '<i class="fas fa-chevron-right"></i>',
					"previous" : '<i class="fas fa-chevron-left"></i>'
				},
				"info" : "",
				"lengthMenu" : "",
				"search" : "Tìm kiếm:",
				"emptyTable" : "Không có dữ liệu phù hợp"
			}
		});
	});
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>
