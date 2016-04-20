import DBConnect.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Question6 {
    private ResultSet rs;
    public int Amount = 0;
    public String dagdeelQuery;

    DBConnect con = new DBConnect();

    public List<Answer6> getDagDeel() throws SQLException {
        dagdeelQuery = "SELECT day_time, count(Voorval_nr) FROM Crimes_fietsroof GROUP BY day_time";
        rs = con.executeQuery(dagdeelQuery);

        List<Answer6> dagdeelTotaal = new ArrayList<>();
        while (!rs.isLast()) {
            rs.next();
            Answer6 test = new Answer6(rs.getString("day_time"), rs.getInt("count(Voorval_nr)"));

            dagdeelTotaal.add(test);
            Amount += 1;
        }

        return dagdeelTotaal;
    }
}




