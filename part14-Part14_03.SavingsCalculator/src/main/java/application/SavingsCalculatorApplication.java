package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    private UI_Layout layout;

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    private void initUI() {
        this.layout = new UI_Layout();

    }

    @Override
    public void start(Stage window) throws Exception {
        initUI();
        BorderPane pane = layout.getLayout();

        Scene view = new Scene(pane, UI_Constants.APP_WIDTH, UI_Constants.APP_HEIGHT);

        window.setTitle("Savings Calculator");
        window.setScene(view);
        window.show();

    }

}
