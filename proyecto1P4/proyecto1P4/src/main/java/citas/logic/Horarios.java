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
public class Horarios {
    Medico idmedico;
    int numero;
    int dia;
    int hora_comienzo;
    int hora_finaliza;
    int frecuencia;

    public Horarios() {
    }

    public Horarios(Medico idmedico, int numero, int dia, int hora_comienzo, int hora_finaliza, int frecuencia) {
        this.idmedico = idmedico;
        this.numero = numero;
        this.dia = dia;
        this.hora_comienzo = hora_comienzo;
        this.hora_finaliza = hora_finaliza;
        this.frecuencia = frecuencia;
    }

    public Horarios(Medico idmedico, int dia, int hora_comienzo, int hora_finaliza, int frecuencia) {
        this.idmedico = idmedico;
        this.dia = dia;
        this.hora_comienzo = hora_comienzo;
        this.hora_finaliza = hora_finaliza;
        this.frecuencia = frecuencia;
    }

    public Medico getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Medico idmedico) {
        this.idmedico = idmedico;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora_comienzo() {
        return hora_comienzo;
    }

    public void setHora_comienzo(int hora_comienzo) {
        this.hora_comienzo = hora_comienzo;
    }

    public int getHora_finaliza() {
        return hora_finaliza;
    }

    public void setHora_finaliza(int hora_finaliza) {
        this.hora_finaliza = hora_finaliza;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idmedico);
        hash = 97 * hash + this.numero;
        hash = 97 * hash + this.dia;
        hash = 97 * hash + this.hora_comienzo;
        hash = 97 * hash + this.hora_finaliza;
        hash = 97 * hash + this.frecuencia;
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
        final Horarios other = (Horarios) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.dia != other.dia) {
            return false;
        }
        if (this.hora_comienzo != other.hora_comienzo) {
            return false;
        }
        if (this.hora_finaliza != other.hora_finaliza) {
            return false;
        }
        if (this.frecuencia != other.frecuencia) {
            return false;
        }
        return Objects.equals(this.idmedico, other.idmedico);
    }

    @Override
    public String toString() {
        return "Horarios{" + "idmedico=" + idmedico + ", numero=" + numero + ", dia=" + dia + ", hora_comienzo=" + hora_comienzo + ", hora_finaliza=" + hora_finaliza + ", frecuencia=" + frecuencia + '}';
    }
    
    
    
    
}
