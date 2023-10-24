package lk.ijse.thogakade.controller;

/*
    @author DanujaV
    @created 10/24/23 - 9:01 AM   
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.thogakade.db.DbConnection;
import lk.ijse.thogakade.model.CustomerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerFormController {
    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();

        var model = new CustomerModel();
        try {
            boolean isSaved = model.saveCustomer(id, name, address, tel);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String tel = txtTel.getText();

        var model = new CustomerModel();
        try {
            boolean isUpdated = model.updateCustomer(id, name, address, tel);
            System.out.println(isUpdated);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            Connection connection = DbConnection.getInstance().getConnection();

            String sql = "SELECT * FROM customer WHERE id = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);

            ResultSet resultSet = pstm.executeQuery();

            if(resultSet.next()) {
                String cus_id = resultSet.getString(1);
                String cus_name = resultSet.getString(2);
                String cus_address = resultSet.getString(3);
                String cus_tel = resultSet.getString(4);

                txtId.setText(cus_id);
                txtName.setText(cus_name);
                txtAddress.setText(cus_address);
                txtTel.setText(cus_tel);
            } else  {
                new Alert(Alert.AlertType.INFORMATION, "customer not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
       clearFields();
    }

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtTel.setText("");
    }
}
