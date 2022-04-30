

<%@page import="citas.logic.Ciudad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="citas.logic.Especialidad"%>
<%@page import="citas.logic.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Medico medico = (Medico) session.getAttribute("medico"); %>
<% ArrayList<Especialidad> especialidades = (ArrayList<Especialidad>) session.getAttribute("especialidadesCombo"); %>
<% ArrayList<Ciudad> ciudades = (ArrayList<Ciudad>) session.getAttribute("ciudadesCombo");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"  integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="/proyecto1P4/css/estilos.css">
        <%@ include file="/Header.jsp" %>
    </head>
    <body>
        </br>
        <form method="POST" name="Update" action="/proyecto1P4/presentation/medico/perfil/update">

            <section class="d-flex justify-content-center">
                <div class="card col-md-5 pad">
                    <div class="mb-3">
                        <h4>Editar Perfil</h4>
                    </div>
                    <div class="mb-2">


                        <div class="mb-2">
                            <label for="nombre">Localidad</label>
                            <select name="localidadCmb" id="localidad" class="form-select" aria-label="Default select example">
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

                        <div class="mb-2">
                            <label for="especialidad">Especialidad</label>
                            <select name="especialidadCmb" id="especialidad" class="form-select" aria-label="Default select example">
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
                            
                            <div class="mb-2">
                                <label>Duración de cita</label>
                                <select name="duracionCmb" class="form-select">
                                    <option>30 minutos</option>
                                    <option>1 hora</option>
                                    <option>1 hora  y 30 minutos</option>
                                    <option>2 horas</option>
                                </select>
                            </div>

                            
                            <!--***************-->
                            
                        <div class="mb-2">
                            <label for="dias">Días de atención:</label> </br>
                            <div class="form-check form-check-inline">
                                <div class="parent-day">
                                    <div class="child-day">
                                        <input name="checkL" class="form-check-input day" type="checkbox" id="inlineCheckbox1" value="lunes" checked>
                                        <label class="form-check-label day" for="inlineCheckbox1" style="margin-right: 25px;">Lunes</label>
                                    </div>
                                    <div class="child-day">
                                        <select name="iniL" class="form-select day" aria-label="Default select example">
                                            <option>Hora de inicio</option>
                                            <option>8am</option>
                                            <option>9am</option>
                                            <option>10am</option>
                                            <option>1pm</option>
                                            <option>2pm</option>
                                            <option>3pm</option>
                                            <option>4pm</option>
                                        </select>
                                    </div>
                                    <div class="child-day">
                                        <select name="finL" class="form-select day" aria-label="Default select example">
                                            <option>Hora de finalización</option>
                                            <option>9am</option>
                                            <option>10am</option>
                                            <option>11am</option>
                                            <option>2pm</option>
                                            <option>3pm</option>
                                            <option>4pm</option>
                                            <option>5pm</option>
                                            <option>6pm</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            </br>
                            
                            <div class="form-check form-check-inline">
                                <div class="parent-day">
                                    <div class="child-day">
                                        <input name="checkM" class="form-check-input day" type="checkbox" id="inlineCheckbox1" value="option1" checked>
                                        <label class="form-check-label day" for="inlineCheckbox1" style="margin-right: 20px;">Martes</label>
                                    </div>
                                    <div class="child-day">
                                        <select name="iniM" class="form-select day" aria-label="Default select example">
                                            <option>Hora de inicio</option>
                                            <option>8am</option>
                                            <option>9am</option>
                                            <option>10am</option>
                                            <option>1pm</option>
                                            <option>2pm</option>
                                            <option>3pm</option>
                                            <option>4pm</option>
                                        </select>
                                    </div>
                                    <div class="child-day">
                                        <select name="finM" class="form-select day" aria-label="Default select example">
                                            <option>Hora de finalización</option>
                                            <option>9am</option>
                                            <option>10am</option>
                                            <option>11am</option>
                                            <option>2pm</option>
                                            <option>3pm</option>
                                            <option>4pm</option>
                                            <option>5pm</option>
                                            <option>6pm</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            </br>
                            
                            <div class="form-check form-check-inline">
                                <div class="parent-day">
                                    <div class="child-day">
                                        <input name="checkI" class="form-check-input day" type="checkbox" id="inlineCheckbox1" value="option1" checked>
                                        <label class="form-check-label day" for="inlineCheckbox1">Miercoles</label>
                                    </div>
                                    <div class="child-day">
                                        <select name="iniI" class="form-select day" aria-label="Default select example">
                                            <option>Hora de inicio</option>
                                            <option>8am</option>
                                            <option>9am</option>
                                            <option>10am</option>
                                            <option>1pm</option>
                                            <option>2pm</option>
                                            <option>3pm</option>
                                            <option>4pm</option>
                                        </select>
                                    </div>
                                    <div class="child-day">
                                        <select name="finI" class="form-select day" aria-label="Default select example">
                                            <option>Hora de finalización</option>
                                            <option>9am</option>
                                            <option>10am</option>
                                            <option>11am</option>
                                            <option>2pm</option>
                                            <option>3pm</option>
                                            <option>4pm</option>
                                            <option>5pm</option>
                                            <option>6pm</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            </br>
                            
                            <div class="form-check form-check-inline">
                                <div class="parent-day">
                                    <div class="child-day">
                                        <input name="checkJ" class="form-check-input day" type="checkbox" id="inlineCheckbox1" value="option1" checked>
                                        <label class="form-check-label day" for="inlineCheckbox1" style="margin-right: 23px;">Jueves</label>
                                    </div>
                                    <div class="child-day">
                                        <select name="iniJ" class="form-select day" aria-label="Default select example">
                                            <option>Hora de inicio</option>
                                            <option>8am</option>
                                            <option>9am</option>
                                            <option>10am</option>
                                            <option>1pm</option>
                                            <option>2pm</option>
                                            <option>3pm</option>
                                            <option>4pm</option>
                                        </select>
                                    </div>
                                    <div class="child-day">
                                        <select name="finJ" class="form-select day" aria-label="Default select example">
                                            <option>Hora de finalización</option>
                                            <option>9am</option>
                                            <option>10am</option>
                                            <option>11am</option>
                                            <option>2pm</option>
                                            <option>3pm</option>
                                            <option>4pm</option>
                                            <option>5pm</option>
                                            <option>6pm</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            </br>
                            
                            <div class="form-check form-check-inline">
                                <div class="parent-day">
                                    <div class="child-day">
                                        <input name="checkV" class="form-check-input day" type="checkbox" id="inlineCheckbox1" value="option1" checked>
                                        <label class="form-check-label day" for="inlineCheckbox1" style="margin-right: 20px;">Viernes</label>
                                    </div>
                                    <div class="child-day">
                                        <select name="iniV" class="form-select day" aria-label="Default select example">
                                            <option>Hora de inicio</option>
                                            <option>8am</option>
                                            <option>9am</option>
                                            <option>10am</option>
                                            <option>1pm</option>
                                            <option>2pm</option>
                                            <option>3pm</option>
                                            <option>4pm</option>
                                        </select>
                                    </div>
                                    <div class="child-day">
                                        <select name="finV" class="form-select day" aria-label="Default select example">
                                            <option>Hora de finalización</option>
                                            <option>9am</option>
                                            <option>10am</option>
                                            <option>11am</option>
                                            <option>2pm</option>
                                            <option>3pm</option>
                                            <option>4pm</option>
                                            <option>5pm</option>
                                            <option>6pm</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            </br>
                            
                            <div class="form-check form-check-inline">
                                <div class="parent-day">
                                    <div class="child-day">
                                        <input name="checkS" class="form-check-input day" type="checkbox" id="inlineCheckbox1" value="option1" checked>
                                        <label class="form-check-label day" for="inlineCheckbox1" style="margin-right: 18px;">Sabado</label>
                                    </div>
                                    <div class="child-day">
                                        <select name="iniS" class="form-select day" aria-label="Default select example">
                                            <option>Hora de inicio</option>
                                            <option>8am</option>
                                            <option>9am</option>
                                            <option>10am</option>
                                            <option>1pm</option>
                                            <option>2pm</option>
                                            <option>3pm</option>
                                            <option>4pm</option>
                                        </select>
                                    </div>
                                    <div class="child-day">
                                        <select name="finS" class="form-select day" aria-label="Default select example">
                                            <option>Hora de finalización</option>
                                            <option>9am</option>
                                            <option>10am</option>
                                            <option>11am</option>
                                            <option>2pm</option>
                                            <option>3pm</option>
                                            <option>4pm</option>
                                            <option>5pm</option>
                                            <option>6pm</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            </br>

                        </div>
                        <div class="mb-2">
                            <label for="formFile" class="form-label">Foto de perfil</label>
                            <input class="form-control" type="file" id="formFile">
                        </div>

                    </div>


                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <button  type="submit" name="guardar" class="btn-editForm btn-primary"> <i class="fas fa-sign-in-alt"></i> Guardar</button>

                            </div>
                            <div class="col">
                                <button  type="submit" name="cancelar" class="btn-editForm btn-primary"> <i class="fas fa-sign-in-alt"></i> Cancelar</button>
                            </div>
                        </div>
                    </div>


                </div>


            </section>

        </form>

    </body>
</html>

<%!
    private String checkLunes() {

        //if (medico.getNombre()) {
        //}
        return "";
    }
%>


