<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member" %>   
<% 
	Member member = (Member)session.getAttribute("member");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	var user_id = $('input[name=user_id]').val();
    var user_pwd = $('input[name=user_pwd]').val();
    
    if(user_id.length==0 || user_pwd.length==0){
    	$("#button1").click(function(){
    		$("#btn").dialog({
    			  title:"로그인 실패!!", width:250, 
                  height:150, modal:true, resizable:false,
                  show:"clip", draggable:false
    		});
    	});
    }
});
function login(){
	    var user_id = $('input[name=user_id]').val();
	    
	    var user_pwd = $('input[name=user_pwd]').val();
	      
	    $.ajax({
		   
	         url : '/hotel/login',
	         type : 'post',
	         data : {
	        	 user_id : user_id,
	            user_pwd : user_pwd
	         },
	         dataType : "json",
	         success : function(data) {
	           if ((data.result) !="" ) { self.close();  opener.location.reload();
	            } 
	            else {
	            }}
	    });
	    
	}
	
/* function idFind(window){
	open("/hotel/view/member/idFind.jsp", "idFindn",  "left="+(screen.availWidth-400)/2+", top="+(screen.availHeight-180)/2+", width=400px,height=180px");	
} */



</script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" type="text/css">
<style type="text/css">
	.btnCenter{text-align:center; padding-top:5px;}
   .btnCenter input{width:200px; height:30px; font-weight:bold;  border-radius:20px; background-color:#00AEF0; color:#fff;}
   .dataView table td input{width:188px; height:19px; padding:5px 0 4px 10px; border:1px solid #ccc;}
   .dataView table{width:25%; border-bottom:2px solid #ccc; border-collapse:collapse;}
   .span1{color:#00AEF0;}
    #joinform{
   width:235px;
   height:250px;
   margin:0 auto;
   text-align: center;
   }
   
   .ui-widget-header{ /* 대화상자 타이틀 */
	background:none;
	border:1px solid #ff5e00;
	background:#00AEF0;
	}
[type="radio"],input[type="checkbox"]{vertical-align:middle;}

</style>
</head>
<body>
	<form method="post" id="joinform" >
		<fieldset>
			<legend>
				<span class="span1">로그인</span>
			</legend>
			<div class="dataView">
				<table summary="아이디, 비밀번호">
					<tr>
						<th scope="row">
						<td><input id="user_id" type="text" name="user_id" required maxlength="15" placeholder="아이디 입력" />
						<p></td>
					</tr>
					<tr>
						<th scope="row"></th>
						<td><input id="user_pwd" type="password" name="user_pwd" required maxlength="15" autocomplete="off" placeholder="비밀번호 입력" />
						<p></td>
					</tr>
				</table>
			</div>
			<br>
			<div class="btnCenter">
				<input id="button1" type="button" value="로그인" onclick="login();"/>
			</div>
			<div id = "btn" style = "display: none">
   			<p>아이디 / 비밀번호 확인 <br> 하십시오!!</p>
			</div>
			<br>
			<div class="btnCenter">
				<a href="/hotel/view/member/idFind.jsp"><input id="button2" type="button" value="ID/비밀번호 찾기" /></a>
			</div>
		</fieldset>
		<br>
		<br>
	</form>
</body>
</html>