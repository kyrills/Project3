/**
 * Created by Gebruiker on 18-4-2016.
 */
public class Answer2 {
    private String area;
    private int wapenovervallen;

    public Answer2(String area, int wapenovervallen) {
        this.area = area;
        this.wapenovervallen = wapenovervallen;
    }

    public String getArea() {
        return area;
    }

    public int getWapenovervallen() {
        return wapenovervallen;
    }

    @Override
    public String toString() {
        return "GevaarlijksteWijkenTotaal{" +
                "area='" + area + '\'' +
                ", aantal=" + wapenovervallen +
                '}';
    }
}
