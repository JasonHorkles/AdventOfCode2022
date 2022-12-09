import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Day7P1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File f = new File("Day7.txt");
        Scanner scanner = new Scanner(f);

        Path originalPath = Path.of("C:/Users/jason/OneDrive/Documents/Intellij Projects/AdventOfCode2022/Day7Files");
        Path lastDir = originalPath;

        int directoryNumber = 0;
        while (scanner.hasNextLine()) {
            String next = scanner.nextLine();

            // Change directory
            if (next.startsWith("$ cd")) {
                next = next.replaceFirst("\\$ cd ", "");

                if (next.equals("..")) lastDir = lastDir.getParent();

                    // New directory
                else if (!next.equals("/")) {
                    String newFilePath = lastDir + "\\" + directoryNumber;
                    lastDir = Files.createDirectories(Paths.get(newFilePath));
                    directoryNumber++;
                }

                // New file
            } else if (!next.startsWith("$ ls") && !next.startsWith("dir ")) {
                Scanner newFileInfo = new Scanner(next);
                int size = newFileInfo.nextInt();
                String name = newFileInfo.next();

                File newFile = new File(lastDir.toString() + "\\" + name + ".txt");
                if (!newFile.exists()) {
                    //noinspection ResultOfMethodCallIgnored
                    newFile.createNewFile();
                    FileWriter newFileText = new FileWriter(newFile, false);
                    newFileText.append("a".repeat(Math.max(0, size)));
                    newFileText.close();
                }
            }
        }

        System.out.println("Files created!");
        Thread.sleep(500);
        System.out.println("Calculating directory sizes...");

        Path lastCalculatedDir = originalPath;
        File root = new File(originalPath.toString());

        // Calculate top-level directory sizes from files first
        //noinspection resource
        Files.walk(originalPath).forEach(path -> {
            if (path.toFile().isDirectory()) {
                path.toFile().renameTo(path.toFile().getParentFile() + "")
            } else {

            }
        });

        // Calculate all the other directory sizes next
        // While there's still a calculate folder, keep running this
        while (true) {
            boolean stillNeedsCalculated = false;
            //noinspection DataFlowIssue
            for (File folders : root.listFiles(File::isDirectory))
                if (folders.getName().startsWith("CALCULATE")) {
                    stillNeedsCalculated = true;
                    break;
                }
            if (!stillNeedsCalculated) break;

            //noinspection resource
            Files.walk(originalPath).forEach(path -> {
                if (path.toFile().isDirectory()) {

                } else {

                }
            });
        }

        System.out.println("Directories updated!");
        Thread.sleep(500);
        System.out.println("Tabulating...");

        AtomicInteger totalSize = new AtomicInteger();
        //noinspection resource
        Files.walk(originalPath).forEach(path -> {
            if (path.toFile().isDirectory()) {
                int size = Integer.parseInt(path.getFileName().toString());
                if (size <= 100000) totalSize.addAndGet(size);
            }
        });

        System.out.println("Done! Total size: " + totalSize.get());
    }
}
