<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<link href="http://localhost:8080/css/circle.css" rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/view/include/head.jsp" />
<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>

<body>

	<div id="wrapper" class="animate">
		<jsp:include page="/WEB-INF/view/include/menu.jsp" />

		<nav aria-label="breadcrumb">
		<ol class="breadcrumb ">
			<li class="breadcrumb-item active" aria-current="page">Home/동아리등록</li>
		</ol>
		</nav>
		<div class="container-fluid">
			<div class="col-md-8 mx-auto">

				<!-- form card login -->
				<div class="card rounded-0">

					<div class="card-body">
						<form class="form" method="Post" enctype="multipart/form-data">
							<div class="form-group row">
								<label for="example-text-input" class="col-2 col-form-label bg-light font-weight-bold">동아리이름</label>
								<div class="col-10">
									<input class="form-control" type="text" value="" id="example-text-input" placeholder="ex)홍길동">
								</div>
							</div>
							<div class="form-group row">
								<label for="example-search-input" class="col-2 col-form-label bg-light font-weight-bold">동아리 인원</label>
								<div class="col-10">
									<input id="spinner" name="personnel" type="number" class="form-control">
								</div>
							</div>
							<div class="form-group row">
								<label for="example-email-input" class="col-2 col-form-label bg-light font-weight-bold">연락처</label>
								<div class="col-10">
									<input class="form-control" type="email" value="" id="example-email-input" placeholder="01084698500">
								</div>
							</div>
							<div class="form-group row">
								<label for="example-url-input" class="col-2 col-form-label bg-light font-weight-bold">동아리 내용</label>
								<div class="col-10">
									<textarea name="content" id="editor"></textarea>
								</div>
							</div>


							<div class="form-group row">
								<label for="example-time-input" class="col-2 col-form-label bg-light font-weight-bold">동아리 날짜</label>
								<div class="col-10">
									<input type="text" class='form-control' id="datepicker">
								</div>
							</div>
							<div class="form-group row">
								<label for="example-time-input" class="col-2 col-form-label bg-light font-weight-bold">동아리 시간</label>
								<div class="col-10">
									<div class="input-group clockpicker">
										<input type="text" class="form-control" value=""> <span class="input-group-addon"> <span class="glyphicon glyphicon-time"></span>
										</span>
									</div>
								</div>
							</div>
							<div class="form-group row">
								<label for="example-time-input" class="col-2 col-form-label bg-light font-weight-bold">동아리 위치</label>
								<div class="col-10">
									<input type="text" class='form-control'>
									<button type="button" class='form-control map'>test</button>
								</div>
							</div>
							<div class="form-row  justify-content-md-center ">
								<div class="form-group">
									<button type="submit" class="btn btn-primary join">등록</button>
									&nbsp;
									<button type="reset" class="btn btn-secondary">취소</button>
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
</body>
</html>
<script>
  $(function() {
    $(".map").click(function() {
      $.ajax({
      url : 'https://openapi.naver.com/v1/map/geocode',
      data : {
      key : '30acVBn_RNTBZdDAcwhu',
      encoding : 'utf-8',
      coord : 'LatLng',
      output : 'json',
      query : '주부토로 449번길'
      },
      dataType : 'json',
      }).done(function(data) {
        console.log( data.result );
      });
    });

    CKEDITOR.replace('editor', {//해당 이름으로 된 textarea에 에디터를 적용
    width : '100%',
    height : '400px',
    filebrowserUploadUrl : 'http://localhost:8080/img_upload?CKEditor=contents&CKEditorFuncNum=1&langCode=ko'
    });
    $('.clockpicker').clockpicker({
    placement : 'top',
    align : 'left',
    donetext : 'Done'
    });
    $("#datepicker").datepicker({
    dateFormat : 'yy-mm-dd',
    minDate : 0
    });

  });
</script>
