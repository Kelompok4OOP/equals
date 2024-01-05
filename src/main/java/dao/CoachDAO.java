/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package dao;

import static dao.BaseDAO.closeCon;
import static dao.BaseDAO.getCon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.UUID;
import model.Coach;

public class CoachDAO {
    private String url;
    private String uname;
    private String pass;
    private String query;
    private static Connection con;
    private static Statement stmt;
    private static PreparedStatement st;
    
    public CoachDAO(){
        url="jdbc:mysql://localhost/equals";
        uname="root";
        pass="";
        setConnectionAndStatement();
        
    }
    private void setConnectionAndStatement(){
        try{
            con=DriverManager.getConnection(url,uname,pass);
            stmt=con.createStatement();
            
        }
        catch(SQLException ex){
            System.err.print(ex.getMessage());
            System.exit(1);
        }
    }
    public void register(Coach coach){
        try{
            query = "INSERT INTO coaches VALUES('%s','%s','%s','%s','%s','%s','%s','%s')";
            query = String.format(query,coach.getUid(),coach.getNama(), coach.getEmail(),coach.getGender(),coach.getTanggalLahir(),coach.getUsername(),coach.getPassword(), coach.getPengalaman());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        }
        catch(SQLException ex){
            System.err.print("Error inserting data:"+ex.getMessage());
            System.exit(1);
        }
    }
    
    public static Coach validate(String username, String password) {
        Coach c = null;
        try {
            con = getCon();
            String query = "select * from coaches where uname = '%s' and pword = '%s' ";
            query = String.format(query,
                    username,
                    password);
            st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                c = new Coach(UUID.fromString(rs.getString("cid"))
                        ,rs.getString("name")
                        ,rs.getDate("dob")
                        ,rs.getString("gender")
                        ,rs.getString("email")
                        , username
                        , password
                ,rs.getString("pengalaman"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return c;
    }
    
    public static Coach searchByUid(String uid) {
    Coach c = null;
    try {
        con = getCon();
        String query = "select * from coaches where uid = '%s'";
        query = String.format(query, uid);

        st = con.prepareStatement(query);
        ResultSet rsUser = st.executeQuery();
        c = new Coach(UUID.fromString(rsUser.getString("cid")),rsUser.getString("nama"),rsUser.getDate("dob"),rsUser.getString("gender"),rsUser.getString("email"),
                rsUser.getString("uname"), rsUser.getString("pword"),rsUser.getString("pengalaman"));

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        closeCon(con);
    }
    return c;
}
    
    /*public User get(String nama, String password){
        User u = null;
        //boolean login=false;
        try{
            String query = "SELECT * FROM user WHERE nama='&s' AND password='&s'";
            query = String.format(query, nama,password);
            ResultSet rs = stmt.executeQuery(query);
            
            if(rs.next()!=false){
                u = new User(
                        u.setUid(rs.getString("uid")),
                        u.setNama(rs.getString("nama")),
                        u.setTanggalLahir(rs.getString("tanggalLahir")),
                        u.setGender(rs.getString("gender")),
                        u.setEmail(rs.getString("email")),
                        u.setUsername(rs.getString("username")),
                        u.setPassword(rs.getString("password")));
                //user.setNama(rs.getString("nama"));
                //user.setGender(rs.getString("gender"));
                //user.setUsia(rs.getString("usia"));
                //user.setPassword(rs.getString("password"));
                //user.setLogin(true);
                
            }else{
               //user.setLogin(false);
               System.out.print("data tidak ditemukan");
            }
        }catch(SQLException ex){
            System.err.print("Error getting the data: "+ex.getMessage());
            System.exit(1);
        }
        return u;
    }*/
    public void delete(Coach coach){
        try{
            query = "DELETE FROM coaches WHERE name = '%s'";
            query = String.format(query,coach.getNama());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menghapus data!");   
        }
        catch(SQLException ex){
            System.err.print("Error getting the data: "+ex.getMessage());
            System.exit(1);
        }
    }
    public static LinkedList<Coach> getAll() {
        LinkedList<Coach> res = new LinkedList<>();
        try {
            con = getCon();
            String query = "select * from coaches ";

            query = String.format(query);
            st = con.prepareStatement(query);
            ResultSet rsUser = st.executeQuery();
            while (rsUser.next()) {
                Coach c = new Coach(UUID.fromString(rsUser.getString("cid")),rsUser.getString("name"),rsUser.getDate("dob"),rsUser.getString("gender"),rsUser.getString("email"),
                rsUser.getString("uname"), rsUser.getString("pword"),rsUser.getString("pengalaman"));
                res.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return res;
    }
}