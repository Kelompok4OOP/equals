/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dewi
 */
public class HomepageController implements Initializable {

    @FXML
    private Button btnAboutUs;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnSignup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAboutUs(ActionEvent event) throws IOException{
        Stage stage = (Stage) btnAboutUs.getScene().getWindow();
        URL url = new File("src/main/java/view/AboutUS.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("About Us");
        stage.show();
    }

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        URL url = new File("src/main/java/view/Login.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
        
    }

    @FXML
    private void SignUpHandler(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) btnSignup.getScene().getWindow();
        URL url = new File("src/main/java/view/Signup.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Signup");
        stage.show();
        
    }
    
}
