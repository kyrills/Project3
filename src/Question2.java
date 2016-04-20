import DBConnect.DBConnect;
import java.sql.*;

public class Question2 {
    private ResultSet rs;
    public String gevaarlijkstewijk;
    DBConnect con = new DBConnect();

    //This method will accept a query from the databse and execute it returning an rs which the controller will then walk through.
    public ResultSet getGevaarlijk() throws SQLException {

        //Variable "gevaarlijkstewijk" gets filled with a query:
        gevaarlijkstewijk = "SELECT ns.area, count(s.weapon)\n" +
                "FROM Neighbourhood_straatroof ns, Straatroof s\n" +
                "WHERE s.weapon = \"ja\" AND\n" +
                "      ns.location = \"ROTTERDAM\" AND\n" +
                "      ns.voorval_nr = s.voorval_nr\n" +
                "GROUP BY ns.area\n" +
                "HAVING count(s.weapon) > 14";

        //The the instance of DBConnect is used and the query gets executed:
        rs = con.executeQuery((gevaarlijkstewijk));

        //rs will be returned and used in Conroller class at the loadbar2 method.
        return rs;
    }
}