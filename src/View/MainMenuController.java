package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;


public class MainMenuController {

    @FXML private Button createOrderBtn;


    public void createOrderBtnClick(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent createOrderView = FXMLLoader.load(getClass().getResource("../fxml/create_order_view.fxml"));
        Scene createOrderScene = new Scene(createOrderView);

        //Gets the stage information
        Stage window = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(createOrderScene);
        window.show();

    }

}
