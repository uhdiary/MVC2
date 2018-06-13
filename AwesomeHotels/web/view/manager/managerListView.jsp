<%@ page import="java.util.ArrayList, manager.model.vo.*"%>
<%@ page import="static common.JDBCTemplate.*, java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

	ArrayList<Manager> list = (ArrayList<Manager>) request.getAttribute("list");
	 //총 목록수
		int listCount = ((Integer)request.getAttribute("listCount")).intValue();
		//현재 보여질 목록 페이지
		int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
		//현재 페이지(19)의 시작 페이지(11)
		int startPage = ((Integer)request.getAttribute("startPage")).intValue();
		//현재 페이지(19)의 마지막 페이지(20)
		int endPage = ((Integer)request.getAttribute("endPage")).intValue();
		//맨 마지막 페이지
		int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
		/*
			총목록수가 1372개 일 때, 한 페이지에 목록을 10개씩 보이게 한다면
			138 페이지가 됨.
			현재 페이지가 13페이지의 목록을 보고 있다면, 아래 페이지 표시는
			다음과 같을 것임.
			
			[맨처음][이전]11 12 13 ... 20[다음][맨마지막]
		*/
		String keyword = (String) request.getAttribute("keyword");
		   String hitem = "hotel";
		   if (keyword == null)
		      keyword = "";
		   else
		      hitem = (String) request.getAttribute("hitem");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>managerListView</title>
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" 
 href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css"
  type="text/css">
  <script type="text/javascript"
   src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {

		$("header").load("/hotel/view/common/mgheader.html");
		$("footer").load("/hotel/view/common/footer.html");

		$(".bt").click(function(){
	  		var word = $(".text[name=keyword]").val();
	  		var idchk =/^[가-힣0-9]{20}$/; 
	  		if(word==""){
	  			$("#msg1").dialog({
	  				title:"오류", width:300, 
	  				height:150, modal:true, resizable:false,
	  				show:"clip", hide:"true", draggable:false
	  			});
	  			return false;
		
	  		}else if((/[ㄱ-ㅎ]/).test(word)){
  			$("#msg2").dialog({
  				title:"검색값 에러!!", width:280, 
  				height:165, modal:true, resizable:false,
  				show:"clip", hide:"true", draggable:false
  			});
  			return false;
  		}else if((/[a-z]/).test(word)){
  			$("#msg3").dialog({
  				title:"소문자 에러!!", width:280, 
  				height:165, modal:true, resizable:false,
  				show:"clip", hide:"true", draggable:false
  			});
  			return false;
  		}
		});
		
		$("table#search tr:eq(0)");
	  	$("table#search tr:gt(0)").hover(
				function(){
					$(this).addClass("bg");
				},
				function(){
					$(this).removeClass("bg");
				}
	  	);
		
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
	height: 5px;
	padding: 13px;
	align: center;
	bgcolor: #9f9f9f;
	position: relative;
	left:20%;
}
.bg{background:#FFF798; opacity:0.7;}

.write:active {
	position: relative;
	top: 3px
}

.write1 {
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
	height: 5px;
	padding: 13px;
	bgcolor: #9f9f9f;
	position:relative;
	left:81%;
}

.write1:active {
	position: relative;
	top: 3px
}

.write2 {
	bgcolor: #9f9f9f;
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
	height: 5px;
	padding: 13px;
	position:relative;
	left:82%;
}

.write2:active {
	position: relative;
	top: 3px
}

.write_m {
	margin-left: 345px;
	width: 604;
}

.bt {
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
	height: 5px;
	padding: 13px;
	position : relative;
	left: 720%;
}

.bt:active {
	position: relative;
	top: 3px
}

.text {
	position : relative;
	left: 313%;
	resize: none;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	display: inline;
	border: 1 solid;
	text-align: middle;
	font-size: 12xt;
}

.line1 {
	background: #00AEF0;
	color: white;
	border-radius: 5px;
}

.line2 {
	background: #00AEF0;
	color: white;
	font-weight: bold;
	border-radius: 5px;

}

.line3 {
	background: #00AEF0;
	color: white;
	font-weight: bold;
	border-radius: 5px;
}

.line4 {
	background: #00AEF0;
	color: white;
	font-weight: bold;
	border-radius: 5px;
}

.line5 {
	border-radius: 5px;
	background: #00AEF0;
	color: white;
	font-weight: bold;
}

.sel {
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	margin-left: 575px;
	position: relative;
	width: 100px;
	height: 30px;
	border: 1px solid #E9DDDD;
}

#center {
	align: center;
}

