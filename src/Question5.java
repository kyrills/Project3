import DBConnect.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Question5 {
    private ResultSet rs;
    public String fietsmerk;
    DBConnect con = new DBConnect();

    public ResultSet getBuitTotaals_1() throws SQLException {
        fietsmerk = "SELECT fr.brand_type, count(fr.object) AS Aantal FROM Fietsroof fr WHERE object = 'FIETS' AND brand_type <> 'ONBEKEND' GROUP BY fr.brand_type HAVING count(fr.object) > 150";
        rs = con.executeQuery(fietsmerk);

        return rs;
    }
}