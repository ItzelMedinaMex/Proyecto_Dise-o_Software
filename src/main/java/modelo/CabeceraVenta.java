
package modelo;

/**
 *
 * @author BLANC-ITZ
 */
public class CabeceraVenta {
    //Atributos
    private int idCabeceraVenta;
    private int idCliente;
    private double valorPagar;
    private String fechaVenta;
    private int Estado;

    
    //constructor
    public CabeceraVenta(){
        this.idCabeceraVenta = 0;
        this.idCliente = 0;
        this.valorPagar = 0.0;
        this.fechaVenta = "";
        this.Estado = 0;
    }
    
    //constructor sobrecargado
    public CabeceraVenta(int idCabeceraVenta, int idCliente, double valorPagar, String fechaVenta, int Estado) {
        this.idCabeceraVenta = idCabeceraVenta;
        this.idCliente = idCliente;
        this.valorPagar = valorPagar;
        this.fechaVenta = fechaVenta;
        this.Estado = Estado;
    }

    //getter y setter
    public int getIdCabeceraVenta() {
        return idCabeceraVenta;
    }

    public void setIdCabeceraVenta(int idCabeceraVenta) {
        this.idCabeceraVenta = idCabeceraVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    //toString
    @Override
    public String toString() {
        return "CabeceraVenta{" + "idCabeceraVenta=" + idCabeceraVenta + ", idCliente=" + idCliente + ", valorPagar=" + valorPagar + ", fechaVenta=" + fechaVenta + ", Estado=" + Estado + '}';
    }

}
