package servlets;

import DAO.DAOCard;
import DAO.DAOCustomer;
import DBO.DBOCard;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "BlockCard", urlPatterns = {"/BlockCard"})
public class BlockCard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            response.setHeader("Content-Type", "application/json");

            String cpf = request.getHeader("cpf");
            if (cpf == null) {
                out.print(1001);
                return ;
            }

            String password = request.getHeader("password");
            if (password == null) {
                out.print(1001);
                return ;
            }
            String number = request.getHeader("number");
            if (number == null) {
                out.print(1001);
                return ;
            }

            DAOCustomer daoCustomer = new DAOCustomer();

            if (!daoCustomer.authenticCustomerRequest(cpf, password)){
                out.print(1001);
                return ;
            }

            DAOCard daoCard = new DAOCard();
            if(daoCard.blockCard(number)){
                out.print(1000);
                return ;
            }

            out.print(1003);

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("etc/error.jsp");
    }
}
