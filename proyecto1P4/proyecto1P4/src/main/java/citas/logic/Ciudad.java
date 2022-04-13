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
   String canton;
   String distrito;

    public Ciudad() {
    }

    public Ciudad(int idProvincia, String provincia, String canton, String distrito) {
        this.idProvincia = idProvincia;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
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

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idProvincia;
        hash = 11 * hash + Objects.hashCode(this.provincia);
        hash = 11 * hash + Objects.hashCode(this.canton);
        hash = 11 * hash + Objects.hashCode(this.distrito);
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
        if (!Objects.equals(this.provincia, other.provincia)) {
            return false;
        }
        if (!Objects.equals(this.canton, other.canton)) {
            return false;
        }
        return Objects.equals(this.distrito, other.distrito);
    }

    @Override
    public String toString() {
        return "Ciudad{" + "idProvincia=" + idProvincia + ", provincia=" + provincia + ", canton=" + canton + ", distrito=" + distrito + '}';
    }
   
   
    
}
