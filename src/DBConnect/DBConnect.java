package DBConnect;

import java.sql.*;

public class DBConnect {

    private Connection con;
    private Statement st;


    public DBConnect(){
        try {
            String host = "jdbc:mysql://91.208.99.2:1129/inf1egro_test";
            String uName = "inf1egro_test";
            String uPass = "test";

            Class.forName("com.mysql.jdbc.Driver");

             con = DriverManager.getConnection(host, uName, uPass);

        } catch (Exception ex) {
            System.out.println("erro: " + ex);
        }


    }
    public ResultSet executeQuery(String query) throws SQLException {
            st = con.createStatement();
            return st.executeQuery(query);
    }


}


