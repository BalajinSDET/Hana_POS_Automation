package com.hanapos.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.Markup;
import com.hanapos.seleniumProjectBase.TestBaseClass;

import io.qameta.allure.Allure;

public class CustomSoftAssert extends SoftAssert {
	TestBaseClass base = new TestBaseClass();
	@Override
	public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
		// Capture screenshot immediately on soft assert failure
		String screenshotPath = TestBaseClass.captureScreenshotBase64();
		ExtentReportManager.getTest().fail("Assertion failed: " + assertCommand.getMessage())
         .addScreenCaptureFromBase64String(screenshotPath, "Test Step failed");
		 
		 byte[] screenshot = ((TakesScreenshot) TestBaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
	     Allure.getLifecycle().addAttachment("Screenshot on Failure", "image/png", "png", screenshot);		 
	}		        
}

