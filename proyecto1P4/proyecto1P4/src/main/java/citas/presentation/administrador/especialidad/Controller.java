/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package citas.presentation.administrador.especialidad;

import citas.logic.Ciudad;
import citas.logic.Especialidad;
import citas.logic.Service;
import citas.logic.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ESCINF
 */
@WebServlet(name = "AdministradorEspecialidadController", urlPatterns = {"/presentation/administrador/especialidad/show", "/presentation/administrador/ciudad/crear", "/presentation/administrador/especialidad/crear", "/presentation/administrador/especialidad/buscar"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("model", new Model());
        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/administrador/especialidad/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/administrador/especialidad/buscar":
                viewUrl = this.buscarEsp(request);
                break;
            case "/presentation/administrador/ciudad/crear":
                viewUrl = this.createCity(request);
                break;
            case "/presentation/administrador/especialidad/crear":
                viewUrl = this.createEspe(request);
                break;

        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String show(HttpServletRequest request) throws Exception {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) throws Exception {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        ArrayList<Ciudad> ciudades = service.findAllCyties();
        session.setAttribute("ciudades", ciudades);
        try {

            return "/presentation/administrador/ciudad/view.jsp";
        } catch (Exception ex) {
            return "";
        }
    }

    private String buscarEsp(HttpServletRequest request) throws Exception {
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
        String viewUrl = "";
        switch (request.getParameter("lookFor")) {

            case "1":
                ArrayList<Ciudad> ciudades = service.findAllCyties();
                session.setAttribute("ciudades", ciudades);
                viewUrl = "/presentation/administrador/ciudad/view.jsp";
                break;

            case "2":
                ArrayList<Especialidad> especialidades = service.findAllSpetials();
                System.out.println("---->" + especialidades.get(0).getNombre());
                session.setAttribute("especialidades", especialidades);
                viewUrl = "/presentation/administrador/especialidades/view.jsp";

                break;
        }
        try {

            return viewUrl;
        } catch (Exception ex) {
            return "";
        }
    }

    private String createCity(HttpServletRequest request) {

        Service service = Service.instance();
        String name = request.getParameter("nombre");
        String viewUrl = "";
        try {

            Ciudad ciudad = new Ciudad(name);
            service.createCiudad(ciudad);

            viewUrl = "/presentation/administrador/especialidades/view.jsp";

        } catch (Exception e) {

        }

        return viewUrl;
    }

    private String createEspe(HttpServletRequest request) {

        Service service = Service.instance();
        String name = request.getParameter("nombre");
        String viewUrl = "";
        try {

            Especialidad especialidad = new Especialidad(name);
            service.createEspecialidad(especialidad);

            viewUrl = "/presentation/administrador/especialidades/view.jsp";

        } catch (Exception e) {

        }

        return viewUrl;
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
