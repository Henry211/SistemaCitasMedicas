/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citas.logic;

import java.util.Objects;

/**
 *
 * @author ESCINF
 */
public class Medico {
  
    String nombre;
    String cedula;
    String clave;
    String costoConsulta;
    Ciudad ciudad;

    public Medico() {
    }

    public Medico(String nombre, String cedula, String clave, String costoConsulta, Ciudad ciudad) {
       
        this.nombre = nombre;
        this.cedula = cedula;
        this.clave = clave;
        this.costoConsulta = costoConsulta;
        this.ciudad = ciudad;
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

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCostoConsulta() {
        return costoConsulta;
    }

    public void setCostoConsulta(String costoConsulta) {
        this.costoConsulta = costoConsulta;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.cedula);
        hash = 53 * hash + Objects.hashCode(this.clave);
        hash = 53 * hash + Objects.hashCode(this.costoConsulta);
        hash = 53 * hash + Objects.hashCode(this.ciudad);
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
       
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        if (!Objects.equals(this.costoConsulta, other.costoConsulta)) {
            return false;
        }
        return Objects.equals(this.ciudad, other.ciudad);
    }
    
    
    
}
