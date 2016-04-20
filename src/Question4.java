import DBConnect.DBConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gebruiker on 19-4-2016.
 */
public class Question4 {
    private ResultSet rs;
    public int Amount = 0;
    public String delicten;
    DBConnect con = new DBConnect();

    public ResultSet getDelicten() throws SQLException {

        delicten = "SELECT mid(date, 4, 2) AS maand, count(voorval_nr) AS aantal\n" +
                "FROM Crimes_fietsroof\n" +
                "WHERE right(date, length(date)-6) = \"2011\"\n" +
                "GROUP BY maand";
        rs = con.executeQuery(delicten);
        return rs;

    }
}