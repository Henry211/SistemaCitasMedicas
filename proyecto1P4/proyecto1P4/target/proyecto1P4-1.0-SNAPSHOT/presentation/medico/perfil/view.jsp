

<%@page import="citas.logic.Horario"%>
<%@page import="citas.logic.Medico"%>
<%@page import="citas.logic.Paciente"%>
<%@page import="citas.presentation.medico.perfil.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Medico medico = (Medico) session.getAttribute("medico");  %>
<% Horario horario = (Horario) session.getAttribute("horario");
   %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="/proyecto1P4/css/estilos.css">
        <link rel="stylesheet" href="/proyecto1P4/css/perfil.css">

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"/>

        <!--Material Design Bootstrap-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css"/>

        <%@ include file="/Header.jsp" %>
    </head>
    <body>
        <div>
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <a href="view.jsp"></a>
                    <div class="col-md-10 mt-5 pt-5">
                        <div class="row z-depth-3">
                            <div class="col-sm-4 bg-info rounded-left">
                                <div class="card-block text-center text-white">
                                    <i class="fas fa-7x mt-5"><img id="img-perfil" src="/proyecto1P4/img/img1.jpg"/></i>
                                    <h2 class="font-weight-bold mt-4">
                                        <%= medico.getNombre()%>

                                    </h2>
                                    <p>Doctor en medicina</p>
                                    <a href="/proyecto1P4/presentation/medico/perfil/editar" class="text-white"><i class="far fa-edit mb-4"> Editar Perfil</i></a>

                                </div>

                            </div>
                            <div class="col-sm-8 bg-white rounded-right">
                                <h3 class="mt-3 text-center">Información</h3>
                                <hr class="badge-primary mt-0 w-25">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <p>Especialidad:</p>
                                        <h6 class="text-muted">
                                            <%= medico.getEspecialidad().getEspecialidad()%>
                                        </h6>
                                    </div>
                                    <div class="col-sm-6">
                                        <p>Localidad:</p>
                                        <h6 class="text-muted">
                                            <%= medico.getCiudad().getProvincia()%>                                                                                        
                                        </h6>


                                    </div>
                                </div>


                                <div class="row">
                                    </ br>

                                    <p>Horario: 

                                    </p>

                                    <main class="contenedor horario-acomodar">



                                        <section class="dias">
                                            <div class="dias_item">
                                                Lunes-------
                                            </div>
                                            <div class="dias_item">
                                                Martes------
                                            </div>
                                            <div class="dias_item">
                                                Miercoles--
                                            </div>
                                            <div class="dias_item">
                                                Jueves------
                                            </div>
                                            <div class="dias_item">
                                                Viernes-----
                                            </div>
                                            <div class="dias_item">
                                                Sabado-----
                                            </div>
                                        </section>

                                        <section class="calendario">
                                            <div class="calendario_dia">


                                                <div class="cita">
                                                    Hora de Inicio
                                                </div>


                                            </div>
                                            <div class="calendario_dia">


                                                <div class="cita">
                                                    <% int dato = horario.getIniLunes(); %>
                                                    <% if (dato != 0) {%>
                                                    <%= horario.getIniLunes()%>
                                                    <% } else { %>
                                                    ...
                                                    <% } %>
                                                </div>


                                            </div>
                                            <div class="calendario_dia">


                                                <div class="cita">
                                                    <% int dato5 = horario.getIniMartes(); %>
                                                    <% if (dato5 != 0) {%>
                                                    <%= horario.getIniMartes()%>
                                                    <% } else { %>
                                                    ...
                                                    <% } %>
                                                </div>


                                            </div>
                                            <div class="calendario_dia">

                                                <div class=" cita">
                                                    <% int dato4 = horario.getIniMiercoles(); %>
                                                    <% if (dato4 != 0) {%>
                                                    <%= horario.getIniMiercoles()%>
                                                    <% } else { %>
                                                    ...
                                                    <% } %>
                                                </div>

                                            </div>
                                            <div class="calendario_dia">

                                                <div class=" cita">
                                                    <% int dato3 = horario.getIniJueves(); %>
                                                    <% if (dato3 != 0) {%>
                                                    <%= horario.getIniJueves()%>
                                                    <% } else { %>
                                                    ...
                                                    <% } %>
                                                </div>


                                            </div>
                                            <div class="calendario_dia">

                                                <div class=" cita">
                                                    <% int dato2 = horario.getIniViernes(); %>
                                                    <% if (dato2 != 0) {%>
                                                    <%= horario.getIniViernes()%>
                                                    <% } else { %>
                                                    ...
                                                    <% } %>
                                                </div>


                                            </div>
                                            <div class="calendario_dia">

                                                <div class=" cita">
                                                    <% int dato0 = horario.getIniSabado(); %>
                                                    <% if (dato0 != 0) {%>
                                                    <%= horario.getIniSabado()%>
                                                    <% } else { %>
                                                    ...
                                                    <% } %>
                                                </div>

                                            </div>



                                        </section>


                                        <section class="calendario">

                                            <div class="calendario_dia fin">


                                                <div class="cita">
                                                    Hora Fin
                                                </div>


                                            </div>

                                            <div class="calendario_dia fin">


                                                <div class="cita">
                                                    <% int dato7 = horario.getFinLunes(); %>
                                                    <% if (dato7 != 0) {%>
                                                    <%= horario.getFinLunes()%>
                                                    <% } else { %>
                                                    ...
                                                    <% } %>
                                                </div>


                                            </div>
                                            <div class="calendario_dia fin">

                                                <div class=" cita">
                                                    <% int dato6 = horario.getFinMartes(); %>
                                                    <% if (dato6 != 0) {%>
                                                    <%= horario.getFinMartes()%>
                                                    <% } else { %>
                                                    ...
                                                    <% } %>

                                                </div>

                                            </div>
                                            <div class="calendario_dia fin">

                                                <div class=" cita">
                                                    <% int dato14 = horario.getFinMiercoles(); %>
                                                    <% if (dato14 != 0) {%>
                                                    <%= horario.getFinMiercoles()%>
                                                    <% } else { %>
                                                    ...
                                                    <% } %>
                                                </div>


                                            </div>
                                            <div class="calendario_dia fin">

                                                <div class=" cita">
                                                    <% int dato13 = horario.getFinJueves(); %>
                                                    <% if (dato13 != 0) {%>
                                                    <%= horario.getFinJueves()%>
                                                    <% } else { %>
                                                    ...
                                                    <% } %>
                                                </div>

                                            </div>
                                            <div class="calendario_dia fin">

                                                <div class=" cita">
                                                    <% int dato12 = horario.getFinViernes(); %>
                                                    <% if (dato12 != 0) {%>
                                                    <%= dato12%>
                                                    <% } else { %>
                                                    ...
                                                    <% } %>
                                                </div>

                                            </div>
                                            <div class="calendario_dia fin">

                                                <div class=" cita">
                                                    <% int dato09 = horario.getFinSabado(); %>
                                                    <% if (dato09 != 0) {%>
                                                    <%= dato09%>
                                                    <% } else { %>
                                                    ...
                                                    <% }%>
                                                </div>

                                            </div>


                                        </section>
                                    </main>


                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
