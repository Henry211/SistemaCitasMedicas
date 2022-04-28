/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package citas.presentation.paciente.cita;

import citas.logic.Cita;
import citas.logic.Horario;
import citas.logic.Medico;
import citas.logic.Paciente;
import citas.logic.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
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
@WebServlet(name = "PacienteCitaController", urlPatterns = {"/presentation/paciente/cita/make","/presentation/paciente/cita/confirm", "/presentation/paciente/cita/selectDate"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
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
            case "/presentation/paciente/cita/confirm":
               viewUrl = this.confirm(request);
                break;
        }
        request.getRequestDispatcher(viewUrl).forward(request, response);
    }
    
    public String confirm(HttpServletRequest request) throws Exception{
    
        HttpSession session = request.getSession(true);        
        Service service = Service.instance();
        
        String idMedico = (String) session.getAttribute("idMed");
        String dateTime = (String) session.getAttribute("dateTime");
        Cita cita = (Cita) session.getAttribute("citaConfirm");
        
        service.crearCita(cita);
        
        
        return "/presentation/paciente/citas/show";
    }
    
    
    public String makeCita(HttpServletRequest request) throws Exception{
        
        HttpSession session = request.getSession(true);
        Service service = Service.instance();

        Paciente paciente = (Paciente) session.getAttribute("paciente");
        String idMedico = (String) request.getParameter("mid");
        Medico medico = service.findMedico(idMedico);
        
        Cita cita = new Cita("Activo",(String)request.getParameter("day"),(String)request.getParameter("hora"),paciente,medico);
    
      
        session.setAttribute("idMed", request.getParameter("mid"));
        session.setAttribute("dateTime", request.getParameter("day"));
        session.setAttribute("citaConfirm", cita);
        
        return "/presentation/paciente/cita/confirmView.jsp";
    }
    
    public String selectDate(HttpServletRequest request) throws Exception{
        
        HttpSession session = request.getSession(true);
        Service service = Service.instance();
        
        String id = request.getParameter("mid");// <--- Id del Médico        
        Horario horario = service.findHorario(id);//---- horario de Medico
        horario.calcDias();
        
        ArrayList<String> citasOcupadas = new ArrayList<String>();
        Medico medico = service.findMedico(id);
        citasOcupadas = service.verifyCitasOcupadas(id);
        System.out.println("citasOcupadas size: "+citasOcupadas.size());
        System.out.println("citasOcupadas 0 elements: "+citasOcupadas.get(0));
        session.setAttribute("medicoSelected", medico);
        session.setAttribute("horarioCita", horario);
        session.setAttribute("citasOcupadas",citasOcupadas);
        
        
        
        String lunes="",martes="",miercoles="",jueves="",viernes="",sabado = "";
 
        LocalDate today = LocalDate.now();
        session.setAttribute("actualDate", today);
        
        String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(new Date());
        
        switch(day){
            case "Monday":
                lunes = "Lunes " + today.getDayOfMonth();
                martes = "Martes "+ today.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                miercoles = "Miercoles "+ today.plus(2, ChronoUnit.DAYS).getDayOfMonth();
                jueves = "Jueves "+ today.plus(3, ChronoUnit.DAYS).getDayOfMonth();
                viernes = "Viernes "+ today.plus(4, ChronoUnit.DAYS).getDayOfMonth();
                sabado = "Sabado "+ today.plus(5, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Tuesday":
                lunes = "Lunes";
                martes = "Martes "+ today.getDayOfMonth();
                miercoles = "Miercoles "+ today.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                jueves = "Jueves "+ today.plus(2, ChronoUnit.DAYS).getDayOfMonth();
                viernes = "Viernes "+ today.plus(3, ChronoUnit.DAYS).getDayOfMonth();
                sabado = "Sabado "+ today.plus(4, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Wednesday":
                lunes = "Lunes";
                martes = "Martes";
                miercoles = "Miercoles "+ today.getDayOfMonth();
                jueves = "Jueves "+ today.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                viernes = "Viernes "+ today.plus(2, ChronoUnit.DAYS).getDayOfMonth();
                sabado = "Sabado "+ today.plus(3, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Thursday":
                lunes = "Lunes";
                martes = "Martes";
                miercoles = "Miercoles";
                jueves = "Jueves "+ today.getDayOfMonth();
                viernes = "Viernes "+ today.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                sabado = "Sabado "+ today.plus(2, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Friday":
                lunes = "Lunes";
                martes = "Martes";
                miercoles = "Miercoles";
                jueves = "Jueves";
                viernes = "Viernes "+ today.getDayOfMonth();
                sabado = "Sabado "+ today.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Saturday":
                lunes = "Lunes";
                martes = "Martes";
                miercoles = "Miercoles";
                jueves = "Jueves";
                viernes = "Viernes";
                sabado = "Sabado "+ today.getDayOfMonth();
                break;
        }
        
        session.setAttribute("lunes", lunes);
        session.setAttribute("martes", martes);
        session.setAttribute("miercoles", miercoles);
        session.setAttribute("jueves", jueves);
        session.setAttribute("viernes", viernes);
        session.setAttribute("sabado", sabado);
        
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
