package com.hanapos.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hanapos.seleniumProjectBase.TestBaseClass;

public class Configuration_SettingsPage extends TestBaseClass{

	public Configuration_SettingsPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//div[@class='navbar-collapse collapse']")
	private WebElement HanaSupportPortal;
	
	@FindBy(xpath="(//p[@class='configSaid-text'])[8]")
	private WebElement OrderEntryLeftMenu;
	
	@FindBy(xpath="//p[text()='Common Address Management']")
	private WebElement CommonAddressManagement;
	
	@FindBy(xpath="(//table[@class='k-selectable'])[1]//tbody//tr[1]//td[2]")
	private WebElement Row1deleteIcon_On_CommonAddressGridTable;
	
	@FindBy(xpath="(//button[text()='Yes'])[1]")
	private WebElement YesButton_DeleteConfirmation_On_CommonAddress;
	
	@FindBy(xpath="(//table[@class='k-selectable'])[2]//tbody//tr//td[2]")
	private List<WebElement> ListOfAddress1_CommonAddressManagement;
	
	@FindBy(xpath="//p[text()='Funeral Log']")
	private WebElement FuneralLogMenu;
	
	@FindBy(xpath="//div[@id='SelecetdConfig']//a")
	private WebElement orderEntryBreadcrumbLink;
	
	@FindBy(xpath="//div[@id='FuneralLogGrid']//div[2]//table//tbody//tr[1]//td[1]")
	private WebElement EditIcon_FuneralLogGridTableRow1;
	
	@FindBy(xpath="//div[@id='FuneralLogGrid']//div[2]//table//tbody//tr[1]//td[2]")
	private WebElement deleteIcon_FuneralLogGridTableRow1;
	
	@FindBy(xpath="(//button[@type='button'][normalize-space()='×'])[1]")
	private WebElement closeIcon_FuneralLog_AddNewRecordPopup;
	
	@FindBy(xpath="//button[@class='confirm']")
	private WebElement YesButton_DeleteConfirmationPopup_FuneralLogGridTableRow1;
	
	@FindBy(xpath="//div[@id='FuneralLogGrid']//div[2]//table//tbody//tr[1]//td[3]")
	private WebElement FirstName_FuneralLogGridTableRow1;
	
	@FindBy(xpath="//div[@id='FuneralLogGrid']//div[2]//table//tbody//tr[1]//td[4]")
	private WebElement LastName_FuneralLogGridTableRow1;
	
	@FindBy(xpath="//div[@id='FuneralLogGrid']//div[2]//table//tbody//tr[1]//td[5]")
	private WebElement DeliveryDate_FuneralLogGridTableRow1;
	
	@FindBy(xpath="//div[@id='FuneralLogGrid']//div[2]//table//tbody//tr[1]//td[6]")
	private WebElement DeliveryTime_FuneralLogGridTableRow1;
	
	@FindBy(xpath="//div[@id='FuneralLogGrid']//div[2]//table//tbody//tr[1]//td[7]")
	private WebElement DeliveryOn_FuneralLogGridTableRow1;
	
	@FindBy(xpath="//div[@id='FuneralLogGrid']//div[2]//table//tbody//tr[1]//td[8]")
	private WebElement DeliveryAddress1_FuneralLogGridTableRow1;
	
	@FindBy(xpath="//div[@id='FuneralLogGrid']//div[2]//table//tbody//tr[1]//td[9]")
	private WebElement DeliveryAddress2_FuneralLogGridTableRow1;
	
	@FindBy(id="lblTitle")
	private WebElement Funeral_Log_AddNewRecord_Popup;
	
	@FindBy(xpath="//input[@id='FirstName']")
	private WebElement fname_Funeral_Log_AddNewRecord_Popup;
	
	@FindBy(xpath="//input[@id='LastName']")
	private WebElement lname_Funeral_Log_AddNewRecord_Popup;
	
	@FindBy(xpath="//select[@id='DeliveryOn']")
	private WebElement deliveryon_Funeral_Log_AddNewRecord_Popup;
	
	@FindBy(xpath="//select[@id='DeliveryTime']")
	private WebElement deliverytime_Funeral_Log_AddNewRecord_Popup;
	
	@FindBy(xpath="//input[@id='DeliveryDate']")
	private WebElement deliverydate_Funeral_Log_AddNewRecord_Popup;
	
	@FindBy(xpath="//input[@id='Address1']")
	private WebElement address1_Funeral_Log_AddNewRecord_Popup;
	
	@FindBy(xpath="//div[@class='ibox-content iframeContent']//iframe")
	private WebElement iframe_Funeral_Log_AddNewRecord_Popup;
	
	
	
	public boolean Verify_Configuration_SettingsPage() {
		HighlightElement(HanaSupportPortal);
		return (HanaSupportPortal.isDisplayed());
	}
	
	public void Click_OrderEntryLeftMenu() {
		click(OrderEntryLeftMenu);
	}
	
	public void Click_CommonAddressManagement() {
		click(CommonAddressManagement);
	}
	
	public boolean Verify_Address1_CommonAddressManagement_IsDisplayed(String Address1) {
	   ThreadWait(3000);
		for (WebElement ele : ListOfAddress1_CommonAddressManagement) {
	        if (ele.getText().equals(Address1)) {
	            HighlightElement(ele); // "114 N CHURCH ST"
	            return ele.isDisplayed();
	        }
	    }
	    return false;
	}

