<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="hotel.model.vo.Hotel" %>
<% 
	Hotel hotel = (Hotel)request.getAttribute("hotel");
	String a[] = hotel.getHotel_address().split("/"); // 주소/lat/lng
	double lat = Double.parseDouble(a[1]); // String 이므로 Double 로 parse
	double lng = Double.parseDouble(a[2]);
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" type="text/css" 
href="/hotel/css/common.css">
<style type="text/css">
ul {list-style: none;}
#slider {
	position: relative;
	overflow: hidden;
}
#slider .slides {
	margin: 0;
	padding: 0;
}
#slider .slide {
	float: left;
	list-style-type: none;
}
#slider-nav {
	position: absolute;
	height: 2em;
	bottom: 0em;
	width: 100%;
	cursor: default;
}
#slider-nav-prv {
	height: 1.5em;
	line-height: 1.5em;
	width: 1.5em;
	text-align: center;
	position: absolute;
	left: 0.5em;
	background: white;
}
#slider-nav-nxt {
	height: 1.5em;
	line-height: 1.5em;
	width: 1.5em;
	text-align: center;
	position: absolute;
	right: 0.5em;
	background: white;
}
#slider-nav-prv:hover, #slider-nav-nxt:hover {
	color: white;
	background: black;
}
#slider-nav-dot-con {text-align: center;}
.slider-nav-dot {
	list-style: none;
	border: 0.15em solid white;
	box-sizing: border-box;
	width: 1em;
	height: 1em;
	display: inline-block;
	border-radius: 50%;
	vertical-align: middle;
}
img#m {
	width: 500px;
	height: 350px;
}
.slider-nav-dot:hover {background: white;}
.foot123{height:10px;}
#sal{
	color:#464543;
	background:#F4F4F4;
	font-family:Verdana, sans-serif;
}
#fac{color:#464543;}
.reversing{
	background: #00AEF0;
	width: 100px;
	height: 48px;
	color: white;
	border: 0px;
	border-radius: 5px;
	font-size: 2.5ex;
}
#first td:nth-child(3n+1){background:#DED8F3;}
#first{
	color:#464543;
	font-family:Verdana, sans-serif;
}
#reserve{
  	height:60px;
  	width:150px;
  	background:#2C4162;
  	border:0;
  	font-size:30px;
  	border-radius:5px;
  	color:white;
}
#reserve:active{
  	position: relative;
  	top: 2px;
  	left: -1px;
}
#reserve:hover{
	color:white;
	background:#00AEF0;
}
#hotel{
     height:60px;
     width:150px;
     background:#2C4162;
     border:0;
     font-size:30px;
     border-radius:5px;
     color:white;
}
#hotel:active{
     position: relative;
     top: 2px;
     left: -1px;
}
#hotel:hover{
   color:white;
   background:#00AEF0;
}
</style>
<script type="text/javascript">
	'use strict';
	var animationSpeed = 3000; //화면전환 속도
	var pause = 6000; //화면전환 후 일시 정지 속도
	$(function() {
		$("header").load("/hotel/view/common/header.jsp");
		$("footer").load("/hotel/view/common/footer.html");	
		var width = 500; //슬라이드 한 개의 폭
		var height = 350; //슬라이드 높이		
		var totalSlides = 7; //복제 슬라이드를 포함한 전체 슬라이드 개수
		var currentSlide = 2; //이 항목은 수정하지 않음
		var interval;
		var action;
		var dotNum;
		var dMinusC;
		var $slideCon = $('#slider');
		var $slideUl = $('.slides');
		var $slides = $('.slide');
		var $dots = $('.slider-nav-dot');
		var $sliderNavPrv = $('#slider-nav-prv');
		var $sliderNavNxt = $('#slider-nav-nxt');

		function initSlider() {
			$slideCon.css('width', width);
			$slideCon.css('height', height);
			$slideUl.css('margin-left', -width);
			$slideUl.css('width', totalSlides * width);
			$slides.css('width', width);
			$slides.css('height', height);
		}

		function startSlider(action, dotNum) {
			if (action == 'prv') {
				$slideUl.animate({'margin-left' : '+=' + width},
				animationSpeed, function() {
					if (--currentSlide === 1) {
						currentSlide = $slides.length - 1;
						$slideUl.css('margin-left',
								-($slides.length - 2) * width);
					}

					for (var i = 0; i < $dots.length; i++)
						$dots[i].style.background = "";
					$dots[currentSlide - 2].style.background = "white";
				});
			} 
			else if (action == 'nxt') {
				$slideUl.animate({'margin-left' : '-=' + width}, 
					animationSpeed, function(){
					if (++currentSlide === $slides.length) {
						currentSlide = 2;
						$slideUl.css('margin-left', -width);
					}

					for (var i = 0; i < $dots.length; i++)
						$dots[i].style.background = "";
					$dots[currentSlide - 2].style.background = "white";
				});
			} 
			else if (action == 'dot') {
				dMinusC = dotNum - currentSlide;
				currentSlide = dotNum;

				for (var i = 0; i < $dots.length; i++)
					$dots[i].style.background = "";
				$dots[currentSlide - 2].style.background = "white";

				$slideUl.animate({
					'margin-left' : '-=' + (dMinusC * width)
				}, animationSpeed);

			} 
			else {
				interval = setInterval(function() {
					$slideUl.animate({'margin-left' : '-=' + width},
					animationSpeed, function() {
					if (++currentSlide === $slides.length) {
						currentSlide = 2;
						$slideUl.css('margin-left', -width);
					}
					for (var i = 0; i < $dots.length; i++)
						$dots[i].style.background = "";
					$dots[currentSlide - 2].style.background = "white";
					});
				}, pause);
			}
		}

		function pauseSlider() {clearInterval(interval);}

		function prvSlide() {startSlider('prv');}

		function nxtSlide() {startSlider('nxt');}

		function dotSelected() {
			dotNum = $(this).attr('id');
			dotNum = parseInt(dotNum.substring(7)) + 1;
			startSlider('dot', dotNum);
		}

		$slideUl.on('mouseenter', pauseSlider)
		.on('mouseleave', startSlider);

		$sliderNavPrv.on('click', prvSlide)
		.on('mouseenter', pauseSlider).on(
				'mouseleave', startSlider);

		$sliderNavNxt.on('click', nxtSlide)
		.on('mouseenter', pauseSlider).on(
				'mouseleave', startSlider);

		$dots.on('click', dotSelected)
		.on('mouseenter', pauseSlider)
		.on('mouseleave', startSlider);
		
		initSlider();
		startSlider();
		
		$("#fac td:eq(0)").css("backgroundColor", "#DDDDDD");
		$("#fac td:nth-child(6n+1)").not("td:eq(0)")
		.css("backgroundColor", "#F4F4F4");
	});
