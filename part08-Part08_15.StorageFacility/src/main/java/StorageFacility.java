import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, StorageUnit> facility;

    public StorageFacility() {
        this.facility = new HashMap<>();
    }

    /**
     * * adds the item to the storage unit given as a parameter
     * 
     * @param unit
     * @param item
     */
    public void add(String unit, String item) {
        if (this.storageUnitCurrentlyExists(unit)) {

            // # copy existing content
            ArrayList<String> contentCopy = facility.get(unit).getUnitContents();
            // # add new item to existing content
            contentCopy.add(item);
            // # replace the key:value pair in Hash Map
            facility.put(unit, new StorageUnit(unit, contentCopy));
        } else {
            ArrayList<String> newContent = new ArrayList<String>();
            newContent.add(item);
            facility.putIfAbsent(unit, new StorageUnit(unit, newContent));
        }

    }

    public ArrayList<String> contents(String storageUnit) {

        if (this.storageUnitCurrentlyExists(storageUnit)) {
            return facility.get(storageUnit).getUnitContents();
        } else {
            return new ArrayList<>();
        }

    }

    /**
     * * Removes the given item from the storage unit.
     * * Only removes ONE item, if there are several items with the same name, only
     * one should be removed.
     * ! If the unit would be empty after the removal, the method ALSO REMOVES THE
     * UNIT
     * 
     * @param storageUnit
     * @param item
     */
    public void remove(String storageUnit, String item) {
        if (this.storageUnitCurrentlyExists(storageUnit)) {
            this.facility.get(storageUnit).removeItemFromUnit(item);
            if (this.facility.get(storageUnit).getUnitContents().size() == 0) {
                this.facility.remove(storageUnit);
            }

        } else {
            return;
        }

    }

    /**
     * * returns the names of the storage units as a list. ONLY THE UNITS THAT
     * CONTAIN ITEMS ARE LISTED
     * 
     * @return
     */
    public ArrayList<String> storageUnits() {
        ArrayList<String> returnList = new ArrayList<>();
        for (String unitName : this.facility.keySet()) {
            if (this.facility.get(unitName).getUnitContents().size() > 0) {
                returnList.add(unitName);
            }
        }
        return returnList;
    }

    // # helper method to check whether storage unit exists in Hash Map
    public boolean storageUnitCurrentlyExists(String unitName) {
        if (facility.keySet().contains(unitName)) {
            return true;
        } else {
            return false;
        }
    }

}
