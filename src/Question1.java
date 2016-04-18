import DBConnect.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyrilll van Seventer on 14/04/2016.
 */

public class Question1 {
    private ResultSet rs;
    public int Amount = 0;
    public String wijkroof;

    public void queries() throws SQLException {
    }

    public List<FietsroofTotaal> getFietsroven() throws SQLException {
        DBConnect con = new DBConnect();
        System.out.println(con);

        wijkroof =  "SELECT DISTINCT area, COUNT(area) AS Aantal FROM Neighbourhood_fietsroof WHERE location = \"ROTTERDAM\" GROUP BY area HAVING count(area) > 340";
        System.out.println(wijkroof);
        rs = con.executeQuery(wijkroof);
        List<FietsroofTotaal> fietsroofTotaals = new ArrayList<>();
        while (!rs.isLast()) {
            rs.next();
            FietsroofTotaal fietsroofTotaal = new FietsroofTotaal( rs.getString("area"), rs.getInt("Aantal"));
            System.out.println(fietsroofTotaal);

            fietsroofTotaals.add(fietsroofTotaal);
            Amount += 1;
        }

        return fietsroofTotaals;
    }
}



