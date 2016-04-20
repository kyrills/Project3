
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

    @FXML
    public BarChart chart;

    @FXML
    public TextField Plaats;

    @FXML
    public BarChart<String, Number> barChart2;

    @FXML
    public BarChart<String, Number> barChart3;

    @FXML
    public LineChart<String, Number> lineChart;

    @FXML
    public PieChart pieChart2;


    private XYChart.Series<String,Number> series_top = new XYChart.Series<String,Number>();
    //    private String[] gemeentenlist = {"Delfshaven","Overschie","Noord","Hillegersberg-Schiebroek",
//            "Kralingen-Crooswijk","Feijenoord","IJsselmonde","Pernis",
//            "Prins Alexander","Charlois","Hoogvliet","Hoek van Holland"};
//    private ObservableList<String> gemeenten = FXCollections.observableArrayList();
    public BarChart<String, Number> barChart;
    public BarChart<String, Number> barChart5;
    //public TabPane tabIndex;

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
    private int cnt = 1;

    @FXML
    private CategoryAxis xAxis_top = new CategoryAxis();

    @FXML
    private NumberAxis yAxis_top = new NumberAxis();
    @FXML    private BarChart<String, Number> barChart_top;
    @FXML    private TabPane tabIndex;

    @FXML    private void loadbar1() throws SQLException {
        if(!bar1loaded) {

            barChart.setTitle("Criminaliteit");

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

//    public void btn(ActionEvent event) {
//        XYChart.Series<String, Number> series = new XYChart.Series<>();
//        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
//        barChart.setCategoryGap(20);
//
//        Question1 q1 = new Question1();
//        try {
//            q1.getFietsroven().forEach(roof ->{
//                series.getData().add(new XYChart.Data<String, Number>(roof.getArea(), roof.getAantal()));
//            });
//            q1.getStraatroven().forEach(roof ->{
//                series1.getData().add(new XYChart.Data<String, Number>(roof.getArea(), roof.getAantal()));
//            });
//
//
//
//            barChart.getData().addAll(series, series1);
//            barChart.getData().add(series1);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    public void btn2(ActionEvent event) {
//        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
//
//        Question2 q2 = new Question2();
//        try {
//            q2.getGevaarlijkstewijk().forEach(roof -> {
//                series2.getData().add(new XYChart.Data<String, Number>(roof.getArea(), roof.getWapenovervallen()));
//            });
//
//            barChart2.getData().add(series2);
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
    @FXML    private void loadbar2() throws SQLException {
        if(!bar2loaded) {

            barChart2.setTitle("Criminaliteit");

            xAxis_top.setLabel("Gevaarlijkste wijken");
            yAxis_top.setLabel("Aantal");
            xAxis_top.setTickLabelRotation(-90.0);

            Question2 q2 = new Question2();
            ResultSet result = q2.getGevaarlijk();

            result.absolute(0);
            while (result.next()) {
                gevaarlijkste.getData().add(new XYChart.Data(result.getString("ns.area"), result.getInt("count(s.weapon)")));
            }

            gevaarlijkste.setName("Wijken met de meeste wapens.");
            barChart2.setAnimated(false);
            barChart2.getData().add(gevaarlijkste);

            bar2loaded = true;
        }

    }



//    public void btn3(ActionEvent event){
//        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
//
//        Question3 q3 = new Question3();
//        try {
//            q3.getMeestebuit().forEach(roof -> {
//                series3.getData().add(new XYChart.Data<String, Number>(roof.getVoorval_nr(), roof.getOvervalbuit()));
//            });
//
//            barChart3.getData().add(series3);
//
//            System.out.println(series3);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

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
                object.getData().add(new XYChart.Data(result.getString("fr.object"), result.getInt("robject")));
            }

            object.setName("Meest gestolen object.");
            barChart3.setAnimated(false);
            barChart3.getData().add(object);

            bar3loaded = true;
        }

    }


//    public void btn4(ActionEvent event) {
//        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
//
//        Question4 q4 = new Question4();
//        try {
//            q4.getOvervallen().forEach(roof -> {
//                series4.getData().add(new XYChart.Data<String, Number>(roof.getMaand(), roof.getOvervallen()));
//            });
//
//            lineChart.getData().add(series4);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

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


//    public void btn5(ActionEvent event) {
//
//        XYChart.Series<String, Number> series5 = new XYChart.Series<>();
//
//        Question5 q5 = new Question5();
//        try {
//            q5.getFiestMerk().forEach(roof -> {
//                series5.getData().add(new XYChart.Data<String, Number>(roof.getVoorval_nr(), roof.getOvervalbuit()));
//            });
//
//            barChart5.getData().add(series5);
//
//            System.out.println(series5);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
@FXML    private void loadbar5() throws SQLException, InterruptedException {
    //while (cnt < 3){
    if(!bar5loaded) {

        barChart5.setTitle("Buit");

//            gemeenten.clear();
//            gemeenten.addAll(Arrays.asList(gemeentenlist));
//            xAxis_top.setCategories(gemeenten);
        xAxis_top.setLabel("Merken");
        yAxis_top.setLabel("Aantal");
//            xAxis_top.setTickLabelRotation(-90.0);

        Question5 q5 = new Question5();
        ResultSet result = q5.getBuitTotaals_1();

        //result.absolute(0);
        while (result.next()) {
            buit.getData().add(new XYChart.Data(result.getString("brand_type"), result.getInt("Aantal")));
        }

        buit.setName("Buit");
        barChart5.setAnimated(false);
        barChart5.getData().add(buit);

        bar5loaded = true;
    }
}

@FXML   private void piebar6() {
            //        pieChart.setCategoryGap(0);
            PieChart pieseries = new PieChart();
            ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
            Question6 q6 = new Question6();

            try {
                q6.getDagDeel().forEach(roof ->{
                    pieData.add(new PieChart.Data(roof.getDay_time(),roof.getCount_overvallen()));
                });

                pieChart2.setData(pieData);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }}
//
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }
//}