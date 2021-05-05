package com.diploma.demo.view.landplot;

import com.diploma.demo.core.landplot.LandPlot;
import com.diploma.demo.core.landplot.service.LandPlotService;
import com.diploma.demo.core.landplot.service.impl.LandPlotServiceImpl;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@FxmlView("land-plot.fxml")
public class LandPlotControllerRead {
    LandPlotServiceImpl landPlotService;

    @FXML
    private TableView tableView;

    @FXML
    void initialize() {
        update();
    }

    void update() {
        TableColumn<LandPlot, Long> nameColumn = new TableColumn<>("ID");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.tableView.getColumns().add(nameColumn);

        TableColumn<LandPlot, Long> appart = new TableColumn<>("Appartamentn");
        appart.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getAddress().getApartmentn()).asObject());
        this.tableView.getColumns().add(appart);


        TableColumn<LandPlot, String> cityColumn = new TableColumn<>("City");
        cityColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getCity()));
        this.tableView.getColumns().add(cityColumn);


        TableColumn<LandPlot, String> homeNumber =   new TableColumn<>("Home number");
        homeNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getHomeNumber()));
        this.tableView.getColumns().add(homeNumber);


        TableColumn<LandPlot, String> region  = new TableColumn<>("Region");
        region.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getRegion()));
        this.tableView.getColumns().add(region);

        TableColumn<LandPlot, String> street  = new TableColumn<>("Street");
        street.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress().getStreet()));
        this.tableView.getColumns().add(street);

        addStringValueInTable("cadastral_number", "cadastralNumber");
        addStringValueInTable("Category", "category");
        addStringValueInTable("Current marks", "currentMarks");
        addStringValueInTable("Intended use", "intendedUse");
        addStringValueInTable("Purpose", "landPlotPurpose");
        addStringValueInTable("Notes", "notes");

        List<LandPlot> plots = landPlotService.getAll();
        for (int i = 0; i < plots.size(); i += 1) {
            System.out.println(plots.get(i).getLandPlotPurpose());
        }
        this.tableView.getItems().addAll(plots);
    }

    private void addStringValueInTable(String name, String nameInDatabase) {
        System.out.println("name : " + name);
        System.out.println("nameInDatabase : " + nameInDatabase);

        TableColumn<LandPlot, String> columm = new TableColumn<>(name);
        columm.setCellValueFactory(new PropertyValueFactory<>(nameInDatabase));
        this.tableView.getColumns().add(columm);
    }


    @Autowired
    public LandPlotControllerRead(LandPlotServiceImpl landPlotService) {
        this.landPlotService = landPlotService;
    }
}