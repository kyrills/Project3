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
    public String fietsroof;
    public String straatroof;
    DBConnect con = new DBConnect();

    public void queries() throws SQLException {
    }

    public List<FietsroofTotaal> getFietsroven() throws SQLException {
        System.out.println(con);
        fietsroof =  "SELECT DISTINCT area, COUNT(area) AS Aantal FROM Neighbourhood_fietsroof WHERE location = \"ROTTERDAM\" GROUP BY area HAVING count(area) > 340";
        rs = con.executeQuery(fietsroof);

        List<FietsroofTotaal> fietsroofTotaals = new ArrayList<>();
        while (!rs.isLast()) {
            rs.next();
            FietsroofTotaal fietsroofTotaal = new FietsroofTotaal( rs.getString("area"), rs.getInt("Aantal"));

            fietsroofTotaals.add(fietsroofTotaal);
            Amount += 1;
        }

        return fietsroofTotaals;
    }
    public List<StraatroofTotaal> getStraatroven() throws SQLException {
        System.out.println(con);
        straatroof = "SELECT DISTINCT area, COUNT(area) AS Aantal FROM Neighbourhood_straatroof WHERE location = \"ROTTERDAM\" GROUP BY area HAVING count(area) > 75";
        rs = con.executeQuery(straatroof);

        List<StraatroofTotaal> straatroofTotaals = new ArrayList<>();
        while (!rs.isLast()) {
            rs.next();
            StraatroofTotaal straatroofTotaal = new StraatroofTotaal(rs.getString("area"), rs.getInt("Aantal"));

            straatroofTotaals.add(straatroofTotaal);
            Amount += 1;
        }

        return straatroofTotaals;
    }
}



