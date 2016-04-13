package sample;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

    @FXML
    public BarChart chart;

    @FXML
    public TextField Plaats;




    @FXML
    public BarChart<String, Number> barChart;

    public void btn(ActionEvent event) {
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
        series.getData().add(new XYChart.Data<String, Number>("Feb", 600));
        series.getData().add(new XYChart.Data<String, Number>("Mar", 400));
        barChart.getData().add(series);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}