import DBConnect.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gebruiker on 18-4-2016.
 */
public class Question2 {
    private ResultSet rs;
    public int Amount = 0;
    public String gevaarlijstewijk;

    public void queries() throws SQLException {
    }

    public List<Answer2> getGevaarlijkstewijk() throws SQLException {
        DBConnect con = new DBConnect();
        System.out.println(con);

        gevaarlijstewijk = "SELECT ns.area, count(s.weapon)\n" +
                "FROM Neighbourhood_straatroof ns, Straatroof s\n" +
                "WHERE s.weapon = \"ja\" AND\n" +
                "      ns.location = \"ROTTERDAM\" AND\n" +
                "      ns.voorval_nr = s.voorval_nr\n" +
                "GROUP BY ns.area\n" +
                "HAVING count(s.weapon) > 14" ;
        System.out.println(gevaarlijstewijk);
        rs = con.executeQuery(gevaarlijstewijk);
        List<Answer2> GevaarlijkstewijkenTotaals = new ArrayList<>();
        while (!rs.isLast()) {
            rs.next();
            Answer2 gevaarlijkstewijkenTotaal = new Answer2( rs.getString("ns.area"), rs.getInt("count(s.weapon)"));
            System.out.println(gevaarlijkstewijkenTotaal);

            GevaarlijkstewijkenTotaals.add(gevaarlijkstewijkenTotaal);
            Amount += 1;
        }

        return GevaarlijkstewijkenTotaals;
    }
}
