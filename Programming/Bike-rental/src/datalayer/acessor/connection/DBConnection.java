package datalayer.acessor.connection;
import java.sql.*;

public interface DBConnection {

    public ResultSet query(String q);
    
}
