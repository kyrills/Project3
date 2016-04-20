import DBConnect.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Question4 {
    private ResultSet rs;
    public String delicten;
    DBConnect con = new DBConnect();

    public ResultSet getDelicten() throws SQLException {

        delicten = "SELECT mid(date, 4, 2) AS maand, count(voorval_nr) AS aantal\n" +
                "FROM Crimes_fietsroof\n" +
                "WHERE right(date, length(date)-6) = \"2012\"\n" +
                "GROUP BY maand";
        rs = con.executeQuery(delicten);
        return rs;

    }
}