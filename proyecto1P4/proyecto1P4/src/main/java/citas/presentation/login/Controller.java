/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package citas.presentation.login;

import citas.logic.Administrador;
import citas.logic.Medico;
import citas.logic.Paciente;
import citas.logic.Service;
import citas.logic.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ESCINF comentario
 */
@WebServlet(name = "LoginController", urlPatterns = {"/presentation/login/mostrar", "/presentation/login/hecho", "/presentation/login/logout", "/presentation/login/registro"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("model", new Model());

        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/login/mostrar":
                viewUrl = this.show(request);
                break;
            case "/presentation/login/hecho":
                viewUrl = this.login(request);
                break;
            case "/presentation/login/logout":
                viewUrl = this.logout(request);
                break;
            case "/presentation/login/registro":
                viewUrl = this.registro(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    private String login(HttpServletRequest request) {
        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.loginAction(request);
            } else {
                request.setAttribute("errores", errores);
                return "/presentation/login/View.jsp";
            }
        } catch (Exception e) {
            return "/presentation/Error.jsp";
        }
    }

    // Que los campos estén llenos
    Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();
        if (request.getParameter("cedulaField").isEmpty()) {
            errores.put("cedulaField", "Cedula requerida");
        }

        if (request.getParameter("claveField").isEmpty()) {
            errores.put("claveField", "Clave requerida");
        }
        return errores;
    }

    void updateModel(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        //model.getPaciente().setCedula(request.getParameter("cedulaField"));
        // model.getPaciente().setClave(request.getParameter("claveField"));
        // model.getUser().setCedula(request.getParameter("cedulaField"));
        //model.getUser().setClave(request.getParameter("claveField"));
    }

    public String loginAction(HttpServletRequest request) {
        
        Model model = (Model) request.getAttribute("model");

        HttpSession session = request.getSession(true);
        String usuario = request.getParameter("cedulaField");
        String password = request.getParameter("claveField");
        String tipo = request.getParameter("tipo");
        session.setAttribute("userType", tipo);
   
        Service service = Service.instance();
        try {
            
            String viewUrl = "";
            switch (tipo) {
                case "1":
                    Paciente real = new Paciente(usuario, password);
                    Paciente p = service.pacienteLogin(real);
                    session.setAttribute("paciente", p);

                    viewUrl = "/presentation/registromedico/show";
                    break;
                case "2":
                    Medico real2 = new Medico(usuario, password);
                    Medico m = service.medicoLogin(real2);
                    session.setAttribute("medico", m);
    
                    viewUrl = "/presentation/medico/perfil/show";
                    break;
                case "3":
                    Administrador real1 = new Administrador(usuario, password);
                    Administrador a = service.administradorLogin(real1);
                    session.setAttribute("admin",a);
                    
                    viewUrl = "/presentation/administrador/especialidades/view.jsp";
                    break;

            }
            return viewUrl;
        } catch (Exception ex) {
            return "/presentation/login/view.jsp";
        }
    }

    public String registro(HttpServletRequest request) {

        // lógica de registro
        System.out.println("entro");
        Model model = (Model) request.getAttribute("model");

        HttpSession session = request.getSession(true);
        String usuario = request.getParameter("nombreField");
        String cedula = request.getParameter("cedulaField");
        String password = request.getParameter("claveField");
        System.out.println("Datos " + usuario + "+" + password);
        Service service = Service.instance();
        try {
            //*Paciente real = service.login(model.getUser().getCedula(),model.getUser().getClave());

            //  session.setAttribute("usuario", real);//ASIGNAR user PARA Header
            String viewUrl = "";
            switch (request.getParameter("tipo")) {
                case "1":
                    Paciente real = new Paciente(usuario, cedula,password);
                    service.createPaciente(real);
                    session.setAttribute("paciente", real);
                    System.out.println("Name-> " + real.getNombre());
                    viewUrl = "/presentation/registromedico/show";
                    break;
                case "2":
                    Medico real2 = new Medico(usuario,cedula, password);
                    service.createMedico(real2);
                    session.setAttribute("medico", real2);
                    System.out.println("Name-> "+ real2.getCedula());
                    viewUrl = "/presentation/medico/perfil/editar";
                    break;
                case "3":
                    Administrador real1 = new Administrador(usuario,cedula, password);
                    service.createAdministrador(real1);
                    session.setAttribute("admin", real1);
                    System.out.println("Name-> "+ real1.getCedula());
                    viewUrl = "/presentation/administrador/especialidades/view.jsp";
                    break;

            }
            return viewUrl;
        } catch (Exception ex) {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("cedulaField", "Usuario o clave incorrectos");
            errores.put("claveField", "Usuario o clave incorrectos");

        
        return "/presentation/registromedico/view.jsp";
    }
    }

    public String logout(HttpServletRequest request) {
        return this.logoutAction(request);
    }

    public String logoutAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("usuario");
        session.invalidate();
        return "/proyecto1P4/index.jsp";
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        model.getUser().setCedula("");
        model.getUser().setClave("");
        return "/presentation/login/view.jsp";
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
