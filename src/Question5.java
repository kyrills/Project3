import DBConnect.DBConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuel on 18-04-16.
 */
//" "


public class Question5 {
    private ResultSet rs;
    public int Amount = 0;
    public String fietsmerk;

    public void queries() throws SQLException {
    }

    public List<Answer5> getFiestMerk() throws SQLException {
        DBConnect con = new DBConnect();
        System.out.println(con);

        fietsmerk = "SELECT fr.brand_type, count(fr.object) FROM Fietsroof fr WHERE object = 'FIETS' GROUP BY fr.brand_type HAVING count(fr.object) > 150";
        System.out.println(fietsmerk);
        rs = con.executeQuery(fietsmerk);
        List<Answer5> BuitTotaals = new ArrayList<>();
        while (!rs.isLast()) {
            rs.next();
            Answer5 buitTotaal = new Answer5( rs.getString("fr.brand_type"), rs.getInt("count(fr.object)"));
            System.out.println(buitTotaal);

            BuitTotaals.add(buitTotaal);
            Amount += 1;
        }

        return BuitTotaals;
    }
}