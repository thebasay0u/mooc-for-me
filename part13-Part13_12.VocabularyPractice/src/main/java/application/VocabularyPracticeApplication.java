package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// END SOLUTION
public class VocabularyPracticeApplication extends Application {

    private Dictionary _dictionary;

    @Override
    public void init() throws Exception {
        // # 1. Initialize dictionary object variable
        this._dictionary = new Dictionary();

    }

    @Override
    public void start(Stage window) throws Exception {

        // # 2. Create views
        PracticeView pracView = new PracticeView(_dictionary);
        InputView inputView = new InputView(_dictionary);

        // # 3. Create high level layout
        BorderPane mainLayout = new BorderPane();

        // # 3.1 - Create menu for main layout
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));

        // # 3.2 - Create menu buttons
        Button enterButton = new Button("Enter new words");
        Button practiceButton = new Button("Practice");

        // # 3.3 - Add buttons to menu
        menu.getChildren().addAll(enterButton, practiceButton);
        mainLayout.setTop(menu);

        // # 4 - connect subviews and buttons; Clicking menu buttons changes subview
        enterButton.setOnAction(event -> mainLayout.setCenter(inputView.getView()));

        practiceButton.setOnAction((event) -> mainLayout.setCenter(pracView.getView()));

        // # 5 - First show the input view
        mainLayout.setCenter(inputView.getView());

        // # 6 Create the main view and add high level layout
        Scene view = new Scene(mainLayout, 400, 300);

        // # 7 - Show the application
        window.setScene(view);
        window.show();

    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}
