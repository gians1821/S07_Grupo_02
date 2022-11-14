package presentacion;

import entidades.*;
import datos.*;
import java.util.*;

public class GestionEmpleados {
  private static Scanner sc = new Scanner(System.in);
    
  public static int menu() {
    String opcionesMenu = """

                          1. Registrar Empleados contratados 
                          2. Registrar Empleados a Destajo
                          3. 
                          4. 
                          5. 
                          6.
                          7.
                          8. Salir

                          \tDigite opcion [1 - 8]: """;
    int opcion;
    do {
      System.out.print("\n\n\tMenu principal\n\n" + opcionesMenu);
      opcion = sc.nextInt();
    } while (opcion < 1 || opcion > 8);
    sc.nextLine();
    return opcion;
  }
  
  public static void main(String[] args) {
    Empleado empleado = new Empleado();
    String dni, nombre, apellido;
    int genero, diaI, mesI, añoI, diaN, mesN, añoN;
    float salario;
    Fecha fechaNacimiento, fechaIngreso;
    int opcion;
    System.out.println("\nDatos del equipo:\n" + empleado.toString());
    do {
      opcion = menu();
      switch(opcion) {
        case 1:
          Contratado contratado = new Contratado();
          System.out.print("\nDNI: ");
          contratado.setDni(sc.nextLine());
          System.out.print("Nombre: ");
          contratado.setNombre(sc.nextLine());
          System.out.print("Apellido: ");
          contratado.setApellido(sc.nextLine());
          System.out.print("Genero: ");
          contratado.setGenero(sc.nextInt());
          System.out.print("Salario: ");
          contratado.setSalario(sc.nextFloat());
          System.out.print("Fecha de nacimiento\n\tDia: ");
          diaN = sc.nextInt();
          System.out.print("\tMes: ");
          mesN = sc.nextInt();
          System.out.print("\tAnio: ");
          añoN = sc.nextInt();
          fechaNacimiento = new Fecha(diaN, mesN, añoN);
          contratado.setFechaNacimiento(fechaNacimiento);
          System.out.print("Fecha de ingreso\n\tDia: ");
          diaI = sc.nextInt();
          System.out.print("\tMes: ");
          mesI = sc.nextInt();
          System.out.print("\tAnio: ");
          añoI = sc.nextInt();
          fechaIngreso = new Fecha(diaI, mesI, añoI);
          contratado.setFechaIngreso(fechaIngreso);
          System.out.println("\nDatos del equipo:\n" + contratado.toString());
          ListaContratados.setContratado(contratado);
          break;
        case 2:
          ADestajo ADestajo = new ADestajo();
          System.out.print("\nDNI: ");
          ADestajo.setDni(sc.nextLine());
          System.out.print("Nombre: ");
          ADestajo.setNombre(sc.nextLine());
          System.out.print("Apellido: ");
          ADestajo.setApellido(sc.nextLine());
          System.out.print("Genero: ");
          ADestajo.setGenero(sc.nextInt());
          System.out.print("Salario: ");
          ADestajo.setSalario(sc.nextFloat());
          System.out.print("Fecha de nacimiento\n\tDia: ");
          diaN = sc.nextInt();
          System.out.print("\tMes: ");
          mesN = sc.nextInt();
          System.out.print("\tAnio: ");
          añoN = sc.nextInt();
          fechaNacimiento = new Fecha(diaN, mesN, añoN);
          ADestajo.setFechaNacimiento(fechaNacimiento);
          System.out.print("Fecha de ingreso\n\tDia: ");
          diaI = sc.nextInt();
          System.out.print("\tMes: ");
          mesI = sc.nextInt();
          System.out.print("\tAnio: ");
          añoI = sc.nextInt();
          fechaIngreso = new Fecha(diaI, mesI, añoI);
          ADestajo.setFechaIngreso(fechaIngreso);
          System.out.println("\nDatos del equipo:\n" + ADestajo.toString());
          ListaADestajo.setADestajo(ADestajo);
          break;
      }
    }while(opcion != 8);
  }
}
