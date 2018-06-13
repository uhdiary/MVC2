<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,paper.model.vo.Paper,member.model.vo.Member, hotel.model.vo.Hotel" %>
<%
	ArrayList<Paper> list = (ArrayList<Paper>)request.getAttribute("list");
	Member loginUser = (Member)session.getAttribute("loginUser");
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
	   String sitem = "title";
	   if (keyword == null)
	      keyword = "";
	   else
	      sitem = (String) request.getAttribute("sitem");

%>    
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<script type="text/javascript"
   src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">

$(function(){
	
	$("header").load("/hotel/view/common/header.jsp");
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
		
	  		}
	});
	
  		
});

	
</script>
<link rel="stylesheet"
   href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css"
   type="text/css">
<style type="text/css">
.line1 {
	border-top: 2px solid #00AEF0;
}

.line2 {
	border-top: 2px solid #00AEF0;
}

.line3 {
	border-top: 2px solid #00AEF0;
}

.line4 {
	border-top: 2px solid #00AEF0;
}

.line5 {
	border-top: 2px solid #00AEF0;
	
}
.line1 {
	border-bottom: 2px solid #c7c7c7;
}

.line2 {
	border-bottom: 2px solid #c7c7c7;
}

.line3 {
	border-bottom: 2px solid #c7c7c7;
}

.line4 {
	border-bottom: 2px solid #c7c7c7;
}

.line5 {
	border-bottom: 2px solid #c7c7c7;
}
.hh{
	list-style: none
}
.hh td{
	border-bottom: 2px solid #d5d5d5;
	font-size:12px;
	cursor: pointer;
  	transition: box-shadow .2s, transform .2s, opacity;
}
.hh:hover{
    box-shadow: 0 15px 20px rgba(0,0,0,0.2);
    transform: translate(0, -4px)
}
#rr th{
	font-size: 14px;
	font-color:#4b4b4b;
}
.write {
	background-color: #00AEF0;
	text-decoration: none;
	font-family: Arial;
	line-height: 10px;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	border-radius: 10px;
	text-align: center;
	vertical-align: middle;
	display: inline-block;
	font-size: 15px;
	color: #ffffff;
	width: 70px;
	height: 2px;
	padding: 13px;
	margin-left: 787px;
}

.write:active {
	position: relative;
	top: 3px
}
#bd2 {
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
}

.bt {
	background-color: #8f8f8f;
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
	margin-right: 320px;
}

.bt:active {
	position: relative;
	top: 3px
}
.bt:focus{
	outline: none;
}
.text {	
	resize: none;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	display: inline;
	border: 1 solid;
	font-size: 12px;
	height: 30px;
	position:relative;
	left:150px;
}
.text:focus{
	outline: none;
}
label {
	font-size: 11pt;
}
.board_a {
	float: left;
	padding: 4px;
	color: black;
	font: bold 12px tahoma;
	border: 0px solid black;
	text-align: center;
	text-decoration: none;
	position:relative;
	left:380px;
}

.board_a a:hover, a:focus {
	color: black;
	border: 1px solid #00AEF0;
	background-color: #00AEF0;
}
#sitem{
	position:relative;
	left:200px;
}
h2{
	-webkit-text-fill-color:transparent;
	color:transparent;
	background-image: url('view/paper/images/tree.png');
	-webkit-background-clip: text;
	background-clip:text;
	font-size:40px;
	line-height:60px;
	font-weight: bold;
	position:relative;
	left:370px;	
	transition:2s eade all;
	background-position:bottom;
}
h2:hover{background-position:top;}
</style>
</head>
<link rel="stylesheet" 
 href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css"
  type="text/css">
  <script type="text/javascript"
   src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<body>
<div id="msg1" style="display: none">
      <h3>검색값이 없습니다!!</h3>	
      </div>
      <div id = "msg2" style = "display: none">
 <h3>해당값이 없습니다.</h3>
 </div>
 <div id = "msg3" style = "display: none">
 <h3>해당값이 없습니다.</h3>
 </div>
<header></header>
<br>

<a href="/hotel/pls"><h2>호텔 리뷰</h2></a>
<table id="tt" cellspacing=0 width=800 border=0 align="center">
<tr bgcolor='#fbfbfb' id="rr">
	<th width=50 class="line1" style="height:50px">번호</th>
	<th width=400 class="line2">제 목</th>
	<th width=80 class="line3">글쓴이</th>
	<th width=80 class="line4">작성일</th>
	<th width=80 class="line5">조회</th>
</tr>

<%	
	for(Paper p : list){
%>
	<tr class="hh">
		<td align="center" style="color:#330099; height:50px;" ><%= p.getPaper_no() %></td>
		<td style="color:gray" height="15opx">
		<% if(loginUser != null){ %>
		<a href="/hotel/pdts?paper_no=<%= p.getPaper_no() %>" style="color:#4b4b4b">
			<%= p.getPaper_title() %></a>
		<% }else{ %>
			<%= p.getPaper_title() %>
		<%  } %>
		</td>
		<td align="center" style="color:gray" ><%= p.getPaper_writer() %></td>
		<td align="center" style="color:gray" ><%= p.getPaper_date() %></td>
		<td align="center" style="color:gray" ><%= p.getPaper_count() %></td>
	</tr>
<%  }  %>

</table><br>
<!--  로그인 상태일 때만 글쓰기 버튼 보이게 함 -->
<% if(loginUser != null){ %>
<tr>
	<td><a href="view/paper/paperWriteForm.jsp" class='write' bgcolor="#00AEF0">글쓰기</a></td>
</tr>
<% } %>
<div class="board_a">

<%
	if(currentPage <= 1){
%>[이전] &nbsp; 
<% }else{ %>
  <a href="/hotel/pls?page=<%= currentPage - 1 %>&keyword=<%=keyword%>&sitem=<%=sitem%>">[이전]</a> &nbsp;
<% } %>

<% for(int p = startPage; p <= endPage; p++){
		if(p == currentPage){	
%><b>[<%= p %>]</b> &nbsp;
<% 		}else{%>
	<a href="/hotel/pls?page=<%= p %>&keyword=<%=keyword%>&sitem=<%=sitem%>">[<%= p %>]</a> &nbsp;
<%     }} %>

<% if(currentPage >= maxPage){ %> [다음]
<% }else{ %>
	<a href="/hotel/pls?page=<%= currentPage + 1 %>&keyword=<%=keyword%>&sitem=<%=sitem%>">[다음]</a>
<% } %>
</div>
<center>
<form action="/hotel/pls">
<table id="bd2" width=959 height="120" border=0 align="center"
	bgcolor="white">
	<tr align="right">
	<td><input type="radio" id="sitem" name="sitem" value="title"
               <%if (sitem.equals("title")) {%> checked <%}%>><label id="sitem">제목</label>
            &nbsp; &nbsp;<input type="radio" id="sitem" name="sitem"
               value="writer" <%if (sitem.equals("writer")) {%> checked <%}%>><label id="sitem">작성자</label>
           </td> <td><input type="search" name="keyword" class="text" cols="23" ></td>
		
		<td><input type="submit" class='bt' bgcolor="f5f5f5" value="검색"></td>
		</td>
	</tr>
</table>
</form>
</center>
<br><br>

</body>
<footer></footer>
	
</body>
</html>