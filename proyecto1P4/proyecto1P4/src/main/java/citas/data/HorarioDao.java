/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citas.data;

import citas.logic.Cita;
import citas.logic.Ciudad;
import citas.logic.Especialidad;
import citas.logic.Horario;
import citas.logic.Horarios;
import citas.logic.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 *
 * @author ESCINF
 */
public class HorarioDao {
    Database db;

    public HorarioDao(Database db) {
        this.db = db;
    }
    
     public void create(Horario u) throws Exception {

        String sql = "insert into horario(id_doctor,comienzo_lunes,finaliza_lunes,comienzo_martes,finaliza_martes,comienzo_miercoles,finaliza_miercoles,comienzo_jueves,finaliza_jueves,comienzo_viernes,finaliza_viernes,comienzo_sabado,finaliza_sabado,frecuencia) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getMedico().getCedula());
        stm.setInt(2, u.getIniLunes());
        stm.setInt(3, u.getFinLunes());
        stm.setInt(4, u.getIniMartes());
        stm.setInt(5, u.getFinMartes());
        stm.setInt(6, u.getIniMiercoles());
        stm.setInt(7, u.getFinMiercoles());
        stm.setInt(8, u.getIniJueves());
        stm.setInt(9, u.getFinJueves());
        stm.setInt(10, u.getIniViernes());
        stm.setInt(11, u.getFinViernes());
        stm.setInt(12, u.getIniSabado());
        stm.setInt(13, u.getFinSabado());
        stm.setInt(14, u.getFrecuencia());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Horario ya existe");
        }
    }
     
     public Horario read(Horarios u) throws Exception {
        String sql = "select * from horario c where idMedicos=? ";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getIdmedico().getCedula());
      
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Horario c = from(rs, "c");
            return c;
        } else {
            throw new Exception("medico existente");
        }
    }
     
             
    Horario from(ResultSet rs, String alias){
        try {
            Horario c= new Horario();
            c.setMedico((Medico) rs.getObject(alias+".id_doctor"));
            c.setIniLunes(rs.getInt(alias+".comienzo_lunes"));
            c.setFinLunes(rs.getInt(alias+".finaliza_lunes"));
            c.setIniMartes(rs.getInt(alias+".comienzo_martes"));
            c.setFinMartes(rs.getInt(alias+".finaliza_martes"));
            c.setIniMiercoles(rs.getInt(alias+".comienzo_miercoles"));
            c.setFinMiercoles(rs.getInt(alias+".finaliza_miercoles"));
            c.setIniJueves(rs.getInt(alias+".comienzo_jueves"));
            c.setFinJueves(rs.getInt(alias+".finaliza_jueves"));
            c.setIniViernes(rs.getInt(alias+".comienzo_viernes"));
            c.setFinViernes(rs.getInt(alias+".finaliza_viernes"));
            c.setIniViernes(rs.getInt(alias+".comienzo_sabado"));
            c.setFinViernes(rs.getInt(alias+".finaliza_sabado"));
            c.setFrecuencia(rs.getInt(alias+".frecuencia"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }  
     

}
