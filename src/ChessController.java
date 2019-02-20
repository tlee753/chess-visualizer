import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.ActionEvent;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.NoSuchElementException;

import javax.swing.border.Border;

import chesspresso.Chess;
import chesspresso.game.Game;
import chesspresso.position.Position;
import chesspresso.pgn.PGN;
import chesspresso.pgn.PGNReader;


public class ChessController {

    Game theGame;

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
    private TextField gameTextField;

    @FXML
    private TextField positionTextField;

    @FXML
    private TextArea notepadTextArea;

    @FXML
    private Text scoreText;

    @FXML
    private Text gameImportText;

    @FXML
    private ImageView logoImageView;

    @FXML
    private MenuItem setFullScreenMenuItem;

    @FXML
    private RadioButton radioBoth;

    @FXML
    private RadioButton radioWhite;

    @FXML
    private RadioButton radioBlack;

    private ToggleGroup radioToggle = new ToggleGroup();
    private boolean fullScreenToggle = false;
    private boolean darkModeToggle = false;

    @FXML
    public void initialize() {
        setNotepadText();
        initializeBoard();
        initializeImageViews();
        initializeLogoImageView();

        radioBoth.setUserData("both");
        radioWhite.setUserData("white");
        radioBlack.setUserData("black");
        radioBoth.setToggleGroup(radioToggle);
        radioWhite.setToggleGroup(radioToggle);
        radioBlack.setToggleGroup(radioToggle);
        radioBoth.setSelected(true);
    }

    @FXML
    public void initializeBoard() {
        Pane[] lightSquares = {a2, a4, a6, a8, b1, b3, b5, b7, c2, c4, c6, c8, d1, d3, d5, d7, e2, e4, e6, e8, f1, f3, f5, f7, g2, g4, g6, g8, h1, h3, h5, h7};
        Pane[] darkSquares = {a1, a3, a5, a7, b2, b4, b6, b8, c1, c3, c5, c7, d2, d4, d6, d8, e1, e3, e5, e7, f2, f4, f6, f8, g1, g3, g5, g7, h2, h4, h6, h8};

        for (Pane p : lightSquares) {
            p.setStyle("-fx-background-color: #f8f8ff;");
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
    private void openFile() throws Exception {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open PGN File");
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            notepadTextArea.setText("");
            gameTextField.setText(file.toString());
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line = null;
                while( (line = bufferedReader.readLine()) != null ) {
                    notepadTextArea.appendText(line + "\n");
                }
            } catch (FileNotFoundException e) {
                System.out.println("hit");
            } catch (IOException e) {
                System.out.println("hit");
            }
            importGame();
        }
    }

    @FXML
    private void importGame() throws Exception {
        String gameFileName = "";
        if (gameTextField.getText().isEmpty()) {
            return;
        } else if (gameTextField.getText().substring(gameTextField.getText().length() - 4).equals(".pgn")) {
            gameFileName = gameTextField.getText();
        } else {
            gameFileName = gameTextField.getText() + ".pgn";
        }
        PGNReader pgnReader = new PGNReader(gameFileName);
        gameImportText.setText("File " + gameFileName + " has been imported.");
        theGame = pgnReader.parseGame();
        // notepadTextArea.setText(theGame.toString());
        theGame.gotoStart();
        positionTextField.setText(theGame.getPosition().getFEN());
        heatMap();
    }

    @FXML
    private void restartGame() {
        if (theGame != null) {
            theGame.gotoStart();
            positionTextField.setText(theGame.getPosition().getFEN());
            heatMap();
        }
    }

    @FXML
    private void previousMove() {
        if (theGame != null) {
            theGame.goBack();
            positionTextField.setText(theGame.getPosition().getFEN());
            heatMap();
        }
    }

    @FXML
    private void nextMove() {
        if (theGame != null) {
            theGame.goForward();
            positionTextField.setText(theGame.getPosition().getFEN());
            heatMap();
        }
    }

