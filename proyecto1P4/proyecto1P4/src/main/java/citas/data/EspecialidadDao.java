/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citas.data;

import citas.logic.Especialidad;
import citas.logic.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ESCINF
 */
public class EspecialidadDao {
    Database db;
    
    public EspecialidadDao(){
        db= Database.instance();
    }

    public void create(Especialidad u) throws Exception{
        String sql="insert into Especialidad (idEspecialidad,nombre,Medico_idMedico) "+
                "values(?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, u.getId());
        stm.setString(2, u.getNombre());
        stm.setObject(3, u.getMedico());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Especialidad ya existe");
        }
    }
    
    public Especialidad read(Especialidad u) throws Exception{
        String sql = "select * from especialidad c where id=? ";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, u.getId());
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Especialidad c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Especialidad existente");
        }
    }
    
    public void update(Especialidad u) throws Exception{
        String sql="update especialidad set nombre=?, Medico_idMedico=?"+
                "where idEspecialidad=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, u.getId());
        stm.setString(2, u.getNombre());      
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Especialidad no existe");
        }        
    }

    public void delete(Especialidad c) throws Exception{
        String sql="delete from especialidad where idEspecialidad=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, c.getId());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Especialidad no existe");
        }
    }
        
        
    Especialidad from(ResultSet rs, String alias){
        try {
            Especialidad c= new Especialidad();
            c.setId(rs.getInt(alias+".idEspecialidad"));
            c.setNombre(rs.getString(alias+".nombre"));
            c.setMedico((Medico) rs.getObject(alias+".nombre"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }    
}
