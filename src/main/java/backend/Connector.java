package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
    private Connection connection = null;

    //Constants
    private static final String IP = "localhost";
    private static final String PORT = "3306";
    public static final String DATABASE = "test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "fuck1234";

    public Connector() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }

    public Connection getConnection() {
        return this.connection;
    }

    void close() throws SQLException {
        connection.close();
    }
    public static void main(String[] args) throws Exception {
        Connector c = new Connector();
        c.getConnection();
        String query = "SELECT * FROM Undersøgelse;";
            Statement stmt = new Connector().getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                String name = res.getString("person");
                System.out.println(name);
                
            }
    }
}
