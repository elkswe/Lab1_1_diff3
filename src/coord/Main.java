package coord;

import coord.view.coordController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/coordView.fxml"));
        rootLayout = (BorderPane) loader.load();

        primaryStage.setTitle("Coordinates");
        primaryStage.setScene(new Scene(rootLayout));
        primaryStage.show();

        coordController coordController = loader.getController();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
