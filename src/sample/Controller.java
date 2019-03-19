package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public  class Controller {

    private static ObservableList<ResultPlotXY> plotData = FXCollections.observableArrayList();

    @FXML
    private TableView<ResultPlotXY> tableResults;

    @FXML
    private TableColumn<ResultPlotXY, Integer> step;

    @FXML
    private TableColumn<ResultPlotXY, Double> x;

    @FXML
    private TableColumn<ResultPlotXY, Double> y;

    @FXML
    public void initialize() {
        initData();

        step.setCellValueFactory(new PropertyValueFactory<ResultPlotXY, Integer>("step"));
        x.setCellValueFactory(new PropertyValueFactory<ResultPlotXY, Double>("x"));
        y.setCellValueFactory(new PropertyValueFactory<ResultPlotXY, Double>("y"));

        tableResults.setItems(plotData);
        tableResults.setEditable(true);
    }

    private static void initData() {
        List<ResultPlotXY> plots = getFirstData();
        int step = 0;
        for (int i = 0; i < plots.size(); i ++) {
            plotData.add(new ResultPlotXY(plots.get(i).getStep(),plots.get(i).getX()));
        }
    }

    public static List<ResultPlotXY> getFirstData(){
        List<ResultPlotXY> plots = new ArrayList<ResultPlotXY>();
        int step = 0;
        for (double i = 0; i < 20; i += 0.2) {
            plots.add(new ResultPlotXY(step++, i));
        }
        return plots;
    }

    public TableView GetTable(){
        return tableResults;
    }

}
