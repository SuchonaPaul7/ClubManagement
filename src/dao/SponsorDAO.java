package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.DBConnection;
import entity.Member;
import entity.Sponsor;

public class SponsorDAO{
    public void insert(Sponsor s){
        try{
            //Connection to Database
            Connection conn = DBConnection.getConnection();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Sponsor (Organization, Email) VALUES (?, ?)");
            stmt.setString(1, s.organization);
            stmt.setString(2,s.email);
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Sponsor> getAll(){
        List<Sponsor> list = new ArrayList<>();
        try{
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Sponsor");
            while (rs.next()) {
                list.add(new Sponsor( rs.getString("Organization"),rs.getString("Email"), rs.getString("Mobile_number")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public void update(int mobileNumber, int id){
        try{
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE Sponsor SET Mobile_number=? WHERE Sponsor_ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1,mobileNumber);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void delete(int id){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Sponsor WHERE Sponsor_ID=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
