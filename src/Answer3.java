/**
 * Created by Samuel on 18-04-16.
 */
public class Answer3 {
    private String voorval_nr;
    private int overvalbuit;

    public Answer3(String voorval_nr, int overvalbuit) {
        this.voorval_nr = voorval_nr;
        this.overvalbuit = overvalbuit;
    }

    public String getVoorval_nr() {
        return voorval_nr;
    }

    public int getOvervalbuit() {
        return overvalbuit;
    }

    @Override
    public String toString() {
        return "Buit per overval{" +
                "Soort buit='" + overvalbuit + '\'' +
                ", aantal=" + voorval_nr +
                '}';
    }
}
