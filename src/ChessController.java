import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class ChessController {

    @FXML
    private Pane a1, a2, a3, a4, a5, a6, a7, a8, b1, b2, b3, b4, b5, b6, b7, b8,
                 c1, c2, c3, c4, c5, c6, c7, c8, d1, d2, d3, d4, d5, d6, d7, d8,
                 e1, e2, e3, e4, e5, e6, e7, e8, f1, f2, f3, f4, f5, f6, f7, f8,
                 g1, g2, g3, g4, g5, g6, g7, g8, h1, h2, h3, h4, h5, h6, h7, h8;

    @FXML
    private TextField positionTextField;

    @FXML
    private TextArea notepadTextArea;

    @FXML
    private ImageView a8ImageView;

    @FXML
    public void initialize() {
        setNotepadText();
        initializeBoard();
        setA8ImageView();
    }

    @FXML
    private void setA8ImageView() {
        Image image = new Image("black-bishop.png");
        a8ImageView.setImage(image);
        System.out.println("image showing");
    }

    @FXML
    public void initializeBoard() {
        Pane[] lightSquares = {a2, a4, a6, a8, b1, b3, b5, b7, c2, c4, c6, c8, d1, d3, d5, d7, e2, e4, e6, e8, f1, f3, f5, f7, g2, g4, g6, g8, h1, h3, h5, h7};
        Pane[] darkSquares = {a1, a3, a5, a7, b2, b4, b6, b8, c1, c3, c5, c7, d2, d4, d6, d8, e1, e3, e5, e7, f2, f4, f6, f8, g1, g3, g5, g7, h2, h4, h6, h8};

        for (Pane p : lightSquares) {
            p.setStyle("-fx-background-color: #fff;");
        }
        for (Pane p : darkSquares) {
            p.setStyle("-fx-background-color: #bbb;");
        }
    }

    @FXML
    public void heatMap() {
        initializeBoard();
        Pane[] squares = {
            a1, a2, a3, a4, a5, a6, a7, a8, b1, b2, b3, b4, b5, b6, b7, b8,
            c1, c2, c3, c4, c5, c6, c7, c8, d1, d2, d3, d4, d5, d6, d7, d8,
            e1, e2, e3, e4, e5, e6, e7, e8, f1, f2, f3, f4, f5, f6, f7, f8,
            g1, g2, g3, g4, g5, g6, g7, g8, h1, h2, h3, h4, h5, h6, h7, h8
        };

        FENViewer viewer = new FENViewer(positionTextField.getText());
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
    public void startHeatMap() {
        positionTextField.setText("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        heatMap();
    }

    @FXML
    public void clearTextField() {
        positionTextField.setText("");
        initializeBoard();
    }

    @FXML
    public void closeProgram() {
        Platform.exit();
    }

    @FXML
    public void openGithub() {
        if(Desktop.isDesktopSupported())
        {
            try {
                Desktop.getDesktop().browse(new URI("http://www.github.com/tlee753/chess-visualizer"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void openWebSite() {
        if(Desktop.isDesktopSupported())
        {
            try {
                Desktop.getDesktop().browse(new URI("http://tlee753.com/"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void setNotepadText() {
        notepadTextArea.setText("Example FEN positions:\n" +
                "Starting Position:\n" +
                "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR\n\n" +
                "Back Rank Checkmate:\n" +
                "R5k1/5ppp/8/8/8/8/8/6K1\n\n" +
                "Fischer Immortal Checkmater:\n" +
                "1Q6/5pk1/2p3p1/1p2N2p/1b5P/1bN5/2r3P1/2K5");
    }

    @FXML
    public void aboutProgram() {
        AlertBox.display("About Chess Viewer", "Chess Viewer is a JavaFx program designed and created by tlee753. It is licensed under the MIT open source license for use and modification without sale in reproduction. Thank you for your cooperation and for using Chess Viewer!");
    }

    @FXML
    public void instructions() {
        AlertBox.display("Chess Viewer Instructions", "Input the beginning of an FEN string into the \"Enter Position Here\" box and click \"Display Heatmap\" to portray this position as each piece is attacked. The green squares represent squares controlled by white - the stronger the green the better the control, and like wise red squares are controlled by black.");
    }
}