package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.DBConnection;
import entity.Committee;
import entity.Member;

public class CommitteeDAO{
    public void insert(Committee c){
        try{
            //Connection to Database
            Connection conn = DBConnection.getConnection();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Committee (Club_ID, Start_year, End_year) VALUES (?, ?, ?)");
            stmt.setInt(1, c.clubId);
            stmt.setInt(2, c.startYear);
            stmt.setInt(3, c.endYear);
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Committee> getAll(){
        List<Committee> list = new ArrayList<>();
        try{
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Committee");
            while (rs.next()) {
                list.add(new Committee(rs.getInt("Start_year"), rs.getInt("End_year"), rs.getInt("Club_ID")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public void update(Committee c){
        try{
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE Committee SET Start_year=? End_year=? WHERE Committee_ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, c.startYear);
            stmt.setInt(2, c.endYear);
            stmt.setInt(3, c.committeeId);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Committee WHERE Committee_ID=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
