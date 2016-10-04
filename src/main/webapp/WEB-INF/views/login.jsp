<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font color="red">
       Votre login ou le mot de passe est incorrecte!! <br/><br/>
      </font>
    </c:if>
	<form action="j_spring_security_check" method="post">
		<table>
			<tr>
				<td>Login</td>
				<td><input type="text" name="j_username"></td>
			</tr>
			<tr>
				<td>Pass word</td>
				<td><input type="password" name="j_password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>