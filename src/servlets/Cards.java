package servlets;

import DAO.DAOCard;
import DAO.DAOCustomer;
import DBO.DBOCard;
import DBO.DBOCustomer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//import com.google.gson.Gson;

@WebServlet(name = "Cards", urlPatterns = {"/Cards"})
public class Cards extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            DAOCard daoCard = new DAOCard();
            ArrayList<DBOCard> c = daoCard.selectAllCards("12345678011");
//            Gson gson = new Gson();

            PrintWriter out = response.getWriter();
            out.print(c);
        }
        catch (Exception e){
            e.getMessage();
        }

    }
}
