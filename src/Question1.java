import DBConnect.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyrilll van Seventer on 14/04/2016.
 */

public class Question1 {
    private ResultSet rs;
    public int Amount = 0;
    public String fietsroof;
    public String straatroof;
    public String namen;
    DBConnect con = new DBConnect();

    public void queries() throws SQLException {
    }

//    public List<diefstal> getFietsroven() throws SQLException {
////        System.out.println(con);
//        fietsroof =  "SELECT DISTINCT area, COUNT(area) AS Aantal FROM Neighbourhood_fietsroof WHERE location = \"ROTTERDAM\" GROUP BY area HAVING count(area) > 340";
//        rs = con.executeQuery(fietsroof);
//
//        List<diefstal> fietsroofTotaals = new ArrayList<>();
//        while (!rs.isLast()) {
//            rs.next();
//            diefstal fietsroofTotaal = new diefstal( rs.getString("area"), rs.getInt("Aantal"));
//
//
////            System.out.println(fietsroofTotaal);
//            fietsroofTotaals.add(fietsroofTotaal);
//            Amount += 1;
//        }
//
//        return fietsroofTotaals;
//    }

    public ResultSet getFietsroven_1() throws SQLException {
        System.out.println(con);
        fietsroof =  "SELECT DISTINCT area, COUNT(area) AS Aantal FROM Neighbourhood_fietsroof WHERE location = \"ROTTERDAM\" GROUP BY area HAVING count(area) > 340";
        rs = con.executeQuery(fietsroof);

        return rs;
    }

//    public List<diefstal> getStraatroven() throws SQLException {
//        System.out.println(con);
//        straatroof = "SELECT DISTINCT area, COUNT(area) AS Aantal FROM Neighbourhood_straatroof WHERE location = \"ROTTERDAM\" GROUP BY area HAVING count(area) > 75";
//        rs = con.executeQuery(straatroof);
//
//
//        List<diefstal> straatroofTotaals = new ArrayList<>();
//        while (!rs.isLast()) {
//            rs.next();
//            diefstal straatroofTotaal = new diefstal(rs.getString("area"), rs.getInt("Aantal"));
//
//            straatroofTotaals.add(straatroofTotaal);
//            Amount += 1;
//            System.out.println(straatroofTotaal);
//        }
//
//        return straatroofTotaals;
//    }
//    public List<namen> getnamen() throws SQLException {
//        namen = "SELECT DISTINCT area, COUNT(area) AS Aantal FROM Neighbourhood_straatroof WHERE location = \"ROTTERDAM\" GROUP BY area HAVING count(area) > 75";
//        rs = con.executeQuery(namen);
//
//        List<namen> areas = new ArrayList<>();
//        while (!rs.isLast()) {
//            rs.next();
//            namen area1 = new namen (rs.getString("area"));
//
//            areas.add(area1);
//            Amount += 1;
//        }
//
//    }


}



