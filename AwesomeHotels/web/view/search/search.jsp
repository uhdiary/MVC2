<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, hotel.model.vo.Hotel" %>
<%@ page import="static common.JDBCTemplate.*, java.sql.*" %>
<%
	// 자동완성기능을 위한 JDBC 코드
	Connection con = getConnection(); 
	Statement st = con.createStatement();
	String sql = "select hotel_name from ahotel";
	ResultSet rs = st.executeQuery(sql);
	
	ArrayList<Hotel> list = 
	(ArrayList<Hotel>)request.getAttribute("list");
	//총 목록수
	int listCount = 0; // 검색값 총갯수
	int currentPage = 0; // 현재 페이지
	int startPage = 1; // 시작 페이지
	int endPage = 0; // 끝 페이지, 만약 검색값이 0일 경우 1 이상 0 이하 반복문, 출력없음
	int maxPage = 0; // 자료값 갯수 상으로 끝 페이지
	String check = "city"; // 라디오버튼을 도시로 검색하기로 초기화
	String keyword = ""; // 검색값 초기화
	if(list != null){
		listCount = ((Integer)request
				.getAttribute("listCount")).intValue();
		//현재 보여질 목록 페이지
		currentPage = ((Integer)request
				.getAttribute("currentPage")).intValue();
		//현재 페이지(19)의 시작 페이지(11)
		startPage = ((Integer)request
				.getAttribute("startPage")).intValue();
		//현재 페이지(19)의 마지막 페이지(20)
		endPage = ((Integer)request.getAttribute("endPage")).intValue();
		//맨 마지막 페이지
		maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
		check = (String)request.getAttribute("checkedItem");
		keyword = (String)request.getAttribute("keyword");
	}
