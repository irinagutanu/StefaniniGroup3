<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="container">
		<header class="header"> <a class="link-title"
			href="index.jsp">Stefanini Quiz Project</a> </header>

		<nav class="menu"> 
		<a href="index.jsp">Home</a> &nbsp; &nbsp;
		&nbsp; 
		<a href="about.jsp">About Us</a> &nbsp; &nbsp; &nbsp; 
		<a	href="showQuiz">Quiz</a> &nbsp; &nbsp; &nbsp; </nav>

		<article class="main"> <br>
		<br>

		You have answered: ${score} out of ${numberOfQuestions} questions. <br> 
		<br>


		</article>
		<footer> &copy; 2018 Stefanini Quiz Project &nbsp;<span
			class="separator">|</span>Designed by Virlan Petru </footer>
	</div>

</body>
</html>