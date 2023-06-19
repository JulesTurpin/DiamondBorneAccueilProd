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
 *      Classe VisiteDAO (INSERT/UPDATE/SELECT)
 * @author Jules Turpin
 */

public class VisiteDAO {
    
    //Déclaration des variables pour les requêtes
    static PreparedStatement requete = null;
    static ResultSet result = null;
    
    //Enregistrement d'une nouvelle visite
    public static int insertVisite(Connection connexion, Visite uneVisite, Personne unePersonne, Entreprise uneEntreprise){
        int resultatInsert = -1;
        
        PersonneDAO unePersonneDAO = new PersonneDAO();
                
        try{
            //Préparation de la requête
            requete = connexion.prepareStatement("INSERT INTO visite SET VIS_PVISITE = ?, VIS_DATE = CURRENT_DATE, VIS_HEUREARRIVEE = CURRENT_TIME, PER_ID = ?;");
            
            //Récupération des données à insérer
            requete.setString(1, uneVisite.getVIS_PVISITE());
            requete.setInt(2, unePersonneDAO.getPersonneId(connexion, unePersonne, uneEntreprise));
            
            //Exécution de la requête
            resultatInsert = requete.executeUpdate();
            
            //Fermeture de la connexion
            ConnexionBdd.fermerConnexion(result);
            ConnexionBdd.fermerConnexion(requete);
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        //Vérification du bon envoie de la requête
        return resultatInsert;
    }
    
    //Récupération de l'id de la visite
    public static int getVisiteId(Connection connexion, Visite uneVisite, Personne unePersonne){
        int uneVisiteId = -1;
        
        try{
            //Préparation de la requete
            requete = connexion.prepareStatement("SELECT VIS_ID FROM visite v, personne p WHERE v.PER_ID = p.PER_ID AND PER_NOM = ? AND PER_PRENOM = ? ORDER BY VIS_DATE DESC, VIS_HEUREARRIVEE DESC LIMIT 1;");
                        
            //Récupération des données pour le SELECT
            requete.setString(1, unePersonne.getPER_NOM());
            requete.setString(2, unePersonne.getPER_PRENOM());
            
            //Executer la requete
            result = requete.executeQuery();
            
            //Récupération des données
            if(result.next()){
                uneVisiteId = result.getInt("VIS_ID");
            }
            
            //Fermeture de la connexion
            ConnexionBdd.fermerConnexion(result);
            ConnexionBdd.fermerConnexion(requete);
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        //Renvoie des données
        return uneVisiteId;
    }
    
    //Récupération de l'heure et la date de la visite
    public static Visite getVisiteDateTime(Connection connexion, Visite uneVisite){
        
        try{
            //Préparation de la requete
            requete = connexion.prepareStatement("SELECT VIS_DATE, VIS_HEUREARRIVEE FROM visite ORDER BY VIS_DATE DESC, VIS_HEUREARRIVEE DESC LIMIT 1;");
            
            //Execution de la requete
            result = requete.executeQuery();
            
            //Récupération des données 
            uneVisite = new Visite();
            if(result.next()){
                
                uneVisite.setVIS_DATE(result.getDate("VIS_DATE"));
                uneVisite.setVIS_HEUREARRIVEE(result.getTime("VIS_HEUREARRIVEE"));
                
                //Renvoie des données
                return uneVisite;
                
            } else {
                return null;
            }
            
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    //Mise à jour de l'heure de départ d'une visite
    public static int updateHeureDepart(Connection connexion, Visite uneVisite){
        int resultatUpdate = -1;
        
        try{
            
            //Préparation de la requête
            requete = connexion.prepareStatement("UPDATE visite SET VIS_HEUREDEPART = CURRENT_TIME WHERE VIS_ID = ?;");
            
            //Récupération des données à insérer/mettre à jour
            requete.setInt(1, uneVisite.getVIS_ID());
            
            //Exécution de la requête
            resultatUpdate = requete.executeUpdate();
            
            //Fermeture de la connexion
            ConnexionBdd.fermerConnexion(result);
            ConnexionBdd.fermerConnexion(requete);
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        //Renvoie des données
        return resultatUpdate;
    }
    
}
