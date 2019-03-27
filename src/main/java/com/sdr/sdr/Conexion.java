/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdr.sdr;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david
 */
public class Conexion {
    
    public DBCollection conexion(){
        MongoClient conexion =  new MongoClient();
     DB db = conexion.getDB( "SDR" );
     DBCollection coll = (DBCollection) db.getCollection("productos");
      return coll;
    }
    
    public DefaultTableModel tabla(){
        String[] columnNames = {"Articulo", "Descripcion", "Cantidad"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0){
            @Override
            public boolean isCellEditable(int fil, int col) {
                if(col==3){
                    return true;
                }else{
                    return false;
                }
            }
        
        };
        
        return model;
    }
    
    
}
