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
    public String delictenpermaand;

    public void queries() throws SQLException {
    }

    public List<Answer4> getOvervallen() throws SQLException {
        DBConnect con = new DBConnect();
        System.out.println(con);

        delictenpermaand = "SELECT mid(date, 4, 2) AS maand, count(voorval_nr)\n" +
                "FROM Crimes_fietsroof\n" +
                "WHERE right(date, length(date)-6) = \"2011\"\n" +
                "GROUP BY maand";
        System.out.println(delictenpermaand);
        rs = con.executeQuery(delictenpermaand);
        List<Answer4> DelictenpermaandTotaals = new ArrayList<>();
        while (!rs.isLast()) {
            rs.next();
            Answer4 delictenpermaandTotaal = new Answer4( rs.getString("maand"), rs.getInt("count(voorval_nr)"));
            System.out.println(delictenpermaandTotaal);

           DelictenpermaandTotaals.add(delictenpermaandTotaal);
            Amount += 1;
        }

        return DelictenpermaandTotaals;
    }
}