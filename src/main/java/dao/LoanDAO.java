package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Loan;
import util.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class LoanDAO {

	public boolean applyLoan(Loan loan) {

	    try {

	        Connection con = DBConnection.getConnection();

	        String query =
	        "INSERT INTO loans(user_id, loan_type, amount, income, interest_rate, tenure, emi, status, reason, bank_name, processing_fee) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ps.setInt(1, loan.getUserId());
	        ps.setString(2, loan.getLoanType());
	        ps.setDouble(3, loan.getAmount());
	        ps.setDouble(4, loan.getIncome());
	        ps.setDouble(5, loan.getInterestRate());
	        ps.setInt(6, loan.getTenure());
	        ps.setDouble(7, loan.getEmi());
	        ps.setString(8, loan.getStatus());
	        ps.setString(9, loan.getReason());

	        ps.setString(10, loan.getBankName());
	        ps.setDouble(11, loan.getProcessingFee());

	        int rows = ps.executeUpdate();

	        return rows > 0;

	    } catch(Exception e) {

	        e.printStackTrace();

	    }

	    return false;
	}
	
public List<Loan> getLoansByUserId(int userId) {

    List<Loan> loans = new ArrayList<>();

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "SELECT * FROM loans WHERE user_id=? ORDER BY created_at DESC";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {

            Loan loan = new Loan();

            loan.setId(rs.getInt("id"));
            loan.setUserId(rs.getInt("user_id"));
            loan.setLoanType(rs.getString("loan_type"));
            loan.setAmount(rs.getDouble("amount"));
            loan.setIncome(rs.getDouble("income"));
            loan.setInterestRate(rs.getDouble("interest_rate"));
            loan.setTenure(rs.getInt("tenure"));
            loan.setEmi(rs.getDouble("emi"));
            loan.setStatus(rs.getString("status"));
            loan.setReason(rs.getString("reason"));
            loan.setBankName(rs.getString("bank_name"));
            loan.setProcessingFee(rs.getDouble("processing_fee"));
            loan.setCreatedAt(rs.getString("created_at"));
            loans.add(loan);
        }

    } catch(Exception e) {

        e.printStackTrace();

    }

    return loans;
}

public List<Loan> getLoansByUserId1(int userId) {

    List<Loan> loans = new ArrayList<>();

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "SELECT * FROM loans WHERE user_id=? ORDER BY created_at DESC";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {

            Loan loan = new Loan();

            loan.setUserId(rs.getInt("user_id"));
            loan.setLoanType(rs.getString("loan_type"));
            loan.setAmount(rs.getDouble("amount"));
            loan.setIncome(rs.getDouble("income"));
            loan.setInterestRate(rs.getDouble("interest_rate"));
            loan.setTenure(rs.getInt("tenure"));
            loan.setEmi(rs.getDouble("emi"));
            loan.setStatus(rs.getString("status"));
            loan.setReason(rs.getString("reason"));
            loan.setCreatedAt(rs.getString("created_at"));
            loan.setBankName(rs.getString("bank_name"));
            loan.setProcessingFee(rs.getDouble("processing_fee"));

            loans.add(loan);
        }

    } catch(Exception e) {

        e.printStackTrace();

    }

    return loans;
}

public List<Loan> getAllLoans() {

    List<Loan> loans = new ArrayList<>();

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "SELECT * FROM loans ORDER BY created_at DESC";

        PreparedStatement ps =
                con.prepareStatement(query);

        ResultSet rs =
                ps.executeQuery();

        while(rs.next()) {

            Loan loan = new Loan();

            loan.setId(rs.getInt("id"));
            loan.setUserId(rs.getInt("user_id"));
            loan.setLoanType(rs.getString("loan_type"));
            loan.setAmount(rs.getDouble("amount"));
            loan.setIncome(rs.getDouble("income"));
            loan.setInterestRate(rs.getDouble("interest_rate"));
            loan.setTenure(rs.getInt("tenure"));
            loan.setEmi(rs.getDouble("emi"));
            loan.setStatus(rs.getString("status"));
            loan.setReason(rs.getString("reason"));
            loan.setCreatedAt(rs.getString("created_at"));
            loan.setBankName(rs.getString("bank_name"));
            loan.setProcessingFee(rs.getDouble("processing_fee"));

            loans.add(loan);
        }

    } catch(Exception e) {

        e.printStackTrace();

    }

    return loans;
}

public boolean updateLoanStatus(int loanId,
        String status) {

try {

Connection con =
DBConnection.getConnection();

String query =
"UPDATE loans SET status=? WHERE id=?";

PreparedStatement ps =
con.prepareStatement(query);

ps.setString(1, status);
ps.setInt(2, loanId);

int rows =
ps.executeUpdate();

return rows > 0;

} catch(Exception e) {

e.printStackTrace();

}

return false;
}

public int getTotalLoans() {

    int count = 0;

    try {

        Connection con = DBConnection.getConnection();

        String query = "SELECT COUNT(*) FROM loans";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            count = rs.getInt(1);

        }

    } catch(Exception e) {

        e.printStackTrace();

    }

    return count;
}

public int getApprovedLoans() {

    int count = 0;

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "SELECT COUNT(*) FROM loans WHERE status='Approved'";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            count = rs.getInt(1);

        }

    } catch(Exception e) {

        e.printStackTrace();

    }

    return count;
}

public int getRejectedLoans() {

    int count = 0;

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "SELECT COUNT(*) FROM loans WHERE status='Rejected'";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            count = rs.getInt(1);

        }

    } catch(Exception e) {

        e.printStackTrace();

    }

    return count;
}

public int getPendingLoans() {

    int count = 0;

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "SELECT COUNT(*) FROM loans WHERE status='Pending'";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            count = rs.getInt(1);

        }

    } catch(Exception e) {

        e.printStackTrace();

    }

    return count;
}

public int getUserLoanCount(int userId) {

    int count = 0;

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "SELECT COUNT(*) FROM loans WHERE user_id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            count = rs.getInt(1);

        }

    } catch(Exception e) {

        e.printStackTrace();

    }

    return count;
}

public int getUserApprovedLoanCount(int userId) {

    int count = 0;

    try {

        Connection con = DBConnection.getConnection();

        String query =
        "SELECT COUNT(*) FROM loans WHERE user_id=? AND status='Approved'";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            count = rs.getInt(1);

        }

    } catch(Exception e) {

        e.printStackTrace();

    }

    return count;
}

public int getUserPendingLoanCount(int userId) {

    int count = 0;

    try {

        Connection con = DBConnection.getConnection();

        String query =
        "SELECT COUNT(*) FROM loans WHERE user_id=? AND status='Pending'";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {

            count = rs.getInt(1);

        }

    } catch(Exception e) {

        e.printStackTrace();

    }

    return count;
}


}
