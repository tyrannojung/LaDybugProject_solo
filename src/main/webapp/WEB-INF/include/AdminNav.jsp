<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lady bug</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/shepe/resources/admin.css/bootstrap.min.css">
</head>
<body>
<div class="container">  
  <ul class="nav nav-tabs">
    <li class="nav-item">
      <a class="nav-link" href="#">회원 리스트</a>
    </li>
    <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">상담하기</a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="index">Message 리스트</a>
      <a class="dropdown-item" href="messageBoot">Message봇</a>
    </div>
  </li>
  <li class="nav-item">
      <a class="nav-link" href="#">식재료</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">레시피</a>
    </li>
    <li class="nav-item">
      <a id="ChartButton" class="nav-link" href="searchChart">통계</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="getFaqList.do">FAQ</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">공지사항</a>
    </li>
  </ul>
 
</div>


</body>
</html>