/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdr.sdr;

import com.mongodb.BasicDBList;
import com.mongodb.Block;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import static com.sdr.sdr.Login.fecha;
import static com.sdr.sdr.Main.db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author Jaime Andres
 */
public class Ventas extends javax.swing.JFrame {
public double precio;
    /**
     * Creates new form Ventas
     */
    public Ventas() {
        initComponents();
        setLocationRelativeTo(null);
        llenar();

        
         addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                INVENTARIO n=new INVENTARIO();
                n.setVisible(true);
                
            }
        });
         jLabel16.setText(fecha);
        Timer tiempo=new Timer(100,new Ventas.hora());
        tiempo.start();
        
        
        
    }
    
    class hora implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            Date hora=new Date();
            String pmam="hh:mm:ss a";
            SimpleDateFormat format=new SimpleDateFormat(pmam);
            Calendar hoy=Calendar.getInstance();
            jLabel17.setText(String.format(format.format(hora),hoy));
        }
        
    }
    void recuperarDatos(String codigo) {
        FindIterable<Document> iterable = db.getCollection("productos").find(new Document("CODIGO", codigo));
        // Iterate the results and apply a block to each resulting document.
        // Iteramos los resultados y aplicacimos un bloque para cada documento.
        iterable.forEach(new Block<Document>() {
            @Override
            
            
            public void apply(final Document document) {
                txtproducto.setText((String) document.get("ARTICULO"));    
                txtcodigo.setText((String) document.get("CODIGO"));
                Document qty = (Document) document.get("STOCK");                
                double act = (double) qty.get("ACTUAL");
                int actual = (int) act;              
                txtactual.setText("" + actual);
                precio = (double) document.get("PRECIO");
                txtprecio.setText("" + precio);
          
           }
            
            
        });
    }
    public void busca() {

        //Metodo para hacer busquedas
        MongoCollection<Document> coll = db.getCollection("productos");
        Document filtro = new Document(); //si se realiza consulta con foltro se hace este objeto
        String j = txtbusca.getText();
        filtro = new Document("ARTICULO", new Document("$regex", j));//pones el filtro que se requiera
        MongoCursor<Document> cursor = coll.find(filtro).iterator();
        DefaultTableModel model = Main.tabla1();

         try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();

                String item = (String) doc.get("ARTICULO"),Codigo = (String) doc.get("CODIGO");

                Object costov = (Object) doc.get("PRECIO");
                Document qty = (Document) doc.get("STOCK");
                Object cantidad = (Object) qty.get("ACTUAL");
                
                model.addRow(new Object[]{item, Codigo,costov,cantidad});
            }
            
            table.setModel(model);
            //Esre bloque de comentarios hace que sucedan algunos errores y hace que no cargue bien la interfaz
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
    }
