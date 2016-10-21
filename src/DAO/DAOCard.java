package DAO;

import DBO.DBOCard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOCard {

    private static final String DB_URL = "jdbc:mysql//127.0.0.1:3306/meu_database";
    private static final String USER = "jlvbank";
    private static final String PASSWORD = "bank123";
    private Connection conn;
    private Statement stmt;

    private void prepareConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    private void disposeConnection(){
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
                conn = null;
            }
        }catch(SQLException e){
            conn = null;
            e.printStackTrace();
        }
    }

    public List<DBOCard> getCards(){
        List<DBOCard> cards = new ArrayList<>();

        try{
            if(conn == null)
                prepareConnection();
            stmt = conn.createStatement();

            String query = "SELECT * FROM jlvbank.cards";
            ResultSet rs = stmt.executeQuery(query);
            DBOCard c;
            while(rs.next()){
                c = new DBOCard();
                c.setId(rs.getInt("id"));
                c.setNumber(rs.getString("num"));
                c.setSecurityNumber(rs.getString("security_num"));
                c.setPassword(rs.getString("password"));
                c.setDueDate(rs.getDate("due_date"));
                c.setBrand(rs.getString("fk_brand"));
                c.setOwner(rs.getString("fk_owner"));
                c.setClassification(rs.getString("fk_classification"));
                c.setStatus(rs.getBoolean("status"));
            }
            rs.close();
            conn.close();
            disposeConnection();
        }catch (SQLException e){
            disposeConnection();
        }

        return cards;
    }
}
