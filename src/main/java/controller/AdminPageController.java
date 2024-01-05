/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.CoachDAO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Coach;

/**
 * FXML Controller class
 *
 * @author Dewi
 */
public class AdminPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fillTable();
    }   
        @FXML
    private Button btnAboutUs;

    @FXML
    private Button btnDeleteCoach;

    @FXML
    private Button btnTambahCoach;

    @FXML
    private TableView<Coach> daftarCoach;

    @FXML
    void handleAboutUs(ActionEvent event) {

    }

    @FXML
    void handleDeleteCoach(ActionEvent event) {

    }
    
    @FXML
    void handlerTambahCoach(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnTambahCoach.getScene().getWindow();
                    URL url = new File("src/main/java/view/Signup_1.fxml").toURI().toURL();
                    Parent root = FXMLLoader.load(url);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
    }

    private void fillTable() {
        LinkedList<Coach> res = CoachDAO.getAll();
        
        daftarCoach.getColumns().clear();
        daftarCoach.getItems().clear();
        
        //tableView menyimpan objek story
        //Tapi di sini kita hanya akan menampilkan
        //2 atribut dari objek story,
        //yaitu sdate dan descrip seperti yang dilakukan di baris berikut
        //sebutkan nama kolom yang ingin muncul di tampilan tabel
        //kemudian sebutkan nama atribut dari objek story yang akan digunakan untu
        //mengisi kolom-kolom tsbt
        TableColumn<Coach, String> cl1 = new TableColumn<>("nama");
        cl1.setCellValueFactory(new PropertyValueFactory<>("nama"));
        TableColumn<Coach, String> cl2 = new TableColumn<>("pengalaman");
        
        cl2.setCellValueFactory(new PropertyValueFactory<>("pengalaman"));// Add two columns into TableView
        cl1.setPrefWidth(200);
        cl2.setPrefWidth(650);
        daftarCoach.getColumns().add(cl1);
        daftarCoach.getColumns().add(cl2);

        // Add data to table
        for (Coach coach : res) {
            daftarCoach.getItems().add(coach);
        }
        
    }

    
}