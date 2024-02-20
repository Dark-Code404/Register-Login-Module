<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Form</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">

<style>
body {
	background-color: #222021;
	font-family: sans-serif;
	margin: 0;
	padding: 0;
	height: 100vh;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.card {
	border-radius: 10px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.form-control {
	border-radius: 5px;
	box-shadow: none;
	border: 1px solid #ccc;
}

.btn-primary {
	background-color: #3498db;
	border-color: #3498db;
}

.btn-primary:hover {
	background-color: Blue;
}

.btn-back-home {
	color: red;
	background-color: yellow;
	border: none;
	border-radius: 5px;
	padding: 10px 20px;
	text-decoration: none;
}

.btn-back-home:hover {
	background-color: yellow;
	text-decoration: none;
}
</style>
</head>
<body>

	<div class="container">
		<div class="row justify-content-center align-items-center">
			<div class="col-sm-8 col-md-6 col-lg-5 card shadow-lg px-4 py-5">
				<h2 class="text-center mb-4">Login</h2>
				<form action="Login" method="post">
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" name="email"
							placeholder="example@gmail.com" required>
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="Password" required>
							<input type="checkbox" onclick="showPassword()"> Show Password
					</div>

					<%
					String message = (String) request.getAttribute("message");
					%>
					<%
					if (message != null) {
					%>
					<p style="color: red;"><%=message%></p>
					<%
					}
					%>

					<button type="submit" class="btn btn-primary btn-block mt-4">Login</button>
				</form>

				<button class="btn btn-back-home mt-1">
					<a href="index.html">Back to home page</a>
				</button>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
		
		 <script>
        function showPassword() {
            var passwordField = document.getElementById("password");
            if (passwordField.type === "password") {
                passwordField.type = "text";
            } else {
                passwordField.type = "password";
            }
        }
    </script>

</body>
</html>
