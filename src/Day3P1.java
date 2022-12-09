import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Day3P1 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Day3.txt");
        Scanner fileScanner = new Scanner(f);

        int totalScore = 0;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String compartment1 = line.substring(0, line.length() / 2);
            String compartment2 = line.substring((line.length() / 2));

            HashSet<Character> duplicateCharacters = new HashSet<>();
            for (Character c1 : compartment1.toCharArray())
                for (Character c2 : compartment2.toCharArray())
                    if (c1 == c2) duplicateCharacters.add(c1);

            if (!duplicateCharacters.isEmpty()) for (Character c : duplicateCharacters)
                switch (c) {
                    case 'a' -> totalScore += 1;
                    case 'b' -> totalScore += 2;
                    case 'c' -> totalScore += 3;
                    case 'd' -> totalScore += 4;
                    case 'e' -> totalScore += 5;
                    case 'f' -> totalScore += 6;
                    case 'g' -> totalScore += 7;
                    case 'h' -> totalScore += 8;
                    case 'i' -> totalScore += 9;
                    case 'j' -> totalScore += 10;
                    case 'k' -> totalScore += 11;
                    case 'l' -> totalScore += 12;
                    case 'm' -> totalScore += 13;
                    case 'n' -> totalScore += 14;
                    case 'o' -> totalScore += 15;
                    case 'p' -> totalScore += 16;
                    case 'q' -> totalScore += 17;
                    case 'r' -> totalScore += 18;
                    case 's' -> totalScore += 19;
                    case 't' -> totalScore += 20;
                    case 'u' -> totalScore += 21;
                    case 'v' -> totalScore += 22;
                    case 'w' -> totalScore += 23;
                    case 'x' -> totalScore += 24;
                    case 'y' -> totalScore += 25;
                    case 'z' -> totalScore += 26;
                    case 'A' -> totalScore += 27;
                    case 'B' -> totalScore += 28;
                    case 'C' -> totalScore += 29;
                    case 'D' -> totalScore += 30;
                    case 'E' -> totalScore += 31;
                    case 'F' -> totalScore += 32;
                    case 'G' -> totalScore += 33;
                    case 'H' -> totalScore += 34;
                    case 'I' -> totalScore += 35;
                    case 'J' -> totalScore += 36;
                    case 'K' -> totalScore += 37;
                    case 'L' -> totalScore += 38;
                    case 'M' -> totalScore += 39;
                    case 'N' -> totalScore += 40;
                    case 'O' -> totalScore += 41;
                    case 'P' -> totalScore += 42;
                    case 'Q' -> totalScore += 43;
                    case 'R' -> totalScore += 44;
                    case 'S' -> totalScore += 45;
                    case 'T' -> totalScore += 46;
                    case 'U' -> totalScore += 47;
                    case 'V' -> totalScore += 48;
                    case 'W' -> totalScore += 49;
                    case 'X' -> totalScore += 50;
                    case 'Y' -> totalScore += 51;
                    case 'Z' -> totalScore += 52;
                }
        }
        System.out.println(totalScore);
    }
}
