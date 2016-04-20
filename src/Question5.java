import DBConnect.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Question5 {
    private ResultSet rs;
    public String fietsmerk;
    DBConnect con = new DBConnect(); //A new instance of DBconnect is being created.

    //This method will accept a query from the database and execute it returning an rs which the controller will then walk through.
    public ResultSet getBuitTotaals_1() throws SQLException {

        //Variable "fietsmerk" gets filled with a query:
        fietsmerk = "SELECT fr.brand_type, count(fr.object) AS Aantal FROM Fietsroof fr WHERE object = 'FIETS' AND brand_type <> 'ONBEKEND' GROUP BY fr.brand_type HAVING count(fr.object) > 150";

        //The the instance of DBConnect is used and the query gets executed:
        rs = con.executeQuery(fietsmerk);

        //rs will be returned and used in Conroller class at the loadbar5 method.
        return rs;
    }
}