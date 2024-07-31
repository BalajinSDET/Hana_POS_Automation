package com.hanapos.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
    private static Map<Long, ExtentTest> extentTestMap = new HashMap<>();

    public synchronized static ExtentReports getExtentReports() {
        if (extent == null) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String repName = "Hana-Test-AutomationReport-" + timeStamp + ".html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./reports/" + repName);

            sparkReporter.config().setDocumentTitle("Hana POS Automation");
            sparkReporter.config().setReportName("Hana POS Automation Test Report");
            sparkReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Application", "Hana POS");
            extent.setSystemInfo("Tester Name", System.getProperty("user.name"));
            extent.setSystemInfo("Environment", "QA");
            
            
        }
        return extent;
    }

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().getId());
    }

    public static synchronized void endTest() {
        extent.flush();
    }

    public static synchronized ExtentTest startTest(String testName) {
        ExtentTest test = getExtentReports().createTest(testName);
        extentTestMap.put(Thread.currentThread().getId(), test);
        return test;
    }
}
