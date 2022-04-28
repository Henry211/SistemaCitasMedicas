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
//        stm.setString(1, u.getIdmedico().getCedula());
//        stm.setInt(2, u.getDia());
        
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Horario ya existe");
        }
    }
     
     public Horarios read(Horarios u) throws Exception {
        String sql = "select * from horario c where idMedicos=? ";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getIdmedico().getCedula());
      
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Horarios c = from(rs, "c");
            return c;
        } else {
            throw new Exception("medico existente");
        }
    }
     
             
    Horarios from(ResultSet rs, String alias){
        try {
            Horarios c= new Horarios();
            c.setNumero(rs.getInt(alias+".numero"));
            c.setIdmedico((Medico) rs.getObject(alias+".id_doctor"));
            c.setDia(rs.getInt(alias+".day"));
            c.setHora_comienzo(rs.getInt(alias+".hora_comienzo"));
            c.setHora_finaliza(rs.getInt(alias+".hora_finaliza"));
            c.setFrecuencia(rs.getInt(alias+".frecuencia"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }  
     

}
