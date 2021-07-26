/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luis
 */

public class ConectorBD {
   
    private static final String HOST = "localhost";
    private static final String BD = "cac-tp-final";
    private static final String URL = "jdbc:mysql://" +HOST+"/"+BD+"?autoReconnect=true&useSSL=false";
    private static final String USUARIO = "root";
    private static final String CLAVE = "123456";
    
    private static ConectorBD instance;
    
    private ConectorBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e) {
            System.err.println("Error en carga del controlador");
        } 
    }
    
    public static ConectorBD getInstance(){
        if(instance == null)
            instance = new ConectorBD();
        return instance;
    }
    
    public Connection conectar() throws SQLException{
        Connection conn;
	conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
	return conn;
    }
    
    
}
