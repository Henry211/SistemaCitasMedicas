<%-- 
    Document   : view
    Created on : 11 abr. 2022, 17:59:53
    Author     : ESCINF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


        <section class="d-flex justify-content-center" style="margin-top: 40px;">
            <div class="card col-md-5 pad">
                <div class="mb-3">
                    <h4>Agregar Ciudad</h4>
                </div>
                <div class="mb-2">
                    <form  method="POST" name="Crear" action="/proyecto1P4/presentation/administrador/ciudad/crear">
                        <div class="mb-2">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" name="nombre" id="nombre">
                        </div>
                        
                        <button  type="submit" name="guardar" class="btn-editForm btn-primary" > <i class="fas fa-sign-in-alt"></i> Guardar</button>
                        <button  type="submit" name="cancelar" class="btn-editForm btn-primary"> <i class="fas fa-sign-in-alt"></i> Cancelar</button>
                    </form>
                </div>

            </div>
        </section>

    </body>
</html>
