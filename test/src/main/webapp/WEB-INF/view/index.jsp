<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="http://localhost:8080/webjars/jquery/3.2.1/dist/jquery.min.js"></script>
<link href="http://localhost:8080/webjars/bootstrap/4.0.0/dist/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="http://localhost:8080/webjars/bootstrap/4.0.0/dist/js/bootstrap.min.js"></script>
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<link href="http://localhost:8080/css/main.css" rel="stylesheet">
<script src="http://localhost:8080/js/main.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>동아리채널</title>
</head>
<body>

	<div id="wrapper" class="animate">
		<nav class="navbar header-top fixed-top navbar-expand-lg navbar-dark bg-primary center"> <span class="navbar-toggler-icon leftmenutrigger "></span> <a class="navbar-brand nav-link " href="#">동아리 채널</a>
		<button class="navbar-toggler text-white" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav animate side-nav">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<i class="fas fa-users"></i> 모임 <i class="fas fa-users	 shortmenu animate"></i>
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown1">
						<div class="list-group">
							<a href="#" class="list-group-item list-group-item-action">문화</a>
							<a href="#" class="list-group-item list-group-item-action">여행</a>
						</div>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
					<a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown3" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<i class="fas fa-building"></i> 강의 <i class="fas fa-building shortmenu animate"></i>
					</a>
				</li>

				<li class="nav-item">
					<a class="nav-link text-white" href="#" title="Comment">
						<i class="fas fa-building"></i> 소개 <i class="fas fa-building shortmenu animate"></i>
					</a>
				</li>
			</ul>
			<ul class="navbar-nav ml-md-auto d-md-flex">
				<li class="nav-item">
					<a class="nav-link text-white" href="#">
						<i class="fas fa-address-book"></i> Profile
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link text-white" href="#">
						<i class="fas fa-sign-in-alt"></i> Login
					</a>
				</li>
			</ul>
		</div>
		</nav>
		<div class="container-fluid">
			<div class="row">
				<div class="col">
					<div class="card">
						<div class="card-body">
							<!--Carousel Wrapper-->
							<div id="carousel-example-1z" class="carousel slide carousel-fade" data-ride="carousel">
								<!--Indicators-->
								<ol class="carousel-indicators">
									<li data-target="#carousel-example-1z" data-slide-to="0" class="active"></li>
									<li data-target="#carousel-example-1z" data-slide-to="1"></li>
									<li data-target="#carousel-example-1z" data-slide-to="2"></li>
								</ol>
								<!--/.Indicators-->
								<!--Slides-->
								<div class="carousel-inner" role="listbox">
									<!--First slide-->
									<div class="carousel-item active">
										<img class="d-block w-100" src="https://mdbootstrap.com/img/Photos/Slides/img%20(130).jpg" alt="First slide">
									</div>
									<!--/First slide-->
									<!--Second slide-->
									<div class="carousel-item">
										<img class="d-block w-100" src="https://mdbootstrap.com/img/Photos/Slides/img%20(129).jpg" alt="Second slide">
									</div>
									<!--/Second slide-->
									<!--Third slide-->
									<div class="carousel-item">
										<img class="d-block w-100" src="https://mdbootstrap.com/img/Photos/Slides/img%20(70).jpg" alt="Third slide">
									</div>
									<!--/Third slide-->
								</div>
								<!--/.Slides-->
								<!--Controls-->
								<a class="carousel-control-prev" href="#carousel-example-1z" role="button" data-slide="prev">
									<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span>
								</a>
								<a class="carousel-control-next" href="#carousel-example-1z" role="button" data-slide="next">
									<span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span>
								</a>
								<!--/.Controls-->
							</div>
							<!--/.Carousel Wrapper-->
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Try Other</h5>
							<h6 class="card-subtitle mb-2 text-muted">Bootstrap 4.0.0 Snippet by pradeep330</h6>
							<p class="card-text">You can also try different version of Bootstrap V4 side menu. Click below link to view all Bootstrap Menu versions.</p>
							<a href="https://bootsnipp.com/pradeep330" class="card-link">link</a>
							<a href="http://websitedesigntamilnadu.com" class="card-link">Another link</a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Card title</h5>
							<table class="table">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">First</th>
										<th scope="col">Last</th>
										<th scope="col">Handle</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row">1</th>
										<td>Mark</td>
										<td>Otto</td>
										<td>@mdo</td>
									</tr>
									<tr>
										<th scope="row">2</th>
										<td>Jacob</td>
										<td>Thornton</td>
										<td>@fat</td>
									</tr>
									<tr>
										<th scope="row">3</th>
										<td>Larry</td>
										<td>the Bird</td>
										<td>@twitter</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">Card title</h5>
							<table class="table">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">First</th>
										<th scope="col">Last</th>
										<th scope="col">Handle</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row">1</th>
										<td>Mark</td>
										<td>Otto</td>
										<td>@mdo</td>
									</tr>
									<tr>
										<th scope="row">2</th>
										<td>Jacob</td>
										<td>Thornton</td>
										<td>@fat</td>
									</tr>
									<tr>
										<th scope="row">3</th>
										<td>Larry</td>
										<td>the Bird</td>
										<td>@twitter</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
<script>
	$(document).ready(function() {
		$('[data-toggle="popover"]').popover();
	});
</script>

<!------ Include the above in your HEAD tag ---------->