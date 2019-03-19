package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class Main extends Application {
    private TableView tableValues = new TableView();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Pane rootPane = new Pane();

        primaryStage.setTitle("MVC lab");

        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();

        AreaChart<Number, Number> numberLineChart = new AreaChart<Number, Number>(x,y);
        numberLineChart.setTitle("Series");
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("cos(x)");
        series1.setName("sin(x)");
        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> datas2 = FXCollections.observableArrayList();
        for(int i=0; i<20; i++){
            datas.add(new XYChart.Data(i,Math.sin(i)));
            datas2.add(new XYChart.Data(i,Math.cos(i)));
        }

        series1.setData(datas);
        series2.setData(datas2);

        tableValues.setEditable(true);

        TableColumn xCol = new TableColumn("X");
        TableColumn yCol = new TableColumn("Y");

        tableValues.getColumns().addAll(xCol, yCol);

        /// Таблица
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        final Label label = new Label("Values");
        label.setFont(new Font("Arial", 20));
        vbox.getChildren().addAll(label, tableValues);

        Pane paneChart = new Pane(numberLineChart);
        paneChart.setLayoutX(220);
        Pane paneTableValues = new Pane(tableValues);
        rootPane.getChildren().addAll(paneTableValues,paneChart);

        Scene scene = new Scene(rootPane, 700,600);
        numberLineChart.getData().add(series1);
        numberLineChart.getData().add(series2);
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
