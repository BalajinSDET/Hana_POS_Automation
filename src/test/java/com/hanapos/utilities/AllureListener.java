package com.hanapos.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hanapos.seleniumProjectBase.TestBaseClass;
import java.io.ByteArrayInputStream;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class AllureListener extends TestBaseClass implements ITestListener {	
	private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
	  
		@Attachment(value = "Screenshot", type = "image/png")
	    public byte[] saveScreenshotPNG(WebDriver driver) {
	        return ((TakesScreenshot) TestBaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	         Object testClass = result.getInstance();
	         WebDriver driver = ((TestBaseClass) testClass).getDriver();
	         if (driver != null) {
	             Allure.addAttachment("Screenshot", new ByteArrayInputStream(saveScreenshotPNG(driver)));
	         }
	         Allure.step("Test failed: " + getTestMethodName(result));
	         Allure.step("Error message: " + result.getThrowable().getMessage());	    
	    }


	}

