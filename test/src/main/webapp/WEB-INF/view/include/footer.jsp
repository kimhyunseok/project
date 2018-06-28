<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<footer class="footer">
	<div class="footerHeader"></div>
	<div class="container-fluid" style="background-color: #009999; height: 400px; padding: 40px">
		<div class="row">

			<!--footer area -->

			<div class="col-md-4">
				<h3>About us</h3>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
			</div>


			<div class="col-md-4">
				<div id="map" style="width: 100%; height: 300px;"></div>
			</div>
			<div class="col-md-4">
				<h3>Contact Us</h3>
				<ul>
					<li>Phone : 010 - 8469 - 8500</li>
					<li>E-mail : lia0417@naver.com</li>

				</ul>
				<p>저희 동아리채널은 사용자에게 원할한 동아리정보를 제공하도록 노력하고 있습니다</p>
				<ul class="sm">
					<li>
						<a href="#">
							<img src="https://www.facebook.com/images/fb_icon_325x325.png" class="img-responsive">
						</a>
					</li>
					<li>
						<a href="#">
							<img src="https://lh3.googleusercontent.com/00APBMVQh3yraN704gKCeM63KzeQ-zHUi5wK6E9TjRQ26McyqYBt-zy__4i8GXDAfeys=w300" class="img-responsive">
						</a>
					</li>
					<li>
						<a href="#">
							<img src="http://playbookathlete.com/wp-content/uploads/2016/10/twitter-logo-4.png" class="img-responsive">
						</a>
					</li>
				</ul>

			</div>
			<!--footer area -->

		</div>
	</div>
</footer>
<script>
	var mapOptions = {
		center : new naver.maps.LatLng(37.3595704, 127.105399),
		zoom : 20,
		zoomControl: true, //줌 컨트롤의 표시 여부
        zoomControlOptions: { //줌 컨트롤의 옵션
            position: naver.maps.Position.TOP_RIGHT
        }
	};
	//지도 컨트롤
	$("#controls").on("click", function(e) {
		e.preventDefault();

		if (map.getOptions("scaleControl")) {
			map.setOptions({ //모든 지도 컨트롤 숨기기
				scaleControl : false,
				logoControl : false,
				mapDataControl : false,
				zoomControl : false,
				mapTypeControl : false
			});
			$(this).removeClass('control-on');
		} else {
			map.setOptions({ //모든 지도 컨트롤 보이기
				scaleControl : true,
				logoControl : true,
				mapDataControl : true,
				zoomControl : true,
				mapTypeControl : true
			});
			$(this).addClass('control-on');
		}
	});
	var map = new naver.maps.Map('map', mapOptions);
</script>
</script>

