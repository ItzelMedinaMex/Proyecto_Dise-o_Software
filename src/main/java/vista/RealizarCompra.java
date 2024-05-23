/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.DetalleVenta;

/**
 *
 * @author BLANC-ITZ
 */
public class RealizarCompra extends javax.swing.JPanel {

    //modelo de los datos 
    private DefaultTableModel modeloDatosProductos;
    //lista para el detalle de venta de los productos
    ArrayList<DetalleVenta> listaProductos = new ArrayList<>();
    private DetalleVenta producto;
    
    private int idProducto=0;
    private String nombre="";
    private int cantidadProductoBBDD=0;
    private double precioUnitario=0.0;
    
    
    private int cantidadValor = 0; //cantidad de productos a comprar
    private double subtotal =0;
    private double totalValor =0.0;
    
    private int auxIdDetalle=1; //id del detallee venta
    
    /**
     * Creates new form RealizarCompra
     */
    public RealizarCompra() {
        initComponents();
        
        //cargar clientes en la vista
        this.CargarCliente();
        this.CargarArticulos();
        this.InicializarTablaProducto();
        this.DatosDelProducto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComboBoxCliente = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboBoxProducto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        añadir = new javax.swing.JButton();
        cantidad = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TextTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        efectivo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cambio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        ComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Cliente:" }));
        ComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxClienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Cliente:");

        jLabel2.setText("Producto:");

        ComboBoxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Producto:" }));
        ComboBoxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxProductoActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha y Hora:");

        jLabel4.setText("Cantidad:");

        añadir.setText("Añadir");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel5.setText("Total a Pagar:");

        TextTotal.setEnabled(false);

        jLabel6.setText("Efectivo:");

        jLabel7.setText("Cambio:");

        cambio.setEnabled(false);

        jButton1.setText("Calcular cambio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(efectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(efectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(cambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jButton2.setText("Generar Recibo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(345, 345, 345))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ComboBoxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ComboBoxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(añadir))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(ComboBoxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(añadir))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxClienteActionPerformed

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
        String combo = this.ComboBoxProducto.getSelectedItem().toString();
        
        //validar que sellecionó un productor
        
        if(combo.equalsIgnoreCase("Seleccione Articulos:")){
            JOptionPane.showMessageDialog(null, "Seleccione Articulo");
        }
        else{
            //validar que ingrese una cantidad
            if(!cantidad.getText().isEmpty()){
                //validar que el usuario no ingrese valores no numericos
                boolean validacion = validar(cantidad.getText());
                if(validacion == true){
                    //validar que la cantidad sea mayor que cero
                    if(Integer.parseInt(cantidad.getText())>0){
                        cantidadValor = Integer.parseInt(cantidad.getText());
                        
                        //ejecutar metodo para obtener datos del producto
                        this.DatosDelProducto();
                        
                        //Validar la cantidad de producto selleccionado no sea mayor al stock de la base de datos
                        if(cantidadValor<=cantidadProductoBBDD){
                            subtotal = precioUnitario * cantidadValor;
                            totalValor = subtotal;
                            
                            //se crea un nuevo producto
                            producto = new DetalleVenta(auxIdDetalle, 1, idProducto, nombre, Integer.parseInt(cantidad.getText()), precioUnitario,totalValor ,1);
                            
                            //añadir a la lista
                            listaProductos.add(producto);
                            
                            JOptionPane.showMessageDialog(null, "Producto Agregado. ");
                            
                            auxIdDetalle++;
                            cantidad.setText(""); //limpiar el campo
                            //volver a cargar los productos
                            this.CargarArticulos();
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "Cantidad supera al del inventario"+ cantidadProductoBBDD+idProducto);
                        }
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "La cantidad no púede ser cero ni negativa.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "En la cantidad no se admiten caracteres no numericos");
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad");

            }
        }
        //lamar al metodo
        this.listaTablaProductos();
        
       
        
    }//GEN-LAST:event_añadirActionPerformed

    private void ComboBoxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxCliente;
    private javax.swing.JComboBox<String> ComboBoxProducto;
    private javax.swing.JTextField TextTotal;
    private javax.swing.JButton añadir;
    private javax.swing.JTextField cambio;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField efectivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables



/*Metodo para cargar cliente*/
    
    private void CargarCliente(){
         Conexion objetoConexion = new Conexion();
         String sql = "select * from Clientes";
         Statement st;
         
         try{
             st = objetoConexion.estableceConexion().createStatement();
             ResultSet rs = st.executeQuery(sql);
             ComboBoxCliente.removeAllItems();
             ComboBoxCliente.addItem("Seleccione Cliente:");
             while(rs.next()){
                 ComboBoxCliente.addItem(rs.getString("nombres")+" "+rs.getString("apellidos"));
            }
             
             
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "error al cargar clientes"+e.toString());
         }
    }
    
    private void CargarArticulos(){
         Conexion objetoConexion = new Conexion();
         String sql = "select * from articulos";
         Statement st;
         
         try{
             st = objetoConexion.estableceConexion().createStatement();
             ResultSet rs = st.executeQuery(sql);
             ComboBoxProducto.removeAllItems();
             ComboBoxProducto.addItem("Seleccione Articulos:");
             while(rs.next()){
                 ComboBoxProducto.addItem(rs.getString("nombresArticulos"));
            }
             
             
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "error al cargar clientes"+e.toString());
         }
    }
    
    //Metodo para inicializar la tabla de los productos 
    public void InicializarTablaProducto(){
        modeloDatosProductos = new DefaultTableModel();
        
        //añadir comlumnas
        modeloDatosProductos.addColumn("N°");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("P. Unitario");
        modeloDatosProductos.addColumn("Total a Pagar");
        modeloDatosProductos.addColumn("Acción");
        
        //agrgar los datos del modelo a la tabla
        this.tablaProductos.setModel(modeloDatosProductos);
    }
    
    //Mtedoto para presentar información de la tabla
    private void listaTablaProductos(){
        this.modeloDatosProductos.setRowCount(listaProductos.size());
        for(int i=0;i<listaProductos.size(); i++){
            this.modeloDatosProductos.setValueAt(i+1,i,0);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getNombre(),i,1);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getCantidadValor(),i,2);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getPrecioUnitario(),i,3);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getTotalValor(),i,4);
            this.modeloDatosProductos.setValueAt("Eliminar",i,5);
        }
        tablaProductos.setModel(modeloDatosProductos);
    }
    
     //metodo validar que funciona para que el usuario nop ingrese valores distintos a los numericos
    private boolean validar(String valor){
        try{
            int num =Integer.parseInt(valor);
            return (true);
        }catch(NumberFormatException e){
            return (false);
        }
    }  
    
    //Metodo para mostrar los datos del producto
    private void DatosDelProducto(){
        try{
            String sql="select * from articulos where nombresArticulos='"+this.ComboBoxProducto.getSelectedItem()+"'";
            Conexion objetoConexion = new Conexion();
            Statement st;
            st = objetoConexion.estableceConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                idProducto = rs.getInt("idArticulo");
                nombre = rs.getString("nombresArticulos");
                cantidadProductoBBDD= rs.getInt("inventario");
                precioUnitario = rs.getDouble("precioPublico");
                
            }
            
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "error al obtener datos del producto"+e.toString());
        }
    }
}
