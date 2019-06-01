package com.sdr.sdr;

import com.mongodb.BasicDBList;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Accumulators.addToSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import static com.sdr.sdr.Main.db;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JFrame;
import org.bson.Document;
import org.springframework.cache.annotation.Cacheable;

/**
 *
 * @author Heladio
 */
public class Agregar extends javax.swing.JFrame {

    public static final int TOLERANCIA = 2;

    private Map<String, List<String>> datos;

    public Agregar() {
        initComponents();
        setLocationRelativeTo(null);
         addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                INVENTARIO n=new INVENTARIO();
                n.setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtArticulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtInformacion = new javax.swing.JTextArea();
        BtnAceptar = new javax.swing.JButton();
        TxtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtStockMin = new javax.swing.JTextField();
        TxtTipo = new javax.swing.JTextField();
        TxtStockActual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtCosto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtPrecio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Artículo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));
        getContentPane().add(TxtArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 420, -1));

        jLabel2.setText("Información:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        TxtInformacion.setColumns(20);
        TxtInformacion.setRows(5);
        jScrollPane1.setViewportView(TxtInformacion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 420, 225));

        BtnAceptar.setText("Aceptar");
        BtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 182, -1));
        getContentPane().add(TxtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 420, -1));

        jLabel3.setText("Código:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel4.setText("Tipo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel5.setText("Stock mínimo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel6.setText("Stock actual:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        TxtStockMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtStockMinKeyTyped(evt);
            }
        });
        getContentPane().add(TxtStockMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 420, -1));
        getContentPane().add(TxtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 420, -1));

        TxtStockActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtStockActualKeyTyped(evt);
            }
        });
        getContentPane().add(TxtStockActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 420, -1));

        jLabel7.setText("Costo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        TxtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCostoKeyTyped(evt);
            }
        });
        getContentPane().add(TxtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 151, -1));

        jLabel8.setText("Precio de venta:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        TxtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPrecioKeyTyped(evt);
            }
        });
        getContentPane().add(TxtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 162, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("AGREGAR");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SDR3.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Media/flame.png"));


        return retValue;
}*/
    private void BtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarActionPerformed
        if (!valido()) {
            return;
        }
        datos = new HashMap<>();
        if (!TxtInformacion.getText().isEmpty()) {
            String[] keyValue;
            List<String> values;
            datos = new HashMap<>();
            //Agregar Datos de información
            for (String line : TxtInformacion.getText().split("\\R")) {
                if (!line.contains(":")) {
                    JOptionPane.showMessageDialog(null, "Información redactada incorrectamente\n"
                            + "Asegúrese de separar las características de su valor\n"
                            + "Ejemplo 1 - característica : valor\n"
                            + "Ejemplo 2 - característica : valor, valor, valor, ...", "Atención",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                keyValue = line.split(":");
                values = new ArrayList<>();
                if (keyValue[1].contains(",")) {
                    for (String value : keyValue[1].split(",")) {
                        if (!value.trim().isEmpty()) {
                            values.add(value.trim().toUpperCase());
                        }
                    }
                } else if (!keyValue[1].trim().isEmpty()) {
                    values.add(keyValue[1].trim().toUpperCase());
                }
                datos.put(keyValue[0].trim().toUpperCase(), values);
            }
        }
        limpiar(datos);
        agregar(datos);
        this.dispose();
        INVENTARIO obj = new INVENTARIO();
        obj.setVisible(true);
    }//GEN-LAST:event_BtnAceptarActionPerformed

    private void TxtStockMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtStockMinKeyTyped
        char caracter = evt.getKeyChar();
        if (caracter < '0' || caracter > '9') {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_TxtStockMinKeyTyped

    private void TxtStockActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtStockActualKeyTyped
        char caracter = evt.getKeyChar();
        if (caracter < '0' || caracter > '9') {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_TxtStockActualKeyTyped

    private void TxtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCostoKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter != '.' || TxtCosto.getText().contains("."))) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_TxtCostoKeyTyped

    private void TxtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPrecioKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter != '.' || TxtPrecio.getText().contains("."))) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_TxtPrecioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JTextField TxtArticulo;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtCosto;
    private javax.swing.JTextArea TxtInformacion;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JTextField TxtStockActual;
    private javax.swing.JTextField TxtStockMin;
    private javax.swing.JTextField TxtTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void agregar(Map<String, List<String>> datos) {
        
        Document documento = new Document();
        documento.put("ARTICULO", TxtArticulo.getText().trim().toUpperCase());
        documento.put("CODIGO", TxtCodigo.getText().trim().toUpperCase());
        documento.put("TIPO", TxtTipo.getText().trim().toUpperCase());
        documento.put("PRECIO", Double.parseDouble(TxtPrecio.getText()));
        documento.put("COSTO", Double.parseDouble(TxtCosto.getText()));
        Document stock = new Document();
        stock.put("MINIMO", Double.parseDouble(TxtStockMin.getText()));
        stock.put("ACTUAL", Double.parseDouble(TxtStockActual.getText()));
        documento.put("STOCK", stock);
        datos.forEach((key, values) -> {
            if (values.size() == 1) {
                documento.put(key, values.get(0));
            } else {
                BasicDBList lista = new BasicDBList();
                lista.addAll(values);
                documento.put(key, lista);
            }
        });
        db.getCollection("productos").insertOne(documento);
        JOptionPane.showMessageDialog(null, "Producto registrado exitosamente");

    }

    private boolean valido() {
        if (TxtArticulo.getText().isEmpty()
                || TxtCodigo.getText().isEmpty()
                || TxtTipo.getText().isEmpty()
                || TxtStockMin.getText().isEmpty()
                || TxtStockActual.getText().isEmpty()
                || TxtCosto.getText().isEmpty()
                || TxtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Registre la información necesaria");
            return false;
        } else {
            try {
                double costo = Double.parseDouble(TxtCosto.getText());
                double precio = Double.parseDouble(TxtPrecio.getText());
                double minimo = Double.parseDouble(TxtStockMin.getText());
                double actual = Double.parseDouble(TxtStockActual.getText());
                if (costo < 0 || precio < 0 || minimo < 0 || actual < 0) {
                    JOptionPane.showMessageDialog(null, "Introduzca valores válidos para precio, costo y stock");
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Introduzca valores válidos para precio, costo y stock");
                return false;
            }
        }
        return true;
    }

    private void limpiar(Map<String, List<String>> datos) {
        //Ajustar llaves para coincidir con llaves existentes
        //Obtener los campos existentes
        MongoCollection<Document> productos = db.getCollection("productos");
        AggregateIterable<Document> resultado = productos.aggregate(Arrays.asList(
                project(new Document("keyValues", new Document("$objectToArray", "$$ROOT"))),
                unwind("$keyValues"),
                group(null, addToSet("keys", "$keyValues.k")),
                unwind("$keys")
        ));
        List<String> keys = new ArrayList<>();
        for (Document doc : resultado) {
            String key = (String) doc.get("keys");
            if (!key.equals("_id")) {
                keys.add((String) doc.get("keys"));
            }
        }
        //Calcular distancia de Levenshtein
        Map<String, String> cambios = new HashMap<>();
        datos.forEach((llaveNueva, valor) -> {
            keys.forEach(llave -> {
                int distancia = Levenshtein(llaveNueva, llave);
                if (distancia > 0 && distancia <= TOLERANCIA) {
                    //Almacenar los posibles errores con su candidato
                    cambios.put(llaveNueva, llave);
                }
            });
        });
        //Cambiar llaves que se encuentren a una determinada distancia de las llaves existentes
        cambios.forEach((nuevo, correcto) -> {
            //Preguntar por cada posible intercambio para evitar errores
            if (JOptionPane.showConfirmDialog(null, "Usted escribió: " + nuevo
                    + "\n¿No quiso decir \"" + correcto + "\"?") == JOptionPane.YES_OPTION) {
                datos.put(correcto, datos.remove(nuevo));
            }
        });
    }

    @Cacheable("distances")
    public static int Levenshtein(String a, String b) {
        int Na = a.length();
        int Nb = b.length();
        int[][] d = new int[Na + 1][Nb + 1];

        for (int i = 1; i <= Na; i++) {
            d[i][0] = i;
        }
        for (int j = 1; j <= Nb; j++) {
            d[0][j] = j;
        }
        int costo;
        for (int j = 1; j <= Nb; j++) {
            for (int i = 1; i <= Na; i++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    costo = 0;
                } else {
                    costo = 1;
                }
                d[i][j] = min(d[i - 1][j] + 1,
                        d[i][j - 1] + 1,
                        d[i - 1][j - 1] + costo);
            }
        }
        return d[Na][Nb];
    }

    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
