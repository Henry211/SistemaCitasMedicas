
package citas.logic;

import java.io.Serializable;

public class Usuario implements Serializable{
    
    private String nombre;
    private String clave;
    private String cedula;
    private Integer tipo;
    
    public Usuario(String cedula, String nombre, String clave, Integer tipo){
        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
        this.tipo = tipo;
    }
    public Usuario( String cedula, String clave, Integer tipo){
        this.clave = clave;
        this.cedula = cedula;
        this.tipo = tipo;
    }
    
    public Usuario(){
        
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
}
