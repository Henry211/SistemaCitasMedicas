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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author ESCINF
 */
@WebServlet(name = "MedicoPerfilController", 
        urlPatterns = {"/presentation/medico/perfil/show", ""
                + "/presentation/medico/calendario/show", 
            "/presentation/medico/calendario/next", 
            "/presentation/medico/perfil/editar", 
            "/presentation/medico/perfil/update"})
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 10, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 10   // 100 MB
)
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

    public String show(HttpServletRequest request) throws Exception {
        return this.showAction(request);
    }

    public String showAction(HttpServletRequest request) throws Exception {

        Service service = Service.instance();
        HttpSession session = request.getSession(true);

        Medico me = (Medico) session.getAttribute("medico");
       
        Horario horario = service.findHorario(me.getCedula());
        if(horario == null){
            Horario auxHor = new Horario(0,0,0,0,0,0,0,0,0,0,0,0,0);
            auxHor.setMedico(me);
            auxHor.calcDias();
            service.createHorario(auxHor);
            horario = service.findHorario(me.getCedula());
            session.setAttribute("horario", horario);
        }else{
            horario.calcDias();
            //horaToInteger  - de alguna forma
            session.setAttribute("horario", horario);
        }
        

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
            case "Wednesday"://se podr??a poner en 'else final' para solicionar tilde
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
        //No est?? llegando el 'medico' de session
        String cedula = medicSession.getCedula();
        String nombre = request.getParameter("nameField");
        String localidad = request.getParameter("localidadCmb");
        String especialidad = request.getParameter("especialidadCmb");
       
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
        String checkL = request.getParameter("checkL");
        String checkM = request.getParameter("checkM");
        String checkI = request.getParameter("checkI");
        String checkJ = request.getParameter("checkJ");
        String checkV = request.getParameter("checkV");
        String checkS = request.getParameter("checkS");
        int cmbFrecuencia = Integer.valueOf(request.getParameter("duracionCmb"));
        System.out.println("Frecuencia->"+cmbFrecuencia);
        

        Medico medico = (Medico) session.getAttribute("medico");
        Ciudad c = new Ciudad(localidad);
        if(!especialidad.equals("Seleccione la Especialidad")){
            Especialidad e = new Especialidad(especialidad);
            medico.setEspecialidad(e);
        }
        Horario horario = new Horario();
        if(checkL != null){
            horario.setIniLunes(horaToInteger(iniL));
            horario.setFinLunes(horaToInteger(finL));
        }else{
            horario.setIniLunes(0);
            horario.setFinLunes(0);
        }
        if(checkM != null){
            horario.setIniMartes(horaToInteger(iniM));
            horario.setFinMartes(horaToInteger(finM));
        }else{
            horario.setIniMartes(0);
            horario.setFinMartes(0);
        }
        if(checkI != null){
            horario.setIniMiercoles(horaToInteger(iniI));
            horario.setFinMiercoles(horaToInteger(finI));
        }else{
            horario.setIniMiercoles(0);
            horario.setFinMiercoles(0);
        }
        if(checkJ != null){
            horario.setIniJueves(horaToInteger(iniJ));
            horario.setFinJueves(horaToInteger(finJ));
        }else{
            horario.setIniJueves(0);
            horario.setFinJueves(0);
        }
        if(checkV != null){
            horario.setIniViernes(horaToInteger(iniV));
            horario.setFinViernes(horaToInteger(finV));
        }else{
            horario.setIniViernes(0);
            horario.setFinViernes(0);
        }
        if(checkS != null){
            horario.setIniSabado(horaToInteger(iniS));
            horario.setFinSabado(horaToInteger(finS));
        }else{
            horario.setIniSabado(0);
            horario.setFinSabado(0);
        }
        
        
        horario.setFrecuencia(cmbFrecuencia);
        horario.calcDias();
        
        horario.setMedico(medico);      
        //medico.setHorario(horario);
        
        medico.setCiudad(c);
        medico.setCedula(medicSession.getCedula());
        
        //String file = request.getParameter("file");
        
         /* Receive file uploaded to the Servlet from the HTML5 form */
        Part filePart = request.getPart("file");
        InputStream fileInput = filePart.getInputStream();
        
        //File file = new File(fileName);
        byte[] bytes = new byte[(int) filePart.getSize() ];
        fileInput.read(bytes);

        medico.setImage(bytes);
            

        //service.createHorario(horario);
        service.updateHorario(horario);
        service.editarMedico(medico);
        session.setAttribute("medico", medico);

        return "/presentation/medico/perfil/show";
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
            ex.printStackTrace();
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
