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
    public void initialize() {
        drivers = FXCollections.observableArrayList();
        drivers.addAll(bl.getPilots());
        listDrivers.setItems(drivers);
        
        // Create a binding that updates when the list changes
        numDrivers.setText(String.valueOf(drivers.size()));
        drivers.addListener((javafx.collections.ListChangeListener<Pilot>) c -> numDrivers.setText(String.valueOf(drivers.size())));
    }


}
