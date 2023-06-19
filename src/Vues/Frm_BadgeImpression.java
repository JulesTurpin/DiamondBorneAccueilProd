/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vues;

import DAO.PersonneDAO;
import DAO.VisiteDAO;
import Model.Personne;
import Model.Visite;
import static bddUtil.ConnexionBdd.connexion;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code39Writer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.ImageIcon;

/**
 *Date du programme
 *      30/05/2023
 * Objet du programme
 *      Frame BadgeImpression
 * @author Jules Turpin
 */
public class Frm_BadgeImpression extends javax.swing.JFrame {

    /**
     * Creates new form Frm_TestBadge
     */
    public Frm_BadgeImpression() {
        initComponents();
        
        Personne unePersonne = new Personne();
        Visite uneVisite = new Visite();
        
        //Récupération du nom, prénom de la personne et de la date et l'heure d'une visite
        unePersonne = PersonneDAO.getPersonneNomPrenomBadge(connexion, uneVisite, unePersonne);
        uneVisite = VisiteDAO.getVisiteDateTime(connexion, uneVisite);
        
        //ImageLogoDiamond
        ImageIcon iconLogoDiamond = new ImageIcon("C:\\Images\\Logo\\LOGO_D_petit.png");
        jLabelIconLogo.setIcon(iconLogoDiamond);
                
        //Set du text visiteur
        jLabelVisite.setForeground(Color.WHITE);
        jLabelVisite.setFont(new Font("Roboto", Font.BOLD, 36));
        
        //Mise en place du Prénom et du Nom
        jLabelPrenom.setText(unePersonne.getPER_NOM());
        jLabelNom.setText(unePersonne.getPER_PRENOM());
        jLabelPrenom.setFont(new Font("Roboto", Font.BOLD, 18));
        jLabelNom.setFont(new Font("Roboto", Font.BOLD, 18));
        
        
        
        jLabelDate1.setText(uneVisite.getVIS_DATE() + "");
        //jLabelHeure.setText(uneVisite.getVIS_HEUREARRIVEE() + "");
        jLabelDate1.setFont(new Font("Roboto", Font.BOLD, 8));
        jLabelDate1.setForeground(Color.WHITE);
        
        //Mise en place du blanc sur tout les panel
        this.getContentPane().setBackground(Color.GRAY);
        jPanel1.setBackground(Color.WHITE);
        jPanel2.setBackground(Color.WHITE);
        jPanel3.setBackground(Color.WHITE);
        jPanel4.setBackground(Color.BLACK);
        
        
        //Création du code bar pour le badge
            int resultVisite = VisiteDAO.getVisiteId(connexion, uneVisite, unePersonne);
            
            String codeBarText = ("VIS" + resultVisite);
            
            
            
            try {
                // Génération du code-barres
                Code39Writer writer = new Code39Writer();
                
                
                BitMatrix bitMatrix = writer.encode(codeBarText, BarcodeFormat.CODE_39, 340, 35);
                                
                // Conversion de la matrice de bits en image BufferedImage
                BufferedImage codeBarImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
                
                // Création d'une nouvelle image combinée avec le texte
                int combinedWidth = Math.max(codeBarImage.getWidth(), 200); // Largeur maximale entre le code-barres et le texte
                int combinedHeight = codeBarImage.getHeight() + 25; // Hauteur supplémentaire pour le texte
                BufferedImage combinedImage = new BufferedImage(combinedWidth, combinedHeight, BufferedImage.TYPE_INT_RGB);

                // Dessin du code-barres sur l'image combinée
                Graphics2D g2d = combinedImage.createGraphics();
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, combinedWidth, combinedHeight);
                g2d.drawImage(codeBarImage, (combinedWidth - codeBarImage.getWidth()) / 2, 0, null);

                // Ajout du texte en dessous du code-barres
                g2d.setColor(Color.BLACK);
                g2d.setFont(new Font("Arial", Font.PLAIN, 10));
                FontMetrics fontMetrics = g2d.getFontMetrics();
                int textWidth = fontMetrics.stringWidth(codeBarText);
                int textHeight = fontMetrics.getHeight();
                int textX = (combinedWidth - textWidth) / 2;
                int textY = combinedHeight - textHeight;
                g2d.drawString(codeBarText, textX, textY);

                g2d.dispose();
                
                //Affichage du code bar
                ImageIcon iconCodeBar = new ImageIcon(combinedImage);
                jLabelIconCodeBarre.setIcon(iconCodeBar);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabelVisite = new javax.swing.JLabel();
        jLabelDate1 = new javax.swing.JLabel();
        jLabelIconLogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelPrenom = new javax.swing.JLabel();
        jLabelNom = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelIconCodeBarre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(340, 188));
        setSize(new java.awt.Dimension(340, 188));

        jLabelVisite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVisite.setText("Visiteur ");

        jLabelDate1.setText("jLabel6");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabelVisite, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jLabelDate1))
            .addComponent(jLabelVisite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIconLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIconLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabelPrenom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPrenom.setText("jLabel3");

        jLabelNom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelNom.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabelPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabelNom, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelPrenom)
                .addComponent(jLabelNom))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIconCodeBarre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIconCodeBarre, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static class Printer implements Printable {
        final Component comp;

        public Printer(Component comp){
            this.comp = comp;
        }

        @Override
        public int print(Graphics g, PageFormat format, int page_index) 
                throws PrinterException {
                
                if (page_index > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                // get the bounds of the component
                Dimension dim = comp.getSize();
                double cHeight = dim.getHeight();
                double cWidth = dim.getWidth();

                // get the bounds of the printable area
                double pHeight = format.getImageableHeight();
                double pWidth = format.getImageableWidth();
                
                double pXStart = format.getImageableX();
                double pYStart = format.getImageableY();

                double xRatio = pWidth / cWidth;
                double yRatio = pHeight / cHeight;


                Graphics2D g2 = (Graphics2D) g;
                g2.translate(pXStart, pYStart);
                g2.scale(xRatio, yRatio);
                comp.paint(g2);
                
                return Printable.PAGE_EXISTS;
            }
    }
    
    
    
    //Impression du badge
    public void printFrame(){
        PrinterJob pjob = PrinterJob.getPrinterJob();
        
        pjob.setJobName(this.getName());
        PageFormat preformat = pjob.defaultPage();
            
        Paper paper = preformat.getPaper();
            
        int ixMarg = 0;
        int iyMar = 0;
        paper.setImageableArea(ixMarg, iyMar, preformat.getWidth() - ixMarg, preformat.getHeight() - iyMar);
        preformat.setPaper(paper);
            
        preformat.setOrientation(PageFormat.LANDSCAPE);
            
        //If user does not hit cancel then print.
            //Set print component
        pjob.setPrintable(new Printer(this.rootPane), preformat);
        try {
            pjob.print();
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }
    
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
            java.util.logging.Logger.getLogger(Frm_BadgeImpression.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_BadgeImpression.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_BadgeImpression.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_BadgeImpression.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_BadgeImpression().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDate1;
    private javax.swing.JLabel jLabelIconCodeBarre;
    private javax.swing.JLabel jLabelIconLogo;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelPrenom;
    private javax.swing.JLabel jLabelVisite;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
