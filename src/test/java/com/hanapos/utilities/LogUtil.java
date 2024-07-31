package com.hanapos.utilities;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.WebDriver;

public class LogUtil {

    public static void saveBrowserLogs(WebDriver driver, String filePath) {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> consoleLogs = logEntries.getAll();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (LogEntry consoleLog : consoleLogs) {
                writer.write(consoleLog.getMessage());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
