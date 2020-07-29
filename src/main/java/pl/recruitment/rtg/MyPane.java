package pl.recruitment.rtg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MyPane extends Pane {

    public MyPane() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Point.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
