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
                <div class="row">
                    <div class="input-field col s6">
                        <input id="cpf_pesquisa" type="number" class="validate" name="cpf" id="cpf">
                        <label for="cpf">CPF:</label>
                    </div>
                    <button class="btn waves-effect waves-light" type="submit">Pesquisar</button>
                </div>

                <div>
                    <table class="sortable">
                        <thead class="header text_b">
                        <tr>
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
                        <tr>
                            <td name="name"> ${name != null ? name : ''}</td>
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
<div id="intro" class="section scrollspy">

    <div class="row">
        <div class="container">
            <h5 class="header text_b"> Dados para Cadastro </h5>
            <form class="col s12">
                <div class="row">
                    <div class="input-field col s6">
                        <input id="complete_name" type="text" class="validate">
                        <label for="complete_name">Nome Completo:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="cpfInput" type="number" class="validate">
                        <label for="cpfInput">CPF:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="rg" type="number" class="validate">
                        <label for="rg">RG:</label>
                    </div>
                    <div class="input-field col s6">
                        <input id="address" type="text" class="validate">
                        <label for="address">Endereço:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="city" type="text" class="validate">
                        <label for="city">Cidade:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="state" type="text" class="validate">
                        <label for="state">Estado:</label>
                    </div>
                    <div class="input-field col s6">
                        <input id="email" type="email" class="validate">
                        <label for="email">E-mail:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="password" type="password" class="validate">
                        <label for="password">Senha:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="confirm_password" type="password" class="validate">
                        <label for="confirm_password">Confirme a senha:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="telephone" type="tel" class="validate">
                        <label for="telephone">Telefone:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="datepicker datepicker--input__focused" type="text" class="datepicker">
                        <label for="datepicker datepicker--input__focused">Data de Nascimento:</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="renda" type="number" class="validate">
                        <label for="renda">Renda:</label>
                    </div>
                    <div>
                        <button class="btn waves-effect waves-light" type="submit" name="action">Inserir</button>
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
<!--  Scripts-->
<script src="modulo_web/min/plugin-min.js"></script>
<script src="modulo_web/min/custom-min.js"></script>
<script src="modulo_web/js/sortable.js"></script>
<script src="modulo_web/js/funcoes.js"></script>
</body>
</html>
