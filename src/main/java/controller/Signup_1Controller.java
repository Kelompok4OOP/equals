/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.CoachDAO;
import dao.UserDAO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Coach;
import model.User;

/**
 * FXML Controller class
 *
 * @author Dewi
 */
public class Signup_1Controller implements Initializable {

    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtEmail;
    @FXML
    private DatePicker dateDOB;
    @FXML
    private RadioButton btnLk;
    @FXML
    private RadioButton btnPr;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnSignup;
    @FXML
    private ToggleGroup genderUser;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPengalaman;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlerSignup(ActionEvent event) throws IOException {
    String name = txtNama.getText();
    Date dob =  Date.valueOf(dateDOB.getValue()); 
    //String gender = genderUser.getValue();
    String gender;
    if(genderUser.getSelectedToggle().equals(btnLk)){
        gender = "Laki-laki";
    }
    else{
        gender = "Perempuan";
    }
    
    
    String email = txtEmail.getText();
    String username = txtUsername.getText();
    String password = txtPassword.getText();
    String pengalaman = txtPengalaman.getText();
    Coach c = new Coach(name,dob,gender, email,username, password, pengalaman);
    CoachDAO coachDAO = new CoachDAO();
    coachDAO.register(c);
    JOptionPane.showMessageDialog(null, " Registered " + username + " Successfully. Please Login!");
    Stage stage = (Stage) btnSignup.getScene().getWindow();
    URL url = new File("src/main/java/view/Homepage.fxml").toURI().toURL();
    Parent root = FXMLLoader.load(url);
    Scene scene = new Scene(root);
    stage.setScene(scene);
    } 
}