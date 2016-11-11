package servlets;

import DAO.DAOCard;
import DBO.DBOCard;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;

@WebServlet(name = "Cards", urlPatterns = {"/Cards"})
public class Cards extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            String cpf = request.getHeader("cpf");

            response.setHeader("Content-Type", "application/json");

            DAOCard daoCard = new DAOCard();
            ArrayList<DBOCard> cards = daoCard.selectAllCards(cpf);

            if (cards == null){
                out.print("1");
                return ;
            }
            Gson gson = new Gson();
            out.print(gson.toJson(cards));

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("etc/error.jsp");
    }
}
