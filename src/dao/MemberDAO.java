package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.DBConnection;
import entity.Member;

public class MemberDAO{
    public void insert(Member m){
        try{
            //Connection to Database
            Connection conn = DBConnection.getConnection();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Member (Student_ID, Name, Department, Club_ID) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, m.studentId);
            stmt.setString(2, m.name);
            stmt.setString(3,m.department);
            stmt.setInt(4, m.clubId);
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public List<Member> getAll(){
        List<Member> list = new ArrayList<>();
        try{
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Member");
            while (rs.next()) {
                list.add(new Member( rs.getString("Name"),rs.getInt("Student_ID"), rs.getString("Department"), rs.getInt("Club_ID")));
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

            String sql = "UPDATE Member SET Mobile_number=? WHERE Student_ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, mobileNumber);
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
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Member WHERE Student_ID=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
