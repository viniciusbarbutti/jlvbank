<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <meta name="theme-color" content="#2196F3">
    <title>Projeto Web</title>

    <!-- CSS  -->
    <link href="modulo_web/min/plugin-min.css" type="text/css" rel="stylesheet">
    <link href="modulo_web/min/custom-min.css" type="text/css" rel="stylesheet" >
    <link href="modulo_web/css/style.css" type="text/css" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body id="top" class="scrollspy">

<!-- MENU -->
<div class="navbar-fixed">
    <nav id="nav_f" class="default_color" role="navigation">
        <div class="container">
            <div class="nav-wrapper">
                <a href="#" id="logo-container" class="brand-logo">Logo</a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="#search">Pesquisar</a></li>
                    <li><a href="#insert">Inserir</a></li>
                    <li><a href="#update">Alterar</a></li>
                    <li><a href="#delete">Excluir</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>

<!-- APRESENTAÇÃO -->
<div class="section no-pad-bot" id="index-banner">
    <div class="container">
        <h1 class="text_h center header cd-headline letters type">
            <span>Trabalho:</span>
            <span class="cd-words-wrapper waiting">
          <b class="is-visible">CRUD</b>
          <b>Projeto</b>
	      <b>Integrado D</b>
        </span>
        </h1>
    </div>
</div>

<!-- SEARCH -->
<div id="search" class="section scrollspy">
    <div class="row">
        <div class="container">
            <h5 class="header text_b"> Pesquisa Clientes: </h5>
            <form method="post" action="DetailCustomersWeb">
                <label id="erroBuscaCpf" name="erroBuscaCpf"> ${erroBuscaCpf != null ? erroBuscaCpf : ''}</label>
                <div class="row">
                    <div class="input-field col s6">
                        <input id="cpf_pesquisa" type="text" class="validate" name="cpf" id="cpf" maxlength="14" minlength="14" onKeyPress="return Apenas_Numeros(event);" onkeyup="maskCPF(this)";>
                        <label for="cpf">CPF:</label>
                    </div>
                    <button class="btn waves-effect waves-light" type="submit">Pesquisar</button>
                </div>

                <div>
                    <table class="sortable">
                        <thead class="header text_b" >
                        <tr ${name != null ? name : ''}>
                            <th data-field="name">Nome</th>
                            <th data-field="cpf">CPF</th>
                            <th data-field="rg" style="display:none">RG</th>
                            <th data-field="aniversario" style="display:none">Data de Nascimento</th>
                            <th data-field="cidade">Cidade</th>
                            <th data-field="endereco" style="display:none">Endereco</th>
                            <th data-field="telefone">Telefone</th>
                            <th data-field="salario" style="display:none">Salario</th>
                            <th data-field="detalhes">Detalhes</th>
                        </tr>
                        </thead>

                        <tbody>
                        <tr >
                            <td name="name"> ${name != null ? name : ''.toString()}</td>
                            <td name="cpf">${cpf != null ? cpf : ''}</td>
                            <td name="rg" style="display:none">${rg != null ? rg : ''}</td>
                            <td name="aniversario" style="display:none">${aniversario != null ? aniversario : ''}</td>
                            <td name="cidade">${cidade != null ? cidade : ''}</td>
                            <td name="endereco" style="display:none">${endereco != null ? endereco : ''}</td>
                            <td name="telefone">${telefone != null ? telefone : ''}</td>
                            <td name="salario" style="display:none">${salario != null ? salario : ''}</td>
                            <td name="detalhes"><a class="waves-effect waves-light btn modal-trigger" href="#modal1">Detalhes</a></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </form>

            <form>
                <!-- Modal Structure -->
                <div id="modal1" class="modal" style="width: 90%; height: 30%;">
                    <div class="modal-content" style="width: 90%; height: 30%;">
                        <h4>Detalhes</h4>
                    </div>
                    <div class="modal-footer">
                            <table class="sortable">
                                <thead class="header text_b">
                                <tr>
                                    <th data-field="name">Nome</th>
                                    <th data-field="cpf">CPF</th>
                                    <th data-field="rg">RG</th>
                                    <th data-field="aniversario">Data de Nascimento</th>
                                    <th data-field="cidade">Cidade</th>
                                    <th data-field="endereco">Endereco</th>
                                    <th data-field="telefone">Telefone</th>
                                    <th data-field="salario">Salario</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr class="text_c">
                                    <td name="name"> ${name != null ? name : ''}</td>
                                    <td name="cpf">${cpf != null ? cpf : ''}</td>
                                    <td name="rg">${rg != null ? rg : ''}</td>
                                    <td name="aniversario">${aniversario != null ? aniversario : ''}</td>
                                    <td name="cidade">${cidade != null ? cidade : ''}</td>
                                    <td name="endereco">${endereco != null ? endereco : ''}</td>
                                    <td name="telefone">${telefone != null ? telefone : ''}</td>
                                    <td name="salario">${salario != null ? salario : ''}</td>
                                </tr>
                                </tbody>
                            </table>
                        <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Fechar</a>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<!-- PARALLAX -->
