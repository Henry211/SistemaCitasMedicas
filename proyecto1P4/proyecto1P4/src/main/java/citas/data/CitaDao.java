package citas.data;

import citas.logic.Cita;
import citas.logic.Ciudad;
import citas.logic.Especialidad;
import citas.logic.Medico;
import citas.logic.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CitaDao {

    Database db;

    public CitaDao() {
        db = Database.instance();
    }

    public void create(Cita u) throws Exception {
        String sql = "insert into cita (estado,dia,hora,Paciente_cedula, Medico_idMedico) "
                + "values(?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getEstado());
        stm.setString(2, u.getDateStr());
        stm.setString(3, u.getHoraStr());
        stm.setObject(4, u.getPaciente().getCedula());
        stm.setObject(5, u.getMedico().getCedula());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cita no creada");
        }
    }

    public ArrayList<Cita> read(String cedula) throws Exception {
        ArrayList<Cita> resultado = new ArrayList<>();
        String sql = "select * from cita c inner join medico m on c.Medico_idMedico= m.idMedicos "
                    + " where c.Paciente_cedula=? order by m.nombre desc";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setObject(1, cedula);
        ResultSet rs = db.executeQuery(stm);
        Cita c;
        int i=0;
        while (rs.next()) {
                c = from2(rs, "c");
                resultado.add(c);
            }
        return resultado;
    }

    public void update(Cita u) throws Exception {
        String sql = "update cita set estado=?, dia=?, hora=? "
                + "where idCitas=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getEstado());
        stm.setString(2, u.getDateStr());
        stm.setString(3, u.getHoraStr());
        stm.setInt(4, u.getIdCita());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cita no existe");
        }
    }

    public void delete(Cita c) throws Exception {
        String sql = "delete from cita where idCitas=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, c.getIdCita());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cita no existe");
        }
    }

    public ArrayList<Cita> citasPaciente(String cedula) throws Exception {
        ArrayList<Cita> resultado = new ArrayList<>();
        try {
//            String sql = "select * from cita c  "
//                    + " where c.Paciente_cedula=? ";
            String sql = "select * from cita c inner join medico m on c.Medico_idMedico= m.idMedicos "
                    + " where c.Paciente_cedula=? ";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Cita c;
            stm.setString(1, cedula);
            while (rs.next()) {
                c = from(rs, "c");
                resultado.add(c);
            }
        } catch (SQLException ex) {
            throw new Exception("no hay citas");
        }
        return resultado;
    }

    public void actualizarEstado(Cita u) throws Exception {
        String sql = "update cita set estado=? where idCitas=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getEstado());
        stm.setInt(1, u.getIdCita());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cita no existe");
        }
    }

    public Long consultaEstado(String estado, int idCita) throws Exception {
        String sql = "select estado from cita c where idCitas=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, estado);
        stm.setInt(2, idCita);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            return rs.getLong("c.estado");
        } else {
            throw new Exception("Cita no Existe");
        }
    }

    public String cambiarFecha(int idCedula, String dia, String hora) throws Exception {
        String sql = "update cita set dia=?,hora=? where Paciente_cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, dia);
        stm.setString(2, hora);
        stm.setInt(3, idCedula);
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Cita no existe");
        }
        return "Fecha actualizada exitosamente";
    }

    public ArrayList<Cita> citasXpaciente(String especialidad, String provincia) {
        ArrayList<Cita> resultado = new ArrayList<>();
        try {
            String sql = "select *from cita c inner join medico m on c.Medico_idMedico= m.idMedicos "
                    + "inner join  paciente p on c.Paciente_cedula= p.cedula where m.nombre_especialidad=? "
                    + "and m.nombre_provincia=? ";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Cita c;
            stm.setString(1, especialidad);
            stm.setString(2, provincia);
            while (rs.next()) {
                c = from(rs, "c");
                resultado.add(c);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    Cita from(ResultSet rs, String alias) {
        try {
            Cita c = new Cita();
            c.setIdCita(rs.getInt(alias + ".idCitas"));
            c.setEstado(rs.getString(alias + ".estado"));
            c.setDateStr(rs.getString(alias + ".dia"));
            c.setHoraStr(rs.getString(alias + ".hora"));
            //-----------
            Paciente p = new Paciente();
            p.setCedula(rs.getString(alias + ".Paciente_cedula"));
            c.setPaciente(p);
            Medico m = new Medico();
            m.setCedula(rs.getString(alias + ".Medico_idMedico"));
            c.setMedico(m);
            //------------
//            c.getPaciente().setCedula(rs.getString(alias + ".Paciente_cedula"));
//            c.getMedico().setCedula(rs.getString(alias + ".Medico_idMedico"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
        
    }
    Cita from2(ResultSet rs, String alias) {
        try {
            Cita c = new Cita();
            c.setIdCita(rs.getInt(alias + ".idCitas"));
            c.setEstado(rs.getString(alias + ".estado"));
            c.setDateStr(rs.getString(alias + ".dia"));
            c.setHoraStr(rs.getString(alias + ".hora"));
            //-----------
            Paciente p = new Paciente();
            p.setCedula(rs.getString(alias + ".Paciente_cedula"));
            c.setPaciente(p);
            Medico m = new Medico();
            Ciudad ciuu = new Ciudad();
            ciuu.setProvincia(rs.getString("m.nombre_provincia"));
            Especialidad esp = new Especialidad();
            esp.setEspecialidad(rs.getString("m.nombre_especialidad"));
            m.setCedula(rs.getString(alias + ".Medico_idMedico"));
            m.setNombre(rs.getString("m.nombre"));
            m.setCiudad(ciuu);
            m.setEspecialidad(esp);
            c.setMedico(m);
            //------------
//            c.getPaciente().setCedula(rs.getString(alias + ".Paciente_cedula"));
//            c.getMedico().setCedula(rs.getString(alias + ".Medico_idMedico"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
        
    }
  
}
