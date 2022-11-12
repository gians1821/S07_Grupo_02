package presentacion;

import entidades.*;
import datos.*;

public class GestionEmpleados {

  public static void main(String[] args) {
    Contratado contratado, contratado1, contratado2;
    contratado = new Contratado();
    contratado.setSalario(1000);
    ListaContratados.setContratado(contratado);
    contratado1 = new Contratado();
    contratado1.setSalario(2000);
    ListaContratados.setContratado(contratado1);
    contratado2 = new Contratado();
    contratado2.setSalario(3000);
    ListaContratados.setContratado(contratado2);
    System.out.println(ListaContratados.getListadoContratados());
  }
}
