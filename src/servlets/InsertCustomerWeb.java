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
 * Created by Juliana on 19/11/2016.
 */

@WebServlet(name = "InsertCustomerWeb", urlPatterns = {"/InsertCustomerWeb"})
public class InsertCustomerWeb extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            response.setHeader("Content-Type", "application/json");

            Commons commons = new Commons();
            DBOCustomer customer = new DBOCustomer();
            DAOCustomer daoCustomer = new DAOCustomer();

            String senhaConfirmada = request.getParameter("confirm_password");

            if(!(request.getParameter("password").equals(senhaConfirmada))){
                request.setAttribute("erro", "As senha devem ser iguais!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }

            customer.setName(request.getParameter("complete_name"));
            customer.setCpf(commons.removeMask(request.getParameter("cpf_insert")));
            customer.setRg(commons.removeMask(request.getParameter("rg")));
            customer.setStreet( request.getParameter("address"));
            customer.setCity(request.getParameter("city"));
            customer.setPassword(request.getParameter("password"));
            customer.setPhone(request.getParameter("telephone"));
            customer.setDateBirth(commons.formataData(request.getParameter("date_birth")));
            customer.setIncome(Double.parseDouble(request.getParameter("income")));


            daoCustomer.insertCustomers(customer);

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
