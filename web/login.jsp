<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <meta name="theme-color" content="#2196F3">
    <title>Projeto Web</title>


    <link rel="stylesheet" href="modulo_web/css/login.css">
</head>

<body id="fundo_login">

<span href="#" class="button" id="toggle-login">Log in</span>

<div id="login">
    <div id="triangle"></div>
    <h1>Log in</h1>
    <script language=javascript>
        function Apenas_Numeros(caracter){
            var nTecla = 0;
            if (document.all) {
                nTecla = caracter.keyCode;
            }else {
                nTecla = caracter.which;
            }
            if ((nTecla> 47 && nTecla <58)
                || nTecla == 8 || nTecla == 127
                || nTecla == 0 || nTecla == 9  // 0 == Tab
                || nTecla == 13) { // 13 == Enter
                return true;
            } else {
                return false;
            }
        }

        function maskCPF(CPF) {
            var evt = window.event;
            kcode=evt.keyCode;
            if (kcode == 8) return;
            if (CPF.value.length == 3) { CPF.value = CPF.value + '.'; }
            if (CPF.value.length == 7) { CPF.value = CPF.value + '.'; }
            if (CPF.value.length == 11) { CPF.value = CPF.value + '-'; }
        }
    </script>

    <form method="post" action="AuthenticationWeb">
        <label id="erro" name="erro"> ${erro != null ? erro : ''}</label>
        <input name="cpf" type="text" placeholder="CPF"  maxlength="14" minlength="14" onKeyPress="return Apenas_Numeros(event);" onkeyup="maskCPF(this)"/>
        <input name="password" type="password" placeholder="Password" />
        <input type="submit" value="Log in"/>
    </form>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="modulo_web/js/index.js"></script>
    <script src="jquery.js" type="text/javascript"></script>
    <script src="jquery.maskedinput.js" type="text/javascript"></script>
</body>
</html>
