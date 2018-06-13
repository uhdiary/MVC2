<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, member.model.vo.Member" %>
<%
   Map<String, Member> memberMap = (Map<String, Member>)request.getAttribute("memberMap");
   Set<Map.Entry<String, Member>> entryset = memberMap.entrySet();
   Iterator<Map.Entry<String, Member>> iter = entryset.iterator();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">

$(function() {

   $("header").load("/hotel/view/common/header.jsp");
   $("footer").load("/hotel/view/common/footer.html");
   
});

</script>
<style type="text/css">
.h21{background-color:gold; text-align:center; padding:10px 0; color: #464543;}

#joinform{
   width:825px;
   height:520px;
   margin:0 auto;
   }
   #tex, #search{ height:20px;}
   .top{
      height: 60px;
   }
   .bottom{
		height:-20px;
   }
   .f11{border:none; width:100%; }
   .dataView table td{width:50px; height:60px; border-top:1px solid #ccc; text-align:center;}
   .dataView table th{height:40px; border-top:1px solid #ccc; background:#00AEF0;  color: #464543;}
   
   .btnCenter{text-align:right; padding-top:5px;}
   .btnCenter input, #button2{width:107px; height:30px; font-weight:bold;}
</style>
</head>
<body>
   <header>
    </header>
    <div class="top"></div>
   <h2 class="h21">관리자 회원 목록</h2>
   <br>
	<form action="/hotel/mall" method="post" id="joinform"
		onsubmit="return vaildate();">
		<fieldset class="f11">
			<legend>
			</legend>
			<div class="dataView">
				<table border="1" cellspacing="0">
					<tbody>
						<tr>
							<th width="7%"><label for="user_id">아이디</label></th>
							<th width="7%"><label for="user_name">이름</label></th>
							<th width="7%"><label for="gender">성 별</label></th>
							<th width="30%"><label for="address">주 소</label>
							<th width="17%"><label for="email">이메일</label></th>
							<th width="20%"><label for="phone">전화번호</label></th>
							<th width="30%"><label for="enroll_date">가입날짜</label></th>
						</tr>
						
						<%
                 		while(iter.hasNext()){
                     	Map.Entry<String, Member> entry = iter.next();
                  	    Member member = entry.getValue();
                 		%>
                 		
						<tr>
							<td><a href="/hotel/myinfo?user_id=<%= member.getUser_id() %>"><%= member.getUser_id() %></a></td>
							<td><%= member.getUser_name() %></td>
							<td><%= member.getGender() %></td>
							<td><%= member.getPostal() %> <%= member.getAddress() %></td>
							<td><%= member.getEmail() %>@<%= member.getEmail_o() %></td>
							<td><%= member.getPhone() %>-<%= member.getPhone_o() %>-<%= member.getPhone_t() %></td>
							<td><%= member.getEnroll_date() %></td>
						</tr>
						<%  } %>
					</tbody>
				</table>
			</div>
<!-- 			<div class="btnCenters">
			 <select id="search" name="search" title="검색" >
                              <option value="">선택</option>
                              <option value="id">아이디</option>
                              <option value="gender">성별</option>
                              <option value="address">주소</option>
                              <option value="date">가입날자</option>
                           </select>
			<input id="tex" type="text" size="30"> <input id="button2" type="button" value="검색">
			</div> -->
			<br>
			<div class="btnCenter">
            <a href="/hotel/view/manager/enrollForm.html"><input id="button1" type="button" value="회원가입" /></a>
         </div>
		</fieldset>
		<br>
		<br>
	</form>
	<div class="bottom">
		<footer></footer>
	</div>
</body>
</html>