</script>
</head>
<body onload = "initMap()"><!-- 지도 자동 실행 -->
	<header></header>
	<div class = "foot123"></div><!-- 약간의 공백 -->
	<table id = "first" style = "width:100%">
	<tr><td align = "center"><h2><b>호 텔 명</b></h2></td>
	<td><h2><%=hotel.getHotel_name() %></h2>
	</td><td></td></tr>
	<tr><td align = "center"><h2><b>주   소</b></h2></td>
	<td><h2><%=a[0] %></h2></td><td align = "right">
	<a href = "/hotel/revpage?hotel_no=<%= hotel.getHotel_no()%>">
   <input type = "button" id = "reserve" value = "예약하기"></a></td></tr>
	<tr><td align = "center"><h2><b>1박가격</b></h2></td>
	<td><h2><%= hotel.getHotel_price()%>원</h2></td>
	<td align = "right">
   <a href = "/hotel/pls?hotel_no=<%= hotel.getHotel_no()%>">
   <input type = "button" id = "hotel" value = 호텔리뷰></a></td></tr>
	</table><hr>
	<table><tr><td>
	<section>
		<div id="sec">
			<div id="slider">
				<ul class="slides">
					<li class="slide slide5"><img id="m"
						src="<%= hotel.getHotel_link() %>5.jpg"></li>
					<li class="slide slide1"><img id="m"
						src="<%= hotel.getHotel_link() %>1.jpg"></li>
					<li class="slide slide2"><img id="m"
						src="<%= hotel.getHotel_link() %>2.jpg"></li>
					<li class="slide slide3"><img id="m"
						src="<%= hotel.getHotel_link() %>3.jpg"></li>
					<li class="slide slide4"><img id="m"
						src="<%= hotel.getHotel_link() %>4.jpg"></li>
					<li class="slide slide5"><img id="m"
						src="<%= hotel.getHotel_link() %>5.jpg"></li>
					<li class="slide slide1"><img id="m"
						src="<%= hotel.getHotel_link() %>1.jpg"></li>
				</ul>
			
				<div id="slider-nav">
					<div id="slider-nav-prv">&#10094;</div>
					<div id="slider-nav-nxt">&#10095;</div>
					<div id="slider-nav-dot-con">
						<span class="slider-nav-dot"
						style="background: white" id="nav-dot1"></span>
						<span class="slider-nav-dot" id="nav-dot2">
						</span>
						<span class="slider-nav-dot" id="nav-dot3">
						</span>
						<span class="slider-nav-dot" id="nav-dot4">
						</span>
						<span class="slider-nav-dot" id="nav-dot5">
						</span>
					</div>
				</div>
			</div>
		</div>
	</section></td><td>
	<table id = "fac">
		<tr>
			<td colspan="6" align="center"><h2>호텔시설</h2></td>
		</tr>
		<tr>
			<td align = "center"><h3><b>일반사항</b></h3></td>
			<td colspan="5" width = "80%">
			<%=hotel.getHotel_fac1() %></td>
		</tr>
		<tr>
			<td align = "center"><h3><b>서 비 스</b></h3></td>
			<td colspan="5"><%=hotel.getHotel_fac2() %></td>
		</tr>
		<tr>
			<td align = "center"><h3><b>인 터 넷</b></h3></td>
			<td colspan="5"><%=hotel.getHotel_fac3() %></td>
		</tr>
		<tr>
			<td align = "center"><h3><b>주  차</b></h3></td>
			<td colspan="5"><%=hotel.getHotel_fac4() %></td>
		</tr>
	</table>
	</td></tr></table><hr>
	<div id = "sal">
	<h3>호텔설명 : <%=hotel.getHotel_info() %></h3></div>
	<hr><div id = "sal">
	<h3>주변 관광지 : <%=hotel.getHotel_travel() %></h3></div>
	<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=
	AIzaSyDVRFAdygOkPwkFjI_FxFDx8_Mx59jcrcI&sensor=TRUE">
	</script><!-- 구글맵을 사용하기 위한 CDN -->
	<script type="text/javascript">
		function initMap() {
			var myLatLng = {
				lat : <%=lat%>,
				lng : <%=lng%>
			};
			var map = new google.maps.Map(document.getElementById("map"),
			{
				zoom : 18,/* 지도상의 확대 정도 */
				center : myLatLng
			});
			var marker = new google.maps.Marker({ /* 지도 마커 표시 */
				position : myLatLng,
				map : map,
				title : "<%=hotel.getHotel_name() %>"
			});
		}
	</script>
	<h2 id = "fac">위치</h2>
	<div id="map" style="width:100%;height:400px;"></div><!-- 지도 -->
	<div class="foot123"></div>
	<div class="foot123"></div>
	<footer></footer>
</body>
</html>