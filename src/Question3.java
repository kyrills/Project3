import DBConnect.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Question3 {
    private ResultSet rs;
    public String buit;
    DBConnect con = new DBConnect(); //A new instance of DBconnect is being created.

    //This method will accept a query from the database and execute it returning an rs which the controller will then walk through.
    public ResultSet getBuit() throws SQLException {

        //Variable "buit" gets filled with a query:
        buit = "SELECT object, count(voorval_nr)\n" +
                "FROM Fietsroof\n" +
                "GROUP BY object\n" +
                "HAVING object = \"fiets\"\n" +
                "\n" +
                "UNION\n" +
                "\n" +
                "SELECT object, count(voorval_nr)\n" +
                "FROM Fietsroof\n" +
                "GROUP BY object\n" +
                "HAVING object = \"bromfiets\"\n" +
                "\n" +
                "UNION\n" +
                "\n" +
                "SELECT object, count(voorval_nr)\n" +
                "FROM Fietsroof\n" +
                "GROUP BY object\n" +
                "HAVING object = \"snorfiets\"\n" +
                "\n" +
                "UNION\n" +
                "\n" +
                "SELECT object, count(voorval_nr)\n" +
                "FROM Straatroof\n" +
                "  WHERE object = \"GSM\"\n" +
                "GROUP BY object\n" +
                "\n" +
                "UNION\n" +
                "\n" +
                "SELECT object, count(voorval_nr)\n" +
                "FROM Straatroof\n" +
                "WHERE object = \"tas\"\n" +
                "GROUP BY object";

        //The the instance of DBConnect is used and the query gets executed:
        rs = con.executeQuery(buit);

        //rs will be returned and used in Conroller class at the loadbar3 method.
        return rs;
    }
}