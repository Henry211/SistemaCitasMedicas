/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citas.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Usuario
 */
public class Horario {
    
    ArrayList<String> lunes = new ArrayList<String>();
    ArrayList<String> martes = new ArrayList<String>();
    ArrayList<String> miercoles = new ArrayList<String>();
    ArrayList<String> jueves = new ArrayList<String>();
    ArrayList<String> viernes = new ArrayList<String>();
    ArrayList<String> sabado = new ArrayList<String>();

    public Horario() {
    }

    public ArrayList<String> getLunes() {
        return lunes;
    }

    public void setLunes(ArrayList<String> lunes) {
        this.lunes = lunes;
    }

    public ArrayList<String> getMartes() {
        return martes;
    }

    public void setMartes(ArrayList<String> martes) {
        this.martes = martes;
    }

    public ArrayList<String> getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(ArrayList<String> miercoles) {
        this.miercoles = miercoles;
    }

    public ArrayList<String> getJueves() {
        return jueves;
    }

    public void setJueves(ArrayList<String> jueves) {
        this.jueves = jueves;
    }

    public ArrayList<String> getViernes() {
        return viernes;
    }

    public void setViernes(ArrayList<String> viernes) {
        this.viernes = viernes;
    }

    public ArrayList<String> getSabado() {
        return sabado;
    }

    public void setSabado(ArrayList<String> sabado) {
        this.sabado = sabado;
    }
    
    
    
    
    public void setDateTime(String dia, String hora){
        
        switch(dia){
            
            case "L":
                if(validar(dia,hora)){
                    lunes.add(hora);
                    Collections.sort(lunes);
                }
                break;
            case "M":
                if(validar(dia,hora)){
                    martes.add(hora);
                    Collections.sort(martes);
                }
                break;
            case "I":
                if(validar(dia,hora)){
                    miercoles.add(hora);
                }
                break;
            case "J":
                if(validar(dia,hora)){
                    jueves.add(hora);
                }
                break;
            case "V":
                if(validar(dia,hora)){
                    viernes.add(hora);
                }
                break;
            case "S":
                if(validar(dia,hora)){
                    sabado.add(hora);
                }
                break;
        }
    }
    
    public boolean validar(String dia, String hora){
        return true;
    }
}
