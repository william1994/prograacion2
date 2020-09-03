/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.conexionamysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 14-ck0013lab
 */
public class ConexionDB {
    private Connection conexion;
    
    public ConexionDB (){
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/Clase1","root","root");
            System.out.println("Conectado a la BD");
        } catch (Exception e) {
            System.out.println("Error de conexion"+e);
        }
        
    }
    public Connection retornarConexion(){
            
            
            return conexion;
        }
}
