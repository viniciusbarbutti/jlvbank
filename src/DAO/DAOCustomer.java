package DAO;

import java.sql.*;

public class DAOCustomer {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/jlvbank";
    private static final String USER = "bank";
    private static final String PASSWORD = "bank123";

    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;

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
}
