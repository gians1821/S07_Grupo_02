package entidades;

public class Cliente {
  private String dni;
  private String nombre;
  private String apellido;
  
  public Cliente() {
    this("00000000", "NN", "NA");
  }
  
  public Cliente(String dni, String nombre, String apellido) {
    this.dni = dni;
    this.nombre = nombre;
    this.apellido = apellido;
  }
  
  public void setDni(String dni) {
    this.dni = dni;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }
  
  public String getDni() {
    return dni;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  @Override
  public String toString() {
    return "\nNumero de DNI: " + getDni() + 
            "\nApellidos y Nombres: " + getApellido() + ", " + getNombre();
  }
}
