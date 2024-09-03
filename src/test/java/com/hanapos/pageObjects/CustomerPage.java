package com.hanapos.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hanapos.seleniumProjectBase.TestBaseClass;

public class CustomerPage extends TestBaseClass {
	public CustomerPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath="//h2[@class='set-text-heading']")
	private WebElement CustomerMenuHeading;
	
	@FindBy(xpath="//th[@data-field='CustomerId']")
	private WebElement CustomerIdColumn_header;
	
	@FindBy(xpath="//span[@class='k-icon k-i-sort-desc-sm']")
	private WebElement descendingIconOnCustomerIdColumn;
	
	@FindBy(xpath="//span[@class='k-icon k-i-sort-asc-sm']")
	private WebElement ascendingIconOnCustomerIdColumn;
	
	@FindBy(xpath="//input[@data-text-field='CustomerName']")
	private WebElement CustomerNameSearchBox;
	
	@FindBy(xpath="//td[4]")
	private List<WebElement> CustomerId_List_OnCustTable;
	
	@FindBy(xpath="//input[@data-text-field='CustomerId']")
	private WebElement CustomerIdSearchBox;
	
	@FindBy(xpath="(//input[@data-text-field='CityStateZip'])[1]")
	private WebElement CustomerCityStateZipSearchBox;
	
	@FindBy(xpath="(//input[@data-text-field='Cust_phone'])")
	private WebElement CustomerPhoneSearchBox;
	
	@FindBy(xpath="(//input[@data-text-field='Cust_address1'])")
	private WebElement CustomerAddressSearchBox;
	
	@FindBy(xpath="(//ul[@class='k-list k-reset'])//li")
	private List<WebElement> CustomerList;
	
	@FindBy(xpath="(//tr[@role='row'])[2]//td[6]")
	private WebElement CompanyNameOnCustTable;
	
	@FindBy(xpath="(//tr[@role='row'])[2]//td[7]")
	private WebElement PhoneNumberOnCustTable;
	
	@FindBy(xpath="(//tr[@role='row'])[2]//td[8]")
	private WebElement AddressOnCustTable;
	
	@FindBy(xpath="(//tr[@role='row'])[2]//td[9]")
	private WebElement CityStateZipCodeOnCustTable;
	
	@FindBy(xpath="(//tr[@role='row'])[2]//td[5]")
	private WebElement CustomerTableRow1;
	
	@FindBy(xpath="//td[@class='rowEvent hana-invoice-column set-customer-font']")
	private List<WebElement> ListOfCustomerID_OnCustomerTableRow;
	
	@FindBy(xpath="//select[@data-role='dropdownlist']")
	private WebElement CustomerDetails_PaginationDropDown;
	
	@FindBy(xpath="//div[@id='page-wrapper']//h4[@id='Title']")
	private WebElement CustomerDetailsPopupHeading;
	
	@FindBy(xpath="(//div[@Class='modal-header customer-modal-header']//a//i)[1]")
	private WebElement CustomerDetailsPopupCloseIcon;
	
	@FindBy(xpath="(//input[@class='i-checks checkbox-all-commongrid'])[1]")
	private WebElement CustomerTableAllCheckBox;
	
	@FindBy(xpath="(//span[@class='fa fa-bars fa-1x fa-font-style'])[1]")
	private WebElement CustomerActionbutton;
	
	@FindBy(xpath="//a[normalize-space()='Delete']")
	private WebElement CustomerDeleteButton;
	
	@FindBy(xpath="//div[@id='page-wrapper']//input[@id='txtCompanyName']")
	private WebElement CustDetailsCompanyNameTextBox;
	
	@FindBy(xpath="(//input[@id='txtFirstName'])[1]")
	private WebElement CustDetailsFirstNameTextBox;
	
	@FindBy(xpath="(//input[@id='txtLastName'])[1]")
	private WebElement CustDetailsLastNameTextBox;
	
	@FindBy(xpath="(//input[@id='txtAddress1'])[1]")
	private WebElement CustDetailsAddress1TextBox;
	
	@FindBy(xpath="(//input[@id='txtAddress2'])[1]")
	private WebElement CustDetailsAddress2TextBox;
	
	@FindBy(xpath="(//input[@id='txtCity'])[1]")
	private WebElement CustDetailsCityTextBox;
	
	@FindBy(xpath="(//input[@id='txtState'])[1]")
	private WebElement CustDetailsStateTextBox;
	
	@FindBy(xpath="(//input[@id='txtZip'])[1]")
	private WebElement CustDetailsZipCodeTextBox;
	
	@FindBy(xpath="(//input[@id='txtCountry'])[1]")
	private WebElement CustDetailsCountryTextBox;
	
	@FindBy(xpath="(//input[@id='txtPhoneNumber'])[1]")
	private WebElement CustDetailsPhoneNumberTextBox;
	
	@FindBy(xpath="(//input[@id='txtAltPhone'])[1]")
	private WebElement CustDetailsAltPhoneNumberTextBox;
	
	@FindBy(xpath="(//input[@id='txtEmail'])[1]")
	private WebElement CustDetailsEmailTextBox;
	
	@FindBy(xpath="(//input[@id='txtStoreCredit'])[1]")
	private WebElement CustDetailsStoreCreditTextBox;
	
	@FindBy(xpath="(//span[@class='switchery switchery-default'])[1]")
	private WebElement CustDetailsCreditApprovedToogle;
	
	@FindBy(xpath="(//span[@class='switchery switchery-default'])[2]")
	private WebElement CustDetailsEmailSettingToogle;
	
	@FindBy(xpath="(//span[@class='switchery switchery-default'])[3]")
	private WebElement CustDetailsLateFeeSettingToogle;
	
	@FindBy(xpath="(//span[contains(@class,'switchery switchery-default')])[5]")
	private WebElement CustDetailsPaperlessStatementToogle;
	
	@FindBy(xpath="(//span[contains(@class,'switchery switchery-default')])[6]")
	private WebElement CustDetailsEnableLoyaltyToogle;
	
	@FindBy(xpath="(//span[contains(@class,'switchery switchery-default')])[7]")
	private WebElement CustDetailsAllowFeedbackEmailToogle;
	
	@FindBy(xpath="//div[@id='page-wrapper']//select[@id='ddlCustomerType']")
	private WebElement CustDetailsCustomerTypeDropDown;
	
	@FindBy(xpath="//tbody[@role='rowgroup']//tr[last()]//td[4]")
	private WebElement CustTable_CustomerID_LastRow;
	
	@FindBy(xpath="//tbody[@role='rowgroup']//tr[1]//td[4]")
	private WebElement CustTable_CustomerID_Row1;
	
	@FindBy(xpath="(//div[@class='card-no-text'])")
	private List<WebElement> List_OfCustDetailsPopup_CreditCardNo;
	
	@FindBy(xpath="(//div[@class='card-no-text'])[1]")
	private WebElement CustDetailsPopup_CreditCardNo;
	
	@FindBy(xpath="(//div[@class='card-date-text'])[1]")
	private WebElement CustDetailsPopup_ExpiryDate;
	
	@FindBy(xpath="(//div[@class='col-lg-2 col-sm-2 nopadding'])[2]")
	private WebElement CustDetailsPopup_CreditCard_DeleteIcon;
	
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	private WebElement CustDetailsPopup_CreditcardTab_DeleteIconAlert_OkButton;
	
	public boolean VerifyCustomerMenuPage() {
		HighlightElement(CustomerMenuHeading);
		fluentWait(CustomerMenuHeading);
		return CustomerMenuHeading.isDisplayed();
	}
	
	public void SearchAndSelectCustomerName(String customerName) {
		clickAndType(CustomerNameSearchBox, customerName);
		delayWithGivenTime(3000);

		for (WebElement customer : CustomerList) {
	        if (customer.getText().equals("Test Automation")) {
	        	click(customer);
	            break;
	        }
	    }				
	}
	
	public void SearchAndSelectCustomerCityStateZip(String citystatezip) {
		clickAndType(CustomerCityStateZipSearchBox, citystatezip);
		delayWithGivenTime(3000);

		for (WebElement customer : CustomerList) {
	        if (customer.getText().equals("Coimbatore")) {
	        	click(customer);
	            break;
	        }
	    }				
	}
	
	public void SearchAndSelectCustomerPhone(String phone) {
		clickAndType(CustomerPhoneSearchBox, phone);
	}
	
	public void SearchAndSelectCustomerAddress(String address) {
		clickAndType(CustomerAddressSearchBox, address);
	}
	
	public void ClickCustomerId_LastRow_OnCustTable() {
		fluentWait(CustTable_CustomerID_LastRow);
		jsClick(CustTable_CustomerID_LastRow);
	}
	
	public void Click_CustomerId_Row1_OnCustTable() {
		fluentWait(CustTable_CustomerID_Row1);
		jsClick(CustTable_CustomerID_Row1);
	}
	
	public void Search_and_SelectCustomerName(String customerName, String expectedcustomername) {
		CustomerNameSearchBox.click();
		delayWithGivenTime(1000);
		DoubleClickAndType(CustomerNameSearchBox, customerName);
		delayWithGivenTime(1000);
		for (WebElement customer : CustomerList) {
	        if (customer.getText().contains(expectedcustomername)) {
	        	jsClick(customer);
	            break;
	        }
	    }
	}
	
	public void Enter_CustomerName_searchbox_OnCustTable(String customername) {	
		CustomerNameSearchBox.clear();
		CustomerNameSearchBox.sendKeys(customername);
		delayWithGivenTime(1000);
		CustomerNameSearchBox.sendKeys(Keys.ENTER);
	}
	
	public String VerifyCompanyNameOnCustTable() {
		HighlightElement(CompanyNameOnCustTable);
		return CompanyNameOnCustTable.getText();
	}
	
	public String VerifyPhoneNumberOnCustTable() {
		HighlightElement(PhoneNumberOnCustTable);
		return PhoneNumberOnCustTable.getText();
	}
	
	public String VerifyAddressOnCustTable() {
		HighlightElement(AddressOnCustTable);
		return AddressOnCustTable.getText();
	}
	
	public String VerifyCityStateZipCodeOnCustTable() {
		HighlightElement(CityStateZipCodeOnCustTable);
		return CityStateZipCodeOnCustTable.getText();
	}
	
	public void ClickCustomerTableRow1() {
		CustomerTableRow1.click();
		jsClick(CustomerTableRow1);
	}
	
	public boolean VerifyCustomerDetailsPopup() {
		HighlightElement(CustomerDetailsPopupHeading);
		fluentWait(CustomerDetailsPopupHeading);
		return CustomerDetailsPopupHeading.isDisplayed();
	}
	
	public void ClickCustomerDetailsPopupCloseIcon() {
		jsScrollClick(CustomerDetailsPopupCloseIcon);
	}
	
	public void ClickOnCustomerTableAllCheckBox() {
		jsClick(CustomerTableAllCheckBox);
	}
	
	public void ClickOnActionButton() {
		jsClick(CustomerActionbutton);
	}
	
	public void ClickOnCustomerDeleteButton() {
		jsClick(CustomerDeleteButton);
	}
	
	public String getCustDetailsCompanyNameTextBox() {
		HighlightElement(CustDetailsCompanyNameTextBox);
		return CustDetailsCompanyNameTextBox.getAttribute("value");
	}
	
	public String getCustDetailsFirstNameTextBox() {
		HighlightElement(CustDetailsFirstNameTextBox);
		System.out.println(CustDetailsFirstNameTextBox.getAttribute("value"));
		return CustDetailsFirstNameTextBox.getAttribute("value");
	}
	
	public String getCustDetailsLastNameTextBox() {
		HighlightElement(CustDetailsLastNameTextBox);
		return CustDetailsLastNameTextBox.getAttribute("value");
	}
	
	public String getCustDetailsAddress1TextBox() {
		HighlightElement(CustDetailsAddress1TextBox);
		return CustDetailsAddress1TextBox.getAttribute("value");
	}
	
	public String getCustDetailsAddress2TextBox() {
		HighlightElement(CustDetailsAddress2TextBox);
		return CustDetailsAddress2TextBox.getAttribute("value");
	}
	
	public String getCustDetailsCityTextBox() {
		HighlightElement(CustDetailsCityTextBox);
		return CustDetailsCityTextBox.getAttribute("value").trim();
	}
	
	public String getCustDetailsStateTextBox() {
		HighlightElement(CustDetailsStateTextBox);
		return CustDetailsStateTextBox.getAttribute("value");
	}
	
	public String getCustDetailsZipCodeTextBox() {
		HighlightElement(CustDetailsZipCodeTextBox);
		return CustDetailsZipCodeTextBox.getAttribute("value");
	}
	
	public String getCustDetailsCountryTextBox() {
		HighlightElement(CustDetailsCountryTextBox);
		return CustDetailsCountryTextBox.getAttribute("value");
	}
	
	public String getCustDetailsAltPhoneNumberTextBox() {
		HighlightElement(CustDetailsAltPhoneNumberTextBox);
		return CustDetailsAltPhoneNumberTextBox.getAttribute("value");
	}
	
	public String getCustDetailsEmailTextBox() {
		HighlightElement(CustDetailsEmailTextBox);
		return CustDetailsEmailTextBox.getAttribute("value");
	}
	
	public String getCustDetailsStoreCreditTextBox() {
		HighlightElement(CustDetailsStoreCreditTextBox);
		return CustDetailsStoreCreditTextBox.getAttribute("value");
	}
	
	public String getCustDetailsPhoneNumberTextbox() {
		HighlightElement(CustDetailsPhoneNumberTextBox);
		return CustDetailsPhoneNumberTextBox.getAttribute("value");
	}
	
	public String getDisplayedCustDetailsCustomerType() {
		Select select = new Select(CustDetailsCustomerTypeDropDown);
				return select.getFirstSelectedOption().getText();
	}
	
	public boolean validateCustDetailsCreditApprovedToogle() {
		HighlightElement(CustDetailsCreditApprovedToogle);
		return CustDetailsCreditApprovedToogle.getAttribute("style").contains("rgb(223, 223, 223)");		
	}
	
	public boolean ValidateCustDetailsPaperlessStatementToogle() {
		HighlightElement(CustDetailsPaperlessStatementToogle);
		return CustDetailsPaperlessStatementToogle.getAttribute("style").contains("rgb(223, 223, 223)");		
	} 
	
	public boolean ValidateCustDetailsEmailStatementToogle() {
		HighlightElement(CustDetailsEmailSettingToogle);
		return CustDetailsEmailSettingToogle.getAttribute("style").contains("rgb(223, 223, 223)");	
	}
	
	public boolean ValidateCustDetailsEnableLoyaltyToogle() {
		HighlightElement(CustDetailsEnableLoyaltyToogle);
		return CustDetailsEnableLoyaltyToogle.getAttribute("style").contains("rgb(223, 223, 223)");		
	}
	
	public boolean ValidateCustDetailsLateFeeSettingToogle() {
		HighlightElement(CustDetailsLateFeeSettingToogle);
		return CustDetailsLateFeeSettingToogle.getAttribute("style").contains("rgb(223, 223, 223)");		
	}

	
	public boolean ValidateCustDetailsAllowFeedbackEmailTToogle() {
		HighlightElement(CustDetailsAllowFeedbackEmailToogle); // green background color 
		return CustDetailsAllowFeedbackEmailToogle.getAttribute("style").contains("rgb(197, 231, 244)");		
	}
	
	public void Click_CustomerId_OnCustomerTable() {
		for(int i = 0; i<ListOfCustomerID_OnCustomerTableRow.size(); i++) {
				jsClick(ListOfCustomerID_OnCustomerTableRow.getLast());
				break;
			}
		}
	
	public void SelectPagination_OnCustomerTable(String pagination) {
		fluentWait(CustomerDetails_PaginationDropDown);
		dropDown(CustomerDetails_PaginationDropDown, pagination, "VisibleText");
	}
	
	public String Verify_CreditCardNumber_OnCustomerDetailsPopup() {
		HighlightElement(CustDetailsPopup_CreditCardNo);
		return CustDetailsPopup_CreditCardNo.getText();
	}
	
	public String Verify_CreditCard_ExpiredDate_OnCustomerDetailsPopup() {
		HighlightElement(CustDetailsPopup_ExpiryDate);
		return CustDetailsPopup_ExpiryDate.getText();
	}
	
	public void Click_OnCreditCard_DeleteIcon_OnCustomerDetailsPopup() {
		click(CustDetailsPopup_CreditCard_DeleteIcon);
	}
	
	public void Click_OnCreditCard_DeleteIcon_DeleteConfirmation() {
		jsClick(CustDetailsPopup_CreditcardTab_DeleteIconAlert_OkButton);
	}
	
	public void click_CustomerId_Header_OnCustTable() {
		jsClick(CustomerIdColumn_header);
	}
	
	public boolean verify_custId_DescendingIcon() {
		return descendingIconOnCustomerIdColumn.isDisplayed();
	}
	
	public boolean verify_custId_AscendingIcon() {
		return ascendingIconOnCustomerIdColumn.isDisplayed();
	}
	
	
	public String get_CustomerId_OnCustTable() {
		return CustomerId_List_OnCustTable.get(0).getText();	
	}
	
	public void Enter_CustomerId_SearchTextBox_OnCustomerTable(String custId) {
		CustomerIdSearchBox.clear();
		CustomerIdSearchBox.sendKeys(custId);
		delayWithGivenTime(1000);
		CustomerIdSearchBox.sendKeys(Keys.ENTER);
	}

	public boolean Verify_DontSaveCreditCard_OnCustomerDetailsPopup() {
		int count = List_OfCustDetailsPopup_CreditCardNo.size();
		if(count<2) {
			return true;
		}else {
			return false;
		}
	}



}

