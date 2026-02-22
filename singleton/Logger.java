package singleton;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Logger {

    private static volatile Logger instance;
    private static final Object lock = new Object();

    private LogLevel currentLevel = LogLevel.INFO;
    private String logFilePath = "app.log";

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public synchronized void log(String message, LogLevel level) {
        if (level.ordinal() >= currentLevel.ordinal()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath, true))) {
                String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                writer.write(time + " [" + level + "] " + message);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLogLevel(LogLevel level) {
        this.currentLevel = level;
    }

    public void loadConfig(String configPath) {
        try (FileReader reader = new FileReader(configPath)) {
            Properties props = new Properties();
            props.load(reader);

            this.logFilePath = props.getProperty("logFilePath", "app.log");
            this.currentLevel = LogLevel.valueOf(props.getProperty("logLevel", "INFO"));

        } catch (Exception e) {
            System.out.println("Config load error: " + e.getMessage());
        }
    }
}