.bd2 {
	width: 959;
	height: 60;
	border: 0;
	position: relative;
	left: -20px;
}

input:focus {
	outline: none;
}

.no {
	position: relative;
	width: 100px;
	height: 80px;
}

.nono {
	position: relative;
	left: 30px;
}

.foot12 {
	height: 30px;
}

.check1 {
	position: relative;
	left: 23px;
}

.button {
	position: relative;
	left: 25px;
	width: 15px;
	height: 15px;
}

a.top {
	position: fixed;
	left: 90%;
	bottom: 50px;
	display: none;
}

#ht {
	position:relative;
	left:500px;
}


#ps {
	position:relative;
	left:33%;
	float: left;
	padding: 4px;
	margin-right: 3px;
	color: #000;
	font: bold 12px tahoma;
	border: 0px solid #eee;
	text-align: center;
	text-decoration: none;
}
.line222:hover{
    box-shadow: 0 15px 20px rgba(0,0,0,0.2);
    transform: translate(0, -4px);
}
</style>
</head>
<body>
<div id = "msg1" style = "display: none">
 <h3>검색값이 없습니다.</h3>
 </div>
 <div id = "msg2" style = "display: none">
 <h3>해당값이 없습니다.</h3>
 </div>
 <div id = "msg3" style = "display: none">
 <h3>해당값이 없습니다.</h3>
 </div>
	<div id="center">
		<header></header>
		<br><br>
		<form action="/hotel/mgsearch" id="listform">
			<table class="bd2">
			<tr>
			<td><a class='write' href="/hotel/view/manager/managerInsert.jsp">등록</a></td> 
			<td id="ht"><input type="radio" name="hitem" value = "hotel" <%if (hitem.equals("hotel")) {%> checked <%}%>><label id="hitem">호텔</label></td>
			<td id="ht"><input type="radio" name="hitem" value = "address" <%if (hitem.equals("address")) {%> checked <%}%>><label id="hitem">주소</label></td>
			<td><input type="search" class="text" name="keyword" style="height: 30px;"></td>
			<td><input type="submit" value="검색" class="bt"></td>
			</tr>
			</table>
		</form>
		<br>
		
			<table id="search" cellspacing=1 width=959 height=15 align="center">
				<tr style="bgcolor: #9f9f9f">
					<td class="line2" width="100"><p align=center>No</p></td>
					<td width=200 class="line3"><p align=center>호텔 전경</p></td>
					<td width=300 class="line4"><p align=center>호텔 이름</p></td>
					<td width=400 class="line5"><p align=center>호텔 주소</p></td>
				</tr>
				<%
					for (Manager m : list) { String a[] = m.getHotel_address().split("/");
				%>
				<tr class="line222">
					<td ><p class="nono" style="position:relative; left:40%;"><%=m.getHotel_no()%></p></td>
					<td ><a href="/hotel/mgone?hotel_no=<%= m.getHotel_no() %>">
					<img class="no" src="<%=m.getHotel_link()%>1.jpg" style="position: relative;left:23%;"></a> </td>

					<td><p align=center><%=m.getHotel_name()%></p></td>
					<td ><p align=center><%=a[0]%></p></td>
				</tr>

				<%
					}
				%>
			</table>
		<br>
<center>
<div>
<%
	if(currentPage <= 1){
%>[이전] &nbsp; 
<% }else{ %>
  <a href="/hotel/mglist?page=<%= currentPage - 1 %>&keyword=<%=keyword%>&hitem=<%=hitem%>">[이전]</a> &nbsp;
<% } %>

<% for(int p = startPage; p <= endPage; p++){
		if(p == currentPage){	
%><b>[<%= p %>]</b> &nbsp;
<% 		}else{%>
	<a href="/hotel/mglist?page=<%= p %>&keyword=<%=keyword%>&hitem=<%=hitem%>">[<%= p %>]</a> &nbsp;
<%     }} %>

<% if(currentPage >= maxPage){ %> [다음]
<% }else{ %>
	<a href="/hotel/mglist?page=<%= currentPage + 1 %>&keyword=<%=keyword%>&hitem=<%=hitem%>">[다음]</a>
<% } %>
</div class="a123">
</div><br>

	</center>
	<div class="foot12"></div>
	<div class="a">
      
    </div>
	<footer></footer>

</body>
</html>