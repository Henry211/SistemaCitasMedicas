
<%@page import="citas.logic.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
            <div class="row">
                <div class="col">
                    <select id="localidad" class="form-select sombra" aria-label="Default select example">
                        <option selected>Seleccione la Localidad</option>
                        <option value="1">San José</option>
                        <option value="2">Alajuela</option>
                        <option value="3">Heredia</option>
                        <option value="3">Cartago</option>
                    </select>
                </div>
                <div class="col">
                    <select id="especialidad" class="form-select sombra" aria-label="Default select example">
                        <option selected>Seleccione la Especialidad</option>
                        <option value="1">Cardiología</option>
                        <option value="2">Dermatología</option>
                        <option value="3">Pediatría</option>
                        <option value="3">Medicina General</option>
                        <option value="3">Gastroenterología</option>
                    </select>
                </div>
                <div class="col">
                    <button type="submit" name="buscar" class="btn btn-primary sombra" id="btn-buscar"> Buscar</button>
                </div>
            </div>
        </div>


        <div class="profile-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card">
                            <div class="img1"><img src="/proyecto1P4/img/img1fon.jpg"/></div>
                            <div class="img2"><img src="/proyecto1P4/img/img1.jpg"/></div>
                            <div class="main-text">
                                <h2>Doctor One</h2>
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
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <div class="img1"><img src="/proyecto1P4/img/img1fon.jpg"/></div>
                            <div class="img2"><img src="/proyecto1P4/img/img2.jpg" /></div>
                            <div class="main-text">
                                <h2 >Doctor Four</h2>
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
                                <h2>Doctor Five</h2>
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
                            <div class="img2"><img src="/proyecto1P4/img/img1.jpg"/></div>
                            <div class="main-text">
                                <h2>Doctor Six</h2>
                                <p><b>Especialidad:</b> Cardiología </br>
                                    <b>Localidad:</b> San José</br>
                                    <b>Atiende:</b> L-M-J</p>
                            </div>
                            <button type="submit" name="entrar" class="btn btn-primary"> Ver</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
