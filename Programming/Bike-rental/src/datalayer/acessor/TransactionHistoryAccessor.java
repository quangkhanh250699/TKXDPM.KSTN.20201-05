package datalayer.acessor;

import datalayer.model.Station;
import datalayer.model.TransactionHistory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryAccessor extends DataAccessor<TransactionHistory>{
    @Override
    public TransactionHistory get(int id) {
        String q = "SELECT * FROM transaction WHERE transactionId = " + id;
        TransactionHistory transactionHistory = null;
        try{
            ResultSet rs = query(q);
            rs.next();
            transactionHistory = new TransactionHistory(id, rs.getInt("userId"), rs.getFloat("total_payment"),
                    rs.getTimestamp("time"), rs.getString("bike_name"), rs.getFloat("rented_duration"));

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return transactionHistory;
    }

    @Override
    public List<TransactionHistory> getAll() {
        String q = "SELECT * FROM transaction" ;
        List<TransactionHistory> transactionHistories = new ArrayList<TransactionHistory>();
        try{
            ResultSet rs = query(q);
            while(rs.next()){
                transactionHistories.add(new TransactionHistory(rs.getInt("transactionId"), rs.getInt("userId"), rs.getFloat("total_payment"),
                        rs.getTimestamp("time"), rs.getString("bike_name"), rs.getFloat("rented_duration")));

            }
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return transactionHistories;
    }

    @Override
    public void update(TransactionHistory transactionHistory) {

    }

    @Override
    public void save(TransactionHistory transactionHistory) {

    }

    @Override
    public void delete(TransactionHistory transactionHistory) {

    }
}
