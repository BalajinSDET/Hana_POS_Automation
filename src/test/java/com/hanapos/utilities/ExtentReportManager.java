package com.hanapos.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

//For email
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hanapos.seleniumProjectBase.TestBaseClass;


public class ExtentReportManager extends TestBaseClass implements ITestListener {
	private static ExtentSparkReporter sparkReporter;
	private static ExtentReports extent;
	private static String repName;
	private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	private String timeStamp;
	
	
	public void onStart(ITestContext testContext) {
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Hana-Test-AutomationReport-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
		sparkReporter = new ExtentSparkReporter(".\\reports\\extentreport\\Hanapos_AutomationReport.html");
		sparkReporter.config().setDocumentTitle("Hana POS Automation"); 
		sparkReporter.config().setReportName("Hana POS Automation Test Report"); 
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Hana - POS");
		extent.setSystemInfo("Tester Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");

		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);

		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);

		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
	}

	 public void onTestStart(ITestResult result) {
	        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
	        extentTest.set(test);
	    }
	
	public void onTestSuccess(ITestResult result) {
			ExtentTest test = extentTest.get();
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.PASS, result.getName() + " got successfully executed");
	}

	public void onTestFailure(ITestResult result)  {
			ExtentTest test = extentTest.get();
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.FAIL, result.getName() + " got failed");
	        test.log(Status.INFO, result.getThrowable().getMessage());

	        String logFilePath = System.getProperty("user.dir") + "\\logs\\" + result.getName() + "_" + timeStamp + "-console.log";
	        LogUtil.saveBrowserLogs(getDriver(), logFilePath);

	        try {
				String imgPath = new TestBaseClass().captureScreen(result.getName());
				test.addScreenCaptureFromPath(imgPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void onTestSkipped(ITestResult result) {
			ExtentTest test = extentTest.get();
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP, result.getName() + " got skipped");
			test.log(Status.INFO, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext) {
			extent.flush();
			
			
			 //To open report on desktop..
			String pathOfExtentReport =	 System.getProperty("user.dir") + "\\reports\\" + repName;
			File extentReport = new File(pathOfExtentReport);
			 
			 try {
				 Desktop.getDesktop().browse(extentReport.toURI()); 
			 } catch (IOException e) {
				 e.printStackTrace(); 
				 }
			 
	}


	//User defined method for sending email..
//	private final static String host = "imap.gmail.com"; 
//	private final static String username = "hanaposqateam@gmail.com"; // password is app password created
//	private final static String password = "bcfburrmktksjckr";
	
	public void sendEmail(String senderEmail, String senderPassword, String recipientEmail) {
	    Properties properties = new Properties();
	    properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.starttls.enable", "true");
	    properties.put("mail.smtp.host", "smtp.gmail.com");
	    properties.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(properties, new Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(senderEmail, senderPassword);
	        }
	    });

	    try {
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(senderEmail));
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
	        message.setSubject("Test Report with attachment");

	        Multipart multipart = new MimeMultipart();
	        String filePath = ".\\reports\\" + repName;
	        String fileName = repName;
	        MimeBodyPart attachmentPart = new MimeBodyPart();
	        attachmentPart.attachFile(filePath);
	        attachmentPart.setFileName(fileName);

	        MimeBodyPart textPart = new MimeBodyPart();
	        textPart.setText("Please find the attached file.");

	        multipart.addBodyPart(textPart);
	        multipart.addBodyPart(attachmentPart);

	        message.setContent(multipart);

	        Transport.send(message);

	        System.out.println("Email sent successfully!");
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Failed to send email: " + e.getMessage());
	    }
	}	
}
