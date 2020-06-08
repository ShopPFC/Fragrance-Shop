var nick = document.getElementById("nick2");
var nombre = document.getElementById("nombre");
var contraseña2 = document.getElementById("contraseña2");
var email = document.getElementById("email");
var apellidos = document.getElementById("apellidos");

function CustomAlert1() {
    this.render = function (dialog) {
        var winW = window.innerWidth;
        var winH = window.innerHeight;
        var dialogoverlay = document.getElementById('dialogoverlay');
        var dialogbox = document.getElementById('dialogbox');
        dialogoverlay.style.display = "block";
        dialogoverlay.style.height = winH + "px";
        dialogbox.style.left = (winW / 2) - (550 * .5) + "px";
        dialogbox.style.top = "100px";
        dialogbox.style.display = "block";
        document.getElementById('dialogboxhead').innerHTML = "";
        document.getElementById('dialogboxbody').innerHTML = dialog;
        document.getElementById('dialogboxfoot').innerHTML = '<button onclick="Alert1.ok()">OK</button>';
    }
    this.ok = function () {
        document.getElementById('dialogbox').style.display = "none";
        document.getElementById('dialogoverlay').style.display = "none";
    }
}
var Alert1 = new CustomAlert1();

function validacionReg() {
    var valido = true;
    if (validarNick2() == false) {
        valido = false;
    } else if (validarNombre() == false) {
        valido = false;
    } else if (validarApellidos() == false) {
        valido = false;
    } else if (validarEmail() == false) {
        valido = false;
    } else if (validarContraseña2() == false) {
        valido = false;
    }
    if (valido === true) {

        document.getElementById("search-theme-form2").action = "controller?opID=InsertaUsuario";
        document.forms["formulario2"].submit();
    }
}

//////////////////////////////NICK//////////////////////////////

function validarNick2() {
    var valido = true;

    if (nick2.value == '') {
        Alert1.render("Debes introducir un usuario");

        valido = false;
    } else if (!(/^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$/.test(nick2.value))) {
        Alert1.render("El usuario no es válido. La estructura válida es: 8 números y una letra");

        valido = false;
    }
    return valido;
}

//////////////////////////////CONTRASEÑA//////////////////////////////


function validarContraseña2() {
    var valido = true;
    if (contraseña2.value == '') {
        Alert1.render("Debes introducir una contraseña");

        valido = false;
    } else if (!(/^(?=.*[0-9])(?=.*[A-Za-z])([A-Za-z0-9]+){6,10}$/.test(contraseña2.value))) {
        Alert1.render("La contraseña no es válida. Debe tener entre 6 y 10 caracteres, números y letras");

        valido = false;
    }
    return valido;
}

//////////////////////////////NOMBRE Y APELLIDOS//////////////////////////////

function validarNombre() {
    var valido = true
    if (nombre.value == '') {
        Alert1.render("El campo nombre es obligatorio");

        valido = false;
    } else if (!(/^[a-zA-Z áéíóúÁÉÍÓÚ]{1,}$/.test(nombre.value))) {
        Alert1.render("El nombre no es válido. Solo puede contener letras");

        valido = false;
    }
    return valido;
}

function validarApellidos() {
    var valido = true;

    if (apellidos.value == '') {
        Alert1.render("El campo apellidos es obligatorio");

        valido = false;
    } else if (!(/^[a-zA-Z áéíóúÁÉÍÓÚ]{1,}$/.test(apellidos.value))) {
        Alert1.render("Los apellidos no son válidos. Solo puede contener letras");

        valido = false;
    }
    return valido;

}

function validarEmail() {
    var valido = true;

    if (email.value == '') {
        Alert1.render("El campo email es obligatorio");
        valido = false;

    } else if (!(/^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i.test(email.value))) {
        Alert1.render("El email no es válido. Debe tener formato de email");
        valido = false;

    }
    return valido;
}

function mostrarPassword() {
    if (contraseña2.type == "password") {
        contraseña2.type = "text";
        $('.icon2').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
    } else {
        contraseña2.type = "password";
        $('.icon2').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
    }
}

$(document).ready(function () {
    //CheckBox mostrar contraseña
    $('#ShowPassword').click(function () {
        $('#contraseña2').attr('type', $(this).is(':checked') ? 'text' : 'password');
    });
});

$("#contraseña2").bind("paste", function() {
  return false;
});



document.getElementById("enviarReg").addEventListener('click', validacionReg);