
<%@page import="citas.logic.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="/proyecto1P4/css/medicoStyle.css">

        <%@ include file="/Header.jsp" %>
    </head>
    <body>

        <div class="card" style="margin-left: auto; margin-right: auto; margin-top: 20px;">
            <div class="img1"><img src="/proyecto1P4/img/img1fon.jpg"/></div>
            <div class="img2"><img src="/proyecto1P4/img/img1.jpg"/></div>
            <div class="main-text">
                <h2 style="margin-top: -25px;">Confirmar Asistencia</h2>
                <p><b>Doctor:</b> Bob Marley </br>
                    <b>Especialidad:</b> Cardiología </br>
                    <b>Localidad:</b> San José</br>
                    <b>Fecha</b> Lunes 8am</p>
            </div>
            <button type="submit" name="entrar" class="btn btn-primary" style="margin-top: -40px;"> Confirmar</button>
            <button type="submit" name="entrar" class="btn btn-primary" style="margin-top: -15px;"> Cancelar</button>
        </div>
    </body>
</html>
