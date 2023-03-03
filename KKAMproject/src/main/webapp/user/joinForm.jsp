<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm.jsp</title>
<script type="text/javascript" src="script/jquery-3.6.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		alert("준비");
		
		$('#join').submit(function(){
			
			if($('.name').val()==""){
				alert("이름을 입력하세요");
				$('.name').focus();
				return false;
			}
			
			if($('.id').val()==""){
				alert("아이디를 입력하세요");
				$('.id').focus();
				return false;
			}
			
            if($('.pw').val()==""){
            	alert("비밀번호 입력하세요");
				$('.pass').focus();
				return false;
            }
          
            if($('.pw2').val()==""){
            	alert("비밀번호2 입력하세요");
				$('.pw2').focus();
				return false;
            }
            
            if($('.pw').val() != $('.pw2').val()){
            	alert("비밀번호 다름");
				$('.pw2').focus();
				return false;
            }
            
            if($('.nick').val()==""){
            	alert("닉네임을 입력하세요");
				$('.nick').focus();
				return false;
            }
            
            if($('.birth').val()==""){
            	alert("생년월일을 입력하세요");
				$('.birth').focus();
				return false;
            }
            
            if($('.phone').val()==""){
            	alert("휴대폰 번호를 입력하세요");
				$('.phone').focus();
				return false;
            }
            
            if($('.email').val()==""){
            	alert("이메일을 입력하세요");
				$('.email').focus();
				return false;
            }
            
            if($('.address').val()==""){
            	alert("주소를 입력하세요");
				$('.address').focus();
				return false;
            }
            
            if($('.addressD').val()==""){
            	alert("상세 주소를 입력하세요");
				$('.addressD').focus();
				return false;
            }
          
		});
		
	$('.dup').click(function(){
		if($('.id').val()==""){
			alert("아이디 입력하세요");
			$('.id').focus();
			return false;
		}

		$.ajax({
			url:'IdCheck.kkam',
			data:{'id':$('.id').val()},
			success:function(result){
				if(result.trim()=="아이디 중복"){
					$('.divresult').html(result).css("color","red");
				}else{
					$('.divresult').html(result).css("color","blue");
				}
			}
		});

	});
	
	$('.nickcheck').click(function(){
		if($('.nick').val()==""){
			alert("닉네임 입력하세요");
			$('.nick').focus();
			return false;
		}

		$.ajax({
			url:'NickCheck.kkam',
			data:{'nick':$('.nick').val()},
			success:function(result){
				if(result.trim()=="닉네임 중복"){
					$('.nickCK').html(result).css("color","red");
				}else{
					$('.nickCK').html(result).css("color","blue");
				}
			}
		});

	});
	
	
	
	});
</script>
</head>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<body>
<h1>Join</h1>
<form action="JoinPro.kkam" method="post" id="join">
이름: <input type="text" name="name" class="name"><br>
아이디: <input type="text" name="id" class="id">
	  <input type="button" value="중복 확인" class="dup"><br>
	  <div class="divresult"></div><br>	  
비밀번호: <input type="password" name="pw" class="pw"><br>
비밀번호 확인: <input type="password" name="pw2" class="pw2"><br>
닉네임: <input type="text" name="nick" class="nick"><input type="button" value="중복 확인" class="nickcheck"><br>
	  <div class="nickCK"></div><br>
생년월일: <input type="date" name="birth" class="birth"><br>
휴대폰 번호: <input type="tel" name="phone" class="phone"><br>
이메일: <input type="email" id="email" name="email" required><br>
우편번호: <input type="text" id="pcode" placeholder="우편번호" onclick="DaumPostcode()" required> 
	    <input type="button" value="우편번호 찾기" id="joinbutton" onclick="DaumPostcode()"><br>
주소: <input type="text" name="address" id="address" placeholder="주소"><br>
상세주소: <input type="text" name="addressD" id="addressD" placeholder="상세주소"><br>
<%@include file="addressMap.jsp"%>
<input type="submit" value="회원가입" class="join">




</form>
</body>
</html>