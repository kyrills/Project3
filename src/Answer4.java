/**
 * Created by Gebruiker on 19-4-2016.
 */
public class Answer4 {
    private String maand;
    private int overvallen;

    public Answer4(String maand, int overvallen) {
        this.maand = maand;
        this.overvallen = overvallen;
    }

    public String getMaand() {
        return maand;
    }

    public void setMaand(String maand) {
        this.maand = maand;
    }

    public int getOvervallen() {
        return overvallen;
    }

    public void setOvervallen(int overvallen) {
        this.overvallen = overvallen;
    }

    @Override
    public String toString() {
        return "GevaarlijksteWijkenTotaal{" +
                "maand='" + maand + '\'' +
                ", aantal=" + overvallen +
                '}';
    }
}