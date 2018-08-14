<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<!--         
		<header class="header">
            <a class="link-title" href="index.html">Stefanini Quiz Project</a>
            
        </header>
        
        <nav class="menu">
            <a href="index.html">Home</a> &nbsp; &nbsp; &nbsp;
            <a href="about.html">About Us</a> &nbsp; &nbsp; &nbsp;
            <a href="logIn.html">Log In</a> &nbsp; &nbsp; &nbsp;
            <a href="signUp.html">Sign Up</a> &nbsp; &nbsp; &nbsp;
        </nav> 
-->
        <article class="main">
           <form method="post" action="registerProcess">
               <p>Sign up</p>
               <p>
                   <label for="username">Username: </label>
                   <input type="text" name="username" placeholder="Your Username"/>
               </p>
               <p>
                   <label for="name">Name: </label>
                   <input type="text" name="name" placeholder="Your Name"/>
               </p>
               <p>
                   <label for="surname">Surname: </label>
                   <input type="text" name="surname" placeholder="Your Surname"/>
               </p>
               <p>
                   <label for="email">Email: </label>
                   <input type="text" name="email" placeholder="Your Email"/>
               </p>
               <p>
                   <label for="password">Password: </label>
                   <input type="password" name="password" placeholder="Your Password"/>
               </p>
               <input type="submit" value="Sign Up" />
           </form>
        </article>
         <footer>
             &copy; 2018 Stefanini Quiz Project &nbsp;<span class="separator">|</span>Desgnied by Virlan Petru
        </footer>
            
        
        
    </div>
    
</body>
</html>