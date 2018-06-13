<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="hotel.model.vo.Hotel"%>
	<%@ page import="member.model.vo.Member" %>
	<%
	Hotel list = (Hotel)request.getAttribute("list");
	String juso[] = list.getHotel_address().split("/");
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		
		$("#checkin").datepicker();
		$("#checkin").datepicker("option", "dateFormat", "yymmdd"); //데이터 포맷으로 날짜의 반환 타입을 지정
		$("#checkin").datepicker("option", "showAnim", "slideDown");
		$("#checkin").datepicker("option", "minDate", 0);
		
		$("#checkout").datepicker();
		$("#checkout").datepicker("option", "dateFormat", "yymmdd"); //데이터 포맷으로 날짜의 반환 타입을 지정
		$("#checkout").datepicker("option", "showAnim", "slideDown");
		$("#checkout").datepicker("option", "minDate", 0);
		$("header").load("/hotel/view/common/header.jsp");
		$("footer").load("/hotel/view/common/footer.html");
		
		
		
		$("#button1").hide();
		
		
		//체크박스 동의 해야 서브밋 연결
		document.f2.onsubmit=function(){

			
			
			var act = document.f2.accept;
			var login1 = $(".login2").val();
		
			if(act.checked==false){
				$("#p5").html("예약확인 체크를 확인해주세요.");
				$("#msg1").dialog({
	  				title:"예약확인하시고 체크후 예약을 진행해주세요.", width:500,
	  				height:130, modal:true, resizable:false,
	  				show:true, hide:true, draggable:false
	  			});
				act.focus();
				return false;
				
			}else if(login1 == null){
				$("#p5").html("로그인 되어 있지 않습니다.");
				$("#msg1").dialog({
	  				title:"로그인후 예약을 진행하여 주세요", width:500,
	  				height:130, modal:true, resizable:false,
	  				show:true, hide:true, draggable:false
	  			});
				return false;
			}
			
		}
		
		
		
		
		
		
		
		
		$(".day1").click(function(){
			
			var checkin1 = $("#checkin").val();
			var checkout1 = $("#checkout").val();
			var hotelno1= $(".hotel_no").val();
			
			
			 var _date  = new Date();
			 var _year  = _date.getFullYear(); // YYYY 4자리
			 var _month = "" + (_date.getMonth() + 1);
			 var _day   = "" + _date.getDate();
			 if( _month.length == 1 ) _month = "0" + _month;
			 if( ( _day.length ) == 1 ) _day = "0" + _day;
			 var tmp = "" + _year + _month + _day;
			
			
			 
			 var pel = $(".day11").val();
			 
			
			 var re = /^[0-5]+$/;
			 if(!re.test(pel)) {
				 $("#p5").html("5명까지 예약이 가능합니다.");
					$("#msg1").dialog({
		  				title:"5명까지 예약이 가능합니다.", width:500,
		  				height:130, modal:true, resizable:false,
		  				show:true, hide:true, draggable:false
		  			});
		               pel.value="";
		               pel.focus();
		               return;
		        }
			 
			 var rb = /^[0]+$/;
			 if(rb.test(pel)) {
				 $("#p5").html("최소 한명을 입력하셔야 합니다.");
					$("#msg1").dialog({
		  				title:"최소 한명을 입력하셔야합니다.", width:500,
		  				height:130, modal:true, resizable:false,
		  				show:true, hide:true, draggable:false
		  			});
		               pel.value="";
		               pel.focus();
		               return;
		        }
			 
			 var ra = /^[0-9]+$/;
			 if(!ra.test(checkin1)&&!ra.test(checkout1)) {
				 $("#p5").html("날짜만 입력하세요");
					$("#msg1").dialog({
		  				title:"날짜만 입력하세요.", width:500,
		  				height:130, modal:true, resizable:false,
		  				show:true, hide:true, draggable:false
		  			});
		               pel.value="";
		               pel.focus();
		               return;
		        }
			 

			 
			 
			var flag = 'N';
			
			
			if(checkin1 < checkout1 && tmp <= checkin1 && pel != ""){
				
				flag='Y';
			
				
		$.ajax({
			url : "/hotel/resc",
			data : {hotel_no:hotelno1, checkin:checkin1, checkout:checkout1 },
			type : "get",
			dataType : "json",
			success : function(data){
				
				//console.log(data);
				var jsonStr = JSON.stringify(data);  //객체를 문자열로 변환
				
				//console.log(jsonStr);
				var json = JSON.parse(jsonStr); //문자열을 배열 객체로 바꿈
				
				var values=" ";
				for(var i in json.list){
					//한글 깨짐을 막기 위해 문자 인코딩 처리한 json 객체의 값은 decodeURIComponent() 로 디코딩 처리함
					values += json.list[i];
					
				}

				
				
				$("#p5").html(values + "<br>" + "고객님이 선택한 위의 날짜는 이미 예약이 찼습니다."+"<br>"+ "다른 날짜를 선택해 주세요");
				$("#msg1").dialog({
	  				title:"예약하신 날짜를 다시 선택해주세요", width:500, 
	  				height:160, modal:true, resizable:false,
	  				show:true, hide:true, draggable:false
	  			});
			},error: function(data){
				$("#p5").html("예약이 가능합니다.");
				$("#msg1").dialog({
	  				title:"예약을 진행하여 주세요.", width:500,
	  				height:130, modal:true, resizable:false,
	  				show:true, hide:true, draggable:false
	  			});
				$("#button1").show();
				
				
				//가격 조정
				var priceyul = $("#price").val();
				//날짜계산
				var day22 = checkout1 - checkin1;
				//세금계산
				var price12 = ((parseInt(priceyul) + parseInt(day22*20000)) + (parseInt(pel*9000))) * 0.1;
				//총합산
				var price345 = (parseInt(priceyul) + parseInt(day22*20000)) + (parseInt(pel*9000))
				
				
				$("#price123").html(price12);
				$("#price").val(price345);
				
				$(".checkin2").val(checkin1);
				$(".checkout2").val(checkout1);
				$(".pel2").val(pel);
				
			}
		});
		
			}else if(checkin1 >= checkout1){
				flag='N';
				$("#p5").html("날짜를 확인해 주세요");
				$("#msg1").dialog({
	  				title:"날짜를 다시 입력해 주세요", width:500,
	  				height:130, modal:true, resizable:false,
	  				show:true, hide:true, draggable:false
				});
			}else if(tmp > checkin1){
				flag='N';
				$("#p5").html("입력하신 날짜는 지난 날짜입니다. 날짜를 다시 입력해 주세요.");
				$("#msg1").dialog({
	  				title:"날짜를 확인해 주세요", width:500,
	  				height:130, modal:true, resizable:false,
	  				show:true, hide:true, draggable:false
				});
				
				
			}else if(pel == ""){
				flag='N';
				$("#p5").html("인원수를 입력해 주세요");
				$("#msg1").dialog({
	  				title:"인원수를 입력해 주세요.", width:500,
	  				height:130, modal:true, resizable:false,
	  				show:true, hide:true, draggable:false
				});
				
			}
			
			
		
	});		//click
	

	});
	

