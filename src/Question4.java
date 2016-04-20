import DBConnect.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Question4 {
    private ResultSet rs;
    public String delicten;
    DBConnect con = new DBConnect(); //A new instance of DBconnect is being created.

    //This method will accept a query from the database and execute it returning an rs which the controller will then walk through.
    public ResultSet getDelicten() throws SQLException {

        //Variable "delicten" gets filled with a query:
        delicten = "SELECT mid(date, 4, 2) AS maand, count(voorval_nr) AS aantal\n" +
                "FROM Crimes_fietsroof\n" +
                "WHERE right(date, length(date)-6) = \"2012\"\n" +
                "GROUP BY maand";

        //The the instance of DBConnect is used and the query gets executed:
        rs = con.executeQuery(delicten);

        //rs will be returned and used in Conroller class at the loadline4 method.
        return rs;

    }
}