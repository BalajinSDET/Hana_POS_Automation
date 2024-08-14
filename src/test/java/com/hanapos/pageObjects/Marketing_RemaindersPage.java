package com.hanapos.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Marketing_RemaindersPage extends TestBaseClass {
	
	public Marketing_RemaindersPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath="//h2[text()='Reminders']")
	private WebElement RemindersHeader;
	
	@FindBy(xpath="//select[@id='reminderShop']")
	private WebElement ShopDropDownRemaindersPage;
	
	@FindBy(xpath="//tbody[@role='rowgroup']//tr[1]//td[1]")
	private WebElement Row1actionButton;
	
	@FindBy(xpath="(//ul[@class='dropdown-menu']//li//a[@class='EditReminder'])[1]")
	private WebElement Row1EditReminder;
	
	@FindBy(xpath="//h4[@id='editReminder']")
	private WebElement EditReminderPopupHeader;
	
	@FindBy(xpath="//input[@id='txtCustomerName']")
	private WebElement CustomerName_EditReminderPopup;
	
	@FindBy(xpath="(//div[@class='bootstrap-tagsinput']//span)[1]")
	private WebElement CustomerEmail_EditReminderPopup;
	
	@FindBy(xpath="//input[@id='txtRecipientFirstName']")
	private WebElement RecipientFirstName_EditReminderPopup;
	
	@FindBy(xpath="//input[@id='txtRecipientLastName']")
	private WebElement RecipientLastName_EditReminderPopup;
	
	@FindBy(xpath="//input[@id='txtRecipientPhone']")
	private WebElement RecipientPhone_EditReminderPopup;
	
	@FindBy(xpath="//select[@id='ddlOccation']")
	private WebElement Occation_EditReminderPopup;
	
	@FindBy(xpath="//select[@id='ddlReminderType']")
	private WebElement ReminderType_EditReminderPopup;
	
	@FindBy(xpath="//input[@id='txtReminderDate']")
	private WebElement ReminderDate_EditReminderPopup;
	
	public boolean Verify_RemaindersHeaderAppears() {
		HighlightElement(RemindersHeader);
		return RemindersHeader.isDisplayed();
	}
	
	public void Select_ShopDropDownRemaindersPage(String shopname) {
		dropDown(ShopDropDownRemaindersPage, shopname, "VisibleText");
	}
	
	public void Click_Row1ActionButton() {
		click(Row1actionButton);
	}
	
	public void Click_Row1EditReminder() {
		click(Row1EditReminder);
	}
	
	public boolean Verify_EditReminderPopupAppears() {
		delayWithGivenTime(2000);
		HighlightElement(EditReminderPopupHeader);
		return EditReminderPopupHeader.isDisplayed();
	}
	
	public String get_CustomerName_EditReminderPopup() {
		HighlightElement(CustomerName_EditReminderPopup);
		return CustomerName_EditReminderPopup.getAttribute("value");
	}
	
	public String get_CustomerEmail_EditReminderPopup() {
		HighlightElement(CustomerEmail_EditReminderPopup);
		return CustomerEmail_EditReminderPopup.getText();
	}
	
	public String get_RecipientFirstName_EditReminderPopup() {
		HighlightElement(RecipientFirstName_EditReminderPopup);
		return RecipientFirstName_EditReminderPopup.getAttribute("value");
	}
	
	public String get_RecipientLastName_EditReminderPopup() {
		HighlightElement(RecipientLastName_EditReminderPopup);
		return RecipientLastName_EditReminderPopup.getAttribute("value");
	}
	
	public String get_RecipientPhone_EditReminderPopup() {
		HighlightElement(RecipientPhone_EditReminderPopup);
		return RecipientPhone_EditReminderPopup.getAttribute("value");
	}
	
	public String get_Occation_EditReminderPopup() {
		HighlightElement(Occation_EditReminderPopup);
		Select select = new Select(Occation_EditReminderPopup);
		String Occation = select.getFirstSelectedOption().getText();
		return Occation;
	}
	
	public String get_ReminderType_EditReminderPopup() {
		HighlightElement(ReminderType_EditReminderPopup);
		Select select = new Select(ReminderType_EditReminderPopup);
		String RemainderType = select.getFirstSelectedOption().getText();
		return RemainderType;
	}
	
	public String get_ReminderDate_EditReminderPopup() {
		HighlightElement(ReminderDate_EditReminderPopup);
		return ReminderDate_EditReminderPopup.getAttribute("value");
	}
	
	
}
