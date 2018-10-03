$(document).ready(function () {
    $("#datepicker").datepicker();
    $(".selectUsuario").change(function () {
        var idU = $(".selectUsuario").val();
        idU = idU.toString();
        console.log("entramos y cambiamos" + idU);
        //alert(idU);
        $.ajax({
            type: "GET",
            url: "/mostrar_usuarios",
            data: {"id": idU},
            success: function (result) {
                var g = $.parseJSON(result);

                console.log(g[0].charn);
            }
            , error: function (error, xhr, status) {
                console.log("Error: " + error + " | XHR: " + xhr + " | STATUS: " + status);
            }
        });


    });
    //$(".formRegistro").click(function () {
    //    $.ajax({
    //        type: "POST",
    //        url: "@{Application.registroUsuario()}",
    //        data: data,
    //        success: success,
    //        dataType: dataType
    //    });
    //})
});