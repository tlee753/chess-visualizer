public class FENViewer {
    private String position;
    private char[][] positionArray;

    public FENViewer(String position) {
        // trimming, parsing, and correction
        this.position = position;
        positionConversion();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void positionConversion() {
        if (position == null) {
            System.out.println("No position provided.");
        } else {
            positionArray = new char[8][8];
            int boardPosition = 0;
            for (int i = 0; i < position.length(); i++) {
                if (Character.isDigit(position.charAt(i))) {
                    for (int j = 0; j < Character.getNumericValue(position.charAt(i)); j++) {
                        positionArray[boardPosition % 8][boardPosition / 8] = '*';
                        // System.out.println("hit");
                        boardPosition++;
                    }
                } else if (position.charAt(i) == '/') {
                    // System.out.println(boardPosition);
                    // System.out.println(positionArray);
                } else {
                    positionArray[boardPosition % 8][boardPosition / 8] = position.charAt(i);
                    boardPosition++;
                }
            }
        }
    }

    public void printPosition() {
        if (positionArray == null) {
            System.out.println("Position not provided.");
        } else {
            System.out.println("╔═══════════════╗");
            for (int i = 0; i < 8; i++) {
                System.out.print("║");
                for (int j = 0; j < 8; j++) {
                    if (j == 7) {
                        System.out.println(positionArray[j][i] + "║");
                        break;
                    }
                    System.out.print(positionArray[j][i] + " ");
                }
            }
            System.out.println("╚═══════════════╝");
        }
    }

}
