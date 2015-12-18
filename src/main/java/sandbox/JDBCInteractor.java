package sandbox;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A class for demonstrating JDBC
 * 
 * @author buddha
 */
public class JDBCInteractor {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3307/unscrambler";
        
        String USER = "root";
        String PASSWORD = "password";
        
        Class.forName(JDBC_DRIVER);
        
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement statement = conn.createStatement();
        
        ResultSet result = statement.executeQuery("SELECT * FROM USERS WHERE NAME='buddha';");
        
        while(result.next())
        {
           System.out.println(result.getInt("id")+","+result.getString("name"));
        }
 
        result.close();
		conn.close();
    }
}
