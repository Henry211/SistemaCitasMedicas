/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package citas.presentation.paciente.cita;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
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
@WebServlet(name = "PacienteCitaController", urlPatterns = {"/presentation/paciente/cita/make", "/presentation/paciente/cita/selectDate"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.setAttribute("model", new Model());
        
        String viewUrl="";
        switch(request.getServletPath()){
            case "/presentation/paciente/cita/make":
                viewUrl = this.makeCita(request);
                break;
            case "/presentation/paciente/cita/selectDate":
               viewUrl = this.selectDate(request);
                break;
            case " ":
               //viewUrl = this.logout(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    public String makeCita(HttpServletRequest request){
        
        Model model = (Model) request.getAttribute("model");
        
        //--Esto debe hacerse diferente
        //-- se setean las entidades trayendolas desde BD
        model.getCita().getMedico().setNombre(request.getAttribute("mid").toString());
        //model.getCita().setFecha(request.getAttribute("dt"));
               
        HttpSession session = request.getSession(true);
        session.setAttribute("idMed", request.getAttribute("mid"));
        session.setAttribute("dateTime", request.getAttribute("dt"));
        
        return "/presentation/paciente/cita/confirmView.jsp";
    }
    
    public String selectDate(HttpServletRequest request){
        
        return "/presentation/calendario/view.jsp";
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
