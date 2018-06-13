<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	Member member = (Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<title>내 정보 보기</title>
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(function() {

   $("header").load("/hotel/view/common/mgrevheader.jsp");
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

#click12{
background:#00AEF0;
color:white;
border:none;
height:50px;
width:90px;
border-radius: 5px;
position: relative;
top:15px;
left:590px;
}
</style>
</head>
<body>
	 <header>
    </header>
	<div>
		<div class="top"></div>
		<h1 class="h21">예약 회원 정보</h1>
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
					<button id="click12" onclick="javascript:history.back(-1)" >뒤로가기</button>
				</div>
				
			</fieldset>
		</form>
		
	</div>
	<div class="bottom">
   <footer></footer>
 	</div>
</body>
</html>