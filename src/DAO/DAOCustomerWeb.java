package DAO;

import DBO.DBOCustomer;

import java.sql.*;

/**
 * Created by Juliana on 10/11/2016.
 */
public class DAOCustomerWeb {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/jlvbank";
    private static final String USER = "jsimoni";
    private static final String PASSWORD = "minamimo";

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


    public DBOCustomer searchCustomer(String cpf){
        DBOCustomer dboCustomer = null;
        try{

            if(connection == null)
                prepareConnection();

            String query = "select cust.name, cust.cpf, cust.rg, city.name, cust.phone," +
                    "from customers cust join cities city where city.id = cust.fk_city and cust.cpf = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                dboCustomer = new DBOCustomer();
                do{
                    dboCustomer.setName(resultSet.getString("name"));
                    dboCustomer.setCpf(resultSet.getString("cpf"));
                    dboCustomer.setRg(resultSet.getString("rg"));
                    dboCustomer.setCity(resultSet.getString("city.name"));
                    dboCustomer.setPhone(resultSet.getString("phone"));

                }while(resultSet.next());
            }
            else{
                return null;
            }
        }
        catch (SQLException e){
            e.getMessage();
        }
        return dboCustomer;
    }
}
