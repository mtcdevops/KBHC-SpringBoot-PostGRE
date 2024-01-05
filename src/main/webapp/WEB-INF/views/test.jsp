<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="/WEB-INF/views/include/common/head.jsp" %>

<body class="bg-theme bg-theme1">

<%@ include file="/WEB-INF/views/include/common/sidebar.jsp" %>
<%@ include file="/WEB-INF/views/include/common/header.jsp" %>

<!-- Start wrapper-->
<div id="wrapper">
<div class="content-wrapper">

	<!-- Start Contents -->
	<h2>Adjust Speed</h2>

	<label for="speedInterval">초당 실행횟수: </label>
	<input type="number" id="speedInterval" min="0" value="100">
	<button onclick="adjustSpeed()">Adjust Speed</button>
	<!-- End Contents -->
	
	<!--start overlay-->
	<div class="overlay toggle-menu"></div>
	<!--end overlay-->
		
</div><!--End content-wrapper-->
<%@ include file="/WEB-INF/views/include/common/footer.jsp" %>
</div><!--End wrapper-->

<%@ include file="/WEB-INF/views/include/common/commonJS.jsp" %>
<script>
function adjustSpeed() {
	console.log("TEST");
	var interval = $("#speedInterval").val();
	
	$.ajax({
		type: 'GET',
		url: '/speed',
		data: { interval: interval },
		success: function(response) {
			alert(response);
		},
		error: function(error) {
			alert('Error adjusting speed: ' + error.responseText);
		}
	});
}
</script>
</body>
</html>
