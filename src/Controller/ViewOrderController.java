package Controller;

import Model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

import static javafx.scene.control.cell.TextFieldTableCell.forTableColumn;

public class ViewOrderController implements Initializable {

    @FXML private TableView<Order> tableView;
    @FXML private TableColumn<Order, String> clientNameColumn;
    @FXML private TableColumn<Order, Integer> refNo;
    @FXML private TableColumn<Order, Double> Payment;
    @FXML private TableColumn<Order, LocalDate> dueDate;
    @FXML private TableColumn<Order, LocalDate> recDate;
    @FXML private TableColumn<Order, String> color;
    @FXML private TableColumn<Order, Integer> size;
    @FXML private TableColumn<Order, Integer> qty;
    @FXML private TableColumn<Order, String> garment;

    @FXML private TextField clientNameTextField;
    @FXML private TextField refNoTextField;
    @FXML private TextField paymentTextField;
    @FXML private DatePicker dueDatePicker;
    @FXML private DatePicker recDatePicker;
    @FXML private TextField colorTextField;
    @FXML private TextField sizeTextField;
    @FXML private TextField qtyTextField;
    @FXML private TextField garmentTextField;

    public void changeClientNameCellEvent(TableColumn.CellEditEvent cellEditEvent) {
        Order clientSelected = tableView.getSelectionModel().getSelectedItem();
        clientSelected.setClientName(cellEditEvent.getNewValue().toString());
    }
    public void changePaymentCellEvent(TableColumn.CellEditEvent cellEditEvent) {
        Order paymentSelected = tableView.getSelectionModel().getSelectedItem();
        paymentSelected.setPayment((Double) cellEditEvent.getNewValue());
    }
    public void changeColorCellEvent(TableColumn.CellEditEvent cellEditEvent) {
        Order colorSelected = tableView.getSelectionModel().getSelectedItem();
        colorSelected.setColour(cellEditEvent.getNewValue().toString());
    }
    public void changeSizeCellEvent(TableColumn.CellEditEvent cellEditEvent) {
        Order sizeSelected = tableView.getSelectionModel().getSelectedItem();
        sizeSelected.setSize((Integer) cellEditEvent.getNewValue());
    }
    public void changeQtyCellEvent(TableColumn.CellEditEvent cellEditEvent) {
        Order qtySelected = tableView.getSelectionModel().getSelectedItem();
        qtySelected.setQuantity((Integer) cellEditEvent.getNewValue());
    }
    public void changeGarmentCellEvent(TableColumn.CellEditEvent cellEditEvent) {
        Order garmentSelected = tableView.getSelectionModel().getSelectedItem();
        garmentSelected.setGarment(cellEditEvent.getNewValue().toString());
    }

    public void backBtnClick(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/View/menu_view.fxml"));
        Scene scene = new Scene(parent);

        //Gets the stage information
        Stage window = (Stage)((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientNameColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("clientName"));
        refNo.setCellValueFactory(new PropertyValueFactory<Order, Integer>("refNum"));
        Payment.setCellValueFactory(new PropertyValueFactory<Order, Double>("payment"));
        dueDate.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("dateDue"));
        recDate.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("dateRec"));
        color.setCellValueFactory(new PropertyValueFactory<Order, String>("colour"));
        size.setCellValueFactory(new PropertyValueFactory<Order, Integer>("size"));
        qty.setCellValueFactory(new PropertyValueFactory<Order, Integer>("quantity"));
        garment.setCellValueFactory(new PropertyValueFactory<Order, String>("garment"));

        tableView.setItems(getOrders());

        tableView.setEditable(true);
        clientNameColumn.setCellFactory(forTableColumn());
        refNo.setCellFactory(TextFieldTableCell.<Order, Integer>forTableColumn(new IntegerStringConverter()));
        Payment.setCellFactory(TextFieldTableCell.<Order, Double>forTableColumn(new DoubleStringConverter()));
        color.setCellFactory(forTableColumn());
        size.setCellFactory(TextFieldTableCell.<Order, Integer>forTableColumn(new IntegerStringConverter()));
        qty.setCellFactory(TextFieldTableCell.<Order, Integer>forTableColumn(new IntegerStringConverter()));
        garment.setCellFactory(forTableColumn());

        //This will allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


    }

    public void saveOrderBtnClick() {

        Order newOrder = new Order(clientNameTextField.getText(),
                Integer.parseInt(refNoTextField.getText()),
                Double.parseDouble(paymentTextField.getText()),
                dueDatePicker.getValue(),
                recDatePicker.getValue(),
                colorTextField.getText(),
                Integer.parseInt(sizeTextField.getText()),
                Integer.parseInt(qtyTextField.getText()),
                garmentTextField.getText());

        tableView.getItems().add(newOrder);
    }

    /**
     * This method will remove the selected row(s) from the table
     */
    public void deleteButtonPushed()
    {
        ObservableList<Order> selectedRows, allOrder;
        allOrder = tableView.getItems();

        //this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the Person objects from the table
        for (Order order: selectedRows)
        {
            allOrder.remove(order);
        }
    }


    private ObservableList<Order> getOrders(){

        ObservableList<Order> orders = FXCollections.observableArrayList();
        orders.add(new Order("Heart Trust", 12345 , 20000, LocalDate.of(2019, Month.NOVEMBER, 27), LocalDate.of(2019, Month.DECEMBER, 28),
                "White", 12, 50, "Blouse"));
        orders.add(new Order("Merl Grove", 23456 , 100000, LocalDate.of(2019, Month.NOVEMBER, 27), LocalDate.of(2019, Month.DECEMBER, 28),
                "Blue", 12, 100, "Tunic"));
        return orders;
    }
}