</script>
<style type="text/css">
.top{
height:30px;
}
.revervet {
	position:relative;
	left:-50px;
	font-weight: bold;
	width: 900px;
	height: 500px;
	border: 3px solid #00AEF0;
	text-align: center;
	border-radius: 5px;
	color:#464543;
	padding: 5px;
	color:#464543;
}

#checkin, #checkout {
	font-size: 17px;
	height: 25px;
	width:150px;
	text-align: center;
	border: 3px solid #00AEF0;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	
}

#button1 {
	background: #00AEF0;
	width: 100px;
	height: 50px;
	color: white;
	border: 0px;
	border-radius: 5px;
}


table{
	border: 3px solid #00AEF0;
}
.chetext {
	color:white;
	font-weight: bold;
	
}
.footgong{
height:30px;
}
.footta{
border:none;
}

.scenter{
position: relative;
left:80px;
}
.imgho{
width:375px;
height:250px;
border-radius: 5px;
border: 5px solid yellow;

}
.topsolid{
border-radius: 7px;
width:400px;
}

.day1{
position: relative;
left:50px;
background: white;
width: 100px;
height: 50px;
border-radius: 5px;
color:#00AEF0;
font-weight: bold;
border:0px;
font-size: 12px;
}
.name23{
color:#00AEF0;
font-size:30px;

}
.not1{
padding: 20px;
position: relative;
top:-20px;
}
.topon{
	position:relative;
	left:-50px;
	font-weight: bold;
	width: 900px;
	border: 3px solid #00AEF0;
	text-align: center;
	border-radius: 5px;
	color:#464543;
	padding: 5px;

}
.padd{
height:8px;

}
.day2{
position: relative;
top:-10px;
left:50px;
color: white;

}
.day5{
	position:relative;
	left:-50px;
	height:180px;
	font-weight: bold;
	width: 900px;
	text-align: center;
	font-color:white;
	padding: 5px;
	border:none;
	background: #00AEF0;
	border-radius: 5px;

}
.day11{
position: relative;
top:9px;
left:50px;
width:50px;
height: 25px;
text-align: center;
border: 3px solid #00AEF0;
border-radius: 7px;
font-size: 20px;
color:#464543;
}




