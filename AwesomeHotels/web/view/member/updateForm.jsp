<!-- directive(지시자) tag : page 지시자, taglib(라이브러리) 지시자, include 지시자 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- page 지시자 태그는 jsp 파일안에서 한번만 사용함
	  단, import 속성은 분리해서 작성할 수 있음
 -->
<%@ page import="member.model.vo.Member, java.sql.Date" %><!-- 여기서 import는 속성이므로 , 를 사용해서 추가 임포트  -->
<!-- scriptlet tag : jspService() 메소드 안에 작성되는 소스가 됨 -->
<%
	Member member = (Member)request.getAttribute("member");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>updateForm</title>
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(function() {

   $("header").load("/hotel/view/common/header.jsp");
   $("footer").load("/hotel/view/common/footer.html");
   
   //비번 정규식
   $('#user_pwd').change(function () {
      var pwd = $(this).val();
      var idchk =/^[!@#$%^*+=-]{1}[a-zA-Z0-9!@#$%^*+=-]{7,11}$/; 
      if(!idchk.test(pwd)){
         //정규식에 만족하지 않음
         $('#pwdLabel').text('특수문자로 시작하고 문자,숫자,특수문자 총 8 ~ 12자');
         $(this).css('border','3px solid red');
         $(this).focus();
      }else{
         $('#pwdLabel').text('');
         $(this).removeAttr('style');
      }         
   });
   
 //이메일
   $('#email').change(function () {
	      var email = $(this).val();
	      var idchk =/^[a-zA-Z]{1}[a-zA-Z0-9]{5,12}$/; 
	      if(!idchk.test(email)){
	         //정규식에 만족하지 않음
	         $('#emailLabel').text('이메일 영문시작으로 영문,숫자 총 6~13자 이내');
	         $(this).css('border','3px solid red');
	         $(this).focus();
	      }else{
	         $('#emailLabel').text('');
	         $(this).removeAttr('style');
	      }         
	   });
   $('#email_o').change(function () {
	      var ema = $(this).val();
	      var idchk =/^[A-Za-z]{1}[a-zA-Z]{1,7}[.]{1}[a-zA-Z]{3}$/; 
	      if(!idchk.test(ema)){
	         //정규식에 만족하지 않음
	         $('#emailLabel').text('이메일 주소 오류');
	         $(this).css('border','3px solid red');
	         $(this).focus();
	      }else{
	         $('#emailLabel').text('');
	         $(this).removeAttr('style');
	      }         
	   });
   
   //전호번호
   $('#phone').change(function () {
	      var pos = $(this).val();
	      var idchk =/^[0-1]{3}$/; 
	      if(!idchk.test(pos)){
	         //정규식에 만족하지 않음
	         $('#phoneLabel').text('앞번호 오류');
	         $(this).css('border','3px solid red');
	         $(this).focus();
	      }else{
	         $('#phoneLabel').text('');
	         $(this).removeAttr('style');
	      }         
	   });
   $('#phone_o').change(function () {
	      var pho = $(this).val();
	      var idchk =/^[0-9]{4}$/; 
	      if(!idchk.test(pho)){
	         //정규식에 만족하지 않음
	         $('#phoneLabel').text('가운데 번호 오류');
	         $(this).css('border','3px solid red');
	         $(this).focus();
	      }else{
	         $('#phoneLabel').text('');
	         $(this).removeAttr('style');
	      }         
	   });
   $('#phone_t').change(function () {
	      var pho = $(this).val();
	      var idchk =/^[0-9]{4}$/; 
	      if(!idchk.test(pho)){
	         //정규식에 만족하지 않음
	         $('#phoneLabel').text('끝 번호 오류');
	         $(this).css('border','3px solid red');
	         $(this).focus();
	      }else{
	         $('#phoneLabel').text('');
	         $(this).removeAttr('style');
	      }         
	   });
   
});
function getEmail(frm)
{
 frm.email_o.value = frm.selectEmail.options[frm.selectEmail.selectedIndex].text;
}
</script>
<style type="text/css">
	#joinform{
   width:825px;
   height:630px;
   margin:0 auto;
   }
    .top{
      height: 60px;
   }
   .bottom{
		top: -20px;
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
   .add input[name="postal"]{width:66px;}
   .add input[name="address"]{width:400px;}
   .mobileNo input[type="text"]{width:66px;}
   .btnCenter{text-align:center; padding-top:5px;}
   .btnCenter input{width:107px; height:30px; font-weight:bold;}
   #zipcode{width:130px; height:30px;}
    .dataView table td p{font-size:12px; color:red;}
   .all {
	box-shadow:inset 0px 1px 0px 0px #ffffff;
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ededed), color-stop(1, #dfdfdf) );
	background:-moz-linear-gradient( center top, #ededed 5%, #dfdfdf 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed', endColorstr='#dfdfdf');
	background-color:#ededed;
	border-top-left-radius:3px;
	border-top-right-radius:3px;
	border-bottom-right-radius:3px;
	border-bottom-left-radius:3px;
	text-indent:0;
	border:1px solid #dcdcdc;
	display:inline-block;
	color:#000000;
	width:50px; height:50px;
	font-size:12px;
	font-weight:bold;
	text-decoration:none; text-align:center; text-shadow:1px 1px 0px #ffffff;
	}	
	.all:hover {
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #dfdfdf), color-stop(1, #ededed) );
	background:-moz-linear-gradient( center top, #dfdfdf 5%, #ededed 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#dfdfdf', endColorstr='#ededed');
	background-color:#dfdfdf;
	}
</style>
</head>
<body>
 	<header>
    </header>
    <div class="top"></div>
	<center>
		<h1 class="h21"><%= member.getUser_name() %>님 정보 수정
		</h1>
		<form action="/hotel/mupdate" id="joinform">
			<fieldset class="f11">
				<div class="dataView">
					<table class="to">
						<tbody>
							<tr>
								<th scope="row"><label for="user_id">아이디 : </label></th>
								<td><%=member.getUser_id()%>
								<input type="hidden" name="user_id" value="<%= member.getUser_id() %>"></td>
							</tr>
							<th scope="row"><label for="user_pwd">비밀번호 : </label></th>
							<td><input id="user_pwd" type="password" name="user_pwd"
								required maxlength="15" autocomplete="off" placeholder="비밀번호 입력" />
								<p id="pwdLabel"></td>
							</tr>
							<tr>
								<th scope="row"><label for="user_pwd1">재확인 </label></th>
								<td><input id="user_pwd1" type="password" name="user_pwd1" required maxlength="15" autocomplete="off" placeholder="비밀번호 재입력" /></td>
								<p id="pwd1Label">
							</tr>
							<tr>
								<th scope="row"><label for="user_name">이 름 : </label></th>
								<td name="user_name"><%=member.getUser_name()%>
								<input type="hidden" name="user_name" value="<%= member.getUser_name() %>"></td>
							</tr>
							<tr>
								<th scope="row"><label for="gender">성 별 : </label></th>
								<td>
									<%
										String gender = (member.getGender() == 'M') ? "남자" : "여자";
										out.print(gender);
									%>
									<input type="hidden" name="gender" value="<%= member.getGender() %>">
								</td>
							</tr>
							<tr>
								<th scope="row"><label for="user_no">주민번호 : </label></th>
								<td name="user_no"><%=member.getUser_no()%>
								<input type="hidden" name="user_no" value="<%= member.getUser_no() %>"></td></td>
							</tr>
							<tr class="email">
								<th scope="row"><label for="email">이메일</label></th>
								<td><input id="email" type="text" name="email"
									value="<%=member.getEmail()%>" /> @ <input id="email_o"
									type="text" name="email_o" value="<%=member.getEmail_o()%>" />
									<select id="selectEmail" name="selectEmail" title="이메일선택"
									onChange="getEmail(this.form);">
										<option value="direct">직접입력</option>
										<option value="naver">naver.com</option>
										<option value="daum">daum.net</option>
										<option value="nate">nate.com</option>
										<option value="google">google.com</option>
								</select><br>
								<span class="point">
                           아이디 비밀번호 분실시 필요한 정보이므로, 정확하게 기입해 주십시오.
                        </span>            
                        <p id="emailLabel"> </td>
							</tr>
							<tr class="mobileNo">
								<th><label for="phone">전화번호 : </label></th>
								<td><input id="phone" type="text" name="phone" maxlength=3 value="<%= member.getPhone() %>" /> - 
								<input type="text" name="phone_o" id="phone_o" maxlength=4 value="<%= member.getPhone_o() %>"> - 
								<input type="text" name="phone_t" id="phone_t" maxlength=4 value="<%= member.getPhone_t() %>">
								<p id="phoneLabel"></td>
							</tr>
							<tr class="add">
								<th scope="row"><label for="address">주 소 : </label>
								<td><input type="text" name="postal" id="postal" maxlength=5 value="<%=member.getPostal()%>" readonly> 
								<input type="button" class="all" id="zipcode" onclick="searchZipcode();" value="우편번호 검색"><br>
									<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
								<img src="//i1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="Postcode()" alt="접기 버튼">
								</div> 
									<p>
										<input type="text" name="address" id="address"
											value="<%=member.getAddress()%>"></td>
							</tr>
					</table>
				</div>
         <div class="btnCenter">
         
            <input id="button1" type="submit" value="수  정"/>
            <a href="/hotel/myinfo?user_id=<%= member.getUser_id() %>"><input id="button2" type="button" value="수정취소" /></a>
         </div>
			</fieldset>
		</form>
	</center>
	<div class="bottom">
		<footer></footer>
	</div>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
<img src="//i1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
</div>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    // 우편번호 찾기 화면을 넣을 element
    var element_layer = document.getElementById('layer');

    function closeDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_layer.style.display = 'none';
    }

    function searchZipcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = data.address; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 기본 주소가 도로명 타입일때 조합한다.
                if(data.addressType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postal').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address').value = fullAddr;
                

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_layer.style.display = 'none';
            },
            width : '100%',
            height : '100%'
        }).embed(element_layer);

        // iframe을 넣은 element를 보이게 한다.
        element_layer.style.display = 'block';

        // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
        initLayerPosition();
    }

    // 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
    // resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
    // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
    function initLayerPosition(){
        var width = 400; //우편번호서비스가 들어갈 element의 width
        var height = 460; //우편번호서비스가 들어갈 element의 height
        var borderWidth = 2; //샘플에서 사용하는 border의 두께

        // 위에서 선언한 값들을 실제 element에 넣는다.
        element_layer.style.width = width + 'px';
        element_layer.style.height = height + 'px';
        element_layer.style.border = borderWidth + 'px solid';
        // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
        element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 'px';
        element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 'px';
    }
</script>
</body>
</html>