var nick = document.getElementById("nick");
var contraseña = document.getElementById("contraseña1");


function CustomAlert() {
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
        document.getElementById('dialogboxfoot').innerHTML = '<button onclick="Alert.ok()">OK</button>';
    }
    this.ok = function () {
        document.getElementById('dialogbox').style.display = "none";
        document.getElementById('dialogoverlay').style.display = "none";
    }
}
var Alert = new CustomAlert();

function validacion() {
    var valido = true;
    if (validarNick() == false) {
        valido = false;
    } else if (validarContraseña() == false) {
        valido = false;
    }
    if (valido === true) {

        document.getElementById("search-theme-form").action = "controller?opID=Valida";
        document.forms["formulario1"].submit();
    }
}

//////////////////////////////NICK//////////////////////////////

function validarNick() {
    var valido = true;

    if (nick.value == '') {
        Alert.render("Debes introducir un usuario");

        valido = false;
    } else if (!(/^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$/.test(nick.value))) {
        Alert.render("El usuario no es válido. La estructura válida es: 8 números y una letra mayúscula");

        valido = false;
    }
    return valido;
}


//////////////////////////////CONTRASEÑA//////////////////////////////

function validarContraseña() {
    var valido = true;
    if (contraseña.value == '') {
        Alert.render("Debes introducir una contraseña");

        valido = false;
    } else if (!(/^(?=.*[0-9])(?=.*[A-Za-z])([A-Z0-9]+){6,10}$/.test(contraseña.value))) {
        Alert.render("La contraseña no es válida. Debe tener entre 6 y 10 caracteres, números y letras");

        valido = false;
    }
    return valido;
}

function mostrarPasswordLogin() {
    if (contraseña.type == "password") {
        contraseña.type = "text";
        $('.icon2').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
    } else {
        contraseña.type = "password";
        $('.icon2').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
    }
}

$(document).ready(function () {
    //CheckBox mostrar contraseña
    $('#ShowPassword').click(function () {
        $('#contraseña1').attr('type', $(this).is(':checked') ? 'text' : 'password');
    });
});

$("#contraseña1").bind("paste", function() {
  return false;
});

document.getElementById("enviar").addEventListener('click', validacion);