#price{
background:#00AEF0;
color:white;
border:none;
text-align:right;
font-size:20px;
}
.p123{
position: relative;
left:80px;
}
.p56{
position: relative;
left:207px;
}
.p57{
position: relative;
left:200px;
}
.p124{
position: relative;
left:70px;
}
#button1{
position: relative;
left:190px;
}

#msg1{
font-weight: bold;
size: 15px;


}
div #p1{
vertical-align:middle;
}

</style>
</head>
<body>

		<header></header>
		<div id = "msg1" align="center" style = "display: none; margin:auto;"><p id="p5"></p></div>
				<div class="scenter">
		<section>
			<div class="reverse1">
					<div class="footgong"><input type="hidden" class="hotel_no" value="<%=list.getHotel_no() %>"></div>
				<table class="topon">
					<tr style="height: 120px;">
						<td><img class="imgho" src="<%= list.getHotel_link()%>1.jpg"></td>
						<td class="topsolid" align="left" colspan="2"><div class="not1">
						<span class="name23"><%=list.getHotel_name() %></span><br><br>
						주소 : <%=juso[0] %><br><br>
						여행지 : <%=list.getHotel_travel() %></div>
						</td>
					</tr>
					</table>
					<div class="padd"></div>
					<form action="/hotel/resc?hotel_no=<%=list.getHotel_no()%>" method="post" name="res" id="res">
					<table class="day5">
					<tr>
						<td class="inertd2">
							<div>
								<label class="chetext">체 크 인</label><br>
								<br> <input type="text" id="checkin" name="checkin" maxlength=8>
							</div>

						</td>
						<td class="inertd2">
							<div>
								<label class="chetext">체 크 아 웃</label><br>
								<br> <input type="text" maxlength=8 id="checkout" name="checkout">
							</div>
						</td>
						<td><span class="day2">인원</span><br>
						<input type="text" class="day11" maxlength=1></td>
						<td class="inertd2" style="width:300px; heigth:100px;"><label class="chetext"><input type="button" class="day1" value="예약 가능 조회"></label></td>
					</tr>
					</table>
					</form>
					<div class="padd"></div>
					<form action="/hotel/res?hotel_no=<%=list.getHotel_no()%>" method="post" name="f2" >
					<table class="revervet">
					<tr>
						<td align="left" colspan="3">체크인 시간 : <%=list.getHotel_start_time() %><br><br>
						체크아웃 시간 : <%=list.getHotel_end_time()%><br><br>
						서비스 : <%=list.getHotel_fac2() %></td>
					</tr>

					<tr>
						<td colspan="2" style="text-align: left;">호텔 세금 및 서비스 차지</td>
						<td> <span class="p57" id ="price123"></span><span class="p56">원</span></td>
					</tr>
					<tr>
						<td colspan="2"
							style="text-align: left; background: #00AEF0; color: white; border-radius: 5px;">최종금액(KRW)</td>
						<td style="background: #00AEF0; color: white; border-radius: 5px;"><input type="text" id="price" class="p124" readonly name="price" value="<%= list.getHotel_price()%>"> <span class="p123">원</span></td>
					</tr>
					<tr style="width: 100px; height: 100px;">

						<td colspan="2" style="text-align: left;">
							<p>위의 호텔정보를 확인하세요</p> <input type="checkbox" name="accept">위의 호텔정보가
							맞습니까?
						</td>
						<td>
						<input type="hidden" name="checkin" class="checkin2">
						<input type="hidden" name="checkout" class="checkout2">
						<input type="hidden" name="people" class="pel2">
						
						<input type="submit" id="button1" value="예약하기"></td>
					</tr>
				</table>
				<% if(loginUser != null){ %>
				<input type="hidden" name="userid" class="login2" value="<%=loginUser.getUser_id()%>">
				<% }%>
				</form>
				
			</div>
		</section>
		</div>
		<div class="footgong"></div>
		
		<footer></footer>

</body>
</html>