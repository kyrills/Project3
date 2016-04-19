
import java.awt.event.KeyEvent;
import java.awt.geom.Arc2D;
import java.net.URL;
import java.sql.SQLException;
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

    @FXML
    public PieChart pieChart2;


    public void btn(ActionEvent event) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        barChart.setCategoryGap(0);

        Question1 q1 = new Question1();
        try {
            q1.getFietsroven().forEach(roof ->{
                series.getData().add(new XYChart.Data<String, Number>(roof.getArea().substring(2), roof.getAantal()));
            });
            q1.getStraatroven().forEach(roof ->{
                series1.getData().add(new XYChart.Data<String, Number>(roof.getArea().substring(2), roof.getAantal()));
            });

            barChart.getData().addAll(series, series1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void btn2(ActionEvent event) {
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();

        Question2 q2 = new Question2();
        try {
            q2.getGevaarlijkstewijk().forEach(roof -> {
                series2.getData().add(new XYChart.Data<String, Number>(roof.getArea().substring(2), roof.getWapenovervallen()));
            });

            barChart2.getData().add(series2);

    } catch (SQLException e) {
        e.printStackTrace();
    }
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
        String SQL =
                "SELECT count(Voorval_nummer)\n" +
                "FROM Crimes\n" +
                "WHERE Gemiddelde_dagdeel_6_uren = '00:00-05:59'\n";
//        double xyz = Double.parseDouble(SQL);
        System.out.println(SQL);
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Ochtend", 40),
                        new PieChart.Data("Middag", 30),
                        new PieChart.Data("Avond", 115),
                        new PieChart.Data("Nacht", 65));

        pieChart.setData(pieChartData);

    }

   public void btn6(ActionEvent event) {
//        XYChart.Series<String, Number> series6 = new XYChart.Series<>();
//
//        Question6 q6 = new Question6();
//        try {
//            q6.getGevaarlijkstedagdeel().forEach(roof ->{
//                series6.getData().add(new XYChart.Data<String, Number>(roof.getDay_time(), roof.getCount_overvallen()));
//            });
//            pieChart2.getData().add(series6);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}