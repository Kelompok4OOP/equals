/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.UUID;

/**
 *
 * @author Dewi
 */
public class Course {
    private UUID coid;
    private String nama;
    private int kuota;
    private String materi;
    private String soal;
    private Coach pembuat;

    public String getMateri() {
        return materi;
    }

    public void setMateri(String materi) {
        this.materi = materi;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }
    
    
    
    public UUID getCoid() {
        return coid;
    }

    public void setCoid(UUID coid) {
        this.coid = coid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKuota() {
        return kuota;
    }

    public void setKuota(int kuota) {
        this.kuota = kuota;
    }

    public Coach getPembuat() {
        return pembuat;
    }

    public void setPembuat(Coach pembuat) {
        this.pembuat = pembuat;
    }

    public Course(String nama, int kuota, Coach pembuat, String materi, String soal) {
        this.nama = nama;
        this.kuota = kuota;
        this.pembuat = pembuat;
        this.materi= materi;
        this.soal=soal;
        UUID coid = UUID.randomUUID();
        this.setCoid(coid);
    
    }

    public Course(UUID coid, String nama, int kuota, Coach pembuat, String materi, String soal) {
        this.coid = coid;
        this.nama = nama;
        this.kuota = kuota;
        this.pembuat = pembuat;
        this.materi= materi;
        this.soal=soal;
    }

    public Course(UUID coid, String nama, int kuota, String materi, String soal) {
        this.coid = coid;
        this.nama = nama;
        this.kuota = kuota;
        this.materi = materi;
        this.soal = soal;
    }
    
    
    
    
    
    
    
}