<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<style>
body {
  background-color: #474e5d;
}

.box {
  text-align: center;
  margin: auto;
  width: 350px;
  padding: 20px;
  background: #ddd;
}

input[type=submit] {
  background-color: #333;
  border: none;
  color: white;
  padding: 12px 24px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}

input[type=text], input[type=password], select, textarea {
  width: 100%;
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

<div class="box">
  <h1>Log In</h1>
  <form action="login" method="post">
	<input type="text" name="username" placeholder="Username">
	<input type="password" name="password" placeholder="Password"><br>
	<input type="submit" value="Login">
  </form>
</div>

</body>
</html>