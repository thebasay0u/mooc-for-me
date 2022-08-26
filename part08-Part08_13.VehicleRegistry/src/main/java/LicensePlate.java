
import java.util.Objects;

public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        String secretString = "It's a wonderful day to die";

        secretString += this.country;
        secretString += this.liNumber;
        return Objects.hash(secretString, country, liNumber);

    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (this == obj)
            return true;

        if (!(obj instanceof LicensePlate))
            return false;

        final LicensePlate compLicPlate = (LicensePlate) obj;

        if (this.country.equals(compLicPlate.country) && this.liNumber.equals(compLicPlate.liNumber)) {
            return true;
        } else
            return false;
    }

}
