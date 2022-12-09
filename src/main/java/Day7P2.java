import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicLong;

public class Day7P2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Use Part 1 to create files
        Path originalPath = Path.of("C:/Users/jason/OneDrive/Documents/Intellij Projects/AdventOfCode2022/Day7Files");

        long totalSpace = 70000000;
        long usedSpace = FileUtils.sizeOfDirectory(originalPath.toFile());

        long freeSpace = totalSpace - usedSpace;
        long neededSpace = 30000000 - freeSpace;

        System.out.println("Remaining needed space: " + neededSpace);
        System.out.println("Tabulating...");

        AtomicLong smallestFolderBytes = new AtomicLong(Long.MAX_VALUE);

        //noinspection resource
        Files.walk(originalPath).forEach(path -> {
            if (path.toFile().isDirectory()) {
                long size = FileUtils.sizeOfDirectory(path.toFile());
                if (size >= neededSpace && size < smallestFolderBytes.get())
                    smallestFolderBytes.set(FileUtils.sizeOfDirectory(path.toFile()));
            }
        });

        System.out.println("Done! Smallest available directory size: " + smallestFolderBytes.get());
    }
}
