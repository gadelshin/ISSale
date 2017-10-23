package db;

import java.sql.*;

public class ConnectionManagerMSSQL implements IConnectionManager {
    private static final ConnectionManagerMSSQL INSTANCE = new ConnectionManagerMSSQL();
    private Connection connection;
    String connectionUrl = "jdbc:sqlserver://localhost:1433;database=ISSale";
    Statement stmt = null;
    ResultSet rs = null;

    private ConnectionManagerMSSQL() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionUrl, "sa", "maSteR");

            // Create and execute an SQL statement that returns some data.
            if (false) {
                String SQL = "SELECT * FROM customers";
                stmt = connection.createStatement();
                rs = stmt.executeQuery(SQL);

                while (rs.next()) {
                    System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
                }
                }
            } catch(SQLException e){
                e.printStackTrace();
            } catch(ClassNotFoundException e){
                e.printStackTrace();
            }
    }

    public static synchronized ConnectionManagerMSSQL getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

}
