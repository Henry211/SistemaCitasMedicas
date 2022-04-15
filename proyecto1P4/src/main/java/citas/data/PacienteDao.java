/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citas.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import citas.logic.Paciente;

/**
 *
 * @author alfon
 */
public class PacienteDao {
        Database db;
    
    public PacienteDao(){
        db= Database.instance();
    }

    public void create(Paciente u) throws Exception{
        String sql="insert into Paciente (cedula, nombre, clave) "+
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
    
    public Paciente read(Paciente paciente) throws Exception{
        String sql = "select * from paciente c where paciente=? and nombre =? and clave =?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, paciente.getCedula());
        stm.setString(2, paciente.getNombre());
        stm.setString(3, paciente.getClave());
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Paciente c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Paciente no Existe");
        }
    }
    
    public void update(Paciente u) throws Exception{
        String sql="update paciente set clave=?, saldo=? "+
                "where paciente=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getNombre());
        stm.setString(3, u.getClave());       
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Paciente no existe");
        }        
    }

    public void delete(Paciente c) throws Exception{
        String sql="delete from paciente where paciente=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getNombre());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Paciente no existe");
        }
    }
    
    public String cambiarClave(String usuario, String cambioClave) throws Exception{
        String sql="UPDATE usuario SET clave=? WHERE usuario=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cambioClave);
        stm.setString(2, usuario);
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Usuario no existe");
        }
        return "Clave actualizada exitosamente";
    }
    
    public Paciente from(ResultSet rs, String alias){
        try {
            Paciente c = new Paciente();
            c.setCedula(rs.getString(alias+".cedula"));
            c.setNombre(rs.getString(alias+".nombre"));
            c.setClave(rs.getString(alias+".clave"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }   
    
}
