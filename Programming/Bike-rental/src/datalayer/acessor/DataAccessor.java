package datalayer.acessor;

import datalayer.acessor.connection.ConnectionFactory;
import datalayer.acessor.connection.DBConnection;

public abstract class DataAccessor<T> implements DataAccessorInterface<T> {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    DBConnection dbConnection = connectionFactory.getDBConnection();

    public String query(String q){
        return null;
    }
}
