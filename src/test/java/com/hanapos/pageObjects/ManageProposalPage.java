package com.hanapos.pageObjects;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hanapos.seleniumProjectBase.TestBaseClass;

public class ManageProposalPage extends TestBaseClass {
	
	public ManageProposalPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="lblProposalId")
	private WebElement ProposalId;
	
	@FindBy(xpath="//a[@id='aCoupleDetails']")
	private WebElement coupleDetails_Tab;
	
	@FindBy(id="txtCustomerFirstName")
	private WebElement brideFirstName;
	
	@FindBy(id="txtCustomerLastName")
	private WebElement brideLastName;
	
	@FindBy(id="txtCustomerPhone")
	private WebElement bridePhoneNumber;
	
	@FindBy(id="txtCustomerEmail")
	private WebElement brideEmail;
	
	@FindBy(id="txtCustomerCity")
	private WebElement brideCity;
	
	@FindBy(id="txtCustomerState")
	private WebElement brideState;
	
	@FindBy(id="txtCustomerAddress")
	private WebElement brideAddress;
	
	@FindBy(id="txtCustomerZip")
	private WebElement brideZip;
	
	@FindBy(xpath="//select[@id='bride-groom']")
	private WebElement bride_Groom_DropDown1;
	
	@FindBy(xpath="//select[@id='bride-groom2']")
	private WebElement bride_Groom_DropDown2;
	
	@FindBy(id="txtAltFirstName")
	private WebElement groomFirstName;
	
	@FindBy(id="txtAltLastName")
	private WebElement groomLastName;
	
	@FindBy(id="txtAltPhone")
	private WebElement groomPhoneNumber;
	
	@FindBy(id="txtAltEmail")
	private WebElement groomEmail;
	
	@FindBy(id="txtAltCity")
	private WebElement groomCity;
	
	@FindBy(id="txtAltState")
	private WebElement groomState;
	
	@FindBy(id="txtAltAddress")
	private WebElement groomAddress;
	
	@FindBy(id="txtAltZip")
	private WebElement groomZip;
	
	@FindBy(id="aEventDetails")
	private WebElement Wedding_eventDetails_Tab;
	
	@FindBy(id="txtCeremonyLocation")
	private WebElement ceremonyLocation;
	
	@FindBy(id="txtCeremonyDate")
	private WebElement ceremonyDate;
	
	@FindBy(id="txtCeremonyTime")
	private WebElement ceremonyTime;
	
	@FindBy(id="txtCeremonyAddress")
	private WebElement ceremonyAddress;
	
	@FindBy(id="txtCeremonyZip")
	private WebElement ceremonyZip;
	
	@FindBy(id="txtCeremonyCity")
	private WebElement ceremonyCity;
	
	@FindBy(id="txtCeremonyState")
	private WebElement ceremonyState;
	
	@FindBy(id="txtReceptionLocation")
	private WebElement receptionLocation;
	
	@FindBy(id="txtReceptionDate")
	private WebElement receptionDate;
	
	@FindBy(id="txtReceptionTime")
	private WebElement receptionTime;
	
	@FindBy(id="txtReceptionAddress")
	private WebElement receptionAddress;
	
	@FindBy(id="txtReceptionZip")
	private WebElement receptionZip;
	
	@FindBy(id="txtReceptionCity")
	private WebElement receptionCity;
	
	@FindBy(id="txtReceptionState")
	private WebElement receptionState;
	
	@FindBy(id="txtWedCoFirstName")
	private WebElement weddingCoordinatorFirstName;
	
	@FindBy(id="txtWedCoLastName")
	private WebElement weddingCoordinatorLastName;
	
	@FindBy(id="txtWedCoPhone")
	private WebElement weddingCoordinatorPhoneNumber;
	
	@FindBy(id="txtWedCoEmail")
	private WebElement weddingCoordinatorEmail;
	
	@FindBy(id="txtWedCoCity")
	private WebElement weddingCoordinatorCity;
	
	@FindBy(id="txtWedCoState")
	private WebElement weddingCoordinatorState;
	
	@FindBy(id="txtWedCoAddress")
	private WebElement weddingCoordinatorAddress;
	
	@FindBy(id="txtWedCoZip")
	private WebElement weddingCoordinatorZip;
	
	@FindBy(id="aDocumentImages")
	private WebElement documentImagesTab;

	@FindBy(id="btnUploadProposalDocs")
	private WebElement browserFilesBtn;
	
	@FindBy(id="aItemsProducts")
	private WebElement items_ProductsTab;
	
	@FindBy(id="ddlCategory")
	private WebElement select_CategoryDropDown;
	
	@FindBy(id="CategoryWiseItem")
	private WebElement items_TextBox;
	
	@FindBy(xpath="//ul[@id='ui-id-4']//li//div")
	private List<WebElement> itemsList;
	
	@FindBy(id="btnAddItem")
	private WebElement addItemBtn_ItemsTab;
	
	@FindBy(xpath="//table[@id='tblPropPackItemsProducts']//tbody//tr[1]//td[1]//label//strong")
	private WebElement item_category_Row1;
	
	@FindBy(xpath="//table[@id='tblPropPackItemsProducts']//tbody//tr[1]//td[3]//div//label[1]")
	private WebElement item_Code_Row1;
	
	@FindBy(xpath="//table[@id='tblPropPackItemsProducts']//tbody//tr[1]//td[3]//div//p[1]")
	private WebElement item_description_Row1;
	
	@FindBy(xpath="//table[@id='tblPropPackItemsProducts']//tbody//tr[1]//td[3]//div//p[2]")
	private WebElement item_Quantity_Row1;

	@FindBy(xpath="//table[@id='tblPropPackItemsProducts']//tbody//tr[1]//td[3]//div//label[1]")
	private WebElement item_Price_In_Product_DetailsRow1;
	
	@FindBy(xpath="//table[@id='tblPropPackItemsProducts']//tbody//tr[1]//td[4]//label")
	private WebElement item_Total_price_Row1;
	
	@FindBy(xpath="//p[contains(text(),'Publish pending changes')]")
	private WebElement publishPendingChanges;
	
	@FindBy(xpath="(//label[@id='lblGrandTotal'])[1]")
	private WebElement grandTotal;
	
	@FindBy(xpath="//h2[text()='Publish pending changes']")
	private WebElement publishPendingChanges_AlertTitle;
	
	@FindBy(xpath="//button[@class='confirm']")
	private WebElement publish_Btn_On_AlertPopup;
	
	
	public String get_ManageProposalPageTitle() {
		return  getDriver().getTitle();
	}
	
	public void Click_CoupleDetailsTab() {
		click(coupleDetails_Tab);
	}
	
	public void Enter_Bride_FirstName(String firstName) {
		clickAndType(brideFirstName, firstName);
	}
	
	public String get_Entered_Bride_FirstName() {
		HighlightElement(brideFirstName);
		return brideFirstName.getAttribute("value").trim();
	}
	
	public void Enter_Bride_LastName(String lastName) {		
		clickAndType(brideLastName, lastName);
	}
	
	public String get_Entered_Bride_LastName() {
		HighlightElement(brideLastName);
		return brideLastName.getAttribute("value").trim();
	}
	
	public void Enter_Bride_PhoneNumber(String phonenumber) {
		clickAndType(bridePhoneNumber, phonenumber);
	}
	
	public String get_Entered_Bride_PhoneNumber() {
		HighlightElement(bridePhoneNumber);
		return bridePhoneNumber.getAttribute("value").trim();
	}
	
	public void Enter_Bride_Email(String email) {
		clickAndType(brideEmail, email);
	}
	
	public String get_Entered_Bride_Email() {
		HighlightElement(brideEmail);
		return brideEmail.getAttribute("value").trim();
	}
	
	public void Enter_Bride_City(String city) {
		clickAndType(brideCity, city);
	}
	
	public String get_Entered_Bride_City() {
		HighlightElement(brideCity);
		return brideCity.getAttribute("value").trim();
	}
	
	public void Enter_Bride_State(String state) {
		clickAndType(brideState, state);
	}
	
	public String get_Entered_Bride_State() {
		HighlightElement(brideState);
		return brideState.getAttribute("value").trim();
	}
	
	public void Enter_Bride_Address(String address) {
		clickAndType(brideAddress, address);
	}
	
	public String get_Entered_Bride_Address() {
		HighlightElement(brideAddress);
		return brideAddress.getAttribute("value").trim();
	}
	
	public void Enter_Bride_Zip(String zip) {
		clickAndType(brideZip, zip);
	}
	
	public String get_Entered_Bride_Zip() {
		HighlightElement(brideZip);
		return brideZip.getAttribute("value").trim();
	}	
	
	public void Select_Bride_Groom_DropDown1(String value) {
		dropDown(bride_Groom_DropDown1, value,"VisibleText");
	}
	
	public void Select_Bride_Groom_DropDown2(String value) {
		dropDown(bride_Groom_DropDown2, value,"VisibleText");
	}
	
	public void Enter_Groom_FirstName(String firstName) {
		clickAndType(groomFirstName, firstName);
	}
	
	public String get_Entered_Groom_FirstName() {
		HighlightElement(groomFirstName);
		return groomFirstName.getAttribute("value").trim();
	}
	
	public void Enter_Groom_LastName(String lastName) {
		clickAndType(groomLastName, lastName);
	}
	
	public String get_Entered_Groom_LastName() {
		HighlightElement(groomLastName);
		return groomLastName.getAttribute("value").trim();
	}
	
	public void Enter_Groom_PhoneNumber(String phonenumber) {
		clickAndType(groomPhoneNumber, phonenumber);
	}
	
	public String get_Entered_Groom_PhoneNumber() {
		HighlightElement(groomPhoneNumber);
		return groomPhoneNumber.getAttribute("value").trim();
	}
	
	public void Enter_Groom_Email(String email) {
		clickAndType(groomEmail, email);
	}
	
	public String get_Entered_Groom_Email() {
		HighlightElement(groomEmail);
		return groomEmail.getAttribute("value").trim();
	}
	
	public void Enter_Groom_City(String city) {
		delayWithGivenTime(1000);
		jsClearAndType(groomCity, city);
	}
	
	public String get_Entered_Groom_City() {
		HighlightElement(groomCity);
		return groomCity.getAttribute("value").trim();
	}
	
	public void Enter_Groom_State(String state) {
		jsClearAndType(groomState, state);
	}
	
	public String get_Entered_Groom_State() {
		HighlightElement(groomState);
		return groomState.getAttribute("value").trim();
	}
	
	public void Enter_Groom_Address(String address) {
		jsClearAndType(groomAddress, address);
	}
	
	public String get_Entered_Groom_Address() {
		HighlightElement(groomAddress);
		return groomAddress.getAttribute("value").trim();
	}
	
	public void Enter_Groom_Zip(String zip) {
		jsClearAndType(groomZip, zip);
	}
	
	public String get_Entered_Groom_Zip() {
		HighlightElement(groomZip);
		return groomZip.getAttribute("value").trim();
	}
	
	public void Click_Weddings_eventDetails_Tab() {
		jsClick(Wedding_eventDetails_Tab);
	}	
	public void Enter_CeremonyLocation(String location) {
		clickAndType(ceremonyLocation, location);
	}
	
	public String get_Entered_CeremonyLocation() {
		HighlightElement(ceremonyLocation);
		return ceremonyLocation.getAttribute("value").trim();
	}
	
	public void Enter_CeremonyDate_WithInNext30Days() {
		LocalDate currentDate = LocalDate.now();
		LocalDate nextDay = currentDate.plusDays(30);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedNextDay = nextDay.format(formatter);
		jsClearAndType(ceremonyDate, formattedNextDay); 
	}
	
	public String get_Entered_CeremonyDate() {
		HighlightElement(ceremonyDate);
		return ceremonyDate.getAttribute("value").trim();
	}
	
	public void Enter_CeremonyTime() {
		LocalTime time730PM = LocalTime.of(19, 30);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		String formattedTime = time730PM.format(formatter);
		delayWithGivenTime(500);
		jsClearAndType(ceremonyTime,formattedTime);
	}
	
	public String get_Entered_CeremonyTime() {
		HighlightElement(ceremonyTime);
		return ceremonyTime.getAttribute("value").trim();
	}
	
	public void Enter_Ceremony_Address(String address) {
		clickAndType(ceremonyAddress, address);
	}
	
	public String get_Entered_Ceremony_Address() {
		HighlightElement(ceremonyAddress);
		return ceremonyAddress.getAttribute("value").trim();
	}
	
	public void Enter_Ceremony_Zip(String zip) {
		clickAndType(ceremonyZip, zip);
	}
	
	public String get_Entered_Ceremony_Zip() {
		HighlightElement(ceremonyZip);
		return ceremonyZip.getAttribute("value").trim();
	}
	
	public void Enter_Ceremony_City(String city) {
		clickAndType(ceremonyCity, city);
	}
	
	public String get_Entered_Ceremony_City() {
		HighlightElement(ceremonyCity);
		return ceremonyCity.getAttribute("value").trim();
	}
	
	public void Enter_Ceremony_State(String state) {
		clickAndType(ceremonyState, state);
	}
	
	public String get_Entered_Ceremony_State() {
		HighlightElement(ceremonyState);
		return ceremonyState.getAttribute("value").trim();
	}
	
	public void Enter_ReceptionLocation(String location) {
		clickAndType(receptionLocation, location);
	}
	
	public String get_Entered_ReceptionLocation() {
		HighlightElement(receptionLocation);
		return receptionLocation.getAttribute("value").trim();
	}
	
	public void Enter_ReceptionDate_WithInNext30Days() {
		LocalDate currentDate = LocalDate.now();
		LocalDate nextDay = currentDate.plusDays(30);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedNextDay = nextDay.format(formatter);
		jsClearAndType(receptionDate, formattedNextDay); 
	}
	
	public String get_Entered_ReceptionDate() {
		HighlightElement(receptionDate);
		return receptionDate.getAttribute("value").trim();
	}
	
	public void Enter_ReceptionTime() {
		LocalTime time730PM = LocalTime.of(19, 30);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		String formattedTime = time730PM.format(formatter);
		delayWithGivenTime(500);
		jsClearAndType(receptionTime,formattedTime);
	}
	
	public String get_Entered_ReceptionTime() {
		HighlightElement(receptionTime);
		return receptionTime.getAttribute("value").trim();
	}
	
	public void Enter_Reception_Address(String address) {
		clickAndType(receptionAddress, address);
	}
	
	public String get_Entered_Reception_Address() {
		HighlightElement(receptionAddress);
		return receptionAddress.getAttribute("value").trim();
	}
	
	public void Enter_Reception_Zip(String zip) {
		clickAndType(receptionZip, zip);
	}
	
	public String get_Entered_Reception_Zip() {
		HighlightElement(receptionZip);
		return receptionZip.getAttribute("value").trim();
	}
	
	public void Enter_Reception_City(String city) {
		clickAndType(receptionCity, city);
	}
	
	public String get_Entered_Reception_City() {
		HighlightElement(receptionCity);
		return receptionCity.getAttribute("value").trim();
	}
	
	public void Enter_Reception_State(String state) {
		clickAndType(receptionState, state);
	}
	
	public String get_Entered_reception_State() {
		HighlightElement(receptionState);
		return receptionState.getAttribute("value").trim();
	}
	
	public void Enter_WeddingCoordinator_FirstName(String firstName) {
		clickAndType(weddingCoordinatorFirstName, firstName);
	}
	
	public String get_Entered_WeddingCoordinator_FirstName() {
		HighlightElement(weddingCoordinatorFirstName);
		return weddingCoordinatorFirstName.getAttribute("value").trim();
	}
	
	public void Enter_WeddingCoordinator_LastName(String lastName) {		
		clickAndType(weddingCoordinatorLastName, lastName);
	}
	
	public String get_Entered_WeddingCoordinator_LastName() {
		HighlightElement(weddingCoordinatorLastName);
		return weddingCoordinatorLastName.getAttribute("value").trim();
	}
	
	public void Enter_WeddingCoordinator_PhoneNumber(String phonenumber) {
		clickAndType(weddingCoordinatorPhoneNumber, phonenumber);
	}
	
	public String get_Entered_WeddingCoordinator_PhoneNumber() {
		HighlightElement(weddingCoordinatorPhoneNumber);
		return weddingCoordinatorPhoneNumber.getAttribute("value").trim();
	}
	
	public void Enter_WeddingCoordinator_Email(String email) {
		jsClearAndType(weddingCoordinatorEmail, email);
	}
	
	public String get_Entered_WeddingCoordinator_Email() {
		HighlightElement(weddingCoordinatorEmail);
		return weddingCoordinatorEmail.getAttribute("value").trim();
	}
	
	public void Enter_WeddingCoordinator_City(String city) {
		jsClearAndType(weddingCoordinatorCity, city);
	}
	
	public String get_Entered_WeddingCoordinator_City() {
		HighlightElement(weddingCoordinatorCity);
		return weddingCoordinatorCity.getAttribute("value").trim();
	}
	
	public void Enter_WeddingCoordinator_State(String state) {
		jsClearAndType(weddingCoordinatorState, state);
	}
	
	public String get_Entered_WeddingCoordinator_State() {
		HighlightElement(weddingCoordinatorState);
		return weddingCoordinatorState.getAttribute("value").trim();
	}
	
	public void Enter_WeddingCoordinator_Address(String address) {
		jsClearAndType(weddingCoordinatorAddress, address);
	}
	
	public String get_Entered_WeddingCoordinator_Address() {
		HighlightElement(weddingCoordinatorAddress);
		return weddingCoordinatorAddress.getAttribute("value").trim();
	}
	
	public void Enter_WeddingCoordinator_Zip(String zip) {
		jsClearAndType(weddingCoordinatorZip, zip);
	}
	
	public String get_Entered_WeddingCoordinator_Zip() {
		HighlightElement(weddingCoordinatorZip);
		return weddingCoordinatorZip.getAttribute("value").trim();
	}	
	
	public void Click_DocumentsAndImages_Tab() {
		jsClick(documentImagesTab);
	}
	
	public void Click_BrowseFiles_To_UploadFiles_Using_DragAndDrop(String filePath) {
		uploadFile(browserFilesBtn, filePath);
	}
	
	public void UploadFiles(String filename) {
		
		String projectPath = System.getProperty("user.dir");
	    String fullFilePath = projectPath + File.separator + "testFiles" + File.separator + filename;	
		
	    uploadFile(browserFilesBtn, fullFilePath);
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 * js.executeScript("arguments[0].style.display = 'block';", browserFilesBtn);
		 * browserFilesBtn.sendKeys(fullFilePath);
		 */
	}

	public void Click_ItemsAndProducts_Tab() {
		click(items_ProductsTab);
	}
	
	public void Select_CategoryDropdown_On_ItemsAndProducts(String category) {
		dropDown(select_CategoryDropDown, category,"VisibleText");
	}
	
	public void Enter_ItemName_On_ItemsAndProducts(String itemName,String itemdescription) {
		clickAndType(items_TextBox, itemName);
		delayWithGivenTime(3000);
		for(WebElement ele : itemsList) {
			if(ele.getText().contains(itemdescription)) {
				click(ele);
				break;
			}
		}
	}
	
	public void Click_AddBtn_On_ItemsAndProducts() {
		click(addItemBtn_ItemsTab);
	}
	
	public String get_Row1_ItemCategory() {
		HighlightElement(item_category_Row1);
		return 	item_category_Row1.getText();
	}
	
	public void Click_Publish_Pending_Changes() {
		click(publishPendingChanges);
	}
	
	public String get_row1_itemCode() {
		HighlightElement(item_Code_Row1);
		return item_Code_Row1.getText();
	}
	
	public String get_row1_itemDescription() {
		HighlightElement(item_description_Row1);
		return item_description_Row1.getText();
	}
	
	public String get_row1_itemQuantity() {
		HighlightElement(item_Quantity_Row1);
		return item_Quantity_Row1.getText();
	}
	
	public String get_row1_itemPrice_InProductDetails() {
		HighlightElement(item_Price_In_Product_DetailsRow1);
		return item_Price_In_Product_DetailsRow1.getText().trim();
	}
	
	public String get_row1_item_TotalPrice() {
		HighlightElement(item_Total_price_Row1);
		return item_Total_price_Row1.getText().trim();
	}
	
	public String get_GrandTotal() {
		HighlightElement(grandTotal);
		return grandTotal.getText().trim();
	}
	
	public boolean Verify_Proposal_Pending_Changes_AlertIsDisplayed() {
		HighlightElement(publishPendingChanges);
		return (publishPendingChanges.isDisplayed());
	}
	
	public void Click_PublishBtn_On_AlertPopup() {
		click(publish_Btn_On_AlertPopup);
	}
	
	public String get_ProposalId() {
		HighlightElement(ProposalId);
		return ProposalId.getText();
	}
	
}
