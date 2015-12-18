package sandbox;



import java.sql.*;

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
 
//		Statement insertStatement = conn.createStatement();
//		int insertResult = insertStatement.executeUpdate("INSERT INTO USERS (name, password) values ('somenewuser','somedummypassword');");
//		System.out.println("Number of rows updated: " + insertResult);
		
		PreparedStatement pStatement = conn.prepareStatement("SELECT id, name, password, points "
                                                                   + "FROM USERS "
                                                                   + "where name = ?",
                                                                     ResultSet.TYPE_FORWARD_ONLY,
                                                                     ResultSet.CONCUR_UPDATABLE);
        pStatement.setString(1, "somenewuser");
        
        result = pStatement.executeQuery();

        while(result.next())
        {
           System.out.println(result.getInt("id")+","+result.getString("name"));
		   result.updateString("password", "newpassword");
		   result.updateRow();
        }
		
        result.close();
		conn.close();
    }
}
