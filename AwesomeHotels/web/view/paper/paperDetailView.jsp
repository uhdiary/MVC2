<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="paper.model.vo.Paper, member.model.vo.Member" %>
<%
	Paper paper = (Paper)request.getAttribute("paper");
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
 <head>
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">

$(function(){
	
	$("header").load("/hotel/view/common/header.jsp");
	$("footer").load("/hotel/view/common/footer.html");
});

	
</script>
<style type="text/css">
#up {
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
	position:relative;
	left:135px;
}

#up:active {
	position: relative;
	top: 3px
}
#del {
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
	width: 46px;
	height: 2px;
	padding: 13px;
	position:relative;
	left:110px;
}

#del:active {
	position: relative;
	top: 3px
}
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
#reply{
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
	width: 50px;
	height: 2px;
	padding: 13px;
	position:relative;
	left:500px;
}
#list {
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
	width: 50px;
	height: 2px;
	padding: 13px;
	position:relative;
	left: 500px;
}

#list:active {
	position: relative;
	top: 3px
}

#reply:active {
	position: relative;
	top: 3px
}

table.type09 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    position: relative;
    left:80px;

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
 <title>게시판</title>
 </head>
 <body>
 <header></header>
 <br><br>
<form action="/hotel/pus?paper_no=<%=paper.getPaper_no()%>" method="post">

<table style="width: 800px;" class="type09">               

      <caption style="font-size:25px">호텔 리뷰</caption>
                     
      <tr>                           
         <th>번호</th>                  
         <td><%= paper.getPaper_no() %></td>
         <th>작성자</th>
         <td> <%= paper.getPaper_writer() %></td>
         <th>등록일</th>
         <td> <%= paper.getPaper_date() %></td>
      </tr>

      <tr>
         <th>제목</th>   
         <td colspan="3"><input type="text" size="30" maxlength="50" name="ptitle" style="font-size:12pt;" value="<%= paper.getPaper_title() %>"></td>
         <th>조회수</th>
         <td><%= paper.getPaper_count() %></td>
      </tr>

      <tr>
         <th height="300px;">내용</th>                  
         <td  colspan="5"><textarea name="pcontent" rows="5" cols="50" style="resize: none; height:300px; font-size:13pt; border:0px;"><%= paper.getPaper_content() %></textarea></td>
      </tr>
   </table>

<br/>


     <% if(loginUser.getUser_id().equals(paper.getPaper_writer()) == true){ %>
	<td><input type="submit" value="수정" id="up"></td> &nbsp; &nbsp;
	<td><a href="/hotel/pds?paper_no=<%= paper.getPaper_no() %>" id="del">삭제</a></td>
	&nbsp; &nbsp;
	<% } %>
	<td><a href="/hotel/pls" id="list">목록</a></td>
	<td><a href = "/hotel/prs?paper_no=<%= paper.getPaper_no() %>" id="reply">답글</a></td>
	</tr>
   </td>
  </tr>
 </table>
 </form>
 <br><br>
 <footer></footer>
</body> 
</html>