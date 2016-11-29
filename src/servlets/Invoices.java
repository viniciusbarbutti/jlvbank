package servlets;

import DAO.DAOCard;
import DAO.DAOCustomer;
import DAO.DAOInvoice;
import DBO.DBOCard;
import DBO.DBOInvoice;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Invoices", urlPatterns = {"/Invoices"})
public class Invoices extends HttpServlet {
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
            String numberCard = request.getParameter("numberCard");

            DAOInvoice daoInvoice = new DAOInvoice();
            ArrayList<DBOInvoice> invoices = daoInvoice.selectInvoices(numberCard);

            if (invoices == null){
                out.print(1002);
                return ;
            }

            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            out.print(gson.toJson(invoices));

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("etc/error.jsp");
    }
}
