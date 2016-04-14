package sample;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

    @FXML
    public BarChart chart;

    @FXML
    public TextField Plaats;


    @FXML
    public BarChart<String, Number> barChart;

    @FXML
    public BarChart<String, Number> barChart2;

    @FXML
    public LineChart<String, Number> lineChart;

    @FXML
    public PieChart pieChart;

    public void btn(ActionEvent event) {
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
        series.getData().add(new XYChart.Data<String, Number>("Feb", 600));
        series.getData().add(new XYChart.Data<String, Number>("Mar", 400));
        barChart.getData().add(series);
    }

    public void btn3(ActionEvent event){

    }


    public void btn4(ActionEvent event) {
        XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>();
        series3.getData().add(new XYChart.Data<String, Number>("Jan", 200));
        series3.getData().add(new XYChart.Data<String, Number>("Feb", 600));
        series3.getData().add(new XYChart.Data<String, Number>("Mar", 400));
        series3.getData().add(new XYChart.Data<String, Number>("Apr", 400));
        series3.getData().add(new XYChart.Data<String, Number>("May", 400));
        series3.getData().add(new XYChart.Data<String, Number>("Jun", 400));
        series3.getData().add(new XYChart.Data<String, Number>("Jul", 400));
        series3.getData().add(new XYChart.Data<String, Number>("Aug", 400));
        series3.getData().add(new XYChart.Data<String, Number>("Sep", 400));
        series3.getData().add(new XYChart.Data<String, Number>("Okt", 400));
        series3.getData().add(new XYChart.Data<String, Number>("Nov", 400));
        series3.getData().add(new XYChart.Data<String, Number>("Dec", 400));

        lineChart.getData().add(series3);
    }


    public void btn5(ActionEvent event) {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Ochtend", 40),
                        new PieChart.Data("Middag", 30),
                        new PieChart.Data("Avond", 115));

        pieChart.setData(pieChartData);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}