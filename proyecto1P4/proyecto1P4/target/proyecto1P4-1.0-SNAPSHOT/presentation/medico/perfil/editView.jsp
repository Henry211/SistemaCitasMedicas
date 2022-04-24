

<%@page import="citas.logic.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Medico medico = (Medico) session.getAttribute("medico");
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
        <section class="d-flex justify-content-center">
            <div class="card col-md-5 pad">
                <div class="mb-3">
                    <h4>Editar Perfil</h4>
                </div>
                <div class="mb-2">
                    <form action="action">
                        <div class="mb-2">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" value= "<%= medico.getNombre()%>" id="nombre">
                        </div>
                       
                        <div class="mb-2">
                            <label for="nombre">Localidad</label>
                            <select id="localidad" class="form-select" aria-label="Default select example">
                                <option selected>Seleccione la Localidad</option>
                                <!--HAcer metodo de ciudades admin en session-->
                                <option value="1">San José</option>
                                <option value="2">Alajuela</option>
                                <option value="3">Heredia</option>
                                <option value="3">Cartago</option>
                            </select>
                        </div>
                        <!--                        <div class="mb-2">
                                                    <label for="correo">Correo</label>
                                                    <input type="text" class="form-control" name="correo" id="correo">
                                                </div>
                                                <div class="mb-2">
                                                    <label for="telefono">Telefono</label>
                                                    <input type="text" class="form-control" name="telefono" id="telefono">
                                                </div>-->
                        <div class="mb-2">
                            <label for="especialidad">Especialidad</label>
                            <select id="especialidad" class="form-select" aria-label="Default select example">
                                <option selected>Seleccione la Especialidad</option>
                                <option value="1">Cardiología</option>
                                <option value="2">Dermatología</option>
                                <option value="3">Pediatría</option>
                                <option value="3">Medicina General</option>
                                <option value="3">Gastroenterología</option>
                            </select>
                        </div>
                        <div class="mb-2">
                            <label for="dias">Días de atención:</label> </br>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1" checked>
                                <label class="form-check-label" for="inlineCheckbox1">Lunes</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                                <label class="form-check-label" for="inlineCheckbox2">Martes</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                                <label class="form-check-label" for="inlineCheckbox2">Miercoles</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                                <label class="form-check-label" for="inlineCheckbox2">Jueves</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                                <label class="form-check-label" for="inlineCheckbox2">Viernes</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                                <label class="form-check-label" for="inlineCheckbox2">Sabado</label>
                            </div>
                        </div>
                        <div class="mb-2">
                            <label for="formFile" class="form-label">Foto de perfil</label>
                            <input class="form-control" type="file" id="formFile">
                        </div>
                    </form>
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



    </body>
</html>

                                <%!
            private String checkLunes() {

                //if (medico.getNombre()) {
                //}
                return "";
            }
        %>


