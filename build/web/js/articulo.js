var artId = document.getElementById("artId");
var artPrecio = document.getElementById("artPrecio");

function CustomAlert2() {
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
        document.getElementById('dialogboxfoot').innerHTML = '<button onclick="Alert2.ok()">OK</button>';
    }
    this.ok = function () {
        document.getElementById('dialogbox').style.display = "none";
        document.getElementById('dialogoverlay').style.display = "none";
    }
}

var Alert2 = new CustomAlert2();

function validacion() {    
    var valido = true;
    if (validarId() == false) {
        valido = false;
    }else if (validarPrecio() == false) {
        valido = false;
    }
    if(valido === true){
        
       document.forms["formulario3"].submit();
    }
}


//////////////////////////////ID//////////////////////////////

function validarId() {
    
    var valido = true;

    if (artId.value == '') {
        Alert2.render("Debes introducir un id válido");
        valido = false;
        
    } else if (!(/^[0-9]*$/.test(artId.value))) {
        Alert2.render("El id no es válido. Solo se aceptan números");
        valido = false;
    }
    return valido;
}


//////////////////////////////PRECIO//////////////////////////////

function validarPrecio() {
    
    var valido = true;
    
    if (artPrecio.value == '') {
        Alert2.render("Debes introducir un precio válido");
        valido = false;
        
    } else if (!(/^[0-9]*$/.test(artPrecio.value))) {
        Alert2.render("El precio no es válido. Solo se acpetan números");
        valido = false;
    } 
    return valido;
}

document.getElementById("enviarArt").addEventListener('click', validacion);