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
            for (int i = 0; i < position.length(); i++) {
                if (Character.isDigit(position.charAt(i))) {
                    for (int j = 0; j < position.charAt(i); j++) {
                        positionArray[boardPosition % 8][boardPosition / 8] = '*';
                        boardPosition++;
                    }
                } else if (position.charAt(i) == '/') {
                    // System.out.println(boardPosition);
                } else {
                    positionArray[boardPosition % 8][boardPosition / 8] = position.charAt(i);
                    boardPosition++;
                }
            }
        }
        System.out.println(positionArray);
    }

}
