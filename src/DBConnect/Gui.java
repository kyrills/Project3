package DBConnect;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import DBConnect.DBConnect;

/**
 * Created by Samuel on 07-04-16.
 */
public class Gui extends JFrame {
    JComboBox jc = new JComboBox();
    JPanel panel = new JPanel();
    private Connection con;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    int Aantal_plaatsen = 0;
    public String bookName;
    public int millionsSold;

    private JMenuItem Exit;
    private JMenuItem Registration;
    private JMenuItem Apie;

DBConnect connect = new DBConnect();


    public Gui() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {


            String host = "jdbc:mysql://91.208.99.2:1129/inf1egro_test";
            String uName = "inf1egro_test";
            String uPass = "test";

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(host, uName, uPass);

            st = con.createStatement();
            String SQL = "SELECT DISTINCT Plaats FROM Fietsroof";
            rs = st.executeQuery(SQL);

            while (rs.next()) {
                jc.addItem(rs.getString("Plaats"));

                System.out.println(rs.getString("Plaats"));
                Aantal_plaatsen += 1;

            }
            System.out.println(Aantal_plaatsen);


        } catch (Exception ex) {
            System.out.println("erro: " + ex);
        } finally {

            try {
                st.close();
                rs.close();
                con.close();
            } catch (Exception ex) {
                System.out.println("erro: " + ex);
            }


            panel.add(jc);
            this.getContentPane().add(panel);
            this.setVisible(true);
        }
    }

        private void setMenu(){
            JMenuBar barObj = new JMenuBar(); // create menuBar obj
            JMenu messagesObj = new JMenu("Meniu"); //create menu bar menu object

            barObj.setBackground(Color.YELLOW); // set menu bar bg color

            Registration = new JMenuItem("Registration");

            Registration.setBackground(Color.WHITE); // set menu bar menu options bg color
            messagesObj.add((Action) Registration); // add Registration into messages

            Apie = new JMenuItem("Apie");

            Apie.setBackground(Color.WHITE);
            messagesObj.add(Apie);

            Exit = new JMenuItem("Exit");

            Exit.setBackground(Color.WHITE);
            messagesObj.add(Exit);
        }


    }

