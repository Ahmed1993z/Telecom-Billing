<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Seller.css">

<title>Seller account</title>
</head>
<body>
<h3>Thank you for login in ${username}</h3>
<br>
<h3>Display Program</h3>
<table>
  <thead>
    <tr>
      <th>Name</th>
      <th>Included Voice Time</th>
      <th>Included SMS</th>
      <th>Included Data</th>
      <th>Fixed Price</th>
      <th>Voice Time Price</th>
      <th>SMS Price</th>
      <th>Data Price</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="program" items="${programs}">
      <tr>
        <td>${program.name}</td>
        <td>${program.includedVoiceTime}</td>
        <td>${program.includedSMS}</td>
        <td>${program.includedData}</td>
        <td>${program.fixedPrice}</td>
        <td>${program.voiceTimePrice}</td>
        <td>${program.smsPrice}</td>
        <td>${program.dataPrice}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>

<br>
<h3>Add a Customer and link them to a program :</h3>
<form action="ProcessSellerActions" method="post">
<label>Username : </label>
<input type="text" name="username"><br>
<label>Password : </label>
<input type="password" name="password"><br>
<label>Surname : </label>
<input type="text" name="surname"><br>
<label>Name : </label>
<input type="text" name="name"><br>
<label>Role : </label>
<input type="text" name="role"><br>
<label>Vat number : </label>
<input type="text" name="vatnumber"><br>
<label>Phone number : </label>
<input type="text" name="phonenumber"><br>
<label>Program : </label>
<input type="text" name="program"><br>
<input type="submit" value="Add" >
</form>
<br>

<br>
<h3>Change a Customer's program plan :</h3>
<form action="ProcessSellerActions" method="get">
<label>Username : </label>
<input type="text" name="username"><br>
<label>Password : </label>
<input type="password" name="password"><br>
<label>Surname : </label>
<input type="text" name="surname"><br>
<label>Name : </label>
<input type="text" name="name"><br>
<label>Role : </label>
<input type="text" name="role"><br>
<label>Vat number : </label>
<input type="text" name="vatnumber"><br>
<label>Phone number : </label>
<input type="text" name="phonenumber"><br>
<label>Program : </label>
<input type="text" name="program"><br>
<input type="submit" value="Add" >
</form>
<br>

<h3>Issue a bill</h3>
<form action="ProcessSellerActions2" method="post">
<label>Phone number : </label>
<input type="text" name="phonenumber"><br>
<label>Month : </label>
<input type="text" name="month"><br>
<label>Calls : </label>
<input type="text" name="calls"><br>
<label>Bill: </label>
<input type="text" name="bill"><br>
<input type="submit" value="Add" >
</form>

<br>




<form action="index.jsp">
  <button type="submit">Logout</button>
</form>
</body>
</html>