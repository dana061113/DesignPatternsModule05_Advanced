package singleton;

import java.io.*;

public class LogReader {

    public void readLogs(String filePath, LogLevel levelFilter) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("[" + levelFilter + "]")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }
    }
}
