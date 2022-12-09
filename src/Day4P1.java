import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4P1 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Day4.txt");
        Scanner scanner = new Scanner(f);

        int fullyContained = 0;
        while (scanner.hasNextLine()) {
            int starting1 = scanner.nextInt();
            int ending1 = scanner.nextInt();
            int starting2 = scanner.nextInt();
            int ending2 = scanner.nextInt();

            if ((starting1 >= starting2 && ending1 <= ending2) || (starting2 >= starting1 && ending2 <= ending1))
                fullyContained++;
        }

        System.out.println(fullyContained);
    }
}
