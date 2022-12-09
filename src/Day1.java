import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Day1.txt");
        Scanner fileScanner = new Scanner(f);

        ArrayList<Integer> elfInventories = new ArrayList<>();

        int totalCalories = 0;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if (line.equals("")) {
                elfInventories.add(totalCalories);
                totalCalories = 0;
                continue;
            }

            totalCalories += Integer.parseInt(line);
        }

        Collections.sort(elfInventories);
        Collections.reverse(elfInventories);

        System.out.println(elfInventories.get(0) + elfInventories.get(1) + elfInventories.get(2));
    }
}
