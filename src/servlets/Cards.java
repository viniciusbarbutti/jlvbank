package servlets;

import DAO.DAOCard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cards", urlPatterns = {"/Cards"})
public class Cards extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOCard daoCard = new DAOCard();
        PrintWriter out = response.getWriter();
        out.print("servletok");
        try{
            int idCustomer  = daoCard.getIdCustomer("12345678011");

            out.print(idCustomer);
        }
        catch (Exception e){}
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOCard daoCard = new DAOCard();
        PrintWriter out = response.getWriter();

        try{
            int idCustomer  = daoCard.getIdCustomer("12345678011");

            out.print(idCustomer);
        }
        catch (Exception e){
            out.print(e);
        }

    }
}
