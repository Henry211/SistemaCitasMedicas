
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
                    <%  //if( userLogued.getTipo() == 1 ){ %>
                    <li class="navbar-item active">
                        <a href="/proyecto1P4/presentation/registromedico/view.jsp" class="nav-link">
                            Médicos
                        </a>
                    </li>
                    <%  //} %>
                    <% //if( user.getTipo() == 2 ){ %>
                    <li class="navbar-item active">
                        <a href="/proyecto1P4/presentation/medico/citas/view.jsp" class="nav-link">
                            Citas
                        </a>
                    </li>
                    <% //} %>
                    <% //if( userLogued == null ){ %>
                    <li class="navbar-item active">
                        <a href="/proyecto1P4/presentation/login/view.jsp" class="nav-link">
                            Login
                        </a>
                    </li>
                    <% //} %>
                    <% //if( userLogued != null ){ %>
                    <li class="navbar-item active">
                        <a href="" class="nav-link">
                            Logout
                        </a>
                    </li>
                    <% //} %>
                </ul>

            </div>
        </nav>
    </div>
</header>


