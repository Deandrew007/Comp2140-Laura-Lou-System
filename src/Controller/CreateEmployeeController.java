package Controller;

import Model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.control.cell.TextFieldTableCell.forTableColumn;

public class CreateEmployeeController implements Initializable {

    @FXML private TableView<Employee> tableView;
    @FXML private TableColumn<Employee, String> name;
    @FXML private TableColumn<Employee, String> position;
    @FXML private TableColumn<Employee, Integer> skill;
    @FXML private TableColumn<Employee, Integer> workhours;
    @FXML private TableColumn<Employee, Double> payRate;

    @FXML private TextField nameTextField;
    @FXML private TextField positionTextField;
    @FXML private TextField skillTextField;
    @FXML private TextField workhoursTextField;
    @FXML private TextField payRateTextField;

    public void changeNameCellEvent(TableColumn.CellEditEvent cellEditEvent) {
        Employee employeeSelected = tableView.getSelectionModel().getSelectedItem();
        employeeSelected.setName(cellEditEvent.getNewValue().toString());
    }

    public void changePositionCellEvent(TableColumn.CellEditEvent cellEditEvent) {
        Employee employeeSelected = tableView.getSelectionModel().getSelectedItem();
        employeeSelected.setPosition1(cellEditEvent.getNewValue().toString());
    }
    public void changeSkillCellEvent(TableColumn.CellEditEvent cellEditEvent) {
        Employee employeeSelected = tableView.getSelectionModel().getSelectedItem();
        employeeSelected.setSkillLevel((Integer) cellEditEvent.getNewValue());
    }
    public void changeWorkHoursCellEvent(TableColumn.CellEditEvent cellEditEvent) {
        Employee employeeSelected = tableView.getSelectionModel().getSelectedItem();
        employeeSelected.setWorkHours((Integer) cellEditEvent.getNewValue());
    }
    public void changePayRateCellEvent(TableColumn.CellEditEvent cellEditEvent) {
        Employee employeeSelected = tableView.getSelectionModel().getSelectedItem();
        employeeSelected.setPayrate((Double) cellEditEvent.getNewValue());
    }

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

        name.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        position.setCellValueFactory(new PropertyValueFactory<Employee, String>("position1"));
        skill.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("skillLevel"));
        workhours.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("workHours"));
        payRate.setCellValueFactory(new PropertyValueFactory<Employee, Double>("payrate"));

        tableView.setItems(getEmployees());

        tableView.setEditable(true);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        position.setCellFactory(TextFieldTableCell.forTableColumn());
        skill.setCellFactory(TextFieldTableCell.<Employee, Integer>forTableColumn(new IntegerStringConverter()));
        workhours.setCellFactory(TextFieldTableCell.<Employee, Integer>forTableColumn(new IntegerStringConverter()));
        payRate.setCellFactory(TextFieldTableCell.<Employee, Double>forTableColumn(new DoubleStringConverter()));

        //This will allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void saveEmployee()
    {
        Employee newEmployee = new Employee(nameTextField.getText(),
                positionTextField.getText(),
                Integer.parseInt(skillTextField.getText()),
                Integer.parseInt(workhoursTextField.getText()),
                Double.parseDouble(payRateTextField.getText()));

        //Get all the items from the table as a list, then add the new person to
        //the list
        tableView.getItems().add(newEmployee);
    }

    /**
     * This method will remove the selected row(s) from the table
     */
    public void deleteButtonPushed()
    {
        ObservableList<Employee> selectedRows, allEmployee;
        allEmployee = tableView.getItems();

        //this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the Person objects from the table
        for (Employee employee: selectedRows)
        {
            allEmployee.remove(employee);
        }
    }

    private ObservableList<Employee> getEmployees(){

        ObservableList<Employee> employees = FXCollections.observableArrayList();
        employees.add(new Employee("Mary Jane", "Seamtress", 3, 40, 50));
        employees.add(new Employee("Yvonne Moore", "Supervisor", 5, 40, 70));
        return employees;
    }

}
