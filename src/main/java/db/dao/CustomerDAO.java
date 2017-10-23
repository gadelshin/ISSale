package db.dao;

import db.ConnectionManagerMSSQL;
import db.IConnectionManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import pojo.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    public static class CustomerDAOException extends Exception {
    }

//    public static void main(String[] args) throws CustomerDAOException, SQLException, ClassNotFoundException {
//        getAllCustomers();
//    }

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(Customer.class);
    static {
        // Declare the JDBC objects.
        manager = ConnectionManagerMSSQL.getInstance();
        PropertyConfigurator.configure("C:\\project\\ISSale\\src\\main\\resources\\log4j.properties");
    }

    public static List<Customer> getAllCustomers() throws CustomerDAOException, SQLException, ClassNotFoundException {
        logger.debug("log method <getAllCustomers>");

        List<Customer> customersList = new ArrayList<>();

        if(true) {
            try {
                Statement statement = manager.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Customers");
                System.out.println("\nСписок покупателей:\n====================");

                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" +
                            resultSet.getString(3) + "\t" + resultSet.getString(4) + "\t" +
                            resultSet.getString(5) + "\t" + resultSet.getString(6) );

                    Customer customer = new Customer(
                            resultSet.getInt("id"),
                            resultSet.getString("firstName"),
                            resultSet.getString("secondName"),
                            resultSet.getString("phone"),
                            resultSet.getString("address"),
                            resultSet.getString("nick"));
                    customersList.add(customer);
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
                throw new CustomerDAOException();
            }
        }

        if(false) {

        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=Students";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl,"sa","maSteR");

            // Create and execute an SQL statement that returns some data.
            String SQL = "SELECT * FROM Customers";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
////            			System.out.println(rs.getString(4) + " " + rs.getString(6));
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) );
////                Student student = new Student(
////                        (short) rs.getInt("id"),
////                        rs.getString("first_name"),
////                        rs.getString("second_name"),
////                        rs.getString("last_name"),
////                        rs.getDate("birth_date").toLocalDate());
////                studentList.add(student);
//            }
////            Statement statement = manager.getConnection().createStatement();
////            ResultSet resultSet = statement.executeQuery("select * from student");
////
////            while (resultSet.next()) {
////                Student student = new Student(
////                        (short) resultSet.getInt("id"),
////                        resultSet.getString("first_name"),
////                        resultSet.getString("second_name"),
////                        resultSet.getString("last_name"),
////                        resultSet.getDate("birth_date").toLocalDate());
////
////                studentList.add(student);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            throw new CustomerDAOException();
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        }
        return customersList;
    }

    public static Customer getCustomerById(int id) {
        logger.debug("log method <getCustomerById("+id+">");

        Customer customer = null;
        try {
            PreparedStatement preparedStatement =  manager.getConnection().prepareStatement("SELECT * FROM Customers WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()==true) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("secondName"),
                        resultSet.getString("phone"),
                        resultSet.getString("address"),
                        resultSet.getString("nick"));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return  customer;
    }

    public static void UpdateCustomerById (Integer id) {
        logger.debug("log method <UpdateCustomerById("+id+">");
        try {
            PreparedStatement preparedStatement =  manager.getConnection().prepareStatement("UPDATE Customers SET firstName = ?, secondName = ? WHERE id=?");
            preparedStatement.setString(1,"НовоеИмя");
            preparedStatement.setString(2,"НоваяФам");
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

//    public static  void UpdateAll(){
//        try {
//            PreparedStatement preparedStatement =  manager.getConnection().prepareStatement("UPDATE student set group_id = ? ");
//            preparedStatement.setInt(1,3);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    public static  void DeleteById(Integer id){
//        try {
//            PreparedStatement preparedStatement =  manager.getConnection().prepareStatement("DELETE  from student where id=?");
//            preparedStatement.setInt(1,id);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static void InsertNewCustomer(Customer customer){
        logger.debug("log InsertNewCustomer:\n"+customer.toString());
        try {
            PreparedStatement preparedStatement = manager.getConnection()
                    .prepareStatement("INSERT INTO Customers(id, firstName, secondName, phone, address, nick) VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getSecondName());
            preparedStatement.setString(4,  customer.getPhone());
            preparedStatement.setString(5,  customer.getAddress());
            preparedStatement.setString(6,customer.getNick());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

//    public  static void InsertAll(List<Student> ls) { // Вообще лучше через Batch пакетом
//        for (Student st: ls
//                ) {
//            InsertStudent(st);
//        }
//    }

}
