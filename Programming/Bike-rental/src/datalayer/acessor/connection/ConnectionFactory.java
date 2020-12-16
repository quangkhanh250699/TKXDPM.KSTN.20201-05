package datalayer.acessor.connection;

import datalayer.acessor.connection.DBConnection;
import datalayer.acessor.connection.MySQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bike_rental?autoReconnect=true&useSSL=false";

    //  Database credentials
    static final String USER = "guest";
    static final String PASS = "guest";

    public DBConnection getDBConnection(){
        MySQLConnection mySQLConnection = MySQLConnection.getInstance();
        if(mySQLConnection.getConn() != null){
            return mySQLConnection;
        }

        Connection conn = null;
        Statement stmt = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            mySQLConnection.setConn(conn);
            mySQLConnection.setStmt(stmt);

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

        return mySQLConnection;
    }

}
