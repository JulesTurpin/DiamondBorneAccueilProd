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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *Date du programme
 *      30/05/2023
 * Objet du programme
 *      Classe PersonneDAO (INSERT/SELECT)
 * @author Jules Turpin
 */

public class PersonneDAO {
    
    //Déclaration des variables pour la requête
    static PreparedStatement requete = null;
    static ResultSet result = null;
    
    //Récupération de l'id d'une personne
    public static int getPersonneId(Connection connexion, Personne unePersonne, Entreprise uneEntreprise){
        int unePersonneId = -1;
        
        try{
            
            if (uneEntreprise == null){
                
                //Préparation de la requete (La personne est un particulier)
                requete = connexion.prepareStatement("SELECT PER_ID FROM personne WHERE PER_NOM = ? AND PER_PRENOM = ? AND PER_MAIL = ? AND PER_TEL = ? AND ENT_ID IS null");
                
                //Récupération des données pour le SELECT
                requete.setString(1, unePersonne.getPER_NOM());
                requete.setString(2, unePersonne.getPER_PRENOM());
                requete.setString(3, unePersonne.getPER_MAIL());
                requete.setString(4, unePersonne.getPER_TEL());
                                
            } else {
                //Préparation de la requete (La personne a une entreprise)
                requete = connexion.prepareStatement("SELECT PER_ID FROM personne WHERE PER_NOM = ? AND PER_PRENOM = ? AND PER_MAIL = ? AND PER_TEL = ? AND ENT_ID = (SELECT ENT_ID FROM entreprise WHERE ENT_NOM = ?)");

                //Récupération des données pour le SELECT
                requete.setString(1, unePersonne.getPER_NOM());
                requete.setString(2, unePersonne.getPER_PRENOM());
                requete.setString(3, unePersonne.getPER_MAIL());
                 requete.setString(4,unePersonne.getPER_TEL());
                requete.setString(5,uneEntreprise.getENT_NOM());
                
            }
            
            //Executer la requete
            result = requete.executeQuery();

            //Récupération des données
            if(result.next()){
                unePersonneId = result.getInt("PER_ID");  
            }

            //Fermeture de la connexion
            ConnexionBdd.fermerConnexion(result);
            ConnexionBdd.fermerConnexion(requete);

        } catch(SQLException e){
            e.printStackTrace();
        }
        //Renvoie des données
        return unePersonneId;
    }
    
    //Récupération du nom et du prénom de la personne pour l'afficher sur le badge
    public static Personne getPersonneNomPrenomBadge(Connection connexion, Visite uneVisite, Personne unePersonne){
        
        try{
            
            //Preparation de la requete
            requete = connexion.prepareStatement("SELECT PER_PRENOM, PER_NOM FROM personne p, visite v WHERE VIS_ID = (SELECT VIS_ID FROM visite ORDER BY VIS_DATE DESC, VIS_HEUREARRIVEE DESC LIMIT 1) AND p.PER_ID = v.PER_ID ORDER BY VIS_DATE DESC, VIS_HEUREARRIVEE DESC LIMIT 1;");
            
            //Executer la requete
            result = requete.executeQuery();
            
            //Récupération des données
            unePersonne = new Personne();
            if(result.next()){
                
                unePersonne.setPER_NOM(result.getString("PER_NOM"));
                unePersonne.setPER_PRENOM(result.getString("PER_PRENOM"));
                return unePersonne;
                
            } else { 
                return null;
            }
            
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    //Insertion d'une nouvelle personne
    public static int insertPersonne(Connection connexion, Personne unePersonne, Entreprise uneEntreprise){
        int resultatInsert = -1;
        
        EntrepriseDAO uneEntrepriseDAO = new EntrepriseDAO();
        
        try{
            
            if(uneEntreprise == null){
                //Préparation de la requête si la personne est un particulier
                requete = connexion.prepareStatement("INSERT INTO personne SET PER_NOM = ?, PER_PRENOM = ?, PER_MAIL = ?, PER_TEL = ?, ENT_ID = null;");

                //Récupération des données à insérer
                requete.setString(1, unePersonne.getPER_NOM());
                requete.setString(2, unePersonne.getPER_PRENOM());
                requete.setString(3, unePersonne.getPER_MAIL());
                requete.setString(4, unePersonne.getPER_TEL());
                System.out.println(unePersonne.getPER_NOM() + "6");
                
            } else {
                //Préparation de la requête si la personne n'est pas un particulier
                requete = connexion.prepareStatement("INSERT INTO personne SET PER_NOM = ?, PER_PRENOM = ?, PER_MAIL = ?, PER_TEL = ?, ENT_ID = ?;");

                //Récupération des données à insérer
                requete.setString(1, unePersonne.getPER_NOM());
                requete.setString(2, unePersonne.getPER_PRENOM());
                requete.setString(3, unePersonne.getPER_MAIL());
                requete.setString(4, unePersonne.getPER_TEL());

                requete.setInt(5, uneEntrepriseDAO.getEntrepriseId(connexion, uneEntreprise));
                System.out.println(unePersonne.getPER_NOM() + "7");
            }
            System.out.println(unePersonne.getPER_NOM() + "8");
            System.out.println(requete);
            
            //Exécution de la requête
            resultatInsert = requete.executeUpdate();
            
            //Fermeture de la connexion
            ConnexionBdd.fermerConnexion(result);
            ConnexionBdd.fermerConnexion(requete);
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        //Renvoie des données
        return resultatInsert;
    }
    
}
