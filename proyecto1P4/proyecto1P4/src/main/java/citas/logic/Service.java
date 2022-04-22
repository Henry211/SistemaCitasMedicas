
package citas.logic;

import citas.data.AdministradorDao;
import citas.data.CitaDao;
import citas.data.CiudadDao;
import citas.data.EspecialidadDao;
import citas.data.MedicoDao;
import citas.data.PacienteDao;


public class Service {
    
    PacienteDao pDao= new PacienteDao();
    MedicoDao mDao= new MedicoDao();
    AdministradorDao aDao= new AdministradorDao();
    CiudadDao cidDao= new CiudadDao();
    CitaDao citDao=new CitaDao();
    EspecialidadDao esDao= new EspecialidadDao();

    public Service() {
    }
    
     // Singleton implementation
    private static Service theInstance;
    public static Service instance(){
        if (theInstance==null){ 
            theInstance=new Service();
        }
        return theInstance;
    }
    
    // Service methods
    //paciente
    public Paciente pacienteLogin(Paciente paciente) throws Exception{
        return pDao.read(paciente); 
    }
    
    public void createPaciente(Paciente paciente) throws Exception{
         pDao.create(paciente); 
    }
    
    
    
    
    //administrador
     public Administrador administradorLogin(Administrador administrador) throws Exception{
        return aDao.read(administrador); 
    }
     
     //medico
      public Medico medicoLogin(Medico medico) throws Exception{
        return mDao.read(medico); 
    }
    
}
