<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	Member loginUser = (Member) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
   src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("header").load("/hotel/view/common/header.jsp");
		$("footer").load("/hotel/view/common/footer.html");
	});
	
	function check(){
		   var frm=document.writeform;
		  var length=frm.length-1;
		   
		   for(var i=0;i<length; i++){
		      if(frm[i].value==""){
		         $("#msg1").dialog({title:"내용이없습니다.", width:280, 
		              height:165, modal:true, resizable:false,
		              show:"clip", hide:true, draggable:false});
		         frm[i].focus();
		         
		         return false;
		      }
		   }
		   return true;
		}

	
	
</script>
<link rel="stylesheet" 
 href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css"
  type="text/css"> 
  
<style type="text/css">

table.write {
	width: 70%;
}

table.write th {
	height: 40px
}

#boardContent {
	margin-left: 5px;

}

#button1 {
	background: #00AEF0;
	width: 100px;
	height: 40px;
	color: white;
	border-radius: 10px;
	position: relative;
}

#aa {
	background: #F7F7F7;
}

table.type09 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;

}
table.type09 thead th {
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #369;
    border-bottom: 3px solid #036;
}
table.type09 tbody th {
    width: 80px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #f3f6f7;
}
table.type09 td {
    width: 500px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}
#boardTitle{
	border:none;
}

#boardWrite{
	border:none;
}

#boardContent{
	border:none;
}
</style>
</head>
<body>
<div id = "msg1" style = "display: none"><!-- 화면상으로는 안보임 -->
 <h3>내용을 입력하여 주세요!!</h3></div>
	<header></header>
	<br>
	<br>
	
	<center>
		<form  name="writeform" action="/hotel/bwrite" onsubmit="return check()">

		<table class="type09">
			<thead>
				<tr>
					<th style="font-size:25px" scope="cols" colspan="2">문의사항 글쓰기</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">제목</th>
					<td><input type="text" id="boardTitle" name="boardTitle"
						size="80px" style="height: 37px; text-align: center;"></td>
				</tr>
				<tr>
					<th scope="row">작성자</th>
				<td><input type="text" id="boardWrite" name="boardWrite"
						size="80px" style="height: 27px; text-align: center;"
						value="<%=loginUser.getUser_id()%>" readonly></td>
				</tr>
				<tr>
					<th scope="row">내용</th>
					<td id="con"><textarea id="boardContent"
							name="boardContent" rows="20" cols="50"
							style="width: 97%; height: 97%;"></textarea></textarea></td>
				</tr>
			</tbody>
		</table>

		<br> <input id="button1" type="submit" value="등록">
		<tr>
			<input id="button1" type=button value="취소"
				OnClick="javascript:history.back(-1)">
		</tr>
		</form>

	</center>
	<br>
	<br>
	<footer></footer>
</body>
</html>