package com.debug.satyajit.billingsystem;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

public class BillingApplication extends Application {

    /*  use this stage to go through difference screens
    that's why make it static, one single instance will exist
     */
    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        /* assign the global stage */
        this.stage = stage;
        this.stage.setResizable(false);

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/HomeScreen.fxml"));
        new JMetro(JMetro.Style.DARK).applyTheme(root);

        Scene scene = new Scene(root);
        stage.setTitle("ACME Billing System");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initialize();
        launch(args);
    }

    private static void initialize() {
        Font.loadFont(BillingApplication.class.getResource("/fonts/RobotoMono-Regular.ttf").toExternalForm(), 10);
    }

    public static Stage getStage() {
        return BillingApplication.stage;
    }

}
