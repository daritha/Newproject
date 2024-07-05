<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Login Form</title>
<script type="text/javascript">
function checkEmptyValues() {
    if (document.getElementById('username').value == "") {
        alert("Please enter your username");
        return false;
    }
    if (document.getElementById('password').value == "") {
        alert("Please enter your password");
        return false;
    }
    return true;
}
</script>
</head>
<body>
<h1 align="center">Student Login Form</h1><br>
<form action="Login" method="post" onsubmit="return checkEmptyValues()">
<div align="center">
    <label>Username: <input type="text" id="username" name="username"></label>
</div>
<br>
<div align="center">
    <label>Password: <input type="password" id="password" name="password"></label>
</div>
<br>
<div align="center">
    <input type="submit" value="Login">
</div>
</form>
</body>
</html>
