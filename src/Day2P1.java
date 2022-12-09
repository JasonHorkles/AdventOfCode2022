import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2P1 {
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

            // X = Rock
            // Y = Paper
            // Z = Scissors

            switch (me) {
                case "X" -> roundPoints += 1;
                case "Y" -> roundPoints += 2;
                case "Z" -> roundPoints += 3;
            }

            // Draw
            if ((opponent.equals("A") && me.equals("X")) || (opponent.equals("B") && me.equals(
                "Y")) || (opponent.equals("C") && me.equals("Z"))) roundPoints += 3;

            else if ((me.equals("X") && opponent.equals("C")) || (me.equals("Z") && opponent.equals("B")) || (me.equals(
                "Y") && opponent.equals("A"))) roundPoints += 6;

            totalScore += roundPoints;
        }

        System.out.println(totalScore);
    }
}
