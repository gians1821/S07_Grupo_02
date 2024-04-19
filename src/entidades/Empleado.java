package entidades;

public class Empleado {
  private String dni;
  private String nombre;
  private String apellido;
  private String genero;
  private float salario;
  private Fecha fechaNacimiento;
  private Fecha fechaIngreso;
  protected int nroFaltas = 0;
  protected int nroTardanzas = 0;

  public Empleado() {
    dni = "00000000";
    nombre = "NN";
    apellido = "NA";
    genero = "NG";
    salario = 0.0f;
    fechaNacimiento = new Fecha();
    fechaIngreso = new Fecha();
  }

  public Empleado(String dni, String nombre, String apellido, String genero, float salario, Fecha fechaNacimiento, Fecha fechaIngreso) {
    this.dni = dni;
    this.nombre = nombre;
    this.apellido = apellido;
    this.genero = genero;
    this.salario = salario;
    this.fechaNacimiento = fechaNacimiento;
    this.fechaIngreso = fechaIngreso;
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

  public void setGenero(String genero) {
    this.genero = genero;
  }    

  public void setSalario(float salario) {
    this.salario = salario;
  }

  public void setFechaNacimiento(Fecha fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public void setFechaIngreso(Fecha fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }

  public void setNroFaltas(int nroFaltas) {
    this.nroFaltas = nroFaltas;
  }

  public void setNroTardanzas(int nroTardanzas) {
    this.nroTardanzas = nroTardanzas;
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

  public String getGenero() {
    return genero;
  }

  public float getSalario() {
    return salario;
  }

  public Fecha getFechaNacimiento() {
    return fechaNacimiento;     
  }

  public Fecha getFechaIngreso() {
    return fechaIngreso;
  }

  public int getEdad(Fecha fechaActual) {
    return fechaActual.getAño() - fechaNacimiento.getAño();
  }

  public int getAntiguedad(Fecha fechaActual) {
    return fechaActual.getAño() - fechaIngreso.getAño();
  }

  public int getNroFaltas() {
    return nroFaltas;
  }

  public int getNroTardanzas() {
    return nroTardanzas;
  }

  @Override
  public String toString() {
    return "\nNumero de DNI: " + getDni() +
            "\nApellidos y Nombres: " + getApellido() + ", " + getNombre() + 
            "\nGenero: " + getGenero() +
            "\nFecha de nacimiento: " + getFechaNacimiento().toString() +
            "\nSalario mensual: " + getSalario() +
            "\nFecha de ingreso: " + getFechaIngreso().toString() +
            "\nNro de faltas: " + getNroFaltas() +
            "\nNro de tardanzas: " + getNroTardanzas();
  }    
}