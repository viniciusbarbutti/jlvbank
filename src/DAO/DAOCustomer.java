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

    public boolean authenticCustomerRequest (String cpf, String pass){
        boolean authentic = false;

        try{
            if(connection == null)
                prepareConnection();

            String query = "SELECT COUNT(*) FROM customers WHERE cpf = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, pass);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                if(resultSet.getInt("count(*)") == 1)
                    disposeConnection();
                    return true;
                else
                    disposeConnection();
                    return false;
            }else{
                disposeConnection();
                return false;
            }
        }
        catch (SQLException e){
            e.getMessage();
        }
        disposeConnection();
        return false;
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
                disposeConnection();
                return null;
            }
        }
        catch (SQLException e) {
            e.getMessage();
        }
        disposeConnection();
        return dboCustomer;
    }

    public DBOCustomer dataCustomer (String cpf){
        DBOCustomer dboCustomer = null;
        try{

            if(connection == null)
                prepareConnection();

            String query = "select cust.name, cust.cpf, cust.rg, city.name, cust.phone from customers cust join cities city where city.id = cust.fk_city and cust.cpf = ?";

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
                disposeConnection();
                return null;
            }
        }
        catch (SQLException e) {
            e.getMessage();
        }
        disposeConnection();
        return dboCustomer;
    }

    public DBOCustomer detailCustomer (String cpf){
        DBOCustomer dboCustomer = null;
        try{

            if(connection == null)
                prepareConnection();

            String query = "select cust.name, cust.cpf, cust.rg, city.name, cust.street, cust.phone, cust.income, cust.date_birth from customers cust\n" +
                    "join cities city where city.id = cust.fk_city and cust.cpf = ?";

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
                    dboCustomer.setStreet(resultSet.getString("street"));
                    dboCustomer.setPhone(resultSet.getString("phone"));
                    dboCustomer.setIncome(resultSet.getDouble("income"));
                    dboCustomer.setDateBirth(resultSet.getDate("date_birth"));

                }while(resultSet.next());
            }
            else{
                disposeConnection();
                return null;
            }
        }
        catch (SQLException e) {
            e.getMessage();
        }
        disposeConnection();
        return dboCustomer;
    }

    public Long searchIdCity (String name){
        Long id = null;
        try{
            if(connection == null)
                prepareConnection();

            String query = "select id from cities where name = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            id = resultSet.getLong("id");

        }
        catch (SQLException e) {
            e.getMessage();
        }
        disposeConnection();
        return id;
    }

    public void insertCustomers (DBOCustomer dboCustomer){
        Long id = null;
        try{
            if(connection == null)
                prepareConnection();

            id = searchIdCity(dboCustomer.getCity());

            String query = "INSERT INTO jlvbank.customers(name, cpf, rg, street, fk_city, phone, password, income, registration_date, date_birth, status)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, 1);";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dboCustomer.getName());
            preparedStatement.setString(2, dboCustomer.getCpf());
            preparedStatement.setString(3, dboCustomer.getRg());
            preparedStatement.setString(4, dboCustomer.getStreet());
            preparedStatement.setLong(5, id);
            preparedStatement.setString(6, dboCustomer.getPhone());
            preparedStatement.setString(7, dboCustomer.getPassword());
            preparedStatement.setDouble(8, dboCustomer.getIncome());
            preparedStatement.setDate(9,dboCustomer.getDateBirth());

            preparedStatement.execute();
            preparedStatement.close();

        }
        catch (SQLException e) {
            e.getMessage();
        }
    }

    public void deleteCustomer(String cpf, String password){
        try{
            if(connection == null)
                prepareConnection();

            String query = "UPDATE customers SET status = 0 where cpf = ? and password = ?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, password);

            System.out.print(query);

            preparedStatement.executeUpdate();
            connection.close();

        }catch(SQLException e){
            e.getMessage();
        }
    }

    public Long validateCustomer(String cpf, String password){
        Long status = null;
        try{
            if(connection == null)
                prepareConnection();

            String query = "select status from customers cust where cpf = ? and password = ?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            status = resultSet.getLong("status");

            preparedStatement.execute();
            connection.close();
            
        }catch(SQLException e){
            e.getMessage();
        }
        return status;
    }
}
