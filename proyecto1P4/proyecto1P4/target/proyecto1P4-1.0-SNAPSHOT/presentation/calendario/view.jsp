

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="/proyecto1P4/css/estilos.css">
        <link rel="stylesheet" href="/proyecto1P4/css/calendario.css">
        
        <%@ include file="/Header.jsp" %>
    </head>
    <body>
        <main class="contenedor">
            
            
            <section class="dias">
                <div class="dias_item">Lunes</div>
                <div class="dias_item">Martes</div>
                <div class="dias_item">Miercoles</div>
                <div class="dias_item">Jueves</div>
                <div class="dias_item">Viernes</div>
                <div class="dias_item">Sabado</div>
            </section>
            
            <section class="calendario">
                <div class="calendario_dia">
                    
                    <div class="cita">
                        <a class="item" href="/proyecto1P4/presentation/paciente/cita/make?mid=JPerez&dt=2022-04-23T09:00">9pm</a>
                    </div>
                    <div class="cita">
                        <a class="item" href="/proyecto1P4/presentation/paciente/cita/make?mid=JPerez&dt=2022-04-23T14:00">2pm</a>
                    </div>
                    
                </div>
                <div class="calendario_dia">
                    
                    <div class=" cita">
                        <a class="item" href="url">9am</a>
                    </div>
                    <div class=" cita">
                        <a class="item" href="url">3pm</a>
                    </div>
                    <div class=" cita">
                        <a class="item" href="url">9am</a>
                    </div>
                    <div class=" cita">
                        <a class="item" href="url">3pm</a>
                    </div>
                </div>
                <div class="calendario_dia">
                    <div class="cita">
                        <a class="item" href="url">9pm</a>
                    </div>
                    <div class="cita">
                        <a class="item" href="url">2pm</a>
                    </div>
                </div>
                <div class="calendario_dia">
                    
                </div>
                <div class="calendario_dia">
                    
                </div>
                <div class="calendario_dia">
                    
                </div>
                
            </section>
        </main>
        
                <a href="/proyecto1P4/presentation/medico/perfil/view.jsp" id="ver-perfil-btn">Ver perfil del doctor</a>

    </body>
</html>
