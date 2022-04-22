
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">               
        <link rel="stylesheet" href="/proyecto1P4/css/estilos.css">
        <link rel="stylesheet" href="/proyecto1P4/css/citaStyle.css">

        <%@ include file="/Header.jsp" %>    
    </head>
    <body>
        <h1>Vista Citas</h1>

        <div class="order-by">Ordenar por  </div>
        <div class="btn-group" role="group" aria-label="Basic example">
            <button type="button" class="btn btn-dark">Estado de cita</button>
            <button type="button" class="btn btn-dark">Nombre paciente</button>
            <button type="button" class="btn btn-dark">Fecha y hora</button>
        </div>

        <div class="card">
            <h5 class="card-header">Cita con Will Smith</h5>
            <div class="card-body">
                <h5 class="card-title">Special title treatment</h5>
                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                <a href="#" class="btn btn-primary">Ver</a>
            </div>
        </div>
        <div class="card">
            <h5 class="card-header">Cita con Winston Chirchill</h5>
            <div class="card-body">
                <h5 class="card-title">Special title treatment</h5>
                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                <a href="#" class="btn btn-primary">Ver</a>
            </div>
        </div>
        <div class="card">
            <h5 class="card-header">Cita con Elon Musk</h5>
            <div class="card-body">
                <h5 class="card-title">Special title treatment</h5>
                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                <a href="#" class="btn btn-primary">Ver</a>
            </div>
        </div>
    </body>
</html>
