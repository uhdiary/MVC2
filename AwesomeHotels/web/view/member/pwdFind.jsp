<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "member.model.vo.Member" %>
<%
  Member loginUser = (Member)session.getAttribute("loginUser");       
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#phone").hide();
	 $('input[name="choiceWay"]').change(function(){
		
		 if($(this).val() == "phone"){
      
           $("#email").hide();
           $("#phone").show();   
           $("#user_id").text("");
           $("#email").val("");
           $('#user_name').val("");
           $('#user_id').val("");
        }else{
      
           $("#phone").hide();
           $("#email").show();
           $("#user_id").text("");
           $("#phone").val("");
           $("#phone_o").val("");
           $("#phone_t").val("");          
           $('#user_name').val("");
           $('#user_id').val("");
        }
    });  
});

	function bringPwd() {
		var user_id1 = $('#user_id').val();
		var user_name1 = $('#user_name').val();
		var email1 = $('#email1').val();
		var email_o1 = $('#email_o').val();
		var phone1 = $('#phone1').val();
		var phone_o1 = $('#phone_o').val();
		var phone_t1 = $('#phone_t').val();
		var pwd = new String();
		$.ajax({
            url : '/hotel/mpwd',
            type : 'post',
            data : {
            	user_id : user_id1,
            	user_name : user_name1,
            	email : email1,
            	email_o : email_o1,
            	phone : phone1,
            	phone_o : phone_o1,
            	phone_t : phone_t1      
                  },    
            dataType : "json",
            success : function(data) {
            	
            	pwd = new String(data.user_pwd);
            	if ((data.user_pwd) != null && (data.user_pwd) != "") {
        		
            		window.location.href = "/hotel/view/member/pwdfin.jsp?user_pwd="+pwd;
                  
               } else{                
            	   $("#button1").click(function(){
               		$("#btn").dialog({
               			  title:"비밀번호 찾기 실패!!", width:250, 
                             height:170, modal:true, resizable:false,
                             show:"clip", draggable:false
               		});
               	});
           		}
            }
         });		
	}
</script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" type="text/css">
<style type="text/css">

.f11{ width:300px; text-align:center;}
.btnCenter{text-align:center; padding-top:5px;}
.btnCenter input{width:200px; height:30px; font-weight:bold;  border-radius:20px; background-color:#00AEF0; color:#fff;}
 #joinform{
   width:325px;
   height:170px;
   margin:0 auto;
   text-align:center;
   }
   .span1{color:#00AEF0;}
   .rom{ text-align:center;}
   .ui-widget-header{ /* 대화상자 타이틀 */
	background:none;
	border:1px solid #ff5e00;
	background:#00AEF0;
	}
</style>
</head>
<body>
<div id = "btn" style = "display: none">
   			<p>입력이 잘못되었습니다. <br>확인 바랍니다</p>
			</div>
<form action="/hotel/mpwd" method="post" id="joinform">
<fieldset class="f11">
<legend>
				<span class="span1">비밀번호 찾기</span>
			</legend>
			<div class="dataView" align="center">
	<table >
		<tr>
			<td>선택</td>
			<td><input type="radio" name="choiceWay" id="ch1" value="email" checked>이메일</td>
			<td><input type="radio" name="choiceWay" id="ch2" value="phone">전화번호</td>
		</tr>
		<tr>      
      <td colspan = "3" class="rom"><input type="text" name="user_id" id="user_id" class="UserInfo"  size="25" placeholder="아이디  입력" /></td>
      </tr>
		<tr>      
      <td colspan = "3" class="rom"><input type="text" name="user_name" id="user_name" class="UserInfo"  size="25" placeholder="이름 입력" /></td>
      </tr>
       <tr id="email" class="rom">
       <td colspan = "3"><input type="text" name="email1" id="email1" class="UserInfo"  size="10" /> @ 
       <input type="text" name="mail_o" id="email_o" class="UserInfo"  size="9" /></td>
       </tr>      
       <tr id="phone" class="rom">
       <td colspan = "3"><input type="text" name="phone1" id="phone1" class="UserInfo"   size="4" /> - 
       <input type="text" name="phone_o" id="phone_o" class="UserInfo"   size="4" /> - 
       <input type="text" name="phone_t" id="phone_t" class="UserInfo"  size="4" /></td>
       </tr>       
      <tr>
      <td colspan="2" class="labelButtonTd1"><label id="foundPwd" ></label></td>
      </tr>
       </table>
       <br>
	</div>
	 <div class="btnCenter">
				<input id="button1" type="button" value="비밀번호 찾기 " onclick="bringPwd();" >
				<p>
				<a href="/hotel/view/member/idFind.jsp"><input id="button2" type="button" value="아이디 찾기 " /></a>
				<input id="button3" type="button" value="닫기" onclick="javascript:window.close()" />
			</div>
			<div id = "msg1" align="center" style = "display: none; margin:auto;"><p id="p5"></p></div>
			
	</fieldset>
	</form>
</body>
</html>