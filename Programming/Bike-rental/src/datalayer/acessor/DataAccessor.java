package datalayer.acessor;

import datalayer.acessor.connection.ConnectionFactory;
import datalayer.acessor.connection.DBConnection;

import java.sql.ResultSet;

public abstract class DataAccessor<T> implements DataAccessorInterface<T> {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    DBConnection dbConnection = connectionFactory.getDBConnection();

    public ResultSet query(String q){
        return dbConnection.query(q);
    }
}
