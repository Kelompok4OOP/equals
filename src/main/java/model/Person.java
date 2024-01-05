/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dewi
 */
import java.util.Date;
import java.util.UUID;


public class Person {
    UUID uid;
    private String nama;
    private Date tanggalLahir;
    private String gender;
    private String email;
    private String username;
    private String password;

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   
    
    public boolean login(String username, String password) {
        // Implement login logic for Person here
        // Return true if login is successful, false otherwise
        return this.nama.equals(username) && this.password.equals(password);
    }
    
    public Person(UUID uid, String nama,Date tanggalLahir, String gender,String email,String username, String password) {
        // Create a new Person instance and set the provided attributes
        //Person person = new Person();
        this.setUid(uid);
        this.setNama(nama);
        this.setTanggalLahir(tanggalLahir);
        this.setGender(gender);
        this.setEmail(email);
        this.setUsername(username);
        this.setPassword(password);
        //return person;
    }
    public Person(String nama,Date tanggalLahir, String gender,String email,String username, String password) {
        // Create a new Person instance and set the provided attributes
        //Person person = new Person();
        this.setUid(uid);
        this.setNama(nama);
        this.setTanggalLahir(tanggalLahir);
        this.setGender(gender);
        this.setEmail(email);
        this.setUsername(username);
        this.setPassword(password);
        //return person;
    }
    /*public Person(int ID, String nama, String gender, String usia, String password){
        this.ID=ID;
        this.nama=nama;
        this.gender=gender;
        this.usia=usia;
        this.password=password;
    }*/
}
