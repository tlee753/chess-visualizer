import javafx.application.Application;

// Scene
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

// Stage
import javafx.stage.Stage;

public class ChessApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ChessViewer-2.0.fxml"));

        stage.setTitle("Chess Viewer 2.0");
        stage.setScene(new Scene(root, 1200, 720));
        stage.show();
    }
}