%>   
<!doctype html>
<html lang="ko">
 <head>
  <meta charset="UTF-8">
  <title>Search</title>
  <link rel="stylesheet" type="text/css"
   href="/hotel/css/common.css">   
   <link rel="stylesheet" 
 href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css"
  type="text/css">  
  <style type="text/css">  
  #search_button{
  	height:68px;
  	width:120px;
  	background:#2C4162;
  	border:0;
  	font-size:40px;
  	border-radius:5px;
  	color:white;
  }
  #search_button:active{
  	position: relative;
  	top: 2px;
  	left: -1px;
  }
  div#search{
  	border-radius:5px;
  	width:74.5%;
  	height:70px;
  	background:#00AEF0;
  }
  #search_button:hover{
	color:white;
	background:#00AEF0;
  }
  .pageee{color:#464543;}
  .pagee{color:#464543;}
  .pagee:hover{
  	border:1px solid #464543;
  	font-size:17.15px;
  }
  .page{  	
  	color:#464543;
	border:2px solid #00AEF0;
  }
  .bg{
	background:linear-gradient(to top, #F4F2FB, #DED8F3);
	color:#2C4162;
	box-shadow: 0 15px 20px rgba(0,0,0,0.2);
    transform: translate(0, -4px);
  }
  .font{font-family:Verdana, sans-serif;}
  #uptable{color:white;}
  .menu{border-radius:5px;}  
  #searcharea{
	  height:25px;
	  border-radius: 5px;
	  width:200px;
	  padding:5px;
  }
  .ui-widget-header{ 
	background:linear-gradient(to right, #00AEF0, #DED8F3);
	color:white;
  }  
  .ui-autocomplete{
  	   width: 310px;
	   max-height: 250px;
	   overflow-y: auto;
	   overflow-x: hidden;
  }
  </style>
  <script src="/hotel/js/jquery-3.1.1.min.js"></script>  
  <script type="text/javascript"
   src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>     
  <script type="text/javascript">
  $(function(){
  	$("header").load("/hotel/view/common/header.jsp");
  	$("footer").load("/hotel/view/common/footer.html");
  	$("table#search tr:eq(0)").css("background", "#464543")
  	.css("color", "white");
  	$("table#search tr:gt(0)").hover(
			function(){
				$(this).addClass("bg");
			},
			function(){
				$(this).removeClass("bg");
			}
  	);
  	$("#search_button").click(function(){
  		var word = $("#searcharea").val().trim();  
  		if(word.length < 2 && word.length > 0){
  			$("#msg1").dialog({
  				title:"단어길이 부족!!", width:430, 
  				height:165, modal:true, resizable:false,
  				show:"clip", hide:true, draggable:false
  			});
  			return false;
  		}
  		if((/[ㄱ-ㅎ]/).test(word)){
  			$("#msg2").dialog({
  				title:"검색값 에러!!", width:280, 
  				height:165, modal:true, resizable:false,
  				show:"clip", hide:true, draggable:false
  			});
  			return false;
  		}
  		if((/[a-z]/).test(word)){
  			$("#msg3").dialog({
  				title:"소문자 에러!!", width:280, 
  				height:165, modal:true, resizable:false,
  				show:"clip", hide:true, draggable:false
  			});
  			return false;
  		}
  		$("#searchForm").submit(); // 이상 없으면 submit
  	});
  	$("#searcharea").keypress(function (evt) {
        if (evt.keyCode == 13){ // 엔터를 누르면
        	$("#search_button").click(); // 검색버튼 누른 효과주기
        	return false;
        }
    });  	
  	var hotels = [ // 호텔명들과 도시명들을 받을 배열
    	<%while(rs.next()){%>
    	{
    		value: "<%=rs.getString("hotel_name")%>",
    		label: "<%=rs.getString("hotel_name")%>"
    	},
    	<% } %>
    	{value: "부산", label: "부산"},
    	{value: "광주", label: "광주"},
    	{value: "서울", label: "서울"},
    	{value: "대전", label: "대전"},
    	{value: "울산", label: "울산"},
    	{value: "대구", label: "대구"},
    	{value: "제주", label: "제주"},
    	{value: "경기", label: "경기"},
    	{value: "인천", label: "인천"}
    ]; 
    $("#searcharea").autocomplete({
      minLength: 1,
      source: hotels,
      focus: function(event, ui) {
        $("#searcharea").val(ui.item.label);
        return false;
      }
    });    
    // 마우스 포커스시
    $("#searcharea").on("focus", function(){
    	$(this).attr("placeholder", ""); 
    });
    // 마우스 포커스아웃시 
    $("#searcharea").on("focusout", function(){ 
    	$(this).attr("placeholder", "호텔명이나 도시를 입력하세요."); 
    });
  });
  </script>
 </head>
 <body>
 <div id = "msg1" style = "display: none"><!-- 화면상으로는 안보임 -->
 <h3>두 글자 이상 검색 가능!!<br>단, 아무 글자도 입력 안할시 전체 검색!!</h3></div>
 <div id = "msg2" style = "display: none">
 <h3>검색값 오류!!<br>제대로 입력하십시오!!</h3></div>
 <div id = "msg3" style = "display: none">
 <h3>소문자 오류!!<br>대문자로 입력하십시오!!</h3></div>
 <header></header><br>
 <div id = "search">
 	<form id="searchForm" action = "/hotel/hsearch" method = "post">
	<table style = "width:950px" class = "font" id = "uptable"
	style = "height:100px"><tr>
	<td><h3><input type="radio" name="hotel"
	value = "city" <% if(check.equals("city")){ %>
	checked
	<% } %>>도시로 검색하기</h3></td>
	<td><h3><input type="radio" name="hotel" 
	value = "hotel" <% if(check.equals("hotel")){ %>
	checked
	<% } %>>호텔명으로 검색하기</h3></td>
	<td><input id = "searcharea" style = "border:0"
	name = "keyword" maxlength="17" value = "<%=keyword %>"
	placeholder = "호텔명이나 도시를 입력하세요."></td>
	<td align = "right">
	<input type = "button" id = "search_button" value = "검색">
	</td></tr>
	</table></form></div><br>
	<table style = "width:100%" id = "search" class = "font">
	<tr><td class = "menu" align = "center" width = "10%">
	<h2>사진</h2></td>
	<td width = "20%" align = "center" class = "menu"><h2>호텔명</h2></td>
	<td align = "center" class = "menu"><h2>주소</h2></td>
	<td align = "center" width = "10%" class = "menu">
	<h2>가격</h2></td></tr>
		<%
		if(list != null) { for(Hotel hotel : list){
			// 주소/lat/lng 로 DB 에 저장되있으므로 '/' 기준으로 split
			String a[] = hotel.getHotel_address().split("/");
		%>
		<tr>
			<td align = "center"><a href="/hotel/hinfo?hotel_no=<%=
			hotel.getHotel_no() %>">
			<img src = "<%=hotel.getHotel_link()%>1.jpg"
			width = "250" height = "170"></a></td>
			<td align = "center"><%= hotel.getHotel_name()%></td>
			<td align = "center"><%= a[0] %></td><!-- 주소 배열 중 첫번째 -->
			<td align = "center"><%= hotel.getHotel_price()%>원</td>
		</tr>		
		<% } } %>
	</table><br>
	<br><h3 align = "center">
<label class = "pageee">[이전]&nbsp;&nbsp;</label>
<% for(int p = startPage; p <= endPage; p++){
		if(p == currentPage){	
%><b class = "page">[<%= p %>]</b> &nbsp;
<% 		}else{%>
<a href="/hotel/hsearch?page=<%=p %>
&keyword=<%=keyword%>&hotel=<%= check%>" class = "pagee">
	[<%= p %>]</a> &nbsp;
<%     }} %><label class = "pageee">[다음]&nbsp;&nbsp;
</label></h3><br><br><hr><footer></footer>
</body>
</html>