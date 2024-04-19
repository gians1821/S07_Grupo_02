package entidades;

public class Fecha {
  private int dia;
  private int mes;
  private int año;

  public Fecha() {
    dia = 1;
    mes = 1;
    año = 1000;
  }
  
  public Fecha(String fecha) {
      String[] date = fecha.split("-");
      this.dia = Integer.parseInt(date[0]);
      this.mes = Integer.parseInt(date[1]);
      this.año = Integer.parseInt(date[2]);
  }

  public Fecha(int dia, int mes, int año) {
    this.dia = dia;
    this.mes = mes;
    this.año = año;
  }

  public void setDia(int dia) {
    this.dia = dia;
  }

  public void setMes(int mes) {
    this.mes = mes;
  }

  public void setAño(int año) {
    this.año = año;
  }

  public int getDia() {
    return dia;
  }

  public int getMes() {
    return mes;
  }    

  public int getAño() {
    return año;
  }

  @Override
  public String toString() {
    return (getDia()<=9?"0"+getDia():getDia()) + "/" + 
           (getMes()<=9?"0"+getMes():getMes()) + "/" + getAño();
  }        
}