package com.hanapos.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Order_Confirmation_Page extends TestBaseClass {
	
	Select s;
	public Order_Confirmation_Page() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="(//h1[normalize-space()='Order Created Successfully'])[1]")
	private WebElement OrderConfirmationPage;
	
	@FindBy(id="customerFName")
	private WebElement CustomerFirstName;
	
	@FindBy(id="customerLName")
	private WebElement CustomerLastName;
	
	@FindBy(id="customerEmail")
	private WebElement CustomerEmail;
	
	@FindBy(id="customerPhone1")
	private WebElement CustomerPhone1;
	
	@FindBy(id="customerPhone2")
	private WebElement CustomerPhone2;
	
	@FindBy(xpath="//span[@id='customerAddress1']")
	private WebElement CustomerAddress;
	
	@FindBy(id="customerCity")
	private WebElement CustomerCity;
	
	@FindBy(id="customerState")
	private WebElement CustomerState;
	
	@FindBy(id="customerZip")
	private WebElement CustomerZip;
	
	public boolean VerifyOrderConfirmationPage() {
		HighlightElement(OrderConfirmationPage);
		return OrderConfirmationPage.isDisplayed();	
	}
	
	public String getCustomerFname() {
		HighlightElement(CustomerFirstName);
		return 	CustomerFirstName.getText();
	}
	
	public String getCustomerLname() {
		HighlightElement(CustomerLastName);
		return 	CustomerLastName.getText();
	}
	
	public String getCustomerEmail() {
		HighlightElement(CustomerEmail);
		return 	CustomerEmail.getText();
	}
	
	public String getCustomerPhone1() {
		HighlightElement(CustomerPhone1);
		return 	CustomerPhone1.getText();
	}
	
	public String getCustomerPhone2() {
		HighlightElement(CustomerPhone2);
		return 	CustomerPhone2.getText();
	}
	
	public String getCustomerAddress() {
		HighlightElement(CustomerAddress);
		return 	CustomerAddress.getText();
	}
	
	public String getCustomerCity() {
		HighlightElement(CustomerCity);
		return 	CustomerCity.getText();
	}
	
	public String getCustomerState() {
		HighlightElement(CustomerState);
		return 	CustomerState.getText();
	}
	
	public String getCustomerZip() {
		HighlightElement(CustomerZip);
		return 	CustomerZip.getText();
	}
	
}
