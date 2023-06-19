/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *Date du programme
 *      30/05/2023
 * Objet du programme
 *      Classe Entreprise
 * @author Jules Turpin
 */

public class Entreprise {
    
    //Variable de la table entreprise
    private int ENT_ID;
    private String ENT_NOM;
    private String ENT_ACTIVITE;
    
    //Variable des relations (One-to-Many)
    private ArrayList<Personne> lesPersonnes;
    
    //Constructeur
    public Entreprise(){
        
    }
    
    public Entreprise(int pEnt_id, String pEnt_nom, String pEnt_activite){
        this.ENT_ID = pEnt_id;
        this.ENT_NOM = pEnt_nom;
        this.ENT_ACTIVITE = pEnt_activite;
    }
    
    //Getter et Setter
    public int getENT_ID() {
        return ENT_ID;
    }

    public void setENT_ID(int ENT_ID) {
        this.ENT_ID = ENT_ID;
    }

    public String getENT_NOM() {
        return ENT_NOM;
    }

    public void setENT_NOM(String ENT_NOM) {
        this.ENT_NOM = ENT_NOM;
    }

    public String getENT_ACTIVITE() {
        return ENT_ACTIVITE;
    }

    public void setENT_ACTIVITE(String ENT_ACTIVITE) {
        this.ENT_ACTIVITE = ENT_ACTIVITE;
    }
    
    //Getter et Setter des relations (One-To-Many)
    public ArrayList<Personne> getLesPersonnes() {
        return lesPersonnes;
    }

    public void setLesPersonnes(ArrayList<Personne> lesPersonnes) {
        this.lesPersonnes = lesPersonnes;
    }
    
    public void addUnePersonne(Personne pUnePersonne){
        if(lesPersonnes == null){
            lesPersonnes = new ArrayList<Personne>();
        }
        lesPersonnes.add(pUnePersonne);
    }
    
}
