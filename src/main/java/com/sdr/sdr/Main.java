package com.sdr.sdr;

import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import javax.swing.table.DefaultTableModel;

public class Main {
    
    public static MongoDatabase db;
    
    public static void main(String[] args) {
        
        MongoClientURI uri = new MongoClientURI(
            "mongodb://dbUser:PEUgdemRd4M9QCeY@sdr-shard-00-00-6u6yh.mongodb.net:27017,sdr-shard-00-01-6u6yh.mongodb.net:27017,sdr-shard-00-02-6u6yh.mongodb.net:27017/test?ssl=true&replicaSet=SDR-shard-0&authSource=admin&retryWrites=true");

        MongoClient mongoClient = new MongoClient(uri);

        db = mongoClient.getDatabase("SDR");
        
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
            java.util.logging.Logger.getLogger(INVENTARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INVENTARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INVENTARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INVENTARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        Login ob=new Login();
        ob.setVisible(true);
    }
    
    public static DefaultTableModel tabla(){
        String[] columnNames = {"Articulo", "Codigo", "Tipo", "Costo", "Precio","Reponer"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0){
            @Override
            public boolean isCellEditable(int fil, int col) {
                return col==5;
            }
        };
        return model;
        
    }
    public static DefaultTableModel tabla1(){
        String[] columnNames = {"Articulo", "Codigo","Precio","Stock"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0){
            @Override
            public boolean isCellEditable(int fil, int col) {
                return col==3;
            }
        };
        return model;
    }
}
