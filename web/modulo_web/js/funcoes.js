var form = document.getElementById('form_pesquisa');
var campo1 = document.getElementById('cpf_pesquisa');

form.addEventListener('submit', function(e) {
    // alerta o valor do campo
    alert(campo1.value);
    // impede o envio do form
    e.preventDefault();
});