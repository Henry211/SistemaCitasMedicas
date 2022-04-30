/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package citas.presentation.medico.citas;

import citas.logic.Cita;
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

@WebServlet(name = "MedicoCitasController", urlPatterns = {"/presentation/medico/citas/show","/presentation/paciente/citas/show"})
public class Controller extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        
        
        request.setAttribute("model", new Model());
        String viewUrl = "";
        switch (request.getServletPath()) {
            case "/presentation/medico/citas/show":
                viewUrl = this.showMedico(request);
                break;
            case "/presentation/paciente/citas/show":
                viewUrl = this.showPaciente(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    public String showMedico(HttpServletRequest request) throws Exception {
        return this.showAction(request);
    }
    
    public String showAction(HttpServletRequest request) throws Exception {
        
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
 
//        ArrayList<Cita> citas = (ArrayList<Cita>) service.citaPaciente("123");
//
//        session.setAttribute("citasList", citas);
        
        try {     
            
            return "/presentation/medico/citas/view.jsp";
        } catch (Exception ex) {
            return "";
        }
    }
    
    public String showPaciente(HttpServletRequest request) throws Exception{
        
        Service service = Service.instance();
        HttpSession session = request.getSession(true);
 
        ArrayList<Cita> citas = (ArrayList<Cita>) service.readCitas("123");
        Paciente paciente = service.findPaciente("123");
        
            
        for(int i=0;i<=citas.size()-1;i++){
            citas.get(i).setPaciente(paciente);
            
        }
        
        
        System.out.println("citas->"+citas.get(0).getMedico().getCiudad().getProvincia() );
        System.out.println("citas->"+citas.get(0).getMedico().getEspecialidad().getEspecialidad());

        session.setAttribute("citasList", citas);
        
        return "/presentation/paciente/cita/view.jsp";
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
