<%@page import="citas.logic.Usuario"%>
<% Usuario usuario=  (Usuario) session.getAttribute("usuario");  %>


<header>
    <div class="container">
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">

            <a href="url" class="navbar-brand mb0 h1">
                <img class="d-inline-block align-top" 
                     src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg"
                     alt="alt" width="30" height="30" style="margin-left: 20px;"/>
                Smart Medical
            </a>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a href="/proyecto1P4/index.jsp" class="nav-link">
                            Inicio
                        </a>
                    </li>
                    <%  //if( usuario.getTipo() == 1 ){ %>
                    <li class="navbar-item active">
                        <a href="/proyecto1P4/presentation/registromedico/show" class="nav-link">
                            Médicos
                        </a>
                    </li>
                    <%  //} %>
                    <% //if( user.getTipo() == 2 ){ %>
                    <li class="navbar-item active">
                        <a href="/proyecto1P4/presentation/medico/citas/show" class="nav-link">
                            Citas
                        </a>
                    </li>
                    <% //} %>
                    <% //if( userLogued == null ){ %>
                    <li class="navbar-item active">
                        <a href="/proyecto1P4/presentation/login/mostrar" class="nav-link">
                            Login
                        </a>
                    </li>
                    <% //} %>
                    <% //if( userLogued != null ){ %>
                    <li class="navbar-item active">
                        <a href="/proyecto1P4/presentation/login/logout" class="nav-link">
                            Logout
                        </a>
                    </li>
                    <% //} %>
                    <% //if( userLogued != null ){ %>
                    <li class="navbar-item active">
                        <a href="/proyecto1P4/presentation/medico/perfil/show" class="nav-link">
                            Perfil
                        </a>
                    </li>
                    <% //} %>
                    <% //if( userLogued != null ){ %>
                    <li class="navbar-item active">
                        <a href="/proyecto1P4/presentation/medico/calendario/show" class="nav-link">
                            Calendario
                        </a>
                    </li>
                    <% //} %>
                    <% //if( userLogued != null ){ %>
                    <li class="navbar-item active">
                        <a href="/proyecto1P4/presentation/administrador/especialidad/show" class="nav-link">
                            Solicitudes (admin)
                        </a>
                    </li>
                    <% //} %>
                    <% //if( userLogued != null ){ %>
                    <li class="navbar-item active">
                        <a href="/proyecto1P4/presentation/administrador/listamedicos/show" class="nav-link">
                            Solicitudes medicos (admin)
                        </a>
                    </li>
                    <% //} %>
                </ul>

            </div>
        </nav>
    </div>
</header>


