import DBConnect.DBConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gebruiker on 18-4-2016.
 */
public class Question6 {
    private ResultSet rs;
    public int Amount = 0;
    public String gevaarlijkstedagdeel;

    public void queries() throws SQLException {
    }

    public List<Antwoord6> getGevaarlijkstedagdeel() throws SQLException {
        DBConnect con = new DBConnect();
        System.out.println(con);

        gevaarlijkstedagdeel = "SELECT day_time, count(voorval_nr) AS dagdeel_overvallen\n" +
                "FROM Crimes_fietsroof\n" +
                "WHERE \n" +
                "      day_time = \"00:00-05:59\" AND\n" +
                "      day_time = \"06:00-11:59\" AND\n" +
                "      day_time = \"12:00-17:59\" AND\n" +
                "      day_time = \"18:00-23:59\" AND\n" +
                "      right(date, length(date)-6) = \"2011\"\n" +
                "GROUP BY day_time;";
        System.out.println(gevaarlijkstedagdeel);
        rs = con.executeQuery(gevaarlijkstedagdeel);
        List<Antwoord6> GevaarlijkstedagdeelTotaals = new ArrayList<>();
        while (!rs.isLast()) {
            rs.next();
            Antwoord6 gevaarlijkstedagdeelTotaal = new Antwoord6( rs.getString("day_time"), rs.getInt("dagdeel_overvallen"));
            System.out.println(gevaarlijkstedagdeelTotaal);

            GevaarlijkstedagdeelTotaals.add(gevaarlijkstedagdeelTotaal);
            Amount += 1;
        }

        return GevaarlijkstedagdeelTotaals;
    }
}
