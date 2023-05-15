<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="Seller.css">


<meta charset="UTF-8">
<title>Account Created</title>
</head>
<body>
<h3>${username} logged</h3>
<br>
<h3>View bill</h3>
<form method="post" action="ProcessClientActions">
<label>Username : </label>
<input type="text" name="username"><br>
    <button type="submit">View Bill</button>
</form>

<br>
<h3>View calls</h3>
<form method="get" action="ProcessClientActions">
<label>Username : </label>
<input type="text" name="username"><br>
    <button type="submit">View Calls</button>
</form>
<br>
<h3>Pay bill</h3>
<form method="post" action="ProcessClientActions2">
<label>Username : </label>
<input type="text" name="username"><br>
    <button type="submit">Pay Bill</button>
</form>
<br>

<form action="index.jsp">
  <button type="submit">Logout</button>
</form>

</body>

</html>