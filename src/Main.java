import DBConnect.DBConnect;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import DBConnect.Gui;
import javax.swing.JFrame;


//public class Main extends Application{
public class Main{

    //Button button;
public static void main(String[] args) {
        //launch(args);
        Gui go = new Gui();
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.setSize(300,200);
        go.setVisible(true);
    }

//    @Override
//    public void start (Stage primaryStage) throws Exception {
//        primaryStage.setTitle("Criminaliteit");
//        button = new Button();
//        button.setText("Fietsendiefstal");
//
//        button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                DBConnect dbconnect = new DBConnect();
//
//
//
//            }
//        });
////does it work now?
//
//        StackPane layout = new StackPane();
//        layout.getChildren().add(button);
//
//        Scene scene = new Scene(layout, 300, 250);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//    }


}
