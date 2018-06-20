<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/view//include/head.jsp" />
<body>

	<div id="wrapper" class="animate">
		<jsp:include page="/WEB-INF/view/include/menu.jsp" />
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-4 mx-auto">

							<!-- form card login -->
							<div class="card rounded-0">
								<div class="card-header">
									<h3 class="mb-0">Login</h3>
								</div>
								<div class="card-body">
									<form class="form" role="form" autocomplete="off" id="formLogin" novalidate="" method="POST">
										<div class="form-group">
											<label for="uname1">아이디</label> <input type="text" class="form-control form-control-lg rounded-0" name="uname1" id="uname1" required="">
											<div class="invalid-feedback">Oops, you missed this one.</div>
										</div>
										<div class="form-group">
											<label>패스워드</label> <input type="password" class="form-control form-control-lg rounded-0" id="pwd1" required="" autocomplete="new-password">
											<div class="invalid-feedback">Enter your password too!</div>
										</div>
										<div>
											<label class="custom-control custom-checkbox"> <input type="checkbox" class="custom-control-input"> <span class="custom-control-indicator"></span> <span class="custom-control-description small text-dark">Remember me on this computer</span>
											</label>
										</div>
										<button type="submit" class="btn btn-success btn-lg float-right" id="btnLogin">Login</button>
									</form>
								</div>
								<!--/card-block-->
							</div>
							<!-- /form card login -->
						</div>
					</div>
					<!--/row-->
				</div>
				<!--/col-->
			</div>
			<!--/row-->
		</div>
</body>
</html>


<!------ Include the above in your HEAD tag ---------->