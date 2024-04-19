package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @web https://www.jc-mouse.net
 * @author Mouse
 */
public class ConnectionToSQLite {

    private Connection connection = null;
    private ResultSet resultSet = null;
    private Statement statement = null;
    // Change the next url for the one yours
    private String db= "/home/gians1821/programming-proyects/sistema-gestion-empleados/test-data/test-sistema-empleados.db";

//Constructor de clase que se conecta a la base de datos SQLite 
    public ConnectionToSQLite ()
    {
      try{
         Class.forName("org.sqlite.JDBC");
         connection = DriverManager.getConnection("jdbc:sqlite:" + this.db );
         System.out.println("Conectado a la base de datos SQLite [ " + this.db + "]");
      }catch(Exception e){
         System.out.println(e);
      }

    }

 /* METODO PARA INSERTAR UN REGISTRO EN LA BASE DE DATOS
 * INPUT:
 table = Nombre de la tabla
 fields = String con los nombres de los campos donde insertar Ej.: campo1,campo2campo_n
 values = String con los datos de los campos a insertar Ej.: valor1, valor2, valor_n
 * OUTPUT:
 * Boolean
*/
 public boolean insert(String table, String fields, String values)
    {
        boolean res=false;
        //Se arma la consulta
        String q=" INSERT INTO " + table + " ( " + fields + " ) VALUES ( " + values + " ) ";
        //se ejecuta la consulta
        try {
            PreparedStatement pstm = connection.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(Exception e){
            System.out.println(e);
        }
      return res;
    }

 /* METODO PARA REALIZAR UNA CONSULTA A LA BASE DE DATOS
 * INPUT:
 * OUTPUT: String con los datos concatenados
*/
 public String select()
 {
    String res=" DNI | Nombre | Apellido | Genero | Salario | Nacimiento | Ingreso |  \n ";
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery("SELECT * FROM contratado ;");
      while (resultSet.next())
      {
        res+=resultSet.getString("dni") 
                + " | " + resultSet.getString("nombre") 
                + " | " +  resultSet.getString("apellido") 
                + " | " +  resultSet.getString("genero") 
                + " | " +  resultSet.getString("salario") 
                + " | " +  resultSet.getString("fechaNacimiento") 
                + " | " +  resultSet.getString("fechaIngreso") 
                + " \n ";
      }
     }
     catch (SQLException ex) {
        System.out.println(ex);
     }
    return res;
 }

  public void desconectar()
    {
        try {
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Desconectado de la base de datos [ " + this.db + "]");
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}

