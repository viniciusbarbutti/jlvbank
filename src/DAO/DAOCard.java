package DAO;

import java.sql.*;

public class DAOCard {

    private static final String DB_URL = "jdbc:mysql//localhost:3306/jlvbank";
    private static final String USER = "jlvbank";
    private static final String PASSWORD = "bank123";
    private Connection conn;
    private PreparedStatement preparedStatement;
    private Statement statement;

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
}
