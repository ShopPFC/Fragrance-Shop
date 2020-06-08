var nick3 = document.getElementById("nick3");
var nombre2 = document.getElementById("nombre2");
var contraseña3 = document.getElementById("contraseña3");
var email2 = document.getElementById("email2");
var apellidos2 = document.getElementById("apellidos2");

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
    if (validarNick3() == false) {
        valido = false;
    } else if (validarNombre2() == false) {
        valido = false;
    } else if (validarApellidos2() == false) {
        valido = false;
    } else if (validarEmail2() == false) {
        valido = false;
    } else if (validarContraseña3() == false) {
        valido = false;
    }
    if (valido === true) {

        document.getElementById("search-theme-form4").action = "controller?opID=ModificarUsuario&dni=<%=usuarioConectado.getDni()%>";
        document.forms["formulario4"].submit();
    }
}

function cancelacionReg() {
    var valido = true;
    if (valido === true) {

        document.getElementById("search-theme-form4").action = "controller?opID=Perfil";
        document.forms["formulario4"].submit();
    }
}

//////////////////////////////NICK//////////////////////////////

function validarNick3() {
    var valido = true;

    if (nick3.value == '') {
        Alert1.render("Debes introducir un usuario");

        valido = false;
    } else if (!(/^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$/.test(nick3.value))) {
        Alert1.render("El usuario no es válido. La estructura válida es: 8 números y una letra");

        valido = false;
    }
    return valido;
}

//////////////////////////////CONTRASEÑA//////////////////////////////


function validarContraseña3() {
    var valido = true;
    if (contraseña3.value == '') {
        Alert1.render("Debes introducir una contraseña");

        valido = false;
    } else if (!(/^(?=.*[0-9])(?=.*[A-Za-z])([A-Za-z0-9]+){6,10}$/.test(contraseña3.value))) {
        Alert1.render("La contraseña no es válida. Debe tener entre 6 y 10 caracteres, números y letras");

        valido = false;
    }
    return valido;
}

//////////////////////////////NOMBRE Y APELLIDOS//////////////////////////////

function validarNombre2() {
    var valido = true
    if (nombre2.value == '') {
        Alert1.render("El campo nombre es obligatorio");

        valido = false;
    } else if (!(/^[a-zA-Z áéíóúÁÉÍÓÚ]{1,}$/.test(nombre2.value))) {
        Alert1.render("El nombre no es válido. Solo puede contener letras");

        valido = false;
    }
    return valido;
}

function validarApellidos2() {
    var valido = true;

    if (apellidos2.value == '') {
        Alert1.render("El campo apellidos es obligatorio");

        valido = false;
    } else if (!(/^[a-zA-Z áéíóúÁÉÍÓÚ]{1,}$/.test(apellidos2.value))) {
        Alert1.render("Los apellidos no son válidos. Solo puede contener letras");

        valido = false;
    }
    return valido;

}

function validarEmail2() {
    var valido = true;

    if (email2.value == '') {
        Alert1.render("El campo email es obligatorio");
        valido = false;

    } else if (!(/^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i.test(email2.value))) {
        Alert1.render("El email no es válido. Debe tener formato de email");
        valido = false;

    }
    return valido;
}

function mostrarPassword2() {
    if (contraseña3.type == "password") {
        contraseña3.type = "text";
        $('.icon2').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
    } else {
        contraseña3.type = "password";
        $('.icon2').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
    }
}

$(document).ready(function () {
    //CheckBox mostrar contraseña
    $('#ShowPassword').click(function () {
        $('#contraseña2').attr('type', $(this).is(':checked') ? 'text' : 'password');
    });
});

$("#contraseña2").bind("paste", function () {
    return false;
});

document.getElementById("guardarPerfil").addEventListener('click', validacionReg);
document.getElementById("cancelarPerfil").addEventListener('click', cancelacionReg);


