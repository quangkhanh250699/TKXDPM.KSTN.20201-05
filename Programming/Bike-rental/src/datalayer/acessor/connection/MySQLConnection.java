package datalayer.acessor.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection implements DBConnection {

    private Connection conn = null;
    private static MySQLConnection instance;

    private MySQLConnection(){}

    public static MySQLConnection getInstance(){
        if(instance == null){
            instance = new MySQLConnection();
        }
        return instance;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public ResultSet query(String q) {

        ResultSet rs = null;
        try{
//            System.out.println("Creating statement...");
            Statement stmt = this.conn.createStatement();
            rs = stmt.executeQuery(q);
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources

        }//end try
        return rs;
    }

}
