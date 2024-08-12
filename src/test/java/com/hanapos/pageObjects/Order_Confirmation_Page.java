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
	
	@FindBy(id="recipentFName")
	private WebElement RecipientFirstName;
	
	@FindBy(id="recipentLName")
	private WebElement RecipientLastName;
	
	@FindBy(id="recipentPhone1")
	private WebElement RecipientPhone1;
	
	@FindBy(id="recipentPhone2")
	private WebElement RecipientPhone2;
	
	@FindBy(id="recipentAddress1")
	private WebElement RecipientAddress1;
	
	@FindBy(id="recipentAddress2")
	private WebElement RecipientAddress2;
	
	@FindBy(id="recipentCity")
	private WebElement RecipientCity;
	
	@FindBy(id="recipentState")
	private WebElement RecipientState;
	
	@FindBy(id="recipentZip")
	private WebElement RecipientZip;
	
	@FindBy(id="btnSubmit")
	private WebElement SubmitButton;
	
	@FindBy(xpath="//td[@class='text-wrap-cms text-wrap-cms-small']//div")
	private WebElement itemcode1;
	
	@FindBy(xpath="//td[@class='text-wrap-cms text-wrap-cms-small']//small")
	private WebElement itemdescription1;
	
	@FindBy(xpath="//tbody[@id='tbodyitems']//td[2]")
	private WebElement qty1;
	
	@FindBy(xpath="//tbody[@id='tbodyitems']//td[3]")
	private WebElement unitprice1;
	
	@FindBy(xpath="//td//span[@id='orderpaymentType']")
	private WebElement PaymentType;
	
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
	
	public String getRecipientFname() {
		HighlightElement(RecipientFirstName);
		return 	RecipientFirstName.getText();
	}
	
	public String getRecipientLname() {
		HighlightElement(RecipientLastName);
		return 	RecipientLastName.getText();
	}
	
	public String getRecipientPhone1() {
		HighlightElement(RecipientPhone1);
		return 	RecipientPhone1.getText();
	}
	
	public String getRecipientPhone2() {
		HighlightElement(RecipientPhone2);
		return 	RecipientPhone2.getText();
	}
	
	public String getRecipientAddress1() { 
		HighlightElement(RecipientAddress1);
		return 	RecipientAddress1.getText();
	}
	
	public String getRecipientAddress2() { 
		HighlightElement(RecipientAddress2);
		return 	RecipientAddress2.getText();
	}
	
	
	public String getRecipientCity() {
		HighlightElement(RecipientCity);
		return 	RecipientCity.getText();
	}
	
	public String getRecipientState() {
		HighlightElement(RecipientState);
		return 	RecipientState.getText();
	}
	
	public String getRecipientZip() {
		HighlightElement(RecipientZip);
		return 	RecipientZip.getText();
	}

	public String get_itemcode1() {
		HighlightElement(itemcode1);
		return itemcode1.getText();
	}
	
	public String get_itemdescription1() {
		HighlightElement(itemdescription1);
		return itemdescription1.getText();
	}
	
	public String get_itemqty1() {
		HighlightElement(qty1);
		return qty1.getText();
	}
	
	public String get_itemunitprice1() {
		HighlightElement(unitprice1);
		return unitprice1.getText();
	}
	
	public String get_PaymentType() {
		HighlightElement(PaymentType);
		return PaymentType.getText();
	}
}
