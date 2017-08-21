import java.lang.reflect.Array;
import java.util.ArrayList;

public class FENViewer {
    private String position;
    private ArrayList<ArrayList<char>> positionArray;

    public FENViewer(String position) {
        // trimming, parsing, and correction
        this.position = position;
    }

    public void printPosition() {
        if (position == null) {
            System.out.println("No position provided.");
        } else {
            int boardPosition = 0;
            for (int i = 0; i < position.length; i++) {
                if (position[i].isDigit()) {
                    for (int j = 0; j < position[i]; j++) {
                        // insert null space on board
                    }
                } else if (position[i] == "/") {
                    // error checking
                } else {
                    positionArray[i % 8][i / 8] = position[i];
                }
            }
        }
        System.out.println(positionArray);
    }

}