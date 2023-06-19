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
 *      Classe Personne
 * @author Jules Turpin
 */

public class Personne {
    
    //Variable de la table personne
    private int PER_ID;
    private String PER_NOM;
    private String PER_PRENOM;
    private String PER_MAIL;
    private String PER_TEL;
    
    //Variable des relations (Many-To-One)
    private Entreprise uneEntreprise;
    
    //Variable des relations (One-To-Many)
    private ArrayList<Visite> lesVisites;
    
    //Constructeur
    public Personne(){
        
    }
    
    public Personne(int pPer_id, String pPer_nom, String pPer_prenom, String pPer_mail, String pPer_tel){
        this.PER_ID = pPer_id;
        this.PER_NOM = pPer_nom;
        this.PER_PRENOM = pPer_prenom;
        this.PER_MAIL = pPer_mail;
        this.PER_TEL = pPer_tel;
    }
    
    //Getter et Setter
    public int getPER_ID() {
        return PER_ID;
    }

    public void setPER_ID(int PER_ID) {
        this.PER_ID = PER_ID;
    }

    public String getPER_NOM() {
        return PER_NOM;
    }

    public void setPER_NOM(String PER_NOM) {
        this.PER_NOM = PER_NOM;
    }

    public String getPER_PRENOM() {
        return PER_PRENOM;
    }

    public void setPER_PRENOM(String PER_PRENOM) {
        this.PER_PRENOM = PER_PRENOM;
    }

    public String getPER_MAIL() {
        return PER_MAIL;
    }

    public void setPER_MAIL(String PER_MAIL) {
        this.PER_MAIL = PER_MAIL;
    }

    public String getPER_TEL() {
        return PER_TEL;
    }

    public void setPER_TEL(String PER_TEL) {
        this.PER_TEL = PER_TEL;
    }
    
    //Getter et Setter des relations (Many-To-One)
    public Entreprise getUneEntreprise() {
        return uneEntreprise;
    }

    public void setUneEntreprise(Entreprise uneEntreprise) {
        this.uneEntreprise = uneEntreprise;
    }
    
    //Getter et Setter des relations (One-To-Many)
    public ArrayList<Visite> getLesVisites() {
        return lesVisites;
    }

    public void setLesVisites(ArrayList<Visite> lesVisites) {
        this.lesVisites = lesVisites;
    }

    public void addUneVisite(Visite pUneVisite){
        if(lesVisites == null){
            lesVisites = new ArrayList<Visite>();
        }
        lesVisites.add(pUneVisite);
    }
    
    
    
}
