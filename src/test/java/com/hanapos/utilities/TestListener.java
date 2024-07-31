package com.hanapos.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.hanapos.seleniumProjectBase.TestBaseClass;

public class TestListener implements ITestListener{

	@Override
    public void onStart(ITestContext context) {
        // Do nothing
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().log(Status.PASS, result.getName() + " got successfully executed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getTest().log(Status.FAIL, result.getName() + " got failed");
        ExtentManager.getTest().log(Status.INFO, result.getThrowable().getMessage());
    
        String imgPath = new TestBaseClass().captureScreen(result.getName());
		//test.addScreenCaptureFromPath(imgPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().log(Status.SKIP, result.getName() + " got skipped");
        ExtentManager.getTest().log(Status.INFO, result.getThrowable().getMessage());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Do nothing
    }
	
}