public void llenar() {

        MongoCollection<Document> coll = db.getCollection("productos");
        MongoCursor<Document> cursor = coll.find().iterator();
        DefaultTableModel model = Main.tabla1();

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();

                String item = (String) doc.get("ARTICULO"),Codigo = (String) doc.get("CODIGO");

                Object costov = (Object) doc.get("PRECIO");
                Document qty = (Document) doc.get("STOCK");
                Object cantidad = (Object) qty.get("ACTUAL");
                
                model.addRow(new Object[]{item, Codigo,costov,cantidad});
            }
            
            table.setModel(model);
            //Esre bloque de comentarios hace que sucedan algunos errores y hace que no cargue bien la interfaz
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
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

        txtbusca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtproducto = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        txtactual = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscaKeyReleased(evt);
            }
        });
        getContentPane().add(txtbusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 246, -1));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 395));

        jLabel1.setText("Producto:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 65, -1, -1));

        jLabel2.setText("Precio:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 91, -1, -1));

        jLabel3.setText("Codigo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 117, -1, -1));

        jLabel8.setText("Stock:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        jLabel9.setText("Cantidad:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });
        getContentPane().add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 150, -1));

        jButton2.setText("realizar venta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 100, -1));

        jButton3.setText("Entrada");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 100, -1));

        jButton5.setText("INVENTARIO");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, -1, -1));

        jButton6.setText("AGREGAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 95, -1));
        getContentPane().add(txtproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 65, 160, -1));
        getContentPane().add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 91, 160, -1));
        getContentPane().add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 117, 160, 25));
        getContentPane().add(txtactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 150, 150, -1));

        jLabel12.setText("jLabel12");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("VENTAS");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

        jLabel15.setText("Total:     $");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 60, -1));
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 150, 30));

        jLabel16.setText("jLabel5");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, 120, 20));

        jLabel17.setText("jLabel6");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 110, 20));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sdr5.png"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
       try {
            int row = table.getSelectedRow();
            String codigo = table.getValueAt(row, 1).toString();
            
            recuperarDatos(codigo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla por favor", "ERROR !!!!", JOptionPane.ERROR_MESSAGE);
        } 
       txtcantidad.setText("");
       txttotal.setText("");
       txtprecio.setEditable(false);
        txtactual.setEditable(false);
        txtcodigo.setEditable(false);
        txtproducto.setEditable(false);
        txttotal.setEditable(false);
// TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

    private void txtcantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyReleased
        try
        { 
        double cantiad =Double.parseDouble(txtcantidad.getText());  
        if(cantiad<1.0)
        {
            cantiad=0.0;
            double total =((precio)*(cantiad));
            txttotal.setText(""+total);   }
        else
        {
            double total =((precio)*(cantiad));
            txttotal.setText(""+total);   
        }
        }
catch(Exception e)
{
    txttotal.setText(""); 
}// TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadKeyReleased

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != KeyEvent.VK_BACK_SPACE)
                ) {
            evt.consume();
            getToolkit().beep();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if("".equals(txtproducto.getText()))
        {
            JOptionPane.showMessageDialog(null, "Seleccione un producto de la tabla para poder realizar la venta");
        }
        else{
        try{
        MongoCollection<Document> collection = db.getCollection("productos");
        double actual =Double.parseDouble(txtactual.getText());
        double cantidad =Double.parseDouble(txtcantidad.getText());
        Document documento = new Document();
        documento.put("Cantidad", txtproducto.getText().trim().toUpperCase());
        documento.put("Codigo", txtcodigo.getText().trim().toUpperCase());
        Document movimiento = new Document();
        movimiento.put("Entrada", 1.0);
        movimiento.put("Salida", 0.0);
        documento.put("TotalMercancia", Double.parseDouble(txtcantidad.getText()));
        documento.put("TotalPrecio", Double.parseDouble(txttotal.getText()));
        documento.put("FechaMov", new Date());
        documento.put("TipoMov", movimiento);
        db.getCollection("movimientos").insertOne(documento);
        collection.updateOne(Filters.eq("CODIGO",txtcodigo.getText()),Updates.set("STOCK.ACTUAL",actual-=cantidad));
        JOptionPane.showMessageDialog(null, "Producto registrado exitosamente");
        llenar();
        }
catch(Exception e)
{
    JOptionPane.showMessageDialog(null, "Seleccione un producto de la tabla para poder realizar la venta");
}
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtbuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscaKeyPressed

    private void txtbuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscaKeyReleased
if (!Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
        txtbusca.setText(txtbusca.getText().toUpperCase());
        busca();        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        txtbusca.setText(txtbusca.getText().toUpperCase());
        busca();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        
        try{
        MongoCollection<Document> collection = db.getCollection("productos");
        double actual =Double.parseDouble(txtactual.getText());
        double cantidad =Double.parseDouble(txtcantidad.getText());
        Document documento = new Document();
        documento.put("Cantidad", txtproducto.getText().trim().toUpperCase());
        documento.put("Codigo", txtcodigo.getText().trim().toUpperCase());
        Document movimiento = new Document();
        movimiento.put("Entrada", 0.0);
        movimiento.put("Salida", 1.0);
        documento.put("TotalMercancia", Double.parseDouble(txtcantidad.getText()));
        documento.put("TotalPrecio", Double.parseDouble(txttotal.getText()));
        documento.put("FechaMov", new Date());
        documento.put("TipoMov", movimiento);
        db.getCollection("movimientos").insertOne(documento);
        collection.updateOne(Filters.eq("CODIGO",txtcodigo.getText()),Updates.set("STOCK.ACTUAL",actual+=cantidad));
        JOptionPane.showMessageDialog(null, "Producto registrado exitosamente");
        llenar();
        }
catch(Exception e)
{
    JOptionPane.showMessageDialog(null, "Seleccione un producto de la tabla para poder realizar la venta");
    
}
               // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
INVENTARIO c= new INVENTARIO();
c.setVisible(true);
dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
Agregar c = new Agregar();
        c.setVisible(true);
dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtactual;
    private javax.swing.JTextField txtbusca;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtproducto;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
