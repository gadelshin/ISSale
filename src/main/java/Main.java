import db.dao.GoodsDAO;

import java.sql.*;

//import com.microsoft.sqlserver.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, GoodsDAO    .GoodsDAOException {

//        ConnectionManagerMSSQL managerMSSQL = ConnectionManagerMSSQL.getInstance();
//        Connection connection = managerMSSQL.getConnection();

        Connection connection;
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=ISSale";
//                              jdbc:sqlserver://localhost;user=MyUserName;password=*****;
        Statement stmt = null;
        ResultSet rs = null;

/*
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(connectionUrl, "sa", "maSteR");

        String SQL = "SELECT * FROM customers";
        stmt = connection.createStatement();
        rs = stmt.executeQuery(SQL);

        try {
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
            }
        } catch(SQLException e){
        e.printStackTrace();
        }
*/

            // JDBC driver name and database URL
//            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//            String DB_URL = "jdbc:mysql://localhost/EMP";
            String DB_URL = "jdbc:sqlserver://localhost:1433;database=ISSale";;
            //  Database credentials
            String user = "sa";
            String pass = "maSteR";

            Connection conn = null;
            Statement stamt = null;
                try {
                    //STEP 2: Register JDBC driver
//                    Class.forName("com.mysql.jdbc.Driver");
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                    Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, user, pass);

                    //STEP 4: Execute a query
                    System.out.println("Creating statement...");
                    stamt = conn.createStatement();
                    String sql;
                    sql = "SELECT * FROM Goods";

                    ResultSet resul = stamt.executeQuery(sql);
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                catch (NullPointerException e) {
                    e.printStackTrace();
                }

//        List<Goods> allGoods = GoodsDAO.getAllGoods();
//        System.out.println("allGoods: " + allGoods);
//        for (Goods gds: allGoods) {
//            System.out.println(gds);
//        }
    }
}
