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
public class User extends Person {
     public User(String nama,Date tanggalLahir, String gender,String email,String username, String password) {
        super(nama,tanggalLahir,gender,email,username,password);
        UUID uid = UUID.randomUUID();
        this.setUid(uid);
    }
     public User(UUID uid, String nama,Date tanggalLahir, String gender,String email,String username, String password) {
        super(uid,nama,tanggalLahir,gender,email,username,password);
    }
}
