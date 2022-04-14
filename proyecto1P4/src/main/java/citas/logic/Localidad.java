/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citas.logic;

/**
 *
 * @author ESCINF
 */
public class Localidad {
    int localidad;
    String provincia;
    String distrito;
    String canton;
    
    public int getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public String getCanton() {
        return canton;
    }

    public void setLocalidad(int localidad) {
        this.localidad = localidad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }


    public Localidad(int localidad, String provincia, String distrito, String canton) {
        this.localidad = localidad;
        this.provincia = provincia;
        this.distrito = distrito;
        this.canton = canton;
    }
}
