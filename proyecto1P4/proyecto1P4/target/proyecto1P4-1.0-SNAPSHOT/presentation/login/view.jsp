

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"  integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
        <link rel="stylesheet" href="/proyecto1P4/css/estilos.css">
</head>
    <body>
        <%@ include file="/Header.jsp" %>
        

        <div class="modal-dialog text-center">
            <div class="col-sm-8 main-section">
                <div class="modal-content">
                    <div class="col-12 user-img">
                        <img src="../../img/login.png" />
                    </div>
                    <form class="col-12" method="POST" name="Entrar" action="" >
                        <div class="form-goup" id="user-group">
                            <input type="text" class="form-control" name="cedulaField" placeholder="Ingrese su Id"/>                            
                        </div>        
                        <div class="form-goup" id="contrasena-group">
                            <input type="password" class="form-control" name="claveField" placeholder="Ingrese su Clave"/>                            
                        </div>
                        <div class="text-info">
                            <input type="radio" name="tipo" value="1" checked/>Paciente
                            <input type="radio" name="tipo" value="2" /> Médico
                            <input type="radio" name="tipo" value="3" /> Admin
                            </br>
                        </div>
                        <button type="submit" name="entrar" class="btn btn-primary"> <i class="fas fa-sign-in-alt"></i> Entrar</button>
                    </form>
                    <div>
                        <a href="/proyecto1P4/presentation/login/registroView.jsp" class="text-white">Registrarse</a>
                    </div>
                </div>
            </div>
        </div>                    
                                                    
                        <!--Cargando...-->
<!--                        <div class="loader center-align" style="margin-top: 10px; display: none;">
                            <div class="preloader-wrapper active">
                                <div class="spinner-layer spinner-red-only">
                                  <div class="circle-clipper left">
                                    <div class="circle"></div>
                                  </div><div class="gap-patch">
                                    <div class="circle"></div>
                                  </div><div class="circle-clipper right">
                                    <div class="circle"></div>
                                  </div>
                                </div>
                              </div>
                        </div>-->
                    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
    </body>
</html>



