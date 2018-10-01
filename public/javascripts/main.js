$(document).ready(function() {
    $( "#datepicker" ).datepicker();
    $(".selectUsuario").change(function(){
        console.log("entramos y cambiamos");
        var idU= $(".selectUsuario").val();
        //alert(idU);
        $.ajax({
               type: "POST",
                url: "@{Application.mostrarUsuario()}",
                data: {ids:idU},
                success: success,
                dataType: dataType
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