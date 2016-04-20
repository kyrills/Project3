import DBConnect.DBConnect;
import java.sql.*;

public class Question2 {
    private ResultSet rs;
    public String gevaarlijkstewijk;
    DBConnect con = new DBConnect();

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