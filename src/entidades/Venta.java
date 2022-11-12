package entidades;

public class Venta {
  private String nroDocumento;
  private Fecha fechaVenta;
  private Cliente cliente;
  private float montoVenta;
  private static int contador = 0;

  public Venta() {
    this("000-0", new Fecha(), new Cliente(), 0.0f);
  }

  public Venta(String nroDocumento, Fecha fechaVenta, Cliente cliente, float montoVenta) {
    this.nroDocumento = nroDocumento;
    this.fechaVenta = fechaVenta;
    this.cliente = cliente;
    this.montoVenta = montoVenta;
    contador++;
  }

  public void setFechaVenta(Fecha fechaVenta) {
    this.fechaVenta = fechaVenta;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public void setMontoVenta(float montoVenta) {
    this.montoVenta = montoVenta;
  }

  public String getNroDocumento() {
    return nroDocumento;
  }

  public Fecha getFechaVenta() {
    return fechaVenta;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public float getMontoVenta() {
    return montoVenta;
  }

  public static int getContador() {
    return contador;
  }

  @Override
  public String toString() {
    return "\nNumero de Documento: " + getNroDocumento() +
            "\nFecha de Venta: " + getFechaVenta() +
            "\nDatos del cliente: " + getCliente().toString() +
            "\nMonto de venta: " + getMontoVenta();
  }
}
