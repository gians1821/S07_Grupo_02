package logica;

import datos.ConnectionToSQLite;
import entidades.Contratado;
import entidades.Fecha;

public class RegistroEmpleado {

    public static void registrar(String dni, String nombre, String apellido, String genero, String salario, String nacimiento, String ingreso, String categoria) {
        try {
            ConnectionToSQLite connection = new ConnectionToSQLite();
            if (categoria.compareTo("contratado") == 0) {
                Fecha fechaNacimiento = new Fecha(nacimiento);
                Fecha fechaIngreso = new Fecha(ingreso);
                Contratado contratado = new Contratado(dni, nombre, apellido, genero, Float.parseFloat(salario), fechaNacimiento, fechaIngreso);
                connection.insert(categoria, 
                        "dni,nombre,apellido,genero,salario,fechaNacimiento,fechaIngreso", 
                        "'27729692', 'Lilia', 'Ramirez', 'Femenino', '1200.00', '04-08-1974', '04-08-2023'");
                connection.desconectar();
            } else if (categoria.compareTo("a-destajo") == 0) {

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
