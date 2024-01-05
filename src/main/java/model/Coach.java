/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Dewi
 */

public class Coach extends Person {
    private String pengalaman;
    public Coach(String nama,Date tanggalLahir, String gender,String email,String username, String password, String pengalaman) {
        super(nama,tanggalLahir,gender,email,username,password);
        UUID uid = UUID.randomUUID();
        this.setUid(uid);
        this.setPengalaman(pengalaman);
    }
     public Coach(UUID uid, String nama,Date tanggalLahir, String gender,String email,String username, String password, String pengalaman) {
        super(uid,nama,tanggalLahir,gender,email,username,password);
        this.setPengalaman(pengalaman);
    }

    public String getPengalaman() {
        return pengalaman;
    }

    public void setPengalaman(String pengalaman) {
        this.pengalaman = pengalaman;
    }
    
}