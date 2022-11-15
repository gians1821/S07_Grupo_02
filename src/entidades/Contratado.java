package entidades;

import java.util.*;

public class Contratado extends Empleado implements Descuentos {
  public final static float PCTJE3 = 0.05f;
  public final static float PCTJE7 = 0.10f;
  public final static float PCTJE15 = 0.15f;
  public final static float PCTJE16 = 0.20f;
  private float pctjeAdicional;

  public Contratado() {
    super();
    pctjeAdicional = 0.0f;        
  }

  public Contratado(String dni, String nombre, String apellido, int genero, float salario, Fecha fechaNacimiento, Fecha fechaIngreso, float pctjeAdicional) {
    super(dni, nombre, apellido, genero, salario, fechaNacimiento, fechaIngreso);
    setPctjeAdicional();
  }

  public void setPctjeAdicional() {
    GregorianCalendar fechaHoy = new GregorianCalendar();
    int dia, mes, año, añosAntg;
    Fecha fechaActual;
    dia = fechaHoy.get(Calendar.DAY_OF_MONTH);
    mes = fechaHoy.get(Calendar.MONTH)+1;
    año = fechaHoy.get(Calendar.YEAR);
    fechaActual = new Fecha(dia, mes, año);
    añosAntg = getAntiguedad(fechaActual);
    if(añosAntg <= 3)
      pctjeAdicional = PCTJE3;
    else if(añosAntg <= 7)
      pctjeAdicional = PCTJE7;
    else if(añosAntg <= 15)
      pctjeAdicional = PCTJE15;
    else
      pctjeAdicional = PCTJE16;
  }

  public float getPctjeAdicional() {
    return pctjeAdicional;
  }

  public float getMontoAdicional() {
    return getSalario() * getPctjeAdicional();
  }

  public float getSueldoNeto() {
    return getSalario() + getMontoAdicional() - (nroFaltas * getDescuentoPorFaltas()) - (nroTardanzas * getDescuentoPorTardanzas());
  }

  @Override
  public String toString() {
    return super.toString() + "\n% adicional: " + getPctjeAdicional()
            + "\nDescuento por faltas: " + (nroFaltas * getDescuentoPorFaltas())
            + "\nDescuento por tardanzas: " + (nroTardanzas * getDescuentoPorTardanzas())
            + "\nSueldo neto: " + getSueldoNeto();
  }

  @Override
  public float getDescuentoPorFaltas() {
    return 0.07f * SBASICO;
  }

  @Override
  public float getDescuentoPorTardanzas() {
    return 0.03f * SBASICO;
  }
}