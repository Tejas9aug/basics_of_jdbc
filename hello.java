import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * hello
 */
public class hello {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Heoooo");

      final  String url ="jdbc:mysql://localhost:3306/customers";
        final String username="root";
        final String password="Tejas@2003";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("OK Connected");
           try {
              
           Statement stmt = connection.createStatement();
           ResultSet res =stmt.executeQuery("select * from custdetails");
            
           while(res.next()){
            int id = res.getInt("id");
            String name = res.getString("name");
            String phone_number = res.getString("phone_number");
            System.out.println();
            System.out.println("======================================");
            System.out.println("ID : "+id);
            System.out.println("Name : "+name);
            System.out.println("PhoneNo : "+phone_number);
            

           }

           } 
           catch (Exception e) {
            System.out.println(e);
            System.out.println("regret to say that u are rejected");
           }
           
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e);
            System.out.println("regret to say that u are rejected");
        }
    }
}