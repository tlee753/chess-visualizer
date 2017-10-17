public class FENViewer {
    private String position;
    private char[][] positionArray;
    private int[][] pointArray;

    public FENViewer(String position) {
        // trimming, parsing, and correction
        this.position = position;
        positionConversion();
        pointConversion();
    }

    public String getPosition() {
        return position;
    }

    public char[][] getPositionArray() {
        return positionArray;
    }

    public int[][] getPointArray() {
        return pointArray;
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
                // } else if (position.charAt(i) == '/') {
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
            System.out.println("Current Position");
            System.out.println("╔════════════════════════════════════════════════════════╗");
            for (int i = 0; i < 8; i++) {
                System.out.print("║");
                for (int j = 0; j < 8; j++) {
                    if (j == 7) {
                        if (i == 7) {
                            System.out.print(positionArray[j][i] + "║\n");
                            break;
                        }
                        System.out.print(positionArray[j][i] + "║\n║\t\t\t\t\t\t\t ║\n");
                        break;
                    }
                    System.out.print(positionArray[j][i] + "\t");
                }
            }
            System.out.println("╚════════════════════════════════════════════════════════╝");
        }
    }

    public void pointConversion() {
        if (positionArray == null) {
            System.out.println("Point array cannot be created.");
        } else {
            pointArray = new int[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    pointArray[j][i] = 0;
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (positionArray[j][i]) {
                        case 'p':
                            if (j == 0) {
                                pointArray[j+1][i+1]--;
                            } else if (j == 7) {
                                pointArray[j-1][i+1]--;
                            } else {
                                pointArray[j+1][i+1]--;
                                pointArray[j-1][i+1]--;
                            }
                            break;
                        case 'r':
                            for (int k = i-1; k > -1; k--) {
                                if (positionArray[j][k] != '*') {
                                    pointArray[j][k]--;
                                    break;
                                }
                                pointArray[j][k]--;
                            }
                            for (int k = j-1; k > -1; k--) {
                                if (positionArray[k][i] != '*') {
                                    pointArray[k][i]--;
                                    break;
                                }
                                pointArray[k][i]--;
                            }
                            for (int k = i+1; k < 8; k++) {
                                if (positionArray[j][k] != '*') {
                                    pointArray[j][k]--;
                                    break;
                                }
                                pointArray[j][k]--;
                            }
                            for (int k = j+1; k < 8; k++) {
                                if (positionArray[k][i] != '*') {
                                    pointArray[k][i]--;
                                    break;
                                }
                                pointArray[k][i]--;
                            }
                            break;
                        case 'n':
                            if (i+2 < 8 && j-1 > -1) {
                                pointArray[j-1][i+2]--;
                            }
                            if (i+2 < 8 && j+1 < 8) {
                                pointArray[j+1][i+2]--;
                            }
                            if (i+1 < 8 && j+2 < 8) {
                                pointArray[j+2][i+1]--;
                            }
                            if (i-1 > -1 && j+2 < 8) {
                                pointArray[j+2][i-1]--;
                            }
                            if (i-2 > -1 && j+1 < 8) {
                                pointArray[j+1][i-2]--;
                            }
                            if (i-2 > -1 && j-1 > -1) {
                                pointArray[j-1][i-2]--;
                            }
                            if (i-1 > -1 && j-2 > -1) {
                                pointArray[j-2][i-1]--;
                            }
                            if (i+1 < 8 && j-2 > -1) {
                                pointArray[j-2][i+1]--;
                            }
                            break;
                        case 'b':
                            int w = i+1;
                            int x = j+1;
                            while (w < 8 && x < 8) {
                                if (positionArray[x][w] != '*') {
                                    pointArray[x][w]--;
                                    break;
                                }
                                pointArray[x][w]--;
                                w++;
                                x++;
                            }
                            w = i-1;
                            x = j+1;
                            while (w > -1 && x < 8) {
                                if (positionArray[x][w] != '*') {
                                    pointArray[x][w]--;
                                    break;
                                }
                                pointArray[x][w]--;
                                w--;
                                x++;
                            }
                            w = i-1;
                            x = j-1;
                            while (w > -1 && x > -1) {
                                if (positionArray[x][w] != '*') {
                                    pointArray[x][w]--;
                                    break;
                                }
                                pointArray[x][w]--;
                                w--;
                                x--;
                            }
                            w = i+1;
                            x = j-1;
                            while (w < 8 && x > -1) {
                                if (positionArray[x][w] != '*') {
                                    pointArray[x][w]--;
                                    break;
                                }
                                pointArray[x][w]--;
                                w++;
                                x--;
                            }
                            break;
                        case 'q':
                            for (int k = i-1; k > -1; k--) {
                                if (positionArray[j][k] != '*') {
                                    pointArray[j][k]--;
                                    break;
                                }
                                pointArray[j][k]--;
                            }
                            for (int k = j-1; k > -1; k--) {
                                if (positionArray[k][i] != '*') {
                                    pointArray[k][i]--;
                                    break;
                                }
                                pointArray[k][i]--;
                            }
                            for (int k = i+1; k < 8; k++) {
                                if (positionArray[j][k] != '*') {
                                    pointArray[j][k]--;
                                    break;
                                }
                                pointArray[j][k]--;
                            }
                            for (int k = j+1; k < 8; k++) {
                                if (positionArray[k][i] != '*') {
                                    pointArray[k][i]--;
                                    break;
                                }
                                pointArray[k][i]--;
                            }
                            int ww = i+1;
                            int xx = j+1;
                            while (ww < 8 && xx < 8) {
                                if (positionArray[xx][ww] != '*') {
                                    pointArray[xx][ww]--;
                                    break;
                                }
                                pointArray[xx][ww]--;
                                ww++;
                                xx++;
                            }
                            ww = i-1;
                            xx = j+1;
                            while (ww > -1 && xx < 8) {
                                if (positionArray[xx][ww] != '*') {
                                    pointArray[xx][ww]--;
                                    break;
                                }
                                pointArray[xx][ww]--;
                                ww--;
                                xx++;
                            }
                            ww = i-1;
                            xx = j-1;
                            while (ww > -1 && xx > -1) {
                                if (positionArray[xx][ww] != '*') {
                                    pointArray[xx][ww]--;
                                    break;
                                }
                                pointArray[xx][ww]--;
                                ww--;
                                xx--;
                            }
                            ww = i+1;
                            xx = j-1;
                            while (ww < 8 && xx > -1) {
                                if (positionArray[xx][ww] != '*') {
                                    pointArray[xx][ww]--;
                                    break;
                                }
                                pointArray[xx][ww]--;
                                ww++;
                                xx--;
                            }
                            break;
                        case 'k':
                            if (i-1 > -1) {
                                if (j-1 > -1 && j-1 < 8) {
                                    pointArray[j-1][i-1]--;
                                }
                                if (j > -1 && j < 8) {
                                    pointArray[j][i-1]--;
                                }
                                if (j+1 > -1 && j+1 < 8) {
                                    pointArray[j+1][i-1]--;
                                }
                            }
                            if (i > -1) {
                                if (j-1 > -1 && j-1 < 8) {
                                    pointArray[j-1][i]--;
                                }
                                if (j+1 > -1 && j+1 < 8) {
                                    pointArray[j+1][i]--;
                                }
                            }
                            if (i+1 < 8) {
                                if (j-1 > -1 && j-1 < 8) {
                                    pointArray[j-1][i+1]--;
                                }
                                if (j > -1 && j < 8) {
                                    pointArray[j][i+1]--;
                                }
                                if (j+1 > -1 && j+1 < 8) {
                                    pointArray[j+1][i+1]--;
                                }
                            }
                            break;
                        case 'P':
                            if (j == 0) {
                                pointArray[j+1][i-1]++;
                            } else if (j == 7) {
                                pointArray[j-1][i-1]++;
                            } else {
                                pointArray[j+1][i-1]++;
                                pointArray[j-1][i-1]++;
                            }
                            break;
                        case 'R':
                            for (int k = i-1; k > -1; k--) {
                                if (positionArray[j][k] != '*') {
                                    pointArray[j][k]++;
                                    break;
                                }
                                pointArray[j][k]++;
                            }
                            for (int k = j-1; k > -1; k--) {
                                if (positionArray[k][i] != '*') {
                                    pointArray[k][i]++;
                                    break;
                                }
                                pointArray[k][i]++;
                            }
                            for (int k = i+1; k < 8; k++) {
                                if (positionArray[j][k] != '*') {
                                    pointArray[j][k]++;
                                    break;
                                }
                                pointArray[j][k]++;
                            }
                            for (int k = j+1; k < 8; k++) {
                                if (positionArray[k][i] != '*') {
                                    pointArray[k][i]++;
                                    break;
                                }
                                pointArray[k][i]++;
                            }
                            break;
                        case 'N':
                            if (i+2 < 8 && j-1 > -1) {
                                pointArray[j-1][i+2]++;
                            }
                            if (i+2 < 8 && j+1 < 8) {
                                pointArray[j+1][i+2]++;
                            }
                            if (i+1 < 8 && j+2 < 8) {
                                pointArray[j+2][i+1]++;
                            }
                            if (i-1 > -1 && j+2 < 8) {
                                pointArray[j+2][i-1]++;
                            }
                            if (i-2 > -1 && j+1 < 8) {
                                pointArray[j+1][i-2]++;
                            }
                            if (i-2 > -1 && j-1 > -1) {
                                pointArray[j-1][i-2]++;
                            }
                            if (i-1 > -1 && j-2 > -1) {
                                pointArray[j-2][i-1]++;
                            }
                            if (i+1 < 8 && j-2 > -1) {
                                pointArray[j-2][i+1]++;
                            }
                            break;
                        case 'B':
                            int y = i+1;
                            int z = j+1;
                            while (y < 8 && z < 8) {
                                if (positionArray[z][y] != '*') {
                                    pointArray[z][y]++;
                                    break;
                                }
                                pointArray[z][y]++;
                                y++;
                                z++;
                            }
                            y = i-1;
                            z = j+1;
                            while (y > -1 && z < 8) {
                                if (positionArray[z][y] != '*') {
                                    pointArray[z][y]++;
                                    break;
                                }
                                pointArray[z][y]++;
                                y--;
                                z++;
                            }
                            y = i-1;
                            z = j-1;
                            while (y > -1 && z > -1) {
                                if (positionArray[z][y] != '*') {
                                    pointArray[z][y]++;
                                    break;
                                }
                                pointArray[z][y]++;
                                y--;
                                z--;
                            }
                            y = i+1;
                            z = j-1;
                            while (y < 8 && z > -1) {
                                if (positionArray[z][y] != '*') {
                                    pointArray[z][y]++;
                                    break;
                                }
                                pointArray[z][y]++;
                                y++;
                                z--;
                            }
                            break;
                        case 'Q':
                            for (int k = i-1; k > -1; k--) {
                                if (positionArray[j][k] != '*') {
                                    pointArray[j][k]++;
                                    break;
                                }
                                pointArray[j][k]++;
                            }
                            for (int k = j-1; k > -1; k--) {
                                if (positionArray[k][i] != '*') {
                                    pointArray[k][i]++;
                                    break;
                                }
                                pointArray[k][i]++;
                            }
                            for (int k = i+1; k < 8; k++) {
                                if (positionArray[j][k] != '*') {
                                    pointArray[j][k]++;
                                    break;
                                }
                                pointArray[j][k]++;
                            }
                            for (int k = j+1; k < 8; k++) {
                                if (positionArray[k][i] != '*') {
                                    pointArray[k][i]++;
                                    break;
                                }
                                pointArray[k][i]++;
                            }
                            int yy = i+1;
                            int zz = j+1;
                            while (yy < 8 && zz < 8) {
                                if (positionArray[zz][yy] != '*') {
                                    pointArray[zz][yy]++;
                                    break;
                                }
                                pointArray[zz][yy]++;
                                yy++;
                                zz++;
                            }
                            yy = i-1;
                            zz = j+1;
                            while (yy > -1 && zz < 8) {
                                if (positionArray[zz][yy] != '*') {
                                    pointArray[zz][yy]++;
                                    break;
                                }
                                pointArray[zz][yy]++;
                                yy--;
                                zz++;
                            }
                            yy = i-1;
                            zz = j-1;
                            while (yy > -1 && zz > -1) {
                                if (positionArray[zz][yy] != '*') {
                                    pointArray[zz][yy]++;
                                    break;
                                }
                                pointArray[zz][yy]++;
                                yy--;
                                zz--;
                            }
                            yy = i+1;
                            zz = j-1;
                            while (yy < 8 && zz > -1) {
                                if (positionArray[zz][yy] != '*') {
                                    pointArray[zz][yy]++;
                                    break;
                                }
                                pointArray[zz][yy]++;
                                yy++;
                                zz--;
                            }
                            break;
                        case 'K':
                            if (i-1 > -1) {
                                if (j-1 > -1 && j-1 < 8) {
                                    pointArray[j-1][i-1]++;
                                }
                                if (j > -1 && j < 8) {
                                    pointArray[j][i-1]++;
                                }
                                if (j+1 > -1 && j+1 < 8) {
                                    pointArray[j+1][i-1]++;
                                }
                            }
                            if (i > -1) {
                                if (j-1 > -1 && j-1 < 8) {
                                    pointArray[j-1][i]++;
                                }
                                if (j+1 > -1 && j+1 < 8) {
                                    pointArray[j+1][i]++;
                                }
                            }
                            if (i+1 < 8) {
                                if (j-1 > -1 && j-1 < 8) {
                                    pointArray[j-1][i+1]++;
                                }
                                if (j > -1 && j < 8) {
                                    pointArray[j][i+1]++;
                                }
                                if (j+1 > -1 && j+1 < 8) {
                                    pointArray[j+1][i+1]++;
                                }
                            }
                            break;
                        default:
                            // default for nulls (debug)
                            break;
                    }
                }
            }
        }
    }

    public void printPoints() {
        if (pointArray == null) {
            System.out.println("Points not calculated.");
        } else {
            System.out.println("Point Visualization");
            System.out.println("╔════════════════════════════════════════════════════════╗");
            for (int i = 0; i < 8; i++) {
                System.out.print("║");
                for (int j = 0; j < 8; j++) {
                    if (j == 7) {
                        if (i == 7) {
                            System.out.print(pointArray[j][i] + "║\n");
                            break;
                        }
                        System.out.print(pointArray[j][i] + "║\n║\t\t\t\t\t\t\t ║\n");
                        break;
                    }
                    System.out.print(pointArray[j][i] + "\t");
                }
            }
            System.out.println("╚════════════════════════════════════════════════════════╝");
        }
    }

}
