package pl.recruitment.rtg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainView.fxml"));
        Scene primaryScene = new Scene(root);
        primaryScene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        primaryStage.setScene(primaryScene);

        primaryStage.minHeightProperty().setValue(850);
        primaryStage.minWidthProperty().setValue(1280);

        primaryStage.setTitle("RTG Analysis");
        primaryStage.show();
    }
}
