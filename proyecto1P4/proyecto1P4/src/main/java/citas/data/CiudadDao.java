/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citas.data;

import citas.logic.Ciudad;
import citas.logic.Especialidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ESCINF
 */
public class CiudadDao {
    Database db;

    public CiudadDao() {
        db= Database.instance();
    }
    
        public void create(Ciudad u) throws Exception{
        String sql="insert into localidad (provincia) "+
                "values(?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getProvincia());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Localidad ya existe");
        }
    }
        
        public Ciudad read(Ciudad u) throws Exception{
        String sql = "select * from localidad c where idLocalidad=? and provincia =?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, u.getIdProvincia());  
        stm.setString(1, u.getProvincia());
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Ciudad c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Ciudad existente");
        }
        
    }
        
         public void update(Ciudad u) throws Exception{
        String sql=" update localidad set provincia=?,canton=?"+
                "where idLocalidad=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, u.getIdProvincia());
        stm.setString(2, u.getProvincia());    
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Ciudad no existe");
        }        
    }
        public void delete(Ciudad c) throws Exception{
        String sql="delete from localidad where idLocalidad=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, c.getIdProvincia());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Ciudad no existe");
        }
    }

 
    
    
    // Dao para lista
    
      public List<Ciudad> findAll(){
        List<Ciudad> resultado=new ArrayList<>();
        try {
            String sql="select * from Usuario c";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs =  db.executeQuery(stm);
            Ciudad c;
            while (rs.next()) {
                c = from(rs, "c"); 
                resultado.add(c);
            }
        } catch (SQLException ex) { }
        return resultado;        
    }
/*
    public List<Ciudad> findByCedula(String cedula){
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
          
    Ciudad from(ResultSet rs, String alias){
        try {
            Ciudad c= new Ciudad();
            c.setIdProvincia(rs.getInt(alias+".idLocalidad"));
            c.setProvincia(rs.getString(alias+".provincia"));
            
            return c;
        } catch (SQLException ex) {
            return null;
        }
    } 
}
