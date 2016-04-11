import DBConnect.Gui;

import javax.swing.*;



//public class Main extends Application{
public class Main{
    public static int Aantal_plaatsen = 0;

    //Button button;
public static void main(String[] args) {
    Aantal_plaatsen +=1;
    Gui go = new Gui();
    go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    go.setSize(300, 200);
    go.setVisible(true);


    if (Aantal_plaatsen == 40) ;
    {
        //launch(args);
        go = new Gui();
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.setSize(800, 200);
        go.setVisible(true);
    }
}



}
