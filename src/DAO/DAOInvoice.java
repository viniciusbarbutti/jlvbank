package DAO;

import DBO.DBOInvoice;
import DBO.DBORelease;

import java.sql.*;
import java.util.ArrayList;

public class DAOInvoice {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/JLVbank";
    private static final String USER = "jlvbank";
    private static final String PASSWORD = "bank123";

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    private void prepareConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    private void disposeConnection(){
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
                connection = null;
            }
        }catch(SQLException e){
            connection = null;
            e.printStackTrace();
        }
    }

    public ArrayList<DBORelease> selectInvoice (int invoice) {
        ArrayList<DBORelease> releases = null;
        if(connection == null)
            prepareConnection();
        try{
            String query = "select rl.id, rl.value, trl.`type`,rl.description, rl.date\n" +
                    "from releases rl\n" +
                    "join type_releases trl on rl.fk_type = trl.id\n" +
                    "where fk_invoice = ?;";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, invoice);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                releases = new ArrayList<>();
                DBORelease dboRelease = new DBORelease();
                do{
                    dboRelease.setId(resultSet.getInt("id"));
                    dboRelease.setValue(resultSet.getDouble("value"));
                    dboRelease.setType(resultSet.getString("type"));
                    dboRelease.setDescription(resultSet.getString("description"));
                    dboRelease.setDate(resultSet.getDate("date"));
                }while(resultSet.next());

            }else
                return releases;
        }catch (Exception e){
            e.getStackTrace();
        }
        return releases;
    }

    public ArrayList<DBOInvoice> selectInvoices (String cardNumber){
        ArrayList<DBOInvoice> invoices = null;

        if(connection == null)
            prepareConnection();

        try{
            String query ="select invoice.id, invoice.valeu, invoice.bar_code, card.num, invoice.start_date, invoice.end_date, invoice.due_date, invoice.paid\n" +
                    "from invoices invoice\n" +
                    "join cards card on card.id = fk_card\n" +
                    "where card.num = ?;";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cardNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                invoices = new ArrayList<>();
                DBOInvoice dboInvoice = new DBOInvoice();
                do{
                    dboInvoice.setId(resultSet.getInt("id"));
                    dboInvoice.setValue(resultSet.getDouble("valeu"));
                    dboInvoice.setBarCode(resultSet.getString("bar_code"));
                    dboInvoice.setCard(resultSet.getString("num"));
                    dboInvoice.setStartDate(resultSet.getDate("start_date"));
                    dboInvoice.setEndDate(resultSet.getDate("end_date"));
                    dboInvoice.setDueDate(resultSet.getDate("due_date"));
                    dboInvoice.setPaid(resultSet.getBoolean("paid"));
                    dboInvoice.setReleases(selectInvoice(dboInvoice.getId()));
                }while (resultSet.next());
            }else
                return invoices;
        }catch (Exception e){
            e.getStackTrace();
        }
        return invoices;
    }
}
