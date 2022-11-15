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
                          4. Registrar las ventas realizadas por los empleados a destajo
                          5. Listar los datos de los empleados contratados (mostrando sueldo neto)
                          6. 
                          7. Mostrar clientes de empleado a destajo
                          8. Salir

                          \tDigite opcion [1 - 8]:""";
    int opcion;
    do {
      System.out.print("\n\n\tMenu principal\n\n" + opcionesMenu + " ");
      opcion = sc.nextInt();
    } while (opcion < 1 || opcion > 8);
    sc.nextLine();
    return opcion;
  }
  
  public static void main(String[] args) {
    Empleado empleado = new Empleado();
    String dni, nombre, apellido;
    int genero, diaI, mesI, añoI, diaN, mesN, añoN, diaV, mesV, añoV;
    float salario;
    Fecha fechaNacimiento, fechaIngreso, fechaVenta;
    Cliente clienteA;
    Venta ventaA;
    int opcion;
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
          System.out.print("Genero (0-Masculino 1-Femenino): ");
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
          contratado.setPctjeAdicional();
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
          System.out.print("Genero (0-Masculino 1-Femenino): ");
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
          ListaADestajo.setADestajo(ADestajo);
          break;
        case 4:
          System.out.print("\n\nDigite DNI del Empleado a destajo: ");
          dni = sc.nextLine();
          int v = 0;
          int p = 0;
          for(int i = 0; i<=ListaADestajo.getPosicion();i++)
            if(ListaADestajo.getADestajo(i).getDni().compareTo(dni)==0){
              v = 1;
              p = i;
            }
          if(v == 1) {
            System.out.print("\nDigite fecha de venta\n\tDia: ");
            diaV = sc.nextInt();
            System.out.print("\tMes: ");
            mesV = sc.nextInt();
            System.out.print("\tAnio: ");
            añoV = sc.nextInt();
            fechaVenta = new Fecha(diaV, mesV, añoV);
            sc.nextLine();
            System.out.print("\nDigite datos de cliente\n\tDNI: ");
            String dniCliente = sc.nextLine();
            System.out.print("\tNombre: ");
            nombre = sc.nextLine();
            System.out.print("\tApellido: ");
            apellido = sc.nextLine();
            clienteA = new Cliente(dniCliente,nombre,apellido);
            System.out.print("\tDigite monto de venta: ");
            float monto = sc.nextFloat();
            sc.nextLine();
            System.out.print("Digite numero de documento de venta: ");
            String numDoc = sc.nextLine();
            ventaA = new Venta(numDoc , fechaVenta , clienteA, monto);
            ListaADestajo.getADestajo(p).setVenta(ventaA);
          } else
            System.out.println("Empleado a destajo no encontrado ");
          break;
        case 5:
          System.out.println(ListaContratados.getListadoContratados());
          break;
        case 7:
          String dniA;
          System.out.print("\nDigite el DNI del empleado: ");
          dniA = sc.nextLine();
          for(int i = 0; i<=ListaADestajo.getPosicion(); i++)
            if((ListaADestajo.getADestajo(i).getDni().compareTo(dniA)) == 0)
              System.out.println(ListaADestajo.getADestajo(i).getListadoVentas());
          break;
      }
    }while(opcion != 8);
  }
}
