
<%@page import="citas.logic.Cita"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<Cita> citas = (ArrayList<Cita>) session.getAttribute("citasList");
%>
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

        <% int i = citas.size(); %>
        <% while (i != 0) { %>
        <% i--;%>

        <div class="card">
            <h5 class="card-header"><%= citas.get(i).getMedico().getEspecialidad().getEspecialidad() %></h5>
            <div class="card-body">
                <h5 class="card-title"></h5>
                <p class="card-text">

                <div class="container">
                    <div class="row">
                        <div class="col">
                            Estado: <%= citas.get(i).getEstado() %> </br>  </br> 
                        </div>
                        <div class="col">
                            Fecha y hora: <%= citas.get(i).getDateStr() %> <%= citas.get(i).getHoraStr()  %></br>
                        </div>
                        <div class="col">
                            Paciente: <%= citas.get(i).getPaciente().getNombre() %> </br>
                        </div>
                        <div class="col">
                            Medico: <%= citas.get(i).getMedico().getNombre() %> </br>
                        </div>
                        <div class="col">
                            Localidad <%= citas.get(i).getMedico().getCiudad().getProvincia() %> </br>
                        </div>

                    </div>
                </div>

                <a href="/proyecto1P4/presentation/medico/citas/cancelarCita?citaId=<%=citas.get(i).getIdCita()%>" class="btn btn-primary">Cancelar</a>
            </div>
        </div>
        <% } %>

    </body>
</html>
