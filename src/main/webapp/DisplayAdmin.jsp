<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Seller.css">

<title>Admin account</title>
</head>
<body>
<h3>Thank you for login in, ${username}</h3>
<br>
<h3>Create a Seller :</h3>
<form action="ProcessAdminActions" method="post">
<label>Username : </label>
<input type="text" name="username"><br>
<label>Password : </label>
<input type="password" name="password"><br>
<label>Surname : </label>
<input type="text" name="surname"><br>
<label>Name : </label>
<input type="text" name="name"><br>
<label>Role : </label>
<input type="text" name="program"><br>
<input type="submit" value="Add" >  
</form>

<h3>Create a Program plan :</h3>
<form action="ProcessAdminActions" method="get">
<label>Name : </label>
<input type="text" name="name"><br>
<label>Voice Time: </label>
<input type="text" name="includedvoicetime"><br>
<label>SMS: </label>
<input type="text" name="includedsms"><br>
<label>Data : </label>
<input type="text" name="includeddata"><br>
<label>fixed Price : </label>
<input type="text" name="fixedprice"><br>
<label>voice Time Price : </label>
<input type="text" name="voicetimeprice"><br>
<label>SMS Price : </label>
<input type="text" name="smsprice"><br>
<label>Data Price: </label>
<input type="text" name="dataprice"><br>
<input type="submit" value="Add" >
</form>
<br>

<h3>Change a program plan  :</h3>
<form action="ProcessAdminActions2" method="post">
<label>Name : </label>
<input type="text" name="name"><br>
<label>Voice Time: </label>
<input type="text" name="includedvoicetime"><br>
<label>SMS: </label>
<input type="text" name="includedsms"><br>
<label>Data : </label>
<input type="text" name="includeddata"><br>
<label>fixed Price : </label>
<input type="text" name="fixedprice"><br>
<label>voice Time Price : </label>
<input type="text" name="voicetimeprice"><br>
<label>SMS Price : </label>
<input type="text" name="smsprice"><br>
<label>Data Price: </label>
<input type="text" name="dataprice"><br>
<input type="submit" value="Add" >
</form>
<br>
<br>

<form action="index.jsp">
  <button type="submit">Logout</button>
</form>
</body>
</html>