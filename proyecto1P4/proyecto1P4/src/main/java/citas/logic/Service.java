package citas.logic;

import citas.data.AdministradorDao;
import citas.data.CitaDao;
import citas.data.CiudadDao;
import citas.data.EspecialidadDao;
import citas.data.HorarioDao;
import citas.data.MedicoDao;
import citas.data.PacienteDao;
import java.util.ArrayList;
import java.util.List;

public class Service {

    PacienteDao pDao = new PacienteDao();
    MedicoDao mDao = new MedicoDao();
    AdministradorDao aDao = new AdministradorDao();
    CiudadDao cidDao = new CiudadDao();
    CitaDao citDao = new CitaDao();
    EspecialidadDao esDao = new EspecialidadDao();
    HorarioDao horDao = new HorarioDao();
    
    public Service() {
    }

    // Singleton implementation
    private static Service theInstance;

    public static Service instance() {
        if (theInstance == null) {
            theInstance = new Service();
        }
        return theInstance;
    }

    // Service methods
    //paciente
    public Paciente pacienteLogin(Paciente paciente) throws Exception {
        return pDao.read(paciente);
    }

    public void createPaciente(Paciente paciente) throws Exception {
        pDao.create(paciente);
    }

    //administrador
    public Administrador administradorLogin(Administrador administrador) throws Exception {
        return aDao.read(administrador);
    }

    public void createAdministrador(Administrador admi) throws Exception {
        aDao.create(admi);
    }

    //medico
    public Medico medicoLogin(Medico medico) throws Exception {
        return mDao.read(medico);
    }

    public void editarMedico(Medico medico) throws Exception {
        mDao.update(medico);
    }

    public void createMedico(Medico medico) throws Exception {
        mDao.create(medico);
    }

    public Ciudad ciudadread(Ciudad ciudad) throws Exception {
        return cidDao.read(ciudad);
    }

    public ArrayList<Ciudad> findAllCyties() throws Exception {
        return cidDao.findAll();
    }

    public ArrayList<Especialidad> findAllSpetials() throws Exception {
        return esDao.findAll();
    }

    public ArrayList<Medico> findAllMedicos() throws Exception {
        return mDao.findAll();
    }

    public ArrayList<Medico> medicoBuscar(String ci, String es) throws Exception {
        return mDao.busca(ci,es);
    }

    public void createCiudad(Ciudad ciudad) throws Exception {
        cidDao.create(ciudad);
    }

    public void createEspecialidad(Especialidad especialidad) throws Exception {
        esDao.create(especialidad);
    }
    public void createHorario(Horario horario) throws Exception {
        horDao.create(horario);
    }
    public Horario findHorario(String idMEdico) throws Exception {
        return horDao.read(idMEdico);
    }
    
    public void updateHorario(Horario horario) throws Exception{
        horDao.update(horario);
    }
   
    public ArrayList<Cita> citaPaciente(String cedula) throws Exception{
        return citDao.citasPaciente(cedula);
    }
    public ArrayList<Cita> readCitas(String cedula) throws Exception{
        return citDao.read(cedula);
    }
    
    public void crearCita(Cita cita) throws Exception{
        citDao.create(cita);
    }
    
    
}
