/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citas.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ESCINF
 */
public class Medico {
    
    int id;
    String nombre;
    String cedula;
    String clave;
    Boolean estado;
    float costoConsulta;
    Localidad localidad;
    
        
    public Medico(int id, String nombre, String cedula, String clave,boolean estado,float costoConsulta) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.cedula = cedula;
        this.clave = clave;
        this.estado = estado;
        this.costoConsulta = costoConsulta;
        //this.cuentas = new ArrayList();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void setCostoConsulta(float costoConsulta) {
        this.costoConsulta = costoConsulta;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getClave() {
        return clave;
    }

    public Boolean getEstado() {
        return estado;
    }

    public float getCostoConsulta() {
        return costoConsulta;
    }

    public Localidad getLocalidad() {
        return localidad;
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
        return true;
    }

     
}
