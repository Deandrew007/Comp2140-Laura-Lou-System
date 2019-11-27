package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateEmployeeController {

    public void backBtnClick(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent createOrderView = FXMLLoader.load(getClass().getResource("../View/menu_view.fxml"));
        Scene createOrderScene = new Scene(createOrderView);

        //Gets the stage information
        Stage window = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(createOrderScene);
        window.show();
    }

}
