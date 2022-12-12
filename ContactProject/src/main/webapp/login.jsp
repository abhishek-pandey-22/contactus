<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
background-color: #fc7303;
}
#main{
margin: 0 auto;
height: 300px;
width: 500px;
background-color: white;

box-shadow: 2px 1px 3px 1px grey;

}

.header{
padding-top: 0px;
padding-left: 16px;
background-color: #c4c2bb;
font-size: 12px;


}
.header b{
font-size: 30px;
}


button {
  background-color: #c4c2bb;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  margin-left: 40%;
}

/* Add a hover effect for buttons */
button:hover {
  opacity: 0.8;
}

/* Add padding to containers */
.container {
  padding: 16px;
}

/* The "Forgot password" text */
span.email {
  float: right;
  padding-top: 16px;
}
input[type="text"]{
  width: 100%;
  height: 40px;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="main">
<div class="header">
<b>Log in</b><br>
Only for Admin
</div>
<form action ="login" method="post">

  <div class="container">
    <label for="fullname"><b>User Name</b></label>
    <input type="text"  name="username" required>

    <label for="text"><b>Password</b></label>
    <input type="text" name="password" required>
     <button type="submit" value = "login"><b>Log in</b></button>
</div>
</form>
</div>

</body>
</html>