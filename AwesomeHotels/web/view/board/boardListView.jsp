<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*,board.model.vo.Board, member.model.vo.Member"%>
<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
	Member loginUser = (Member) session.getAttribute("loginUser");

	//총 목록수
	int listCount = ((Integer) request.getAttribute("listCount")).intValue();
	//현재 보여질 목록 페이지
	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
	//현재 페이지(19)의 시작 페이지(11)
	int startPage = ((Integer) request.getAttribute("startPage")).intValue();
	//현재 페이지(19)의 마지막 페이지(20)
	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	//맨 마지막 페이지
	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();

	String keyword = (String) request.getAttribute("keyword");
	String sitem = "title";
	if (keyword == null)
		keyword = "";
	else
		sitem = (String) request.getAttribute("sitem");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항</title>
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" type="text/css">
<script type="text/javascript">
	$(function() {
		$("header").load("/hotel/view/common/header.jsp");
		$("footer").load("/hotel/view/common/footer.html");
<%if (listCount == 0) {%>
	$("#msg1").dialog({
			title : "검색",
			width : 430,
			height : 165,
			modal : true,
			resizable : false,
			draggable : false
		});
<%}%>

	$("table#bo tr:gt(1)").hover(
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

.ui-widget-header {
	background: linear-gradient(to right, #00Aef0, #ded8f3);
	color: white;
}

.bg{
	background:linear-gradient(to top, #f3f6f7, #FFFFFF, #f3f6f7);  
   color:black;
   box-shadow: 0 15px 20px rgba(0,0,0,0.2);
   transform: translate(0, -4px);
  }
  
#ul {  
    list-style:none;  
    display:inline;  
}  

#ul  a {  
    padding:4px;  
    width:13px;  
    color:#000;  
    font:bold 11px tahoma;  
    text-align:center;  
    text-decoration:none;  
}  
#ul a:hover, #ul  a:focus {  
    color:#fff;  
    background-color:#00AEF0;  
}  
</style>
</head>
<body>
	<div id="msg1" style="display: none">
		<h3>검색값이 없습니다.</h3>
	</div>
	<header></header>
	<br>
	<center>
		<hr width="600" size="2" color="#00AEF0">
		<hr width="600" size="1" color="#00AEF0">
		<font size="5" color="#464543"> 문의사항 </font>&nbsp;&nbsp; 총 목록수(<%=listCount%>)
		<hr width="600" size="1" color="#00AEF0">
		<hr width="600" size="2" color="#00AEF0">
		<br>

		<table id="bo" width="100%" cellpadding="0" cellspacing="0" border="0" align="center">

			<tr height="5">
				<td width="5"></td>
			</tr>

			<tr
				style="background: url('/hotel/view/board/images/table_mid.gif') repeat-x; text-align: center; height:32px">
				<td width="73" ><b>번호</b></td>
				<td width="379"><b>제목</b></td>
				<td width="73"><b>작성자</b></td>
				<td width="164"><b>작성일</b></td>
				<td width="58"><b>조회수</b></td>
			</tr>

			
			<%
				for (Board b : list) {
			%>

			<tr>
				<td class="line" height=50px; align="center"><%=b.getBoardNo()%></td>
				<td class="line" height=50px; align="center">
					<%
						if (loginUser != null) {
					%> <a href="/hotel/bdetail?boardno=<%=b.getBoardNo()%>"> <%=b.getBoardTitle()%></a>

					<%
						} else {
					%> <%=b.getBoardTitle()%> <%
 	}
 %>
				</td>

				<td class="line" height=50px; align="center"><%=b.getBoardWriter()%></td>
				<td class="line" height=50px; align="center"><%=b.getBoardDate()%></td>
				<td class="line" height=50px; align="center"><%=b.getReadCount()%></td>
				<%
					}					
				%>
			

		</table>

		<br>
		<div id="button" align="right">

			<!--  로그인 상태일 때만 글쓰기 버튼 보이게 함 -->
			<%
				if (loginUser != null) {
			%>

			<button id="button1"
				onclick="javascript:location.href='view/board/boardWriteForm.jsp';">글쓰기</button>

			<%
				}
			%>
		</div>

		<!-- search검색 -->
		<center>

			<form action="/hotel/blist" method="post">
				<br> <input type="radio" id="sitem" name="sitem" value="title"
					<%if (sitem.equals("title")) {%> checked <%}%>> 제목으로 검색
				&nbsp; &nbsp; <input type="radio" id="sitem" name="sitem"
					value="writer" <%if (sitem.equals("writer")) {%> checked <%}%>>
				작성자로 검색 <br> <input type="search" name="keyword" size="30"
					value="<%=keyword%>"> <input type="submit" value="검색">

			</form>
		</center>
		<br>

		<!-- 페이징부분 -->
		<center>
			<div id="ul">
				<%
					if (currentPage <= 1) {
				%>
				[이전] &nbsp;
				<%
					} else {
				%>
				<a
					href="/hotel/blist?page=<%=currentPage - 1%>&keyword=<%=keyword%>&sitem=<%=sitem%>">[이전]</a>
				&nbsp;
				<%
					}
				%>

				<%
					for (int p = startPage; p <= endPage; p++) {
						if (p == currentPage) {
				%><b>[<%=p%>]
				</b> &nbsp;
				<%
					} else {
				%>
				<a
					href="/hotel/blist?page=<%=p%>&keyword=<%=keyword%>&sitem=<%=sitem%>">[<%=p%>]
				</a> &nbsp;
				<%
					}
					}
				%>

				<%
					if (currentPage >= maxPage) {
				%>
				[다음]
				<%
					} else {
				%>
				<a
					href="/hotel/blist?page=<%=currentPage + 1%>&keyword=<%=keyword%>&sitem=<%=sitem%>">[다음]</a>
				<%
					}
				%>

			</div>
		</center>
		<br>

		<footer></footer>
</body>
</html>