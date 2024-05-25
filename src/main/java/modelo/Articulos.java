/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.sql.SQLException;
import javax.swing.JTextField;

/**
 *
 * @author BLANC-ITZ
 */
public interface Articulos {
    public void InsertarArticulo(JTextField paramId,JTextField paramNombres, JTextField paramPrecioPublico, JTextField paramPrecioProveedor, JTextField paramInventario);
    public void ModificarArticulo(JTextField paramId, JTextField paramNombres, JTextField paramPrecioPublico, JTextField paramPrecioProveedor, JTextField paramInventario) ;
    public void EliminarArticulo(JTextField paramId) throws SQLException;
}
