import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class VehicleRegistry {

    private HashMap<LicensePlate, String> registry;

    public VehicleRegistry() {
        this.registry = new HashMap<>();

    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if ((this.registry.keySet().contains(licensePlate)))
            return false;
        else {
            this.registry.put(licensePlate, owner);
            return true;
        }
    }

    public String get(LicensePlate licensePlate) {

        return this.registry.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (!this.registry.keySet().contains(licensePlate))
            return false;
        else {
            this.registry.remove(licensePlate);
            return true;
        }
    }

    public void printLicensePlates() {

        for (LicensePlate lp : this.registry.keySet()) {
            System.out.println(lp);
        }
    }

    public void printOwners() {
        Set<String> valueSet = new HashSet<>(this.registry.values());
        for (String s : valueSet) {
            System.out.println(s);
        }
    }

}
