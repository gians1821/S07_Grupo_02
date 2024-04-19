package entidades;

public class ADestajo extends Empleado implements Descuentos {
  public static final int TAM = 10;
  public static final float COMISION = 0.20f;
  private Venta[] listaVentas;
  private int posicion;
  
  public ADestajo() {
    super();
    listaVentas = new Venta[TAM];
    posicion = -1;
  }

  public ADestajo(String dni, String nombre, String apellido, String genero, float salario, Fecha fechaNacimiento, Fecha fechaIngreso) {
    super(dni, nombre, apellido, genero, salario, fechaNacimiento, fechaIngreso);
    listaVentas = new Venta[TAM];
    posicion = -1;
  }
  
  public void setVenta(Venta venta) {
    posicion++;
    listaVentas[posicion] = venta;
  }
  
  public int getPosicion() {
    return posicion;
  }
  
  public Venta getVenta(int pos) {
    if (pos < 0 || pos > getPosicion()) 
      return null;
    return listaVentas[pos];
  }
  
  public float getMontoTotalVentas() {
    float montoTotalVentas = 0;
    for (int i = 0; i <= posicion; i++) {
      montoTotalVentas += listaVentas[posicion].getMontoVenta();
    }
    return montoTotalVentas;
  }
  
  public float getMontoComision() {
    return getMontoTotalVentas() * COMISION;
  }
  
  public float getSueldoNeto() {
    return getSalario() + getMontoComision() - (nroFaltas * getDescuentoPorFaltas()) - (nroTardanzas * getDescuentoPorTardanzas());
  }
  
  public String getListadoVentas() {
    String contenido = "";
    for (int i = 0; i <= posicion; i++)
      contenido += "\nVENTA " + (i+1) + ":" + listaVentas[i] + "\n";
    return contenido;
  }

  @Override
  public String toString() {
    return super.toString() + 
            "\nMonto total de ventas: " + getMontoTotalVentas() +
            "\nMonto comision: " + getMontoComision() +
            "\nDescuento por faltas: " + (nroFaltas * getDescuentoPorFaltas()) +
            "\nDescuento por tardanzas: " + (nroTardanzas * getDescuentoPorTardanzas()) +
            "\nSueldo neto: " + getSueldoNeto();
  }

  @Override
  public float getDescuentoPorFaltas() {
    return 0.05f * SBASICO;
  }

  @Override
  public float getDescuentoPorTardanzas() {
    return 0.01f * SBASICO;
  }
}
