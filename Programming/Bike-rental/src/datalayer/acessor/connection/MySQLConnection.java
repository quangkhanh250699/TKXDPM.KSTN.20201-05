package datalayer.acessor.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnection implements DBConnection {

    private Connection conn = null;
    private Statement stmt = null;

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

    public Statement getStmt() {
        return stmt;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    @Override
    public ResultSet query(String q) {
        return this.stmt.executeQuery(q);
    }

}
