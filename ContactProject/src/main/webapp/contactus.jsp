<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset = "UTF-8">
<title>contact us page</title>
<style>

body{
background-color: #fc7303;
font-family: Times New Roman", Times, serif;

}
#main{
margin: 0 auto;
height: 500px;
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


input[type=int], input[type=email] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
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

button:hover {
  opacity: 0.8;
}
.container {
  padding: 16px;
}
span.email {
  float: right;
  padding-top: 16px;
}
input[type="text"]{
  width: 100%;
  height: 100px;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  
  box-sizing: border-box;
  

}

}</style>
</head>
<body>
<div id = "main">
<div class="header">
<b>Contact Us</b><br>
Please fill this form in a decent manner
</div>
<form action="contactus" method="post">
 

  <div class="container">
    <label for="uname"><b>User Name</b></label>
    <input type="int"  name="uname" required>

    <label for="email"><b>E-mail</b></label>
    <input type="email" name="email" required placeholder="example@example.com">
    
    <label for="messege"><b>Messege</b></label>
    <input type="text" name="messege" required>
    <button type="submit"><b>SUBMIT</b></button>
  </div>

</form>
</div>



</body>
</html>