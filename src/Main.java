import DBConnect.Gui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

import static javafx.application.Application.launch;


//public class Main extends Application{
public class Main extends Application{
//    public static int Aantal_plaatsen = 0;

    //Button button;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Criminaliteit in Rotterdam");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }

public static void main(String[] args) {

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




