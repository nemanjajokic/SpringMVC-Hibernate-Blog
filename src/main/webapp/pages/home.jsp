<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<title>homePage</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial;
  margin: 0;
}

.header {
  padding: 35px;
  text-align: center;
  background: #474e5d;
  color: white;
}

.header h1 {
  font-size: 40px;
}

.navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  float: left;
  display: block;
  color: white;
  text-align: center;
  padding: 14px 20px;
  text-decoration: none;
}

.navbar a.right {
  float: right;
}

.navbar a:hover {
  background-color: #ddd;
  color: black;
}

/************************************************************************************/

.img {
  background-color: #aaa;
  width: 98%;
  padding: 20px;
}

.content {
  text-align: justify;
}

.card {
  background-color: white;
  padding: 20px;
  margin-top: 20px;
}

.row {
  max-width: 1500px;
  margin: auto;
} 

.row2 {
  max-width: 1470px;
  margin: auto;
} 

.footer {
  padding: 30px;
  text-align: center;
  background: #ddd;
  margin-top: 20px;
}

.navbar .search-container {
  float: right;
}

.navbar input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}

.navbar .search-container button {
  float: right;
  padding: 6px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.navbar .search-container button:hover {
  background: #ccc;
}

@media screen and (max-width: 600px) {
  .navbar .search-container {
    float: none;
  }
  .navbar a, .navbar input[type=text], .navbar .search-container button {
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }
  .navbar input[type=text] {
    border: 1px solid #ccc;  
  }
}

a:link {
  color: white;
}

a:visited {
  color: white;
}

a:hover {
  color: pink;
}

a:active {
  color: pink;
}

.login {
  float: right;
}

</style>
</head>
<body>

<div class="header">
  <div class="login">
    <c:choose>
      <c:when test="${name.equals('anonymousUser')}">
        <a style="font-weight:bold" href="login">Login</a>	<a style="font-weight:bold" href="register">Register</a>
      </c:when>    
      <c:otherwise>
        <a style="font-weight:bold" href="/HibMVC/logout">Logout</a> 
      </c:otherwise>
    </c:choose> 
  </div>
  <h1>Blog by Neca</h1>
  <p>Welcome to my Blog.</p>
</div>

<div class="navbar">
  <a href="blogs">My Posts</a>
  <a href="blog">Make a new Post</a>
  <div class="search-container">
    <form action="displayBlog">
      <input type="text" placeholder="Search by title..." name="search">
      <button type="submit">Search</button>
    </form>
  </div>
</div>

<div class="row2">
<h2 style="text-align:center">Latest Posts</h2>
<hr>
</div>

<c:forEach var="blog" items="${blogs}">  
<div class="row">
  <div class="card">
    <h2>${blog.title}</h2>
    <h5>Post by ${blog.author}, ${blog.date}</h5>
      <div class="img">
        <c:if test="${not empty blog.base64Image}">
		  <img id="photo" src="data:image/jpeg;base64,${blog.base64Image}" />
 		</c:if>
      </div>
    <div class="content">
      <p>${blog.content}</p>
    </div>
  </div>
</div>
</c:forEach> 

<div class="footer">
  <h5>Blog made in Spring and Hibernate</h5>
</div>

</body>
</html>