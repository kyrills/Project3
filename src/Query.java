import DBConnect.DBConnect;
import java.sql.*;

/**
 * Created by Kyrilll van Seventer on 14/04/2016.
 */

public class Query {
    private ResultSet rs;
    public int Amount = 0;
    public String wijkroof;

    public void queries() throws SQLException {

    }

    public void wijken() throws SQLException {
        DBConnect con = new DBConnect();
        System.out.println(con);

        wijkroof = "SELECT * FROM Neighbourhood_fietsroof";
        System.out.println(wijkroof);
        rs = con.executeQuery(wijkroof);

        while (!rs.isLast()) {
            rs.next();
            int id_col = rs.getInt("voorval_nr");
            String locatie = rs.getString("location");
            String area = rs.getString("area");
            String street = rs.getString("street");
            System.out.println(id_col + " " + locatie + " " + area + " " + street);
            Amount += 1;
            System.out.println(id_col);
        }
    }
}