	public String Verify_DisplayedAddress1_CommonAddressManagement() {
		for (WebElement ele : ListOfAddress1_CommonAddressManagement) {
			HighlightElement(ele); // "114 N CHURCH ST"
			return ele.getText();			
		}
		return null;
	}
	
	public void Click_FuneralLogMenu() {
		click(FuneralLogMenu);
	}
	
	public void Click_EditIcon_FuneralLogGridTableRow1() {
		click(EditIcon_FuneralLogGridTableRow1);
	}
	
	public String getDisplayedFirstName() {
		getDriver().switchTo().activeElement();
		getDriver().switchTo().frame(0);
		delayWithGivenTime(2000);
		HighlightElement(FirstName_FuneralLogGridTableRow1);
		return FirstName_FuneralLogGridTableRow1.getText();
	}
	
	public String getDisplayedLastName() {
		HighlightElement(LastName_FuneralLogGridTableRow1);
		return LastName_FuneralLogGridTableRow1.getText();
	}
	
	public String getDisplayedDeliveryDate() {
		HighlightElement(DeliveryDate_FuneralLogGridTableRow1);
		return DeliveryDate_FuneralLogGridTableRow1.getText();
	}
	
	public String getDisplayedDeliveryTime() {
		HighlightElement(DeliveryTime_FuneralLogGridTableRow1);
		return DeliveryTime_FuneralLogGridTableRow1.getText();
	}
	
	public String getDisplayedDeliveryOn() {
		HighlightElement(DeliveryOn_FuneralLogGridTableRow1);
		return DeliveryOn_FuneralLogGridTableRow1.getText();
	}
	
	public String getDisplayedDeliveryAddress1() {
		HighlightElement(DeliveryAddress1_FuneralLogGridTableRow1);
		return DeliveryAddress1_FuneralLogGridTableRow1.getText();
	}
	
	public String getDisplayedDeliveryAddress2() {
		HighlightElement(DeliveryAddress2_FuneralLogGridTableRow1);
		return DeliveryAddress2_FuneralLogGridTableRow1.getText();
	}
	
	public boolean Verify_FuneralLog_AddNewRecord_Popup() {
		HighlightElement(Funeral_Log_AddNewRecord_Popup);
		return Funeral_Log_AddNewRecord_Popup.isDisplayed();
	}
	
	public String getFirstNameFuneralLogAddNewRecordPopup() {
		HighlightElement(fname_Funeral_Log_AddNewRecord_Popup);
		return fname_Funeral_Log_AddNewRecord_Popup.getAttribute("value");
	}
	
	public String getLastNameFuneralLogAddNewRecordPopup() {
		HighlightElement(lname_Funeral_Log_AddNewRecord_Popup);
		return lname_Funeral_Log_AddNewRecord_Popup.getAttribute("value");
	}
	
	public String getSelectedDeliveryOnFuneralLogAddNewRecordPopup() {
		HighlightElement(deliveryon_Funeral_Log_AddNewRecord_Popup);
		Select dropdown = new Select(deliveryon_Funeral_Log_AddNewRecord_Popup);
		return dropdown.getFirstSelectedOption().getText();
	}
	
	public String getSelectedDeliveryTimeFuneralLogAddNewRecordPopup() {
		HighlightElement(deliverytime_Funeral_Log_AddNewRecord_Popup);
		Select dropdown = new Select(deliverytime_Funeral_Log_AddNewRecord_Popup);
		return dropdown.getFirstSelectedOption().getText();
	}
	
	public String getSelectedDeliveryDateFuneralLogAddNewRecordPopup() {
		HighlightElement(deliverydate_Funeral_Log_AddNewRecord_Popup);
		return deliverydate_Funeral_Log_AddNewRecord_Popup.getAttribute("value");
	}
	
	public String getEnteredAddress1FuneralLogAddNewRecordPopup() {
		HighlightElement(address1_Funeral_Log_AddNewRecord_Popup);
		return address1_Funeral_Log_AddNewRecord_Popup.getAttribute("value");
	}
	
	public void Click_DeleteIcon_FuneralLogGridTableRow1() {
		click(deleteIcon_FuneralLogGridTableRow1);
	}
	
	public void Click_Row1_DeleteIcon_FuneralLogGridTableRow2() {
		click(YesButton_DeleteConfirmationPopup_FuneralLogGridTableRow1);
	}
	
	public void Click_CloseIcon_FuneralLogAddNewRecordPopup() {
		click(closeIcon_FuneralLog_AddNewRecordPopup);
	}
	
	public void Click_OrderEntryBreadCrumbLink() {
		getDriver().switchTo().defaultContent();
		delayWithGivenTime(1000);
		actionScrollClick(orderEntryBreadcrumbLink);
	}
	
	public void Click_Row1_DeleteIcon() {		
		jsClick(Row1deleteIcon_On_CommonAddressGridTable);
	}
	
	public void Click_YesButton_On_DeleteConfirmation() {
		delayWithGivenTime(1000);
		jsClick(YesButton_DeleteConfirmation_On_CommonAddress);
	}
	
	
	
}	

