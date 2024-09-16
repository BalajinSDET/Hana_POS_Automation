package com.hanapos.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;


import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*public abstract class Reporter {
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public ExtentTest test, node;
	public String testCaseName, testDescription, nodes, authors,category;
	public String excelFileName;
	
	@BeforeSuite
	public void startReport() {
		//Creating an object for ExtentHtmlReporter to create a html file
		reporter = new ExtentHtmlReporter("./reports/result.html");
		//If you want to maintain the history of execution
		reporter.setAppendExisting(true);
		//Creating an object for ExtentHtmlReporter class to create a new report
		extent = new ExtentReports();
		// Bridge the HTML file and report
		extent.attachReporter(reporter);
	}
	
    @BeforeClass
	public void report() throws IOException {
    	// Creating a new Test inside the report for each test case
		test = extent.createTest(testCaseName, testDescription);
		test.assignAuthor(authors);
		test.assignCategory(category);  
	}
    public abstract long takeSnap();
    public void reportStep(String dec, String status, boolean bSnap ) {
    	MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){

			long snapNumber = 100000L;
			snapNumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../reports/images/"+snapNumber+".jpg").build();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
    	if(status.equalsIgnoreCase("pass")) {
    		node.pass(dec, img);
    	} else if(status.equalsIgnoreCase("fail")) {
    		node.fail(dec, img); 
    	}
    }
    
    public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

    @AfterSuite
    public void stopReport() {
    	extent.flush();
    }
}
*/



  public class ExtentManager { private static ExtentReports extent;
  private static Map<Long, ExtentTest> extentTestMap = new HashMap<>();
  
  public synchronized static ExtentReports getExtentReports() { if (extent ==
  null) { String timeStamp = new
  SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); String repName =
  "Hana-Test-AutomationReport-" + timeStamp + ".html"; ExtentSparkReporter
  sparkReporter = new ExtentSparkReporter("./reports/" + repName);
  
  sparkReporter.config().setDocumentTitle("Hana POS Automation");
  sparkReporter.config().setReportName("Hana POS Automation Test Report");
  sparkReporter.config().setTheme(Theme.DARK);
  
  extent = new ExtentReports(); extent.attachReporter(sparkReporter);
  extent.setSystemInfo("Application", "Hana POS");
  extent.setSystemInfo("Tester Name", System.getProperty("user.name"));
  extent.setSystemInfo("Environment", "QA");
  
  
  } return extent; }
  
  public static synchronized ExtentTest getTest() { return
  extentTestMap.get(Thread.currentThread().getId()); }
  
  public static synchronized void endTest() { extent.flush(); }
  
  public static synchronized ExtentTest startTest(String testName) { ExtentTest
  test = getExtentReports().createTest(testName);
  extentTestMap.put(Thread.currentThread().getId(), test); return test; } }
 