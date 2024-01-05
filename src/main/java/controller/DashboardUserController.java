/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.CoachDAO;
import dao.CourseDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Coach;
import model.Course;

/**
 * FXML Controller class
 *
 * @author ASUS Vivobook
 */
public class DashboardUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            fillTable();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    @FXML
    private Button btnHome;

    @FXML
    private TableView<Course> daftarCourse;

    @FXML
    void handlerHome(ActionEvent event) {
        
    }
    private void fillTable() throws SQLException {
        LinkedList<Course> res = CourseDAO.getAllforuser();
        
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
