/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citas.data;

import citas.logic.Administrador;
import citas.logic.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ESCINF
 */
public class PacienteDao {
       Database db;

    public PacienteDao() {
        db= Database.instance();
    }
      
    
     public void create(Paciente u) throws Exception{
        String sql="insert into paciente (cedula, nombre, clave) "+
                "values(?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getNombre());
        stm.setString(3, u.getClave());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Paciente ya existe");
        }
    }
     
     public Paciente read(Paciente u) throws Exception{
        String sql = "select * from paciente c where cedula=? and clave =?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getClave());
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Paciente c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Paciente existente");
        }
    }
    
        Paciente from(ResultSet rs, String alias){
        try {
            Paciente c= new Paciente();
            c.setCedula(rs.getString(alias+".cedula"));
            c.setNombre(rs.getString(alias+".nombre"));
            c.setClave(rs.getString(alias+".clave"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }
       
    
}
