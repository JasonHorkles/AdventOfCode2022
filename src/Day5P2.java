import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Day5P2 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Day5.txt");
        Scanner scanner = new Scanner(f);

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        Stack<Character> stack3 = new Stack<>();
        Stack<Character> stack4 = new Stack<>();
        Stack<Character> stack5 = new Stack<>();
        Stack<Character> stack6 = new Stack<>();
        Stack<Character> stack7 = new Stack<>();
        Stack<Character> stack8 = new Stack<>();
        Stack<Character> stack9 = new Stack<>();

        stack1.push('F');
        stack1.push('H');
        stack1.push('B');
        stack1.push('V');
        stack1.push('R');
        stack1.push('Q');
        stack1.push('D');
        stack1.push('P');

        stack2.push('L');
        stack2.push('D');
        stack2.push('Z');
        stack2.push('Q');
        stack2.push('W');
        stack2.push('V');

        stack3.push('H');
        stack3.push('L');
        stack3.push('Z');
        stack3.push('Q');
        stack3.push('G');
        stack3.push('R');
        stack3.push('P');
        stack3.push('C');

        stack4.push('R');
        stack4.push('D');
        stack4.push('H');
        stack4.push('F');
        stack4.push('J');
        stack4.push('V');
        stack4.push('B');

        stack5.push('Z');
        stack5.push('W');
        stack5.push('L');
        stack5.push('C');

        stack6.push('J');
        stack6.push('R');
        stack6.push('P');
        stack6.push('N');
        stack6.push('T');
        stack6.push('G');
        stack6.push('V');
        stack6.push('M');

        stack7.push('J');
        stack7.push('R');
        stack7.push('L');
        stack7.push('V');
        stack7.push('M');
        stack7.push('B');
        stack7.push('S');

        stack8.push('D');
        stack8.push('P');
        stack8.push('J');

        stack9.push('D');
        stack9.push('C');
        stack9.push('N');
        stack9.push('W');
        stack9.push('V');

        ArrayList<Stack<Character>> stacks = new ArrayList<>();
        stacks.add(stack1);
        stacks.add(stack2);
        stacks.add(stack3);
        stacks.add(stack4);
        stacks.add(stack5);
        stacks.add(stack6);
        stacks.add(stack7);
        stacks.add(stack8);
        stacks.add(stack9);

        while (scanner.hasNextLine()) {
            int moves = scanner.nextInt();
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            ArrayList<Character> movedCrates = new ArrayList<>();
            for (int x = 0; x < moves; x++) movedCrates.add(stacks.get(from - 1).pop());
            Collections.reverse(movedCrates);

            for (Character c : movedCrates) stacks.get(to - 1).push(c);
        }

        for (Stack<Character> stack : stacks) System.out.print(stack.get(stack.size() - 1));
    }
}
