<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
margin: 0;
padding:0;
height:400px;	
}

.bl_tc2>a>img{
width: 100%;
height: 100%;
object-fit: cover;
}

.headForm{
display:none;
}
#tocplusWindow{
display:none;
}

.bl_tc2 {
    margin:auto;
    padding:15px;
    width:300px;
    border:none;
    border-radius:10px;
    background-color: #EEEFF1;
}
.text-field{
 font-size:14px;
 margin-bottom:10px;
 border:none;
 border-radius:5px;
 padding:10px;
 width:100%;
}
.submit-btn{
color:#EEEFF1;
font-size:18px;
font-weight:bold;
background-color: #02E862;
margin-bottom:30px;
padding:10px;
border: none;
border-radius: 5px;
width: 100%;
}
.submit-btn:hover{
cursor:pointer;
}


</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="bl_tc2">
<a href="main.do"><img src="./image/logo1.png"></a>
      <form action="login_result" method="post">
       <table>
		<tr>
		 <td> <label id="label">아이디 </label><input type="text" name="mid" class="text-field"></td>
		 </tr>
		 <tr>
		<td><label id="label">비밀번호</label><input type="password" name="mpw" class="text-field"><td>
		</td>
		 <tr>
		<td><input type="submit" value="로그인" class="submit-btn"></td>
		</tr>
		</table>
	</form>
<a href="main.jsp?page=idpw.jsp">아이디를 잊으셨나요?</a><br>
   <a href="main.jsp?page=idpw.jsp">비밀번호를 잊으셨나요?</a>
   </div>  
   
   
 
</body>
</html>