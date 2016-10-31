package DAO;

import DBO.DBOCard;

import java.sql.*;
import java.util.ArrayList;

public class DAOCard {

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


    public ArrayList<DBOCard> selectAllCards(String cpf){
        ArrayList<DBOCard> cards = null;

        if(connection == null)
            prepareConnection();

        try{
            String query = "select card.id, card.num, card.security_num, card.password, card.due_date, brand.name, cust.name, cla.classification, card.status from cards card\n" +
                    "join brands brand on card.fk_brand = brand.id\n" +
                    "join customers cust on cust.id = card.fk_owner\n" +
                    "join classification cla on cla.id = card.fk_classification\n" +
                    "where cust.cpf = ?;";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                cards = new ArrayList<>();
                DBOCard dboCard = new DBOCard();
                do{
                    dboCard.setId(resultSet.getInt("id"));
                    dboCard.setNumber(resultSet.getString("num"));
                    dboCard.setSecurityNumber(resultSet.getString("security_num"));
                    dboCard.setPassword(resultSet.getString("password"));
                    dboCard.setDueDate(resultSet.getDate("due_date"));
                    dboCard.setBrand(resultSet.getString("brand.name"));
                    dboCard.setOwner(resultSet.getString("cust.name"));
                    dboCard.setClassification(resultSet.getString("cla.classification"));
                    dboCard.setStatus(resultSet.getBoolean("status"));

                    cards.add(dboCard);
                }while (resultSet.next());

            }else
                return cards;

        }catch (Exception e){
            e.printStackTrace();
        }
        return  cards;
    }

    public Boolean blockCard(String number){
        if(connection == null)
            prepareConnection();
        try{
            String query = "UPDATE cards SET status = 0 WHERE num = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, number);

            int i = preparedStatement.executeUpdate();
            if(i > 0)
                return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
