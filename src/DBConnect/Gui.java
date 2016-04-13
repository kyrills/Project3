package DBConnect;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import DBConnect.DBConnect;
import javafx.scene.control.Button;

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



//    private static String[] filename = {"Cirkel.png"};
//    private Icon[] pics = {new ImageIcon(getClass().getResource(filename[0])), new ImageIcon(getClass().getResource(filename[1]))};

    public Gui() {
        //System.out.println("123");
//        setMenu();
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//        button = new Button();
//        button.setText("Fietsendiefstal");


        try {


//            String host = "jdbc:mysql://91.208.99.2:1129/inf1egro_test";
//            String uName = "inf1egro_test";
//            String uPass = "test";
//
//            Class.forName("com.mysql.jdbc.Driver");
//            //Class.forName("mysql-connector-java-5.1.38-bin.jar");
//
//            con = DriverManager.getConnection(host, uName, uPass);
            connect.Connector();
            st = con.createStatement();
            String SQL = "SELECT DISTINCT Plaats FROM Fietsroof";
            rs = st.executeQuery(SQL);

            while (rs.next()) {
                jc.addItem(rs.getString("Plaats"));

                System.out.println(rs.getString("Plaats"));
                Aantal_plaatsen += 1;
//                List.LinkList theLinkedList = new List.LinkList();
//                theLinkedList.insertFirstLink("Don Quixote", 500);
//                System.out.println(bookName + ": " + millionsSold + ",000,000 Sold");

//                if (button.setOnAction()== true) {
//                    System.out.print(jc);


            }
            System.out.println(Aantal_plaatsen);
//                int id_col = rs.getInt("Voorval_nummer");
//                String first_name = rs.getString("MK");
//                String last_name = rs.getString("Poging");
//                String job = rs.getString("Plaats");
//                System.out.println(id_col + " " + first_name + " " + last_name + " " + job);
//                Amount += 1;

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

//        private void setMenu(){
//            JMenuBar barObj = new JMenuBar(); // create menuBar obj
//            JMenu messagesObj = new JMenu("Meniu"); //create menu bar menu object
//
//            barObj.setBackground(Color.YELLOW); // set menu bar bg color
//
//            Registration = new JMenuItem("Registration");
//
//            Registration.setBackground(Color.WHITE); // set menu bar menu options bg color
//            messagesObj.add((Action) Registration); // add Registration into messages
//
//            Apie = new JMenuItem("Apie");
//
//            Apie.setBackground(Color.WHITE);
//            messagesObj.add(Apie);
//
//            Exit = new JMenuItem("Exit");
//
//            Exit.setBackground(Color.WHITE);
//            messagesObj.add(Exit);
//        }
//        public void fill(){
//        String sql = "Selevt * from fietsroof";
//        ps =con.prepareStatement(sql);
//        rs=ps.




//        super("de Titel");
//        setLayout(new FlowLayout());
//
//        box = new JComboBox(filename);
//
//        box.addItemListener(
//                new ItemListener() {
//                    @Override
//                    public void itemStateChanged(ItemEvent event) {
//                        if(event.getStateChange()==ItemEvent.SELECTED);
//                            picture.setIcon(pics[box.getSelectedIndex()]);
//                    }
//                }
//        );
//        add(box);
//        picture=new JLabel(pics[0]);
//        add(picture);
//    }

    }

