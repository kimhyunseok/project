<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<div class="container-fluid">
	<footer class="footer">
		<div class="footerHeader"></div>
		<div class="container-fluid" style="background-color: #009999; padding: 30px">
			<div class="row">

				<!--footer area -->

				<div class="col-md-4">
					<h3>����Ʈ�Ұ�</h3>
					<p>���Ƹ�ä���� ����ڿ��� ���������� ��̻�Ȱ�� ���� ������ ��︮���� ������ ��ȣȸ Ȱ���� �������� ���� ��� ���ؼ� ��ȣȸ�� �ұԸ� ������ ����� �������� �����Ѵٴ� ���� �ø��� ���� �ִ� ������� ������ �������� ������ �̷������ �ϴ� ����Ʈ�Դϴ�</p>
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
					<p>���� ���Ƹ�ä���� ����ڿ��� ������ ���Ƹ������� �����ϵ��� ����ϰ� �ֽ��ϴ�</p>
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
</div>
<script>

  var mapOptions = {
  center : new naver.maps.LatLng(37.3595704, 127.105399),
  zoom : 20,
  zoomControl : true, //�� ��Ʈ���� ǥ�� ����
  zoomControlOptions : { //�� ��Ʈ���� �ɼ�
    position : naver.maps.Position.TOP_RIGHT
  }
  };
  //���� ��Ʈ��
  $("#controls").on("click", function(e) {
    e.preventDefault();

    if (map.getOptions("scaleControl")) {
      map.setOptions({ //��� ���� ��Ʈ�� �����
      scaleControl : false,
      logoControl : false,
      mapDataControl : false,
      zoomControl : false,
      mapTypeControl : false
      });
      $(this).removeClass('control-on');
    } else {
      map.setOptions({ //��� ���� ��Ʈ�� ���̱�
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

