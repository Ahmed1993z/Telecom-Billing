<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Admin</title>
<link rel="stylesheet" type="text/css" href="Seller.css">
</head>
<body>
<h3>Login into your Admin Account :</h3>
<form action="ProcessAdminLogin" method="post">
<label>Username : </label>
<input type="text" name="username"><br>
<label>Password : </label>
<input type="password" name="password"><br>

<input type="submit" value="login" >
</form>
<br>
</body>
</html>