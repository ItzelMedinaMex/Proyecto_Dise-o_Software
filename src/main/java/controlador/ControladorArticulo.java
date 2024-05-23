/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Articulo;

/**
 *
 * @author BLANC-ITZ
 */
public class ControladorArticulo{
    
    public void InsertarArticulo(JTextField paramId,JTextField paramNombres, JTextField paramPrecioPublico, JTextField paramPrecioProveedor, JTextField paramInventario){
        
       Articulo a = new Articulo();
       
        int id = Integer.parseInt(paramId.getText());
        a.setId(id);
        
        a.setNombres(paramNombres.getText());
        
        double precioPublico = Double.parseDouble(paramPrecioPublico.getText());
        a.setPrecioPublico(precioPublico);
        
        double precioProveedor = Double.parseDouble(paramPrecioProveedor.getText());
        a.setPrecioProveedor(precioProveedor);
        
        int inventario= Integer.parseInt(paramInventario.getText());
        a.setInventario(inventario);
        
        
        Conexion objetoConexion = new Conexion();
        String consulta = ("insert into articulos (idArticulo, nombresArticulos, precioPublico, precioProveedor, inventario) values (?, ?, ?, ?, ?);");
        
        try{
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
            cs.setInt(1, id);
            cs.setString(2, a.getNombres());
            cs.setDouble(3, precioPublico);
            cs.setDouble(4, precioProveedor);
            cs.setInt(5, inventario);
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se incertó correctamente el articulo");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se incertó correctamente el articulo"+e.toString());
        }
    }

    public void MostrarArticulos(JTable paramTablaTotalArticulo){
        Conexion objetoConexion = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        paramTablaTotalArticulo.setRowSorter(OrdenarTabla);
        
        String sql="";
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombres");
        modelo.addColumn("Precio público");
        modelo.addColumn("Precio proveedor");
        modelo.addColumn("Inventario");
        
        paramTablaTotalArticulo.setModel(modelo);
        
        sql = "select * from articulos;";
        
        String[] datos = new String[6];
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
                
                
                modelo.addRow(datos);
            }
            paramTablaTotalArticulo.setModel(modelo);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los registros"+e.toString());
        }
    }
    public void SeleccionarArticulo(JTable paramTablaArticulos, JTextField paramId, JTextField paramNombres, JTextField paramPrecioPublico, JTextField paramPrecioProveedor, JTextField paramInventario) {
        try {
            int fila = paramTablaArticulos.getSelectedRow();
            if (fila >= 0) {
                paramId.setText((paramTablaArticulos.getValueAt(fila, 0).toString())); // Cambiado de 1 a 0
                paramNombres.setText((String) (paramTablaArticulos.getValueAt(fila, 1))); // Cambiado de 2 a 1
                paramPrecioPublico.setText((paramTablaArticulos.getValueAt(fila, 2).toString())); // Cambiado de 3 a 2
                paramPrecioProveedor.setText((paramTablaArticulos.getValueAt(fila, 3).toString())); // Cambiado de 4 a 3
                paramInventario.setText((paramTablaArticulos.getValueAt(fila, 4).toString())); // Cambiado de 5 a 4
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección" + e.toString());
        }
    }
    public void ModificarArticulo(JTextField paramId, JTextField paramNombres, JTextField paramPrecioPublico, JTextField paramPrecioProveedor, JTextField paramInventario) {


        
        Articulo a = new Articulo();
       
        int id = Integer.parseInt(paramId.getText());
        a.setId(id);
        
        a.setNombres(paramNombres.getText());
        
        double precioPublico = Double.parseDouble(paramPrecioPublico.getText());
        a.setPrecioPublico(precioPublico);
        
        double precioProveedor = Double.parseDouble(paramPrecioProveedor.getText());
        a.setPrecioProveedor(precioProveedor);
        
        int inventario= Integer.parseInt(paramInventario.getText());
        a.setInventario(inventario);

        Conexion objetoConexion = new Conexion();
        String consulta = "UPDATE articulos SET idArticulo = ?, nombresArticulos = ?, precioPublico = ?, precioProveedor = ?, inventario = ? WHERE idArticulo = ?;";

        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1, id);
            cs.setString(2, a.getNombres());
            cs.setDouble(3, precioPublico);
            cs.setDouble(4, precioProveedor);
            cs.setInt(5, inventario);
            cs.setInt(6, id);
         
            cs.execute();
            JOptionPane.showMessageDialog(null, "Modificación exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó, error: " + e.toString());
        }
    }
    
    public void EliminarArticulo(JTextField paramId) throws SQLException{
        Articulo a = new Articulo();
        int id = Integer.parseInt(paramId.getText());
        a.setId(id);
        
        Conexion objetoConexion = new Conexion();
        
        String consulta ="DELETE FROM articulos WHERE articulos.idArticulo=?;";
        
        try{
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1, a.getId());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el Articulo");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo eliminar, error"+e.toString());
        }
    }
    
    
}
