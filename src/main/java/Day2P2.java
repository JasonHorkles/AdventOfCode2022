import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2P2 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Day2.txt");
        Scanner fileScanner = new Scanner(f);

        int totalScore = 0;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String opponent = String.valueOf(line.charAt(0));
            String me = String.valueOf(line.charAt(2));
            int roundPoints = 0;

            // A = Rock
            // B = Paper
            // C = Scissors

            // X = Lose
            // Y = Draw
            // Z = Win

            RPS iChose = null;
            switch (me) {
                case "X" -> {
                    switch (opponent) {
                        case "A" -> iChose = RPS.SCISSORS;
                        case "B" -> iChose = RPS.ROCK;
                        case "C" -> iChose = RPS.PAPER;
                    }
                }

                case "Y" -> {
                    switch (opponent) {
                        case "A" -> iChose = RPS.ROCK;
                        case "B" -> iChose = RPS.PAPER;
                        case "C" -> iChose = RPS.SCISSORS;
                    }
                    roundPoints += 3;
                }

                case "Z" -> {
                    switch (opponent) {
                        case "A" -> iChose = RPS.PAPER;
                        case "B" -> iChose = RPS.SCISSORS;
                        case "C" -> iChose = RPS.ROCK;
                    }
                    roundPoints += 6;
                }
            }

            //noinspection DataFlowIssue
            switch (iChose) {
                case ROCK -> roundPoints += 1;
                case PAPER -> roundPoints += 2;
                case SCISSORS -> roundPoints += 3;
            }

            totalScore += roundPoints;
        }

        System.out.println(totalScore);
    }

    public enum RPS {
        ROCK, PAPER, SCISSORS
    }
}
