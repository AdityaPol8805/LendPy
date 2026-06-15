package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import util.DBConnection;
import java.sql.ResultSet;

public class UserDAO {


// Register User
public boolean registerUser(User user) {

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "INSERT INTO users(name,email,password) VALUES(?,?,?)";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getPassword());

        int rows = ps.executeUpdate();

        return rows > 0;

    } catch (Exception e) {

        e.printStackTrace();

    }

    return false;
}

// Login User
public boolean loginUser(String email, String password) {

    boolean status = false;

    try {

        Connection con = DBConnection.getConnection();

        String query =
                "SELECT * FROM users WHERE email=? AND password=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setString(1, email);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            status = true;

        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return status;
}
public int getUserIdByEmail(String email) {

int userId = 0;

try {

    Connection con = DBConnection.getConnection();

    String query = "SELECT id FROM users WHERE email=?";

    PreparedStatement ps = con.prepareStatement(query);

    ps.setString(1, email);

    ResultSet rs = ps.executeQuery();

    if (rs.next()) {

        userId = rs.getInt("id");

    }

} catch (Exception e) {

    e.printStackTrace();

}

return userId;


}



}
