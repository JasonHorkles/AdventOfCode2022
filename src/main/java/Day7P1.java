import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class Day7P1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File f = new File("Day7.txt");
        Scanner scanner = new Scanner(f);

        Path originalPath = Path.of("C:/Users/jason/OneDrive/Documents/Intellij Projects/AdventOfCode2022/Day7Files");

        System.out.println("Create files? y/N");
        Scanner in = new Scanner(System.in);
        if (in.next().equalsIgnoreCase("y")) {
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
        }
        System.out.println("Calculating directory sizes...");

        AtomicLong totalSize = new AtomicLong();
        //noinspection resource
        Files.walk(originalPath).forEach(path -> {
            if (path.toFile().isDirectory()) {
                long size = FileUtils.sizeOfDirectory(path.toFile());
                if (size <= 100000) totalSize.addAndGet(size);
            }
        });

        System.out.println("Done! Total size: " + totalSize.get());
    }
}
