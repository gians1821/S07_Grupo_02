package datos;

import entidades.*;

public class ListaContratados {
  public final static int TAM = 10;
  private static Contratado listaC[] = new Contratado[TAM];
  private static int posicion = -1;

  public static void setContratado(Contratado contratado) {
    if(posicion == listaC.length - 1)
      nuevaLista();
    ++posicion;
    listaC[posicion] = contratado;
  }

  private static void nuevaLista() {
    Contratado aux[] = new Contratado[listaC.length + TAM];
    for(int i=0; i<=posicion; i++)
      aux[i] = listaC[i];
    listaC = aux;
  }

  public static Contratado getContratado(int pos) {
    return listaC[pos];
  }

  public static int getPosicion() {
    return posicion;
  }

  public static String getListadoContratados() {
    String contenido = "";
    for(int i=0; i<=getPosicion(); i++) {
        contenido += "\nEmpleado " + (i+1) +":\n" + getContratado(i).toString() + "\n";            
    }
    return contenido;
  }    
}
