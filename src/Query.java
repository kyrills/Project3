import DBConnect.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyrilll van Seventer on 14/04/2016.
 */
public class Query {
    //    ResultSet resultset;
//    public String wijkroof;
//    public int Amount = 0;
//    Statement st;
//    ResultSet rs;
//    private Connection con;
//    private Statement st;
    private ResultSet rs;
    public int Amount = 0;
    public String wijkroof;

    public void queries() throws SQLException {

    }


    public void wijken() throws SQLException {
        DBConnect con = new DBConnect();
//        conn.DBConnect();
        System.out.println(con);
//        wijkroof = "SELECT * FROM Neighbourhood_fietsroof";
//             wijkroof ="SELECT DISTINCT area, COUNT(area) FROM inf1egro_test.Neighbourhood_fietsroof Group BY area";

//            rs = conn.getSt().executeQuery(wijkroof);

//            String Buurt = rs.getString("area");
//            String Aantal = rs.getString("Count(area)");

//            st = conn.createStatement();

        wijkroof = "SELECT * FROM Neighbourhood_fietsroof";
        System.out.println(wijkroof);
        rs = con.executeQuery(wijkroof);
        while (!rs.isLast()) {
//
            rs.next();
            int id_col = rs.getInt("voorval_nr");
            String locatie = rs.getString("location");
            String area = rs.getString("area");
            String street = rs.getString("street");
            System.out.println(id_col + " " + locatie + " " + area + " " + street);
            Amount += 1;
//
//            System.out.println(Buurt + " " + Aantal + " ");
            System.out.println(id_col);
        }
//        List<List<String>> result = new ArrayList<>();  // List of list, one per row
//            while (resultset.next()) {
//        List<String> row = new ArrayList<>(numcols); // new list per row
//        int i = 1;
//        while (i <= numcols) {  // don't skip the last column, use <=
//            row.add(resultset.getString(i++));
//        }
//        result.add(row); // add it to the result

//    public Statement getSt() {
//        return st;
//    }


    }
}
//    }



