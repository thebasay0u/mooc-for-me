package FlightControl;

import java.util.Scanner;

import FlightControl.UI.TextUI;
import FlightControl.domain.Flight;
import FlightControl.logic.FlightControl;

public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.
        Scanner scan = new Scanner(System.in);
        FlightControl ATC = new FlightControl();
        TextUI textUI = new TextUI(ATC, scan);

        textUI.start();

    }
}
