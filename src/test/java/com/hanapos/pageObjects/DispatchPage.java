package com.hanapos.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hanapos.seleniumProjectBase.TestBaseClass;

public class DispatchPage extends TestBaseClass{
	public DispatchPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//h4[text()='Dispatch']")
	private WebElement dispatchPage;
	
	@FindBy(xpath="//input[@id='undispatch-invoicescan']")
	private WebElement scanOrder_Textbox;
	
	@FindBy(xpath="//select[@id='ddlDispatchDriver']")
	private WebElement selectDriver_Dropdown;
	
	@FindBy(xpath="//table[@id='dispatchCurrentDispatch']//tbody//tr[1]//td[1]")
	private WebElement InvoiceNumberOnDispatchTable_Row1_TripSection;
	
	@FindBy(xpath="//table[@id='dispatchCurrentDispatch']//tbody//tr[1]//td[2]")
	private WebElement Name_Address_OnDispatchTable_Row1_TripSection;
	
	@FindBy(xpath="//table[@id='dispatchCurrentDispatch']//tbody//tr[1]//td[3]")
	private WebElement City_OnDispatchTable_Row1_TripSection;
	
	@FindBy(xpath="//table[@id='dispatchCurrentDispatch']//tbody//tr[1]//td[4]")
	private WebElement State_OnDispatchTable_Row1_TripSection;
	
	@FindBy(xpath="//table[@id='dispatchCurrentDispatch']//tbody//tr[1]//td[5]")
	private WebElement Zipcode_OnDispatchTable_Row1_TripSection;
	
	@FindBy(id="btnDispatchSave")
	private WebElement DispatchSave_Button;
	
	@FindBy(id="btnDispatchCreateTrip")
	private WebElement DispatchNewTrip_Button;
	
	@FindBy(id="ancDispatchRoutePlanner")
	private WebElement DispatchRoutePlanner_Button;
	
	@FindBy(id="btnDispatchRemotePrint")
	private WebElement DispatchRemotePrint_Button;
	
	@FindBy(id="btnDispatchManualPrint")
	private WebElement DispatchManualPrint_Button;
	
	@FindBy(id="btnDispatchAddPayrate")
	private WebElement DispatchAddPayrate_Button;
	
	@FindBy(xpath="(//table[@role='grid']//tbody)[6]//tr//td[2]")
	private List<WebElement> SavedTrips_driverInitial;
	
	@FindBy(xpath="(//table[@role='grid']//tbody)[6]//tr//td[3]")
	private List<WebElement> SavedTrips_driverName;
	
	@FindBy(xpath="(//table[@role='grid']//tbody)[6]//tr//td[4]")
	private List<WebElement> SavedTrips_driverPhonenumber;
	
	@FindBy(xpath="(//a[@class='close text-right no-padding']//i)[3]")
	private WebElement closeIcon_dispatchPopup;
	
	
	public String get_InvoiceNumberOnDispatchTable() {
		HighlightElement(InvoiceNumberOnDispatchTable_Row1_TripSection);
		return InvoiceNumberOnDispatchTable_Row1_TripSection.getText();
	}
	
	public boolean Verify_DispatchPopup_IsDisplayed() {
		HighlightElement(dispatchPage);
		return dispatchPage.isDisplayed();
	}
	
	public void Enter_InvoiceNumber_on_ScanOrderTextbox(String order) {
		//jsClearAndType(scanOrder_Textbox, order);
		scanOrder_Textbox.sendKeys(order);
		delayWithGivenTime(2000);
		scanOrder_Textbox.sendKeys(Keys.ENTER);
	}
	
	public void Select_Driver(String drivername) {
		dropDown(selectDriver_Dropdown, drivername, "VisibleText");
	}
	
	public String get_Selected_Driver() {
		Select s = new Select(selectDriver_Dropdown);
		return s.getFirstSelectedOption().getText();
	}
	
	public String get_Displayed_InvoiceNumber_Row1() {
		HighlightElement(InvoiceNumberOnDispatchTable_Row1_TripSection);
		return InvoiceNumberOnDispatchTable_Row1_TripSection.getText();
	}
	
	public void Click_DispatchSave_Button() {
		jsClick(DispatchSave_Button);
	}
	
	public boolean Verify_NewTripBtn_IsDisplayed() {
		HighlightElement(DispatchNewTrip_Button);
		return DispatchNewTrip_Button.isDisplayed();
	}
	
	public boolean Verify_RoutePlannerBtn_IsDisplayed() {
		HighlightElement(DispatchRoutePlanner_Button);
		return DispatchRoutePlanner_Button.isDisplayed();
	}
	
	public boolean Verify_RemotePrintBtn_IsDisplayed() {
		HighlightElement(DispatchRemotePrint_Button);
		return DispatchRemotePrint_Button.isDisplayed();
	}
	
	public boolean Verify_ManualPrintBtn_IsDisplayed() {
		HighlightElement(DispatchManualPrint_Button);
		return DispatchManualPrint_Button.isDisplayed();
	}
	
	public boolean Verify_AddPayrateBtn_IsDisplayed() {
		HighlightElement(DispatchAddPayrate_Button);
		return DispatchAddPayrate_Button.isDisplayed();
	}
	
	public String get_InvoiceNumber_On_TripSection() {
		HighlightElement(InvoiceNumberOnDispatchTable_Row1_TripSection);
		return InvoiceNumberOnDispatchTable_Row1_TripSection.getText().trim();
	}
	
	public String get_NameAndAddress_On_TripSection() {
		HighlightElement(Name_Address_OnDispatchTable_Row1_TripSection);
		return Name_Address_OnDispatchTable_Row1_TripSection.getText().trim();
	}
	
	public String get_City_On_TripSection() {
		HighlightElement(City_OnDispatchTable_Row1_TripSection);
		return City_OnDispatchTable_Row1_TripSection.getText().trim();
	}
	
	public String get_State_On_TripSection() {
		HighlightElement(State_OnDispatchTable_Row1_TripSection);
		return State_OnDispatchTable_Row1_TripSection.getText().trim();
	}
	
	public String get_Zipcode_On_TripSection() {
		HighlightElement(Zipcode_OnDispatchTable_Row1_TripSection);
		return Zipcode_OnDispatchTable_Row1_TripSection.getText().trim();
	}
	
	public String get_SavedTrips_driverInitial(String driverInitial) {
		String driverinitial = null;
		for(WebElement ele:SavedTrips_driverInitial) {
			if(ele.getText().contains(driverInitial)) {
				 driverinitial=(ele.getText());
				 return driverinitial;
			}
		}
		return driverinitial;
	}
	
	public String get_SavedTrips_driverName(String drivername) {
		String driverinitial = null;
		for(WebElement ele:SavedTrips_driverName) {
			if(ele.getText().contains(drivername)) {
				 driverinitial=(ele.getText());
				 return driverinitial;
			}
		}
		return driverinitial;
	}
	
	public String get_SavedTrips_driverPhoneNumber(String driverphonenumber) {
		String driverinitial = null;
		for(WebElement ele:SavedTrips_driverPhonenumber) {
			if(ele.getText().contains(driverphonenumber)) {
				 driverinitial=(ele.getText());
				 return driverinitial;
			}
		}
		return driverinitial;
	}
	
	public void Click_CloseIcon_dispatchPopup() {
		jsClick(closeIcon_dispatchPopup);
	}
	
}
