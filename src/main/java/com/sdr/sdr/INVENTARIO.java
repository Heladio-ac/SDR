package com.sdr.sdr;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import javax.swing.table.DefaultTableModel;
import static com.sdr.sdr.Main.db;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author david
 */
public class INVENTARIO extends javax.swing.JFrame {

    Icon modificar;
    public boolean reponer = true;

    public INVENTARIO() {
        initComponents();
        llenar();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jTextField1 = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        bmostrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        jMenuItem1.setText("Verificar Si El Inventario es bajo");
        jMenuItem1.setComponentPopupMenu(jPopupMenu1);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Actualizar Inventario");
        jMenuItem2.setComponentPopupMenu(jPopupMenu1);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 361, 143, -1));

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(bBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 360, -1, -1));

        bmostrar.setText("Mostrar Todos");
        bmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmostrarActionPerformed(evt);
            }
        });
        getContentPane().add(bmostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 360, -1, -1));

        jButton1.setText("EXIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, -1, -1));

        jButton2.setText("Agregar Producto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 123, -1));

        jLabel1.setText("Producto:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 364, 54, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INVENTARIO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 119, 18));

        jButton3.setText("Modificar Producto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        jButton4.setText("Eliminar producto");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 123, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(table);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, 547, 285));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SDR2.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void busca() {

        //Metodo para hacer busquedas
        MongoCollection<Document> coll = db.getCollection("productos");
        Document filtro = new Document(); //si se realiza consulta con foltro se hace este objeto
        String j = jTextField1.getText();
        filtro = new Document("ARTICULO", new Document("$regex", j));//pones el filtro que se requiera
        MongoCursor<Document> cursor = coll.find(filtro).iterator();
        DefaultTableModel model = Main.tabla();

        try {

            while (cursor.hasNext()) {

                Document doc = cursor.next();

                String item = (String) doc.get("ARTICULO"), Tipo = (String) doc.get("TIPO"), Codigo = (String) doc.get("CODIGO");

                Object costoc = (Object) doc.get("COSTO"), costov = (Object) doc.get("PRECIO");

                Document qty = (Document) doc.get("STOCK");
                Object cantidad = (Object) qty.get("ACTUAL"), cantidad1 = (Object) qty.get("MINIMO");

                try {
                    double i = (double) cantidad;
                    double k = (double) cantidad1;
                    if (i <= k) {
                        String Stock = "Reponer";
                        model.addRow(new Object[]{item, Codigo, Tipo, costoc, costov, Stock});
                        reponer = false;
                    } else {
                        String Stock = "Suficiente";
                        model.addRow(new Object[]{item, Codigo, Tipo, costoc, costov, Stock});
                    }
                } catch (Exception e) {
                    String Stock = "Sin Informacion";
                    model.addRow(new Object[]{item, Codigo, Tipo, costoc, costov, Stock});
                }

            }
            table.setModel(model);
            color c = new color(5);
            //Esre bloque de comentarios hace que sucedan algunos errores y hace que no cargue bien la interfaz
            table.getColumnModel().getColumn(5).setCellRenderer(c);
            table.getColumnModel().getColumn(0).setPreferredWidth(70);
            table.getColumnModel().getColumn(1).setPreferredWidth(20);
            table.getColumnModel().getColumn(2).setPreferredWidth(20);
            table.getColumnModel().getColumn(3).setPreferredWidth(20);
            table.getColumnModel().getColumn(4).setPreferredWidth(40);

        } catch (MongoException e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
    }
    /*public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Media/flame.png"));


        return retValue;
    }*/

    public void llenar() {

        MongoCollection<Document> coll = db.getCollection("productos");
        MongoCursor<Document> cursor = coll.find().iterator();
        DefaultTableModel model = Main.tabla();

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();

                String item = (String) doc.get("ARTICULO"), Tipo = (String) doc.get("TIPO"), Codigo = (String) doc.get("CODIGO");

                Object costoc = (Object) doc.get("COSTO"), costov = (Object) doc.get("PRECIO");

                Document qty = (Document) doc.get("STOCK");
                Object cantidad = (Object) qty.get("ACTUAL"), cantidad1 = (Object) qty.get("MINIMO");

                try {
                    double i = (double) cantidad;
                    double k = (double) cantidad1;
                    if (i <= k) {
                        String Stock = "Reponer";
                        model.addRow(new Object[]{item, Codigo, Tipo, costoc, costov, Stock});
                        reponer = false;
                    } else {
                        String Stock = "Suficiente";
                        model.addRow(new Object[]{item, Codigo, Tipo, costoc, costov, Stock});
                    }
                } catch (Exception e) {
                    String Stock = "Sin Informacion";
                    model.addRow(new Object[]{item, Codigo, Tipo, costoc, costov, Stock});
                }

            }
            if (reponer == false) {

                JOptionPane.showMessageDialog(null, "Atención hay artículos que necesitan reposición", "¡¡ATENCIÓN!!", JOptionPane.WARNING_MESSAGE);
            }
            table.setModel(model);
            color c = new color(5);
            //Esre bloque de comentarios hace que sucedan algunos errores y hace que no cargue bien la interfaz
            table.getColumnModel().getColumn(5).setCellRenderer(c);
            table.getColumnModel().getColumn(0).setPreferredWidth(70);
            table.getColumnModel().getColumn(1).setPreferredWidth(20);
            table.getColumnModel().getColumn(2).setPreferredWidth(20);
            table.getColumnModel().getColumn(3).setPreferredWidth(20);
            table.getColumnModel().getColumn(4).setPreferredWidth(40);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }

    }

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        busca();
    }//GEN-LAST:event_bBuscarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Agregar c = new Agregar();
        c.setVisible(true);
        dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void bmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmostrarActionPerformed
        llenar(); // TODO add your handling code here:
    }//GEN-LAST:event_bmostrarActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        if (!Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
        jTextField1.setText(jTextField1.getText().toUpperCase());
        busca();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        JFrame obj = new Agregar();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        /*String t=jTextField1.getText();
if(t.length()>0)
{
    char prim=t.charAt(0);
    t=Character.toUpperCase(prim)+t.substring(1,t.length());
    jTextField1.setText(t);
}*/// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int row = table.getSelectedRow();
       String codigo=table.getValueAt(row,1).toString();
       Actualizar obj=new Actualizar(codigo);
       obj.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bmostrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
