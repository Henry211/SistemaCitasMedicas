/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package citas.presentation.medico.perfil;

import citas.logic.Ciudad;
import citas.logic.Especialidad;
import citas.logic.Horario;
import citas.logic.Medico;
import citas.logic.Paciente;
import citas.logic.Service;
import citas.logic.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
@WebServlet(name = "MedicoPerfilController", urlPatterns = {"/presentation/medico/perfil/show", "/presentation/medico/calendario/show", "/presentation/medico/calendario/next", "/presentation/medico/perfil/editar", "/presentation/medico/perfil/update"})
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
            case "/presentation/medico/calendario/next":
                viewUrl = this.nextCalendar(request);
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
        Service service = Service.instance();
        HttpSession session = request.getSession(true);

//        Paciente paciente = (Paciente) session.getAttribute("paciente");
        Medico me = (Medico) session.getAttribute("medico");
        System.out.println(me.getNombre());
        System.out.println(me.getClave());
        System.out.println(me.getCedula());

        
        //request.setAttribute("model", model);
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

        String lunes = "", martes = "", miercoles = "", jueves = "", viernes = "", sabado = "";

        LocalDate today = LocalDate.now();

        String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(new Date());
        System.out.println("DATEE==_-->" + day);

        switch (day) {
            case "Monday":
                lunes = "Lunes " + today.getDayOfMonth();
                martes = "Martes " + today.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                miercoles = "Miercoles " + today.plus(2, ChronoUnit.DAYS).getDayOfMonth();
                jueves = "Jueves " + today.plus(3, ChronoUnit.DAYS).getDayOfMonth();
                viernes = "Viernes " + today.plus(4, ChronoUnit.DAYS).getDayOfMonth();
                sabado = "Sabado " + today.plus(5, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Tuesday":
                lunes = "Lunes";
                martes = "Martes " + today.getDayOfMonth();
                miercoles = "Miercoles " + today.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                jueves = "Jueves " + today.plus(2, ChronoUnit.DAYS).getDayOfMonth();
                viernes = "Viernes " + today.plus(3, ChronoUnit.DAYS).getDayOfMonth();
                sabado = "Sabado " + today.plus(4, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Wednesday"://se podría poner en 'else final' para solicionar tilde
                lunes = "Lunes";
                martes = "Martes";
                miercoles = "Miercoles " + today.getDayOfMonth();
                jueves = "Jueves " + today.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                viernes = "Viernes " + today.plus(2, ChronoUnit.DAYS).getDayOfMonth();
                sabado = "Sabado " + today.plus(3, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Thursday":
                lunes = "Lunes";
                martes = "Martes";
                miercoles = "Miercoles";
                jueves = "Jueves " + today.getDayOfMonth();
                viernes = "Viernes " + today.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                sabado = "Sabado " + today.plus(2, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Friday":
                lunes = "Lunes";
                martes = "Martes";
                miercoles = "Miercoles";
                jueves = "Jueves";
                viernes = "Viernes " + today.getDayOfMonth();
                sabado = "Sabado " + today.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Saturday":
                lunes = "Lunes";
                martes = "Martes";
                miercoles = "Miercoles";
                jueves = "Jueves";
                viernes = "Viernes";
                sabado = "Sabado " + today.getDayOfMonth();
                break;

        }
        System.out.println("pasa por show ");
        lunes = "Lunes";
        martes = "Martes";
        miercoles = "Miercoles " + today.getDayOfMonth();
        jueves = "Jueves " + today.plus(1, ChronoUnit.DAYS).getDayOfMonth();
        viernes = "Viernes " + today.plus(2, ChronoUnit.DAYS).getDayOfMonth();
        sabado = "Sabado " + today.plus(3, ChronoUnit.DAYS).getDayOfMonth();
        
        session.setAttribute("lunes", lunes);
        session.setAttribute("martes", martes);
        session.setAttribute("miercoles", miercoles);
        session.setAttribute("jueves", jueves);
        session.setAttribute("viernes", viernes);
        session.setAttribute("sabado", sabado);

        try {

            return "/presentation/calendario/view.jsp";
        } catch (Exception ex) {
            return "";
        }
    }

    public String nextCalendar(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");
        Service service = Service.instance();
        HttpSession session = request.getSession(true);

        String lunes = "", martes = "", miercoles = "", jueves = "", viernes = "", sabado = "";
        Format f = new SimpleDateFormat("EEEE");
//        String day = f.format(new Date());
        String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(new Date());
        LocalDate date = (LocalDate) session.getAttribute("actualDate");
        date = date.plus(1, ChronoUnit.WEEKS);
        session.setAttribute("actualDate", date);
        LocalDate today = LocalDate.now();
        System.out.println("DATEE_-->" + day);

        switch (day) {
            case "Monday":
                lunes = "Lunes " + date.getDayOfMonth();
                martes = "Martes " + date.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                miercoles = "Miercoles " + date.plus(2, ChronoUnit.DAYS).getDayOfMonth();
                jueves = "Jueves " + date.plus(3, ChronoUnit.DAYS).getDayOfMonth();
                viernes = "Viernes " + date.plus(4, ChronoUnit.DAYS).getDayOfMonth();
                sabado = "Sabado " + date.plus(5, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Tuesday":
                lunes = "Lunes " + date.minus(1, ChronoUnit.DAYS).getDayOfMonth();
                martes = "Martes " + date.getDayOfMonth();
                miercoles = "Miercoles " + date.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                jueves = "Jueves " + date.plus(2, ChronoUnit.DAYS).getDayOfMonth();
                viernes = "Viernes " + date.plus(3, ChronoUnit.DAYS).getDayOfMonth();
                sabado = "Sabado " + date.plus(4, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Wednesday":
                lunes = "Lunes " + date.minus(2, ChronoUnit.DAYS).getDayOfMonth();
                martes = "Martes " + date.minus(1, ChronoUnit.DAYS).getDayOfMonth();
                miercoles = "Miercoles " + date.getDayOfMonth();
                jueves = "Jueves " + date.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                viernes = "Viernes " + date.plus(2, ChronoUnit.DAYS).getDayOfMonth();
                sabado = "Sabado " + date.plus(3, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Thursday":
                lunes = "Lunes " + date.minus(3, ChronoUnit.DAYS).getDayOfMonth();
                martes = "Martes " + date.minus(2, ChronoUnit.DAYS).getDayOfMonth();
                miercoles = "Miercoles " + date.minus(1, ChronoUnit.DAYS).getDayOfMonth();
                jueves = "Jueves " + date.getDayOfMonth();
                viernes = "Viernes " + date.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                sabado = "Sabado " + date.plus(2, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Friday":
                lunes = "Lunes " + date.minus(4, ChronoUnit.DAYS).getDayOfMonth();
                martes = "Martes " + date.minus(3, ChronoUnit.DAYS).getDayOfMonth();
                miercoles = "Miercoles " + date.minus(2, ChronoUnit.DAYS).getDayOfMonth();
                jueves = "Jueves " + date.minus(1, ChronoUnit.DAYS).getDayOfMonth();
                viernes = "Viernes " + date.getDayOfMonth();
                sabado = "Sabado " + date.plus(1, ChronoUnit.DAYS).getDayOfMonth();
                break;
            case "Saturday":
                lunes = "Lunes " + date.minus(5, ChronoUnit.DAYS).getDayOfMonth();
                martes = "Martes " + date.minus(4, ChronoUnit.DAYS).getDayOfMonth();
                miercoles = "Miercoles " + date.minus(3, ChronoUnit.DAYS).getDayOfMonth();
                jueves = "Jueves " + date.minus(2, ChronoUnit.DAYS).getDayOfMonth();
                viernes = "Viernes " + date.minus(1, ChronoUnit.DAYS).getDayOfMonth();
                sabado = "Sabado " + date.getDayOfMonth();
                break;
        }

        session.setAttribute("lunes", lunes);
        session.setAttribute("martes", martes);
        session.setAttribute("miercoles", miercoles);
        session.setAttribute("jueves", jueves);
        session.setAttribute("viernes", viernes);
        session.setAttribute("sabado", sabado);

        try {

            return "/presentation/calendario/view.jsp";
        } catch (Exception ex) {
            return "";
        }
    }

    public String checkDates(String str) {
        return "";
    }

    public String editProfile(HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession(true);
        Service service = Service.instance();

        ArrayList<Especialidad> especialidades = service.findAllSpetials();
        ArrayList<Ciudad> ciudades = service.findAllCyties();

        session.setAttribute("especialidadesCombo", especialidades);
        session.setAttribute("ciudadesCombo", ciudades);

        return "/presentation/medico/perfil/editView.jsp";
    }

    public String updateProfile(HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession(true);
        Service service = Service.instance();

        Medico medicSession = (Medico) session.getAttribute("medico");
        //No está llegando el 'medico' de session
        String cedula = medicSession.getCedula();
        String nombre = request.getParameter("nameField");
        String localidad = request.getParameter("localidadCmb");
        String especialidad = request.getParameter("especialidadCmb");
        String estado = request.getParameter("estadoCmb");
        String iniL = request.getParameter("iniL");
        String finL = request.getParameter("finL");
        String iniM = request.getParameter("iniM");
        String finM = request.getParameter("finM");
        String iniI = request.getParameter("iniI");
        String finI = request.getParameter("finI");
        String iniJ = request.getParameter("iniJ");
        String finJ = request.getParameter("finJ");
        String iniV = request.getParameter("iniV");
        String finV = request.getParameter("finV");
        String iniS = request.getParameter("iniS");
        String finS = request.getParameter("finS");

        Medico medico = new Medico();
        Ciudad c = new Ciudad(localidad);
        Especialidad e = new Especialidad(especialidad);
        Horario horario = new Horario();
        horario.setIniLunes(horaToInteger(iniL));
        horario.setFinLunes(horaToInteger(finL));
        horario.setIniMartes(horaToInteger(iniM));
        horario.setFinMartes(horaToInteger(finM));
        horario.setIniJueves(horaToInteger(iniI));
        horario.setFinJueves(horaToInteger(finI));
        horario.setIniViernes(horaToInteger(iniV));
        horario.setFinViernes(horaToInteger(finV));
        horario.setIniSabado(horaToInteger(iniS));
        horario.setFinSabado(horaToInteger(finS));
        horario.setFrecuencia(1);
        horario.calcDias();
        
        horario.setMedico(medico);      
        //medico.setHorario(horario);
        
        medico.setCiudad(c);
        medico.setEspecialidad(e);
        medico.setEstado(estado);
        medico.setCedula(medicSession.getCedula());

        //service.createHorario(horario);
        service.updateHorario(horario);
        service.editarMedico(medico);

        return "/presentation/medico/perfil/view.jsp";
    }
    
    public int horaToInteger(String str){
        
       
        switch(str){
            
            case "8am":
                return 8;      
            case "9am":
                return 9;          
            case "10am":
                return 10;     
            case "11am":
                return 11;           
            case "1pm":
                return 13;               
            case "2pm":
                return 14;               
            case "3pm":
                return 15;                
            case "4pm":
                return 16;
            case "5pm":
                return 17;
            case "6pm":
                return 18;   
        }
        return 0;
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
