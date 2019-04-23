package com.sdr.sdr;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import javax.swing.table.DefaultTableModel;
import static com.sdr.sdr.Main.db;
import javax.swing.Icon;
import javax.swing.JFrame;
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

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bmostrar))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 238, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(bBuscar)
                            .addComponent(bmostrar))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    public void busca(){
    
       
        
    //Metodo para hacer busquedas
     DBCollection coll =  db.getCollection("productos");
     BasicDBObject filtro = new BasicDBObject(); //si se realiza consulta con foltro se hace este objeto
     String j=jTextField1.getText();
     filtro=new BasicDBObject("ARTICULO",new BasicDBObject("$regex",j));//pones el filtro que se requiera
     DBCursor cursor = coll.find(filtro);
     DefaultTableModel model= Main.tabla();
     
     
try 
{
    
       
   while(cursor.hasNext()) 
   {
       
                DBObject obj = cursor.next();
       
      
      String item = (String)obj.get("ARTICULO"),Tipo=(String)obj.get("TIPO"),Codigo=(String)obj.get("CODIGO");
      
      Object  costoc = (Object) obj.get("COSTO"),costov = (Object) obj.get("PRECIO");
     
     BasicDBObject qty = (BasicDBObject) obj.get("STOCK");
     Object  cantidad = (Object) qty.get("ACTUAL"),cantidad1 = (Object) qty.get("MINIMO");
     
              
       try{
      double i= (double) cantidad;
      double k= (double) cantidad1;
       if(i<= k){
            String Stock="Reponer";
            model.addRow(new Object[] { item,Codigo,Tipo,costoc,costov,Stock});
            reponer=false;
        }
       else
       {
           String Stock="Suficiente";
           model.addRow(new Object[] { item,Codigo,Tipo,costoc,costov,Stock});
       }
      }
      catch(Exception e)
      { 
          String Stock="Sin Informacion";
            model.addRow(new Object[] { item,Codigo,Tipo,costoc,costov,Stock});
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
       
      
      String item = (String)obj.get("ARTICULO"),Tipo=(String)obj.get("TIPO"),Codigo=(String)obj.get("CODIGO");
      
      Object  costoc = (Object) obj.get("COSTO"),costov = (Object) obj.get("PRECIO");
     
     BasicDBObject qty = (BasicDBObject) obj.get("STOCK");
     Object  cantidad = (Object) qty.get("ACTUAL"),cantidad1 = (Object) qty.get("MINIMO");
     
              
       try
       {
      double i= (double) cantidad;
      double k= (double) cantidad1;
       if(i<= k){
            String Stock="Reponer";
            model.addRow(new Object[] { item,Codigo,Tipo,costoc,costov,Stock});
            reponer=false;
                }
       else
       {
           String Stock="Suficiente";
           model.addRow(new Object[] { item,Codigo,Tipo,costoc,costov,Stock});
       }
      }
      catch(Exception e)
      { 
          String Stock="Sin Informacion";
            model.addRow(new Object[] { item,Codigo,Tipo,costoc,costov,Stock});
      }        

   }
   if(reponer==false)
           {
               
              JOptionPane.showMessageDialog(null, "Atención hay artículos que necesitan reposición","¡¡ATENCIÓN!!",JOptionPane.WARNING_MESSAGE);
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
} 
catch(Exception e)
        {
            System.out.println(e.getMessage());
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
       JFrame obj=new AgregarFlexible();
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
