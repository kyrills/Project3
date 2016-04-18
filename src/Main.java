import DBConnect.DBConnect;
import DBConnect.Gui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

import java.sql.SQLException;

import static javafx.application.Application.launch;


//public class Main extends Application{
public class Main extends Application{
//    public static int Aantal_plaatsen = 0;

    //Button button;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Criminaliteit in Rotterdam");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

public static void main(String[] args) throws SQLException, ClassNotFoundException {
//    Query query = new Query();
//    query.queries();

//    DBConnect dbConnect = new DBConnect();
//    dbConnect.DBConnect();

    Query wijken = new Query();
    wijken.wijken();

    launch(args);
//    Aantal_plaatsen +=1;
//    Gui go = new Gui();
//    go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    go.setSize(300, 200);
//    go.setVisible(true);


//    if (Aantal_plaatsen == 40) ;
//    {
        //launch(args);
//        go = new Gui();
//        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        go.setSize(800, 200);
//        go.setVisible(true);
    }


}




