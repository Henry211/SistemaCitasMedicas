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
public class MedicoDao {

    Database db;

    public MedicoDao() {
        db = Database.instance();
    }

    public void create(Medico u) throws Exception {
        String sql = "insert into medico (nombre,idMedicos,clave,estado,nombre_provincia,nombre_especialidad) "
                + "values(?,?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getCedula());
        stm.setString(2, u.getNombre());
        stm.setString(3, u.getClave());
        stm.setString(4, u.getEstado());
        stm.setObject(5, u.getCiudad());
        stm.setObject(6, u.getEspecialidad());
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
        String sql = "update medico set estado=?,nombre_provincia=?,nombre_especialidad=?"
                + "where idMedicos=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, u.getEstado());
        stm.setObject(2, u.getCiudad().getProvincia());
        stm.setObject(3, u.getEspecialidad().getEspecialidad());
        stm.setString(4, u.getCedula());
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

    public ArrayList<Medico> findAll() {
        ArrayList<Medico> resultado = new ArrayList<>();
        try {
            String sql = "select * from medico c";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            Medico c;
            while (rs.next()) {
                c = from(rs, "c");
                resultado.add(c);
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    public ArrayList<Medico> busca(String ci, String es) throws Exception {
        ArrayList<Medico> resultado = new ArrayList<>();
        String sql = "select * from medico c "
                + "where nombre_provincia=? and nombre_especialidad=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, ci);
        stm.setString(2, es);
        System.out.println("SQL->" + sql);
        System.out.println("STM->" + stm);
        ResultSet rs = db.executeQuery(stm);
        Medico c;
        int i=0;
        while (rs.next()) {
            c = from(rs, "c");
            resultado.add(c);
        }
        return resultado;
    }

    /*
public String cambiarCostoConculta(String cedula, String cambioCostoConsulta) throws Exception{
String sql="UPDATE SET clave=? WHERE cedula=?";
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
            c.setEstado(rs.getString(alias + ".estado"));
            String str = rs.getString(alias + ".nombre_provincia");
            Ciudad ciuu = new Ciudad(str);
            c.setCiudad(ciuu);
            String str2 = rs.getString(alias + ".nombre_especialidad");
            Especialidad espe = new Especialidad(str2);
            c.setEspecialidad(espe);

// c.setFoto(rs.getString(alias+".foto"));
// c.setFoto((String) rs.getObject(alias+".foto"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }
}
