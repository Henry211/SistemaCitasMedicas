

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                        <img src="/proyecto1P4/img/login.png" />
                    </div>
                    <form class="col-12" method="POST" name="Entrar" action="/proyecto1P4/presentation/login/registro" >
                        <div class="form-goup" id="name-group">
                            <input type="text" class="form-control" name="nombreField" placeholder="Ingrese su Nombre"/>                            
                        </div>        
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
                        <button type="submit" name="entrar" class="btn btn-primary"> <i class="fas fa-sign-in-alt"></i> Registrarse</button>
                    </form>
                </div>
            </div>
        </div>  
    </body>
</html>
