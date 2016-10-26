package servlets;

import DAO.DAOCustomer;
import DBO.DBOCustomer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//import com.google.gson.Gson;

@WebServlet(name = "Cards", urlPatterns = {"/Cards"})
public class Cards extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            DAOCustomer daoCustomer = new DAOCustomer();
            DBOCustomer dboCustomer = daoCustomer.authenticCustomer("12345678011", "vini");
//            Gson gson = new Gson();

            PrintWriter out = response.getWriter();
            out.print(dboCustomer);
        }
        catch (Exception e){
            e.getMessage();
        }

    }
}