    @FXML
    public void heatMap() {
        initializeBoard();
        initializeImageViews();
        String radioAnswer = radioToggle.getSelectedToggle().getUserData().toString();
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

        if (positionTextField.getText().isEmpty()) {
            return;
        }

        FENViewer viewer = new FENViewer(positionTextField.getText(), radioAnswer);
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
                        squares[j * 8 + (7-i)].setStyle("-fx-background-color: #fffc66;");
                    }
                } else if (points > 0) {
                    switch (points) {
                        case 1:
                            hex = "#88fa4e";
                            break;
                        case 2:
                            hex = "#61d836";
                            break;
                        case 3:
                            hex = "#1db100";
                            break;
                        case 4:
                            hex = "#017100";
                            break;
                        case 5:
                            hex = "#017100";
                            break;
                        default:
                            hex = "#017100";
                    }
                    squares[j * 8 + (7-i)].setStyle("-fx-background-color: " + hex + ";");
                } else if (points < 0) {
                    switch (points) {
                        case -1:
                            hex = "#ff968d";
                            break;
                        case -2:
                            hex = "#ff644e";
                            break;
                        case -3:
                            hex = "#ee220c";
                            break;
                        case -4:
                            hex = "#b51700";
                            break;
                        case 5:
                            hex = "#b51700";
                            break;
                        default:
                            hex = "#b51700";
                    }
                    squares[j * 8 + (7-i)].setStyle("-fx-background-color: " + hex + ";");
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
                        throw new NoSuchElementException("Can't find the element.");
                }
            }
        }
        scoreText.setText(Integer.toString(viewer.scorePoints()));
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
    private void toggleViewFullScreen(ActionEvent event) {
        Stage stage = (Stage) gameTextField.getScene().getWindow();
        fullScreenToggle = !fullScreenToggle;
        stage.setFullScreen(fullScreenToggle);
    }

    @FXML
    private void toggleViewDarkMode(ActionEvent event) {
        Scene scene = (Scene) gameTextField.getScene();
        darkModeToggle = !darkModeToggle;
        if (darkModeToggle) {
            scene.getStylesheets().add("styles.css");
        } else {
            scene.getStylesheets().remove("styles.css");
        }
    }

    @FXML
    public void closeProgram() {
        Platform.exit();
    }

    @FXML
    private void setNotepadText() {
        notepadTextArea.setText("Example FEN positions:\n\n" +
                "Opera Game Mate:\n" +
                "1n1Rkb1r/p4ppp/4q3/4p1B1/4P3/8/PPP2PPP/2K5\n\n" +
                "Back Rank Checkmate:\n" +
                "R5k1/5ppp/8/8/8/8/8/6K1\n\n" +
                "Fischer Immortal Checkmate:\n" +
                "1Q6/5pk1/2p3p1/1p2N2p/1b5P/1bn5/2r3P1/2K5");
    }

    @FXML
    private void initializeLogoImageView() {
        logoImageView.setImage(new Image("assets/logo.png"));
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
    public void aboutProgram() {
        AlertBox.display("About Chess Viewer", "Chess Viewer is a JavaFx program designed and created by tlee753. It is licensed under the MIT open source license for use, modification, and reproduction. Thank you for using Chess Viewer!");
    }

    @FXML
    public void instructions() {
        AlertBox.display("Chess Viewer Instructions", "Choose a PGN chess game file via clicking the \"Open\" button or input the beginning of an FEN string into the \"Enter Position Here\" box, then click \"Display Heatmap\" to portray the position(s) as each piece is attacked. The green squares represent squares controlled by white - the stronger the green the better the control, and like wise red squares are controlled by black. Yellow indicates a square under tension with equal and non-zero control by white and black. Grey or white squares are not controlled by either side. \n\nHint: you can use \"j\" and \"k\" to flip through game moves, \"r\" to restart a game, \"h\" to show the heatmap, and \"c\" to clear the heatmap.");
    }

    @FXML
    public void keyboardShortcuts() {
        AlertBox.display("Keyboard Shortcuts", "J: Next Move \nK: Previous Move \nH:Display Heat Map \nR: Restart Game \nC: Clear Heat Map \nW: Show White Heat Map \nB: Show Black Heat Map \nT: Show Combined Heat Map \nO: Open File");
    }

    @FXML
    void keyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case K:
            case DOWN:
            case KP_DOWN:
            case LEFT:
            case KP_LEFT:
                previousMove();
                break;
            case J:
            case UP:
            case KP_UP:
            case RIGHT:
            case KP_RIGHT:
                nextMove();
                break;
            case H:
                heatMap();
                break;
            case R:
                restartGame();
                break;
            case C:
                initializeBoard();
                break;
            case W:
                radioWhite.setSelected(true);
                heatMap();
                break;
            case B:
                radioBlack.setSelected(true);
                heatMap();
                break;
            case T:
                radioBoth.setSelected(true);
                heatMap();
                break;
            case F:
                Stage stage = (Stage) gameTextField.getScene().getWindow();
                fullScreenToggle = !fullScreenToggle;
                stage.setFullScreen(fullScreenToggle);
                break;
            case O:
                try {
                    openFile();
                } catch (Exception e) {

                }
                break;
            default:
                break;
        }
    }
}