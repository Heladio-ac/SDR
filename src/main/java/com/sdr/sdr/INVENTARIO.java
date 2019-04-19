package com.sdr.sdr;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import javax.swing.table.DefaultTableModel;
import static com.sdr.sdr.Main.db;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author david
 */
public class INVENTARIO extends javax.swing.JFrame {
    Icon modificar;
 public boolean reponer=true;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        bmostrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

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

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Articulo", "Descripcion", "Cantidad"
            }
        ));
        table.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(table);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        bmostrar.setText("Mostrar Todos");
        bmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmostrarActionPerformed(evt);
            }
        });

        jButton1.setText("EXIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar Producto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Producto:");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(124, 0, 0));
        jLabel2.setText("INVENTARIO");

        jButton3.setText("Modificar Producto");

        jButton4.setText("Eliminar producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bmostrar)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(bBuscar)
                            .addComponent(bmostrar))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    public void busca(){
    
       
        
    //Metodo para hacer busquedas
     DBCollection coll =  db.getCollection("productos");
     BasicDBObject filtro = new BasicDBObject(); //si se realiza consulta con foltro se hace este objeto
     String j=jTextField1.getText();
     filtro=new BasicDBObject("Articulo",new BasicDBObject("$regex",j));//pones el filtro que se requiera
     DBCursor cursor = coll.find(filtro);
     DefaultTableModel model= Main.tabla();
     
     
try 
{
    
       
   while(cursor.hasNext()) 
   {
       
                DBObject obj = cursor.next();
      String color = (String)obj.get("Color");
      String tama = (String)obj.get("Tamaño");
      String item = (String)obj.get("Articulo");
      String titulo = (String)obj.get("Titulo"),Tipo=(String)obj.get("Tipo"),banda = (String)obj.get("Banda");
      String desc=color+","+banda+","+Tipo+tama+","+titulo;
      

     BasicDBObject qty = (BasicDBObject) obj.get("Stock");
                Object  cantidad = (Object) qty.get("StockActual");
                Object  cantidad1 = (Object) qty.get("StockMinimo");
              int i= (int) cantidad;
              int k= (int) cantidad1;
       if(i< k){
            String Stock="Reponer";
            model.addRow(new Object[] { item,desc,cantidad,cantidad1,Stock});
            reponer=false;
        }
       else
       {
           String Stock="Suficiente";
            model.addRow(new Object[] { item,desc,cantidad,cantidad1,Stock});
       }         
                    
   }
      table.setModel(model);
      color c = new color(4);
      table.getColumnModel().getColumn(4).setCellRenderer(new color(4));
      table.getColumnModel().getColumn(2).setPreferredWidth(40);
      table.getColumnModel().getColumn(3).setPreferredWidth(40);
      table.getColumnModel().getColumn(0).setPreferredWidth(40);
       table.getColumnModel().getColumn(4).setPreferredWidth(30);


  
      
}
catch(MongoException e)
{   e.printStackTrace();}

finally 
{
   cursor.close();
}
}
    
    public void llenar ()
    {
        
        DBCollection coll = (DBCollection) db.getCollection("productos");
        DBCursor cursor = coll.find();
        DefaultTableModel model= Main.tabla();
        
try 
{
   while(cursor.hasNext()) 
   {
      DBObject obj = cursor.next();
       String color = (String)obj.get("Color");
      String tama = (String)obj.get("Tamaño");
      String item = (String)obj.get("Articulo");
      String titulo = (String)obj.get("Titulo"),Tipo=(String)obj.get("Tipo"),banda = (String)obj.get("Banda");
      String desc=color+","+banda+","+Tipo+tama+","+titulo;

     BasicDBObject qty = (BasicDBObject) obj.get("Stock");
                Object  cantidad = (Object) qty.get("StockActual");
                Object  cantidad1 = (Object) qty.get("StockMinimo");
             
      
      int i= (int) cantidad;
      int j= (int) cantidad1;
       if(i< j){
            String Stock="Reponer";
            model.addRow(new Object[] { item,desc,cantidad,cantidad1,Stock});
            reponer=false;
        }
       else
       {
           String Stock="Suficiente";
            model.addRow(new Object[] { item,desc,cantidad,cantidad1,Stock});
       }
       

   }
   if(reponer==false)
           {
               
              JOptionPane.showMessageDialog(null, "Atención hay artículos que necesitan reposición","¡¡ATENCIÓN!!",JOptionPane.WARNING_MESSAGE);
           }
      table.setModel(model);
      color c = new color(4);
      table.getColumnModel().getColumn(4).setCellRenderer(new color(4));
      table.getColumnModel().getColumn(0).setPreferredWidth(20);
      table.getColumnModel().getColumn(1).setPreferredWidth(40);
      table.getColumnModel().getColumn(2).setPreferredWidth(20);
      table.getColumnModel().getColumn(3).setPreferredWidth(20);
      table.getColumnModel().getColumn(4).setPreferredWidth(30);
} 
finally 
{
   cursor.close();
}
    }
    
    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
     busca();
    }//GEN-LAST:event_bBuscarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
     Agregar c= new Agregar();
     c.setVisible(true);
     dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void bmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmostrarActionPerformed
       llenar(); // TODO add your handling code here:
    }//GEN-LAST:event_bmostrarActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        if(!Character.isLetter(evt.getKeyChar())) 
        evt.consume();
        String t=jTextField1.getText();
if(t.length()>0)
{
    char prim=t.charAt(0);
    t=Character.toUpperCase(prim)+t.substring(1,t.length());
    jTextField1.setText(t);
}
        busca();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.dispose();
       Agregar obj=new Agregar();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bmostrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
