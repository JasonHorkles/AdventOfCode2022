import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4P2 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Day4.txt");
        Scanner scanner = new Scanner(f);

        int partiallyContained = 0;
        while (scanner.hasNextLine()) {
            int starting1 = scanner.nextInt();
            int ending1 = scanner.nextInt();
            int starting2 = scanner.nextInt();
            int ending2 = scanner.nextInt();

            ArrayList<Integer> group1Numbers = new ArrayList<>();
            for (int x = starting1; x <= ending1; x++) group1Numbers.add(x);

            ArrayList<Integer> group2Numbers = new ArrayList<>();
            for (int x = starting2; x <= ending2; x++) group2Numbers.add(x);

            boolean shouldIBreak = false;
            for (int x : group1Numbers) {
                if (shouldIBreak) break;
                for (int y : group2Numbers)
                    if (x == y) {
                        partiallyContained++;
                        shouldIBreak = true;
                        break;
                    }
            }
        }

        System.out.println(partiallyContained);
    }
}
