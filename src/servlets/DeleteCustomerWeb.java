package servlets;

import Common.Commons;
import DAO.DAOCustomer;
import DBO.DBOCustomer;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Juliana on 20/11/2016.
 */

@WebServlet(name = "DeleteCustomerWeb", urlPatterns = {"/DeleteCustomerWeb"})
public class DeleteCustomerWeb extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            response.setHeader("Content-Type", "application/json");
            Commons commons = new Commons();
            String cartao = commons.removeMask(request.getParameter("cartao"));
            String securityNum = request.getParameter("password");

            if((cartao == null) || (securityNum == null)){
                request.setAttribute("erro_delete", "Por favor, preencha todos os campos!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }

            DAOCustomer daoCustomer = new DAOCustomer();

            daoCustomer.desativaCartao(cartao, securityNum);
            request.setAttribute("erro_delete", "Usuário excluído com sucesso!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);


        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
