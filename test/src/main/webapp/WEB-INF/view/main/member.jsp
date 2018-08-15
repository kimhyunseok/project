<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/view/include/head.jsp" />
<body>

	<div id="wrapper" class="animate">
		<jsp:include page="/WEB-INF/view/include/menu.jsp" />
		<div class="container-fluid">
			<nav aria-label="breadcrumb">
			<ol class="breadcrumb ">
				<li class="breadcrumb-item active" aria-current="page">Home/��������</li>
			</ol>
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-4 mx-auto">

							<!-- form card login -->
							<div class="card rounded-0">
								<div class="card-header">
									<h3 class="mb-0">
										<c:choose>
											<c:when test="${user eq 1}">Login</c:when>
											<c:otherwise>ȸ����������</c:otherwise>
										</c:choose>
									</h3>
								</div>
								<div class="card-body">
									<c:choose>
										<c:when test="${user eq 1}">
											<form id="join" method="post" action="http://localhost:8080/UserJoin">
												<div class="form-row">
													<div class="col-sm-8 form-group">
														<label>���̵� </label><span class="regForm text-danger">*</span> <input name="user_id" type="text" id="user_id" class="form-control" placeholder="" required>
													</div>
													<!-- form-id end.// -->
													<div class="col form-group">
														<label>&nbsp; </label>
														<button class="btn btn-info btn-block" id="idchk">�ߺ�Ȯ��</button>
													</div>
													<!-- form-group end.// -->
												</div>
												<div class="form-group">
													<label>�н�����</label><span class="regForm text-danger">*</span> <input name="user_pw" id="user_pw" class="form-control pwd1" type="password" required>
												</div>
												<div class="form-group">
													<label>�н����� Ȯ��</label><span class="regForm text-danger">*</span> <input class="form-control pwd2" type="password" required>
												</div>
												<div class="form-group">
													<font name="check"><br /></font>
												</div>
												<div class="form-row">
													<div class="form-group col-md-12">
														<label>�̸���</label><span class="regForm text-danger">*</span>
														<div class="form-inline">
															<input type="text" name="user_email_1" class="form-control col-md-5" required id="user_email"> <span class="col-md-1">@</span> <select name="user_email_2" id="inputState" class="form-control col-md-6">
																<option value="naver.com">naver.com</option>
																<option value="gmail.com">gmail.com</option>
																<option value="nate.com">nate.com</option>
																<option value="hanmail.net">hanmail.net</option>
																<option value="custom">�����Է�</option>
															</select>
														</div>
													</div>
												</div>
												<div class="form-row  justify-content-md-center ">
													<div class="row">
														<div class="form-group">
															<button type="submit" class="btn btn-primary join">�����ϱ�</button>
															&nbsp;
															<button type="reset" class="btn btn-secondary">���</button>
														</div>
													</div>
													<!-- form-group// -->
												</div>
										</c:when>
										<c:otherwise>
											<form id="join" method="post" action="http://localhost:8080/UserUpdate">
												<div class="form-group">
													<label>���̵� </label><span class="regForm text-danger">*</span> <input name="user_id" type="text" id="user_id" class="form-control" value="${user_info.user_id}" placeholder="" readonly>
												</div>
												<div class="form-group">
													<label>�н�����</label><span class="regForm text-danger">*</span> <input id="user_b_pw" value="${user_info.user_pw}" class="form-control pwd1" type="password" readonly>
												</div>
												<div class="form-group">
													<label>�н����� Ȯ��</label><span class="regForm text-danger">*</span> <input class="form-control pwd2" type="password" required>
												</div>
												<div class="form-group">
													<label>���ο� �н�����</label><span class="regForm text-danger">*</span> <input name="user_pw" type="password" id="user_pw" value="" class="form-control pwd1">
												</div>
												<div class="form-group">
													<font name="check"><br /></font>
												</div>
												<div class="form-row">
													<div class="form-group col-md-12">
														<label>�̸���</label><span class="regForm text-danger">*</span>
														<div class="form-inline">
															<input type="text" name="user_email_1" class="form-control col-md-5" required id="user_email" value="${user_info.user_email_1}"> <span class="col-md-1">@</span> <select name="user_email_2" value="${user_info.user_email_2}" id="inputState" class="form-control col-md-6">
																<option value="naver.com">naver.com</option>
																<option value="gmail.com">gmail.com</option>
																<option value="nate.com">nate.com</option>
																<option value="hanmail.net">hanmail.net</option>
																<option value="custom">�����Է�</option>
															</select>
														</div>
													</div>
												</div>
												<div class="form-row  justify-content-md-center ">
													<div class="row">
														<div class="form-group">
															<button type="submit" class="btn btn-primary update">��������</button>
															&nbsp;
															<button type="reset" class="btn btn-secondary">���</button>
														</div>
													</div>
													<!-- form-group// -->
												</div>
										</c:otherwise>
									</c:choose>

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
    var idchk = false;
    var pwdchk = false;
    $("#idchk").click(function() {
      if ($("#user_id").val() == "") {
        alert("���̵� �Է����ּ���");
      } else {
        var id = $("#user_id").val();
        $.ajax({
        type : 'POST',
        url : "http://localhost:8080/IdChk.ajax",
        data : {
          "user_id" : id
        },
        success : function(msg) {
          idchk = msg.idchk;
          if (idchk == 1) {
            idchk = false;
            alert("�̹� �����ϴ� ���̵��Դϴ�");
          } else if (idchk == 0) {
            alert("��밡���� ���̵��Դϴ�");
            idchk = true;
            $("#user_id").attr('readonly', 'readonly');
            $("#idchk").attr('readonly', 'readonly');
          }
        }
        });
      }
    });
    /* �ߺ�Ȯ�� end// */

    $('.pwd1').keyup(function() {
      $('font[name=check]').html('<br>');
    });

    $('.pwd2').keyup(function() {
      if ($('.pwd1').val() == $('.pwd2').val()) {
        $('font[name=check]').html('<br>');
        $('font[name=check]').html("��й�ȣ�� ��ġ�մϴ�");
        $('font[name=check]').css("color", "blue");
        pwdchk = false;
      } else {
        $('font[name=check]').html('<br>');
        $('font[name=check]').html("��й�ȣ�� Ʋ���ϴ�.");
        $('font[name=check]').css("color", "red");
        pwdchk = true;
      }
    });
    /* ���üũ end// */
    $(".join").click(function() {
      if (idchk == false) {
        alert("�ߺ�Ȯ���� ���ּ���");
        return false;
      } else if (pwdchk == true) {
        alert("��й�ȣ�� Ʋ���ϴ�.");
        return false;
      } else if ($("#user_email").val() == null) {
        alert("�̸����� �Է����ּ���");
        return false;
      }
    });
    $(".update").click(function() {
      if ($("#user_pw").val() == $("#user_b_pw").val()) {
        alert("������й�ȣ�� �����ϴ�.");
        $("#user_pw").text("");
        $("#user_pw").focus();
        return false;
      } else if ($("#user_email").val() == null) {
        alert("�̸����� �Է����ּ���");
        return false;
      }
    });
  });
</script>


<!------ Include the above in your HEAD tag ---------->