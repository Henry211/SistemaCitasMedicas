

<%@page import="java.time.LocalDate"%>
<%@page import="citas.logic.Medico"%>
<%@page import="citas.logic.Horario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Horario horario = (Horario) session.getAttribute("horarioCita"); %>
<% Medico medico = (Medico) session.getAttribute("medicoSelected");%>
<% String lunes = (String) session.getAttribute("lunes"); %>
<% String martes = (String) session.getAttribute("martes"); %>
<% String miercoles = (String) session.getAttribute("miercoles"); %>
<% String jueves = (String) session.getAttribute("jueves"); %>
<% String viernes = (String) session.getAttribute("viernes"); %>
<% String sabado = (String) session.getAttribute("sabado"); %>
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
                <div class="dias_item">
                    <%= lunes %>
                </div>
                <div class="dias_item">
                    <%= martes %>
                </div>
                <div class="dias_item">
                    <%= miercoles %>
                </div>
                <div class="dias_item">
                    <%= jueves %>
                </div>
                <div class="dias_item">
                    <%= viernes %>
                </div>
                <div class="dias_item">
                    <%= sabado %>
                </div>
            </section>

            <section class="calendario">
                <div class="calendario_dia">

                    <% int i = horario.getLunes().size(); %>
                    <% while (i != 0) { %>
                    <% i--;%>
                    <div class="cita">
                        <a class="item" href="/proyecto1P4/presentation/paciente/cita/make?mid=<%=medico.getCedula()%>&day=<%=lunes%>&hora=<%=horario.getLunes().get(i).toString()%>">
                            <%= horario.getLunes().get(i).toString()%>
                        </a>
                    </div>
                    <% } %>

                </div>
                <div class="calendario_dia">
                    <% int i2 = horario.getMartes().size(); %>
                    <% while (i2 != 0) { %>
                    <% i2--;%>
                    <div class=" cita">
                        <a class="item" href="/proyecto1P4/presentation/paciente/cita/make?mid=<%=medico.getCedula()%>&day=<%=martes%>&hora=<%=horario.getMartes().get(i2).toString()%>">
                            <%= horario.getMartes().get(i2).toString()%>
                        </a>
                    </div>
                    <% } %>
                </div>
                <div class="calendario_dia">
                    <% int i3 = horario.getMiercoles().size(); %>
                    <% while (i3 != 0) { %>
                    <% i3--;%>
                    <div class=" cita">
                        <a class="item" href="/proyecto1P4/presentation/paciente/cita/make?mid=<%=medico.getCedula()%>&day=<%=miercoles%>&hora=<%=horario.getMiercoles().get(i3).toString()%>">
                            <%= horario.getMiercoles().get(i3).toString()%>
                        </a>
                    </div>
                    <% } %>

                </div>
                <div class="calendario_dia">
                    <% int i4 = horario.getJueves().size(); %>
                    <% while (i4 != 0) { %>
                    <% i4--;%>
                    <div class=" cita">
                        <a class="item" href="/proyecto1P4/presentation/paciente/cita/make?mid=<%=medico.getCedula()%>&day=<%=jueves%>&hora=<%=horario.getJueves().get(i4).toString()%>">
                            <%= horario.getJueves().get(i4).toString()%>
                        </a>
                    </div>
                    <% } %>
                </div>
                <div class="calendario_dia">
                    <% int i5 = horario.getViernes().size(); %>
                    <% while (i5 != 0) { %>
                    <% i5--;%>
                    <div class=" cita">
                        <a class="item" href="/proyecto1P4/presentation/paciente/cita/make?mid=<%=medico.getCedula()%>&day=<%=viernes%>&hora=<%=horario.getViernes().get(i5).toString()%>">
                            <%= horario.getViernes().get(i5).toString()%>
                        </a>
                    </div>
                    <% } %>
                </div>
                <div class="calendario_dia">
                    <% int i6 = horario.getSabado().size(); %>
                    <% while (i6 != 0) { %>
                    <% i6--;%>
                    <div class=" cita">
                        <a class="item" href="/proyecto1P4/presentation/paciente/cita/make?mid=<%=medico.getCedula()%>&day=<%=sabado%>&hora=<%=horario.getSabado().get(i6).toString()%>">
                            <%= horario.getSabado().get(i6).toString()%>
                        </a>
                    </div>
                    <% }%>
                </div>

            </section>
        </main>
        <form method="GET" name="Update" action="/proyecto1P4/presentation/medico/calendario/next">
            <div class="btn-date">
                <button type="submit" class="btn btn-primary">Next Week</button>
            </div>
        </form>

        </br>

        <a href="/proyecto1P4/presentation/medico/perfil/view.jsp" id="ver-perfil-btn">Ver perfil del doctor</a>

    </body>
</html>
