package com.hanapos.pageObjects;

import java.util.List;

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
	
	@FindBy(xpath="//input[@data-text-field='CustomerName']")
	private WebElement CustomerNameSearchBox;
	
	@FindBy(xpath="(//input[@data-text-field='CityStateZip'])[1]")
	private WebElement CustomerCityStateZipSearchBox;
	
	@FindBy(xpath="(//ul[@class='k-list k-reset'])[5]//li")
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
	private WebElement CustTable_CustomerID;
	
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
	
	public void ClickCustomerIdOnCustTable() {
		fluentWait(CustTable_CustomerID);
		jsClick(CustTable_CustomerID);
	}
	
	public void Search_and_SelectCustomerName(String customerName, String expectedcustomername) {
		CustomerNameSearchBox.click();
		delayWithGivenTime(1000);
		DoubleClickAndType(CustomerNameSearchBox, customerName);
		delayWithGivenTime(3000);
		for (WebElement customer : CustomerList) {
	        if (customer.getText().contains(expectedcustomername)) {
	        	click(customer);
	            break;
	        }
	    }
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
		return CustDetailsCityTextBox.getAttribute("value");
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
			ListOfCustomerID_OnCustomerTableRow.getLast().click();
				break;
			}
		}
	
	public void SelectPagination_OnCustomerTable(String pagination) {
		fluentWait(CustomerDetails_PaginationDropDown);
		dropDown(CustomerDetails_PaginationDropDown, pagination, "VisibleText");
	}
	}

