<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <title>Lady bug</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/shepe/resources/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
  <link rel="stylesheet" href="/shepe/resources/chatcss/search.css" />
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/include/Nav.jsp" />
	<div class="content">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="search-result-box card-box">
                    <!-- end row -->
                    <ul class="nav nav-tabs tabs-bordered">
                        <li class="nav-item"><a href="#home" data-toggle="tab" aria-expanded="true" class="nav-link active">레시피 <span class="badge badge-success ml-1">50</span></a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <div class="row">
									<div class="col-md-12">
										
										<c:forEach items="${search_reList}" var="reList">
											<div class="search-item">
											<div class="media">
												<img class="d-flex mr-3 img-thumbnail"
													src="/shepe/resources/img/${reList.recipe_complete_img}" height="54"
													style="width: 255px; height: 350px;">
												<div class="media-body">
													<h5 class="media-heading mt-0">
														<a href="#" class="text-dark">${reList.recipe_nm}</a>
													</h5>
													<p class="font-13">
														<b>category:</b> <span><a href="#" class="text-muted">${reList.recipe_category_kind}</a></span>
													</p>
													<p class="mb-0 font-13">
														<b>info:</b> <br>
														<span class="text-muted">${reList.recipe_info}</span>
													</p>
												</div>
											</div>
										</div>
										</c:forEach>
										
										

										<ul
											class="pagination justify-content-end pagination-split mt-0">
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Previous"><span aria-hidden="true">«</span>
													<span class="sr-only">Previous</span></a></li>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Next"><span aria-hidden="true">»</span> <span
													class="sr-only">Next</span></a></li>
										</ul>
									</div>
									<ul class="nav nav-tabs tabs-bordered">
										<li class="nav-item"><a href="#home" data-toggle="tab"
											aria-expanded="true" class="nav-link active">식재료
												<span class="badge badge-success ml-1">50</span>
										</a></li>
									</ul>
									
									<div class="tab-content">
		
									<c:forEach items="${search_inList}" var="inList">
									<div class="search-item">
                                        <h4 class="mb-1"><a href="#">${inList.ingredient_nm}</a></h4>
                                        <div class="font-13 text-success mb-3">https://www.bootdey.com</div>
                                        <p class="mb-0 text-muted">Dolor posuere proin blandit accumsan senectus netus nullam curae, ornare laoreet adipiscing luctus mauris adipiscing pretium eget fermentum, tristique lobortis est ut metus lobortis tortor tincidunt himenaeos habitant quis dictumst proin odio sagittis purus mi, nec taciti vestibulum quis in sit varius lorem sit metus mi.</p>
                                    </div>
									</c:forEach>

                                    <ul class="pagination justify-content-end pagination-split mt-0">
                                        <li class="page-item"><a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">«</span> <span class="sr-only">Previous</span></a></li>
                                        <li class="page-item"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">»</span> <span class="sr-only">Next</span></a></li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end All results tab -->
                    </div>
                </div>
            </div>
        </div>
        <!-- end row -->
    </div>
    <!-- container -->
</div>

</body>
</html>