import chesspresso.pgn.PGNReader;
import chesspresso.pgn.PGNSyntaxError;
import chesspresso.game.Game;
import chesspresso.position.Position;
import java.io.*;

public class Main {
	public static void main(String[] args) throws PGNSyntaxError, IOException {
		System.out.println("Program starting...");

        InputStream inputStream = new FileInputStream("GrandpaVsTyler-4.pgn");
        PGNReader pgnReader = new PGNReader(inputStream, "GrandpaVsTyler-4.pgn");

        Game game = pgnReader.parseGame();

        Position position = game.getPosition();

        System.out.println(position);
	}
}