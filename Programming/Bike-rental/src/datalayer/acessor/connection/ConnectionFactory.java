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

    /**
     * Create connection to mysql server
     * @return connection
     */
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
            mySQLConnection.setConn(conn);

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        return mySQLConnection;
    }

}
