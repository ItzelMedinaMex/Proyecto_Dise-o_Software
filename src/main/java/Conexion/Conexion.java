/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

/**
 *
 * @author BLANC-ITZ
 */

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author BLANC-ITZ
 */
public class Conexion {
    Connection conectar = null;
        
    String usuario  = "root";
    String contrasenia  = "BTStuspatrones03@";
    String bd  = "bdabarrotes_tizimin";
    String ip  = "localhost";
    String puerto  = "3306";
        
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
        
    public Connection estableceConexion(){
                
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
            //JOptionPane.showMessageDialog(null, "La conexión se ha realizado con éxito");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.toString());
        }
         return conectar;
    }
}
