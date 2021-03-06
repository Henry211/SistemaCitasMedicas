package citas.data;

import citas.logic.Ciudad;
import citas.logic.Especialidad;
import citas.logic.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ESCINF
 */
public class EspecialidadDao {

    Database db;

    public EspecialidadDao() {
        db = Database.instance();
    }

    public void create(Especialidad u) throws Exception {
        String sql = "insert into especialidad (especialidad) " + "values(?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getEspecialidad());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Especialidad ya existe");
        }
    }

    public Especialidad read(Especialidad u) throws Exception {
        String sql = "select * from especialidad c where especialidad=? ";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getEspecialidad());
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            Especialidad c = from(rs, "c");
            return c;
        } else {
            throw new Exception("Especialidad existente");
        }
    }

    public void update(Especialidad u) throws Exception {
        String sql = "update especialidad set especialidad=?" + "where especialidad=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getEspecialidad());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Especialidad no existe");
        }
    }

    /*public void delete(Especialidad c) throws Exception{
String sql="delete from especialidad where idEspecialidad=?";
PreparedStatement stm = db.prepareStatement(sql);
stm.setInt(1, c.getId());
int count=db.executeUpdate(stm);
if (count==0){
throw new Exception("Especialidad no existe");
}
}*/
    public ArrayList<Especialidad> findAll() {
        ArrayList<Especialidad> resultado = new ArrayList<>();
        try {
            String sql = "select * from especialidad c";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Especialidad c;
            while (rs.next()) {
                c = from(rs, "c");
                resultado.add(c);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    Especialidad from(ResultSet rs, String alias) {
        try {
            Especialidad c = new Especialidad();
            c.setEspecialidad(rs.getString(alias + ".especialidad"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }
}
