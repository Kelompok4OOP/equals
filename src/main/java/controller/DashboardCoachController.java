/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import controller.LoginController;
import dao.CoachDAO;
import dao.CourseDAO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Coach;
import model.Course;

/**
 * FXML Controller class
 *
 * @author ASUS Vivobook
 */
public class DashboardCoachController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Course> daftarCourse;

    @FXML
    private Button btnHome;

    @FXML
    private Label tambahCourse;
    

    @FXML
    void handlerHome(ActionEvent event) {

    }

    @FXML
    void buatPelatihan(MouseEvent event) throws IOException {
        Stage stage = (Stage) tambahCourse.getScene().getWindow();
                    URL url = new File("src/main/java/view/buatPelatihan.fxml").toURI().toURL();
                    Parent root = FXMLLoader.load(url);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
    }

   
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        try {
            fillTable();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardCoachController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fillTable() throws SQLException {
        LinkedList<Course> res = CourseDAO.getAll(LoginController.coach);
        
        daftarCourse.getColumns().clear();
        daftarCourse.getItems().clear();
        
        //tableView menyimpan objek story
        //Tapi di sini kita hanya akan menampilkan
        //2 atribut dari objek story,
        //yaitu sdate dan descrip seperti yang dilakukan di baris berikut
        //sebutkan nama kolom yang ingin muncul di tampilan tabel
        //kemudian sebutkan nama atribut dari objek story yang akan digunakan untu
        //mengisi kolom-kolom tsbt
        TableColumn<Course, String> cl1 = new TableColumn<>("nama");
        cl1.setCellValueFactory(new PropertyValueFactory<>("nama"));
        TableColumn<Course, String> cl2 = new TableColumn<>("kuota");
        
        cl2.setCellValueFactory(new PropertyValueFactory<>("kuota"));// Add two columns into TableView
        cl1.setPrefWidth(200);
        cl2.setPrefWidth(650);
        daftarCourse.getColumns().add(cl1);
        daftarCourse.getColumns().add(cl2);

        // Add data to table
        for (Course course : res) {
            daftarCourse.getItems().add(course);
        }
        
    }
}
