package com.hanapos.LoginPage_Testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.CustomSoftAssert;
import com.hanapos.utilities.DataLibrary;

public class Hana_T1_LoginPage_FT extends TestBaseClass{
	
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	public static final String dataSheetName = "TC_001_LoginPageTest";
	
	// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
	CustomSoftAssert softassert = new CustomSoftAssert();
	
	@DataProvider(name = "fetch_Excel_Data") 
	public Object[][] fetchData() throws IOException { 
		return DataLibrary.readExcelData(dataSheetName); 
	}

	@Test(priority = 1,groups= {"Smoke","Regression"},dataProvider="fetch_Excel_Data") 
	public void VerifyLoginTest(String username, String password, String exp_res) {
		
		logger.info("**** Starting TC_001_LoginTest  ****");
		logger.debug("capturing application debug logs....");
		lp = new LoginPage();
		
		logger.info("Entering valid username and password..");
		lp.EnterUserName(username);
		lp.EnterPassword(password);
		lp.ClickLoginButton();
		logger.info("Clicked on Login button..");
		
		dashboard = new HanaDashBoardPage();
		if(exp_res.equalsIgnoreCase("Valid"))
		{
			if(dashboard.VerifyHanaDashBoardPage()==true)
			{
				Assert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
				Assert.assertEquals(dashboard.VerifyPageTitleonDashboard(), "Hana | Dashboard v.3");
				logger.info("User navigated to hana dashboard page sucess..");
				logger.info("**** Finished TC_001_LoginPageTest  ****");				
			}
			else
			{
				Assert.fail();
			}
		}

		if(exp_res.equalsIgnoreCase("Invalid"))
		{
			if(lp.IncorrectErrorMsgIsDisplayed()==true)
			{
				Assert.assertTrue(true);
			}
			else if (lp.IsValidationMessageExist()==true) {
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
			}
		}
	}
	

	@Test(priority = 2,groups= {"Regression"},enabled=false)
	public void ValidateLoginPageTitle() {
		lp = new LoginPage();
		Assert.assertEquals(lp.VerifyLoginPageTitle(), "HANA POS | Login");
	}

	@Test(priority = 3,groups= {"Regression"},enabled=false)
	public void VerifyLoginPage() {
		lp = new LoginPage();
		Assert.assertEquals(lp.ValidateLoginPage(), "Welcome to HANA POS");
	}
	
	@Test(priority = 4, enabled = false, groups= {"Regression"})
	public void ValidateLoginPageUIElementsPresenceTest() {
		lp = new LoginPage();
		softassert.assertEquals(lp.VerifyLoginPageTitle(), "HANA POS | Login");
		softassert.assertEquals(lp.ValidateLoginPage(), "Welcome to HANA POS");
		softassert.assertTrue(lp.ValidateUsernameFieldIsPresence(),"Username field is not displayed");
		softassert.assertTrue(lp.ValidatePasswordFieldIsPresence(),"Password field is not displayed");
		softassert.assertTrue(lp.ValidateLoginButtonIsPresence(),"Login button is not displayed");
		softassert.assertTrue(lp.ValidateForgotUserNameIsPresence(),"Forgot UserName link is not displayed");
		softassert.assertTrue(lp.ValidateForgotPasswordIsPresence(),"Forgot Password link is not displayed");
		softassert.assertTrue(lp.ValidateDonothaveanaccountIsPresence(),"Do not have an account link is not displayed");
		softassert.assertTrue(lp.ValidateCreateAccountIsPresence(),"Create Account button is not displayed");
		softassert.assertAll();
	}
	@Test(priority=5,enabled=false,groups= {"Regression"})
	public void ValidateForgotUsernamePageTest() {
		lp=new LoginPage();
		lp.ClickForgotUserName();
		Assert.assertTrue(lp.ValidateForgotUserNamePage());
	}
	
	@Test(priority=6,enabled=false,groups= {"Regression"})
	public void ValidateForgotPasswordPageTest() {
		lp=new LoginPage();
		lp.ClickForgotPassword();
		Assert.assertTrue(lp.ValidateForgotPasswordPage());
	}
}
