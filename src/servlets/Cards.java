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
import java.util.ArrayList;

@WebServlet(name = "Cards", urlPatterns = {"/Cards"})
public class Cards extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getHeader("cpf");

        try {
            DAOCard daoCard = new DAOCard();
            ArrayList<DBOCard> cards = daoCard.selectAllCards(cpf);

            PrintWriter out = response.getWriter();

            //TODO: talk with Leoni
            if (cards == null)
                out.print("error");

            else {
                Gson gson = new Gson();

                out.print(gson.toJson(cards));
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("etc/error.jsp");
    }
}
