/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citas.presentation.medico.perfil;

import citas.logic.Medico;
import citas.logic.Paciente;

/**
 *
 * @author ESCINF
 */
public class Model {
    Medico medico;
    
    Model(){
        medico = new Medico();
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    
}
