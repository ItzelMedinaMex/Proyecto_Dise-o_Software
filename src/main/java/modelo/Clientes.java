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
public interface Clientes {
    public void InsertarCliente(JTextField paramId,JTextField paramNombres, JTextField paramApellidos, JTextField paramCalle, JTextField paramNumero, JTextField paramColonia, JTextField paramCp, JTextField paramEstado, JTextField paramCiudad, JTextField paramTelefono);
    public void ModificarCliente(JTextField paramId,JTextField paramNombres, JTextField paramApellidos,JTextField paramCalle, JTextField paramNumero,JTextField paramColonia, JTextField paramCp, JTextField paramEstado, JTextField paramCiudad, JTextField paramTelefono);
    public void EliminarClientes(JTextField paramId) throws SQLException;
}
