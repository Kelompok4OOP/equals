/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.CoachDAO;
import dao.CourseDAO;
import dao.UserDAO;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Coach;
import model.Course;
import model.User;

/**
 * FXML Controller class
 *
 * @author Dewi
 */
public class BuatPelatihanController implements Initializable {
    public static User user;
    public static Coach coach;
    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtKuota;

    @FXML
    private TextField txtMateri;

    @FXML
    private TextField txtNama;

    @FXML
    private TextField txtSoal;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    void loginHandler(ActionEvent event) throws IOException {
        String nama;
        int kuota;
        kuota = Integer.valueOf(txtKuota.getText());
        nama = txtNama.getText();
        String materi = txtMateri.getText();
        String soal = txtSoal.getText();
        Course co = new Course(nama,kuota,LoginController.coach,materi,soal);
        CourseDAO courseDAO = new CourseDAO();
        courseDAO.insertEntry(co);
        JOptionPane.showMessageDialog(null, " Registered " + nama + " Successfully. Please Login!");
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        URL url = new File("src/main/java/view/DashboardCoach.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
    }
    
}