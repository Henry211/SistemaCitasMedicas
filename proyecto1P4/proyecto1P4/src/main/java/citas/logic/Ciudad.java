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
public class Ciudad {
    
   int idProvincia;
   String provincia;

  

    public Ciudad() {
    }

    public Ciudad(int idProvincia, String provincia) {
        this.idProvincia = idProvincia;
        this.provincia = provincia;
    }
    
    public Ciudad(String name){
        this.provincia = name;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.idProvincia;
        hash = 19 * hash + Objects.hashCode(this.provincia);
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
        final Ciudad other = (Ciudad) obj;
        if (this.idProvincia != other.idProvincia) {
            return false;
        }
        return Objects.equals(this.provincia, other.provincia);
    }

    @Override
    public String toString() {
        return "Ciudad{" + "idProvincia=" + idProvincia + ", provincia=" + provincia + '}';
    }

  


  

 


 
   
   
    
}
