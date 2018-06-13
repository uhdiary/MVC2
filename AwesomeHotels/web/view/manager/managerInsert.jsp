<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hotel change</title>
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("header").load("/hotel/view/common/mgheader.html");
		$("footer").load("/hotel/view/common/footer.html");

	});
</script>
<style type="text/css">
.write {
	background-color: #00AEF0;
	text-decoration: none;
	font-family: Arial;
	line-height: 10px;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	border-radius: 10px;
	text-align: center;
	vertical-align: right;
	display: inline-block;
	font-size: 15px;
	color: #ffffff;
	width: 70px;
	height: 35px;
	padding: 13px;
	margin-left: 400px;
}

.write:active {
	position: relative;
	top: 3px
}

.tbl_model {
	resize : none;
}
.foot1{
height:30px;
}
</style>
</head>
<body>
	
		<header></header>
		<form action="/hotel/mginsert" method="post">
		<div id="container">
			<!-- CONTENTS -->
			<div id="content">
				<div class="c_header">
					<h2 style="margin-left: 130px; color: #1e94cc; font-weight: bold;">호텔 정보 등록</h2>
				</div>
				
				<table width="700" height=1000 " class="tbl_model" align="center"
					cellspacing=0border-bottom:solid1px#00AEF0;' style='table-layout:fixed;'>
					<colgroup>
						<col style="width: 22%">
						<col>
					</colgroup>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">호텔명</div>
						</th>
						<td
							style='border-bottom: solid 0px #00AEF0; border-top: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<input type="text" name="hotel_name"
									style='border: 0; padding: 0; width: 500px; height: 40px; align: center; border-width: 0; font-size: 12pt;'
									size="20">
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">호텔주소</div>
						</th>
						<td
							style='border-bottom: solid 0px #00AEF0; border-top: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<input type="text" name="hotel_address"
									style='border: 0; padding: 0; width: 500px; height: 40px; align: center; border-width: 0; font-size: 12pt;'
									size="20">
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">호텔정보</div>
						</th>
						<td
							style='border-bottom: solid 0px #00AEF0; border-top: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<input type="text" name="hotel_info"
									style='border: 0; padding: 0; width: 500px; height: 40px; align: center; border-width: 0; font-size: 12pt;'
									size="20">
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">사진링크</div>
						</th>
						<td
							style='border-bottom: solid 1px #00AEF0; border-top: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<input type="text" name="hotel_link" 
									style='border: 0; padding: 0; width: 500px; height: 40px; align: center; border-width: 0; font-size: 12pt;'
									size="20">
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">일반사항</div>
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<input type="text" name="hotel_fac1"
									style='border: 0; padding: 0; width: 500px; height: 50px; align: center; border-width: 0; font-size: 12pt;'
									size="100">
							</div>
						</td>
					</tr>

					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">서비스</div>
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<input type="text" name="hotel_fac2"
									style='border: 0; padding: 0; width: 500px; height: 50px; align: center; border-width: 0; font-size: 12pt;'>
							</div>
						</td>
					</tr>

					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">인터넷</div>
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<input type="text" name="hotel_fac3"
									style='border: 0; padding: 0; width: 500px; height: 50px; align: center; border-width: 0; font-size: 12pt;'>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">주차</div>
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<input type="text" name="hotel_fac4"
									style='border: 0; padding: 0; width: 500px; height: 50px; align: center; border-width: 0; font-size: 12pt;'>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">체크인</div>
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<input type="text" name="hotel_start_time"
									style='border: 0; padding: 0; width: 500px; height: 50px; align: center; border-width: 0; font-size: 12pt;'>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">체크아웃</div>
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<input type="text" name="hotel_end_time"
									style='border: 0; padding: 0; width: 500px; height: 50px; align: center; border-width: 0; font-size: 12pt;'>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">주변관광지</div>
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<input type="text" name="hotel_travel"
									style='border: 0; padding: 0; width: 500px; height: 50px; align: center; border-width: 0; font-size: 12pt;'>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">가격</div>
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<input type="text" name="hotel_price"
									style='border: 0; padding: 0; width: 500px; height: 50px; align: center; border-width: 0; font-size: 12pt;'>
						</td>
					</tr>
				</table>
				<br>
				<table width=604 class="write_m">
					<input type="submit" bgcolor="#00AEF0" value="등록" class="write"style="margin-left: 760px;">
				</table>
				</form>
				<div class="foot1"></div>
				<footer></footer>
	
</body>
</html>