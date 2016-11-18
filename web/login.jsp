<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <meta name="theme-color" content="#2196F3">
    <title>Projeto Web</title>


    <link rel="stylesheet" href="modulo_web/css/login.css">
</head>

<body>

<span href="#" class="button" id="toggle-login">Log in</span>

<div id="login">
    <div id="triangle"></div>
    <h1>Log in</h1>
    <form method="post" action="AuthenticationWeb">
        <label id="erro" name="erro"> ${erro != null ? erro : ''}</label>
        <input name="cpf" type="text" placeholder="CPF" />
        <input name="password" type="password" placeholder="Password" />
        <input type="submit" value="Log in"/>
    </form>
</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="modulo_web/js/index.js"></script>
</body>
</html>
