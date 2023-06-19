/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bddUtil;

import java.sql.*;

/**
 *Date du programme
 *      30/05/2023
 * Objet du programme
 *      Classe de connexion à la base de données
 * @author Jules Turpin
 */

public class ConnexionBdd {
    
    //Variable pour la connexion à la base de données
    public static Connection connexion = null;
    public static Statement statement = null;
    public static ResultSet result = null;
    
    //Méthode de creation et de connection à la base de données
    public static Connection ouvrirConnexion(){
        
        try{ //Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Pilote MySql JDBC chargé");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try{ //obtention de la connexion
            connexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/caillebotis", "Caillebotis", "C@ill€botis");
            System.out.println("Connexion OK");
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return connexion;
        
    }
    
    //Méthode de fermeture de la fermeture du ResultSet
    public static void fermerConnexion(ResultSet result){
        
        if(result != null){
            
            try{
                result.close();
            } catch(Exception e){
                System.out.println("Erreur lors de la fermeture d'une connexion dans fermerConnexion(ResultSet result)");
            }
            
        }
        
    }
    
    //Méthode de fermeture du Statement
    public static void fermerConnexion(Statement statement){
        
        if(statement != null){
            
            try{
                statement.close();
            } catch(Exception e){
                System.out.println("Erreur lors de la fermeture d'une connexion dans fermerConnexion(Statement statement");
            }
            
        }
        
    }
    
    //Méthode de fermeture de la connexion
    public static void fermerConnexion(Connection connexion){
        
        if(connexion != null){
            
            try{
                connexion.close();
                System.out.println("Fermeture connexion OK");
            } catch(Exception e){
                System.out.println("Erreur lors de la fermeture d'une connexion dans fermerConnexion(Connection connexion");
            }
            
        }
        
    }
    
}
