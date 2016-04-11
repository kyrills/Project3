import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Dave on 08-04-16.
 */
public class Straatroof extends JFrame {
    private String plaats;
    private String soortRoof;
    private int dagdeel;
    private String dagsoort;
    private String maandNaam;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    public int Amount = 0;
    JComboBox jc = new JComboBox();
    JPanel panel = new JPanel();


    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public String getSoortRoof() {
        return soortRoof;
    }

    public void setSoortRoof(String soortRoof) {
        this.soortRoof = soortRoof;
    }

    public String getMaandNaam() {
        return maandNaam;
    }

    public void setMaandNaam(String maandNaam) {
        this.maandNaam = maandNaam;
    }

    public String getDagsoort() {
        return dagsoort;
    }

    public void setDagsoort(String dagsoort) {
        this.dagsoort = dagsoort;
    }

    public int getDagdeel() {
        return dagdeel;
    }

    public void setDagdeel(int dagdeel) {
        this.dagdeel = dagdeel;
    }

    public Straatroof(){
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            String host = "jdbc:mysql://91.208.99.2:1129/inf1egro_test";
            String uName = "inf1egro_test";
            String uPass = "test";

            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("mysql-connector-java-5.1.38-bin.jar");

            Connection con = DriverManager.getConnection(host, uName, uPass);
            st = con.createStatement();
            String SQL = "SELECT DISTINCT Plaats FROM straatroof";
            rs = st.executeQuery(SQL);
            while(Amount < 22000) {
//                theLinkedList.insertFirstLink("Don Quixote", 500);
                rs.next();
                String Plaats = rs.getString("Plaats");
//                String soortRoof = rs.getString("MK_omschrijving");

                System.out.println(Plaats + " " + soortRoof);
                Amount += 1;
            }
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

    }

