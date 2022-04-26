

<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDate"%>
<%@page import="citas.logic.Medico"%>
<%@page import="citas.logic.Horario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% Horario horario = (Horario) session.getAttribute("horarioCita"); %>

<% Medico medico = (Medico) session.getAttribute("medicoSelected");%>

<% ArrayList<String> citasOcupadas = (ArrayList<String>) session.getAttribute("citasOcupadas");%>

<% String lunes = (String) session.getAttribute("lunes"); %>
<% String martes = (String) session.getAttribute("martes"); %>
<% String miercoles = (String) session.getAttribute("miercoles"); %>
<% String jueves = (String) session.getAttribute("jueves"); %>
<% String viernes = (String) session.getAttribute("viernes"); %>
<% String sabado = (String) session.getAttribute("sabado");
%>
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

            <form method="GET" name="Update" action="/proyecto1P4/presentation/medico/calendario/next">
                <div class="btn-date">
                    <button type="submit" class="btn btn-primary">Next Week</button>
                </div>
            </form>


            <section class="dias">
                <div class="dias_item">
                    <%= lunes%>
                </div>
                <div class="dias_item">
                    <%= martes%>
                </div>
                <div class="dias_item">
                    <%= miercoles%>
                </div>
                <div class="dias_item">
                    <%= jueves%>
                </div>
                <div class="dias_item">
                    <%= viernes%>
                </div>
                <div class="dias_item">
                    <%= sabado%>
                </div>
            </section>

            <section class="calendario">
                <% if (horario != null) { %>
                <div class="calendario_dia">


                    <% int i = horario.getLunes().size(); %>
                    <% while (i != 0) { %>
                    <% i--;%>
                    <div class="cita">
                        <a class="item"
                           <% int b1 = citasOcupadas.size() - 1; %>
                           <% String date1 = lunes + " " + horario.getLunes().get(i).toString(); %>
                           <% do { %>
                           <% String cita = citasOcupadas.get(b1); %>                                
                           <% if (lunes == "Lunes" || date1.equals(cita)) { %>
                           style="pointer-events: none;"
                           <% }b1--; %>                          
                           <% }while (b1 != 0);%>
                           href="/proyecto1P4/presentation/paciente/cita/make?mid=<%=medico.getCedula()%>&day=<%=lunes%>&hora=<%=horario.getLunes().get(i).toString()%>">
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
                        <a class="item"
                          <% int b2 = citasOcupadas.size() - 1; %>
                           <% String date2 = martes + " " + horario.getMartes().get(i2).toString(); %>
                           <% do { %>
                           <% String cita2 = citasOcupadas.get(b2); %>                                
                           <% if (martes == "Martes" || date2.equals(cita2)) { %>
                           style="pointer-events: none;"
                           <% }b2--; %>                          
                           <% }while (b2 != 0);%>
                           href="/proyecto1P4/presentation/paciente/cita/make?mid=<%=medico.getCedula()%>&day=<%=martes%>&hora=<%=horario.getMartes().get(i2).toString()%>">
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
                        <a class="item"
                           <% int b3 = citasOcupadas.size() - 1; %>
                           <% String date3 = miercoles + " " + horario.getMiercoles().get(i3).toString(); %>
                           <%do { %>
                           <% String cita3 = citasOcupadas.get(b3); %>                                
                           <% if (miercoles == "Miercoles" || date3.equals(cita3)) { %>
                           style="pointer-events: none;"
                           <% }b3--; %>                          
                           <% } while (b3 != 0);%>
                           href="/proyecto1P4/presentation/paciente/cita/make?mid=<%=medico.getCedula()%>&day=<%=miercoles%>&hora=<%=horario.getMiercoles().get(i3).toString()%>">
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
                        <a class="item"
                           <% int bou = citasOcupadas.size() - 1; %>
                           <% String date4 = jueves + " " + horario.getJueves().get(i4).toString(); %>
                           <% do { %>
                           <% String cita4 = citasOcupadas.get(bou); %>                                
                           <% if (jueves == "Jueves" || date4.equals(cita4)) { %>
                           style="pointer-events: none;"
                           <% }bou--; %>                          
                           <% }while (bou != 0);%>

                           href="/proyecto1P4/presentation/paciente/cita/make?mid=<%=medico.getCedula()%>&day=<%=jueves%>&hora=<%=horario.getJueves().get(i4).toString()%>">
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
                        <a class="item"
                           <% int b4 = citasOcupadas.size() - 1; %>
                           <% String date5 = viernes + " " + horario.getViernes().get(i4).toString(); %>
                           <% do { %>
                           <% String cita5 = citasOcupadas.get(b4); %>                                
                           <% if (viernes == "Viernes" || date5.equals(cita5)) { %>
                           style="pointer-events: none;"
                           <% }b4--; %>                          
                           <% }while (b4 != 0);%>
                           href="/proyecto1P4/presentation/paciente/cita/make?mid=<%=medico.getCedula()%>&day=<%=viernes%>&hora=<%=horario.getViernes().get(i5).toString()%>">
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
                        <a class="item"
                           <% if (sabado == "Sabado") { %>
                           style="pointer-events: none;"
                           <% }%>
                           href="/proyecto1P4/presentation/paciente/cita/make?mid=<%=medico.getCedula()%>&day=<%=sabado%>&hora=<%=horario.getSabado().get(i6).toString()%>">
                            <%= horario.getSabado().get(i6).toString()%>
                        </a>
                    </div>
                    <% }%>
                </div>
                <% }%>

            </section>
        </main>


        </br>

        <a href="/proyecto1P4/presentation/medico/perfil/view.jsp" id="ver-perfil-btn">Ver perfil del doctor</a>

    </body>
</html>
