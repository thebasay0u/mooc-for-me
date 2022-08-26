import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner _scanner;
    private List<String> _inputs;

    public UserInterface(Scanner scanner, List<String> inputs) {
        this._inputs = inputs;
        this._scanner = scanner;
    }

    public void startUI() {

        boolean keepGoing = true;
        while (keepGoing) {
            String input = _scanner.nextLine();
            if (input.isEmpty())
                break;
            else {
                _inputs.add(input);
            }
        }

        _inputs.stream().forEach(in -> System.out.println(in));
    }

}
