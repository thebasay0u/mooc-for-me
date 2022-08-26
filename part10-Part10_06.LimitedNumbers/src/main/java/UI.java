import java.util.List;
import java.util.Scanner;

public class UI {
    private Scanner _scan;
    private List<Integer> _inputs;

    public UI(Scanner scanner, List<Integer> inputs) {
        this._inputs = inputs;
        this._scan = scanner;
    }

    public void startUI() {

        boolean dontstop = true;

        while (dontstop) {
            int numIn = Integer.parseInt(_scan.nextLine());
            if (numIn < 0) {
                dontstop = false;
                break;
            } else {
                _inputs.add(numIn);
            }
        }
        _inputs.stream().filter(x -> x >= 1 && x <= 5).forEach(num -> System.out.println(num));
    }
}
