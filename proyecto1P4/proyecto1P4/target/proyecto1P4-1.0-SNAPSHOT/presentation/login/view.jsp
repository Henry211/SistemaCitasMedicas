

<%@page import="citas.presentation.login.Model"%>
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
        <% Model model= (Model) request.getAttribute("model"); %>
        <% Map<String,String> errores = (Map<String,String>) request.getAttribute("errores"); %>
        <% Map<String,String[]> form = (errores==null)?this.getForm(model):request.getParameterMap();%>

        <div class="modal-dialog text-center">
            <div class="col-sm-8 main-section">
                <div class="modal-content">
                    <div class="col-12 user-img">
                        <img src="../../img/login.png" />
                    </div>
                    <form class="col-12" method="POST" name="Entrar" action="/proyecto1P4/presentation/login/hecho" >
                        <div class="form-goup" id="user-group">
                            <input type="text" class="form-control" name="cedulaField" placeholder="Ingrese su Id" value="<%=form.get("cedulaField")[0]%>" title="<%=title("cedeulaField",errores)%>"/>                            
                        </div>        
                        <div class="form-goup" id="contrasena-group">
                            <input type="password" class="form-control" name="claveField" placeholder="Ingrese su Clave" value="<%=form.get("claveField")[0]%>" title="<%=title("claveField",errores)%>"/>                            
                        </div>
                        <div class="text-info">
                            <input type="radio" name="tipo" value="1" checked/>Paciente
                            <input type="radio" name="tipo" value="2" /> Médico
                            <input type="radio" name="tipo" value="3" /> Admin
                            </br>
                            <!--form.get de 'tipo'-->
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

<%!
  private Map<String,String[]> getForm(Model model){
       Map<String,String[]> values = new HashMap<>();
       values.put("cedulaField", new String[]{String.valueOf(model.getUser().getCedula())});
       values.put("claveField", new String[]{model.getUser().getPassword()});
       values.put("tipo", new String[]{String.valueOf(model.getUser().getTipo())});
       return values;
    }  
private String title(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return errores.get(campo);
      else
        return "";
    }

    private String erroneo(String campo, Map<String,String> errores){
      if ( (errores!=null) && (errores.get(campo)!=null) )
        return "is-invalid";
      else
        return "";
    }
%>



