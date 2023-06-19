/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Time;
import java.sql.Date;

/**
 *Date du programme
 *      30/05/2023
 * Objet du programme
 *      Classe Visite
 * @author Jules Turpin
 */

public class Visite {
    
    //Variable de la table visite
    private int VIS_ID;
    private String VIS_PVISITE;
    private Date VIS_DATE;
    private Time VIS_HEUREARRIVEE;
    private Time VIS_HEUREDEPART;
    
    //Variable des relations (Many-To-One)
    private Personne unePersonne;
    
    //Constructeur
    public Visite(){
        
    }
    
    public Visite(int pVis_id, String pVis_pVisite, Date pVis_date, Time pVis_heureArrivee, Time pVis_heureDepart){
        this.VIS_ID = pVis_id;
        this.VIS_PVISITE = pVis_pVisite;
        this.VIS_DATE = pVis_date;
        this.VIS_HEUREARRIVEE = pVis_heureArrivee;
        this.VIS_HEUREDEPART = pVis_heureDepart;
    }
    
    //Getter et Setter
    public int getVIS_ID() {
        return VIS_ID;
    }

    public void setVIS_ID(int VIS_ID) {
        this.VIS_ID = VIS_ID;
    }

    public String getVIS_PVISITE() {
        return VIS_PVISITE;
    }

    public void setVIS_PVISITE(String VIS_PVISITE) {
        this.VIS_PVISITE = VIS_PVISITE;
    }

    public Date getVIS_DATE() {
        return VIS_DATE;
    }

    public void setVIS_DATE(Date VIS_DATE) {
        this.VIS_DATE = VIS_DATE;
    }

    public Time getVIS_HEUREARRIVEE() {
        return VIS_HEUREARRIVEE;
    }

    public void setVIS_HEUREARRIVEE(Time VIS_HEUREARRIVEE) {
        this.VIS_HEUREARRIVEE = VIS_HEUREARRIVEE;
    }

    public Time getVIS_HEUREDEPART() {
        return VIS_HEUREDEPART;
    }

    public void setVIS_HEUREDEPART(Time VIS_HEUREDEPART) {
        this.VIS_HEUREDEPART = VIS_HEUREDEPART;
    }
    
    //Getter et Setter des relations (Many-To-One)
    public Personne getUnePersonne() {
        return unePersonne;
    }

    public void setUnePersonne(Personne unePersonne) {
        this.unePersonne = unePersonne;
    }
    
}
