import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.NoSuchElementException;


public class ChessController {

    @FXML
    private Pane a1, a2, a3, a4, a5, a6, a7, a8, b1, b2, b3, b4, b5, b6, b7, b8,
                 c1, c2, c3, c4, c5, c6, c7, c8, d1, d2, d3, d4, d5, d6, d7, d8,
                 e1, e2, e3, e4, e5, e6, e7, e8, f1, f2, f3, f4, f5, f6, f7, f8,
                 g1, g2, g3, g4, g5, g6, g7, g8, h1, h2, h3, h4, h5, h6, h7, h8;

    @FXML
    private ImageView a1ImageView, a2ImageView, a3ImageView, a4ImageView,
                      a5ImageView, a6ImageView, a7ImageView, a8ImageView,
                      b1ImageView, b2ImageView, b3ImageView, b4ImageView,
                      b5ImageView, b6ImageView, b7ImageView, b8ImageView,
                      c1ImageView, c2ImageView, c3ImageView, c4ImageView,
                      c5ImageView, c6ImageView, c7ImageView, c8ImageView,
                      d1ImageView, d2ImageView, d3ImageView, d4ImageView,
                      d5ImageView, d6ImageView, d7ImageView, d8ImageView,
                      e1ImageView, e2ImageView, e3ImageView, e4ImageView,
                      e5ImageView, e6ImageView, e7ImageView, e8ImageView,
                      f1ImageView, f2ImageView, f3ImageView, f4ImageView,
                      f5ImageView, f6ImageView, f7ImageView, f8ImageView,
                      g1ImageView, g2ImageView, g3ImageView, g4ImageView,
                      g5ImageView, g6ImageView, g7ImageView, g8ImageView,
                      h1ImageView, h2ImageView, h3ImageView, h4ImageView,
                      h5ImageView, h6ImageView, h7ImageView, h8ImageView;

    @FXML
    private TextField positionTextField;

    @FXML
    private TextArea notepadTextArea;

    @FXML
    public void initialize() {
        setNotepadText();
        initializeBoard();
        initializeImageViews();
    }

