<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>editBlog</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  background-color: #474e5d; margin: 0;
  }
  
.header {
  text-align:center;
  }
  
.form {
  text-align:center; font-family: verdana;
  }
  
.btn {
  border: none;
  color: white;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
}

.send {background-color: #333;}
.send:hover {background: #ddd; color: black;}

a:link {
  color: black;
}

a:visited {
  color: pink;
}

a:hover {
  color: green;
}

a:active {
  color: blue;
}

input[type=text], select, textarea {
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

</style>
</head>
<body>

<div class="header">
  <h1>Edit your Blog</h1>
</div>

<div class="form">
  <form action="updateBlog" id="form" method="post">
    <input type="text" name="bid" value="${blog.bid}" readonly="readonly"><br>
	<input type="text" name="title" value="${blog.title}"><br>
	<textarea name ="content" rows="50" cols="120" required="required">${blog.content}</textarea><br>
  </form>
  
  <button class="btn send" type="submit" form="form" value="Submit">Update</button><br>
 
  <a href="home">Back to home page</a>
</div>
	
</body>
</html>