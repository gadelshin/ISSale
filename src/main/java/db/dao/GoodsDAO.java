package db.dao;

import db.ConnectionManagerMSSQL;
import db.IConnectionManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import pojo.Customer;
import pojo.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAO {
    public static class GoodsDAOException extends Exception {
    }

//    public static void main(String[] args) throws GoodsDAO.GoodsDAOException, SQLException, ClassNotFoundException {
//        getAllGoods();
//    }

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(GoodsDAO.class);
    static {
        // Declare the JDBC objects.
        manager = ConnectionManagerMSSQL.getInstance();
        PropertyConfigurator.configure("C:\\project\\ISSale\\src\\main\\resources\\log4j.properties");
    }

    public static List<Goods> getAllGoods() throws GoodsDAO.GoodsDAOException, SQLException, ClassNotFoundException {
        logger.debug("log method <getAllGoods>");

        List<Goods> goodsList = new ArrayList<>();

            try {
                Statement statement = manager.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Goods");
                System.out.println("\nСписок товаров:\n=================");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" +
                            resultSet.getString(3) + "\t" + resultSet.getString(4) + "\t" +
                            resultSet.getString(5) );

                    Goods goods = new Goods(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("model"),
                            resultSet.getString("description"),
                            resultSet.getDouble("price"));
                    goodsList.add(goods);
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
                throw new GoodsDAO.GoodsDAOException();
            }

        return goodsList;
    }

    public static Goods getGoodsById(int id) {

        logger.debug("log method <getGoodsById("+id+")>");
        Goods goods = null;
        try {
            PreparedStatement preparedStatement =  manager.getConnection().prepareStatement("SELECT * FROM Goods WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()==true) {
                goods = new Goods(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("model"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return  goods;
    }

    public static void UpdateGoodsById (Integer id) {
        logger.debug("log method <UpdateGoodsById("+id+")>");
        try {
            PreparedStatement preparedStatement =  manager.getConnection().prepareStatement("UPDATE Goods SET name = ?, model = ? , description = ?, price = ? WHERE id=?");
            preparedStatement.setString(1,"Товар новый");
            preparedStatement.setString(2,"Модель <>");
            preparedStatement.setString(3,"Описание <>");
            preparedStatement.setDouble(4,1234.56);
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

    public static void InsertNewGoods(Goods goods){
        logger.debug("log InsertNewGoods:\n"+goods.toString());
        try {
            PreparedStatement preparedStatement = manager.getConnection()
                    .prepareStatement("INSERT INTO Goods(id, name, model, description, price) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, goods.getId());
            preparedStatement.setString(2, goods.getName());
            preparedStatement.setString(3, goods.getModel());
            preparedStatement.setString(4, goods.getDescription());
            preparedStatement.setDouble(5, goods.getPrice());

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
