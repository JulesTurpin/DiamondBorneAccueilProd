/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Entreprise;
import bddUtil.ConnexionBdd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *Date du programme
 *      30/05/2023
 * Objet du programme
 *      Classe EntrepriseDAO (INSERT/SELECT)
 * @author Jules Turpin
 */

public class EntrepriseDAO {
    
    //Déclaration des variables pour la requête
    static PreparedStatement requete = null;
    static ResultSet result = null;
    
    //Récupération de l'id de l'entreprise
    public static int getEntrepriseId(Connection connexion, Entreprise uneEntreprise){
        int uneEntrepriseId = -1;
        
        try{
            //Préparation de la requete
            requete = connexion.prepareStatement("SELECT ENT_ID FROM entreprise WHERE ENT_NOM = ? AND ENT_ACTIVITE = ?;");
                        
            //Récupération des données pour le SELECT
            requete.setString(1, uneEntreprise.getENT_NOM());
            requete.setString(2, uneEntreprise.getENT_ACTIVITE());
            
            //Executer la requete
            result = requete.executeQuery();
            
            //Récupération des données
            if(result.next()){
                uneEntrepriseId = result.getInt("ENT_ID");
            }
            
            //Fermeture de la connexion
            ConnexionBdd.fermerConnexion(result);
            ConnexionBdd.fermerConnexion(requete);
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        //Renvoie des données
        return uneEntrepriseId;
    }
    
    //Enregistrement d'une nouvelle entreprise
    public static int insertEntreprise(Connection connexion, Entreprise uneEntreprise){
        int resultatInsert = -1;
        
        try{
            
            //Préparation de la requête
            requete = connexion.prepareStatement("INSERT INTO entreprise SET ENT_NOM = ?, ENT_ACTIVITE = ?;");
            
            //Récupération des données à insérer
            requete.setString(1, uneEntreprise.getENT_NOM());
            requete.setString(2, uneEntreprise.getENT_ACTIVITE());
            
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
