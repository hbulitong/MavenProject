<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align:center">让暴风雨来的更猛烈些！！！</div>
	<form id="test" name="test" action="/MavenProject/test/simple" method="post">
		<input type="hidden" name="user" value="litong"/>
	</form>
	<br>
	<br>
	<br>
	<div style="text-align:center"><input type="button" name="submit" value="发表留言" onclick="SendForm();"/></div>
</body>

</html>
<script language="javascript">
     function SendForm () 
      {
    	 document.test.submit();
      }
 
 
 </script>