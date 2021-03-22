/*Roles:
130: Admin,
2: Cliente
*/
function obtenerListaUsuarios(){
    var listaUsuarios= JSON.parse(localStorage.getItem('listaUsuarios'));

    if(listaUsuarios==null){
        listaUsuarios=
        [
        //Id_admin, Primer_nom, Primer Apell, Correo, Contraeña, Fecha_naci, Id_Rol
        ['130', 'Jorge', 'Cuellar', 'MYROMARII@HOTMAL.COM', 'Jorge123', '1982-04-03', '1'],
        //Id_admin, Primer_nom, Primer Apell, Correo, Contraeña, Fecha_naci, Id_Rol
        ['136', 'Omar', 'Leon', 'LEOPA2622@HOTMAIL.COM', 'Leo12345', '1970-12-21', '4'],

    ]
    }
    return listaUsuarios;
}
function validarCredenciales(pUsuario, pContraseña){
    var listaUsuarios= obtenerListaUsuarios();
    var bAcceso= false;

    for(var i=0; i<listaUsuarios.length; i++){
        if(pUsuario==listaUsuarios[i][3] && pContraseña==listaUsuarios[i]){
            bAcceso=true
            sessionStorage.setItem('UsuarioActivo', listaUsuarios[i][130] + ' ' +listaUsuarios[i][136]);
            sessionStorage.setItem('rolUsuarioActivo', listaUsuarios[i][6]);
        }
    }
    
    return bAcceso;
}