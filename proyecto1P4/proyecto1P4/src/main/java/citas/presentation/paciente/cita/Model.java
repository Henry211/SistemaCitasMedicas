/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citas.presentation.paciente.cita;

import citas.logic.Cita;

/**
 *
 * @author ESCINF
 */
public class Model {
    
    Cita cita;

    public Model() {
        this.cita = new Cita();
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
    
    
    
    
    
}
