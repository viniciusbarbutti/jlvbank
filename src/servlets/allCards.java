package servlets;

import DAO.DAOCard;
import DAO.DAOCustomer;
import DBO.DBOCard;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;

@WebServlet(name = "allCards", urlPatterns = {"/allCards"})
public class allCards extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            response.setHeader("Content-Type", "application/json");

            String cpf = request.getParameter("cpf");
            if (cpf == null) {
                out.print(1001);
                return ;
            }

            String password = request.getParameter("password");
            if (password == null) {
                out.print(1001);
                return ;
            }

            DAOCustomer daoCustomer = new DAOCustomer();

            if (!daoCustomer.authenticCustomerRequest(cpf, password)){
                out.print(1001);
                return ;
            }

            DAOCard daoCard = new DAOCard();
            ArrayList<DBOCard> cards = daoCard.selectAllCards(cpf);

            if (cards == null){
                out.print(1002);
                return ;
            }
            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            out.print(gson.toJson(cards));

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("etc/error.jsp");
    }
}
