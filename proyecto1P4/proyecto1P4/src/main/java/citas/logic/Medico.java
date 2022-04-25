package citas.logic;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ESCINF
 */
public class Medico implements Serializable {

    String cedula;
    String nombre;
    String clave;
    String estado;
    Ciudad nombre_ciudad;
    Especialidad nombre_especialidad;
    String foto;

    public Medico() {
    }

    public Medico(String cedula, String nombre, String clave) {

        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
    }

    public Medico(String cedula, String nombre, String clave, String estado, String nombre_ciudad, String nombre_especialidad) {

        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
        this.estado = estado;
        this.nombre_ciudad = new Ciudad(nombre_ciudad);
        this.nombre_especialidad = new Especialidad(nombre_especialidad);
        
    }

 

 
    
    

    public Medico(String cedula, String clave) {
        this.cedula = cedula;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getClave() {
        return clave;
    }

    public Especialidad getEspecialidad() {
        return nombre_especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.nombre_especialidad = especialidad;
    }

    public Ciudad getCiudad() {
        return nombre_ciudad;
    }

    public void setCiudad(Ciudad nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.cedula);
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + Objects.hashCode(this.clave);
        hash = 71 * hash + Objects.hashCode(this.estado);
        hash = 71 * hash + Objects.hashCode(this.foto);
        hash = 71 * hash + Objects.hashCode(this.nombre_ciudad);
        hash = 71 * hash + Objects.hashCode(this.nombre_especialidad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        return Objects.equals(this.nombre_ciudad, other.nombre_ciudad);
    }

}
