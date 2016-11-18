package servlets;

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
 * Created by Juliana on 13/11/2016.
 */

@WebServlet(name = "DetailCustomersWeb", urlPatterns = {"/DetailCustomersWeb"})
public class DetailCustomerWeb extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            response.setHeader("Content-Type", "application/json");

            String cpf = request.getParameter("cpf");

            DBOCustomer customer = new DBOCustomer();
            DAOCustomer daoCustomer = new DAOCustomer();
            customer = daoCustomer.detailCustomer(cpf);

            Gson gson = new Gson();

            request.setAttribute("name", gson.toJson(customer.getName()));
            request.setAttribute("cpf", gson.toJson(customer.getCpf()));
            request.setAttribute("rg", gson.toJson(customer.getRg()));
            request.setAttribute("cidade", gson.toJson(customer.getCity()));
            request.setAttribute("endereco", gson.toJson(customer.getStreet()));
            request.setAttribute("telefone", gson.toJson(customer.getPhone()));
            request.setAttribute("salario", gson.toJson(customer.getIncome()));
            request.setAttribute("aniversario", gson.toJson(customer.getDateBirth()));

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
