
<%@page import="citas.logic.Especialidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="citas.logic.Ciudad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Especialidad> especialidades = (ArrayList<Especialidad>) session.getAttribute("especialidades");%>
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
                    <div class="order-by">Tipo de solicitudes  </div>
                </div>

                <form class="col-12" method="POST" name="Entrar" action="/proyecto1P4/presentation/administrador/especialidad/buscar" >
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="lookFor" id="inlineRadio1" value="2" checked>
                        <label class="form-check-label radioLabels" for="inlineRadio1">Especialidades</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="lookFor" id="inlineRadio1" value="1">
                        <label class="form-check-label radioLabels" for="inlineRadio1">Ciudades</label>
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Buscar</button>
                </form>

            </div>
        </div>

        <div class="div-addNew text-center">
            <a class="add-btn" href="/proyecto1P4/presentation/administrador/datos/viewCiudad.jsp">Agregar nueva Ciudad</a>    
            <a class="add-btn" href="/proyecto1P4/presentation/administrador/datos/viewEspecialidad.jsp">Agregar nueva Especialidad</a>    
        </div>


        <% int i = especialidades.size(); %>
        <% do { %>
        <% i--;%>
        <div class="card">
            <h5 class="card-header">Especialidad.</h5>
            <div class="card-body">
                <h5 class="card-title"> 
                    <%= especialidades.get(i).getNombre() %>
                </h5>
                <p class="card-text">

                <div class="container">
                    <div class="row">
                        <div class="col">
                            ... </br> 
                        </div>
                        <div class="col">
                            ... </br>
                        </div>

                    </div>
                </div>

            </div>
        </div>
        <% } while (i != 0);%>






    </body>
</html>
