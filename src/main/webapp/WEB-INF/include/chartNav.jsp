<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/shepe/resources/admin.css/bootstrap.min.css">
</head>
<body>
<div class="container">  
<ul id="ChartButton1" class="nav nav-tabs" role="tablist">
		<li class="nav-item dropdown">
			<a id="10" class="nav-link dropdown-toggle" href="" data-toggle="dropdown">검색량 차트</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="searchChart">검색량 차트</a>
			</div>
		</li>
		<li class="nav-item dropdown">
			<a id="9" class="nav-link dropdown-toggle" href="" data-toggle="dropdown">봇 통계 차트</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="bootChart">봇 통계 차트 url</a>
			</div>
		</li>
	</ul>
</div>
<script>
  $(".nav-item > .nav-link").click(function(){
	var choice1 ="0";
    choice1 = this.id;   
    $(".nav-item > .nav-link").removeClass("active");
    sessionStorage.removeItem("choiceChart");
	sessionStorage.setItem("choiceChart", choice1);
	});
</script>

<script>
window.onload = function() {
	var choiceChart = sessionStorage.getItem("choiceChart");
	if(choiceChart == "ChartButton"  || choiceChart == null) {
		$("#10").addClass("active");
	}
	$("#"+choiceChart).addClass("active");
};
</script>

</body>
</html>