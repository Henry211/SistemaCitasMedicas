/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package citas.presentation.medico.perfil;

import citas.logic.Ciudad;
import citas.logic.Especialidad;
import citas.logic.Medico;
import citas.logic.Paciente;
import citas.logic.Service;
import citas.logic.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "MedicoPerfilController", urlPatterns = {"/presentation/medico/perfil/show", "/presentation/medico/calendario/show", "/presentation/medico/perfil/editar","/presentation/medico/perfil/update"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("model", new Model());
        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/medico/perfil/show":
                viewUrl = this.show(request);
                break;
            case "/presentation/medico/calendario/show":
                viewUrl = this.showCalendar(request);
                break;
            case "/presentation/medico/perfil/editar":
                viewUrl = this.editProfile(request);
                break;
            case "/presentation/medico/perfil/update":
                viewUrl = this.updateProfile(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }

    public String show(HttpServletRequest request) {
        return this.showAction(request);
    }


    public String showAction(HttpServletRequest request) {
//        Model model = (Model) request.getAttribute("model");
//        Service service = Service.instance();
        //HttpSession session = request.getSession(true);

//        Paciente paciente = (Paciente) session.getAttribute("paciente");
        //Medico me = (Medico) session.getAttribute("medico");
//        System.out.println(me.getNombre());
//        System.out.println(me.getClave());
//        System.out.println(me.getCedula());
//
//        model.setMedico(me);
//        request.setAttribute("model", model);

        try {

            return "/presentation/medico/perfil/view.jsp";
        } catch (Exception ex) {
            return "";
        }
    }

    public String showCalendar(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        try {

            return "/presentation/calendario/view.jsp";
        } catch (Exception ex) {
            return "";
        }
    }
    
    public String editProfile(HttpServletRequest request) throws Exception{
        
        HttpSession session = request.getSession(true);
        Service service = Service.instance();
        
        // 1-- Traer datos de DB --
        // 2--Guardar datos en Model--
        // 3--Guardar Model en session-- 
        ArrayList<Especialidad> especialidades = service.findAllSpetials();
        ArrayList<Ciudad> ciudades = service.findAllCyties();

        
        session.setAttribute("especialidadesCombo", especialidades);
        session.setAttribute("ciudadesCombo", ciudades);
        
        return "/presentation/medico/perfil/editView.jsp";
    }
    
    public String updateProfile(HttpServletRequest request) throws  Exception{
        
        HttpSession session = request.getSession(true);
        Service service = Service.instance();
        
        Medico medicSession = (Medico) session.getAttribute("medico");
        //No está llegando el 'medico' de session
        String cedula = medicSession.getCedula();
        String nombre = request.getParameter("nameField");
        String localidad = request.getParameter("localidadCmb");
        String especialidad = request.getParameter("especialidadCmb");
        String estado = request.getParameter("estadoCmb");

              
        
        Medico medico = new Medico();
        Ciudad c = new Ciudad(localidad);
        Especialidad e = new Especialidad(especialidad);
        medico.setCiudad(c);
        medico.setEspecialidad(e);
        medico.setEstado(estado);
        medico.setCedula(medicSession.getCedula());
        
        System.out.println("-->" + medico.getCedula());
        System.out.println("-->" + medico.getCiudad().getProvincia());
        System.out.println("-->" + medico.getEspecialidad().getEspecialidad());
        System.out.println("-->" + medico.getEstado());
        
        service.editarMedico(medico);
        
        return "/presentation/medico/perfil/view.jsp";
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
