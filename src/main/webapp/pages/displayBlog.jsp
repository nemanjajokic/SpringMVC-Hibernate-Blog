<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html lang="en">
<head>
<title>displayBlog</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

.header {
  padding: 30px;
  text-align: center;
  background: #474e5d;
  color: white;
}

.blog {
  padding: 2em 25em;
  text-align: justify;
  background: #333;
  color: white;
}

.back {
  padding: 30px;
  text-align: center;
  background: #333;
  color: white;
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

.header h1 {
  font-size: 40px;
}

.footer {
  padding: 30px;
  text-align: center;
  background: #ddd;
  margin-top: 0px;
}

</style>
</head>
<body>

<div class="header">
  <h1>${blog.title}</h1>
</div>

<div class="blog">
  <c:if test="${not empty blog.base64Image}">
	<img id="photo" src="data:image/jpeg;base64,${blog.base64Image}" />
  </c:if>
  <p>${blog.content}</p>
</div>

<div class="back">
  <a href="home">Back to home page</a>
</div>

<div class="footer">
  <h5>Blog made in Spring and Hibernate</h5>
</div>