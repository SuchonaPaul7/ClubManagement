package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.DBConnection;
import entity.Club;
import entity.Member;

public class ClubDAO{
    public void insert(Club cl){
        try{
            //Connection to Database
            Connection conn = DBConnection.getConnection();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Club (Club_name, Budget) VALUES (?, ?)");
            stmt.setString(1, cl.clubName);
            stmt.setFloat(2,cl.budget);
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public List<Club> getAll(){
        List<Club> list = new ArrayList<>();
        try{
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Club");
            while (rs.next()) {
                list.add(new Club(rs.getInt("Club_ID"),rs.getString("Club_name"), rs.getFloat("Budget")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public void update(Club cl){
        try{
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE CLub SET Club_name=? WHERE Budget=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, cl.clubName);
            stmt.setFloat(2, cl.budget);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void delete(int id){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Club WHERE Club_ID=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
