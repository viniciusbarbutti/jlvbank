package DAO;

import DBO.DBOCustomer;

import java.sql.*;

public class DAOCustomer {

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

    /*return is 0, customer didn't found*/
    public int selectId(String cpf){
        int idCustomer = 0;
        try{

            if(connection == null)
                prepareConnection();

            String query = "SELECT id FROM customers WHERE cpf = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                do{
                    idCustomer = resultSet.getInt("id");
                }while(resultSet.next());
            }
            else{
                return idCustomer;
            }
        }
        catch (SQLException e){
            e.getMessage();
        }

        return idCustomer;
    }

    public DBOCustomer authenticCustomer (String cpf, String pass){
        DBOCustomer dboCustomer = null;
        try{

            if(connection == null)
                prepareConnection();

            String query = "select cust.id,cust.name, cust.cpf, cust.rg, cust.street, city.name, cust.phone," +
                    "cust.password, cust.income, cust.registration_date, cust.date_birth, cust.status " +
                    "from customers cust join cities city where city.id = cust.fk_city and cust.cpf = ?" +
                    "and cust.password = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, pass);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                dboCustomer = new DBOCustomer();
                do{
                    dboCustomer.setId(resultSet.getInt("id"));
                    dboCustomer.setName(resultSet.getString("name"));
                    dboCustomer.setCpf(resultSet.getString("cpf"));
                    dboCustomer.setRg(resultSet.getString("rg"));
                    dboCustomer.setStreet(resultSet.getString("street"));
                    dboCustomer.setCity(resultSet.getString("city.name"));
                    dboCustomer.setPhone(resultSet.getString("phone"));
                    dboCustomer.setPassword(resultSet.getString("password"));
                    dboCustomer.setIncome(resultSet.getDouble("income"));
                    dboCustomer.setRegistrationDate(resultSet.getDate("registration_date"));
                    dboCustomer.setDateBirth(resultSet.getDate("date_birth"));
                    dboCustomer.setStatus(resultSet.getBoolean("status"));

                }while(resultSet.next());
            }
            else{
                return null;
            }
        }
        catch (SQLException e) {
            e.getMessage();
        }
        return dboCustomer;
    }
}
