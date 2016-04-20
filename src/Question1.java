import DBConnect.DBConnect;
import java.sql.*;

public class Question1 {
    private ResultSet rs;
    public int Amount = 0;
    public String fietsroof;
    public String straatroof;
    public String namen;
    DBConnect con = new DBConnect();

    public void queries() throws SQLException {
    }

    public ResultSet getFietsroven_1() throws SQLException {

        fietsroof =  "SELECT DISTINCT area, COUNT(area) AS Aantal FROM Neighbourhood_fietsroof WHERE location = \"ROTTERDAM\" GROUP BY area HAVING count(area) > 340";
        rs = con.executeQuery(fietsroof);

        return rs;
    }
}



