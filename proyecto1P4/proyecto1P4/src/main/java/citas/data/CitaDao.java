/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citas.data;
import citas.logic.Cita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class CitaDao {
    Database db;
    
    public CitaDao(){
        db= Database.instance();
    }

    public void create(Cita u) throws Exception{
        String sql="insert into Cita (idCita, estado, fecha) "+
                "values(?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, u.getIdCita());
        stm.setString(2, u.getEstado());
        stm.setObject(3, u.getFecha());
      
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cita ya existe");
        }
    }
    
    public Cita read(Cita u) throws Exception{
        String sql = "select * from idCita c where idCita=? and estado =?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, u.getIdCita());
        stm.setString(2, u.getEstado());
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Cita c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Cita existente");
        }
    }
    
    public void update(Cita u) throws Exception{
        String sql="update idCita set estado=?, set fecha=? "+
                "where idCita=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, u.getIdCita());
        stm.setString(2, u.getEstado());
        stm.setObject(3, u.getFecha());       
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cita no existe");
        }        
    }

    public void delete(Cita c) throws Exception{
        String sql="delete from idCita where idCita=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, c.getIdCita());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cita no existe");
        }
    }
    public void actualizarEstado(int idCita, String estado) throws Exception{
        String sql="UPDATE idCita SET estado=? where idCita=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, estado);    
        stm.setInt(2, idCita);
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cita no existe");
        }        
    }
    
    public Long consultaEstado(int idCita) throws Exception{
        String sql="select saldo from idCita c where idCita=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, idCita);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            return rs.getLong("c.estado");
        }
        else{
            throw new Exception ("Cita no Existe");
        }
    }
    
    public String cambiarEstado(int idCedula, String cambioEstado) throws Exception{
        String sql="UPDATE idCedula SET estado=? WHERE idCedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cambioEstado);
        stm.setInt(2, idCedula);
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cita no existe");
        }
        return "Estado actualizado exitosamente";
    }
        
    public String cambiarFecha(int idCedula, String cambioFecha) throws Exception{
        String sql="UPDATE idCedula SET fecha=? WHERE idCedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cambioFecha);
        stm.setInt(2, idCedula);
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cita no existe");
        }
        return "Fecha actualizada exitosamente";
    }
        
        
    Cita from(ResultSet rs, String alias){
        try {
            Cita c= new Cita();
            c.setIdCita(rs.getInt(alias+".IdCita"));
            c.setEstado(rs.getString(alias+".estado"));
            c.setFecha((LocalDateTime) rs.getObject(alias+".fecha"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }   
}
