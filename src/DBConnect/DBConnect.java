package DBConnect;
//import List.Link;
//import List.LinkList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Samuel on 04-04-16.
 */


public class DBConnect {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    public int Amount = 0;
    public String fietsroof;
    public DBConnect() {
        try {
            String host = "jdbc:mysql://91.208.99.2:1129/inf1egro_test";
            String uName = "inf1egro_test";
            String uPass = "test";

            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("mysql-connector-java-5.1.38-bin.jar");

            Connection con = DriverManager.getConnection(host, uName, uPass);
            st = con.createStatement();
            fietsroof = "SELECT * FROM Fietsroof";
            rs = st.executeQuery(fietsroof);
            while(Amount < 22000) {

                rs.next();
                int id_col = rs.getInt("Voorval_nummer");
                String first_name = rs.getString("MK");
                String last_name = rs.getString("Poging");
                String job = rs.getString("Plaats");
                System.out.println(id_col + " " + first_name + " " + last_name + " " + job);
                Amount += 1;
            }
        } catch (Exception ex) {
            System.out.println("erro: " + ex);
        }

    }

}


