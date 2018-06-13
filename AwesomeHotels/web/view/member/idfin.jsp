<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>   
<% 
	String user_id = request.getParameter("user_id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"></script>
<style type="text/css">
.f11{ width:365px; text-align:center;}
.btnCenter{text-align:center; padding-top:5px;}
.btnCenter input{width:200px; height:30px; font-weight:bold;  border-radius:20px; background-color:#00AEF0; color:#fff;}
.dataView table{width:100%; border-bottom:2px solid #ccc; border-collapse:collapse;}
.dataView table th{width:99px; height:44px; text-align:60px;}
.dataView table th{width:99px; height:44px; text-align:center;}
 #joinform{
   width:325px;
   height:170px;
   margin:0 auto;
   text-align:center;
   }
   .span1{color:#00AEF0;}
.dataView table tr th{align:center;}
</style>
</head>
<body>
	<form action="">
	<fieldset class="f11">
         <legend><span class="span1">아이디 찾기 결과</span></legend>
		<div class="dataView">
		<table summary="아이디">
               <tbody class="b">
			 <tr>
                     <th scope="row">아이디:</th>
                     <td id="foundId3"><%=user_id %></td>
             </tr>
             <tr>
             	<td colspan = "2"><h5>아이디 찾기를 성공 하셧습니다.</h5></td>
             </tr>
         </tbody>
         </table>
         <div class="btnCenter">
            <a href="/hotel/view/member/pwdFind.jsp"><input id="button1" type="button" value="비밀번호 찾기" /></a>
            <input id="button2" type="button" value="닫기" onclick="javascript:window.close()" />
         </div>
		</div>
		</fieldset>
	</form>
</body>
</html>