
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
        <div class="container">
            <div class="row">
                <div class="col paddingTo">
                    <div class="order-by">Ordenar por  </div>
                </div>
                <div class="col">
                    <button type="button" class="btn btn-dark">Estado de cita</button>
                </div>
                <div class="col">
                    <button type="button" class="btn btn-dark">Nombre paciente</button>
                </div>
                <div class="col">
                    <button type="button" class="btn btn-dark">Fecha y hora</button>
                </div>

            </div>
        </div>



        <div class="card">
            <h5 class="card-header">Cita con Will Smith</h5>
            <div class="card-body">
                <h5 class="card-title">Cardiología</h5>
                <p class="card-text">

                <div class="container">
                    <div class="row">
                        <div class="col">
                            Estado: Pendiente </br> 
                        </div>
                        <div class="col">
                            Fecha y hora: Jueves 8am </br>
                        </div>
                        <div class="col">
                            Paciente: Kevin Mora </br>
                        </div>

                    </div>
                </div>
                
                <a href="#" class="btn btn-primary">Asistir</a>
            </div>
        </div>
        <div class="card">
            <h5 class="card-header">Cita con Will Smith</h5>
            <div class="card-body">
                <h5 class="card-title">Dermatología</h5>
                <p class="card-text">

                <div class="container">
                    <div class="row">
                        <div class="col">
                            Estado: Pendiente </br> 
                        </div>
                        <div class="col">
                            Fecha y hora: Jueves 8am </br>
                        </div>
                        <div class="col">
                            Paciente: Kevin Mora </br>
                        </div>

                    </div>
                </div>
                
                <a href="#" class="btn btn-primary">Asistir</a>
            </div>
        </div>
        <div class="card">
            <h5 class="card-header">Cita con Will Smith</h5>
            <div class="card-body">
                <h5 class="card-title">Special title treatment</h5>
                <p class="card-text">

                <div class="container">
                    <div class="row">
                        <div class="col">
                            Estado: Pendiente </br> 
                        </div>
                        <div class="col">
                            Fecha y hora: Jueves 8am </br>
                        </div>
                        <div class="col">
                            Paciente: Kevin Mora </br>
                        </div>

                    </div>
                </div>
                
                <a href="#" class="btn btn-primary">Asistir</a>
            </div>
        </div>
        
    </body>
</html>
