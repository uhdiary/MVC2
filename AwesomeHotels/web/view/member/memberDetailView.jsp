<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	Member member = (Member)request.getAttribute("member");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>내 정보 보기</title>
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(function() {

   $("header").load("/hotel/view/common/header.jsp");
   $("footer").load("/hotel/view/common/footer.html");
   
});
</script>
<style type="text/css">
	#joinform{
   width:705px;
   height:500px;
   margin:0 auto;
   }
    .top{
      height: 60px;
   }
.bottom{
height:-20px;
}

   .f11{
   	border: 0px;
   }
	.h21{background-color:gold; text-align:center; padding:10px 0; color: #464543;}
	
	.dataView table{width:100%; border-bottom:2px solid #ccc; border-collapse:collapse;}
   .dataView table th{width:99px; height:44px; border-top:1px solid #ccc; text-align:left;}
   .dataView table tr:first-child td,.dataView table tr:first-child th{border-top:2px solid #ccc;}
   .dataView th label{display:inline-block; width:99px; padding:10px 0 5px 10px;}
   .dataView table td{border-top:1px solid #ccc; padding:5px 10px;}
    .btnCenter{text-align:center; padding-top:5px;}
   .btnCenter input{width:107px; height:30px; font-weight:bold;}
</style>
</head>
<body>
	 <header>
    </header>
	<center>
		<div class="top"></div>
		<h1 class="h21">내 정보</h1>
		<form id="joinform">
			<fieldset class="f11">
				<div class="dataView">
					<table class="to">
						<tbody>
							<tr>
								<th scope="row">아이디 :</th>
								<td><%= member.getUser_id() %></td>
							</tr>
							<tr>
								<th scope="row">이 름 :</th>
								<td><%= member.getUser_name() %></td>
							</tr>
							<tr>
								<th scope="row">성 별 :</th>
								<td>
									<%
										String gender = (member.getGender() == 'M') ? "남자" : "여자";
										out.print(gender);
									%>
								</td>
							</tr>
							<tr>
								<th scope="row">주민번호 :</th>
								<td><%= member.getUser_no() %></td>
							</tr>
							<tr>
								<th scope="row">이메일 :</th>
								<td><%= member.getEmail() %> @ <%= member.getEmail_o() %></td>
							</tr>
							<tr class="mobileNo">
								<th>전화번호 :</th>
								<td><%= member.getPhone() %> - <%= member.getPhone_o() %> -
									<%= member.getPhone_t() %></td>
							</tr>
							<tr>
								<th scope="row">주 소 :</th>
								<td><%= member.getPostal() %><p><%= member.getAddress() %></td>
							</tr>
					</table>
				</div>
				<div class="btnCenter">
            <a href="/hotel/upform?user_id=<%= member.getUser_id() %>"><input id="button1" type="button" value="수정" OnClick="openNew()"/></a>
            <a href="/hotel/mdel?user_id=<%= member.getUser_id() %>"><input id="button2" type="reset" value="탈퇴"/></a>
         </div>
			</fieldset>
		</form>
	</center>
	<div class="bottom">
   <footer></footer>
 	</div>
</body>
</html>