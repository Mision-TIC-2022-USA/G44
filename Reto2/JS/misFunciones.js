function traerInformacion() {

    $.ajax({
        url: 'https://ge98c0cd4db3cd7-db202110141836.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/usuario/usuario',
        type: 'GET',
        dataType: 'json',
        success: function (json) {
            ContruirTabla(json.items);
        },
        error: function (xhr, status) {
            console.log(status);
        },
        complete: function (xhr, status) {
            //console.log('Petición realizada');
        }
    });
}

function ContruirTabla(data) {

    var dataTable = "";

    for (const dato of data) {
        dataTable += "<tr>"
        dataTable += "<td>" + dato.id + "</td>";
        dataTable += "<td>" + dato.nombre + "</td>";
        dataTable += "<td>" + dato.cedula + "</td>";
        dataTable += "<td>" + dato.celular + "</td>";
        dataTable += "<td>" + "<button onclick='EliminarRegistro(" + dato.id + ")'>Eliminar</button>" + "</td>";
        dataTable += "</tr>";
    }
    $("#myTable").html(dataTable);
}


function GuardarRegistro() {

    var myData = {
        id: $("#id").val(),
        nombre: $("#nombre").val(),
        cedula: $("#cedula").val(),
        celular: $("#celular").val()
    };

    $.ajax({
        url: 'https://ge98c0cd4db3cd7-db202110141836.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/usuario/usuario',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(myData),
        //dataType: 'json',
        success: function (json) {
            traerInformacion();
        },
        error: function (xhr, status) {
            console.log(status);
        },
        complete: function (xhr, status) {
            //console.log('Petición realizada');
        }
    });
}

function EliminarRegistro(idElemento) {

    var myData = {
        id: idElemento,
    };

    $.ajax({
        url: 'https://ge98c0cd4db3cd7-db202110141836.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/usuario/usuario',
        type: 'DELETE',
        contentType: 'application/json',
        data: JSON.stringify(myData),
        //dataType: 'json',
        success: function (json) {
            traerInformacion();
        },
        error: function (xhr, status) {
            console.log(status);
        },
        complete: function (xhr, status) {
            //console.log('Petición realizada');
        }
    });
}


function ActualizarRegistro() {

    var myData = {
        id: $("#id").val(),
        nombre: $("#nombre").val(),
        cedula: $("#cedula").val(),
        celular: $("#celular").val()
    };

    $.ajax({
        url: 'https://ge98c0cd4db3cd7-db202110141836.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/usuario/usuario',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(myData),
        //dataType: 'json',
        success: function (json) {
            traerInformacion();
        },
        error: function (xhr, status) {
            console.log(status);
        },
        complete: function (xhr, status) {
            //console.log('Petición realizada');
        }
    });
}
