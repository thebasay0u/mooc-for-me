package mooc.logic;

import mooc.ui.UserInterface;

public class ApplicationLogic {

    private UserInterface _ui;

    public ApplicationLogic(UserInterface ui) {
        this._ui = ui;

    }

    public void execute(int times) {

        for (int i = 1; i <= times; i++) {
            System.out.println("Application logic is working");
            this._ui.update();
        }

    }
}
