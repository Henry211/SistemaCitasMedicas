
<%@page import="citas.logic.Ciudad"%>
<%@page import="citas.logic.Especialidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="citas.logic.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Medico> medicos = (ArrayList<Medico>) session.getAttribute("listaMedicos"); %>
<% ArrayList<Especialidad> especialidades = (ArrayList<Especialidad>) session.getAttribute("especialidadesCombo"); %>
<% ArrayList<Ciudad> ciudades = (ArrayList<Ciudad>) session.getAttribute("ciudadesCombo");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="../../css/medicoStyle.css">

        <%@ include file="/Header.jsp" %>
    </head>
    <body>


        <div class="container sombra">
            <form class="col-12" method="GET" name="Buscar" action="/proyecto1P4/presentation/registromedico/show" >
                <div class="row">
                    <div class="col">
                        <select id="localidad" class="form-select sombra" aria-label="Default select example">
                            <option selected>Seleccione la Localidad</option>
                            <% int c = ciudades.size(); %>
                            <% while (c != 0) { %>
                            <% c--;%>
                            <option value="<%= ciudades.get(c).getProvincia()%>">
                                <%= ciudades.get(c).getProvincia()%>
                            </option>
                            <% } %>
                        </select>
                    </div>
                    <div class="col">
                        <select id="especialidad" class="form-select sombra" aria-label="Default select example">
                            <option selected>Seleccione la Especialidad</option>
                            <% int e = especialidades.size(); %>
                            <% while (e != 0) { %>
                            <% e--;%>
                            <option value="<%= especialidades.get(e).getEspecialidad()%>">
                                <%= especialidades.get(e).getEspecialidad()%>
                            </option>
                            <% }%>
                        </select>
                    </div>
                    <div class="col">
                        <button type="submit" name="buscar" class="btn btn-primary sombra" id="btn-buscar"> Buscar</button>
                    </div>
                </div>
            </form>
        </div>


        <div class="profile-area">
            <div class="container">
                <div class="row">

                    <% int i = medicos.size(); %>
                    <% do { %>
                    <% i--;%>

                    <div class="col-md-4">
                        <form class="col-12" method="POST" name="Ver" action="/proyecto1P4/presentation/paciente/cita/selectDate?mid=<%= medicos.get(0).getCedula()%>" >
                            <!--Cómo pasar el medico seleccionado en el request?-->
                            <div class="card">
                                <div class="img1"><img src="/proyecto1P4/img/img1fon.jpg"/></div>
                                <div class="img2"><img src="/proyecto1P4/img/img1.jpg"/></div>
                                <div class="main-text">
                                    <h2>
                                        <%= medicos.get(i).getNombre()%>
                                    </h2>
                                    <p><b>Especialidad:</b> 
                                        <%= medicos.get(i).getEspecialidad().getEspecialidad()%>
                                        </br>
                                        <b>Localidad:</b> 
                                        <%= medicos.get(i).getCiudad().getProvincia()%>
                                        </br>
                                        <b>Atiende:</b> L-M-J</p>
                                </div>
                                <button type="submit" name="entrar" class="btn btn-primary"> Ver</button>
                            </div>
                        </form>
                    </div>

                    <% } while (i != 0);%>
                    <!--                    <div class="col-md-4">
                                            <div class="card">
                                                <div class="img1"><img src="/proyecto1P4/img/img1fon.jpg"/></div>
                                                <div class="img2"><img src="/proyecto1P4/img/img2.jpg"/></div>
                                                <div class="main-text">
                                                    <h2>Doctor Two</h2>
                                                    <p><b>Especialidad:</b> Cardiología </br>
                                                        <b>Localidad:</b> San José</br>
                                                        <b>Atiende:</b> L-M-J</p>
                                                </div>
                                                <button type="submit" name="entrar" class="btn btn-primary"> Ver</button>
                    
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="card">
                                                <div class="img1"><img src="/proyecto1P4/img/img1fon.jpg"/></div>
                                                <div class="img2"><img src="/proyecto1P4/img/img3.jpg"/></div>
                                                <div class="main-text">
                                                    <h2>Doctor Three</h2>
                                                    <p><b>Especialidad:</b> Cardiología </br>
                                                        <b>Localidad:</b> San José</br>
                                                        <b>Atiende:</b> L-M-J</p>
                                                </div>
                                                <button type="submit" name="entrar" class="btn btn-primary"> Ver</button>
                                            </div>
                                        </div>-->

                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
