/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citas.data;

import citas.logic.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ESCINF
 */
public class UsuarioDao{ 
    Database db;
    
   public UsuarioDao(){
        db= Database.instance();
    }

     public void create(Usuario u) throws Exception{
        String sql="insert into Usuario (cedula, nombre, clave, tipo) "+
                "values(?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getNombre());
        stm.setString(3, u.getClave());
        stm.setInt(4, u.getTipo());
      
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Usuario ya existe");
        }
    }
    
    public Usuario read(Usuario u) throws Exception{
        String sql = "select * from cedula c where cedula=? and nombre =?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getNombre());
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Usuario c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Usuario existente");
        }
    }
    
    public void update(Usuario u) throws Exception{
        String sql="update cedula set nombre=?, set clave=?,set tipo "+
                "where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getNombre());
        stm.setString(3, u.getClave());   
        stm.setInt(4, u.getTipo()); 
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Usuario no existe");
        }        
    }

    public void delete(Usuario c) throws Exception{
        String sql="delete from cedula where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getCedula());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Usuario no existe");
        }
    }
        
    public String cambiarClave(String cedula, String cambioClave) throws Exception{
        String sql="UPDATE cedula SET clave=? WHERE cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cambioClave);
        stm.setString(2, cedula);
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Usuario no existe");
        }
        return "Clave actualizada exitosamente";
    }
        
        
    Usuario from(ResultSet rs, String alias){
        try {
            Usuario c= new Usuario();
            c.setCedula(rs.getString(alias+".cedula"));
            c.setNombre(rs.getString(alias+".nombre"));
            c.setClave(rs.getString(alias+".clave"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }   
}
