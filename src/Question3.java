import DBConnect.DBConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuel on 18-04-16.
 */
//" "


public class Question3 {
    private ResultSet rs;
    public int Amount = 0;
    public String buit;

    public void queries() throws SQLException {
    }

    public List<Answer3> getMeestebuit() throws SQLException {
        DBConnect con = new DBConnect();
        System.out.println(con);

        buit = "SELECT fr.object, count(fr.object), count(sr.object) AS robject FROM Fietsroof fr, Straatroof sr WHERE fr.object = sr.object GROUP BY fr.object HAVING count(fr.object)";
        System.out.println(buit);
        rs = con.executeQuery(buit);
        List<Answer3> BuitTotaals = new ArrayList<>();
        while (!rs.isLast()) {
            rs.next();
            Answer3 buitTotaal = new Answer3( rs.getString("fr.object"), rs.getInt("robject"));
            System.out.println(buitTotaal);

            BuitTotaals.add(buitTotaal);
            Amount += 1;
        }

        return BuitTotaals;
    }
}