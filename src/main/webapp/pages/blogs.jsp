<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>blogs</title>
<style>
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

.blog {
  padding-right: 25%;
  text-align: justify;
}

</style>
</head>
<body>

<c:forEach var="blog" items="${blogs}">
<div class="page">
  <h2>${blog.title}</h2>
  <h5>Date of Post ${blog.date}</h5>
  <c:if test="${not empty blog.base64Image}">
  	<img id="photo" src="data:image/jpeg;base64,${blog.base64Image}" />
  </c:if>
  <div class="blog">
    <p>${blog.content}</p><br>
  </div>
  <a style="font-weight:bold" href="edit + ${blog.bid}">Edit</a>
  <a style="font-weight:bold" href="delete + ${blog.bid}">Delete</a>
</div>
</c:forEach> 

<h2><a href="home">Back to Home Page</a></h2>

</body>
</html>