
package db;



import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;



public class Database {
    
    
    public static Connection connect(){
           
    Connection conn =null;
    
    try
    {
    
    Class.forName("com.mysql.jdbc.Driver");
    conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itp2017","root","");
    System.out.println("r");
    }
    
    catch(ClassNotFoundException | SQLException e)
    {
        System.out.println(e);
    }
    
    return conn;
    
}   
    }

    


    
    
    
    

