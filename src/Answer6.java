
public class Answer6 {
    private String day_time;
    private int count_overvallen;

    public Answer6(String day_time, int count_overvallen) {
        this.day_time = day_time;
        this.count_overvallen = count_overvallen;
    }

    public String getDay_time() {
        return day_time;
    }

    public int getCount_overvallen() {
        return count_overvallen;
    }

    @Override
    public String toString() {
        return "GevaarlijksteDagdeelTotaal{" +
                "dagdeel='" + day_time + '\'' +
                ", aantal=" + count_overvallen +

                '}';
    }
}
