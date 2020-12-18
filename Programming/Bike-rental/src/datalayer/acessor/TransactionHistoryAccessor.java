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
        String q = "UPDATE transaction SET " +
                " userId = " + transactionHistory.getUserId() +
                " , total_payment = " + transactionHistory.getTotal_payment() +
                " , time = " + "\"" + transactionHistory.getTime() + "\"" +
                " , bike_name = " + "\"" +  transactionHistory.getBike_name() + "\"" +
                " , rented_duration = " + transactionHistory.getRented_duration() +
                " WHERE transactionId = " + transactionHistory.getTransactionId();
        System.out.println(q);
        try{
            executeUpdate(q);
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void save(TransactionHistory transactionHistory) {
        String q = "INSERT INTO transaction(userId, total_payment, time, bike_name, rented_duration) VALUES (" +
                transactionHistory.getUserId() +
                ", " + transactionHistory.getTotal_payment() +
                ", " + "\"" + transactionHistory.getTime() + "\"" +
                ", " + "\"" + transactionHistory.getBike_name() + "\"" +
                ", " + transactionHistory.getRented_duration() +
                ")";
        System.out.println(q);
        try{
            executeUpdate(q);
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void delete(TransactionHistory transactionHistory) {
        String q = "DELETE FROM transaction WHERE transactionId = " + transactionHistory.getTransactionId();
        System.out.println(q);
        try{
            execute(q);
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return;
    }
}
