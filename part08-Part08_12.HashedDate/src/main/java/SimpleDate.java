import java.util.Objects;

public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(SimpleDate other) {
        if (this.year < other.year) {
            return true;
        }

        if (this.year == other.year
                && this.month < other.month) {
            return true;
        }

        if (this.year == other.year
                && this.month == other.month
                && this.day < other.day) {
            return true;
        }

        return false;
    }

    public int differenceInYears(SimpleDate other) {
        if (earlier(other)) {
            return other.differenceInYears(this);
        }

        int yearRemoved = 0;

        if (this.month < other.month) {
            yearRemoved = 1;
        } else if (this.month == other.month && this.day < other.day) {
            yearRemoved = 1;
        }

        return this.year - other.year - yearRemoved;
    }

    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof SimpleDate)) {
            return false;
        }

        SimpleDate simpleObject = (SimpleDate) object;

        if (this.day == simpleObject.day && this.month == simpleObject.month && this.year == simpleObject.year) {
            return true;
        }

        return false;

    }

    /**
     * 
     * 
     */
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        if (this.year >= 1900 && this.year <= 2100) {
            int hash = 999;
            hash *= hash + this.day;
            hash *= hash + this.month;
            hash *= hash + this.year;
            return Objects.hash(day, month, year);

        } else {
            int hash = 17;
            hash = 31 * hash + this.day;
            hash = 31 * hash + this.month;
            hash = 31 * hash + this.year;
            return Objects.hash(day, month, year);
        }

    }

}
