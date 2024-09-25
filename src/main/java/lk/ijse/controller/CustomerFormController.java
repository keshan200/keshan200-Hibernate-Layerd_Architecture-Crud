package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.DTO.CustomerDTO;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.BOTypes;
import lk.ijse.bo.CustomerBO;
import lk.ijse.bo.impl.CustomerBOImpl;

public class CustomerFormController {


    @FXML
    private TableColumn<?, ?> colAdrs;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<?> tblCustomer;

    @FXML
    private TextField txtAdrs;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;


    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getSuperBO(BOTypes.Customerbo);


    @FXML
    void btnDelete(ActionEvent event) {

        String id = txtID.getText();

        try {
            boolean isDeleted = customerBO.deleteCustomer(id);

            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer has been deleted").show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnSave(ActionEvent event) {

        String id = txtID.getText();
        String name = txtName.getText();
        String adrs = txtAdrs.getText();

        try {
            boolean isSaved = customerBO.saveCustomer(new CustomerDTO(id,name,adrs));

            if (isSaved) {
               new Alert(Alert.AlertType.CONFIRMATION,"Customer Saved").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    @FXML
    void btnUpdate(ActionEvent event) {
        String id = txtID.getText();
        String name = txtName.getText();
        String adrs = txtAdrs.getText();

        try {
            boolean isUpdated = customerBO.updateCustomer(new CustomerDTO(id,name,adrs));

            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Updated").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

}

