/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ac.msruas.apclab.cse159;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author shadowleaf
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane attendanceScreen;
    @FXML
    private Button button2;
    @FXML
    private AnchorPane studentListScreen;
    @FXML
    private Button button1;
    
    @FXML
    private Label totalPresent;
    @FXML
    private VBox studentsList;
    @FXML
    private Label totalAbsent;
    @FXML
    private Label totalStudents;
    
    private Integer ts;
    private Integer tp;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ts = studentsList.getChildren().size();
        tp = 0;
    }

    @FXML
    private void goToAttendance(ActionEvent event) {
        studentListScreen.toFront();
    }

    @FXML
    private void goToStudentList(ActionEvent event) {
        totalPresent.setText(tp.toString());
        totalAbsent.setText((ts-tp)+"");
        totalStudents.setText(ts.toString());
        attendanceScreen.toFront();
    }

    @FXML
    private void updateAttendance(ActionEvent event) {
        CheckBox checkbox = (CheckBox) event.getSource();
        if (checkbox.isSelected()) {
            tp++;
        } else {
            tp--;
        }
    }

}
