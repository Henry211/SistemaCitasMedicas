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
                    <h4>Agregar Especialidad</h4>
                </div>
                <div class="mb-2">
                    <form action="/proyecto1P4/presentation/administrador/especialidad/crear" method="POST" name="crear">
                        <div class="mb-2">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" name="nombre" id="nombre">
                        </div>
                        
                        <button  type="submit" name="guardar" class="btn-editForm btn-primary" style="display: inline-block" > <i class="fas fa-sign-in-alt"></i> Guardar</button>
                        <button  type="submit" name="cancelar" class="btn-editForm btn-primary" style="display: inline-block"> <i class="fas fa-sign-in-alt"></i> Cancelar</button>
                    </form>
                </div>

            </div>
        </section>

    </body>
</html>