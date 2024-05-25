/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import Conexion.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import vista.RealizarCompra;

public class ControladorPDF {
    private String nombreCliente;
    private String telefonoCliente;
    private String direccion;

    private String fechaActual = "";
    private String nombreArchivoPDFVenta = "";

    // método para obtener datos del cliente
    public void DatosCliente(int idCliente) {
        Connection cn = Conexion.conectar();
        String sql = "select * from Clientes where idCliente = '" + idCliente + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                nombreCliente = rs.getString("nombre") + " " + rs.getString("apellido");
                ;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente: " + e);
        }
    }

    // método para generar la factura de venta
    public void generarFacturaPDF() {
        try {
            // cargar la fecha actual
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            // cambiar el formato de la fecha de / a _
            String fechaNueva = fechaActual.replace("/", "_");

            nombreArchivoPDFVenta = "Venta_" + (nombreCliente != null ? nombreCliente : "null") + "_" + fechaNueva + ".pdf";

            // obtener la ruta del escritorio del usuario
            String ruta = System.getProperty("user.home") + "/Desktop/" + nombreArchivoPDFVenta;

            FileOutputStream archivo;
            File file = new File(ruta);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE); // agregar nueva línea
            fecha.add("Factura: 001" + "\nFecha: " + fechaActual + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0); // quitar el borde de la tabla
            // tamaño de las celdas
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            // agregar celdas

            String ruc = "0987654321001";
            String nombre = "Abarrotes Tizimin";
            String telefono = "9843168587";
            String direccion = "Tizimin, Yucatan. ";
            String razon = "La magia de la programación, está en el poder de tu imaginación";

            Encabezado.addCell(""); // celda vacía
            Encabezado.addCell("RUC: " + ruc + "\nNOMBRE: " + nombre + "\nTELÉFONO: " + telefono);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            // CUERPO
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE); // nueva línea
            cliente.add("Datos del cliente: " + "\n\n");
            doc.add(cliente);

            // DATOS DEL CLIENTE
            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0); // quitar bordes
            // tamaño de las celdas
            float[] ColumnaCliente = new float[]{25f, 45f, 30f, 40f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("Cédula/RUC: ", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Teléfono: ", negrita));
            PdfPCell cliente4 = new PdfPCell(new Phrase("Dirección: ", negrita));
            // quitar bordes
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);
            // agregar celda a la tabla
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(cliente4);

            tablaCliente.addCell(nombreCliente != null ? nombreCliente : "");
            tablaCliente.addCell(telefonoCliente != null ? telefonoCliente : "");
            tablaCliente.addCell(direccion != null ? direccion : "");

            // agregar al documento
            doc.add(tablaCliente);

            // ESPACIO EN BLANCO
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            // AGREGAR LOS PRODUCTOS
            PdfPTable tablaProducto = new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            // tamaño de celdas
            float[] ColumnaProducto = new float[]{15f, 50f, 15f, 20f};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio Unitario: ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Precio Total: ", negrita));
            // quitar bordes
            producto1.setBorder(0);
            
            producto3.setBorder(0);
            producto4.setBorder(0);
            // agregar color al encabezado del producto
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
           
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            // agregar celda a la tabla
            tablaProducto.addCell(producto1);
            
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);

            for (int i = 0; i < RealizarCompra.tablaProductos.getRowCount(); i++) {
                String producto = RealizarCompra.tablaProductos.getValueAt(i, 1).toString();
                String cantidad = RealizarCompra.tablaProductos.getValueAt(i, 2).toString();
                String precio = RealizarCompra.tablaProductos.getValueAt(i, 3).toString();
                String total = RealizarCompra.tablaProductos.getValueAt(i, 7).toString();

                tablaProducto.addCell(cantidad);
                tablaProducto.addCell(producto);
                tablaProducto.addCell(precio);
                tablaProducto.addCell(total);
            }

            // agregar al documento
            doc.add(tablaProducto);

            // Total a pagar
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: " + RealizarCompra.TextTotal.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            // Firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelación y firma\n\n");
            firma.add("_______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            // Mensaje
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("¡Gracias por su compra!");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            // cerrar el documento y el archivo
            doc.close();
            archivo.close();

            // abrir el documento al finalizar
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            }

        } catch (DocumentException | IOException e) {
            System.out.println("Error al generar la factura PDF: " + e);
        }
    }
}
