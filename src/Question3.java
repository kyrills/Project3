import DBConnect.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Question3 {
    private ResultSet rs;
    public String buit;
    DBConnect con = new DBConnect();

    public ResultSet getBuit() throws SQLException {

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

        rs = con.executeQuery(buit);

        return rs;
    }
}