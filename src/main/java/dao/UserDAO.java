/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Dewi
 */
//package main.DAO;
import static dao.BaseDAO.closeCon;
import static dao.BaseDAO.getCon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import model.User;
import java.sql.PreparedStatement;
import java.util.UUID;
/*import static utils.BaseDao.DB_HOST;
import static utils.BaseDao.DB_NAME;
import static utils.BaseDao.DB_PASS;
import static utils.BaseDao.DB_USER;*/
/**
 *
 * @author Acer
 */
public class UserDAO {
    private String url;
    private String uname;
    private String pass;
    private String query;
    private static Connection con;
    private static Statement stmt;
    private static PreparedStatement st;
    
    public UserDAO(){
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
    public void register(User user){
        try{
            query = "INSERT INTO users VALUES('%s','%s','%s','%s','%s','%s','%s')";
            query = String.format(query,user.getUid(),user.getNama(), user.getEmail(),user.getGender(),user.getTanggalLahir(),user.getUsername(),user.getPassword());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        }
        catch(SQLException ex){
            System.err.print("Error inserting data:"+ex.getMessage());
            System.exit(1);
        }
    }
    
    public static User validate(String username, String password) {
        User u = null;
        try {
            con = getCon();
            String query = "select * from users where uname = '%s' and pword = '%s' ";
            query = String.format(query,
                    username,
                    password);
            st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                u = new User(UUID.fromString(rs.getString("uid"))
                        ,rs.getString("name")
                        ,rs.getDate("dob")
                        ,rs.getString("gender")
                        ,rs.getString("email")
                        , username
                        , password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return u;
    }
    
    public static User searchByUid(String username, String password) {
    User u = null;
    try {
        con = getCon();
        String query = "select * from users where uname = '%s' and pword = '%s'";
        query = String.format(query,
                    username,
                    password);

        st = con.prepareStatement(query);
        ResultSet rsUser = st.executeQuery();
        u = new User(UUID.fromString(rsUser.getString("uid")),rsUser.getString("name"),rsUser.getDate("dob"),rsUser.getString("gender"),rsUser.getString("email"),
                rsUser.getString("uname"), rsUser.getString("pword"));

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        closeCon(con);
    }
    return u;
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
    public void delete(User user){
        try{
            query = "DELETE FROM users WHERE nama = '%s'";
            query = String.format(query,user.getNama());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menghapus data!");   
        }
        catch(SQLException ex){
            System.err.print("Error getting the data: "+ex.getMessage());
            System.exit(1);
        }
    }
}