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
        String consulta = ("insert into articulos (id, nombres, precioPublico, precioProveedor, inventario) values (?, ?, ?, ?, ?);");
        
        try{
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            
            cs.setInt(1, id);
            cs.setString(2, a.getNombres());
            cs.setDouble(3, precioPublico);
            cs.setDouble(4, precioProveedor);
            cs.setInt(5, inventario);
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se incertó correctamente el alumno");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se incertó correctamente el alumno"+e.toString());
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

    
}
