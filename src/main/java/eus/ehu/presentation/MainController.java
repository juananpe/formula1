package eus.ehu.presentation;
import eus.ehu.businesslogic.BlInterface;
import eus.ehu.businesslogic.BusinessLogic;
import eus.ehu.domain.Pilot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;

public class MainController {

    @FXML
    private ListView<Pilot> listDrivers;

    private ObservableList<Pilot> drivers;

    private BlInterface bl = new BusinessLogic();

    @FXML
    private Label numDrivers;

    @FXML
    void onDelete(ActionEvent event) {
        // print the selected pilot
        Pilot selectedPilot = listDrivers.getSelectionModel().getSelectedItem();
        System.out.println(selectedPilot);
        // delete the selected pilot from the database
        bl.deletePilot(selectedPilot);
        // delete the selected pilot from the list
        drivers.remove(selectedPilot);

    }

    @FXML
    void onAdd(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add New Driver");
        dialog.setHeaderText("Enter driver details");
        dialog.setContentText("Driver name:");

        dialog.showAndWait().ifPresent(name -> {
            if (!name.isEmpty()) {
                bl.storePilot(name, "Unknown", 0);
                drivers.clear();
                drivers.addAll(bl.getPilots());
            }
        });
    }

    @FXML
    public void initialize() {
        drivers = FXCollections.observableArrayList();
        drivers.addAll(bl.getPilots());
        listDrivers.setItems(drivers);
        
        // Create a binding that updates when the list changes
        numDrivers.setText(String.valueOf(drivers.size()));
        drivers.addListener((javafx.collections.ListChangeListener<Pilot>) c -> numDrivers.setText(String.valueOf(drivers.size())));
    }


}
