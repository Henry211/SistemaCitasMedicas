/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citas.data;

import citas.logic.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ESCINF
 */
public class MedicoDao {

    Database db;

    public MedicoDao() {
        db = Database.instance();
    }

    public void create(Medico u) throws Exception {
        String sql = "insert into medico (nombre,idMedicos,clave,estado,localidad_idLocalidad,id_especialidad) "
                + "values(?,?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getNombre());
        stm.setString(3, u.getClave());
        stm.setString(4, u.getEstado());
        stm.setObject(5, u.getEspecialidad());
        stm.setObject(6, u.getCiudad());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Medico ya existe");
        }
    }

    public Medico read(Medico u) throws Exception {
        String sql = "select * from medico c where idMedicos=? and clave =?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getClave());
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Medico c = from(rs, "c");
            return c;
        } else {
            throw new Exception("medico existente");
        }
    }

    

    public void update(Medico u) throws Exception {
        String sql = "update medico set estado=?,localidad_idLocalidad=?,id_especialidad=?"
                + "where idMedicos=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getEstado());
        stm.setObject(2, u.getCiudad());
        stm.setObject(3, u.getEspecialidad());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Medico no existe");
        }
    }
    

    public void delete(Medico c) throws Exception {
        String sql = "delete from medico where idMedicos=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getCedula());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Medico no existe");
        }
    }

    public String cambiarClave(String cedula, String cambioClave) throws Exception {
        String sql = "UPDATE medico SET clave=? WHERE idMedicos=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cambioClave);
        stm.setString(2, cedula);
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Medico no existe");
        }
        return "Clave actualizada exitosamente";
    }

    /*
    public String cambiarCostoConculta(String cedula, String cambioCostoConsulta) throws Exception{
        String sql="UPDATE  SET clave=? WHERE cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, cambioCostoConsulta);
        stm.setString(2, cedula);
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Medico no existe");
        }
        return "Costo de la consulta actualizada exitosamente";
    }
     */
    Medico from(ResultSet rs, String alias) {
        try {
            Medico c = new Medico();
            c.setCedula(rs.getString(alias + ".idMedicos"));
            c.setNombre(rs.getString(alias + ".nombre"));
            c.setClave(rs.getString(alias + ".clave"));
//            c.setEstado(rs.getString(alias+".estado"));
//            c.setFoto(rs.getString(alias+".foto"));
//            c.setFoto((String) rs.getObject(alias+".foto"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }
}
