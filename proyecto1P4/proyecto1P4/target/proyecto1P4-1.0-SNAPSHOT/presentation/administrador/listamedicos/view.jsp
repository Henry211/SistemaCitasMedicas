
<%@page import="citas.logic.Ciudad"%>
<%@page import="citas.logic.Especialidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="citas.logic.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Medico> medicos = (ArrayList<Medico>) session.getAttribute("listaMedicos"); %>

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


        <div class="container sombra">
            <form class="col-12" method="GET" name="Buscar" action="/proyecto1P4/presentation/administrador/listamedicos/show" >
                <div class="row">
                    <div class="col">
                        <select name="medicos" id="medicos" class="form-select sombra" aria-label="Default select example" style="margin-top: 50px; ">
                            <option selected>Seleccione la Localidad</option>
                            <option value="1">Todos los médicos</option>
                            <option value="2">Solicitudes pendientes</option>
                           
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
                        <form class="col-12" method="POST" name="Ver" action="/proyecto1P4/presentation/administrador/listamedicos/update?mid=<%= medicos.get(0).getCedula()%>" >

                            <div class="card">
                                <div class="img1"><img src="/proyecto1P4/img/img1fon.jpg"/></div>
                                <!--Print user avatar -->
                                <% if(medicos.get(i).getImage() != null){ %> 
                                    <div class="img2"><img src="data:image/jpg;base64,<%= medicos.get(i).getBase64Image()%>"/></div> 
                                <% } if(medicos.get(i).getImage() == null){ %>
                                    <div class="img2"><img src="/proyecto1P4/img/default.jpg" /></div>
                                <% }%>
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
                                <button type="submit"  value="aceptar" class="btn btn-primary" style="margin-top: -40px;" >Aceptar</button>
                                <button type="submit" name="entrar" value="rechazar" class="btn btn-primary" style="margin-top: -15px;">Rechazar</button>
                            </div>
                        </form>
                    </div>

                    <% } while (i != 0);%>


                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
