<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Client</title>
</head>
<link rel="stylesheet" type="text/css" href="Seller.css">
<body>

<h3>Login into your Client Account :</h3>
<form action="ProcessClientLogin" method="post">
<label>Username : </label>
<input type="text" name="username"><br>
<label>Password : </label>
<input type="password" name="password"><br>
<input type="submit" value="Login" >
</form>
<br>

</body>
</html>