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
    DBConnect con = new DBConnect();

    public void queries() throws SQLException {
    }

    public ResultSet getBuit() throws SQLException {

        buit = "SELECT fr.object, count(fr.object), count(sr.object) AS robject FROM Fietsroof fr, Straatroof sr WHERE fr.object = sr.object GROUP BY fr.object HAVING count(fr.object)";

        rs = con.executeQuery(buit);

        return rs;
    }
}