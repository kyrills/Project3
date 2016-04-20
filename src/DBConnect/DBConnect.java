package DBConnect;

import java.sql.*;

public class DBConnect {

    private Connection con;
    private Statement st;

    //The connection with the server will be established in the DBConnect method, if the server fails to respond an error message will be showed.
    public DBConnect(){
        try {
            String host = "jdbc:mysql://91.208.99.2:1129/inf1egro_test";    //Server ip + database name
            String uName = "inf1egro_test"; //Username
            String uPass = "test"; //password
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


