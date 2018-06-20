<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="fakeLoader"></div>
<nav class="navbar header-top fixed-top navbar-expand-lg navbar-dark bg-primary center">
	<span class="navbar-toggler-icon leftmenutrigger "></span>
	<a class="navbar-brand nav-link " href="#">동아리 채널</a>
	<button class="navbar-toggler text-white" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarText">
		<ul class="navbar-nav animate side-nav">
			<li class="nav-item dropdown">
				<a class="nav-link text-white" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="false" aria-expanded="false">
					<i class="fas fa-users"></i> 모임 <i class="fas fa-users	shortmenu animate"></i>
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown1">
					<div class="list-group">
						<a href="#" class="list-group-item list-group-item-action">문화</a>
						<a href="#" class="list-group-item list-group-item-action">여행</a>
					</div>
				</div>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link  text-white" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fas fa-bicycle"></i>스포츠<i class="fas fas fa-bicycle shortmenu animate"></i>
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown2">
					<div class="list-group">
						<a href="#" class="list-group-item list-group-item-action">축구</a>
						<a href="#" class="list-group-item list-group-item-action">야구</a>
						<a href="#" class="list-group-item list-group-item-action">자전거</a>
					</div>
				</div>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link text-white" href="#" id="navbarDropdown3" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fas fa-building"></i> 강의 <i class="fas fa-building shortmenu animate"></i>
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-white" href="#" title="Comment">
					<i class="fas fa-building"></i> 소개 <i class="fas fa-building shortmenu animate"></i>
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-white test" href="#" title="Comment">
					<i class="fas fa-building "></i> 소개 <i class="fas fa-building shortmenu animate"></i>
				</a>
			</li>
		</ul>
		<!-- 로그인 Start -->
		<ul class="navbar-nav ml-md-auto d-md-flex">
			<c:choose>
				<c:when test="${sessionScope.ss_id eq null}">
					<li class="nav-item">
						<a class="nav-link text-white" href="http://localhost:8080/login">
							<i class="fas fa-sign-in-alt"></i> Login
						</a>
					</li>
				</c:when>
				<c:when test="${sessionScope.ss_id ne null}">
					<li class="nav-item">
						<a class="nav-link text-white" href="#">
							<i class="fas fa-address-book"></i>
							<c:out value="${sessionScope.ss_id}" />
							님
						</a>
					</li>
					<li class="nav-item">
						<a class="nav-link text-white" href="http://localhost:8080/logout">
							<i class="fas fa-sign-in-alt"></i> Logout
						</a>
					</li>
				</c:when>
			</c:choose>
		</ul>
		<!-- 로그인 End -->
	</div>
</nav>
<script>

	
	function loading() {
		$("#fakeLoader").fakeLoader({
			timeToHide : 1000, //Time in milliseconds for fakeLoader disappear
			zIndex : 999, // Default zIndex
			spinner : "spinner2",//Options: 'spinner1', 'spinner2', 'spinner3', 'spinner4', 'spinner5', 'spinner6', 'spinner7' 
			bgColor : "#dcdcdc" //Hex, RGB or RGBA colors
		});
	}
		
	
	$(window).on('load',loading());
</script>