
package citas.logic;

import java.io.Serializable;

public class Usuario implements Serializable{
    
    private String nombre;
    private String password;
    private String cedula;
    private Integer tipo;
    
    public Usuario(String nombre, String password, String cedula, Integer tipo){
        this.nombre = nombre;
        this.password = password;
        this.cedula = cedula;
        this.tipo = tipo;
    }
    public Usuario( String cedula, String clave, Integer tipo){
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
}
