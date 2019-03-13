<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<link href="http://localhost:8080/css/circle.css" rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/view/include/head.jsp" />
<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=30acVBn_RNTBZdDAcwhu"></script>
<body>

	<div id="wrapper" class="animate">
		<jsp:include page="/WEB-INF/view/include/menu.jsp" />

		<nav aria-label="breadcrumb">
		<ol class="breadcrumb ">
			<li class="breadcrumb-item active" aria-current="page">Home/${requestScope.title}</li>
		</ol>
		</nav>
		<div class="container-fluid">
			<div class="col-md-8 mx-auto">

				<!-- form card login -->
				<div class="card rounded-0">

					<div class="card-body">
						<form class="form" method="Post" action="http://localhost:8080/circle/circleInsert_ok" enctype="multipart/form-data">
							<input type="hidden" name="circle_Point" id="point">
							<div class="form-group row">
								<label for="example-text-input" class="col-2 col-form-label bg-light font-weight-bold">동아리구분</label>
								<div  class="col-10 form-inline">
									<select id="kind1" name="circle_Kind" class="form-control">
										<option value="">-- 선택 --</option>
										<option value="0">문화</option>
										<option value="1">스포츠</option>
										<option value="2">강의</option>
									</select> 
									<select id="kind2" name="circle_Kind" class="form-control">
										<option value="">-- 선택 --</option>
										<option class="0" value="1">독서</option>
										<option class="0" value="2">와인</option>
										<option class="0" value="3">맛집</option>
										<option class="1" value="1">축구</option>
										<option class="1" value="2">야구</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label for="example-text-input" class="col-2 col-form-label bg-light font-weight-bold">동아리이름</label>
								<div class="col-10">
									<input class="form-control" type="text" name="circle_Nm" value="" id="example-text-input" placeholder="ex)홍길동" required="required">
								</div>
							</div>
							<div class="form-group row">
								<label for="example-search-input" class="col-2 col-form-label bg-light font-weight-bold">동아리 인원</label>
								<div class="col-10">
									<input id="spinner" type="number" name="circle_Cnt" class="form-control">
								</div>
							</div>
							<div class="form-group row">
								<label for="example-email-input" class="col-2 col-form-label bg-light font-weight-bold">연락처</label>
								<div class="col-10">
									<input class="form-control" type="tel" name="circle_PNum" value="" id="example-email-input" placeholder="01084698500" required="required">
								</div>
							</div>
							<div class="form-group row">
								<label for="example-url-input" class="col-2 col-form-label bg-light font-weight-bold">동아리 내용</label>
								<div class="col-10">
									<textarea name="circle_Content" id="editor"></textarea>
								</div>
							</div>
							<div class="form-group row">
								<label for="example-time-input" class="col-2 col-form-label bg-light font-weight-bold">동아리 날짜</label>
								<div class="col-10">
									<input type="text" name="circle_Date" class='form-control' id="datepicker" required="required">
								</div>
							</div>
							<!-- <div class="form-group row">
								<label for="example-time-input" class="col-2 col-form-label bg-light font-weight-bold">동아리 시간</label>
								<div class="col-10">
									<div class="input-group clockpicker">
										<input type="text" class="form-control" name="circle_Time" value="" required="required"> <span class="input-group-addon"> <span class="glyphicon glyphicon-time"></span>
										</span>
									</div>
								</div>
							</div> -->
							<div class="form-group row">
								<label for="example-time-input" class="col-2 col-form-label bg-light font-weight-bold">동아리 위치</label>
								<div class="col-10">
									<div class="form-group form-inline">
										<input class="form-control" style="width: 100px;" placeholder="우편번호" name="circle_PostNum" id="addr1" type="text" readonly="readonly" required="required">
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="도로명 주소" name="circle_Addr1" id="addr2" type="text" readonly="readonly" required="required" /> <input class="form-control" placeholder="상세주소" name="circle_Addr2" id="addr3" type="text" required="required" />
									</div>
									<div class=" form-inline">
										<button type="button" class='form-control ' id="search">찾기</button>
									</div>
								</div>
							</div>
							<div class="form-group row">
								<label for="example-time-input" class="col-2 col-form-label bg-light font-weight-bold">동아리 지도</label>
								<div class="col-10">
									<div id="map" style="width: 100%; height: 400px;"></div>
								</div>
							</div>
							<div class="form-group row">
								<label for="example-time-input" class="col-2 col-form-label bg-light font-weight-bold">동아리 로고</label>
								<div class="col-10">
									<input type="file" name="logo" class="form-control"  accept=" .jpg, .png" >
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
function point(lat,lng){
  var mapOptions = {
      center: new naver.maps.LatLng(lat, lng),
  };
  var map = new naver.maps.Map('map', mapOptions); 
  
  var marker = new naver.maps.Marker({
    position: new naver.maps.LatLng(lat, lng),
    map: map
});
}
  $(function() {
    $("#kind2").chained("#kind1");
    $("#search").click(function() {
      var width=500;
      var height=650;
      new daum.Postcode({
        oncomplete : function(data) {
          // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
         
          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          console.log(data.zonecode);
          console.log(fullRoadAddr);
          
          $("#addr1").val(data.zonecode);
          $("#addr2").val(fullRoadAddr);
          //검색된 주소를 비동기통신을 통해서 좌표를 얻는다
          $.ajax({
            type : 'post',
            url : 'http://localhost:8080/mapPosition_ajax',
            data : {
              'address' : fullRoadAddr
            }, //encodeURIComponent로 인코딩하여 넘깁니다.

            dataType : 'json',
            timeout : 10000,
            cache : false,
            error : function(x, e) {
              alert('요청하신 작업을 수행하던 중 예상치 않게 중지되었습니다.\n\n다시 시도해 주십시오.');
            },
            success : function(data) {
              var myObj = JSON.parse(data.map);
              var lng = myObj.result.items[0].point.x;
              var lat = myObj.result.items[0].point.y;
              $("#point").val(lat+","+lng);
              point(lat, lng);
            }
          });
        }
        }).open({
        left:(window.screen.width/2)-(width/2),
        top:(window.screen.height/2)-(height/2)
      });
    });
	// 텍스트에디터영역 시작
    CKEDITOR.replace('editor', {//해당 이름으로 된 textarea에 에디터를 적용
    width : '100%',
    height : '400px',
    filebrowserUploadUrl : 'http://localhost:8080/img_upload?CKEditor=contents&CKEditorFuncNum=1&langCode=ko'
    });
 	// 텍스트에디터영역 시작
 	// 시간선택영역 시작
    $('.clockpicker').clockpicker({
    placement : 'top',
    align : 'left',
    donetext : 'Done'
    });
 	// 시간선택영역 끝
    $("#datepicker").datepicker({
    dateFormat : 'yy-mm-dd',
    minDate : 0
    });

  });
</script>
