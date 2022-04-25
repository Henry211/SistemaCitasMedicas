

<%@page import="citas.logic.Medico"%>
<%@page import="citas.logic.Horario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Horario horario = (Horario) session.getAttribute("horario"); %>
<% Medico medico = (Medico) session.getAttribute("medico"); %>
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
                    
                    <% int i = horario.getLunes().size(); %>
                    <% while(i != 0){ %>
                    <% i--; %>
                    <div class="cita">
                        <a class="item" href="/proyecto1P4/presentation/paciente/cita/make?mid=JPerez&dt=2022-04-23T09:00">
                            <%= horario.getLunes().get(i).toString() %>
                        </a>
                    </div>
                    <% } %>
                    
                </div>
                <div class="calendario_dia">
                    <% int i2 = horario.getMartes().size(); %>
                    <% while(i2 != 0){ %>
                    <% i2--; %>
                    <div class=" cita">
                        <a class="item" href="url">
                            <%= horario.getMartes().get(i2).toString() %>
                        </a>
                    </div>
                    <% } %>
                </div>
                <div class="calendario_dia">
                    <% int i3 = horario.getMiercoles().size(); %>
                    <% while(i3 != 0){ %>
                    <% i3--; %>
                    <div class=" cita">
                        <a class="item" href="url">
                            <%= horario.getMiercoles().get(i3).toString() %>
                        </a>
                    </div>
                    <% } %>
                    
                </div>
                <div class="calendario_dia">
                    <% int i4 = horario.getJueves().size(); %>
                    <% while(i4 != 0){ %>
                    <% i4--; %>
                    <div class=" cita">
                        <a class="item" href="url">
                            <%= horario.getJueves().get(i4).toString() %>
                        </a>
                    </div>
                    <% } %>
                </div>
                <div class="calendario_dia">
                    <% int i5 = horario.getViernes().size(); %>
                    <% while(i5 != 0){ %>
                    <% i5--; %>
                    <div class=" cita">
                        <a class="item" href="url">
                            <%= horario.getViernes().get(i5).toString() %>
                        </a>
                    </div>
                    <% } %>
                </div>
                <div class="calendario_dia">
                    <% int i6 = horario.getSabado().size(); %>
                    <% while(i6 != 0){ %>
                    <% i6--; %>
                    <div class=" cita">
                        <a class="item" href="url">
                            <%= horario.getSabado().get(i6).toString() %>
                        </a>
                    </div>
                    <% } %>
                </div>
                
            </section>
        </main>
        
                <a href="/proyecto1P4/presentation/medico/perfil/view.jsp" id="ver-perfil-btn">Ver perfil del doctor</a>

    </body>
</html>
