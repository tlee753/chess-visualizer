public class Main {
    public static void main(String[] args) {
        FENViewer fenViewer = new FENViewer(args[0]);
        fenViewer.printPosition();
        fenViewer.printPoints();
    }
}
