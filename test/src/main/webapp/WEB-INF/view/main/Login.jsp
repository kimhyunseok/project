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
									<form class="form" action="http://localhost:8080/LoginChk" role="form" autocomplete="off" id="formLogin" novalidate="" method="POST">
										<div class="form-group">
											<label for="uname1">아이디</label> <input type="text" name="user_id" class="form-control form-control-lg rounded-0" id="user_id" required="">
											<div class="invalid-feedback">Oops, you missed this one.</div>
										</div>
										<div class="form-group">
											<label>패스워드</label> <input type="password" name="user_pw" class="form-control form-control-lg rounded-0" id="user_pw" required="" autocomplete="new-password">
											<div class="invalid-feedback">Enter your password too!</div>
										</div>
										<div>
											<label class="custom-control custom-checkbox"> <input type="checkbox" class="custom-control-input"> <span class="custom-control-indicator"></span> <span class="custom-control-description small text-dark">Remember me on this computer</span>
											</label>
										</div>
										<button type="button" class="btn btn-success btn-lg float-right" id="btnLogin">Login</button>
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
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnLogin").click(function() {
			if ($("#user_id").val() == "") {
				alert("아이디를 입력해주세요");
			} else if ($("#user_pw").val() == "") {
				alert("비밀번호를 입력해주세요");
			} else {
				var id=$("#user_id").val();
				var pw=$("#user_pw").val();
				$.ajax({
			        // type을 설정합니다.
			        type : 'POST',
			        url : "http://localhost:8080/LoginChk",
			        // 사용자가 입력하여 id로 넘어온 값을 서버로 보냅니다.
			        data : {"user_id" : id,"user_pw" : pw},
			        // 성공적으로 값을 서버로 보냈을 경우 처리하는 코드입니다.
			        success : function (data) {
			            // 서버에서 Return된 값으로 중복 여부를 사용자에게 알려줍니다.
			            alert(data.chk);      
			        }
			    });
			}
		});
	});
</script>


<!------ Include the above in your HEAD tag ---------->