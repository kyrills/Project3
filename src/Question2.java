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
    public String gevaarlijkstewijk;
    DBConnect con = new DBConnect();


    public void queries() throws SQLException {
    }

    public ResultSet getGevaarlijk() throws SQLException {

        gevaarlijkstewijk = "SELECT ns.area, count(s.weapon)\n" +
                "FROM Neighbourhood_straatroof ns, Straatroof s\n" +
                "WHERE s.weapon = \"ja\" AND\n" +
                "      ns.location = \"ROTTERDAM\" AND\n" +
                "      ns.voorval_nr = s.voorval_nr\n" +
                "GROUP BY ns.area\n" +
                "HAVING count(s.weapon) > 14";
        rs = con.executeQuery((gevaarlijkstewijk));

        return rs;
    }

}