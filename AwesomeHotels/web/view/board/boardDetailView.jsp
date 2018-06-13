<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="board.model.vo.Board, member.model.vo.Member" %>
<%
	Board board = (Board)request.getAttribute("board");
	Member loginUser = (Member)session.getAttribute("loginUser");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항 내용</title>
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("header").load("/hotel/view/common/header.jsp");
		$("footer").load("/hotel/view/common/footer.html");
	});
	
</script>
<style type="text/css">
.line {
	border-bottom: 1px solid #2C4162;
}

#button1 {
	background: #00AEF0;
	width: 100px;
	height: 40px;
	color: white;
	border-radius: 10px;
	position: relative;
}

#update {
	background: #00AEF0;
	width: 100px;
	height: 40px;
	color: white;
	border-radius: 10px;
	position: relative;

}

#reply {
	background: #00AEF0;
	width: 100px;
	height: 40px;
	color: white;
	border-radius: 10px;
	position: relative;
	right : 11px;

}

#back {
	background: #00Aef0;
	width: 80px;
	height: 30px;
	color: white;
	border-radius: 5px;
	position: relative;
	right: 10px;

}

table.type09 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;

}
table.type09 caption {
    padding: 10px;
    text-align:left;
    font-weight: bold;
    vertical-align: top;
    color: #369;
    border-bottom: 3px solid #036;
    
    
}
table.type09 tbody th {
    width: 250px;
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
</style>
</head>
<body>
<header></header><br/><br/>

<center>
<form action="" method="post">

<table style="width: 600px;" class="type09">					

		<caption style="font-size:25px">문의사항글</caption>
							
		<tr>									
			<th>번호</th>						
			<td><%= board.getBoardNo() %></td>
			<th>작성자</th>
			<td> <%= board.getBoardWriter() %></td>
			<th>등록일</th>
			<td> <%= board.getBoardDate() %></td>
		</tr>

		<tr>
			<th>제목</th>	
			<td colspan="3"><%= board.getBoardTitle() %></td>
			<th>조회수</th>
			<td><%= board.getReadCount() %></td>
		</tr>

		<tr>
			<th height="300px;">내용</th>						
			<td  colspan="5"><pre><%= board.getBoardContent() %></pre></td>
		</tr>
	</table>

<br/>

<table >
<% if(loginUser.getUser_id().equals(board.getBoardWriter()) == true){ %>
<input id="update" type="button" value="수정하기" onclick = "location.href = '/hotel/bupdateview?boardno=<%= board.getBoardNo() %>'"> &nbsp;
<input id="update" type="button" value="삭제하기" onclick = "location.href= '/hotel/bdel?boardno=<%= board.getBoardNo() %>'">
&nbsp; &nbsp;
<% }else if(loginUser.getUser_code().trim().equals("2") == true){ %>
<input id="update" type="button" value="삭제하기" onclick = "location.href= '/hotel/bdel?boardno=<%= board.getBoardNo() %>'">
&nbsp; &nbsp;
<% } 
if(loginUser.getUser_code().trim().equals("2") == true){ %>
<input id="reply" type="button" value="답변달기" onclick = "location.href= '/hotel/breply?boardno=<%= board.getBoardNo() %>'">
&nbsp; &nbsp;
<% }%>
</table>
<br><br>
<a  id="back" href="/hotel/blist">목록으로 이동</a> &nbsp;
<br><br>
</form>
</center>
<footer></footer>
</body>
</html>