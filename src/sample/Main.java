package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

import static sample.Controller.getFirstData;

public class Main extends Application {
    @FXML private TableView<ResultPlotXY> tableValues = new TableView<ResultPlotXY>();
    Controller control =new Controller();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Pane rootPane = new Pane();
        primaryStage.setTitle("MVC lab");

        NumberAxis x = new NumberAxis(-1,20,0.2);
        NumberAxis y = new NumberAxis(-2.8,2.8,0.2);

        AreaChart<Number, Number> numberLineChart = new AreaChart<Number, Number>(x,y);
        numberLineChart.setTitle("График");
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("log(x) * sin(x)");

        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
        List<ResultPlotXY> data= getFirstData();
        for(int i=0; i<data.size(); i++){
            datas.add(new XYChart.Data(RoundDouble(data.get(i).getX(),3),RoundDouble(data.get(i).getY(),3)));
        }

        series1.setData(datas);

        /// Таблица
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        final Label label = new Label("Значения");
        label.setFont(new Font("Arial", 20));
        vbox.getChildren().addAll(label, tableValues);

        Pane paneChart = new Pane(numberLineChart);
        paneChart.setLayoutX(180);
        rootPane.getChildren().addAll(root,paneChart);

        Scene scene = new Scene(rootPane, 700,400);
        numberLineChart.getData().add(series1);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private static double RoundDouble(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
