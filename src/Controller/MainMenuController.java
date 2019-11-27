package Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MainMenuController {

    public void createOrderBtnClick(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent createOrderView = FXMLLoader.load(getClass().getResource("/View/view_orders.fxml"));
        Scene createOrderScene = new Scene(createOrderView);

        //Gets the stage information
        Stage window = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(createOrderScene);
        window.show();
    }

    public void createEmployeeBtnClick(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent createOrderView = FXMLLoader.load(getClass().getResource("/View/create_employee.fxml"));
        Scene createOrderScene = new Scene(createOrderView);

        //Gets the stage information
        Stage window = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(createOrderScene);
        window.show();
    }

    public void assignEmployeeBtnClick(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent createOrderView = FXMLLoader.load(getClass().getResource("/View/assign_employee.fxml"));
        Scene createOrderScene = new Scene(createOrderView);

        //Gets the stage information
        Stage window = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(createOrderScene);
        window.show();
    }

    public void calculatePayrollBtnClick(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent createOrderView = FXMLLoader.load(getClass().getResource("/View/calculate_payroll.fxml"));
        Scene createOrderScene = new Scene(createOrderView);

        //Gets the stage information
        Stage window = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(createOrderScene);
        window.show();
    }

    public void generateReportBtnClick(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent createOrderView = FXMLLoader.load(getClass().getResource("/View/generate_report.fxml"));
        Scene createOrderScene = new Scene(createOrderView);

        //Gets the stage information
        Stage window = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(createOrderScene);
        window.show();
    }


}
