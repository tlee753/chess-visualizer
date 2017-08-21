public class FENViewer {
    private String position;

    public FENViewer(String position) {
        // trimming, parsing, and correction
        this.position = position;
    }

    public void printPosition() {
        if (position == null) {
            System.out.println("No position provided.");
        } else {

        }
    }
}