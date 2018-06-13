<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%@ page import="paper.model.vo.Paper"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	Paper paper = (Paper)request.getAttribute("paper");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>paperWriteForm</title>
<script type="text/javascript"
   src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
  <script>tinymce.init({ selector:'textarea' });</script>
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">

$(function(){
	
	$("header").load("/hotel/view/common/header.jsp");
	$("footer").load("/hotel/view/common/footer.html");
	
	
});	


</script>
<style type="text/css">
#gg {
	position:relative;
	left:80px;
}

input[type=text]{
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
}

input[type=text]:focus{
	outline: none;
}
label {
	font-size : 11pt;
}
.write {
	background-color: #00AEF0;
	text-decoration: none;
	font-family: Arial;
	line-height: 10px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 10px;
	text-align: center;
	vertical-align: middle;
	display: inline-block;
	font-size: 15px;
	color: #ffffff;
	width: 70px;
	height: 2px;
	padding: 13px;
	position:relative;
	left:650px;
}

.write:active {
	position: relative;
	top: 3px
}
.write1 {
	background-color: #00AEF0;
	text-decoration: none;
	font-family: Arial;
	line-height: 10px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 10px;
	text-align: center;
	vertical-align: middle;
	display: inline-block;
	font-size: 15px;
	color: #ffffff;
	width: 40px;
	height: 2px;
	padding: 13px;
	position:relative;
	left:650px;
}

.write1:active {
	position: relative;
	top: 3px
}
</style>
</head>
<body>
<div id = "msg1" style = "display: none"><!-- 화면상으로는 안보임 -->
 <h3>내용을 입력하여 주세요!!</h3></div>
<header></header>
<br><br>
<div id="gg">
<form action="/hotel/pws" method="post">
	
<br><br>
<table width="800" height="300" id="rr" border="0" cellspacing="0" style="border-color:#fbfbfb; border-top: 2px solid #00AEF0;">
	<tr><th><label>제목</label></th>
	<td>
	<input type="text" name="ptitle" size="50" style="height:20px; font-size:13pt;">
	</td></tr>	
	<tr><th><label>작성자</label></th>
	<td><input type="text" name="pwriter"  value="<%= loginUser.getUser_id() %>" readonly style="height:20px; font-size:13pt;"></td></tr>
	<tr><th><label>내용</label></th>
	<td><textarea name="pcontent" rows="5" cols="50" style="font-size:13pt;">
	</textarea></td></tr>
</table><br>
<table>		
	<tr>
	<td><input type="submit" class="write" value="등록"></td>
	<td><a href="/hotel/pls" class="write1">취소</a></td>
	</tr>
</table>
<br><br><br>

</form>
</div>
<footer></footer>
</body>
</html>