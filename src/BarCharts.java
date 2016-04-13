/**
 * Created by Kyrilll van Seventer on 11/04/2016.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import DBConnect.DBConnect;
import DBConnect.Gui;


    public class BarCharts extends Application {
        String SQL1 = "SELECT count(Buurt) FROM Fietsroof GROUP BY Buurt HAVING count(Buurt) > 700";
        int xyz = Integer.parseInt(SQL1);
        final static String Stadsdriehoek = "Stadsdriehoek";
        final static String Cool = "Coolhaven";
        final static String Hoogvliet_zuid = "Hoogvliet-zuid";
        final static String Oosterflank = "Oosterflank";
        final static String Groot_ijselmonde = "Groot ijselmonde";

        @Override public void start(Stage stage) {
            stage.setTitle("Bar Chart Sample");
            final NumberAxis xAxis = new NumberAxis();
            final CategoryAxis yAxis = new CategoryAxis();
            final BarChart<Number,String> bc =
                    new BarChart<Number,String>(xAxis,yAxis);
            bc.setTitle("Country Summary");
            xAxis.setLabel("Aantal fietsendiefstallen");
            xAxis.setTickLabelRotation(90);
            yAxis.setLabel("Rotterdam");

            XYChart.Series series1 = new XYChart.Series();
            series1.setName("2011");
            series1.getData().add(new XYChart.Data(xyz, Stadsdriehoek));
            series1.getData().add(new XYChart.Data(511, Cool));
            series1.getData().add(new XYChart.Data(442, Hoogvliet_zuid));
            series1.getData().add(new XYChart.Data(426, Oosterflank));
            series1.getData().add(new XYChart.Data(418, Groot_ijselmonde));

//            XYChart.Series series2 = new XYChart.Series();
//            series2.setName("2004");
//            series2.getData().add(new XYChart.Data(57401.85, austria));
//            series2.getData().add(new XYChart.Data(41941.19, brazil));
//            series2.getData().add(new XYChart.Data(45263.37, france));
//            series2.getData().add(new XYChart.Data(117320.16, italy));
//            series2.getData().add(new XYChart.Data(14845.27, usa));
//
//            XYChart.Series series3 = new XYChart.Series();
//            series3.setName("2005");
//            series3.getData().add(new XYChart.Data(45000.65, austria));
//            series3.getData().add(new XYChart.Data(44835.76, brazil));
//            series3.getData().add(new XYChart.Data(18722.18, france));
//            series3.getData().add(new XYChart.Data(17557.31, italy));
//            series3.getData().add(new XYChart.Data(92633.68, usa));

            Scene scene  = new Scene(bc,800,600);
            bc.getData().addAll(series1
//                    , series2, series3
            );
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
