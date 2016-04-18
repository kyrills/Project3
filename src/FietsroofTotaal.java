/**
 * Created by Kyrilll van Seventer on 18/04/2016.
 */
public class FietsroofTotaal {
    private String area;
    private int aantal;

    public FietsroofTotaal(String area, int aantal) {
        this.area = area;
        this.aantal = aantal;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    @Override
    public String toString() {
        return "FietsroofTotaal{" +
                "area='" + area + '\'' +
                ", aantal=" + aantal +
                '}';
    }
}
