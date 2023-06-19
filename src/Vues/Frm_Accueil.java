/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vues;

import DAO.VisiteDAO;
import Model.Visite;
import bddUtil.ConnexionBdd;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import javafx.stage.StageStyle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *Date du programme
 *      30/05/2023
 * Objet du programme
 *      Frame BadgeImpression
 * @author Jules Turpin
 */

public class Frm_Accueil extends javax.swing.JFrame {
    
    Connection connexion = ConnexionBdd.ouvrirConnexion();
    boolean bSendBarreCode;
    StringBuilder phrase = new StringBuilder();
    String idVis;
    String prefixCodeBarre;

    /**
     * Creates new form Frm_Accueil
     */
    public Frm_Accueil() {
        initComponents();
        
        //Forçage du pleine écran
        this.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        
        //Désactivation de la modification de taille de l'application
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //Couleur du background
        this.getContentPane().setBackground(Color.WHITE);
        
        
        //Mise en place des images
        ImageIcon iconLogoGDiamond = new ImageIcon("C:\\Images\\Logo\\LOGO-DIAMOND-SC-v2.jpg");
        ImageIcon iconLogoPDiamond = new ImageIcon("C:\\Images\\Logo\\LOGO_D_petit.png");
        ImageIcon iconLogoLichtgitter = new ImageIcon("C:\\Images\\Logo\\LOGO_LG.png");
        ImageIcon iconPresentation = new ImageIcon("C:\\Images\\BORNE_ACCUEIL_PAGE_1_petit.jpg");
        
        jLogoDiamondGN.setIcon(iconLogoGDiamond);
        jLogoDiamondPBA.setIcon(iconLogoPDiamond);
        jLogoLichtgitterA.setIcon(iconLogoLichtgitter);
        jLabel2.setIcon(iconPresentation);
        
        //récupération du code barre + update de l'heure de départ
        Visite uneVisite = new Visite();
        
        //KeyListener permettant de récupérer le scan du code bar
        this.addKeyListener(new KeyListener(){
            
            //Méthode en fonction du type de la touche utilisé
            public void keyTyped(KeyEvent e) {
                // Cette méthode est appelée lorsque l'utilisateur tape une touche et la relâche.
                // Vous pouvez mettre votre code de traitement ici.
                
                //récupération caractère par caractère de la phrase du code bar + mise en phrase de chaque caractère
                char keyChar = e.getKeyChar();
                
                if(bSendBarreCode == true){
                    phrase.append(keyChar);
                }
                
            }

            //Méthode quand la touche est pressé
            public void keyPressed(KeyEvent e) {
                // Cette méthode est appelée lorsque l'utilisateur appuie sur une touche.
                // Vous pouvez mettre votre code de traitement ici.
                
                int iKeyCode = e.getKeyCode();
        
                //Début du code bar
                if(iKeyCode == 18 && !bSendBarreCode){
                    bSendBarreCode = true;
                    phrase.setLength(0);
                }

                //Fin du code barre
                if(iKeyCode == 10 && bSendBarreCode){
                    bSendBarreCode = false;
                    
                    //Récupération de l'identifiant de visite en supprimant le préfix "VIS"
                    prefixCodeBarre = phrase.substring(0, 3);
                    idVis = phrase.substring(3);
                    
                    //Insertion de l'heure de départ dans la base de donnée si le chiffre est bien un entier et que le préfix est bien égal à "VIS"
                    if(prefixCodeBarre.equals("VIS")){
                        try{
                        
                            Integer.parseInt(idVis);
                            uneVisite.setVIS_ID(Integer.parseInt(idVis));
                            int updateVisite = VisiteDAO.updateHeureDepart(connexion, uneVisite);
                            
                            //pop-up
                            JOptionPane.showMessageDialog(null, "Merci de votre visite !");
            
                        } catch(NumberFormatException ex){
                            ex.printStackTrace();
                        }
                    }
                                      
                }
                
            }

            //Méthode quand la touche est laché
            public void keyReleased(KeyEvent e) {
                // Cette méthode est appelée lorsque l'utilisateur relâche une touche après l'avoir appuyée.
                // Vous pouvez mettre votre code de traitement ici.
                
            }
            
        });
        
        //Activer la possibiliter de selectionné la Frame
        this.setFocusable(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLogoDiamondGN = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPiedPageA = new javax.swing.JPanel();
        jPied1A = new javax.swing.JPanel();
        jLogoDiamondPBA = new javax.swing.JLabel();
        jLogoLichtgitterA = new javax.swing.JLabel();
        jTextPiedP1A = new javax.swing.JLabel();
        AjTextpiedP2A = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPied2A = new javax.swing.JPanel();
        jTextPied3A = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jLogoDiamondGN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLogoDiamondGN.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLogoDiamondGN.setDoubleBuffered(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenue chez le Caillebotis Diamond");

        jButton1.setText("Documentation technique");
        jButton1.setMaximumSize(new java.awt.Dimension(185, 29));
        jButton1.setMinimumSize(new java.awt.Dimension(185, 29));
        jButton1.setPreferredSize(new java.awt.Dimension(185, 29));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setText("Enregistrer votre visite");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPiedPageA.setBackground(new java.awt.Color(255, 255, 255));
        jPiedPageA.setPreferredSize(new java.awt.Dimension(768, 108));

        jPied1A.setBackground(new java.awt.Color(60, 59, 58));

        jTextPiedP1A.setForeground(new java.awt.Color(255, 255, 255));
        jTextPiedP1A.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTextPiedP1A.setText("Le Caillebotis Diamond est une société du groupe Lichtgitter, un des leaders mondiaux sur le");

        AjTextpiedP2A.setForeground(new java.awt.Color(255, 255, 255));
        AjTextpiedP2A.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AjTextpiedP2A.setText("le monde");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("marché du caillebotis avec plus de 15 filiales en Europe & de nombreuses repésentations dans");

        javax.swing.GroupLayout jPied1ALayout = new javax.swing.GroupLayout(jPied1A);
        jPied1A.setLayout(jPied1ALayout);
        jPied1ALayout.setHorizontalGroup(
            jPied1ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPied1ALayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLogoDiamondPBA, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPied1ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AjTextpiedP2A, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextPiedP1A, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jLogoLichtgitterA, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPied1ALayout.setVerticalGroup(
            jPied1ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPied1ALayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPied1ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLogoDiamondPBA, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPied1ALayout.createSequentialGroup()
                        .addComponent(jTextPiedP1A)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(AjTextpiedP2A))
                    .addComponent(jLogoLichtgitterA, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPied2A.setBackground(new java.awt.Color(249, 77, 30));

        jTextPied3A.setText(" @ 2023 Le Caillebotis Diamond");

        javax.swing.GroupLayout jPied2ALayout = new javax.swing.GroupLayout(jPied2A);
        jPied2A.setLayout(jPied2ALayout);
        jPied2ALayout.setHorizontalGroup(
            jPied2ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPied2ALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextPied3A, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPied2ALayout.setVerticalGroup(
            jPied2ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPied2ALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextPied3A, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPiedPageALayout = new javax.swing.GroupLayout(jPiedPageA);
        jPiedPageA.setLayout(jPiedPageALayout);
        jPiedPageALayout.setHorizontalGroup(
            jPiedPageALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPied1A, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPied2A, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPiedPageALayout.setVerticalGroup(
            jPiedPageALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPiedPageALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPied1A, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPied2A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPiedPageA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jButton2)
                .addGap(232, 232, 232))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLogoDiamondGN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(543, 543, 543))))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLogoDiamondGN, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPiedPageA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Lien vers la brochure de Diamond (Version 2023)
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String url = "https://lecaillebotisdiamond.sharefile.eu/d-s0631e62827984426bbb006c7f2502a1c";
        
        try{
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch(java.io.IOException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //Lien vers le formulaire d'enregistrement
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        JFrame leFormulaire = new JFrame();
        
        leFormulaire = new Frm_FormulaireEnregistrement();
        leFormulaire.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Accueil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AjTextpiedP2A;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLogoDiamondGN;
    private javax.swing.JLabel jLogoDiamondPBA;
    private javax.swing.JLabel jLogoLichtgitterA;
    private javax.swing.JPanel jPied1A;
    private javax.swing.JPanel jPied2A;
    private javax.swing.JPanel jPiedPageA;
    private javax.swing.JLabel jTextPied3A;
    private javax.swing.JLabel jTextPiedP1A;
    // End of variables declaration//GEN-END:variables
}
