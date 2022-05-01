package citas.logic;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ESCINF
 */
public class Especialidad implements Serializable{

    String especialidad;

    public Especialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Especialidad() {
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.especialidad);
        return hash;
    }
    /*
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
final Especialidad other = (Especialidad) obj;
return this.id == other.id;
}
     */
}