<div class="parallax-container">
    <div class="parallax"><img src="modulo_web/img/parallax1.png"></div>
</div>

<!-- CADASTRO -->
<div id="insert" class="section scrollspy">

    <div class="row">
        <div class="container">
            <h5 class="header text_b"> Dados para Cadastro </h5>

            <label id="erro" name="erro"> ${erro != null ? erro : ''}</label>
            <form class="col s12" method="post" action="InsertCustomerWeb">
                <div class="row">
                    <div class="input-field col s6">
                        <input id="complete_name" name="complete_name" type="text" class="validate" required="required">
                        <label for="complete_name">Nome Completo:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="cpf_insert" type="text" class="validate" name="cpf_insert" maxlength="14" minlength="14" required="required" onKeyPress="return Apenas_Numeros(event);" onkeyup="maskCPF(this)";>
                        <label for="cpf_insert">CPF:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="rg" type="text" class="validate" name="rg" id="rg" required="required" maxlength="12" minlength="12" onKeyPress="return Apenas_Numeros(event);" onkeyup="maskRG(this)";>
                        <label for="rg">RG:</label>
                    </div>
                    <div class="input-field col s6">
                        <input id="address" name="address" type="text" class="validate" required="required">
                        <label for="address">Endereço:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="autocomplete-input" name="city" type="text" class="autocomplete" required="required">
                        <label for="autocomplete-input">Cidade:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="password" name="password" type="password" class="validate" required="required">
                        <label for="password">Senha:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="confirm_password" name="confirm_password" type="password" class="validate" required="required">
                        <label for="confirm_password">Confirme a senha:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="telephone" name="telephone" type="tel" class="validate" maxlength="13" minlength="12" required="required" onkeypress="mascara(this, '## ####-####')">
                        <label for="telephone">Telefone:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="datepicker datepicker--input__focused" name="date_birth"type="text" class="datepicker" required="required">
                        <label for="datepicker datepicker--input__focused">Data de Nascimento:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="income" name="income" type="number" class="validate" required="required">
                        <label for="income">Renda:</label>
                    </div>
                    <div>
                        <button class="btn waves-effect waves-light" type="submit" name="action">Inserir Usuário</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- PARALLAX -->
<div class="parallax-container">
    <div class="parallax"><img src="modulo_web/img/parallax1.png"></div>
</div>

