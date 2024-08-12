package com.hanapos.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hanapos.seleniumProjectBase.TestBaseClass;

public class LoginPage extends TestBaseClass {
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath="//h3[contains(text(),'Welcome to HANA POS')]") 
	private WebElement LoginPage;
	
	@FindBy(xpath="//h3[contains(text(),'Welcome to HANA Florist POS')]")
	private WebElement LoginPageQaFinal;

	@FindBy(id="Username") 
	private WebElement Username;

	@FindBy(id="Password") 
	private WebElement Password;

	@FindBy(id="btnLogin")
	private WebElement loginbutton;
	
	@FindBy(xpath="//span[@class='field-validation-error']")
	private WebElement loginPageErrorMsg;
	
	@FindBy(xpath="//span[contains(text(),'Please Enter Valid User Details')]")
	private WebElement IncorrectValidationMsg;
	
	@FindBy(xpath="//small[normalize-space()='Forgot UserName?']")
	private WebElement forgotUserName;
	
	@FindBy(xpath="//h3[normalize-space()='FORGOT USERNAME']")
	private WebElement forgotUserNamePage;
	
	@FindBy(xpath="//small[normalize-space()='Forgot password?']")
	private WebElement forgotpassword;
	
	@FindBy(xpath="//h3[normalize-space()='FORGOT PASSWORD']")
	private WebElement forgotPasswordPage;
	
	@FindBy(xpath="//small[normalize-space()='Do not have an account?']")
	private WebElement donothaveanaccount;
	
	@FindBy	(xpath="//a[normalize-space()='Create an account']")
	private WebElement CreateAccount;

	public String VerifyLoginPageTitle() {
		return getDriver().getTitle();
	}
	
	
	public String ValidateLoginPage() {
		HighlightElement(LoginPage);
		return LoginPage.getText(); // LoginPage.getText();//LoginPageQaFinal.getText(); 
	}
	
	public String ValidateLoginPageQaFinal() {
		HighlightElement(LoginPageQaFinal);
		return LoginPageQaFinal.getText();
	}
	
	public boolean LoginPageIsDisplayed() {
		HighlightElement(LoginPage);
		return LoginPage.isDisplayed();
	}

	public String ValidateLoginPageUrl() {
		return getDriver().getCurrentUrl();
	}
	
	public LoginPage EnterUserName(String username) {
		clickAndType(Username,username ); 
		return this;
	}
	
	public boolean ValidateUsernameFieldIsPresence() {
		HighlightElement(Username);
		return Username.isDisplayed();
	}

	public boolean ValidatePasswordFieldIsPresence() {
		HighlightElement(Password);
		return Password.isDisplayed();
	}

	public LoginPage EnterPassword(String password) {
		clickAndType(Password,password ); 
		return this;
	}

	public HanaDashBoardPage ClickLoginButton() {
		click(loginbutton);
		return new HanaDashBoardPage();
	}
	
	public boolean ValidateLoginButtonIsPresence() {
		HighlightElement(loginbutton);
		return loginbutton.isDisplayed();
	}
	
	public boolean IsValidationMessageExist() {
		HighlightElement(loginPageErrorMsg);
		return loginPageErrorMsg.isDisplayed();
	}
	
	public boolean IncorrectErrorMsgIsDisplayed() {
		HighlightElement(IncorrectValidationMsg);
		return IncorrectValidationMsg.isDisplayed();
	}
	
	public String NullValidationErrorMsg() {
		HighlightElement(loginPageErrorMsg);
		return loginPageErrorMsg.getText();
	}
	
	public String IncorrectValidationErrorMsg() {
		HighlightElement(IncorrectValidationMsg);
		return IncorrectValidationMsg.getText();
	}
		
	
	public boolean ValidateForgotUserNameIsPresence() {
		HighlightElement(forgotUserName);
		return forgotUserName.isDisplayed();
	}
	
	public void ClickForgotUserName() {
		click(forgotUserName);
	}

	public void ClickForgotPassword() {
		click(forgotpassword);
	}
	
	public boolean ValidateForgotPasswordIsPresence() {
		HighlightElement(forgotpassword);
		return forgotpassword.isDisplayed();
	}
	
	public boolean ValidateDonothaveanaccountIsPresence() {
		HighlightElement(donothaveanaccount);
		return donothaveanaccount.isDisplayed();
	}
	
	public boolean ValidateCreateAccountIsPresence() {
		HighlightElement(CreateAccount);
		return CreateAccount.isDisplayed();
	}
	
	public boolean ValidateForgotUserNamePage() {
		HighlightElement(forgotUserNamePage);
		return forgotUserNamePage.isDisplayed();
	}
	
	public boolean ValidateForgotPasswordPage() {
		HighlightElement(forgotPasswordPage);
		return forgotPasswordPage.isDisplayed();
	}
	
}
