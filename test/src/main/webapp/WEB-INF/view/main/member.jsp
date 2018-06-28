<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/view/include/head.jsp" />
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
									<form>
										<div class="form-row">
											<div class="col-sm-8 form-group">
												<label>아이디 </label><span class="regForm text-danger">*</span> <input type="text" id="user_id" class="form-control" placeholder="" required>
											</div>
											<!-- form-id end.// -->
											<div class="col form-group">
												<label>&nbsp; </label>
												<button class="btn btn-info btn-block" id="idchk">중복확인</button>
											</div>
											<!-- form-group end.// -->
										</div>
										<div class="form-group">
											<label>패스워드</label><span class="regForm text-danger">*</span> <input name="user_pwd" class="form-control pwd1" type="password" required >
										</div>
										<div class="form-group">
											<label>패스워드 확인</label><span class="regForm text-danger">*</span> <input class="form-control pwd2" type="password" required>
										</div>
										<div class="form-group">
											<font name="check"><br/></font>
										</div>
										<div class="form-row">
											<div class="col form-group">
												<label>닉네임</label> <input name="user_nm" type="text" class="form-control " placeholder="" required> 
											</div>
											<!-- form-id end.// -->
										</div>
										<!-- form-row end.// -->

										<div class="form-row">
											<div class="form-group col-md-12">
												<label>이메일</label><span class="regForm text-danger">*</span>
												<div class="form-inline">
													<input type="email" class="form-control col-md-5" required name="user_email"> <span class="col-md-1">@</span> 
													<select name="user_email" id="inputState" class="form-control col-md-6" >
														<option value="naver">naver.com</option>
														<option value="gmail">gmail.com</option>
														<option value="nate">nate.com</option>
														<option value="hanmail">hanmail.net</option>
														<option value="custom">직접입력</option>
													</select>
												</div>
											</div>
										</div>
										<div class="form-row  justify-content-md-center ">
											<div class="row">
												<div class="form-group">
													<button type="submit" class="btn btn-primary join">가입하기</button>
													&nbsp;
													<button type="reset" class="btn btn-secondary" >취소</button>
												</div>
											</div>
											<!-- form-group// -->
										</div>
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
    var idchk=false;
    var pwdchk=false;
    $("#idchk").click(function() {
      if ($("#user_id").val() == "") {
        alert("아이디를 입력해주세요");
      } else {
        var id = $("#user_id").val();
        $.ajax({
        type : 'POST',
        url : "http://localhost:8080/IdChk.ajax",
        data : {
          "user_id" : id
        },
        success : function(msg) {
          idchk=msg.idchk;
          if (idchk==1) {
            idchk=false;
            alert("이미 존재하는 아이디입니다");
          } else if(idchk==0){
            idchk=true;
            $("#user_id").attr('disabled', 'disabled');
            $("#idchk").attr('disabled', 'disabled');
          }
        }
        });
      }
    });
    /* 중복확인 end// */
    
    $('.pwd1').keyup(function(){
      $('font[name=check]').html('<br>');
     }); 

     $('.pwd2').keyup(function(){
      if($('.pwd1').val()==$('.pwd2').val()){
       $('font[name=check]').html('<br>');
       $('font[name=check]').html("비밀번호가 일치합니다");
       $('font[name=check]').css("color","blue");
       pwdchk=false;
      }else{
       $('font[name=check]').html('<br>');
       $('font[name=check]').html("비밀번호가 틀림니다.");
       $('font[name=check]').css("color","red");
       pwdchk=true;
      }
     }); 
     /* 비번체크 end// */
     $(".join").click(function() {
	      if(idchk==false){
	        alert("중복확인을 해주세요");
	      }else if(pwdchk==true){
	        alert("비밀번호가 틀림니다.");
	      }else if()
     });
    
  });
</script>


<!------ Include the above in your HEAD tag ---------->