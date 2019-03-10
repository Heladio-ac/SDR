package com.sdr.sdr;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Main {
    
    public static MongoDatabase db;
    
    public static void main(String[] args) {
        MongoClient conexion =  new MongoClient();
        db = conexion.getDatabase("MetalStorm");
    }
}
