package com.sdr.sdr;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import javax.swing.table.DefaultTableModel;

import static com.sdr.sdr.Main.db;
/**
 *
 * @author david
 */
public class INVENTARIO extends javax.swing.JFrame {

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

        table.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
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
        jLabel2.setText("INVENTARIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(bBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bmostrar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton1)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(bBuscar)
                            .addComponent(bmostrar)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
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
      
      model.addRow(new Object[] { item,desc,cantidad,cantidad1});
               
                    
                    
   }
   table.setModel(model);
   table.getColumnModel().getColumn(2).setPreferredWidth(20);
   table.getColumnModel().getColumn(3).setPreferredWidth(20);
   table.getColumnModel().getColumn(0).setPreferredWidth(20);


  
      
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
      
                
      model.addRow(new Object[] { item,desc,cantidad,cantidad1});
      
     /* double i= (double) qty;
       if(i< 30){
            JOptionPane.showMessageDialog(null, "ATENCION EL inventario del item "+item+" es bajo");
        }*/

   }
      table.setModel(model);
      table.getColumnModel().getColumn(2).setPreferredWidth(20);
      table.getColumnModel().getColumn(3).setPreferredWidth(20);
      table.getColumnModel().getColumn(0).setPreferredWidth(20);
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
