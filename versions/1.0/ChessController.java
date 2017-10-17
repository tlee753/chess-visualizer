import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Arrays;

public class ChessController {

    @FXML
    private Pane a1, a2, a3, a4, a5, a6, a7, a8, b1, b2, b3, b4, b5, b6, b7, b8,
                 c1, c2, c3, c4, c5, c6, c7, c8, d1, d2, d3, d4, d5, d6, d7, d8,
                 e1, e2, e3, e4, e5, e6, e7, e8, f1, f2, f3, f4, f5, f6, f7, f8,
                 g1, g2, g3, g4, g5, g6, g7, g8, h1, h2, h3, h4, h5, h6, h7, h8;

    @FXML
    private Button heatMapButton;

    @FXML
    private TextField positionField;

    @FXML
    void initialize() {
        Pane[] lightSquares = {a2, a4, a6, a8, b1, b3, b5, b7, c2, c4, c6, c8, d1, d3, d5, d7, e2, e4, e6, e8, f1, f3, f5, f7, g2, g4, g6, g8, h1, h3, h5, h7};
        Pane[] darkSquares = {a1, a3, a5, a7, b2, b4, b6, b8, c1, c3, c5, c7, d2, d4, d6, d8, e1, e3, e5, e7, f2, f4, f6, f8, g1, g3, g5, g7, h2, h4, h6, h8};

        for (Pane p : lightSquares) {
            p.setStyle("-fx-background-color: #fff;");
        }
        for (Pane p : darkSquares) {
            p.setStyle("-fx-background-color: #bbb;");
        }
        // System.out.println("initialized...");
    }

    @FXML
    void heatMap() {
        initialize();
        Pane[] squares = {
            a1, a2, a3, a4, a5, a6, a7, a8, b1, b2, b3, b4, b5, b6, b7, b8,
            c1, c2, c3, c4, c5, c6, c7, c8, d1, d2, d3, d4, d5, d6, d7, d8,
            e1, e2, e3, e4, e5, e6, e7, e8, f1, f2, f3, f4, f5, f6, f7, f8,
            g1, g2, g3, g4, g5, g6, g7, g8, h1, h2, h3, h4, h5, h6, h7, h8
        };

        FENViewer viewer = new FENViewer(positionField.getText());
        int[][] pointArray = viewer.getPointArray();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int points = pointArray[j][i];
                String hex = "";
                if (points > 0) {
                    switch (points) {
                        case 1:
                            hex = "f";
                            break;
                        case 2:
                            hex = "b";
                            break;
                        case 3:
                            hex = "8";
                            break;
                        case 4:
                            hex = "4";
                            break;
                        default:
                            hex = "0";
                    }
                    squares[j * 8 + (7-i)].setStyle("-fx-background-color: #0" + hex + "0;");
                } else if (points < 0) {
                    switch (points) {
                        case -1:
                            hex = "f";
                            break;
                        case -2:
                            hex = "b";
                            break;
                        case -3:
                            hex = "8";
                            break;
                        case -4:
                            hex = "4";
                            break;
                        default:
                            hex = "0";
                    }
                    squares[j * 8 + (7-i)].setStyle("-fx-background-color: #" + hex + "00;");
                }
            }
        }

    }

    @FXML
    void startHeatMap() {
        positionField.setText("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        heatMap();
    }

    @FXML
    void clearTextField() {
        initialize();
        positionField.setText("");
    }
}