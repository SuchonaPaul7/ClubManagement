package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import entity.Advisor;
import entity.Member;

public class AdvisorDAO {
    public void insert(Advisor a) {
        try {
            //Connection to Database
            Connection conn = DBConnection.getConnection();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Advisor (Name, Department, Club_ID) VALUES (?, ?, ?)");
            stmt.setString(1, a.name);
            stmt.setString(2, a.department);
            stmt.setInt(3, a.clubId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Advisor> getAll() {
        List<Advisor> list = new ArrayList<>();
        try{
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Advisor");
            while (rs.next()) {
                list.add(new Advisor( rs.getString("Name"),rs.getInt("Advisor_ID"), rs.getString("Department"), rs.getInt("Club_ID")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public void update(int mobileNumber, int id) {
        try{
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE Advisor SET Mobile_number=? WHERE Advisor_ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, mobileNumber);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Advisor WHERE Advisor_ID=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}