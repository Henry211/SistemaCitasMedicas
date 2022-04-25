package citas.logic;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ESCINF
 */
public class Ciudad implements Serializable {

    String provincia;

    public Ciudad() {
    }

    public Ciudad(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /*
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
     */
    @Override
    public String toString() {
        return "Ciudad{" + ", provincia=" + provincia + '}';
    }

}
