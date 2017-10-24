import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String title, String message) {
        Stage window = new Stage();

        // blocks other user events in other windows until this one is taken care of
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(500);

        Label label = new Label();
        label.setPrefWidth(500);
        label.setWrapText(true);
        label.setText(message);
        Button closeButton = new Button("Close");
        closeButton.setStyle("-fx-padding: 10px;");
        closeButton.setOnAction(e -> window.close());

        label.setPadding(new Insets(10));
        closeButton.setPadding(new Insets(0, 10, 10, 10));

        VBox layout = new VBox();
        layout.setPadding(new Insets(0, 0, 10, 0));
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.showAndWait();
    }

}
