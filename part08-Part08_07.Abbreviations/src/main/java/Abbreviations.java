import java.util.HashMap;

public class Abbreviations {
    private HashMap<String, String> abbreviations;

    public Abbreviations() {
        this.abbreviations = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        if (!this.hasAbbreviation(abbreviation))
            this.abbreviations.put(abbreviation, explanation);
        else
            System.out.println("Abbreviation already added");
    }

    public boolean hasAbbreviation(String abbreviation) {
        if (this.abbreviations.containsKey(abbreviation)) {
            return true;
        } else {
            return false;
        }
    }

    public String findExplanationFor(String abbreviation) {
        return this.abbreviations.get(abbreviation);
    }
}
