
import java.awt.event.KeyEvent;
import java.awt.geom.Arc2D;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class Controller{

//    @FXML
//    public BarChart chart;
//
//    @FXML
//    public TextField Plaats;
//
//    @FXML


    @FXML
    public BarChart<String, Number> barChart;
    public BarChart<String, Number> barChart2;
    public BarChart<String, Number> barChart3;
    public LineChart<String, Number> lineChart;
    public BarChart<String, Number> barChart5;
    public PieChart pieChart2;

    private XYChart.Series<String,Number> criminaliteit = new XYChart.Series<String, Number>();
    private XYChart.Series<String, Number> buit = new XYChart.Series<String, Number>();
    private XYChart.Series<String, Number> object = new XYChart.Series<String, Number>();
    private XYChart.Series<String, Number> maand = new XYChart.Series<String, Number>();
    private XYChart.Series<String, Number> gevaarlijkste = new XYChart.Series<String, Number>();
    private boolean bar1loaded = false;
    private boolean bar2loaded = false;
    private boolean bar3loaded = false;
    private boolean line4loaded = false;
    private boolean bar5loaded = false;

    @FXML
    private CategoryAxis xAxis_top = new CategoryAxis();
    private NumberAxis yAxis_top = new NumberAxis();

    @FXML    private void loadbar1() throws SQLException {
        if(!bar1loaded) {

            barChart.setTitle("Criminaliteit per wijk.");

            xAxis_top.setLabel("Gemeenten");
            yAxis_top.setLabel("aantal");
            xAxis_top.setTickLabelRotation(-90.0);

            Question1 q1 = new Question1();
            ResultSet result = q1.getFietsroven_1();

            result.absolute(0);
            while (result.next()) {
                criminaliteit.getData().add(new XYChart.Data(result.getString("area"), result.getInt("Aantal")));
            }

            criminaliteit.setName("Criminaliteit");
            barChart.getData().add(criminaliteit);

            bar1loaded = true;
        }
    }

    @FXML    private void loadbar2() throws SQLException {
        if(!bar2loaded) {

            barChart2.setTitle("Wijken met de meeste wapens.");

            xAxis_top.setLabel("Gevaarlijkste wijken");
            yAxis_top.setLabel("Aantal");
            xAxis_top.setTickLabelRotation(-90.0);

            Question2 q2 = new Question2();
            ResultSet result = q2.getGevaarlijk();

            result.absolute(0);
            while (result.next()) {
                gevaarlijkste.getData().add(new XYChart.Data(result.getString("ns.area"), result.getInt("count(s.weapon)")));
            }

            gevaarlijkste.setName("Wapens");
            barChart2.setAnimated(false);
            barChart2.getData().add(gevaarlijkste);

            bar2loaded = true;
        }
    }

    @FXML    private void loadbar3() throws SQLException {
        if(!bar3loaded) {

            barChart3.setTitle("Meest gestolen object");

            xAxis_top.setLabel("Objectnaam");
            yAxis_top.setLabel("aantal");
            xAxis_top.setTickLabelRotation(-90.0);

            Question3 q3 = new Question3();
            ResultSet result = q3.getBuit();

            result.absolute(0);
            while (result.next()) {
                object.getData().add(new XYChart.Data(result.getString("object"), result.getInt("count(voorval_nr)")));
            }

            object.setName("Meest gestolen object.");
            barChart3.setAnimated(false);
            barChart3.getData().add(object);

            bar3loaded = true;
        }
    }

    @FXML    private void loadline4() throws SQLException {
        if(!line4loaded) {

            lineChart.setTitle("Criminaliteit per maand");

            xAxis_top.setLabel("Maand");
            yAxis_top.setLabel("Aantal");
            xAxis_top.setTickLabelRotation(-90.0);

            Question4 q4 = new Question4();
            ResultSet result = q4.getDelicten();

            result.absolute(0);
            while (result.next()) {
                maand.getData().add(new XYChart.Data(result.getString("maand"), result.getInt("aantal")));
            }

            maand.setName("Criminaliteit per maand");
            lineChart.setAnimated(false);
            lineChart.getData().add(maand);
            line4loaded = true;
        }
    }

@FXML    private void loadbar5() throws SQLException, InterruptedException {
    if(!bar5loaded) {

        barChart5.setTitle("Meest gestolen merk.");

        xAxis_top.setLabel("Merken");
        yAxis_top.setLabel("Aantal");

        Question5 q5 = new Question5();
        ResultSet result = q5.getBuitTotaals_1();

        while (result.next()) {
            buit.getData().add(new XYChart.Data(result.getString("brand_type"), result.getInt("Aantal")));
        }

        buit.setName("Merken");
        barChart5.setAnimated(false);
        barChart5.getData().add(buit);

        bar5loaded = true;
    }
}

@FXML   private void piebar6() {
            PieChart pieseries = new PieChart();
            ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
            Question6 q6 = new Question6();
            pieChart2.setTitle("Criminaliteit per dagdeel.");

            try {
                q6.getDagDeel().forEach(roof ->{
                    pieData.add(new PieChart.Data(roof.getDay_time(),roof.getCount_overvallen()));
                });

                pieChart2.setData(pieData);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}