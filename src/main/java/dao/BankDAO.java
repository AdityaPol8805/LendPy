package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Bank;
import util.DBConnection;

public class BankDAO {

    public List<Bank> getBanksByLoanType(String loanType){

        List<Bank> banks = new ArrayList<>();

        try{

            Connection con =
                    DBConnection.getConnection();

            String query =
            "SELECT * FROM banks WHERE loan_type=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, loanType);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()){

                Bank bank = new Bank();

                bank.setId(rs.getInt("id"));
                bank.setBankName(rs.getString("bank_name"));
                bank.setLoanType(rs.getString("loan_type"));
                bank.setInterestRate(rs.getDouble("interest_rate"));
                bank.setMinIncome(rs.getDouble("min_income"));
                bank.setMaxAmount(rs.getDouble("max_amount"));
                bank.setMaxTenure(rs.getInt("max_tenure"));
                bank.setProcessingFee(rs.getDouble("processing_fee"));

                banks.add(bank);
            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return banks;
    }
    
    public boolean addBank(Bank bank){

        try{

            Connection con =
                    DBConnection.getConnection();

            String query =
            "INSERT INTO banks(bank_name,loan_type,interest_rate,min_income,max_amount,max_tenure,processing_fee) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, bank.getBankName());
            ps.setString(2, bank.getLoanType());
            ps.setDouble(3, bank.getInterestRate());
            ps.setDouble(4, bank.getMinIncome());
            ps.setDouble(5, bank.getMaxAmount());
            ps.setInt(6, bank.getMaxTenure());
            ps.setDouble(7, bank.getProcessingFee());

            int rows =
                    ps.executeUpdate();

            return rows > 0;

        }catch(Exception e){

            e.printStackTrace();
        }

        return false;
    }
    
    public List<Bank> getAllBanks(){

        List<Bank> banks =
                new ArrayList<>();

        try{

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM banks";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()){

                Bank bank = new Bank();

                bank.setId(rs.getInt("id"));
                bank.setBankName(
                        rs.getString("bank_name"));
                bank.setLoanType(
                        rs.getString("loan_type"));
                bank.setInterestRate(
                        rs.getDouble("interest_rate"));
                bank.setMinIncome(
                        rs.getDouble("min_income"));
                bank.setMaxAmount(
                        rs.getDouble("max_amount"));
                bank.setMaxTenure(
                        rs.getInt("max_tenure"));
                bank.setProcessingFee(
                        rs.getDouble("processing_fee"));

                banks.add(bank);
            }

        }catch(Exception e){

            e.printStackTrace();
        }

        return banks;
    }
    
    public boolean deleteBank(int id){

        try{

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "DELETE FROM banks WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1,id);

            int rows =
                    ps.executeUpdate();

            return rows > 0;

        }catch(Exception e){

            e.printStackTrace();
        }

        return false;
    }
}