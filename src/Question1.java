import DBConnect.DBConnect;
import java.sql.*;

public class Question1 {
    private ResultSet rs;
    public String fietsroof;
    DBConnect con = new DBConnect(); //A new instance of DBconnect is being created.

    //This method will accept a query from the database and execute it returning an rs which the controller will then walk through.
    public ResultSet getFietsroven_1() throws SQLException {

        //Variable "fietsroof" gets filled with a query:
        fietsroof =  "SELECT DISTINCT area, COUNT(area) AS Aantal FROM Neighbourhood_fietsroof WHERE location = \"ROTTERDAM\" GROUP BY area HAVING count(area) > 340";

        //The the instance of DBConnect is used and the query gets executed:
        rs = con.executeQuery(fietsroof);

        //rs will be returned and used in Conroller class at the loadbar1 method.
        return rs;
    }
}



