package servlets;

import DAO.DAOCustomer;
import DBO.DBOCustomer;
import com.google.gson.Gson;
import Common.Commons;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Juliana on 13/11/2016.
 */
@WebServlet(name = "Servlet AuthenticationWeb", urlPatterns = {"/AuthenticationWeb"})
public class AuthenticationWeb extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            response.setHeader("Content-Type", "application/json");
            Commons commons = new Commons();
            String cpf = commons.removeMask(request.getParameter("cpf"));
            String password = request.getParameter("password");

            if((cpf == null) || (password == null)){
                request.setAttribute("erro", "Por favor, preencha todos os campos");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }

            DAOCustomer daoCustomer = new DAOCustomer();
            boolean answer = daoCustomer.authenticCustomerRequest(cpf, password);

            if(answer){
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
            else{
                request.setAttribute("erro", "CPF ou senha inválida!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("etc/error.jsp");
    }

}


