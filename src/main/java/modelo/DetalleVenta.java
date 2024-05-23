
package modelo;

/**
 *
 * @author BLANC-ITZ
 */
public class DetalleVenta {
    
    //Atributos
    private int idDetalleVenta;
    private int idCabeceraVenta;
    private int idProducto;
    
    //lo vamos a utilizar para la base de datos
    private String nombre;
    private int cantidadValor;
    private double precioUnitario;
    private double totalValor;
    private int Estado;

    //constructor
    public DetalleVenta() {
        this.idDetalleVenta = 0;
        this.idCabeceraVenta = 0;
        this.idProducto = 0;
        this.nombre = "";
        this.cantidadValor = 0;
        this.precioUnitario = 0.0;
        this.totalValor = 0.0;
        this.Estado = 0;
    }

    //constructor sobrecargado
    public DetalleVenta(int idDetalleVenta, int idCabeceraVenta, int idProducto, String nombre, int cantidad, double precioUnitario, double total, int Estado) {
        this.idDetalleVenta = idDetalleVenta;
        this.idCabeceraVenta = idCabeceraVenta;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidadValor = cantidad;
        this.precioUnitario = precioUnitario;
        this.totalValor = total;
        this.Estado = Estado;
    }
    
    //get and set

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdCabeceraVenta() {
        return idCabeceraVenta;
    }

    public void setIdCabeceraVenta(int idCabeceraVenta) {
        this.idCabeceraVenta = idCabeceraVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadValor() {
        return cantidadValor;
    }

    public void setCantidadValor(int cantidadValor) {
        this.cantidadValor = cantidadValor;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getTotalValor() {
        return totalValor;
    }

    public void setTotalValor(double totalValor) {
        this.totalValor = totalValor;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
    
    //to String

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", idCabeceraVenta=" + idCabeceraVenta + ", idProducto=" + idProducto + ", nombre=" + nombre + ", cantidad=" + cantidadValor + ", precioUnitario=" + precioUnitario + ", total=" + totalValor + ", Estado=" + Estado + '}';
    }
    
}
