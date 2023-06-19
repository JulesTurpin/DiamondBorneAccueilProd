/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Entreprise;
import Model.Personne;
import Model.Visite;
import bddUtil.ConnexionBdd;
import java.sql.Connection;

/**
 *Date du programme
 *      31/05/2023
 * Objet du programme
 *      Classe controleInsertion
 * @author Jules Turpin
 */

public class ControleDAO {
    
    public static int controleInsertion(Entreprise uneEntreprise, Personne unePersonne, Visite uneVisite){
        int resultatControle = -1;
        
        Connection connexion = ConnexionBdd.ouvrirConnexion();
        
        //Vérification de la connexion à la base de données
        if(connexion == null){
            ConnexionBdd.ouvrirConnexion();
            System.out.println("La base est en cours de connexion");
        } else {
            System.out.println("La base est connecté");
        }
        
        //Début du traitement de l'entreprise, avec création si nécessaire
        if(uneEntreprise != null){
            
            int resultEntreprise = EntrepriseDAO.getEntrepriseId(connexion, uneEntreprise);
            
            if(resultEntreprise >= 1){
                resultatControle = 0;
            } else {                            
                EntrepriseDAO.insertEntreprise(connexion, uneEntreprise);
                resultatControle = 1;
            }
        
        }
        //Fin du traitement de l'entreprise : Créer ou récupérer
        
        //Début du traitement de la personne, avec création si nécessaire
        int resultPersonne = PersonneDAO.getPersonneId(connexion, unePersonne, uneEntreprise);
        
        if(resultPersonne >= 1){
            resultatControle = 0;
        } else {
            PersonneDAO.insertPersonne(connexion, unePersonne, uneEntreprise);
            resultatControle = 1;
        }
        //Fin de traitement de la personne : Créer ou récupérer
        
        //Création de la visite
        VisiteDAO.insertVisite(connexion, uneVisite, unePersonne, uneEntreprise);
        //Fin de traitement de la visite
        
        //Vérification du bon envoie de la requête (Valide si resultatControle est égal à 0 ou 1);
        return resultatControle;
    }
    
}
