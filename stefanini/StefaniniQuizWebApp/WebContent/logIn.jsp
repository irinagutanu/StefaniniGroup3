<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Log In</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/scripts.js"></script>
    
</head>

<body>
    <div class="container">
        <header class="header">
            <a class="link-title" href="index.jsp">Stefanini Quiz Project</a>
            
        </header>
        
        <nav class="menu">
            <a href="index.jsp">Home</a> &nbsp; &nbsp; &nbsp;
            <a href="about.jsp">About Us</a> &nbsp; &nbsp; &nbsp;
            <a href="logIn.jsp">Log In</a> &nbsp; &nbsp; &nbsp;
            <a href="register">Sign Up</a> &nbsp; &nbsp; &nbsp;
            <a href="showQuiz">Quiz</a> &nbsp; &nbsp; &nbsp;
        </nav>
        <article class="main">
           <form method="get" action="springWebAppLogIn">
               <p>
                   <label for="name">Name: </label>
                   <input type="text" name="name" placeholder="Your Name"/>
               </p>
               <p>
                   <label for="password">Password: </label>
                   <input type="password" name="password" placeholder="Your Password"/>
               </p>
               <input type="submit" value="Log In" />
           </form>
        </article>
         <footer>
             &copy; 2018 Stefanini Quiz Project &nbsp;<span class="separator">|</span>Desgnied by Virlan Petru
        </footer>
            
        
        
    </div>
    
</body>
</html>