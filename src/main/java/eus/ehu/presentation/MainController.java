package eus.ehu.presentation;
import eus.ehu.businesslogic.BlInterface;
import eus.ehu.businesslogic.BusinessLogic;
import eus.ehu.domain.Pilot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class MainController {

    @FXML
    private ListView<Pilot> listDrivers;

    private ObservableList<Pilot> drivers;

    private BlInterface bl = new BusinessLogic();

    @FXML
    public void initialize() {
        drivers = FXCollections.observableArrayList();
        drivers.addAll(bl.getPilots());
        listDrivers.setItems(drivers);
    }


}
