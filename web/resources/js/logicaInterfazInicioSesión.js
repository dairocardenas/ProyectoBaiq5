//document.querySelector('#btnIngresar').addEventListener('Click', 
IniciarSesión);

function IniciarSesión(){
    var Usuario = '';
    var Contraseña="";
    var bAcceso = false;

    Usuario=document.querySelector('#txtUsuario').value;
    Contraseña=document.querySelector('#txtContraseña').value;

    bAcceso= validarCredenciales(pUsuario, pContraseña);
    if(bAcceso==true){
        Ingresar();
    }
}

function Ingresar(){
    var rol= sessionStorage.getItem('rolUsuarioActivo');
    switch(rol){
        case '130':
            window.location.href='form2.html';
            break;

            case '136':
                window.location.href='Cliente.html';
                break;
                default:
                window.location.href='Index1.html';
                break;
    }
}
    