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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import citas.logic.Administrador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorDao {
    Database db;
    
    public AdministradorDao(){
        db= Database.instance();
    }

     public void create(Administrador u) throws Exception{
        String sql="insert into administrador (cedula, nombre, clave) "+
                "values(?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getNombre());
        stm.setString(3, u.getClave());
      
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Administrador ya existe");
        }
    }
    
    public Administrador read(Administrador u) throws Exception{
        String sql = "select * from administrador c where idAdministrador=? and clave =?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getClave());
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Administrador c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Administrador existente");
        }
    }
    
    public void update(Administrador u) throws Exception{
        String sql="update administrador set nombre=?, clave=? "+
                "where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getNombre());
        stm.setString(3, u.getClave());       
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Administrador no existe");
        }        
    }

    public void delete(Administrador c) throws Exception{
        String sql="delete from administrador where idAdministrador=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getCedula());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Administrador no existe");
        }
    }
        
    public String cambiarClave(String cedula, String cambioClave) throws Exception{
        String sql="UPDATE administrador SET clave=? WHERE idAdministrador=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cambioClave);
        stm.setString(2, cedula);
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Administrador no existe");
        }
        return "Clave actualizada exitosamente";
    }
        
        
    Administrador from(ResultSet rs, String alias){
        try {
            Administrador c= new Administrador();
            c.setCedula(rs.getString(alias+".idAdministrador"));
            c.setNombre(rs.getString(alias+".nombre"));
            c.setClave(rs.getString(alias+".clave"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }  
        
        
    /* Dao para lista
    public List<Usuario> findAll(){
        List<Usuario> resultado=new ArrayList<>();
        try {
            String sql="select * from Usuario c";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs =  db.executeQuery(stm);
            Usuario c;
            while (rs.next()) {
                c = from(rs, "c"); 
                resultado.add(c);
            }
        } catch (SQLException ex) { }
        return resultado;        
    }

    public List<Usuario> findByCedula(String cedula){
        List<Usuario> resultado = new ArrayList<>();
        try {
            String sql="select * from Usuario c "+
                    "where c.usuario like ?";            
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, cedula+"%");
            ResultSet rs =  db.executeQuery(stm); 
            Usuario c;
            while (rs.next()) {
                c = from(rs, "c"); 
                resultado.add(c);
            }
        } catch (SQLException ex) {  }
        return resultado;
    }
    */
}
