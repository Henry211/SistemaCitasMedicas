
<%@page import="java.util.ArrayList"%>
<%@page import="citas.logic.Ciudad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Ciudad> ciudades = (ArrayList<Ciudad>) session.getAttribute("ciudades"); %>
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
                <div class="col">
                    <button type="button" class="btn btn-dark">Medicos</button>
                </div>
                <div class="col">
                    <button type="button" class="btn btn-dark">Especialidades</button>
                </div>
                <div class="col">
                    <button type="button" class="btn btn-dark">Ciudades</button>
                </div>

            </div>
        </div>

        <div class="div-addNew text-center">
            <a class="add-btn" href="/proyecto1P4/presentation/administrador/datos/viewCiudad.jsp">Agregar nueva Ciudad</a>    
            <a class="add-btn" href="/proyecto1P4/presentation/administrador/datos/viewEspecialidad.jsp">Agregar nueva Especialidad</a>    
        </div>

        <% int i = ciudades.size(); %>
        <% do{ %>
        <% i--; %>
        <div class="card">
            <h5 class="card-header">Ciudad.</h5>
            <div class="card-body">
                <h5 class="card-title"> 
                    <%= ciudades.get(i).getProvincia() %>
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
        <% }while(i != 0); %>



    </body>
</html>