<!-- Cancelar Cartão -->
<div id="delete" class="section scrollspy">

    <div class="row">
        <div class="container">
            <h5 class="header text_b"> Cancelar Cartão </h5>
            <label id="erro_delete" name="erro_delete"> ${erro_delete != null ? erro_delete : ''}</label>
            <form class="col s12" method="post" action="DeleteCustomerWeb">
                <div class="row">
                    <div class="input-field col s3">
                        <input id="cartao" type="text" class="validate" name="cartao" required="required" onKeyPress="return Apenas_Numeros(event);">
                        <label for="cartao">Cartão:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="password" name="password" type="password" class="validate" required="required">
                        <label for="password">Senha:</label>
                    </div>
                    <div>
                        <button class="btn waves-effect waves-light" type="submit" name="action">Cancelar Cartão</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<!--Team-->
<div class="section scrollspy" id="team">
    <div class="container">
        <h2 class="header text_b"> Integrantes </h2>
        <div class="row">
            <div class="col s12 m3">
                <div class="card card-avatar">
                    <div class="waves-effect waves-block waves-light">
                        <img class="activator" src="modulo_web/img/avatar1.png">
                    </div>
                    <div class="card-content">
		                        <span class="card-title activator grey-text text-darken-4">Leoni Murilo <br/>
		                            <small><em><a class="red-text text-darken-1" href="#">123456</a></em></small></span>
                    </div>
                </div>
            </div>
            <div class="col s12 m3">
                <div class="card card-avatar">
                    <div class="waves-effect waves-block waves-light">
                        <img class="activator" src="modulo_web/img/avatar2.png">
                    </div>
                    <div class="card-content">
		                        <span class="card-title activator grey-text text-darken-4">Juliana<br/>
		                            <small><em><a class="red-text text-darken-1" href="#">15148513</a></em></small>
		                        </span>
                    </div>
                </div>
            </div>
            <div class="col s12 m3">
                <div class="card card-avatar">
                    <div class="waves-effect waves-block waves-light">
                        <img class="activator" src="modulo_web/img/avatar3.png">
                    </div>
                    <div class="card-content">
		                        <span class="card-title activator grey-text text-darken-4">Vinicius Barbutti<br/>
		                            <small><em><a class="red-text text-darken-1" href="#">15183270</a></em></small></span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--Footer-->
<footer id="contact" class="page-footer default_color scrollspy">
    <div class="footer-copyright default_color">
        <div class="container" align="center">
            Feito por: Juliana de Simoni, Leoni Murilo e Vinicius Barbutti.
        </div>
    </div>
</footer>




<!-- Validações dos campos-->
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
        if ((kcode == 8) || (kcode == 9)) return;
        if (CPF.value.length == 3) { CPF.value = CPF.value + '.'; }
        if (CPF.value.length == 7) { CPF.value = CPF.value + '.'; }
        if (CPF.value.length == 11) { CPF.value = CPF.value + '-'; }
    }

    function maskRG(RG) {
        var evt = window.event;
        kcode=evt.keyCode;
        if ((kcode == 8) || (kcode == 9)) return;
        if (RG.value.length == 2) { RG.value = RG.value + '.'; }
        if (RG.value.length == 6) { RG.value = RG.value + '.'; }
        if (RG.value.length == 10) { RG.value = RG.value + '-'; }
    }
    function mascara(t, mask){
        var i = t.value.length;
        var saida = mask.substring(1,0);
        var texto = mask.substring(i)
        if (texto.substring(0,1) != saida){
            t.value += texto.substring(0,1);
        }
    }


</script>

<!--  Scripts-->
<script src="modulo_web/min/plugin-min.js"></script>
<script src="modulo_web/min/custom-min.js"></script>
<script src="modulo_web/js/sortable.js"></script>
<script src="modulo_web/js/funcoes.js"></script>
<script src="modulo_web/js/index.js"></script>
<script src="modulo_web/js/init.js"></script>
<script src="modulo_web/js/jquery.js"></script>
<script src="modulo_web/js/jquery-2.1.1.min.js"></script>
<script src="modulo_web/js/materialize.js"></script>
<script src="modulo_web/js/materialize.min.js"></script>
</body>
</html>
