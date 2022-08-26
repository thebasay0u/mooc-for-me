import java.util.HashMap;

public class IOU {

    private HashMap<String, Double> debts;

    public IOU() {
        this.debts = new HashMap<>();

    }

    public void setSum(String toWhom, double amount) {
        if (this.debts.isEmpty() || !this.debts.keySet().contains(toWhom)) {
            debts.put(toWhom, amount);
        } else {
            double currentDebt = debts.get(toWhom);
            debts.put(toWhom, currentDebt + amount);
        }

    }

    public double howMuchDoIOweTo(String toWhom) {
        if (this.debts.keySet().contains(toWhom)) {
            return debts.get(toWhom);
        } else {
            return 0;
        }

    }

    public String toString() {
        return debts.toString();

    }
}