    @FXML
    private void setImageView(Pane pane, ImageView imageView, Character piece) {
        imageView.fitWidthProperty().bind(pane.widthProperty());
        imageView.fitHeightProperty().bind(pane.heightProperty());
        switch (piece) {

        }
        imageView.setImage(new Image("assets/black-bishop.png"));
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
    private void initializeImageViews() {
        Pane[] squares = {
                a1, a2, a3, a4, a5, a6, a7, a8, b1, b2, b3, b4, b5, b6, b7, b8,
                c1, c2, c3, c4, c5, c6, c7, c8, d1, d2, d3, d4, d5, d6, d7, d8,
                e1, e2, e3, e4, e5, e6, e7, e8, f1, f2, f3, f4, f5, f6, f7, f8,
                g1, g2, g3, g4, g5, g6, g7, g8, h1, h2, h3, h4, h5, h6, h7, h8
        };
        ImageView[] views = {
                a1ImageView, a2ImageView, a3ImageView, a4ImageView,
                a5ImageView, a6ImageView, a7ImageView, a8ImageView,
                b1ImageView, b2ImageView, b3ImageView, b4ImageView,
                b5ImageView, b6ImageView, b7ImageView, b8ImageView,
                c1ImageView, c2ImageView, c3ImageView, c4ImageView,
                c5ImageView, c6ImageView, c7ImageView, c8ImageView,
                d1ImageView, d2ImageView, d3ImageView, d4ImageView,
                d5ImageView, d6ImageView, d7ImageView, d8ImageView,
                e1ImageView, e2ImageView, e3ImageView, e4ImageView,
                e5ImageView, e6ImageView, e7ImageView, e8ImageView,
                f1ImageView, f2ImageView, f3ImageView, f4ImageView,
                f5ImageView, f6ImageView, f7ImageView, f8ImageView,
                g1ImageView, g2ImageView, g3ImageView, g4ImageView,
                g5ImageView, g6ImageView, g7ImageView, g8ImageView,
                h1ImageView, h2ImageView, h3ImageView, h4ImageView,
                h5ImageView, h6ImageView, h7ImageView, h8ImageView
        };
        for (int i = 0; i < 64; i++) {
            views[i].fitWidthProperty().bind(squares[i].widthProperty());
            views[i].fitHeightProperty().bind(squares[i].heightProperty());
            views[i].setImage(null);
        }
    }

    @FXML
    public void heatMap() {
        initializeBoard();
        initializeImageViews();
        Pane[] squares = {
            a1, a2, a3, a4, a5, a6, a7, a8, b1, b2, b3, b4, b5, b6, b7, b8,
            c1, c2, c3, c4, c5, c6, c7, c8, d1, d2, d3, d4, d5, d6, d7, d8,
            e1, e2, e3, e4, e5, e6, e7, e8, f1, f2, f3, f4, f5, f6, f7, f8,
            g1, g2, g3, g4, g5, g6, g7, g8, h1, h2, h3, h4, h5, h6, h7, h8
        };
        ImageView[] views = {
                a1ImageView, a2ImageView, a3ImageView, a4ImageView,
                a5ImageView, a6ImageView, a7ImageView, a8ImageView,
                b1ImageView, b2ImageView, b3ImageView, b4ImageView,
                b5ImageView, b6ImageView, b7ImageView, b8ImageView,
                c1ImageView, c2ImageView, c3ImageView, c4ImageView,
                c5ImageView, c6ImageView, c7ImageView, c8ImageView,
                d1ImageView, d2ImageView, d3ImageView, d4ImageView,
                d5ImageView, d6ImageView, d7ImageView, d8ImageView,
                e1ImageView, e2ImageView, e3ImageView, e4ImageView,
                e5ImageView, e6ImageView, e7ImageView, e8ImageView,
                f1ImageView, f2ImageView, f3ImageView, f4ImageView,
                f5ImageView, f6ImageView, f7ImageView, f8ImageView,
                g1ImageView, g2ImageView, g3ImageView, g4ImageView,
                g5ImageView, g6ImageView, g7ImageView, g8ImageView,
                h1ImageView, h2ImageView, h3ImageView, h4ImageView,
                h5ImageView, h6ImageView, h7ImageView, h8ImageView
        };

        FENViewer viewer = new FENViewer(positionTextField.getText());
        int[][] pointArray = viewer.getPointArray();
        char[][] pieceArray = viewer.getPositionArray();
        boolean[][] tensionArray = viewer.getTensionArray();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                // adjust colors via points
                int points = pointArray[j][i];
                String hex = "";
                if (points == 0) {
                    if (tensionArray[j][i]) {
                        squares[j * 8 + (7-i)].setStyle("-fx-background-color: #ff0;");
                    }
                } else if (points > 0) {
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
                } else {
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

                // add pieces to squares
                char piece = pieceArray[j][i];

                switch (piece) {
                    case 'p':
                        views[j * 8 + (7-i)].setImage(new Image("assets/black-pawn.png"));
                        break;
                    case 'r':
                        views[j * 8 + (7-i)].setImage(new Image("assets/black-rook.png"));
                        break;
                    case 'n':
                        views[j * 8 + (7-i)].setImage(new Image("assets/black-knight.png"));
                        break;
                    case 'b':
                        views[j * 8 + (7-i)].setImage(new Image("assets/black-bishop.png"));
                        break;
                    case 'q':
                        views[j * 8 + (7-i)].setImage(new Image("assets/black-queen.png"));
                        break;
                    case 'k':
                        views[j * 8 + (7-i)].setImage(new Image("assets/black-king.png"));
                        break;
                    case 'P':
                        views[j * 8 + (7-i)].setImage(new Image("assets/white-pawn.png"));
                        break;
                    case 'R':
                        views[j * 8 + (7-i)].setImage(new Image("assets/white-rook.png"));
                        break;
                    case 'N':
                        views[j * 8 + (7-i)].setImage(new Image("assets/white-knight.png"));
                        break;
                    case 'B':
                        views[j * 8 + (7-i)].setImage(new Image("assets/white-bishop.png"));
                        break;
                    case 'Q':
                        views[j * 8 + (7-i)].setImage(new Image("assets/white-queen.png"));
                        break;
                    case 'K':
                        views[j * 8 + (7-i)].setImage(new Image("assets/white-king.png"));
                        break;
                    case '*':
                        break;
                    default:
                        throw new NoSuchElementException("wtf bro");
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
        initializeImageViews();
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
                "Fischer Immortal Checkmate:\n" +
                "1Q6/5pk1/2p3p1/1p2N2p/1b5P/1bn5/2r3P1/2K5");
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