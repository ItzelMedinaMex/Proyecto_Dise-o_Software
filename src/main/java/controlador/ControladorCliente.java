/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Cliente;
import modelo.Direccion;


public class ControladorCliente {
    public void InsertarCliente(JTextField paramId,JTextField paramNombres, JTextField paramApellidos, JTextField paramCalle, JTextField paramNumero, JTextField paramColonia, JTextField paramCp, JTextField paramEstado, JTextField paramCiudad, JTextField paramTelefono){
        Cliente varCliente = new Cliente();
        Direccion varDireccion = new Direccion();
        
        int id = Integer.parseInt(paramId.getText());
        varCliente.setId(id);
        
        varCliente.setNombreCliente(paramNombres.getText());
        varCliente.setApellidoPaterno(paramApellidos.getText());
        
        varDireccion.setCalle(paramCalle.getText());
        
        int numero = Integer.parseInt(paramNumero.getText());
        varDireccion.setNumero(numero);
        
        varDireccion.setColonia(paramColonia.getText());
        
        int cp = Integer.parseInt(paramCp.getText());
        varDireccion.setCp(cp);
        
        varDireccion.setEstado(paramEstado.getText());
        
        varDireccion.setCiudad(paramCiudad.getText());
        
        Long telefono = Long.parseLong(paramTelefono.getText());
        varDireccion.setTelefono(telefono);
        
        
        Conexion objetoConexion = new Conexion();
        String consulta = ("insert into Clientes (id, nombres, apellidos, calle, numero, colonia, cp,estado, ciudad,  telefono) values (?, ?, ?, ?, ?, ?, ?,?, ?, ?);");
        
        try{
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
            cs.setInt(1, varCliente.getId());
            cs.setString(2, varCliente.getNombreCliente());
            cs.setString(3, varCliente.getApellidoPaterno());
            
            cs.setString(4, varDireccion.getCalle());
            cs.setInt(5, varDireccion.getNumero());
            cs.setString(6, varDireccion.getColonia());
            cs.setInt(7, varDireccion.getCp());
            cs.setString(8, varDireccion.getEstado());
            cs.setString(9, varDireccion.getCiudad());
            cs.setLong(10, (long) varDireccion.getTelefono());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se incertó correctamente el Cliente");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se incertó correctamente el Cliente"+e.toString());
        }
    }
    
    public void MostrarClientes(JTable paramTablaTotalClientes){
        Conexion objetoConexion = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        paramTablaTotalClientes.setRowSorter(OrdenarTabla);
        
        String sql="";
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        
        modelo.addColumn("Calle");
        modelo.addColumn("Numero");
        modelo.addColumn("Colonia");
        
        modelo.addColumn("CP");
        modelo.addColumn("Estado");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Telefono");
        
        paramTablaTotalClientes.setModel(modelo);
        
        sql = "select * from Clientes;";
        
        String[] datos = new String[11];
        Statement st;
        
        try{
            st = objetoConexion.estableceConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                datos[9]=rs.getString(10);
                
                modelo.addRow(datos);
            }
            paramTablaTotalClientes.setModel(modelo);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros"+e.toString());
        }
    }
    
}
