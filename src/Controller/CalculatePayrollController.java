package Controller;

import Model.Employee;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculatePayrollController implements Initializable {

    public void backBtnClick(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent createOrderView = FXMLLoader.load(getClass().getResource("../View/menu_view.fxml"));
        Scene createOrderScene = new Scene(createOrderView);

        //Gets the stage information
        Stage window = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(createOrderScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
