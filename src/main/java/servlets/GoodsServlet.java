package servlets;

import db.dao.GoodsDAO;
import pojo.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GoodsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Goods> allGoods = GoodsDAO.getAllGoods();
            response.setCharacterEncoding ("windows-1251");

            for (Goods gds: allGoods) {
                response.getWriter().println(gds);
            }
        } catch (GoodsDAO.GoodsDAOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
