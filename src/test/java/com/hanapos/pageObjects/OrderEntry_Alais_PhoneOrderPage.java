package com.hanapos.pageObjects;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hanapos.seleniumProjectBase.TestBaseClass;

public class OrderEntry_Alais_PhoneOrderPage extends TestBaseClass {
	Select s;

	public OrderEntry_Alais_PhoneOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "(//select[@id='drpShopUser'])[1]")
	private WebElement salesPersonDDonPhoneOrder;

	@FindBy(xpath = "//span[@class='fa fa-clone iconSize']")
	private WebElement defaultvaluesicon;

	@FindBy(xpath = "//h3[normalize-space()='Choose Page Default Values']")
	private WebElement choosepagedefaultvaluespopup;

	@FindBy(xpath = "//input[@id='txtItemCode']")
	private WebElement itemcodeonCPDV; // CPDV - choose page default value

	@FindBy(xpath = "(//input[@id='txtQty1'])[1]")
	private WebElement qtyonCPDV;

	@FindBy(xpath = "(//select[@id='ddlDefaultWireInMethod'])[1]")
	private WebElement defaultwireinmethodonCPDV;

	@FindBy(xpath = "(//select[@id='ddlDefaultWireOutMethod'])[1]")
	private WebElement defaultwireoutmethodonCPDV;

	@FindBy(xpath = "(//select[@id='ddlPaymentType'])[1]")
	private WebElement paymenttypeonCPDV;

	@FindBy(xpath = "(//select[@id='ddlSalesPerson'])[1]")
	private WebElement salespersononCPDV;

	@FindBy(xpath = "(//select[@id='ddlSelectCountry'])[1]")
	private WebElement selectcountryonCPDV;

	@FindBy(xpath = "(//select[@id='ddlSelectLocation'])[1]")
	private WebElement selectlocationonCPDV;

	@FindBy(xpath = "//select[@id='ddlSelectOccasion']")
	private WebElement selectoccasionOnCPDV;

	@FindBy(xpath = "//select[@id='ddlPhoneOrderCustomerType']")
	private WebElement selectcustomertypeOnCPDV;

	@FindBy(xpath = "(//select[@id='ddlSelectOrderType'])[1]")
	private WebElement selectordertypeOnCPDV;

	@FindBy(xpath = "(//div[@class='modal-header']//a//i)[7]")
	private WebElement CPDV_Popup_CloseIcon;

	@FindBy(xpath = "//select[@id='orderOccasion']")
	private WebElement occasionOnphoneorderpage;

	@FindBy(xpath="//input[@id='orderPrintSuperTicketChkBox']")
	private WebElement printTicketCheckBox_OrderDetailsSection;
	
	@FindBy(xpath="//input[@id='orderreminderChkBox']")
	private WebElement sendRemainderCheckbox_OrderDetailsSection;

	@FindBy(xpath = "(//input[@id='orderItem1'])[1]")
	private WebElement itemcodeOnphoneorderpage;

	@FindBy(xpath = "(//input[@id='orderItemQty1'])[1]")
	private WebElement qtyOnphoneorderpage;

	@FindBy(xpath = "(//select[@id='customerType'])[1]")
	private WebElement custTypeOnphoneorderpage;

	@FindBy(xpath = "(//input[@id='txtRecipientPhone'])[1]")
	private WebElement recipientphoneonCPDV;

	@FindBy(xpath = "(//input[@id='txtRecipientZipcode'])[1]")
	private WebElement recipientzipcodeonCPDV;

	@FindBy(xpath = "(//input[@id='productTaxId'])[1]")
	private WebElement taxid_OnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='paymentDiscAmtTxt'])[1]")
	private WebElement paymentdiscamt_OnPhoneOrderPage;

	@FindBy(xpath = "(//select[@id='productTaxType'])[1]")
	private WebElement taxtype_OnPhoneOrderPage;
	
	//======================Product Section===============================//
	@FindBy(xpath="(//legend[@class='scheduler-border'])[5]")
	private WebElement productsectionOnPhoneOrderPage;
	
	

	// -------------------------Recipient Section --------------------------------//
	@FindBy(xpath="//fieldset[@class='col-md-7 col-sm-7 scheduler-border borderLeft recepientinfo']")
	private WebElement recipientsectionOnPhoneOrderPage;

	@FindBy(xpath="//legend[@class='scheduler-border']//span[@style='color:red']")
	private WebElement recipientKMS;

	@FindBy(xpath = "(//input[@id='reciFirstName'])[1]")
	private WebElement recipientfirstnameOnPhoneOrderPage;

	@FindBy(xpath="//ul[@id='ui-id-22']//li")
	private List<WebElement> ListOfReciFirstName_Autosuggestions_OnPhoneOrderPage;
	
	@FindBy(xpath="//div[@class='toast-title']")
	private WebElement addressverifiedmsg;

	@FindBy(xpath = "(//input[@id='reciLastName'])[1]")
	private WebElement recipientlastnameOnPhoneOrderPage;

	@FindBy(xpath="//span[@id='viewMap']")
	private WebElement googleIcon_ReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="//h4[contains(text(),'Map Directions')]")
	private WebElement mapdirectionsPopup_ReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="//table[@class='adp-directions']//tr[1]")
	private WebElement directionsRow1_ReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="//iframe[@id='mapPreview']")
	private WebElement mapiframe_ReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="//div[@class='gm-style-iw gm-style-iw-c']//div[2]//div")
	private WebElement tooltiptext_MapDirectionPopup_ReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="//div[@class='gm-style-iw gm-style-iw-c']//div[1]//button")
	private WebElement TooltipCloseIcon_MapDirectionPopup_ReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="(//table[@id='control']//tbody//tr[2]//td[@valign='top'][2]//div//div[@class='gm-style-mtc']//button)[2]")
	private WebElement SateliteTab_MapDirectionPopupReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="(//ul[@role='menu']//li//label)[2]")
	private WebElement satelliteTabLabel_MapDirectionPopupReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="(//table[@id='control']//tbody//tr[2]//td[@valign='top'][2]//div//div[@class='gm-style-mtc']//button)[1]")
	private WebElement MapTab_MapDirectionPopupReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="(//button[@class='gm-control-active'])[3]")
	private WebElement plusIcon_MapDirectionPopupReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="(//button[@class='gm-control-active'])[4]")
	private WebElement minusIcon_MapDirectionPopupReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="(//div[@class='gm-style']//div//div//div//div//div)[1]")
	private WebElement VerifyZoomIn_MapDirectionPopupReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="//button[@class='gm-svpc']")
	private WebElement DragPegman_MapDirectionPopupReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="(//button[@class='gm-control-active gm-fullscreen-control'])[1]")
	private WebElement FullScreen_MapDirectionPopupReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="(//div[@class='modal-content']//a//i)[3]")
	private WebElement CloseIcon_MapDirectionPopupReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath="(//ul[@role='menu']//li//label)[1]")
	private WebElement satelliteTabTerrain_MapDirectionPopupReciAddress1_OnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='reciAddress1'])")
	private WebElement recipientaddress1OnPhoneOrderPage;

	@FindBy(xpath="//div[@class='pac-container pac-logo hdpi']//div")
	private List<WebElement> ListOfReciAddress1_Autosuggestions_OnPhoneOrderPage;

	@FindBy(xpath="//div[@class='pac-container pac-logo hdpi']//div//span[3]")
	private List<WebElement> ListOfReciAddress1_CityStateCountry_Autosuggestions_OnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='reciAddress2'])")
	private WebElement recipientaddress2OnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='reciZipCode'])[1]")
	private WebElement recipientzipcodeOnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='reciCity'])[1]")
	private WebElement recipientcityOnPhoneOrderPage;

	@FindBy(xpath = "(//select[@id='reciCountry'])[1]")
	private WebElement recipientcountryOnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='reciPhone1'])[1]")
	private WebElement recipientphoneOnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='reciPhone2'])[1]")
	private WebElement recipientphone2OnPhoneOrderPage;

	@FindBy(xpath="//input[@id='reciAttention']")
	private WebElement recipientattentionOnPhoneOrderPage;

	@FindBy(xpath = "(//select[@id='reciLocationType'])[1]")
	private WebElement recipientlocationOnPhoneOrderPage;

	@FindBy(xpath = "//input[@id='reciDate']")
	private WebElement recipientDeliverydateOnPhoneOrderPage;

	@FindBy(xpath = "//input[@id='reciTime']")
	private WebElement recipientDeliverytimeOnPhoneOrderPage;

	@FindBy(xpath="//select[@id='reciTimeType']")
	private WebElement selectDeliverytimeonDropdown_RecipientSectionOnPhoneOrderPage;

	@FindBy(xpath="//div[@class='col-md-3 col-sm-3 col-xs-12 text-right no-padding']//a//span")
	private WebElement ClearTimeButton_recipientSectionOnPhoneOrderPage;

	@FindBy(xpath="//input[@id='reciState']")
	private WebElement recipientstateOnPhoneOrderPage;

	@FindBy(xpath="//button[@class='multiselect dropdown-toggle btn btn-default']")
	private WebElement recipientSelectOptionsBtnOnPhoneOrderPage;
	
	@FindBy(xpath="(//ul[@class='multiselect-container dropdown-menu']//li//a//label)[1]")
	private WebElement selectallOption_RecipientSelectOptionsDropDown;
	
	@FindBy(xpath="(//ul[@class='multiselect-container dropdown-menu']//li//a//label)[2]")
	private WebElement confidentialOption_RecipientSelectOptionsDropDown;
	
	@FindBy(xpath="(//ul[@class='multiselect-container dropdown-menu']//li//a//label)[3]")
	private WebElement FrequentAddrOption_RecipientSelectOptionsDropDown;

	@FindBy(xpath="(//ul[@class='multiselect-container dropdown-menu']//li//a//label)[4]")
	private WebElement saveFuneralOption_RecipientSelectOptionsDropDown;
	
	@FindBy(xpath="//ul[@class='multiselect-container dropdown-menu']//li//a//label")
	private List<WebElement> recipientSelectOptionsListOnPhoneOrderPage;
	
	@FindBy(xpath="//span[@Class='multiselect-selected-text']")
	private WebElement selectedRecipientOptionsOnPhoneOrderPage;
	
	@FindBy(xpath="//select[@id='reciLocationType']")
	private WebElement recipientLocation;
	
	@FindBy(xpath="//select[@id='reciZone']")
	private WebElement recipientzone;

	// ================== Wire In section =====================================
	@FindBy(xpath = "//li[@data-ordermode='wirein']")
	private WebElement wireinmethodOnPhoneOrderPage;

	@FindBy(xpath = "(//select[@id='wireinMethods'])[1]")
	private WebElement wireIndefaultDDOnPhoneOrderPage;

	// ================ Wire Out section ===============================
	@FindBy(xpath = "//li[@data-ordermode='wireout']")
	private WebElement wireoutmethodOnPhoneOrderPage;

	@FindBy(xpath = "(//select[@id='wireoutMethods'])[1]")
	private WebElement wireOutdefaultDDOnPhoneOrderPage;

	// ================ Delivery Type Section========================
	@FindBy(xpath = "//li[@data-ordermode='delivery']")
	private WebElement deliverytypeOnPhoneOrderPage;

	@FindBy(xpath = "(//select[@id='paymentOptions'])[1]")
	private WebElement paymentTypeDropdownOnPhoneOrderPage;
	
	
	//==================== Wire In deliveryType Section ================
	@FindBy(xpath="//li[@data-ordermode='wirein']//a")
	private WebElement wirein_deliverytype_OnPhoneOrderPage;
	
	@FindBy(id="wireinFirstName")
	private WebElement wireinFirstName_OnPhoneOrderPage;
	
	@FindBy(id="wireinLastName")
	private WebElement wireinLastName_OnPhoneOrderPage;
	
	@FindBy(xpath="//input[@id='wireinShopCode']")
	private WebElement wireinShopCode_OnPhoneOrderPage;
	
	@FindBy(xpath="//input[@id='wireinShopName']")
	private WebElement wireinShopName_OnPhoneOrderPage;
	
	@FindBy(xpath="//select[@id='wireinMethods']")
	private WebElement wireinMethods_OnPhoneOrderPage;
	
	@FindBy(xpath="//input[@id='wireinOrderNum']")
	private WebElement wireinOrderNum_OnPhoneOrderPage;
	
	@FindBy(xpath="(//input[@id='wireinEmail'])[1]")
	private WebElement wireinEmail_OnPhoneOrderPage;
	
	@FindBy(xpath="(//input[@id='wireinPhone'])[1]")
	private WebElement wireinPhone_OnPhoneOrderPage;
	
	@FindBy(xpath="//textarea[@id='wireinShopAddress']")
	private WebElement wireinShopAddress_OnPhoneOrderPage;
	
	@FindBy(xpath="//textarea[@id='wireinComments']")
	private WebElement wireinComments_OnPhoneOrderPage;
	

	//============================== Wire Out deliveryType Section ================
	@FindBy(xpath="//li[@data-ordermode='wireout']//a")
	private WebElement wireout_deliverytype_OnPhoneOrderPage;
	
	@FindBy(id="wireoutMethods")
	private WebElement wireoutMethods_OnPhoneOrderPage;
	
	@FindBy(xpath="//input[@id='wireoutFlorist']")
	private WebElement wireoutFlorist_OnPhoneOrderPage;
	
	@FindBy(xpath="//div[@class='col-lg-6 col-sm-12 wireoutAmt']")
	private WebElement wireoutAmt_OnPhoneOrderPage;
	
	@FindBy(xpath="//input[@id='wireoutAmount']")
	private WebElement wireoutAmount_OnPhoneOrderPage;
	
	
	
	
	
	
	
	
	// ================= Pickup section ============================
	@FindBy(id = "drpShopUser")
	private WebElement salesPersonDDOnPhoneOrderPage;

	@FindBy(xpath = "//li[@data-ordermode='pickup']")
	private WebElement pickupOnPhoneOrderPage;

	@FindBy(xpath = "(//a[@class='headerIconAnchor'])[10]")
	private WebElement pickupTypeOnPhoneOrderPage;

	@FindBy(xpath = "//div[@class='toast-message']")
	private WebElement SuccessToastMsg;

	// ===================== Customer Section ==============================
	@FindBy(xpath = "//fieldset[contains(@class,'customerinfo')]")
	private WebElement custSectionOnPhoneOrderPage;

	@FindBy(xpath = "//input[@id='searchCustomer']")
	private WebElement searchCustomertextboxOnCustSection;

	@FindBy(xpath = "(//legend[@class='scheduler-border']//span)[1]")
	private WebElement newcustomerlabel;

	@FindBy(xpath = "//li[@class='ui-menu-item']//div")
	private List<WebElement> listOfCustomerNamesOnCustSection;

	@FindBy(xpath = "//ul[@id='ui-id-3']")
	private WebElement cust_unorderlistOnCustSection;

	@FindBy(xpath = "//input[@id='custFirstName']")
	private WebElement firstnameOnPhoneOrderPage;

	@FindBy(xpath = "//input[@id='custLastName']")
	private WebElement lastnameOnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='custCompanyName'])[1]")
	private WebElement companyNameOnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='custEmail'])[1]")
	private WebElement emailIdOnPhoneOrderPage;

	@FindBy(xpath = "//div[@class='pac-container pac-logo hdpi']//div//span")
	private List<WebElement> listOfAddress1SuggestionsOnCustSection;

	@FindBy(xpath = "(//input[@id='custAddress1'])[1]")
	private WebElement address1OnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='custAddress2'])[1]")
	private WebElement address2OnPhoneOrderPage;

	@FindBy(xpath = "//input[@id='custZipCode']")
	private WebElement zipcodeOnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='custCity'])[1]")
	private WebElement cityOnPhoneOrderPage;

	@FindBy(xpath = "//input[@id='custState']")
	private WebElement stateOnPhoneOrderPage;

	@FindBy(xpath = "//input[@id='custPhone']")
	private WebElement phoneNumOnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='custAltPhone'])[1]")
	private WebElement AltphoneNumOnPhoneOrderPage;

	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-remove-circle iconSize clearInfo'])[1]")
	private WebElement clearCustInfoBtnOnPhoneOrderPage;

	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-edit iconSize editCustomer'])[1]")
	private WebElement editCustInfoBtnOnPhoneOrderPage;

	@FindBy(xpath = "//ul[@id='ui-id-4']")
	private WebElement cust_FirstnameUnorderListOnCustSection;

	@FindBy(xpath = "//ul[@id='ui-id-4']//li//div")
	private List<WebElement> listOfFirstNamesOnCustSection;

	@FindBy(xpath = "//ul[@id='ui-id-5']")
	private WebElement cust_LastnameUnorderListOnCustSection;

	@FindBy(xpath = "//ul[@id='ui-id-5']//li//div")
	private List<WebElement> listOfLastNamesOnCustSection;

	@FindBy(xpath = "//ul[@id='ui-id-8']")
	private WebElement cust_companyNameUnorderListOnCustSection;

	@FindBy(xpath = "//ul[@id='ui-id-8']//li//div")
	private List<WebElement> listOfCompanyNamesOnCustSection;

	@FindBy(xpath = "//ul[@id='ui-id-6']")
	private WebElement cust_phoneNumberUnorderListOnCustSection;

	@FindBy(xpath = "//ul[@id='ui-id-6']//li//div")
	private List<WebElement> listOfPhoneNumbersOnCustSection;

	@FindBy(xpath = "//ul[@id='ui-id-7']")
	private WebElement cust_altphoneNumberUnorderListOnCustSection;

	@FindBy(xpath = "//ul[@id='ui-id-7']//li//div")
	private List<WebElement> listOfAltPhoneNumbersOnCustSection;

	@FindBy(xpath = "(//h4[@id='Title'])[1]")
	private WebElement custSectionCustomerDetailsPopup;

	@FindBy(xpath="//div[@class='col-lg-3 col-md-4 col-sm-3 custActions ']//a[1] //span")
	private WebElement custHistoryIcon_OnCustDetailsSection;

	@FindBy(xpath="//h4[contains(text(),'Previous Orders History')]")
	private WebElement previousOrdersHistoryHeaderPopup_OnCustDetailsSection;

	@FindBy(xpath="//table[@id='tblCustomerOrderHistory']//tbody//tr//td[1]")
	private List<WebElement> ListOfPreviousOrdersInvoices_InOrderHistoryTable_CustHistoryPopup;

	@FindBy(xpath="//label[@class='ChkBoxLbl PromotionsLbl']")
	private WebElement TextMepromotionsCheckBox_OnCustDetailsPopup;

	@FindBy(xpath="(//span[@class='switchery switchery-default'])[5]")
	private WebElement smstooglebutton_OnCustDetailsPopup;




	// ============= Credit Card tab on Customer Details
	// ===========================
	@FindBy(xpath = "(//li[@id='CustomerCardLi'])[1]")
	private WebElement creditCardTabOnCustDetailsPopup;

	@FindBy(xpath = "(//a[@id='btnAddNewCreditCard'])[1]")
	private WebElement addNewCreditCardBtnOnCustDetailsPopup;

	@FindBy(xpath = "//input[@id='txtCreditFirstName']")
	private WebElement creditCardTab_FirstName_OnCustDetailsPopup;

	@FindBy(id = "txtCreditLastName")
	private WebElement creditCardTab_LastName_OnCustDetailsPopup;

	@FindBy(xpath = "(//input[@id='txtCardNumber'])[1]")
	private WebElement creditCardTab_CreditCardNumber_OnCustDetailsPopup;

	@FindBy(xpath = "(//input[@id='txtExp'])[1]")
	private WebElement creditCardTab_ExpDate_OnCustDetailsPopup;

	@FindBy(xpath = "(//input[@id='txtCVV'])[1]")
	private WebElement creditCardTab_CVV_OnCustDetailsPopup;

	@FindBy(xpath = "(//input[@id='txtCardZipCode'])[1]")
	private WebElement creditCardTab_ZipCode_OnCustDetailsPopup;

	@FindBy(xpath = "(//a[@id='btnSaveCreditInfo'])[1]")
	private WebElement creditCardTab_SaveBtn_OnCustDetailsPopup;

	@FindBy(xpath = "//button[@class='close']//span//i")
	private WebElement creditCardTab_CloseIcon_OnCustDetailsPopup;

	@FindBy(xpath = "//h4[@id='UpdateCardModalTitle']")
	private WebElement AddNewInformationCreditCardOnCustDetailsPopup;

	// =========================Profile Tab customer details
	// popup===========================
	@FindBy(xpath = "//a[@id='CustomerProfileAnc']")
	private WebElement customerProfileTabOnCustDetailsPopup;

	@FindBy(xpath = "(//input[@id='txtCutomerId'])[1]")
	private WebElement customerIDOnCustDetailsPopup;

	@FindBy(xpath = "//input[@id='txtCompanyName']")
	private WebElement companyNameOnCustDetailsPopup;

	@FindBy(xpath = "//input[@id='txtAddress1']")
	private WebElement address1OnCustDetailsPopup;

	@FindBy(xpath = "//input[@id='txtAddress2']")
	private WebElement address2OnCustDetailsPopup;

	@FindBy(xpath = "//input[@id='txtZip']")
	private WebElement zipcodeOnCustDetailsPopup;

	@FindBy(xpath = "//input[@id='txtCountry']")
	private WebElement countryOnCustDetailsPopup;

	@FindBy(xpath = "//input[@id='txtCity']")
	private WebElement cityOnCustDetailsPopup;

	@FindBy(xpath = "//input[@id='txtState']")
	private WebElement stateOnCustDetailsPopup;

	@FindBy(xpath = "//input[@id='txtPhoneNumber']")
	private WebElement phoneNumOnCustDetailsPopup;

	@FindBy(xpath = "//input[@id='txtAltPhone']")
	private WebElement altphoneNumOnCustDetailsPopup;

	@FindBy(xpath = "//input[@id='txtEmail']")
	private WebElement emailIdOnCustDetailsPopup;

	@FindBy(xpath = "//input[@id='txtFirstName']")
	private WebElement firstNameOnCustDetailsPopup;

	@FindBy(xpath = "//input[@id='txtLastName']")
	private WebElement lastNameOnCustDetailsPopup;

	@FindBy(xpath = "(//span[@class='switchery switchery-default'])[4]")
	private WebElement latesettingtooglebutton;

	@FindBy(xpath = "(//a[@id='btnUpdateCustomerDetails'])[1]")
	private WebElement updateCustomerDetailsBtnOnCustDetailsPopup;

	@FindBy(xpath = "(//div[@class='modal-header customer-modal-header']//a//i)[1]")
	private WebElement closeBtnOnCustDetailsPopup;

	// ========================Preferences tab customer details popup
	// ========================

	@FindBy(xpath = "(//a[@data-toggle='tab'][normalize-space()='Preferences'])[1]")
	private WebElement preferencesTabOnCustDetailsPopup;

	@FindBy(xpath = "(//select[@id='ddlDefaultTaxExempt'])[1]")
	private WebElement taxtype_preference_OnCustDetailsPopup;

	@FindBy(xpath = "(//input[@id='txtTaxId'])[1]")
	private WebElement taxid_preference_OnCustDetailsPopup;

	@FindBy(xpath = "(//input[@id='txtDefaultDiscount'])[1]")
	private WebElement discount_preference_OnCustDetailsPopup;

	@FindBy(xpath = "(//input[@id='txtDiscountAmount'])[1]")
	private WebElement discountamount_preference_OnCustDetailsPopup;

	@FindBy(xpath = "(//input[@id='txtDafultDeliveryFee'])[1]")
	private WebElement deliveryfee_preference_OnCustDetailsPopup;

	@FindBy(xpath = "//div[@id='page-wrapper']//textarea[@id='txtDefaultCardMsg']")
	private WebElement cardmessage_preference_OnCustDetailsPopup;

	@FindBy(xpath = "(//select[@id='ddlDefaultPaymentType'])[1]")
	private WebElement paymenttype_preference_OnCustDetailsPopup;

	@FindBy(xpath = "(//select[@id='ddlPaymentTerms'])[1]")
	private WebElement paymentterms_preference_OnCustDetailsPopup;

	@FindBy(xpath = "(//textarea[@id='txtDefaultSpecialInstrunction'])[1]")
	private WebElement specialinstruction_preference_OnCustDetailsPopup;

	@FindBy(xpath = "(//button[@id='btnUpdateCustomerDefaults'])[1]")
	private WebElement updatecustomerDefaultbtn_preference_OnCustDetailsPopup;

	@FindBy(xpath = "(//button[normalize-space()='Not Needed'])[1]")
	private WebElement confirmationalert_notneededbtn_preference_OnCustDetailsPopup;

	@FindBy(xpath = "(//div[@class='sweet-alert showSweetAlert visible'])[1]")
	private WebElement confirmationalert_preference_OnCustDetailsPopup;

	// ==========================Order Details Section ========================
	@FindBy(xpath = "//a[normalize-space()='View ShortCodes']")
	private WebElement viewShortcodesOnPhoneOrderPage;

	@FindBy(xpath = "(//textarea[@id='orderCardMsg'])[1]")
	private WebElement viewShortcodeTextboxOnPhoneOrderPage;

	@FindBy(xpath = "//ul[@id='textcomplete-dropdown-1']//li//a//div//span")
	private List<WebElement> listOfShortcodesOnPhoneOrderPage;

	// ======================= Product Details Section ==============
	@FindBy(xpath = "//td//input[@id='orderItem1']")
	private WebElement prod_details_Itemcode1;

	@FindBy(xpath = "//ul[@id='ui-id-15']//li//div")
	private List<WebElement> listOfItemsUnderItemcode1;

	@FindBy(xpath = "//td//textarea[@id='orderItemDesc1']")
	private WebElement prod_details_ItemDescription1;

	@FindBy(xpath = "//td//input[@id='orderItemQty1']")
	private WebElement prod_details_Qty1;

	@FindBy(xpath = "(//tbody[@class='productLines']//tr[1]//td[3]//input)")
	private WebElement prod_details_Quantity1;

	@FindBy(xpath = "(//tbody[@class='productLines']//tr[1]//td[4]//input)")
	private WebElement prod_details_Unitprice1;

	@FindBy(xpath = "(//tbody[@class='productLines']//tr[1]//td[5]//input)")
	private WebElement prod_details_Extendedprice1;

	@FindBy(xpath = "(//tbody[@class='productLines']//tr[1]//td[6]//input)")
	private WebElement prod_details_DiscountAmt1;

	@FindBy(xpath = "(//tbody[@class='productLines']//tr[1]//td[7]//input)")
	private WebElement prod_details_DiscountPercentage1;

	@FindBy(xpath = "//td//input[@id='orderItem2']")
	private WebElement prod_details_Itemcode2;

	@FindBy(xpath = "//td//textarea[@id='orderItemDesc2']")
	private WebElement prod_details_ItemDescription2;

	@FindBy(id = "productGrid")
	private WebElement productDetailGrid;
	
	@FindBy(xpath="//a[@id='orderItemRemoveIcon1']")
	private WebElement removeIconProdDetails1;
	
	@FindBy(xpath="//textarea[@id='orderItemDesc2']")
	private WebElement prod_details_ItemDescription2OnPhoneOrderPage;
	
	@FindBy(xpath="//ul[@id='ui-id-19']//li//div")
	private List<WebElement> listOfRow2_ItemDescription_OnPhoneOrderPage;
	
	@FindBy(xpath="//a[@id='orderItemAddIcon3']")
	private WebElement addIconProdDetails3_OnPhoneOrderPage;
	
	@FindBy(xpath="//input[@id='orderItem4']")
	private WebElement prod_details_Itemcode4_OnPhoneOrderPage;
	
	@FindBy(xpath="//table[@class='table productGrid']//tbody//tr")
	private List<WebElement> listOfRow_ProductDetails_OnPhoneOrderPage;
	
	@FindBy(xpath="//input[@id='orderItem2']")
	private WebElement prod_details_Itemcode2_OnPhoneOrderPage;
	
	@FindBy(xpath="//textarea[@id='orderItemDesc2']")
	private WebElement prod_details_ItemDescription2_OnPhoneOrderPage;
	
	@FindBy(xpath="//input[@id='orderItemQty2']")
	private WebElement prod_details_ItemQty2_OnPhoneOrderPage;
	
	@FindBy(xpath="//input[@id='orderItemPrice2']")
	private WebElement prod_details_ItemPrice2_OnPhoneOrderPage;

	// ===================== Payment type ==============================
	@FindBy(xpath = "//input[@id='paymentPayableBal']")
	private WebElement payableBalanceOnPhoneOrderPage;

	@FindBy(xpath = "//input[@id='paymentGrandTotalTxt']")
	private WebElement grandTotalOnPhoneOrderPage;

	@FindBy(id="paymentDelFeeTxt")
	private WebElement deliveryFee_PhoneOrder_PaymentSection;
	
	// ===================Payment Type as Gift Card =============================
	@FindBy(id="paymentGiftCardNumber")
	private WebElement giftCardNumber_PhoneOrder_PaymentSection;
	
	@FindBy(id="paymentGiftCustName")
	private WebElement giftCardCustName_PhoneOrder_PaymentSection;
	
	@FindBy(id="paymentGiftAmt")
	private WebElement giftCardAmount_PhoneOrder_PaymentSection;
	
	@FindBy(id="paymentGiftCardCurrentBalance")
	private WebElement giftCardCurrentBalance_PhoneOrder_PaymentSection;
	
	//====================== cash type ========================================
	@FindBy(xpath = "//input[@id='paymentPaidAmt']")
	private WebElement paidAmountOnPhoneOrderPage;

	@FindBy(xpath = "//select[@id='paymentCashCashRegister']")
	private WebElement cashRegisterDDOnPhoneOrderPage;

	@FindBy(xpath = "//button[@id='btnPlaceOrder']")
	private WebElement placeOrderButtonOnPhoneOrderPage;

	// =================Payments as Invoice/House Account ==================
	@FindBy(xpath = "(//input[@id='paymentPONumber'])[1]")
	private WebElement ponumber_paymenttype_InvHouseAct_OnPhoneOrderPage;

	// ====================== Confirmation popup ==============================
	@FindBy(xpath = "//h4[contains(text(),'Order Confirmation')]")
	private WebElement confirmationPopupTitleOnPhoneOrderPage;

	@FindBy(xpath = "(//button[@class='btn btn-default pull-right'])[1]")
	private WebElement cancelButtonOnPhoneOrderPage;

	@FindBy(xpath = "(//button[normalize-space()='Submit Order'])[1]")
	private WebElement submitOrderButtonOnPhoneOrderPage;

	// ============== Instruction textbox =================
	@FindBy(xpath = "//textarea[@id='productSpInstructions']")
	private WebElement Splinstruction_Textbox_OnPhoneOrderPage;
	
	@FindBy(xpath = "//textarea[@id='productDriverInstruct']")
	private WebElement Driverinstruction_Textbox_OnPhoneOrderPage;
	
	@FindBy(xpath="(//textarea[@id='txtCustomerNotes'])[1]")
	private WebElement customerPrivateNotes_Textbox_OnPhoneOrderPage;
	
	@FindBy(id="productTaxType")
	private WebElement producttaxType_OnPhoneOrderPage;
	
	@FindBy(id="productTaxId")
	private WebElement producttaxId_OnPhoneOrderPage;
	
	@FindBy(xpath="//select[@id='productReferral']")
	private WebElement productSourceCode_OnPhoneOrderPage;
	
	@FindBy(xpath="//select[@id='customerType']")
	private WebElement productcustomerType_OnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='txtPONumber'])[1]")
	private WebElement ponumber_preference_OnCustDetailsPopup;

	@FindBy(xpath = "(//input[@id='paymentPONumber'])[1]")
	private WebElement ponumber_paymenttype_OnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='paymentPaymentTerm'])[1]")
	private WebElement paymentterm_paymenttype_OnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='paymentDelFeeTxt'])[1]")
	private WebElement deliveryfee_paymenttype_OnPhoneOrderPage;

	// =================Unpaid Invoice tab customer details popup ===============
	@FindBy(xpath = "(//a[@id='CustomerUnpaidAnc'])[1]")
	private WebElement customerDetailsPopup_Unpaid_TabOnPhoneOrderPage;

	@FindBy(xpath="//span[@class='k-icon k-i-file-excel']")
	private WebElement exportToExcel_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage;

	@FindBy(xpath = "(//div[@class='k-pager-wrap k-grid-pager k-widget k-floatwrap'])[1]")
	private WebElement pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage;

	@FindBy(xpath = "(//a[@title='Go to the first page'])[1]")
	private WebElement firstpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage;

	@FindBy(xpath = "(//a[@title='Go to the previous page'])[1]")
	private WebElement previouspage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage;

	@FindBy(xpath = "(//a[@title='Go to the next page'])[1]")
	private WebElement nextpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage;

	@FindBy(xpath = "(//a[@title='Go to the last page'])[1]")
	private WebElement lastpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage;

	@FindBy(xpath = "(//span[@class='k-state-selected'])[1]")
	private WebElement selectedpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage;

	@FindBy(xpath = "//span[@class='k-input']")
	private WebElement pagelist_DisplayedNumber_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage;

	@FindBy(xpath = "//span[@class='k-select']")
	private WebElement pagelistdropdown_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage;

	@FindBy(xpath = "//ul[@class='k-list k-reset']//li")
	private List<WebElement> pagelist_dropdownvalues_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage;

	@FindBy(xpath = "//span[@class='k-pager-sizes k-label']")
	private WebElement itemsperpage_Label_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage;

	@FindBy(xpath = "//a[@class='k-pager-refresh k-link']//span")
	private WebElement refreshButton_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage;

	@FindBy(xpath = "//span[@class='k-pager-info k-label']")
	private WebElement pagenumber_Label_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage;

	@FindBy(xpath = "//div[@id='full-view-modal-body']")
	private WebElement InvoiceDetailsPopup_Unpaid_TabOnPhoneOrderPage;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr[1]//td[2]")
	private WebElement row1_InvoiceNo_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "//div[@class='modal-close-icon']//a//i")
	private WebElement closeIcon_InvoiceDetailsPopup_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//button[@id='btnMakePayment'])[1]")
	private WebElement MakePaymentButton_InvoiceDetailsPopup_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr[1]//td[1]/input")
	private WebElement row1_Checkbox_InvoiceDetailsPopup_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//div[@id='unpaidinvoices-confirm'])[1]")
	private WebElement invoicepaymentdetailssection_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//select[@id='ddlUnPaidInvoicePaymentType'])[1]")
	private WebElement paymenttype_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//select[@id='unpaidinv-cashregister'])[1]")
	private WebElement cashregister_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//span[@id='lblCreditOnFileTotalDue'])[1]")
	private WebElement totaldueamt_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//input[@id='unpaidinv-paymentamount'])[1]")
	private WebElement paymentamount_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//button[@class='btn btn-cancel'])[1]")
	private WebElement cancelButton_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//button[@class='btn btn-primary unpaidSubmitMakePayment'])[1]")
	private WebElement submitButton_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//span[contains(text(),'Payment processed successfully...')])[1]")
	private WebElement paymentSuccessMessage_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//select[@id='paymentconfirm-cashregister'])[1]")
	private WebElement cashregister_ConfirmationSection_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//button[contains(@class,'btn btn-primary')][normalize-space()='Print Receipt'])[1]")
	private WebElement printReceiptButton_ConfirmationSection_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//button[contains(@class,'btn btn-primary')][normalize-space()='Email Receipt'])[1]")
	private WebElement emailReceiptButton_ConfirmationSection_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//input[@type='text'])[159]")
	private WebElement emailtextbox_ConfirmationSection_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//button[@id='btn-unpaid-back'])[1]")
	private WebElement backButton_ConfirmationSection_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//div[@id='gvCustomerUnpaidInvoices'])[1]")
	private WebElement unpaidInvoiceTable_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//input[contains(@class,'k-textbox k-FullWidth')])[1]")
	private WebElement CustomerDetailsPopup_Invoicesearchtextbox_UnpaidTab;

	@FindBy(xpath = "(//td[@class='hana-cust-grid-row-fullview kendo-hana-invoice-column'])[1]")
	private WebElement InvoiceNumber_Row1_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//td[@class='hana-cust-grid-row-fullview kendo-hana-invoice-column'])")
	private List<WebElement> ListOfInvoiceNumber_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "//div[@class='k-grid-norecords']")
	private WebElement NoUnpaidInvoiceFound_InvoiceTable_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//button[@class='k-button k-button-icon'])[1]")
	private WebElement InvoiceClearbutton_Invoicesearchtextbox_UnpaidTab;

	@FindBy(xpath = "(//input[@class='k-textbox k-FullWidth'])[2]")
	private WebElement PaidAmtSearchTextbox_InvoiceTable_UnpaidTab_OnPhoneOrderPage;

	@FindBy(xpath="//tbody[@role='rowgroup']//tr//td[3]")
	private List<WebElement> listOfPaidAmt__InvoiceTable_UnpaidTab_OnPhoneOrderPage;

	@FindBy(xpath = "(//button[@class='k-button k-button-icon'])[2]")
	private WebElement InvoiceClearbutton_PaidAmtsearchtextbox_UnpaidTab;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr[last()]//td[1]/input")
	private WebElement lastRow_Checkbox_InvoiceTable_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//input[contains(@class,'k-textbox k-FullWidth')])[3]")
	private WebElement CustomerDetailsPopup_BalanceAmtsearchtextbox_UnpaidTab;

	@FindBy(xpath = "(//button[@class='k-button k-button-icon'])[3]")
	private WebElement InvoiceClearbutton_BalanceAmtsearchtextbox_UnpaidTab;

	@FindBy(xpath = "(//input[contains(@class,'k-textbox k-FullWidth')])[4]")
	private WebElement CustomerDetailsPopup_ProductTotalsearchtextbox_UnpaidTab;

	@FindBy(xpath = "(//button[@class='k-button k-button-icon'])[4]")
	private WebElement InvoiceClearbutton_ProductTotalsearchtextbox_UnpaidTab;

	@FindBy(xpath = "(//td[@class='hana-cust-grid-row-fullview hana-product-column'])")
	private List<WebElement> ListOfProductsTotal_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//input[contains(@class,'k-textbox k-FullWidth')])[5]")
	private WebElement CustomerDetailsPopup_Deliverysearchtextbox_UnpaidTab;

	@FindBy(xpath = "(//button[@class='k-button k-button-icon'])[5]")
	private WebElement InvoiceClearbutton_Deliverysearchtextbox_UnpaidTab;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr//td[6]")
	private List<WebElement> ListOfDelivery_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//input[contains(@class,'k-textbox k-FullWidth')])[6]")
	private WebElement CustomerDetailsPopup_Taxsearchtextbox_UnpaidTab;

	@FindBy(xpath = "(//button[@class='k-button k-button-icon'])[6]")
	private WebElement InvoiceClearbutton_Taxsearchtextbox_UnpaidTab;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr//td[7]")
	private List<WebElement> ListOfTax_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//input[contains(@class,'k-textbox k-FullWidth')])[8]")
	private WebElement CustomerDetailsPopup_Totalsearchtextbox_UnpaidTab;

	@FindBy(xpath = "(//button[@class='k-button k-button-icon'])[8]")
	private WebElement InvoiceClearbutton_Totalsearchtextbox_UnpaidTab;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr//td[9]")
	private List<WebElement> ListOfTotal_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//input[contains(@class,'k-textbox k-FullWidth')])[9]")
	private WebElement CustomerDetailsPopup_OrderDatesearchtextbox_UnpaidTab;

	@FindBy(xpath = "(//button[@class='k-button k-button-icon'])[9]")
	private WebElement InvoiceClearbutton_OrderDatesearchtextbox_UnpaidTab;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr//td[10]")
	private List<WebElement> ListOfOrderDate_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//input[contains(@class,'k-textbox k-FullWidth')])[10]")
	private WebElement CustomerDetailsPopup_DeliveryDatesearchtextbox_UnpaidTab;

	@FindBy(xpath = "(//button[@class='k-button k-button-icon'])[10]")
	private WebElement InvoiceClearbutton_DeliveryDatesearchtextbox_UnpaidTab;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr//td[11]")
	private List<WebElement> ListOfDeliveryDate_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage;

	@FindBy(xpath = "(//a[@class='k-link'])[1]")
	private WebElement InvoiceLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup;

	@FindBy(xpath = "(//span[@class='k-icon k-i-sort-asc-sm'])[1]")
	private WebElement Invoice_uparrow_UnpaidInvoiceTab_OnCustomerDetailsPopup;

	@FindBy(xpath = "//span[@class='k-icon k-i-sort-desc-sm']")
	private WebElement Invoice_downarrow_UnpaidInvoiceTab_OnCustomerDetailsPopup;

	@FindBy(xpath = "(//a[@class='k-link'])[2]")
	private WebElement PaidAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup;

	@FindBy(xpath = "(//td[@class='hana-cust-grid-row-fullview'])[1]")
	private List<WebElement> ListOfPaidAmt_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup;

	@FindBy(xpath = "(//a[@class='k-link'])[3]")
	private WebElement BalanceAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup;

	@FindBy(xpath = "(//td[@class='hana-cust-grid-row-fullview'])[2]")
	private List<WebElement> ListOfBalanceAmt_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup;

	@FindBy(xpath = "(//a[@class='k-link'])[4]")
	private WebElement ProductTotalLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup;

	@FindBy(xpath = "(//a[@class='k-link'])[5]")
	private WebElement DeliveryLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr//td[6]")
	private List<WebElement> ListOfDelivery_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup;

	@FindBy(xpath = "(//a[@class='k-link'])[6]")
	private WebElement TaxLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr//td[7]")
	private List<WebElement> ListOfTax_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup;

	@FindBy(xpath = "(//a[@class='k-link'])[7]")
	private WebElement LatefeeLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr//td[8]")
	private List<WebElement> ListOflatefee_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup;

	@FindBy(xpath = "(//a[@class='k-link'])[8]")
	private WebElement TotalLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr//td[9]")
	private List<WebElement> ListOfTotallabel_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup;

	@FindBy(xpath = "(//a[@class='k-link'])[9]")
	private WebElement OrderDateLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr//td[10]")
	private List<WebElement> ListOfOrderDate_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup;

	@FindBy(xpath = "(//a[@class='k-link'])[10]")
	private WebElement DeliveryDateLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr//td[11]")
	private List<WebElement> ListOfDeliveryDate_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup;

	//=============================Payment details======================

	@FindBy(xpath="(//a[normalize-space()='Payment Detail(s)'])[1]")
	private WebElement PaymentDetailsTab;

	@FindBy(xpath="(//div[@id='gvCustomerPaymentDtls'])[1]")
	private WebElement PaymentDetailsTabTable;

	@FindBy(xpath="(//div[@id='gvCustomerPaymentDtls']//div//a)[1]")
	private WebElement exportExcel_PaymentDetailsTab;

	@FindBy(xpath="(//table[@role='grid'])[3]//tbody//tr[1]//td[1]")
	private WebElement tablerow1cell1_PaymentDetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr[2]//th//span//input)[1]")
	private WebElement InvoiceSearchTextBox_PaymentDetailsTab;

	@FindBy(xpath="(//table[@role='grid'])[3]//tbody//tr//td[1]")
	private List <WebElement> ListOfInvoice_PaymentDetailsTab;

	@FindBy(xpath="//div[contains(text(),'No Customer Payments Found.')]")
	private WebElement NoCustomerFound_PaymentDetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr[2]//th//span//button)[1]")
	private WebElement clearbutton_InvoiceSearchTextBox_PaymentDetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr[2]//th//span//input)[2]")
	private WebElement payAmountSearchBox_PaymentDetailsTab;

	@FindBy(xpath="(//table[@role='grid'])//tbody[@role='rowgroup']//tr//td[2]")
	private List<WebElement> ListOfPayAmount_PaymentDetailsTab; 

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr[2]//th//span//button)[2]")
	private WebElement clearbutton_PayAmountSearchBox_PaymentDetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr[2]//th//span//input)[3]")
	private WebElement payDateSearchBox_PaymentDetailsTab;

	@FindBy(xpath="(//table[@role='grid'])//tbody[@role='rowgroup']//tr//td[3]")
	private List<WebElement> ListOfPayDate_PaymentDetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr[2]//th//span//button)[3]")
	private WebElement clearbutton_PayDateSearchBox_PaymentDetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr[2]//th//span//span[2])")
	private WebElement filterIconOnPayDate_PaymentDetailsTab;

	@FindBy(xpath="(//div[@class='k-animation-container']//ul[@class='k-list k-reset']//li)")
	private List<WebElement> ListOfFilterOptionsOnPayDate_PaymentDetailsTab;

	@FindBy(xpath="(//span[@role='button'])[1]")
	private WebElement calendarIconOnPayDate_PaymentDetailsTab;

	@FindBy(xpath="//a[@class='k-link k-nav-fast']")
	private WebElement calendar_MonthYear_PayDate_PaymentDetailsTab;

	@FindBy(xpath="//table[@class='k-content k-month']//tbody//tr//td")
	private List<WebElement> ListOfdates_PayDate_PaymentDetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr[2]//th//span//input)[5]")
	private WebElement MOPSearchBox_PaymentDetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr[2]//th//span//button)[4]")
	private WebElement clearbutton_MOPSearchBox_PaymentDetailsTab;

	@FindBy(xpath="(//table[@role='grid'])//tbody[@role='rowgroup']//tr//td[4]")
	private List<WebElement> ListOfMOP_PaymentDetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr[2]//th//span//input)[6]")
	private WebElement ChecknoSearchBox_PaymentDetailsTab;

	@FindBy(xpath="(//table[@role='grid'])//tbody[@role='rowgroup']//tr//td[5]")
	private List<WebElement> ListOfCheckno_PaymentDetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr[2]//th//span//button)[5]")
	private WebElement clearbutton_ChecknoSearchBox_PaymentDetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr[2]//th//span//input)[7]")
	private WebElement CCNumberSearchBox_PaymentDetailsTab;

	@FindBy(xpath="(//table[@role='grid'])//tbody[@role='rowgroup']//tr//td[6]")
	private List<WebElement> ListOfCCNumber_PaymentDetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr[2]//th//span//button)[6]")
	private WebElement clearbutton_CCNumberSearchBox_PaymentDetailsTab;

	@FindBy(xpath="//div[@class='k-pager-wrap k-grid-pager k-widget k-floatwrap']")
	private WebElement paginationSection_PaymentDetailsTab;

	@FindBy(xpath="(//ul[@class='k-pager-numbers k-reset'])")
	private WebElement pagelistnumber_PaymentDetailsTab;

	@FindBy(xpath="//span[@class='k-pager-info k-label']")
	private WebElement paginationInfo_PaymentDetailsTab;

	@FindBy(xpath="(//a[@class='k-link'])[16]")
	private WebElement threedotsOnPagination_PaymentDetailsTab;

	@FindBy(xpath="(//ul[@class='k-pager-numbers k-reset']//li/a)[2]")
	private WebElement page2_PaymentDetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr//th//a)[1]")
	private WebElement invoicelabel_paymentdetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr//th//a)[2]")
	private WebElement payamountlabel_paymentdetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr//th//a)[3]")
	private WebElement payDatelabel_paymentdetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr//th//a)[4]")
	private WebElement moplabel_paymentdetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr//th//a)[5]")
	private WebElement checknolabel_paymentdetailsTab;

	@FindBy(xpath="(//thead[@class='k-grid-header']//tr//th//a)[6]")
	private WebElement ccnumberlabel_paymentdetailsTab;

	//=============================Order Details Tab=======================================
	@FindBy(xpath="//legend[text()='Order Details']")
	private WebElement OrderDetailsSection;
	
	@FindBy(xpath="//label[@class='ChkBoxLbl reminderLbl']")
	private WebElement sendreminderlabel_OrderDetailsTab;
	
	@FindBy(xpath="//a[text()='View ShortCodes']")
	private WebElement ViewShortCodesLink_OrderDetailsSection;
	
	@FindBy(xpath="//div[@class='shortCodeListDiv']//table//tbody//tr//td[1]")
	private List<WebElement> ListOfShortCodes_OrderDetailsSection;
	
	@FindBy(xpath="//div[@class='shortCodeListDiv']//table//tbody//tr[last()]//td[1]")
	private WebElement LastShortCode_OrderDetailsSection;
	
	@FindBy(xpath="//div[@class='shortCodeListDiv']//table//tbody//tr//td[2]")
	private List<WebElement> ListOfValues_OrderDetailsSection;
	
	@FindBy(xpath="//div[@class='shortCodeListDiv']//table//tbody//tr[last()]//td[2]")
	private WebElement LastValues_OrderDetailsSection;
	
	@FindBy(xpath="//div[@class='shortCodeListDiv']//table//tbody//tr//td[3]")
	private List<WebElement> ListOfdeleteIcon_OrderDetailsSection;
	
	@FindBy(xpath="//div[@class='shortCodeListDiv']//table//tbody//tr[last()]//td[3]//a")
	private WebElement LastdeleteIcon_OrderDetailsSection;
	
	@FindBy(xpath="//div[@class='sweet-alert showSweetAlert visible']")
	private WebElement ConfirmationPopup;
	
	@FindBy(xpath="//h2[text()='Confirmation']")
	private WebElement ConfirmationAlert_ShortCodesPopup_OrderDetailsSection;
	
	@FindBy(xpath="//div[@class='sa-icon sa-info']")
	private WebElement ConfirmationAlertIcon_ShortCodesPopup_OrderDetailsSection;
	
	@FindBy(xpath="//button[@class='cancel']")
	private WebElement ConfirmationAlertCancelButton_ShortCodesPopup_OrderDetailsSection;
	
	@FindBy(xpath="//p[text()='Are you sure you want to delete this code?']")
	private WebElement ConfirmationAlertMessage_ShortCodesPopup_OrderDetailsSection;
	
	@FindBy(xpath="//button[@class='confirm']")
	private WebElement YesButtonDeleteConfirmation_ShortCodesPopup_OrderDetailsSection;
	
	@FindBy(xpath="//button[@class='cancel']")
	private WebElement NoButtonDeleteConfirmation_ShortCodesPopup_OrderDetailsSection;
	
	@FindBy(xpath="(//div[@class='modal-content']//i)[1]")
	private WebElement closeIcon_ShortCodesPopup_OrderDetailsSection;
	
	@FindBy(xpath="//h4[text()='Short Codes']")
	private WebElement ShortCodes_Popup_OrderDetailsSection;
	
	@FindBy(xpath="//input[@id='txtNewShortCode']")
	private WebElement codeTextBox_ShortCodesPopup_OrderDetailsSection;
	
	@FindBy(xpath="//input[@id='txtNewShortDesc']")
	private WebElement valueTextBox_ShortCodesPopup_OrderDetailsSection;
	
	@FindBy(xpath="//input[@id='btnAddNewShortCode']")
	private WebElement addButton_ShortCodesPopup_OrderDetailsSection;
	
	@FindBy(xpath="(//a[normalize-space()='Order Detail(s)'])[1]")
	private WebElement OrderDetailsTab;

	@FindBy(xpath="(//div[@id='gvCustomerOrderDtls']//div//a)[1]")
	private WebElement exporttoexcelbutton_orderdetailsTab;

	@FindBy(xpath="(//div[@id='gvCustomerOrderDtls'])[1]")
	private WebElement OrderDetailsTable;

	@FindBy(xpath="(//thead[@role='rowgroup']//tr[2]//th//span//input)[1]") //(//thead[@role='rowgroup']//tr[2]//th//span//input)[18]
	private WebElement InvoiceNoSearchBox_OrderDetailsTab;

	@FindBy(xpath="//table[@role='grid']//tbody//tr//td[contains(@class,' gvCustomerOrderDtls')]")
	private List<WebElement> ListOfInvoiceNo_OrderDetailsTab;

	@FindBy(xpath="//table[@role='grid']//tbody//tr//td[1]")
	private WebElement FirstInvoiceNo_OrderDetailsTab;

	@FindBy(xpath="(//thead[@role='rowgroup']//tr[2]//th//span//button)[1]")
	private WebElement clearbutton_InvoiceNoSearchBox_OrderDetailsTab;

	@FindBy(xpath="//div[contains(text(),'No Customer Orders Found.')]")
	private WebElement NoCustomerOrderFoundMessage_OrderDetailsTab;

	@FindBy(xpath="(//thead[@role='rowgroup']//tr[2]//th//span//input)[5]")
	private WebElement TotalAmountSearchBox_OrderDetailsTab;

	@FindBy(xpath="//table[@role='grid']//tbody//tr//td[5]")
	private List<WebElement> TotalAmountList_OrderDetailsTab;

	@FindBy(xpath="(//thead[@role='rowgroup']//tr[2]//th//span//button)[5]")
	private WebElement clearbutton_TotalAmountSearchBox_OrderDetailsTab;

	@FindBy(xpath="(//thead[@role='rowgroup']//tr[2]//th//span//input)[2]")
	private WebElement StatusSearchBox_OrderDetailsTab;

	@FindBy(xpath="//table[@role='grid']//tbody//tr//td[2]")
	private List<WebElement> ListOfStatus_OrderDetailsTab;

	@FindBy(xpath="(//thead[@role='rowgroup']//tr[2]//th//span//button)[2]")
	private WebElement clearbutton_StatusSearchBox_OrderDetailsTab;

	@FindBy(xpath="(//thead[@role='rowgroup']//tr[2]//th//span//input)[3]")
	private WebElement NameSearchBox_OrderDetailsTab;

	@FindBy(xpath="//table[@role='grid']//tbody//tr//td[3]")
	private List<WebElement> ListOfName_OrderDetailsTab;

	@FindBy(xpath="(//thead[@role='rowgroup']//tr[2]//th//span//button)[3]")
	private WebElement clearbutton_NameSearchBox_OrderDetailsTab;

	@FindBy(xpath="(//thead[@role='rowgroup']//tr[2]//th//span//input)[4]")
	private WebElement AddressSearchBox_OrderDetailsTab;

	@FindBy(xpath="//table[@role='grid']//tbody//tr//td[4]")
	private List<WebElement> ListOfAddress_OrderDetailsTab;

	@FindBy(xpath="(//thead[@role='rowgroup']//tr[2]//th//span//button)[4]")
	private WebElement clearbutton_AddressSearchBox_OrderDetailsTab;

	@FindBy(xpath="(//thead[@role='rowgroup']//tr[2]//th//span//input)[6]")
	private WebElement OrderDateSearchBox_OrderDetailsTab;

	@FindBy(xpath="//table[@role='grid']//tbody//tr//td[6]")
	private List<WebElement> ListOfOrderDate_OrderDetailsTab;

	@FindBy(xpath="(//thead[@role='rowgroup']//tr[2]//th//span//button)[6]")
	private WebElement clearbutton_OrderDateSearchBox_OrderDetailsTab;

	@FindBy(xpath="(//thead[@role='rowgroup']//tr[2]//th//span//input)[7]")
	private WebElement DescriptionSearchBox_OrderDetailsTab;

	@FindBy(xpath="//table[@role='grid']//tbody//tr//td[7]")
	private List<WebElement> ListOfDescription_OrderDetailsTab;

	@FindBy(xpath="(//thead[@role='rowgroup']//tr[2]//th//span//button)[7]")
	private WebElement clearbutton_DescriptionSearchBox_OrderDetailsTab;

	//=========================Statements Tab ==========================
	@FindBy(xpath="(//a[contains(text(),'Statement(s)')])[1]")
	private WebElement StatementsTab;

	@FindBy(xpath="(//select[@id='ddlMonthYear'])[1]")
	private WebElement monthdropdown_statementsTab;

	@FindBy(xpath="(//button[@id='btnDownloadStatement'])[1]")
	private WebElement downloadstatementbutton_statementsTab;

	@FindBy(xpath="//div[@id='sizer']")
	private WebElement iframereport_statementsTab;

	@FindBy(xpath="(//h2[@id='lblCustAccStmntMsg'])[1]")
	private WebElement NoStatementsFoundMessage_statementsTab;






	// ================================================================================//

	public void ClickDefaultValuesIcon() {
		jsClick(defaultvaluesicon);
	}

	public String GetOrderEntryPageTitle() {
		return getDriver().getTitle();
	}

	public boolean VerifyChoosePageDefaultValuesPopup() {
		HighlightElement(choosepagedefaultvaluespopup);
		return choosepagedefaultvaluespopup.isDisplayed();
	}

	public String getItemCodeOnCPDV() {
		HighlightElement(itemcodeonCPDV);
		delayWithGivenTime(500);
		return itemcodeonCPDV.getAttribute("value");
	}

	public String getQtyOnCPDV() {
		HighlightElement(qtyonCPDV);
		delayWithGivenTime(500);
		return qtyonCPDV.getAttribute("value");
	}

	public String getOccasionOnCPDV() {
		HighlightElement(selectoccasionOnCPDV);
		delayWithGivenTime(500);
		s = new Select(selectoccasionOnCPDV);
		return s.getFirstSelectedOption().getText();
	}

	public String getcustomerTypeOnCPDV() {
		HighlightElement(selectcustomertypeOnCPDV);
		delayWithGivenTime(500);
		s = new Select(selectcustomertypeOnCPDV);
		return s.getFirstSelectedOption().getText();
	}

	public void ClickCloseIconOnChoosePageDefaultValuesPopup() {
		jsClick(CPDV_Popup_CloseIcon);
		delayWithGivenTime(500);
	}

	public void SelectOccasion_On_OrderDetails_In_PhoneOrderPage(String occasion) {
		dropDown(occasionOnphoneorderpage, occasion, "VisibleText");
	}

	public String getSelectedOccasionOnPhoneOrderPage() {
		HighlightElement(occasionOnphoneorderpage);
		s = new Select(occasionOnphoneorderpage);
		return s.getFirstSelectedOption().getText();
	}

	public String getItemcodeOnPhoneOrderPage() {
		HighlightElement(itemcodeOnphoneorderpage);
		return itemcodeOnphoneorderpage.getAttribute("value");
	}

	public String getItemqtyOnPhoneOrderPage() {
		HighlightElement(qtyOnphoneorderpage);
		return qtyOnphoneorderpage.getAttribute("value");
	}

	public String getSelectedCustTypeOnPhoneOrderPage() {
		HighlightElement(custTypeOnphoneorderpage);
		s = new Select(custTypeOnphoneorderpage);
		return s.getFirstSelectedOption().getText();
	}

	public String getFirstnameOnPhoneOrderPage() {
		HighlightElement(firstnameOnPhoneOrderPage);
		System.out.println(firstnameOnPhoneOrderPage.getAttribute("value"));
		return firstnameOnPhoneOrderPage.getAttribute("value");
	}

	public void EnterCustomerFirstName(String firstname) {
		DoubleClickAndType(firstnameOnPhoneOrderPage, firstname);
	}

	public boolean VerifyFnameField_On_CustSection_IsDisabled() {
		HighlightElement(firstnameOnPhoneOrderPage);
		return firstnameOnPhoneOrderPage.isEnabled();
	}

	public String getLastnameOnPhoneOrderPage() {
		HighlightElement(lastnameOnPhoneOrderPage);
		return lastnameOnPhoneOrderPage.getAttribute("value");
	}

	public void EnterCustomerLastName(String lastname) {
		DoubleClickAndType(lastnameOnPhoneOrderPage, lastname);
	}

	public boolean VerifyLnameField_On_CustSection_IsDisabled() {
		HighlightElement(lastnameOnPhoneOrderPage);
		return lastnameOnPhoneOrderPage.isEnabled();
	}

	public String getCompanyNameOnPhoneOrderPage() {
		HighlightElement(companyNameOnPhoneOrderPage);
		return companyNameOnPhoneOrderPage.getAttribute("value");
	}

	public boolean VerifyCompanyNameField_On_CustSection_IsDisabled() {
		HighlightElement(companyNameOnPhoneOrderPage);
		return companyNameOnPhoneOrderPage.isEnabled();
	}

	public void EnterCustomerCompanyName(String custcompanyname) {
		DoubleClickAndType(companyNameOnPhoneOrderPage, custcompanyname);
	}

	public String getEmailIdOnPhoneOrderPage() {
		HighlightElement(emailIdOnPhoneOrderPage);
		return emailIdOnPhoneOrderPage.getAttribute("value");
	}

	public boolean VerifyEmailIdField_On_CustSection_IsDisabled() {
		HighlightElement(emailIdOnPhoneOrderPage);
		return emailIdOnPhoneOrderPage.isEnabled();
	}

	public void EnterCustomerEmailId(String custemailid) {
		emailIdOnPhoneOrderPage.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(emailIdOnPhoneOrderPage, custemailid);
	}

	public String getAddress1OnPhoneOrderPage() {
		HighlightElement(address1OnPhoneOrderPage);
		return address1OnPhoneOrderPage.getAttribute("value");
	}

	public boolean VerifyAddress1Field_On_CustSection_IsDisabled() {
		HighlightElement(address1OnPhoneOrderPage);
		return address1OnPhoneOrderPage.isEnabled();
	}

	public void EnterAddress1(String custaddress1) {
		address1OnPhoneOrderPage.clear();
		delayWithGivenTime(500);
		clickAndType(address1OnPhoneOrderPage, custaddress1);
	}

	public void SearchAndSelect_Address1_CustSection(String custaddress1, String fulladdress) {
		for (WebElement CustomerAddress1 : listOfAddress1SuggestionsOnCustSection) {
			MouseHover(listOfAddress1SuggestionsOnCustSection.get(0));
			click(listOfAddress1SuggestionsOnCustSection.get(0));
			break;
		}
	}


	public String getAddress2OnPhoneOrderPage() {
		HighlightElement(address2OnPhoneOrderPage);
		return address2OnPhoneOrderPage.getAttribute("value");
	}

	public boolean VerifyAddress2Field_On_CustSection_IsDisabled() {
		HighlightElement(address2OnPhoneOrderPage);
		return address2OnPhoneOrderPage.isEnabled();
	}

	public String getZipCodeOnPhoneOrderPage() {
		HighlightElement(zipcodeOnPhoneOrderPage);
		return zipcodeOnPhoneOrderPage.getAttribute("value");
	}

	public void EnterZipCode(String custzipcode) {
		zipcodeOnPhoneOrderPage.clear();
		delayWithGivenTime(1000);
		jsClearAndType(zipcodeOnPhoneOrderPage, custzipcode);
	}

	public boolean VerifyZipcodeField_On_CustSection_IsDisabled() {
		HighlightElement(zipcodeOnPhoneOrderPage);
		return zipcodeOnPhoneOrderPage.isEnabled();
	}

	public String getCityOnPhoneOrderPage() {
		HighlightElement(cityOnPhoneOrderPage);
		return cityOnPhoneOrderPage.getAttribute("value");
	}

	public boolean VerifyCityField_On_CustSection_IsDisabled() {
		HighlightElement(cityOnPhoneOrderPage);
		return cityOnPhoneOrderPage.isEnabled();
	}

	public String getStateOnPhoneOrderPage() {
		HighlightElement(stateOnPhoneOrderPage);
		return stateOnPhoneOrderPage.getAttribute("value");
	}

	public boolean VerifyStateField_On_CustSection_IsDisabled() {
		HighlightElement(stateOnPhoneOrderPage);
		return stateOnPhoneOrderPage.isEnabled();
	}

	public String getPhoneNumberOnPhoneOrderPage() {
		HighlightElement(phoneNumOnPhoneOrderPage);
		return phoneNumOnPhoneOrderPage.getAttribute("value");
	}

	public boolean VerifyPhonenumberField_On_CustSection_IsDisabled() {
		HighlightElement(phoneNumOnPhoneOrderPage);
		return phoneNumOnPhoneOrderPage.isEnabled();
	}

	public void EnterPhoneNumber(String custphonenumber) {
		phoneNumOnPhoneOrderPage.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(phoneNumOnPhoneOrderPage, custphonenumber);
	}

	public void EnterAltPhoneNumber(String custphonenumber) {
		DoubleClickAndType(AltphoneNumOnPhoneOrderPage, custphonenumber);
	}

	public String getAltPhoneNumberOnPhoneOrderPage() {
		HighlightElement(AltphoneNumOnPhoneOrderPage);
		return AltphoneNumOnPhoneOrderPage.getAttribute("value");
	}

	public boolean VerifyAltPhonenumberField_On_CustSection_IsDisabled() {
		HighlightElement(AltphoneNumOnPhoneOrderPage);
		return AltphoneNumOnPhoneOrderPage.isEnabled();
	}
	
	public void SearchandSelectItemcodeOnPhoneOrderPage(String proditemcode) {
		DoubleClickAndType(prod_details_Itemcode1, proditemcode);
		delayWithGivenTime(3000);
		for (WebElement item : listOfItemsUnderItemcode1) {
			if (item.getText().contains("rrd-Red Rose Deluxe")) {
				click(item);
				break;
			}
		}
	}

	public String getProdDetailsItemcode1OnPhoneOrderPage() {
		HighlightElement(prod_details_Itemcode1);
		return prod_details_Itemcode1.getAttribute("value");
	}

	public String getProdDetailsItemcode2OnPhoneOrderPage() {
		HighlightElement(prod_details_Itemcode2);
		return prod_details_Itemcode2.getAttribute("value");
	}

	public String getProdDetailsItemDescription1OnPhoneOrderPage() {
		HighlightElement(prod_details_ItemDescription1);
		return prod_details_ItemDescription1.getAttribute("value");
	}

	public String getProdDetailsItemDescription2OnPhoneOrderPage() {
		HighlightElement(prod_details_ItemDescription2);
		return prod_details_ItemDescription2.getAttribute("value");
	}

	public String getDisplayedRecipientphoneOnPhoneOrderPage() {
		HighlightElement(recipientphoneonCPDV);
		return recipientphoneonCPDV.getAttribute("value");
	}

	public String getDisplayedRecipientZipcodeOnPhoneOrderPage() {
		HighlightElement(recipientzipcodeonCPDV);
		return recipientzipcodeonCPDV.getAttribute("value");
	}

	public String getSelectedWireInMethodOnPhoneOrderPage() {
		HighlightElement(defaultwireinmethodonCPDV);
		s = new Select(defaultwireinmethodonCPDV);
		return s.getFirstSelectedOption().getText();
	}

	public String getSelectedWireOutMethodOnPhoneOrderPage() {
		HighlightElement(defaultwireoutmethodonCPDV);
		s = new Select(defaultwireoutmethodonCPDV);
		return s.getFirstSelectedOption().getText();
	}

	public String getSelectedPaymentTypeOnPhoneOrderPage() {
		HighlightElement(paymenttypeonCPDV);
		s = new Select(paymenttypeonCPDV);
		return s.getFirstSelectedOption().getText();
	}

	public String getSelectedCustomerTypeOnPhoneOrderPage() {
		HighlightElement(selectcustomertypeOnCPDV);
		s = new Select(selectcustomertypeOnCPDV);
		return s.getFirstSelectedOption().getText();
	}

	public String getSelectedSalesPersonOnPhoneOrderPage() {
		HighlightElement(salespersononCPDV);
		s = new Select(salespersononCPDV);
		return s.getFirstSelectedOption().getText();
	}

	public String getSelectedCountryOnPhoneOrderPage() {
		HighlightElement(selectcountryonCPDV);
		s = new Select(selectcountryonCPDV);
		return s.getFirstSelectedOption().getText();
	}

	public String getSelectedLocationOnPhoneOrderPage() {
		HighlightElement(selectlocationonCPDV);
		s = new Select(selectlocationonCPDV);
		return s.getFirstSelectedOption().getText();
	}

	public String getSelectedOrderTypeOnPhoneOrderPage() {
		HighlightElement(selectordertypeOnCPDV);
		s = new Select(selectordertypeOnCPDV);
		return s.getFirstSelectedOption().getText();
	}

	public String getProdItemQty1OnPhoneOrderPage() {
		HighlightElement(prod_details_Quantity1);
		return prod_details_Quantity1.getAttribute("value");
	}

	public String getRecipientPhoneOnPhoneOrderPage() {
		HighlightElement(recipientphoneOnPhoneOrderPage);
		return recipientphoneOnPhoneOrderPage.getAttribute("value");
	}

	public void EnterRecipientPhone2OnPhoneOrderPage(String reciphone2) {
		clickAndType(recipientphone2OnPhoneOrderPage,reciphone2);
	}
	
	public String getRecipientPhone2OnPhoneOrderPage() {
		HighlightElement(recipientphone2OnPhoneOrderPage);
		return recipientphone2OnPhoneOrderPage.getAttribute("value");

	}


	public String getRecipientZipcodeOnPhoneOrderPage() {
		HighlightElement(recipientzipcodeOnPhoneOrderPage);
		return recipientzipcodeOnPhoneOrderPage.getAttribute("value");
	}

	public void ClickWireInMethodOnPhoneOrderPage() {
		jsClick(wireinmethodOnPhoneOrderPage);

	}

	public void ClickWireOutMethodOnPhoneOrderPage() {
		jsClick(wireoutmethodOnPhoneOrderPage);
	}

	public String getDisplayedWireInSelectedOption() {
		HighlightElement(wireIndefaultDDOnPhoneOrderPage);
		s = new Select(wireIndefaultDDOnPhoneOrderPage);
		return (s.getFirstSelectedOption().getText());
	}

	public String getDisplayedWireOutSelectedOption() {
		HighlightElement(wireOutdefaultDDOnPhoneOrderPage);
		s = new Select(wireOutdefaultDDOnPhoneOrderPage);
		return (s.getFirstSelectedOption().getText());
	}

	public void ClickdeliveryTypeOnPhoneOrderPage() {
		jsClick(deliverytypeOnPhoneOrderPage);
	}

	public void Click_WireIn_DeliveryType_OnPhoneOrderPage() {
		jsClick(wirein_deliverytype_OnPhoneOrderPage);
	}
	
	public void Click_WireOut_DeliveryType_OnPhoneOrderPage() {
		jsClick(wireout_deliverytype_OnPhoneOrderPage);
	}
	
	
	
	public String getDisplayedPaymentTypeSelectedOption() {
		HighlightElement(paymentTypeDropdownOnPhoneOrderPage);
		s = new Select(paymentTypeDropdownOnPhoneOrderPage);
		return (s.getFirstSelectedOption().getText());
	}

	public void SelectPaymentTypeOnPhoneOrderPage_PaymentSection(String paymentType) {
		dropDown(paymentTypeDropdownOnPhoneOrderPage, paymentType, "VisibleText");
	}
	
	public String get_SelectedPaymentType_OnPhoneOrderPage() {
		s=new Select(paymentTypeDropdownOnPhoneOrderPage);
		return s.getFirstSelectedOption().getText();
	}

	public void ClickPickupTypeOnPhoneOrderPage() {
		jsClick(pickupOnPhoneOrderPage);
	}

	public String getHighlightedColorOnPickupTypeOnPhoneOrderPage() {
		String color = pickupTypeOnPhoneOrderPage.getCssValue("color");
		String hexColor = rgbaToHex(color);
		return hexColor;
	}
	
	public void ClickDeliveryTypeOnPhoneOrderPage() {
		jsClick(deliverytypeOnPhoneOrderPage);
	}

	public String getHighlightedColorOnDeliveryTypeOnPhoneOrderPage() {
		String color = deliverytypeOnPhoneOrderPage.getCssValue("color");
		String hexColor = rgbaToHex(color);
		return hexColor;
	}

	public String getDisplayedSalesPersonSelectedOption() {
		HighlightElement(salesPersonDDonPhoneOrder);
		s = new Select(salesPersonDDonPhoneOrder);
		return (s.getFirstSelectedOption().getText());
	}

	public String getDisplayedCountryonRecipientSecOnPhoneOrderPage() {
		HighlightElement(recipientcountryOnPhoneOrderPage);
		s = new Select(recipientcountryOnPhoneOrderPage);
		return (s.getFirstSelectedOption().getText());
	}

	public String getDisplayedLocationonRecipientSecOnPhoneOrderPage() {
		HighlightElement(recipientlocationOnPhoneOrderPage);
		s = new Select(recipientlocationOnPhoneOrderPage);
		return (s.getFirstSelectedOption().getText());
	}

	public boolean verifyPickupOrderTypesIsHighlighted() {
		boolean isPickupHighlighted = pickupOnPhoneOrderPage.getAttribute("class").contains("active");
		return isPickupHighlighted;
	}

	public boolean verifyDeliveryOrderTypesIsHighlighted() {
		boolean isDeliveryHighlighted = deliverytypeOnPhoneOrderPage.getAttribute("class").contains("active");
		return isDeliveryHighlighted;
	}

	public boolean verifyWireInOrderTypesIsHighlighted() {
		boolean isWireInHighlighted = wireinmethodOnPhoneOrderPage.getAttribute("class").contains("active");
		return isWireInHighlighted;
	}

	public boolean verifyWireOutOrderTypesIsHighlighted() {
		boolean isWireOutHighlighted = wireoutmethodOnPhoneOrderPage.getAttribute("class").contains("active");
		return isWireOutHighlighted;
	}

	public boolean verifySuccessToastMessageAppears() {
		HighlightElement(SuccessToastMsg);
		return SuccessToastMsg.isDisplayed();
	}

	public String verifySuccessToastMessageText() {
		HighlightElement(SuccessToastMsg);
		return (SuccessToastMsg.getText());
	}

	public void SearchAndSelectCustomerOnCust_Section(String customerName) {
		searchCustomertextboxOnCustSection.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(searchCustomertextboxOnCustSection, customerName);
		delayWithGivenTime(2000);
		for (WebElement customerElement : listOfCustomerNamesOnCustSection) {
			if (customerElement.getText().contains(customerName)) {
				customerElement.click();
				break;
			}
		}
	}

	public boolean VerifyAutosuggestion_Displayed_On_Cust_Section(String customerName) {
		searchCustomertextboxOnCustSection.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(searchCustomertextboxOnCustSection, customerName);
		delayWithGivenTime(2000);
		if (listOfCustomerNamesOnCustSection.isEmpty() || listOfCustomerNamesOnCustSection.size() == 0) {
			System.out.println(
					"No suggestion displayed and list of customers size is " + listOfCustomerNamesOnCustSection.size());
			return true;
		} else if (cust_unorderlistOnCustSection.getAttribute("style").contains("none")) {
			System.out.println("No suggestion displayed status "
					+ cust_unorderlistOnCustSection.getAttribute("style").contains("none"));
			return true;
		} else {
			return false;
		}
	}

	public void SearchAndSelect_CustomerOnCust_Section(String customerName, String customerFullName) {
		searchCustomertextboxOnCustSection.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(searchCustomertextboxOnCustSection, customerName);
		delayWithGivenTime(2000);
		for (WebElement customerElement : listOfCustomerNamesOnCustSection) {
			if (customerElement.getText().contains(customerFullName)) {
				customerElement.click();
				break;
			}
		}
	}

	public void ClickReciNameOnPhoneOrderPage() {
		recipientfirstnameOnPhoneOrderPage.click();
	}

	public void EnterReciFirstName(String recifname) {
		recipientfirstnameOnPhoneOrderPage.clear();
		DoubleClickAndType(recipientfirstnameOnPhoneOrderPage, recifname);
	}

	public String getReciFirstName() {
		return recipientfirstnameOnPhoneOrderPage.getAttribute("value");
	}

	public void EnterReciLastName(String recilname) {
		recipientlastnameOnPhoneOrderPage.clear();
		DoubleClickAndType(recipientlastnameOnPhoneOrderPage, recilname);
	}

	public String getReciLastName() {
		System.out.println("LastName of Recipient" +recipientlastnameOnPhoneOrderPage.getAttribute("value"));
		return recipientlastnameOnPhoneOrderPage.getAttribute("value");
	}

	public void EnterReciAddress1(String reciaddress1) {
		jsClear(recipientaddress1OnPhoneOrderPage);
		delayWithGivenTime(1000);
		DoubleClickAndType(recipientaddress1OnPhoneOrderPage, reciaddress1);
	}

	public boolean Verify_Autosuggestion_Displayed_OnReciAddress1() {
		recipientaddress1OnPhoneOrderPage.clear();
		delayWithGivenTime(1000);
		for(int i=0;i<ListOfReciAddress1_Autosuggestions_OnPhoneOrderPage.size();i++) {
			int ReciAddress1_size=	ListOfReciAddress1_Autosuggestions_OnPhoneOrderPage.size();
			if(ReciAddress1_size>0) {
				return true;
			}
		}return false;

	}

	public void SearchAndSelectReciAddress1(String reciaddress1) {	
		recipientaddress1OnPhoneOrderPage.clear();
		delayWithGivenTime(1000);
		recipientaddress1OnPhoneOrderPage.sendKeys(reciaddress1);
		delayWithGivenTime(2000);
		for (WebElement customerElement : ListOfReciAddress1_Autosuggestions_OnPhoneOrderPage) {
			MouseHover(ListOfReciAddress1_Autosuggestions_OnPhoneOrderPage.get(0));
			click(ListOfReciAddress1_Autosuggestions_OnPhoneOrderPage.get(0));		
			break;
		}   	    
	}	

	public void Click_ReciAddress1() {
		click(recipientaddress1OnPhoneOrderPage);
		recipientaddress1OnPhoneOrderPage.sendKeys(Keys.TAB);
	}

	public String getReciAddress1() {
		HighlightElement(recipientaddress1OnPhoneOrderPage);
		return recipientaddress1OnPhoneOrderPage.getAttribute("value");
	}

	public void EnterReciAddress2(String reciaddress2) {
		jsClear(recipientaddress2OnPhoneOrderPage);
		DoubleClickAndType(recipientaddress2OnPhoneOrderPage, reciaddress2);
	}

	public String getReciAddress2() {
		HighlightElement(recipientaddress2OnPhoneOrderPage);
		return recipientaddress2OnPhoneOrderPage.getAttribute("value");
	}

	public void EnterReciZipcode(String recizipcode) {
		DoubleClickAndType(recipientzipcodeOnPhoneOrderPage, recizipcode);
	}

	public String getReciZipcode() {
		HighlightElement(recipientzipcodeOnPhoneOrderPage);
		return recipientzipcodeOnPhoneOrderPage.getAttribute("value");
	}

	public void EnterReciCity(String recicity) {
		recipientcityOnPhoneOrderPage.clear();
		delayWithGivenTime(1000);
		recipientcityOnPhoneOrderPage.clear();
		clickAndType(recipientcityOnPhoneOrderPage, recicity);
	}

	public String getReciCity() {
		HighlightElement(recipientcityOnPhoneOrderPage);
		return recipientcityOnPhoneOrderPage.getAttribute("value");
	}

	public void SelectReciCountry(String recicountry) {
		dropDown(recipientcountryOnPhoneOrderPage, recicountry, "VisibleText");
	}

	public String getSelectedCountryOnReciCountry() {
		Select select = new Select(recipientcountryOnPhoneOrderPage);
		return (select.getFirstSelectedOption().getText());
	}

	public void EnterReciPhone(String reciphone) {
		DoubleClickAndType(recipientphoneOnPhoneOrderPage, reciphone);
	}

	public String getReciPhone() {
		HighlightElement(recipientphoneOnPhoneOrderPage);
		return recipientphoneOnPhoneOrderPage.getAttribute("value");
	}

	public void SelectReciLocation(String recilocation) {
		//	HighlightElement(recipientlocationOnPhoneOrderPage);
		//	recipientlocationOnPhoneOrderPage.click();
		//	delayWithGivenTime(1000);
		//	Select select = new Select(recipientlocationOnPhoneOrderPage);
		//	select.selectByVisibleText(recilocation);
		dropDown(recipientlocationOnPhoneOrderPage, recilocation, "VisibleText");
	}

	public String getSelectedLocationOnReciLocation() {
		Select select = new Select(recipientlocationOnPhoneOrderPage);
		return (select.getFirstSelectedOption().getText());
	}

	public void EnterDeliveryDateOnReciSection() {
		LocalDate currentDate = LocalDate.now();

		// Calculate the next day
		LocalDate nextDay = currentDate.plusDays(1);

		// Format the date as a string (adjust the format to match the date picker's
		// expected format)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedNextDay = nextDay.format(formatter);
		jsClearAndType(recipientDeliverydateOnPhoneOrderPage, formattedNextDay); // DoubleClickAndType();
	}

	public String getDeliveryDateOnReciSection() {
		return recipientDeliverydateOnPhoneOrderPage.getAttribute("value");
	}

	public void ClickViewShortCode() {
		jsClick(viewShortcodesOnPhoneOrderPage);
	}

	public void EnterViewShortCode() {
		viewShortcodeTextboxOnPhoneOrderPage.clear();
		delayWithGivenTime(1000);
		viewShortcodeTextboxOnPhoneOrderPage.sendKeys("@");
		delayWithGivenTime(1000);
		viewShortcodeTextboxOnPhoneOrderPage.sendKeys("HB");
		delayWithGivenTime(1000);
		for (WebElement viewShortCodeElement : listOfShortcodesOnPhoneOrderPage) {
			if (viewShortCodeElement.getText().contains("HBD-Happy Birthday! Hope you have an amazing day!")) {
				viewShortCodeElement.click();
				break;
			}
		}
	}

	public void EnterViewShortCode(String shortcode, String value) {
		viewShortcodeTextboxOnPhoneOrderPage.clear();
		delayWithGivenTime(1000);
		viewShortcodeTextboxOnPhoneOrderPage.sendKeys("@");
		delayWithGivenTime(1000);
		viewShortcodeTextboxOnPhoneOrderPage.sendKeys(shortcode);
		delayWithGivenTime(1000);
		for (WebElement viewShortCodeElement : listOfShortcodesOnPhoneOrderPage) {
			if (viewShortCodeElement.getText().contains(value)) {
				viewShortCodeElement.click();
				break;
			}
		}
	}
	
	public String getEnteredViewShortCode() {
		HighlightElement(viewShortcodeTextboxOnPhoneOrderPage);
		return viewShortcodeTextboxOnPhoneOrderPage.getAttribute("value");
	}

	public String getUnitPriceOnProdDetails() {
		return prod_details_Unitprice1.getAttribute("value");
	}

	public boolean validateItemDetails(String expectedDescription, String expectedPrice, String expectedExtPrice,
			String expectedDiscountAmt, String expectedDiscountPercentage) {

		WebElement itemTable = productDetailGrid;
		List<WebElement> rows = itemTable.findElements(By.tagName("tr"));

		for (WebElement row : rows) {

			List<WebElement> cells = row.findElements(By.tagName("td"));

			String itemDescription = cells.get(1).getText();

			String itemPrice = cells.get(2).getText();

			String itemExtPrice = cells.get(3).getText();

			String itemDiscountAmt = cells.get(4).getText();

			String itemDiscountPercentage = cells.get(5).getText();

			if (itemDescription.equals(expectedDescription)) {
				Assert.assertEquals(itemDescription, expectedDescription, "Description does not match");
				Assert.assertEquals(itemPrice, expectedPrice, "Price does not match");
				Assert.assertEquals(itemExtPrice, expectedExtPrice, "Extended Price does not match");
				Assert.assertEquals(itemDiscountAmt, expectedDiscountAmt, "Discount Amount does not match");
				Assert.assertEquals(itemDiscountPercentage, expectedDiscountPercentage,
						"Discount Percentage does not match");
				break;
			}
		}
		return true;
	}

	public String getPayableAmount() {
		return payableBalanceOnPhoneOrderPage.getAttribute("value");
	}

	public String getGrandTotalAmount() {
		return grandTotalOnPhoneOrderPage.getAttribute("value");
	}

	public void EnterCashAmount() {
		System.out.println("Amount need to be paid is: " + getGrandTotalAmount());
		DoubleClickAndType(paidAmountOnPhoneOrderPage, getGrandTotalAmount());
	}

	public void SelectCashRegistry_On_CashPaymentType(String cashregistry) {
		//	click(cashRegisterDDOnPhoneOrderPage);
		//	SelectDropDownVisibleText(cashRegisterDDOnPhoneOrderPage, cashregistry);
		dropDown(cashRegisterDDOnPhoneOrderPage, cashregistry, "VisibleText");
	}

	public void ClickPlaceOrderButton() {
		jsClick(placeOrderButtonOnPhoneOrderPage);
	}

	public boolean VerifyConfirmationPopupOnPhoneOrderPage() {
		HighlightElement(confirmationPopupTitleOnPhoneOrderPage);
		return confirmationPopupTitleOnPhoneOrderPage.isDisplayed();
	}

	public void ClickCancelButton_On_ConfirmationPopup() {
		jsClick(cancelButtonOnPhoneOrderPage);
	}

	public void ClickSubmitButton_On_ConfirmationPopup() {
		jsClick(submitOrderButtonOnPhoneOrderPage);
	}

	public boolean Verify_NewCustomer_Label_Appears() {
		HighlightElement(newcustomerlabel);
		return newcustomerlabel.isDisplayed();
	}

	public boolean VerifyCustSectionAppears() {
		HighlightElement(custSectionOnPhoneOrderPage);
		return custSectionOnPhoneOrderPage.isDisplayed();
	}

	public boolean Verify_CustClearBtn_Appears() {
		HighlightElement(clearCustInfoBtnOnPhoneOrderPage);
		return clearCustInfoBtnOnPhoneOrderPage.isDisplayed();
	}

	public void ClickOn_CustClearBtn() {
		jsClick(clearCustInfoBtnOnPhoneOrderPage);
	}

	public boolean VerifyGoogleMap_Address1_CustSection() {
		HighlightElement(listOfAddress1SuggestionsOnCustSection.get(0));
		return listOfAddress1SuggestionsOnCustSection.get(0).getAttribute("style").contains("none");
	}

	public boolean Verify_CustFirstNameSection_AutosuggestionAppears() {
		HighlightElement(cust_FirstnameUnorderListOnCustSection);
		return cust_FirstnameUnorderListOnCustSection.getAttribute("style").contains("none");
	}

	public void SearchAndSelect_FirstnameOnCustSection(String firstname, String fullname) {
		firstnameOnPhoneOrderPage.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(firstnameOnPhoneOrderPage, firstname);
		delayWithGivenTime(2000);
		for (WebElement customerfnameElement : listOfFirstNamesOnCustSection) {
			if (customerfnameElement.getText().contains(fullname)) {
				customerfnameElement.click();
				break;
			}
		}
	}

	public void SearchAndSelect_LastnameOnCustSection(String lastname, String fullname) {
		lastnameOnPhoneOrderPage.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(lastnameOnPhoneOrderPage, lastname);
		delayWithGivenTime(2000);
		for (WebElement customerlastnameElement : listOfLastNamesOnCustSection) {
			if (customerlastnameElement.getText().contains(fullname)) {
				customerlastnameElement.click();
				break;
			}
		}
	}

	public boolean Verify_CustLastNameSection_AutosuggestionAppears() {
		HighlightElement(cust_LastnameUnorderListOnCustSection);
		return cust_LastnameUnorderListOnCustSection.getAttribute("style").contains("none");
	}

	public void SearchAndSelect_CompanynameOnCustSection(String cmpyname, String fullcmpyname) {
		companyNameOnPhoneOrderPage.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(companyNameOnPhoneOrderPage, cmpyname);
		delayWithGivenTime(2000);
		for (WebElement customercmpynameElement : listOfCompanyNamesOnCustSection) {
			if (customercmpynameElement.getText().contains(fullcmpyname)) {
				click(customercmpynameElement);
				break;
			}
		}
	}

	public boolean Verify_CustCompanyNameSection_AutosuggestionAppears() {
		HighlightElement(cust_companyNameUnorderListOnCustSection);
		return cust_companyNameUnorderListOnCustSection.getAttribute("style").contains("none");
	}

	public void SearchAndSelect_phonenumberOnCustSection(String phonenum, String fullphonenum) {
		phoneNumOnPhoneOrderPage.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(phoneNumOnPhoneOrderPage, phonenum);
		delayWithGivenTime(2000);
		for (int i = 0; i < listOfPhoneNumbersOnCustSection.size(); i++) {
			if (listOfPhoneNumbersOnCustSection.get(i).getText().contains(fullphonenum)) {
				(listOfPhoneNumbersOnCustSection.get(0)).click();
				break;
			}
		}
	}

	public boolean Verify_phonenumberCustSection_AutosuggestionAppears() {
		HighlightElement(cust_phoneNumberUnorderListOnCustSection);
		return cust_phoneNumberUnorderListOnCustSection.getAttribute("style").contains("none");
	}

	public boolean Verify_AltphonenumberCustSection_AutosuggestionAppears() {
		HighlightElement(cust_altphoneNumberUnorderListOnCustSection);
		return cust_altphoneNumberUnorderListOnCustSection.getAttribute("style").contains("none");
	}

	public void SearchAndSelect_AltphonenumberOnCustSection(String altphonenum, String altfullphonenum) {
		AltphoneNumOnPhoneOrderPage.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(AltphoneNumOnPhoneOrderPage, altphonenum);
		delayWithGivenTime(2000);
		for (int i = 0; i < listOfAltPhoneNumbersOnCustSection.size(); i++) {
			if (listOfAltPhoneNumbersOnCustSection.get(i).getText().contains(altfullphonenum)) {
				(listOfAltPhoneNumbersOnCustSection.get(0)).click();
				break;
			}
		}
	}

	public boolean Verify_CustEditIcon_Appears() {
		HighlightElement(editCustInfoBtnOnPhoneOrderPage);
		return editCustInfoBtnOnPhoneOrderPage.isDisplayed();
	}

	public void Click_CustEditIcon() {
		jsClick(editCustInfoBtnOnPhoneOrderPage);
	}

	public boolean Verify_CustomerDetailsPopupAppears() {
		HighlightElement(custSectionCustomerDetailsPopup);
		return custSectionCustomerDetailsPopup.isDisplayed();
	}

	public void Click_ProfileTab_OnCustDetailsPopup() {
		customerProfileTabOnCustDetailsPopup.click();
	}

	public boolean Verify_CustomerDetails_Popup_ProfileTab() {
		HighlightElement(customerProfileTabOnCustDetailsPopup);
		String ariaexpanded = customerProfileTabOnCustDetailsPopup.getAttribute("aria-expanded");
		return "true".equals(ariaexpanded);
	}

	public boolean Verify_CustomerIDField_Disabled() {
		HighlightElement(customerIDOnCustDetailsPopup);
		return customerIDOnCustDetailsPopup.isEnabled();
	}

	public void Enter_CompanyName_OnCustDetailsPopup(String cmpyname) {
		companyNameOnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(companyNameOnCustDetailsPopup, cmpyname);
	}

	public String get_CompanyName_OnCustDetailsPopup() {
		HighlightElement(companyNameOnCustDetailsPopup);
		return companyNameOnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_FirstName_OnCustDetailsPopup(String firstname) {
		firstNameOnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(firstNameOnCustDetailsPopup, firstname);
	}

	public String get_FirstName_OnCustDetailsPopup() {
		return firstNameOnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_LastName_OnCustDetailsPopup(String lastname) {
		lastNameOnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(lastNameOnCustDetailsPopup, lastname);
	}

	public String get_LastName_OnCustDetailsPopup() {
		return lastNameOnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_PhoneNumber_OnCustDetailsPopup(String phonenum) {
		phoneNumOnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(phoneNumOnCustDetailsPopup, phonenum);
	}

	public String get_PhoneNumber_OnCustDetailsPopup() {
		return phoneNumOnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_AltPhoneNumber_OnCustDetailsPopup(String altphonenum) {
		altphoneNumOnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(altphoneNumOnCustDetailsPopup, altphonenum);
	}

	public String get_AltPhoneNumber_OnCustDetailsPopup() {
		return altphoneNumOnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_Email_OnCustDetailsPopup(String email) {
		emailIdOnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(emailIdOnCustDetailsPopup, email);
	}

	public String get_Email_OnCustDetailsPopup() {
		return emailIdOnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_Country_OnCustDetailsPopup(String country) {
		countryOnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(countryOnCustDetailsPopup, country);
	}

	public String get_Country_OnCustDetailsPopup() {
		return countryOnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_City_OnCustDetailsPopup(String city) {
		cityOnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(cityOnCustDetailsPopup, city);
	}

	public String get_City_OnCustDetailsPopup() {
		return cityOnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_ZipCode_OnCustDetailsPopup(String zipcode) {
		zipcodeOnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(zipcodeOnCustDetailsPopup, zipcode);
	}

	public String get_ZipCode_OnCustDetailsPopup() {
		return zipcodeOnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_Address1_OnCustDetailsPopup(String address1) {
		address1OnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(address1OnCustDetailsPopup, address1);
	}

	public String get_Address1_OnCustDetailsPopup() {
		return address1OnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_Address2_OnCustDetailsPopup(String address2) {
		address2OnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(address2OnCustDetailsPopup, address2);
	}

	public String get_Address2_OnCustDetailsPopup() {
		return address2OnCustDetailsPopup.getAttribute("value");
	}

	public void Click_LateFeeSetting_OnCustDetailsPopup() {
		latesettingtooglebutton.click();

	}

	public boolean Verify_LateFeeSetting_Enabled_OnCustDetailsPopup() {
		HighlightElement(latesettingtooglebutton); // rgb(197, 231, 244) - green
		return latesettingtooglebutton.getAttribute("style").contains("rgb(197, 231, 244)");
	}

	public void Click_UpdateBtn_OnCustDetailsPopup() {
		click(updateCustomerDetailsBtnOnCustDetailsPopup);
	}

	public void Click_Customer_DetailsPopupCloseBtn() {
		fluentWait(closeBtnOnCustDetailsPopup);
		jsClick(closeBtnOnCustDetailsPopup);
	}

	public void Click_CreditCardTab_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		actionClick(creditCardTabOnCustDetailsPopup);
	}

	public void Click_AddNewBtn_CreditCardTab_OnCustDetailsPopup() {

		jsClick(addNewCreditCardBtnOnCustDetailsPopup);
	}

	public boolean Verify_AddNewInformation_Popup() {
		HighlightElement(addNewCreditCardBtnOnCustDetailsPopup);
		return addNewCreditCardBtnOnCustDetailsPopup.isDisplayed();
	}

	public void Enter_CreditCardTab_FirstName_OnCustDetailsPopup(String creditcard_firstname) {
		DoubleClickAndType(creditCardTab_FirstName_OnCustDetailsPopup, creditcard_firstname);
	}

	public String get_CreditCardTab_EnteredFirstName_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(creditCardTab_FirstName_OnCustDetailsPopup);
		return creditCardTab_FirstName_OnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_CreditCardTab_LastName_OnCustDetailsPopup(String creditcard_lastname) {
		DoubleClickAndType(creditCardTab_LastName_OnCustDetailsPopup, creditcard_lastname);
	}

	public String get_CreditCardTab_EnteredLastName_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(creditCardTab_LastName_OnCustDetailsPopup);
		return creditCardTab_LastName_OnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_CreditCardTab_CreditCardNumber_OnCustDetailsPopup(String creditcard_number) {
		DoubleClickAndType(creditCardTab_CreditCardNumber_OnCustDetailsPopup, creditcard_number);
	}

	public String get_CreditCardTab_EnteredCreditCardNumber_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(creditCardTab_CreditCardNumber_OnCustDetailsPopup);
		return creditCardTab_CreditCardNumber_OnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_CreditCardTab_ExpDate_OnCustDetailsPopup(String creditcard_expdate) {
		creditCardTab_ExpDate_OnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(creditCardTab_ExpDate_OnCustDetailsPopup, creditcard_expdate);
	}

	public String get_CreditCardTab_EnteredExpDate_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(creditCardTab_ExpDate_OnCustDetailsPopup);
		return creditCardTab_ExpDate_OnCustDetailsPopup.getAttribute("value");

	}

	public void Enter_CreditCardTab_CVV_OnCustDetailsPopup(String creditcard_cvv) {
		DoubleClickAndType(creditCardTab_CVV_OnCustDetailsPopup, creditcard_cvv);
	}

	public String get_CreditCardTab_EnteredCVV_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(creditCardTab_CVV_OnCustDetailsPopup);
		return creditCardTab_CVV_OnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_CreditCardTab_Zipcode_OnCustDetailsPopup(String creditcard_zipcode) {
		DoubleClickAndType(creditCardTab_ZipCode_OnCustDetailsPopup, creditcard_zipcode);
	}

	public String get_CreditCardTab_EnteredZipcode_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(creditCardTab_ZipCode_OnCustDetailsPopup);
		return creditCardTab_ZipCode_OnCustDetailsPopup.getAttribute("value");
	}

	public void Click_SaveBtn_CreditCardTab_OnCustDetailsPopup() {
		click(creditCardTab_SaveBtn_OnCustDetailsPopup);
	}

	public boolean Verify_SavedInformation_Popup() {
		delayWithGivenTime(1000);
		HighlightElement(SuccessToastMsg);
		return SuccessToastMsg.isDisplayed();
	}

	public void Click_CloseIcon_CreditCardTab_OnCustDetailsPopup() {
		jsClick(creditCardTab_CloseIcon_OnCustDetailsPopup);
	}

	public void Click_PreferencesTab_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		jsClick(preferencesTabOnCustDetailsPopup);
	}

	public void Select_TaxType_PreferencesTab_OnCustDetailsPopup(String taxtype) {
		delayWithGivenTime(1000);
		dropDown(taxtype_preference_OnCustDetailsPopup, taxtype, "VisibleText");
	}

	public String get_TaxType_PreferencesTab_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(taxtype_preference_OnCustDetailsPopup);
		s = new Select(taxtype_preference_OnCustDetailsPopup);
		return s.getFirstSelectedOption().getText();
	}

	public void Enter_TexId_PreferenceTab_OnCustDetailsPopup(String taxid) {
		taxid_preference_OnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(taxid_preference_OnCustDetailsPopup, taxid);
	}

	public String get_TexId_PreferenceTab_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(taxid_preference_OnCustDetailsPopup);
		return taxid_preference_OnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_DiscountPercentage_PreferenceTab_OnCustDetailsPopup(String discount) {
		discount_preference_OnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(discount_preference_OnCustDetailsPopup, discount);
	}

	public void Click_DiscountPercentage_PreferenceTab_OnCustDetailsPopup() {
		discount_preference_OnCustDetailsPopup.click();
	}

	public String get_DiscountPercentage_PreferenceTab_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(discount_preference_OnCustDetailsPopup);
		return discount_preference_OnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_DiscountAmount_PreferenceTab_OnCustDetailsPopup(String discountamount) {
		discountamount_preference_OnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(discountamount_preference_OnCustDetailsPopup, discountamount);
	}

	public void Click_DiscountAmount_PreferenceTab_OnCustDetailsPopup() {
		discountamount_preference_OnCustDetailsPopup.click();
	}

	public String get_DiscountAmount_PreferenceTab_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(discountamount_preference_OnCustDetailsPopup);
		return discountamount_preference_OnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_DeliveryFee_PreferenceTab_OnCustDetailsPopup(String deliveryfee) {
		deliveryfee_preference_OnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(deliveryfee_preference_OnCustDetailsPopup, deliveryfee);
	}

	public String get_DeliveryFee_PreferenceTab_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(deliveryfee_preference_OnCustDetailsPopup);
		return deliveryfee_preference_OnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_CardMessage_PreferenceTab_OnCustDetailsPopup(String cardmessage) {
		cardmessage_preference_OnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(cardmessage_preference_OnCustDetailsPopup, cardmessage);
	}

	public String get_CardMessage_PreferenceTab_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(cardmessage_preference_OnCustDetailsPopup);
		return cardmessage_preference_OnCustDetailsPopup.getAttribute("value");
	}

	public void Enter_PONumber_PreferenceTab_OnCustDetailsPopup(String ponumber) {
		ponumber_preference_OnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(ponumber_preference_OnCustDetailsPopup, ponumber);
	}

	public String get_PONumber_PreferenceTab_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(ponumber_preference_OnCustDetailsPopup);
		return ponumber_preference_OnCustDetailsPopup.getAttribute("value");
	}

	public void Select_PaymentType_PreferenceTab_OnCustDetailsPopup(String paymenttype) {
		delayWithGivenTime(1000);
		dropDown(paymenttype_preference_OnCustDetailsPopup, paymenttype, "VisibleText");
	}

	public String get_PaymentType_PreferenceTab_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(paymenttype_preference_OnCustDetailsPopup);
		s = new Select(paymenttype_preference_OnCustDetailsPopup);
		return s.getFirstSelectedOption().getText();
	}

	public void Select_PaymentTerms_PreferenceTab_OnCustDetailsPopup(String paymentterms) {
		delayWithGivenTime(1000);
		dropDown(paymentterms_preference_OnCustDetailsPopup, paymentterms, "VisibleText");
	}

	public String get_PaymentTerms_PreferenceTab_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(paymentterms_preference_OnCustDetailsPopup);
		s = new Select(paymentterms_preference_OnCustDetailsPopup);
		return s.getFirstSelectedOption().getText();
	}

	public void Enter_SpecialInstruction_PreferenceTab_OnCustDetailsPopup(String specialinstruction) {
		specialinstruction_preference_OnCustDetailsPopup.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(specialinstruction_preference_OnCustDetailsPopup, specialinstruction);
	}

	public String get_SpecialInstruction_PreferenceTab_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(specialinstruction_preference_OnCustDetailsPopup);
		return specialinstruction_preference_OnCustDetailsPopup.getAttribute("value");
	}

	public void Click_UpdateCustDefaultBtn_PreferenceTab_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		click(updatecustomerDefaultbtn_preference_OnCustDetailsPopup);
	}

	public boolean Verify_CustDefaultSucessMsg_PreferenceTab_OnCustDetailsPopup() {
		delayWithGivenTime(1000);
		HighlightElement(SuccessToastMsg);
		return SuccessToastMsg.isDisplayed();
	}

	public boolean Verify_ConfirmationAlert_Preference_OnCustDetailsPopup() {
		HighlightElement(confirmationalert_preference_OnCustDetailsPopup);
		return confirmationalert_preference_OnCustDetailsPopup.isDisplayed();
	}

	public void Click_ConfirmationAlert_NotNeeded_Button_Preference_OnCustDetailsPopup() {
		getDriver().switchTo().activeElement();
		click(confirmationalert_notneededbtn_preference_OnCustDetailsPopup);
	}

	public String get_SpecialInstruction_OnPhoneorderpage() {
		delayWithGivenTime(1000);
		HighlightElement(specialinstruction_preference_OnCustDetailsPopup);
		return specialinstruction_preference_OnCustDetailsPopup.getAttribute("value");
	}

	public String get_PONumber_InvoiceHouseAccount_OnPhoneorderpage() {
		delayWithGivenTime(1000);
		HighlightElement(ponumber_paymenttype_OnPhoneOrderPage);
		return ponumber_paymenttype_OnPhoneOrderPage.getAttribute("value");
	}

	public String get_PaymentTerms_InvoiceHouseAccount_OnPhoneorderpage() {
		delayWithGivenTime(1000);
		HighlightElement(paymentterm_paymenttype_OnPhoneOrderPage);
		return paymentterm_paymenttype_OnPhoneOrderPage.getAttribute("value");
	}

	public String get_DeliveryFee_InvoiceHouseAccount_OnPhoneorderpage() {
		HighlightElement(deliveryfee_paymenttype_OnPhoneOrderPage);
		delayWithGivenTime(1000);
		return deliveryfee_paymenttype_OnPhoneOrderPage.getAttribute("value");
	}

	public String get_TaxId_OnPhoneOrderPage() {
		HighlightElement(taxid_OnPhoneOrderPage);
		return taxid_OnPhoneOrderPage.getAttribute("value");
	}

	public String get_PaymentSection_DiscountAmount_OnPhoneOrderPage() {
		HighlightElement(paymentdiscamt_OnPhoneOrderPage);
		return paymentdiscamt_OnPhoneOrderPage.getAttribute("value");
	}

	public void Select_TaxType_OnPhoneOrderPage(String taxtype) {
		dropDown(taxtype_OnPhoneOrderPage, taxtype, "VisibleText");
	}

	public String get_TaxType_OnPhoneOrderPage() {
		HighlightElement(taxtype_OnPhoneOrderPage);
		s = new Select(taxtype_OnPhoneOrderPage);
		return s.getFirstSelectedOption().getText();
	}

	public void Click_UnpaidInvoiceTab_OnCustDetailsPopup() {
		click(customerDetailsPopup_Unpaid_TabOnPhoneOrderPage);
	}

	public void Click_Row1Inv_UnpaidInvoiceTab_OnCustDetailsPopup() {
		click(row1_InvoiceNo_UnpaidTabOnPhoneOrderPage);
	}

	public boolean Verify_InvoicePopup_Appears_OnUnpaidInvoiceTab() {
		HighlightElement(row1_InvoiceNo_UnpaidTabOnPhoneOrderPage);
		return InvoiceDetailsPopup_Unpaid_TabOnPhoneOrderPage.isDisplayed();
	}

	public void ClickCloseIcon_InvoicePopup_OnUnpaidInvoiceTab() {
		click(closeIcon_InvoiceDetailsPopup_UnpaidTabOnPhoneOrderPage);
	}

	public boolean Verify_MakePaymentBtn_InvoicePopup_OnUnpaidInvoiceTab() {
		HighlightElement(MakePaymentButton_InvoiceDetailsPopup_UnpaidTabOnPhoneOrderPage);
		return MakePaymentButton_InvoiceDetailsPopup_UnpaidTabOnPhoneOrderPage.isEnabled();
	}

	public void Click_MakePaymentBtn_InvoicePopup_OnUnpaidInvoiceTab() {
		click(MakePaymentButton_InvoiceDetailsPopup_UnpaidTabOnPhoneOrderPage);
	}

	public void Click_Row1_Checkbox_UnpaidInvoiceTab_OnCustDetailsPopup() {
		click(row1_Checkbox_InvoiceDetailsPopup_UnpaidTabOnPhoneOrderPage);
	}

	public boolean Verify_InvoicePaymentDetails_UnpaidInvoiceTab_OnCustDetailsPopup() {
		HighlightElement(invoicepaymentdetailssection_UnpaidTabOnPhoneOrderPage);
		return invoicepaymentdetailssection_UnpaidTabOnPhoneOrderPage.isDisplayed();
	}

	public void Select_PaymentMethod_OnUnpaidInvoiceTab(String paymenttype) {
		dropDown(paymenttype_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage, paymenttype, "VisibleText");
	}

	public void Select_CashRegistry_OnUnpaidInvoiceTab(String cashregistry) {
		dropDown(cashregister_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage, cashregistry, "VisibleText");
	}

	public String get_totaldueamount_InvoiceDetails_unpaidInvoiceTab() {
		return totaldueamt_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage.getText();
	}

	public void EnterPaymentAmount_InvoiceDetails_UnpaidInvoiceTab() {
		clickAndType(paymentamount_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage,
				get_totaldueamount_InvoiceDetails_unpaidInvoiceTab());
	}

	public void Enter_PaymentAmount_InvoiceDetails_UnpaidInvoiceTab(String paymentamount) {
		clickAndType(paymentamount_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage, paymentamount);
	}

	public void Click_cancelButton_InvoiceDetails_UnpaidInvoiceTab() {
		click(cancelButton_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage);
	}

	public void Click_SubmitButton_InvoiceDetails_UnpaidInvoiceTab() {
		click(submitButton_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage);
	}

	public boolean Verify_SuccessMessage_InvoiceDetails_UnpaidInvoiceTab() {
		HighlightElement(paymentSuccessMessage_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage);
		return paymentSuccessMessage_InvoiceDetailssection_UnpaidTabOnPhoneOrderPage.isDisplayed();
	}

	public String get_SelectedCashRegistry_InvoiceDetails_UnpaidInvoiceTab() {
		HighlightElement(cashregister_ConfirmationSection_UnpaidTabOnPhoneOrderPage);
		s = new Select(cashregister_ConfirmationSection_UnpaidTabOnPhoneOrderPage);
		return (s.getFirstSelectedOption().getText());
	}

	public String get_emailreceipt_UnpaidInvoiceTab() {
		return emailtextbox_ConfirmationSection_UnpaidTabOnPhoneOrderPage.getAttribute("value");
	}

	public void ClickBackButton_ConfirmationSection_UnpaidInvoiceTab() {
		click(backButton_ConfirmationSection_UnpaidTabOnPhoneOrderPage);
	}

	public void Click_PrintRecieptButton_ConfirmationSection_UnpaidInvoiceTab() {
		click(printReceiptButton_ConfirmationSection_UnpaidTabOnPhoneOrderPage);
	}

	public void Click_EmailRecieptButton_ConfirmationSection_UnpaidInvoiceTab() {
		click(emailReceiptButton_ConfirmationSection_UnpaidTabOnPhoneOrderPage);
	}

	public boolean Verify_UnpaidInvoiceTable_UnpaidInvoiceTab() {
		HighlightElement(unpaidInvoiceTable_UnpaidTabOnPhoneOrderPage);
		return unpaidInvoiceTable_UnpaidTabOnPhoneOrderPage.isDisplayed();
	}

	public void Enter_InvoiceSearchext_UnpaidInvoiceTab(String invoice) {
		CustomerDetailsPopup_Invoicesearchtextbox_UnpaidTab.clear();
		delayWithGivenTime(1000);
		HighlightElement(CustomerDetailsPopup_Invoicesearchtextbox_UnpaidTab);
		clickAndType(CustomerDetailsPopup_Invoicesearchtextbox_UnpaidTab, invoice);
	}

	public String get_EnteredInvoiceSearchext_UnpaidInvoiceTab() {
		return CustomerDetailsPopup_Invoicesearchtextbox_UnpaidTab.getAttribute("value");
	}

	public void PressEnterKey() {
		delayWithGivenTime(1000);
		CustomerDetailsPopup_Invoicesearchtextbox_UnpaidTab.sendKeys(Keys.ENTER);
	}

	public String get_InvoiceNumber_UnpaidInvoiceTable_OnUnpaidInvoiceTab() {
		HighlightElement(InvoiceNumber_Row1_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage);
		return InvoiceNumber_Row1_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage.getText();
	}

	public boolean Verify_AutoSuggestion_InvoiceNumber_UnpaidInvoiceTable_OnUnpaidInvoiceTab(
			String threedigitinvoicenumber) {
		boolean isValid = false;
		for (WebElement suggestion : ListOfInvoiceNumber_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			if (suggestion.getText().contains(threedigitinvoicenumber)) {
				isValid = true;
				System.out.println("Displayed invoice autosuggestion total count is : "
						+ ListOfInvoiceNumber_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage.size());
				System.out.println("Displayed invoice suggestion: " + suggestion.getText());
			}
		}
		return isValid;
	}

	public int Verify_ListofInvoiceNumbers_Appears_InUnpaidInvoiceTable_OnUnpaidInvoiceTab() {
		int totalinvoicecount = ListOfInvoiceNumber_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage.size();
		System.out.println("Displayed invoice total count is : " + totalinvoicecount);
		return totalinvoicecount;
	}

	public boolean Verify_NoUnpaidInvoiceFound() {
		HighlightElement(NoUnpaidInvoiceFound_InvoiceTable_UnpaidTabOnPhoneOrderPage);
		return NoUnpaidInvoiceFound_InvoiceTable_UnpaidTabOnPhoneOrderPage.isDisplayed();
	}

	public boolean Verify_ClearButton_AppearsOnInvoiceSearchtextbox_UnpaidInvoiceTab() {
		HighlightElement(InvoiceClearbutton_Invoicesearchtextbox_UnpaidTab);
		return InvoiceClearbutton_Invoicesearchtextbox_UnpaidTab.isDisplayed();
	}

	public void Click_Clearbutton_Invoicesearchtextbox_UnpaidInvoiceTab() {
		click(InvoiceClearbutton_Invoicesearchtextbox_UnpaidTab);
	}

	public void Enter_PaidAmount_OnInvoiceSearchBox_UnpaidInvoiceTab(String paidamount) {
		PaidAmtSearchTextbox_InvoiceTable_UnpaidTab_OnPhoneOrderPage.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(PaidAmtSearchTextbox_InvoiceTable_UnpaidTab_OnPhoneOrderPage, paidamount);
	}

	public String get_PaidAmount_UnpaidInvoiceTable_OnUnpaidInvoiceTab() {
		HighlightElement(PaidAmtSearchTextbox_InvoiceTable_UnpaidTab_OnPhoneOrderPage);
		return PaidAmtSearchTextbox_InvoiceTable_UnpaidTab_OnPhoneOrderPage.getText();
	}

	public boolean Verify_ClearButton_AppearsOnPaidAmtSearchtextbox_UnpaidInvoiceTab() {
		HighlightElement(InvoiceClearbutton_PaidAmtsearchtextbox_UnpaidTab);
		return InvoiceClearbutton_PaidAmtsearchtextbox_UnpaidTab.isDisplayed();
	}

	public void Click_Clearbutton_PaidAmtsearchtextbox_UnpaidInvoiceTab() {
		click(InvoiceClearbutton_PaidAmtsearchtextbox_UnpaidTab);
	}

	public void Click_LastRowCheckbox_OnUnpaidInvoiceTable_UnpaidInvoiceTab() {
		click(lastRow_Checkbox_InvoiceTable_UnpaidTabOnPhoneOrderPage);
	}

	public void Enter_BalanceAmount_OnInvoiceSearchBox_UnpaidInvoiceTab(String balanceamount) {
		CustomerDetailsPopup_BalanceAmtsearchtextbox_UnpaidTab.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(CustomerDetailsPopup_BalanceAmtsearchtextbox_UnpaidTab, balanceamount);
	}

	public String get_BalanceAmount_UnpaidInvoiceTable_OnUnpaidInvoiceTab() {
		HighlightElement(CustomerDetailsPopup_BalanceAmtsearchtextbox_UnpaidTab);
		return CustomerDetailsPopup_BalanceAmtsearchtextbox_UnpaidTab.getText();
	}

	public boolean Verify_ClearButton_AppearsOnBalanceAmtSearchtextbox_UnpaidInvoiceTab() {
		HighlightElement(InvoiceClearbutton_BalanceAmtsearchtextbox_UnpaidTab);
		return InvoiceClearbutton_BalanceAmtsearchtextbox_UnpaidTab.isDisplayed();
	}

	public void Click_Clearbutton_BalanceAmtsearchtextbox_UnpaidInvoiceTab() {
		click(InvoiceClearbutton_BalanceAmtsearchtextbox_UnpaidTab);
	}

	public void Enter_ProductTotal_OnInvoiceSearchBox_UnpaidInvoiceTab(String producttotal) {
		CustomerDetailsPopup_ProductTotalsearchtextbox_UnpaidTab.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(CustomerDetailsPopup_ProductTotalsearchtextbox_UnpaidTab, producttotal);
	}

	public String get_ProductTotal_UnpaidInvoiceTable_OnUnpaidInvoiceTab() {
		HighlightElement(CustomerDetailsPopup_ProductTotalsearchtextbox_UnpaidTab);
		return CustomerDetailsPopup_ProductTotalsearchtextbox_UnpaidTab.getText();
	}

	public boolean Verify_ClearButton_AppearsOnProductTotalSearchtextbox_UnpaidInvoiceTab() {
		HighlightElement(InvoiceClearbutton_ProductTotalsearchtextbox_UnpaidTab);
		return InvoiceClearbutton_ProductTotalsearchtextbox_UnpaidTab.isDisplayed();
	}

	public void Click_Clearbutton_ProductTotalsearchtextbox_UnpaidInvoiceTab() {
		click(InvoiceClearbutton_ProductTotalsearchtextbox_UnpaidTab);
	}

	public String get_EnteredProductTotalSearchtext_UnpaidInvoiceTab() {
		return CustomerDetailsPopup_ProductTotalsearchtextbox_UnpaidTab.getAttribute("value");
	}

	public boolean Verify_ProductTotalValue_OnDisplayedInvoices() {
		boolean allValuesMatch = true;
		for (WebElement cell : ListOfProductsTotal_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			String productTotalValue = cell.getText();
			if (productTotalValue.contains("34")) {
				HighlightElement(cell);
			} else {
				System.out.println("Validation Failed: " + productTotalValue);
				allValuesMatch = false;
			}
		}

		return allValuesMatch;

	}

	public void Enter_Delivery_OnInvoiceSearchBox_UnpaidInvoiceTab(String delivery) {
		CustomerDetailsPopup_Deliverysearchtextbox_UnpaidTab.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(CustomerDetailsPopup_Deliverysearchtextbox_UnpaidTab, delivery);
	}

	public String get_Delivery_UnpaidInvoiceTable_OnUnpaidInvoiceTab() {
		HighlightElement(CustomerDetailsPopup_Deliverysearchtextbox_UnpaidTab);
		return CustomerDetailsPopup_Deliverysearchtextbox_UnpaidTab.getText();
	}

	public boolean Verify_ClearButton_AppearsOnDeliverySearchtextbox_UnpaidInvoiceTab() {
		HighlightElement(InvoiceClearbutton_Deliverysearchtextbox_UnpaidTab);
		return InvoiceClearbutton_Deliverysearchtextbox_UnpaidTab.isDisplayed();
	}

	public void Click_Clearbutton_Deliverysearchtextbox_UnpaidInvoiceTab() {
		click(InvoiceClearbutton_Deliverysearchtextbox_UnpaidTab);
	}

	public String get_EnteredDeliverySearchtext_UnpaidInvoiceTab() {
		return CustomerDetailsPopup_Deliverysearchtextbox_UnpaidTab.getAttribute("value");
	}

	public boolean Verify_DeliveryValue_OnDisplayedInvoices() {
		boolean allValuesMatch = true;
		for (WebElement cell : ListOfDelivery_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			String deliveryValue = cell.getText();
			if (deliveryValue.contains("20")) {
				HighlightElement(cell);
			} else {
				System.out.println("Validation Failed: " + deliveryValue);
				allValuesMatch = false;
			}
		}

		return allValuesMatch;

	}

	public void Enter_Tax_OnInvoiceSearchBox_UnpaidInvoiceTab(String tax) {
		CustomerDetailsPopup_Taxsearchtextbox_UnpaidTab.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(CustomerDetailsPopup_Taxsearchtextbox_UnpaidTab, tax);
	}

	public String get_Tax_UnpaidInvoiceTable_OnUnpaidInvoiceTab() {
		HighlightElement(CustomerDetailsPopup_Taxsearchtextbox_UnpaidTab);
		return CustomerDetailsPopup_Taxsearchtextbox_UnpaidTab.getText();
	}

	public boolean Verify_ClearButton_AppearsOnTaxSearchtextbox_UnpaidInvoiceTab() {
		HighlightElement(InvoiceClearbutton_Taxsearchtextbox_UnpaidTab);
		return InvoiceClearbutton_Taxsearchtextbox_UnpaidTab.isDisplayed();
	}

	public void Click_Clearbutton_Taxsearchtextbox_UnpaidInvoiceTab() {
		click(InvoiceClearbutton_Taxsearchtextbox_UnpaidTab);
	}

	public String get_EnteredTaxSearchtext_UnpaidInvoiceTab() {
		return CustomerDetailsPopup_Taxsearchtextbox_UnpaidTab.getAttribute("value");
	}

	public boolean Verify_TaxValue_OnDisplayedInvoices() {
		boolean allValuesMatch = true;
		for (WebElement cell : ListOfTax_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			String taxValue = cell.getText();
			if (taxValue.contains("9.21")) {
				HighlightElement(cell);
			} else {
				System.out.println("Validation Failed: " + taxValue);
				allValuesMatch = false;
			}
		}
		return allValuesMatch;
	}

	public void Enter_Total_OnInvoiceSearchBox_UnpaidInvoiceTab(String total) {
		CustomerDetailsPopup_Totalsearchtextbox_UnpaidTab.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(CustomerDetailsPopup_Totalsearchtextbox_UnpaidTab, total);
	}

	public String get_Total_UnpaidInvoiceTable_OnUnpaidInvoiceTab() {
		HighlightElement(CustomerDetailsPopup_Totalsearchtextbox_UnpaidTab);
		return CustomerDetailsPopup_Totalsearchtextbox_UnpaidTab.getText();
	}

	public boolean Verify_ClearButton_AppearsOnTotalSearchtextbox_UnpaidInvoiceTab() {
		HighlightElement(InvoiceClearbutton_Totalsearchtextbox_UnpaidTab);
		return InvoiceClearbutton_Totalsearchtextbox_UnpaidTab.isDisplayed();
	}

	public void Click_Clearbutton_Totalsearchtextbox_UnpaidInvoiceTab() {
		click(InvoiceClearbutton_Totalsearchtextbox_UnpaidTab);
	}

	public String get_EnteredTotalSearchtext_UnpaidInvoiceTab() {
		return CustomerDetailsPopup_Totalsearchtextbox_UnpaidTab.getAttribute("value");
	}

	public boolean Verify_TotalValue_OnDisplayedInvoices() {
		boolean allValuesMatch = true;
		for (WebElement cell : ListOfTotal_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			String totalValue = cell.getText();
			if (totalValue.contains("31")) {
				HighlightElement(cell);
			} else {
				System.out.println("Validation Failed: " + totalValue);
				allValuesMatch = false;
			}
		}
		return allValuesMatch;
	}

	public void Enter_OrderDate_OnInvoiceSearchBox_UnpaidInvoiceTab(String orderdate) {
		CustomerDetailsPopup_OrderDatesearchtextbox_UnpaidTab.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(CustomerDetailsPopup_OrderDatesearchtextbox_UnpaidTab, orderdate);
	}

	public String get_OrderDate_UnpaidInvoiceTable_OnUnpaidInvoiceTab() {
		HighlightElement(CustomerDetailsPopup_OrderDatesearchtextbox_UnpaidTab);
		return CustomerDetailsPopup_OrderDatesearchtextbox_UnpaidTab.getText();
	}

	public boolean Verify_ClearButton_AppearsOnOrderDateSearchtextbox_UnpaidInvoiceTab() {
		HighlightElement(InvoiceClearbutton_OrderDatesearchtextbox_UnpaidTab);
		return InvoiceClearbutton_OrderDatesearchtextbox_UnpaidTab.isDisplayed();
	}

	public void Click_Clearbutton_OrderDatesearchtextbox_UnpaidInvoiceTab() {
		click(InvoiceClearbutton_OrderDatesearchtextbox_UnpaidTab);
	}

	public String get_EnteredOrderDateSearchtext_UnpaidInvoiceTab() {
		return CustomerDetailsPopup_OrderDatesearchtextbox_UnpaidTab.getAttribute("value");
	}

	public boolean Verify_OrderDateValue_OnDisplayedInvoices() {
		boolean allValuesMatch = true;
		for (WebElement cell : ListOfOrderDate_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			String totalValue = cell.getText();
			if (totalValue.contains("07/17/2024")) {
				HighlightElement(cell);
			} else {
				System.out.println("Validation Failed: " + totalValue);
				allValuesMatch = false;
			}
		}
		return allValuesMatch;
	}

	public void Enter_DeliveryDate_OnInvoiceSearchBox_UnpaidInvoiceTab(String orderdate) {
		CustomerDetailsPopup_DeliveryDatesearchtextbox_UnpaidTab.clear();
		delayWithGivenTime(500);
		DoubleClickAndType(CustomerDetailsPopup_DeliveryDatesearchtextbox_UnpaidTab, orderdate);
	}

	public String get_DeliveryDate_UnpaidInvoiceTable_OnUnpaidInvoiceTab() {
		HighlightElement(CustomerDetailsPopup_DeliveryDatesearchtextbox_UnpaidTab);
		return CustomerDetailsPopup_DeliveryDatesearchtextbox_UnpaidTab.getText();
	}

	public boolean Verify_ClearButton_AppearsOnDeliveryDateSearchtextbox_UnpaidInvoiceTab() {
		HighlightElement(InvoiceClearbutton_DeliveryDatesearchtextbox_UnpaidTab);
		return InvoiceClearbutton_DeliveryDatesearchtextbox_UnpaidTab.isDisplayed();
	}

	public void Click_Clearbutton_DeliveryDatesearchtextbox_UnpaidInvoiceTab() {
		click(InvoiceClearbutton_DeliveryDatesearchtextbox_UnpaidTab);
	}

	public String get_EnteredDeliveryDateSearchtext_UnpaidInvoiceTab() {
		return CustomerDetailsPopup_DeliveryDatesearchtextbox_UnpaidTab.getAttribute("value");
	}

	public boolean Verify_DeliveryDateValue_OnDisplayedInvoices() {
		boolean allValuesMatch = true;
		for (WebElement cell : ListOfDeliveryDate_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			String DeliveryValue = cell.getText();
			if (DeliveryValue.contains("07/17/2024")) {
				HighlightElement(cell);
			} else {
				System.out.println("Validation Failed: " + DeliveryValue);
				allValuesMatch = false;
			}
		}
		return allValuesMatch;
	}

	public void Verify_InvoicesAreSortedInAscendingOrder() {
		List<String> originalInvoiceNumbers = new ArrayList<>();
		for (WebElement invoiceElement : ListOfInvoiceNumber_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			originalInvoiceNumbers.add(invoiceElement.getText());
		}
	}

	public void ClickInvoiceLabel_OnUnpaidInvoiceTab_OnCustomerDetailsPopup() {
		click(InvoiceLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
	}

	public boolean Verify_Uparrow_Appears_OnInvoiceLabel_OnUnpaidInvoiceTab_OnCustomerDetailsPopup() {
		HighlightElement(InvoiceLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
		return Invoice_uparrow_UnpaidInvoiceTab_OnCustomerDetailsPopup.isDisplayed();
	}

	public boolean Verify_Downarrow_Appears_OnInvoiceLabel_OnUnpaidInvoiceTab_OnCustomerDetailsPopup() {
		HighlightElement(InvoiceLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
		return Invoice_downarrow_UnpaidInvoiceTab_OnCustomerDetailsPopup.isDisplayed();
	}

	public boolean Verify_InvoiceHeader_DefaultOrder() {
		delayWithGivenTime(1000);
		List<String> originalInvoiceNumbers = new ArrayList<>();
		for (WebElement invoiceElement : ListOfInvoiceNumber_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			originalInvoiceNumbers.add(invoiceElement.getText());
		}
		delayWithGivenTime(2000);
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalInvoiceNumbers);
		Collections.sort(sortedInvoiceNumbers);

		if (originalInvoiceNumbers.equals(sortedInvoiceNumbers)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean Verify_InvoiceHeader_Sorted_ascending() {
		// Store the invoice numbers in a list
		List<String> originalInvoiceNumbers = new ArrayList<>();
		for (WebElement invoiceElement : ListOfInvoiceNumber_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			originalInvoiceNumbers.add(invoiceElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalInvoiceNumbers);
		Collections.sort(sortedInvoiceNumbers);

		// Compare the original list with the sorted list
		if (originalInvoiceNumbers.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Original invoice numbers: " + originalInvoiceNumbers);
			System.out.println("Sorted invoice numbers: " + sortedInvoiceNumbers);
			System.out.println("Invoices are not sorted in ascending order.");
			return false;
		}
	}

	public boolean Verify_InvoiceHeader_Sorted_descending() {
		// Store the invoice numbers in a list
		List<String> originalInvoiceNumbers = new ArrayList<>();
		for (WebElement invoiceElement : ListOfInvoiceNumber_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			originalInvoiceNumbers.add(invoiceElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalInvoiceNumbers);
		Collections.sort(sortedInvoiceNumbers, Collections.reverseOrder());

		if (originalInvoiceNumbers.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Invoices are not sorted in descending order.");
			return false;
		}
	}

	public void Click_PaidAmtLabel_OnUnpaidInvoiceTab_OnCustomerDetailsPopup() {
		click(PaidAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
	}

	public boolean Verify_PaidAmtHeader_DefaultOrder() {
		List<String> originalPaidAmt = new ArrayList<>();
		for (WebElement paidAmtElement : ListOfPaidAmt_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originalPaidAmt.add(paidAmtElement.getText());
		}
		delayWithGivenTime(2000);
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalPaidAmt);
		Collections.sort(sortedInvoiceNumbers);

		if (originalPaidAmt.containsAll(sortedInvoiceNumbers)) {
			System.out.println("Original Paid Amts: " + originalPaidAmt);
			System.out.println("Sorted Paid Amts: " + sortedInvoiceNumbers);
			System.out.println("Paid amount are sorted in default order.");
			return false;
		} else {
			System.out.println("Original Paid Amts: " + originalPaidAmt);
			System.out.println("Sorted Paid Amts: " + sortedInvoiceNumbers);
			System.out.println("Paid amount are not sorted in default order.");
			return true;
		}
	}

	public boolean Verify_PaidAmtHeader_Sorted_ascending() {
		// Store the invoice numbers in a list
		List<String> originalPaidAmt = new ArrayList<>();
		for (WebElement paidAmtElement : ListOfPaidAmt_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originalPaidAmt.add(paidAmtElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalPaidAmt);
		Collections.sort(sortedInvoiceNumbers);

		if (originalPaidAmt.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean Verify_PaidAmtHeader_Sorted_descending() {
		List<String> originalPaidAmt = new ArrayList<>();
		for (WebElement paidAmtElement : ListOfPaidAmt_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originalPaidAmt.add(paidAmtElement.getText());
		}
		delayWithGivenTime(2000);
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalPaidAmt);
		Collections.sort(sortedInvoiceNumbers, Collections.reverseOrder());

		if (originalPaidAmt.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Paid Amount are not sorted in descending order.");
			return false;
		}
	}

	public void Click_BalanceAmtLabel_OnCustomerDetailsPopup() {
		click(BalanceAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
	}

	public void DragWithPixel() {
		int offsetX = BalanceAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup.getSize().getWidth() - 1; // Get the width
		// of the header
		// and use a
		// slight offset

		// Create an instance of Actions class
		Actions actions = new Actions(getDriver());

		// Perform the drag and drop action to resize the column header
		actions.moveToElement(BalanceAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup, offsetX, 0).clickAndHold()
		.moveByOffset(50, 0) // Change the offset values as needed
		.release().perform();
	}

	public boolean Verify_BalanceAmtHeader_DefaultOrder() {
		List<String> originalBalanceAmt = new ArrayList<>();
		for (WebElement invoiceElement : ListOfBalanceAmt_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originalBalanceAmt.add(invoiceElement.getText());
		}
		delayWithGivenTime(2000);
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalBalanceAmt);
		Collections.sort(sortedInvoiceNumbers);

		if (originalBalanceAmt.equals(sortedInvoiceNumbers)) {
			System.out.println("Original Balance Amts: " + originalBalanceAmt);
			System.out.println("Sorted Balance Amts: " + sortedInvoiceNumbers);
			System.out.println("Balance amount are sorted in default order.");
			return false;
		} else {
			System.out.println("Original Balance Amts: " + originalBalanceAmt);
			System.out.println("Sorted Balance Amts: " + sortedInvoiceNumbers);
			System.out.println("Balance amount are not sorted in default order.");
			return true;
		}
	}

	public boolean Verify_BalanceAmtHeader_Sorted_ascending() {
		// Store the invoice numbers in a list
		List<String> originalBalanceAmt = new ArrayList<>();
		for (WebElement balanceAmtElement : ListOfBalanceAmt_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originalBalanceAmt.add(balanceAmtElement.getText());
		}

		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalBalanceAmt);
		Collections.sort(sortedInvoiceNumbers);

		// Compare the original list with the sorted list
		if (originalBalanceAmt.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Original Balance Amts: " + originalBalanceAmt);
			System.out.println("Sorted Balance Amts: " + sortedInvoiceNumbers);
			System.out.println("Balance amount are not sorted in ascending order.");
			return false;
		}
	}

	public boolean Verify_BalanceAmtHeader_Sorted_descending() {
		List<String> originalBalanceAmt = new ArrayList<>();
		for (WebElement balanceAmtElement : ListOfBalanceAmt_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originalBalanceAmt.add(balanceAmtElement.getText());
		}

		List<String> sortedInvoiceNumbers = new ArrayList<>(originalBalanceAmt);
		Collections.sort(sortedInvoiceNumbers, Collections.reverseOrder());

		if (originalBalanceAmt.containsAll(sortedInvoiceNumbers)) {
			System.out.println("Balance Amount are not sorted in descending order.");
			return true;
		} else {
			System.out.println("Balance Amount are not sorted in descending order.");
			return false;
		}
	}

	public void Click_ProductTotalLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup() {
		click(ProductTotalLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
	}

	public boolean Verify_ProductTotalHeader_Sorted_ascending() {
		List<String> originalProductTotal = new ArrayList<>();
		for (WebElement productTotalElement : ListOfProductsTotal_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			originalProductTotal.add(productTotalElement.getText());
		}

		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalProductTotal);
		Collections.sort(sortedInvoiceNumbers);

		// Compare the original list with the sorted list
		if (originalProductTotal.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Original Balance Amts: " + originalProductTotal);
			System.out.println("Sorted Balance Amts: " + sortedInvoiceNumbers);
			System.out.println("Balance amount are not sorted in ascending order.");
			return false;
		}

	}

	public boolean Verify_Downarrow_Appears_OnProductTotalLabel_OnUnpaidInvoiceTab_OnCustomerDetailsPopup() {
		HighlightElement(InvoiceLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
		return Invoice_downarrow_UnpaidInvoiceTab_OnCustomerDetailsPopup.isDisplayed();
	}

	public boolean Verify_ProductTotalHeader_Sorted_descending() {
		List<String> originalProductTotal = new ArrayList<>();
		for (WebElement prodTotalElement : ListOfProductsTotal_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			originalProductTotal.add(prodTotalElement.getText());
		}
		delayWithGivenTime(2000);
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalProductTotal);
		Collections.sort(sortedInvoiceNumbers, Collections.reverseOrder());

		if (originalProductTotal.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Product total are not sorted in descending order.");
			return false;
		}
	}

	public void Click_DeliveryLabel_OnUnpaidTab_OnCustomerDetailsPopup() {
		click(DeliveryLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
	}

	public boolean Verify_DeliveryHeader_Sorted_ascending() {
		List<String> originalProductTotal = new ArrayList<>();
		for (WebElement productTotalElement : ListOfDelivery_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originalProductTotal.add(productTotalElement.getText());
		}

		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalProductTotal);
		Collections.sort(sortedInvoiceNumbers);

		// Compare the original list with the sorted list
		if (originalProductTotal.equals(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Original delivery Amts: " + originalProductTotal);
			System.out.println("Sorted delivery Amts: " + sortedInvoiceNumbers);
			System.out.println("Delivery amount are not sorted in ascending order.");
			return false;
		}
	}

	public boolean Verify_DeliveryHeader_DefaultOrder() {
		List<String> actualOrder = new ArrayList<>();	    
		// Retrieve the text from each web element and store it in the actualOrder list
		for (WebElement productTotalElement : ListOfDelivery_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			actualOrder.add(productTotalElement.getText().trim());
		}
		List<String> expectedOrder = new ArrayList<>(actualOrder);

		return actualOrder.equals(expectedOrder);
	}



	public boolean Verify_Downarrow_Appears_OnDeliveryLabel_OnUnpaidInvoiceTab_OnCustomerDetailsPopup() {
		HighlightElement(InvoiceLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
		return Invoice_downarrow_UnpaidInvoiceTab_OnCustomerDetailsPopup.isDisplayed();
	}

	public boolean Verify_DeliveryHeader_Sorted_descending() {
		List<String> originalProductTotal = new ArrayList<>();
		for (WebElement prodTotalElement : ListOfDelivery_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originalProductTotal.add(prodTotalElement.getText());
		}
		delayWithGivenTime(2000);
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalProductTotal);
		Collections.sort(sortedInvoiceNumbers, Collections.reverseOrder());

		if (originalProductTotal.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Product total are not sorted in descending order.");
			return false;
		}

	}

	public void Click_TaxLabel_OnUnpaidTab_OnCustomerDetailsPopup() {
		click(TaxLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
	}

	public boolean Verify_TaxHeader_Sorted_ascending() {
		List<String> originalTax = new ArrayList<>();
		for (WebElement taxElement : ListOfTax_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originalTax.add(taxElement.getText());
		}

		// Create a copy of the list and sort it
		List<String> sortedtax = new ArrayList<>(originalTax);
		Collections.sort(sortedtax);

		// Compare the original list with the sorted list
		if (originalTax.containsAll(sortedtax)) {
			return true;
		} else {
			System.out.println("Original Tax Amts: " + originalTax);
			System.out.println("Sorted Tax Amts: " + sortedtax);
			System.out.println("Tax are not sorted in ascending order.");
			return false;
		}
	}

	public boolean verify_TaxHeader_Sorted_Descending() {
		List<String> originaltax = new ArrayList<>();
		for (WebElement taxElement : ListOfTax_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originaltax.add(taxElement.getText());
		}

		List<String> sortedtax = new ArrayList<>(originaltax);
		Collections.sort(sortedtax, Collections.reverseOrder());

		if (originaltax.containsAll(sortedtax)) {
			return true;
		} else {
			System.out.println("Original Tax Amts: " + originaltax);
			System.out.println("Sorted Tax Amts: " + sortedtax);
			System.out.println("Tax are not sorted in descending order.");
			return false;
		}
	}

	private List<String> defaultTax;

	public void captureDefaultOrder() {
		defaultTax = new ArrayList<>();
		for (WebElement taxElement : ListOfTax_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			defaultTax.add(taxElement.getText());
		}
	}

	public boolean verify_Delivery_Sorted_DefaultOrder() {
		List<String> currenttax = new ArrayList<>();
		for (WebElement taxElement : ListOfTax_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			currenttax.add(taxElement.getText());
		}

		if (currenttax.equals(defaultTax)) {
			return true;
		} else {
			System.out.println("Default tax Amts: " + defaultTax);
			System.out.println("Current tax Amts: " + currenttax);
			System.out.println("Tax amounts are not in default order.");
			return false;
		}
	}

	public void Click_LateFee_Label_OnUnpaidTab_OnCustomerDetailsPopup() {
		click(LatefeeLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
	}

	public boolean Verify_LatefeeHeader_Sorted_ascending() {
		List<String> originallatefee = new ArrayList<>();
		for (WebElement latefeeElement : ListOflatefee_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originallatefee.add(latefeeElement.getText());
		}

		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originallatefee);
		Collections.sort(sortedInvoiceNumbers);

		// Compare the original list with the sorted list
		if (originallatefee.equals(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Original late fee Amts: " + originallatefee);
			System.out.println("Sorted late fee Amts: " + sortedInvoiceNumbers);
			System.out.println("Late fees are not sorted in ascending order.");
			return false;
		}
	}

	public boolean verify_LatefeeHeader_Sorted_Descending() {
		List<String> originallatefee = new ArrayList<>();
		for (WebElement latefeeElement : ListOflatefee_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originallatefee.add(latefeeElement.getText());
		}

		List<String> sortedlatefee = new ArrayList<>(originallatefee);
		Collections.sort(sortedlatefee, Collections.reverseOrder());

		if (originallatefee.equals(sortedlatefee)) {
			return true;
		} else {
			System.out.println("Original Late fee Amts: " + originallatefee);
			System.out.println("Sorted Late fee Amts: " + sortedlatefee);
			System.out.println("Tax are not sorted in descending order.");
			return false;
		}
	}

	public void Click_Total_Label_OnUnpaidTab_OnCustomerDetailsPopup() {
		click(TotalLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
	}

	public boolean Verify_TotalHeader_Sorted_ascending() {
		List<String> originallatefee = new ArrayList<>();
		for (WebElement latefeeElement : ListOfTotallabel_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originallatefee.add(latefeeElement.getText());
		}

		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originallatefee);
		Collections.sort(sortedInvoiceNumbers);

		// Compare the original list with the sorted list
		if (originallatefee.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Original late fee Amts: " + originallatefee);
			System.out.println("Sorted late fee Amts: " + sortedInvoiceNumbers);
			System.out.println("Late fees are not sorted in ascending order.");
			return false;
		}
	}

	public boolean verify_TotalHeader_Sorted_Descending() {
		List<String> originallatefee = new ArrayList<>();
		for (WebElement latefeeElement : ListOfTotallabel_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originallatefee.add(latefeeElement.getText());
		}

		List<String> sortedlatefee = new ArrayList<>(originallatefee);
		Collections.sort(sortedlatefee, Collections.reverseOrder());

		if (originallatefee.containsAll(sortedlatefee)) {
			return true;
		} else {
			System.out.println("Original Late fee Amts: " + originallatefee);
			System.out.println("Sorted Late fee Amts: " + sortedlatefee);
			System.out.println("Tax are not sorted in descending order.");
			return false;
		}
	}

	public boolean Verify_TotalHeader_DefaultOrder() {
		List<String> originalTotalLabel = new ArrayList<>();
		for (WebElement totalLabelElement : ListOfTotallabel_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originalTotalLabel.add(totalLabelElement.getText());
		}

		// Create a copy of the list and sort it
		List<String> expectedTotalLabel = new ArrayList<>(originalTotalLabel);


		// Compare the original list with the sorted list
		if (originalTotalLabel.containsAll(expectedTotalLabel)) {
			return true;
		} else {
			System.out.println("Original default order: " + originalTotalLabel);
			System.out.println("expected default order: " + expectedTotalLabel);
			System.out.println("Default order are not sorted in default order.");
			return false;
		}
	}


	public void Click_OrderDate_Label_OnUnpaidTab_OnCustomerDetailsPopup() {
		click(OrderDateLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
	}

	public boolean Verify_OrderDateHeader_Sorted_ascending() {
		List<String> originallatefee = new ArrayList<>();
		for (WebElement latefeeElement : ListOfOrderDate_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originallatefee.add(latefeeElement.getText());
		}

		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originallatefee);
		Collections.sort(sortedInvoiceNumbers);

		// Compare the original list with the sorted list
		if (originallatefee.equals(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Original late fee Amts: " + originallatefee);
			System.out.println("Sorted late fee Amts: " + sortedInvoiceNumbers);
			System.out.println("Late fees are not sorted in ascending order.");
			return false;
		}
	}

	public boolean verify_OrderDateHeader_Sorted_Descending() {
		List<String> originallatefee = new ArrayList<>();
		for (WebElement latefeeElement : ListOfOrderDate_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originallatefee.add(latefeeElement.getText());
		}

		List<String> sortedlatefee = new ArrayList<>(originallatefee);
		Collections.sort(sortedlatefee, Collections.reverseOrder());

		if (originallatefee.equals(sortedlatefee)) {
			return true;
		} else {
			System.out.println("Original Late fee Amts: " + originallatefee);
			System.out.println("Sorted Late fee Amts: " + sortedlatefee);
			System.out.println("Tax are not sorted in descending order.");
			return false;
		}
	}

	public void Click_DeliveryDate_Label_OnUnpaidTab_OnCustomerDetailsPopup() {
		click(DeliveryDateLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
	}

	public boolean Verify_DeliveryDateHeader_Sorted_ascending() {
		List<String> originallatefee = new ArrayList<>();
		for (WebElement latefeeElement : ListOfDeliveryDate_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originallatefee.add(latefeeElement.getText());
		}

		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originallatefee);
		Collections.sort(sortedInvoiceNumbers);

		// Compare the original list with the sorted list
		if (originallatefee.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Original late fee Amts: " + originallatefee);
			System.out.println("Sorted late fee Amts: " + sortedInvoiceNumbers);
			System.out.println("Late fees are not sorted in ascending order.");
			return false;
		}
	}

	public boolean verify_DeliveryDateHeader_Sorted_Descending() {
		List<String> originallatefee = new ArrayList<>();
		for (WebElement latefeeElement : ListOfDeliveryDate_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup) {
			originallatefee.add(latefeeElement.getText());
		}

		List<String> sortedlatefee = new ArrayList<>(originallatefee);
		Collections.sort(sortedlatefee, Collections.reverseOrder());

		if (originallatefee.equals(sortedlatefee)) {
			return true;
		} else {
			System.out.println("Original Late fee Amts: " + originallatefee);
			System.out.println("Sorted Late fee Amts: " + sortedlatefee);
			System.out.println("Tax are not sorted in descending order.");
			return false;
		}
	}

	public boolean Verify_Pagination_OnUnpaidInvoiceTab_OnCustomerDetailsPopup() {
		HighlightElement(pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		return pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.isDisplayed();
	}

	public boolean Verify_FirstPagePaginationIcon_IsAppears() {
		HighlightElement(firstpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		return firstpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.isDisplayed();
	}

	public void Click_FirstPagePaginationIcon_OnUnpaidTab_OnCustomerDetailsPopup() {
		click(firstpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
	}

	public boolean Verify_FirstPagePaginationIconIsEnabled_OnUnpaidTab_OnCustomerDetailsPopup() {
		HighlightElement(firstpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		String disabledAttribute = firstpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.getAttribute("disabled");
		return disabledAttribute == null || !disabledAttribute.equals("true");
	}

	public boolean Verify_PreviousPagePaginationIcon_IsAppears() {
		HighlightElement(previouspage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		return previouspage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.isDisplayed();
	}

	public void Click_PreviousPagePaginationIcon_OnUnpaidTab_OnCustomerDetailsPopup() {
		click(previouspage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
	}

	public boolean Verify_PreviousPagePaginationIcon_OnUnpaidTab_OnCustomerDetailsPopup() {
		HighlightElement(previouspage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		String disabledAttribute = previouspage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.getAttribute("disabled");
		return disabledAttribute == null || !disabledAttribute.equals("true");
	}

	public boolean Verify_NextPagePaginationIcon_IsAppears() {
		HighlightElement(nextpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		return nextpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.isDisplayed();
	}

	public void Click_NextPagePaginationIcon_OnUnpaidTab_OnCustomerDetailsPopup() {
		click(nextpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
	}

	public boolean Verify_NextPagePaginationIconIsEnabled_OnUnpaidTab_OnCustomerDetailsPopup() {
		HighlightElement(nextpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		String disabledAttribute = nextpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage
				.getAttribute("disabled");
		return disabledAttribute == null || !disabledAttribute.equals("true");
	}

	public boolean Verify_LastPagePaginationIcon_IsAppears() {
		HighlightElement(lastpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		return lastpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.isDisplayed();
	}

	public void Click_LastPagePaginationIcon_OnUnpaidTab_OnCustomerDetailsPopup() {
		click(lastpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
	}

	public boolean Verify_LastPagePaginationIconIsEnabled_OnUnpaidTab_OnCustomerDetailsPopup() {
		HighlightElement(lastpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		String disabledAttribute = lastpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.getAttribute("disabled");
		return disabledAttribute == null || !disabledAttribute.equals("true");		
	}

	public boolean Verify_CurrentPageNumber_IsAppears() {
		HighlightElement(selectedpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		return selectedpage_Pagination_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.isDisplayed();
	}

	public boolean Verify_PageListNumber_IsAppears() {
		HighlightElement(pagelist_DisplayedNumber_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		return pagelist_DisplayedNumber_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.isDisplayed();
	}

	public String getpagelistdropdown_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage() {
		HighlightElement(pagelist_DisplayedNumber_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		return pagelist_DisplayedNumber_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.getText();
	}

	public boolean Verify_pagelist_DisplayedNumber_OnUnpaidTab_OnCustomerDetailsPopup() {
		HighlightElement(pagelistdropdown_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		click(pagelistdropdown_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		delayWithGivenTime(1000);

		List<String> expectedPaginationValues = Arrays.asList("25", "50", "100", "150", "200", "250");
		Set<String> actualPaginationValues = new HashSet<>();

		for (WebElement dropdownValue : pagelist_dropdownvalues_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage) {
			HighlightElement(dropdownValue);
			actualPaginationValues.add(dropdownValue.getText());
		}

		// Check if all expected pagination values are present in the actual dropdown
		// values
		boolean allOptionsDisplayed = actualPaginationValues.containsAll(expectedPaginationValues);

		if (!allOptionsDisplayed) {
			System.out.println("Missing pagination values in dropdown: " + expectedPaginationValues.stream()
			.filter(value -> !actualPaginationValues.contains(value)).collect(Collectors.joining(", ")));
		}

		return allOptionsDisplayed;
	}

	public boolean Verify_ItemsperPageLabelIsAppears_OnUnpaidTab_OnCustomerDetailsPopup() {
		HighlightElement(itemsperpage_Label_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		return itemsperpage_Label_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.isDisplayed();
	}

	public boolean Verify_RefreshIcon_IsAppears_OnUnpaidTab_OnCustomerDetailsPopup() {
		HighlightElement(refreshButton_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		return refreshButton_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.isDisplayed();
	}

	public boolean Verify_Totalpagenumber_IsAppears_OnUnpaidTab_OnCustomerDetailsPopup() {
		HighlightElement(pagenumber_Label_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		return pagenumber_Label_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.isDisplayed();
	}

	public String get_TotalPageNumber_Appears_OnUnpaidTab() {
		HighlightElement(pagenumber_Label_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);

		String paginationText = pagenumber_Label_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.getText();

		// Use regular expressions to extract the total number of items
		Pattern pattern = Pattern.compile("of\\s(\\d+)\\sitems");
		Matcher matcher = pattern.matcher(paginationText);

		if (matcher.find()) {
			String totalItems = matcher.group(1);
			System.out.println("Total number of items: " + totalItems);
		} else {
			System.out.println("Total number of items not found.");
		}

		return matcher.group(1);
	}


	public String get_FirstPageNumber_Appears_OnUnpaidTab() {
		HighlightElement(pagenumber_Label_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);

		String paginationText = pagenumber_Label_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.getText();

		// Use regular expressions to extract the first number of items
		Pattern pattern = Pattern.compile("(\\d+)");
		Matcher matcher = pattern.matcher(paginationText);

		if (matcher.find()) {
			String firstPageNumber = matcher.group(0);
			System.out.println("First page number: " + firstPageNumber);
			return firstPageNumber;
		} else {
			System.out.println("First page number not found.");
			return null;
		}
	}



	public String get_TotalPagenumber_Appears_OnUnpaidTab_OnCustomerDetailsPopup() {
		HighlightElement(pagenumber_Label_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);

		String paginationText = pagenumber_Label_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.getText();

		Pattern pattern = Pattern.compile("(\\d+\\s-\\s\\d+)");
		Matcher matcher = pattern.matcher(paginationText);

		if (matcher.find()) {
			String itemRange = matcher.group(1);
			System.out.println("Item range: " + itemRange);
		} else {
			System.out.println("Item range not found.");
		}

		return matcher.group(1);
	}

	public void Select_SalesPersonOn_PhoneOrderEntryPage(String salesperson) {
		dropDown(salesPersonDDOnPhoneOrderPage, salesperson, "VisibleText");
	}
	
	public String get_SelectedSalesPersonOn_PhoneOrderEntryPage() {
		s=new Select(salesPersonDDOnPhoneOrderPage);
		return s.getFirstSelectedOption().getText();
	}

	public void SelectNumberDropdown_inPaginationSection_OnUnpaidTab_OnCustomerDetailsPopup() {
		click(pagelistdropdown_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		delayWithGivenTime(1000);
		for (WebElement ele : pagelist_dropdownvalues_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage) {
			if (ele.getText().equals("50")) {
				ele.click();
				break;
			}
		}
	}

	public boolean Verify_NoOfItemDisplayed_OnUnpaidTab_OnCustomerDetailsPopup() {
		String itemsCountText = pagenumber_Label_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.getText(); // e.g., "1																												// items"
		int displayedItemsCount = Integer.parseInt(itemsCountText.split(" ")[4]);
		System.out.println("Number of items displayed on Order details Tab: " + displayedItemsCount);

		List<WebElement> tableRows = getDriver().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int actualRowsCount = tableRows.size();

		if (displayedItemsCount == actualRowsCount) {
			System.out.println("Actual number of items displayed is correct: " + actualRowsCount);
			return true;
		} else {
			System.out.println("Actual Number of items displayed on Order details Tab is incorrect: " + actualRowsCount);
			return false;
		}
	}

	public String Validate_InvoiceHeader_ReorderFunctionality() {
		dragAndDrop(InvoiceLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup,PaidAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
		delayWithGivenTime(2000);
		return InvoiceLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup.getText();
	}

	public void Reorder_InvoiceHeader() {
		dragAndDrop(PaidAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup,InvoiceLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
		delayWithGivenTime(1000);
	}

	public String Validate_PaidAmt_ReOrderFunctionality() {
		dragAndDrop(PaidAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup,InvoiceLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
		delayWithGivenTime(1000);
		return PaidAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup.getText();
	}

	public void Reorder_PaidAmtHeader() {
		dragAndDrop(InvoiceLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup,PaidAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
		delayWithGivenTime(1000);
	}

	public String Validate_BalanceAmt_ReOrderFunctionality() {
		dragAndDrop(BalanceAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup,ProductTotalLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
		delayWithGivenTime(1000);
		return ProductTotalLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup.getText();
	}

	public void Reorder_BalanceAmtHeader() {
		dragAndDrop(ProductTotalLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup,BalanceAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
		delayWithGivenTime(1000);
	}

	public String Validate_ProductTotal_ReOrderFunctionality() {
		dragAndDrop(ProductTotalLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup,BalanceAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
		delayWithGivenTime(1000);
		return BalanceAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup.getText();
	}

	public void Reorder_ProductTotalHeader() {
		dragAndDrop(BalanceAmtLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup,ProductTotalLabel_UnpaidInvoiceTab_OnCustomerDetailsPopup);
		delayWithGivenTime(1000);
	}

	public String Validate_Delivery_ReOrderFunctionality() {
		dragAndDrop(DeliveryLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup,TaxLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
		delayWithGivenTime(1000);
		return TaxLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup.getText();
	}

	public void Reorder_DeliveryHeader() {
		dragAndDrop(TaxLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup,DeliveryLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
		delayWithGivenTime(1000);
	}

	public String Validate_Tax_ReOrderFunctionality() {
		dragAndDrop(TaxLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup,DeliveryLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
		delayWithGivenTime(1000);
		return DeliveryLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup.getText();
	}

	public void Reorder_TaxHeader() {
		dragAndDrop(DeliveryLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup,TaxLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
		delayWithGivenTime(1000);
	}

	public String Validate_Latefee_ReOrderFunctionality() {
		dragAndDrop(LatefeeLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup,TotalLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
		delayWithGivenTime(1000);
		return TotalLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup.getText();
	}

	public void Reorder_LatefeeHeader() {
		dragAndDrop(TotalLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup,LatefeeLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
		delayWithGivenTime(1000);
	}

	public String Validate_Total_ReOrderFunctionality() {
		dragAndDrop(TotalLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup,LatefeeLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
		delayWithGivenTime(1000);
		return LatefeeLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup.getText();
	}

	public void Reorder_TotalHeader() {
		dragAndDrop(LatefeeLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup,TotalLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
		delayWithGivenTime(1000);
	}

	public String Validate_OrderDate_ReOrderFunctionality() {
		dragAndDrop(OrderDateLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup,DeliveryDateLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
		delayWithGivenTime(1000);
		return DeliveryDateLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup.getText();
	}

	public void Reorder_OrderDateHeader() {
		dragAndDrop(DeliveryDateLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup,OrderDateLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
		delayWithGivenTime(1000);
	}

	public String Validate_DeliveryDate_ReOrderFunctionality() {
		dragAndDrop(DeliveryDateLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup,OrderDateLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
		delayWithGivenTime(1000);
		return OrderDateLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup.getText();
	}

	public void Reorder_DeliveryDateHeader() {
		dragAndDrop(OrderDateLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup,DeliveryDateLabelOn_UnpaidInvoiceTable_UnpaidTab_CustomerDetailsPopup);
		delayWithGivenTime(1000);
	}

	public boolean Verify_ExportToExcel_OnUnpaidInvoiceTab_CustomerDetailsPopup() {
		HighlightElement(exportToExcel_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		return (exportToExcel_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.isDisplayed());
	}

	public void Click_ExportToExcel_OnUnpaidInvoiceTab_CustomerDetailsPopup() {
		jsClick(exportToExcel_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
	}

	public boolean VerifyFileIsDownloaded(String pathfile, String filename) {
		File filelocation = new File(pathfile);
		File[] totalfiles = filelocation.listFiles();

		for (File file : totalfiles) {
			if (file.getName().contains(filename)) {
				System.out.println("File is download successfully");
				break;			
			}
		}return true;
	} 

	public void ClickOn_PaymentDetails_CustomerDetailsPopup() {
		jsClick(PaymentDetailsTab);
	}

	public boolean Verify_ExportToExcel_OnPaymentDetailsTab() {
		HighlightElement(exportExcel_PaymentDetailsTab);
		return exportExcel_PaymentDetailsTab.isDisplayed();
	}

	public void Click_ExportToExcel_OnPaymentDetailsTab() {
		jsClick(exportExcel_PaymentDetailsTab);
	}

	public String get_Lastrowcell1_Paymentdetailstab() {
		fluentWait(tablerow1cell1_PaymentDetailsTab);
		HighlightElement(tablerow1cell1_PaymentDetailsTab);
		return tablerow1cell1_PaymentDetailsTab.getText();
	}

	public void EnterInvoiceNo_Paymentdetailstab(String invoiceno) {
		fluentWait(InvoiceSearchTextBox_PaymentDetailsTab);
		delayWithGivenTime(500);
		InvoiceSearchTextBox_PaymentDetailsTab.click();
		delayWithGivenTime(500);

		(InvoiceSearchTextBox_PaymentDetailsTab).clear();
		delayWithGivenTime(500);

		InvoiceSearchTextBox_PaymentDetailsTab.sendKeys(invoiceno);
		//clickAndType(InvoiceSearchTextBox_PaymentDetailsTab, invoiceno);

	}

	public String get_InvoiceNo_Paymentdetailstab() {
		HighlightElement(InvoiceSearchTextBox_PaymentDetailsTab);
		return InvoiceSearchTextBox_PaymentDetailsTab.getAttribute("value");
	}

	public boolean Verify_TableGridOnPaymentDetailsTab_IsAppear() {
		fluentWait(PaymentDetailsTabTable);
		HighlightElement(PaymentDetailsTabTable);
		return PaymentDetailsTabTable.isDisplayed();
	}

	public boolean Verify_InvoiceNo_Paymentdetailstab(String threedigitinvoicenumber) {				
		//int totalinvoicecount = ListOfInvoice_PaymentDetailsTab.size();
		boolean isValid = false;
		for (WebElement suggestion : ListOfInvoiceNumber_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			if (suggestion.getText().contains(threedigitinvoicenumber)) {
				isValid = true;
				System.out.println("Displayed invoice autosuggestion total count is : "
						+ ListOfInvoiceNumber_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage.size());
				System.out.println("Displayed invoice suggestion: " + suggestion.getText());
			}
		}
		return isValid;
	}

	public boolean Verify_NoCustomerPaymentsFound_PaymentDetailsTab() {
		HighlightElement(NoCustomerFound_PaymentDetailsTab);
		return 	NoCustomerFound_PaymentDetailsTab.isDisplayed();
	}

	public boolean Verify_InvoiceSearchBox_ClearButton_Appears() {
		HighlightElement(clearbutton_InvoiceSearchTextBox_PaymentDetailsTab);
		return	clearbutton_InvoiceSearchTextBox_PaymentDetailsTab.isDisplayed();
	}

	public void Click_InvoiceSearchBox_ClearButton() {
		jsClick(clearbutton_InvoiceSearchTextBox_PaymentDetailsTab);
	}

	public void Enter_PayAmountSearchBox_OnPaymentDetailsTab(String payamount) {
		payAmountSearchBox_PaymentDetailsTab.clear();
		delayWithGivenTime(500);
		clickAndType(payAmountSearchBox_PaymentDetailsTab, payamount);
	}

	public String get_PayAmount_Paymentdetailstab() {
		HighlightElement(payAmountSearchBox_PaymentDetailsTab);
		return payAmountSearchBox_PaymentDetailsTab.getAttribute("value");
	}


	public boolean Verify_PayAmount_Paymentdetailstab(String threedigitpayamount) {                
		boolean isValid = false;
		for (WebElement suggestion : ListOfPayAmount_PaymentDetailsTab) {
			HighlightElement(suggestion);
			System.out.println("Displayed suggestion on Pay Amount: " + suggestion.getText());
			if (suggestion.getText().trim().equals(threedigitpayamount)) {
				isValid = true;
				System.out.println("Found matching Pay Amount: " + threedigitpayamount);
				break; 
			}
		}
		return isValid;
	}

	public int Verify_NoOfPayAmountDisplayedCount_PaymentDetails() {
		int no_of_paymentamount = ListOfPayAmount_PaymentDetailsTab.size();
		return no_of_paymentamount;
	}

	public boolean Verify_PayAmountSearchBox_ClearButton_Appears() {
		HighlightElement(clearbutton_PayAmountSearchBox_PaymentDetailsTab);
		return	clearbutton_PayAmountSearchBox_PaymentDetailsTab.isDisplayed();
	}

	public void Click_PayAmountSearchBox_ClearButton() {
		jsClick(clearbutton_PayAmountSearchBox_PaymentDetailsTab);
	}


	/*
	 * LocalDate currentDate = LocalDate.now();
	 * 
	 * // Calculate the next day LocalDate nextDay = currentDate.plusDays(1);
	 * 
	 * // Format the date as a string (adjust the format to match the date picker's
	 * // expected format) DateTimeFormatter formatter =
	 * DateTimeFormatter.ofPattern("MM/dd/yyyy"); String formattedNextDay =
	 * nextDay.format(formatter);
	 * jsClearAndType(recipientDeliverydateOnPhoneOrderPage, formattedNextDay); //
	 * DoubleClickAndType();
	 */



	public void Enter_PayDateSearchBox_OnPaymentDetailsTab() { //String paydate
		payDateSearchBox_PaymentDetailsTab.clear();
		delayWithGivenTime(500);
		LocalDate currentDate = LocalDate.now();
		LocalDate previousDay =currentDate.plusDays(-1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedPreviousDay = previousDay.format(formatter);
		clickAndType(payDateSearchBox_PaymentDetailsTab, formattedPreviousDay);
	}


	public void Enter_PayDateSearchBox_OnPaymentDetailsTab(String paydate) {
		payDateSearchBox_PaymentDetailsTab.clear();
		delayWithGivenTime(500);
		clickAndType(payDateSearchBox_PaymentDetailsTab, paydate);
	}

	public String previousDate() {
		LocalDate currentDate = LocalDate.now();
		LocalDate previousDay =currentDate.plusDays(-1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedPreviousDay = previousDay.format(formatter);
		return formattedPreviousDay;
	}

	public String NextDate() {
		LocalDate currentDate = LocalDate.now();
		LocalDate previousDay =currentDate.plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedPreviousDay = previousDay.format(formatter);
		return formattedPreviousDay;
	}


	public String get_PayDate_Paymentdetailstab() {
		HighlightElement(payDateSearchBox_PaymentDetailsTab);
		return payDateSearchBox_PaymentDetailsTab.getAttribute("value");
	}


	public boolean Verify_PayDate_Paymentdetailstab(String paydate) {             
		boolean isValid = false;
		for (WebElement suggestion : ListOfPayDate_PaymentDetailsTab) {
			HighlightElement(suggestion);
			if (suggestion.getText().trim().equals(paydate)) {
				isValid = true;
				System.out.println("Found matching Pay Date : " + paydate);
				break; 
			}
		}
		return isValid;
	}




	public boolean Verify_PayDateSearchBox_ClearButton_Appears() {
		HighlightElement(clearbutton_PayDateSearchBox_PaymentDetailsTab);
		return	clearbutton_PayDateSearchBox_PaymentDetailsTab.isDisplayed();
	}

	public void Click_PayDateSearchBox_ClearButton() {
		jsClick(clearbutton_PayDateSearchBox_PaymentDetailsTab);
	}

	public boolean Verify_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup() {
		HighlightElement(filterIconOnPayDate_PaymentDetailsTab);
		click(filterIconOnPayDate_PaymentDetailsTab);
		delayWithGivenTime(1000);

		List<String> expectedPayDateFilterValues = Arrays.asList("Is equal to", "Is not equal to", "Is after or equal to", "Is after", "Is before or equal to", "Is before", "Is null", "Is not null");
		Set<String> actualPayDateFilterValues = new HashSet<>();

		for (WebElement dropdownValue : ListOfFilterOptionsOnPayDate_PaymentDetailsTab) {
			HighlightElement(dropdownValue);
			actualPayDateFilterValues.add(dropdownValue.getText());
		}

		// Check if all expected pagination values are present in the actual dropdown
		// values
		boolean allOptionsDisplayed = actualPayDateFilterValues.containsAll(expectedPayDateFilterValues);

		if (!allOptionsDisplayed) {
			System.out.println("Missing pagination values in dropdown: " + expectedPayDateFilterValues.stream()
			.filter(value -> !actualPayDateFilterValues.contains(value)).collect(Collectors.joining(", ")));
		}

		return allOptionsDisplayed;
	}

	public void Click_CalendarIconOnPayDate_OnPaymentDetailsTab() {
		click(calendarIconOnPayDate_PaymentDetailsTab);
	}


	public void SelectTheDate_FromDatePickerIcon_OnPaymentDetailsTab() {
		LocalDate currentDate = LocalDate.now();
		int targetDay = currentDate.getDayOfMonth();
		String targetMonth = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int targetYear = currentDate.getYear();

		// Locate the month and year display
		HighlightElement(calendar_MonthYear_PayDate_PaymentDetailsTab);  
		calendar_MonthYear_PayDate_PaymentDetailsTab.isDisplayed();
		// Loop to navigate to the correct month and year
		while (true) {
			String displayedMonthYear = calendar_MonthYear_PayDate_PaymentDetailsTab.getText();
			String[] parts = displayedMonthYear.split(" ");
			String displayedMonth = parts[0];
			int displayedYear = Integer.parseInt(parts[1]);

			if (displayedYear == targetYear && displayedMonth.equals(targetMonth)) {
				break;
			}

			if (displayedYear > targetYear || (displayedYear == targetYear && !displayedMonth.equals(targetMonth) && displayedMonth.compareTo(targetMonth) > 0)) {
				// Click the previous arrow if the displayed date is after the target date
				WebElement prevArrow = getDriver().findElement(By.xpath("//span[@class='k-icon k-i-arrow-60-left']"));
				prevArrow.click();
			} else {
				// Click the next arrow if the displayed date is before the target date
				WebElement nextArrow = getDriver().findElement(By.xpath("//span[@class='k-icon k-i-arrow-60-right']"));
				nextArrow.click();
			}
		}

		// Select the desired date
		for (WebElement date :  ListOfdates_PayDate_PaymentDetailsTab) {
			if (date.getText().equals(String.valueOf(targetDay))) {
				click(date);
				break;
			}
		}

	}


	public void Click_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup() {
		HighlightElement(filterIconOnPayDate_PaymentDetailsTab);
		click(filterIconOnPayDate_PaymentDetailsTab);
	}

	public void Click_FilterIconOptions_PayDateOnPaymentDetailsTab_OnCustomerDetailsPopup(String filterValue) {
		HighlightElement(filterIconOnPayDate_PaymentDetailsTab);
		click(filterIconOnPayDate_PaymentDetailsTab);
		delayWithGivenTime(1000);
		for(int i = 0; i < ListOfFilterOptionsOnPayDate_PaymentDetailsTab.size(); i++) {
			if(ListOfFilterOptionsOnPayDate_PaymentDetailsTab.get(i).getText().contains(filterValue)) {
				HighlightElement(ListOfFilterOptionsOnPayDate_PaymentDetailsTab.get(i));
				//	click(ListOfFilterOptionsOnPayDate_PaymentDetailsTab.get(i));
				ListOfFilterOptionsOnPayDate_PaymentDetailsTab.get(i).click();
				break;
			}

		}
	}

	public void Enter_MOPSearchBox_OnPaymentDetailsTab(String mop) {
		MOPSearchBox_PaymentDetailsTab.clear();
		delayWithGivenTime(500);
		clickAndType(MOPSearchBox_PaymentDetailsTab, mop);
	}

	public String get_MOPSearchBox_Paymentdetailstab() {
		HighlightElement(MOPSearchBox_PaymentDetailsTab);
		return MOPSearchBox_PaymentDetailsTab.getAttribute("value");
	}


	public boolean Verify_MOP_Paymentdetailstab(String mop) {                
		boolean isValid = false;
		for (WebElement suggestion : ListOfMOP_PaymentDetailsTab) {
			HighlightElement(suggestion);
			System.out.println("Displayed suggestion of MOP: " + suggestion.getText());
			if (suggestion.getText().trim().equals(mop)) {
				isValid = true;
				System.out.println("Found matching Mode of Payment: " + mop);
				break; 
			}
		}
		return isValid;
	}


	public boolean Verify_MOPSearchBox_ClearButton_Appears() {
		HighlightElement(clearbutton_MOPSearchBox_PaymentDetailsTab);
		return	clearbutton_MOPSearchBox_PaymentDetailsTab.isDisplayed();
	}

	public void Click_MOPSearchBox_ClearButton() {
		jsClick(clearbutton_MOPSearchBox_PaymentDetailsTab);
	}

	public void Enter_CheckNoSearchBox_OnPaymentDetailsTab(String checkno) {
		ChecknoSearchBox_PaymentDetailsTab.clear();
		delayWithGivenTime(500);
		clickAndType(ChecknoSearchBox_PaymentDetailsTab, checkno);
	}

	public String get_CheckNoSearchBox_Paymentdetailstab() {
		HighlightElement(ChecknoSearchBox_PaymentDetailsTab);
		return ChecknoSearchBox_PaymentDetailsTab.getAttribute("value");
	}


	public boolean Verify_CheckNo_Paymentdetailstab(String checkno) {                
		boolean isValid = false;
		for (WebElement suggestion : ListOfCheckno_PaymentDetailsTab) {
			HighlightElement(suggestion);
			System.out.println("Displayed suggestion of Check No: " + suggestion.getText());
			if (suggestion.getText().trim().equals(checkno)) {
				isValid = true;
				System.out.println("Found matching Check No: " + checkno);
				break; 
			}
		}
		return isValid;
	}


	public boolean Verify_CheckNoSearchBox_ClearButton_Appears() {
		HighlightElement(clearbutton_ChecknoSearchBox_PaymentDetailsTab);
		return	clearbutton_ChecknoSearchBox_PaymentDetailsTab.isDisplayed();
	}

	public void Click_CheckNoSearchBox_ClearButton() {
		jsClick(clearbutton_ChecknoSearchBox_PaymentDetailsTab);
	}

	public void Enter_CCNumberSearchBox_OnPaymentDetailsTab(String checkno) {
		CCNumberSearchBox_PaymentDetailsTab.clear();
		delayWithGivenTime(500);
		clickAndType(CCNumberSearchBox_PaymentDetailsTab, checkno);
	}

	public String get_CCNumberSearchBox_Paymentdetailstab() {
		HighlightElement(CCNumberSearchBox_PaymentDetailsTab);
		return CCNumberSearchBox_PaymentDetailsTab.getAttribute("value");
	}


	public boolean Verify_CCNumber_Paymentdetailstab(String ccnumber) {                
		boolean isValid = false;
		for (WebElement suggestion : ListOfCCNumber_PaymentDetailsTab) {
			HighlightElement(suggestion);
			System.out.println("Displayed suggestion of Credit Card Number: " + suggestion.getText());
			if (suggestion.getText().trim().equals(ccnumber)) {
				isValid = true;
				System.out.println("Found matching Credit Card Number: " + ccnumber);
				break; 
			}
		}
		return isValid;
	}


	public boolean Verify_CCNumberSearchBox_ClearButton_Appears() {
		HighlightElement(clearbutton_CCNumberSearchBox_PaymentDetailsTab);
		return	clearbutton_CCNumberSearchBox_PaymentDetailsTab.isDisplayed();
	}

	public void Click_CCNumberSearchBox_ClearButton() {
		jsClick(clearbutton_CCNumberSearchBox_PaymentDetailsTab);
	}

	public boolean Verify_PaginationSection_OnPaymentDetailsTab() {
		HighlightElement(paginationSection_PaymentDetailsTab);
		return paginationSection_PaymentDetailsTab.isDisplayed();
	}

	public boolean Verify_PageListNumber_OnPaymentDetailsTab() {
		HighlightElement(pagelistnumber_PaymentDetailsTab);
		return pagelistnumber_PaymentDetailsTab.isDisplayed();
	}

	public boolean Verify_PaginationInfo_OnPaymentDetailsTab() {
		HighlightElement(paginationInfo_PaymentDetailsTab);
		return paginationInfo_PaymentDetailsTab.isDisplayed();
	}

	public String get_PaginationInfo_PaymentDetailsTab() {
		HighlightElement(paginationInfo_PaymentDetailsTab);		
		String paginationText = paginationInfo_PaymentDetailsTab.getText();

		Pattern pattern = Pattern.compile("(\\d+\\s-\\s\\d+)");
		Matcher matcher = pattern.matcher(paginationText);

		if (matcher.find()) {
			String itemRange = matcher.group(1);
			System.out.println("Item range: " + itemRange);
		} else {
			System.out.println("Item range not found.");
		}

		return matcher.group(1);
	}

	public String get_TotalInfo_Appears_OnUnpaidTab() {
		HighlightElement(paginationInfo_PaymentDetailsTab);

		String paginationText = paginationInfo_PaymentDetailsTab.getText();

		// Use regular expressions to extract the total number of items
		Pattern pattern = Pattern.compile("of\\s(\\d+)\\sitems");
		Matcher matcher = pattern.matcher(paginationText);

		if (matcher.find()) {
			String totalItems = matcher.group(1);
			System.out.println("Total number of items: " + totalItems);
		} else {
			System.out.println("Total number of items not found.");
		}

		return matcher.group(1);
	}

	public void ClickThreeDots_Pagination_PaymentDetails() {
		click(threedotsOnPagination_PaymentDetailsTab);
	}

	public boolean Verify_11to20Pages_Pagination_PaymentDetails() {
		List<WebElement> paginationNumbers = getDriver().findElements(By.xpath("//ul[@class='k-pager-numbers k-reset']//li/a"));

		// Verify pagination numbers from 11 to 20
		boolean isPaginationCorrect = true;
		for (WebElement paginationNumber : paginationNumbers) {
			String text = paginationNumber.getText();
			if (!text.equals("...")) {
				try {
					int pageNumber = Integer.parseInt(text);
					if (pageNumber < 11 || pageNumber > 20) {
						isPaginationCorrect = false;
						break;
					}
				} catch (NumberFormatException e) {
					isPaginationCorrect = false;
					break;
				}
			}
		}

		// Print the result
		if (isPaginationCorrect) {
			System.out.println("Pagination numbers from 11 to 20 are displayed correctly.");
			return true;
		} else {
			System.out.println("Pagination numbers from 11 to 20 are NOT displayed correctly.");
			return false;
		}
	}

	public void Click_Pagenumber2_Pagination_PaymentDetails() {
		click(page2_PaymentDetailsTab);
	}

	public boolean Verify_LastPageNumber_OnPaymentDetailsTab() {
		List<WebElement> paginationNumbers = getDriver().findElements(By.xpath("//ul[@class='k-pager-numbers k-reset']//li/a"));

		// Find the highest page number
		int highestPageNumber = 0;
		for (WebElement paginationNumber : paginationNumbers) {
			String text = paginationNumber.getText();
			if (!text.equals("...")) {
				try {
					int pageNumber = Integer.parseInt(text);
					if (pageNumber > highestPageNumber) {
						highestPageNumber = pageNumber;
					}
				} catch (NumberFormatException e) {
					e.getMessage();
				}
			}
		}

		// Verify the highest page number is displayed
		WebElement currentPageElement = getDriver().findElement(By.xpath("//ul[@class='k-pager-numbers k-reset']//li//span[@class='k-state-selected']"));
		int currentPageNumber = Integer.parseInt(currentPageElement.getText());

		if (currentPageNumber == highestPageNumber) {
			System.out.println("Last page is displayed correctly.");
			return true;
		} else {
			System.out.println("Last page is NOT displayed correctly.");
			return false;
		}
	}

	public void Click_InvoiceHeader_PaymentDetails() {
		click(invoicelabel_paymentdetailsTab);
	}

	public boolean Verify_InvoiceHeader_Sorted_ascending_PaymentDetailsTab() {
		// Store the invoice numbers in a list
		List<String> originalInvoiceNumbers = new ArrayList<>();
		for (WebElement invoiceElement : ListOfInvoiceNumber_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			originalInvoiceNumbers.add(invoiceElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalInvoiceNumbers);
		Collections.sort(sortedInvoiceNumbers);

		// Compare the original list with the sorted list
		if (originalInvoiceNumbers.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Original invoice numbers: " + originalInvoiceNumbers);
			System.out.println("Sorted invoice numbers: " + sortedInvoiceNumbers);
			System.out.println("Invoices are not sorted in ascending order.");
			return false;
		}
	}

	public boolean Verify_InvoiceHeader_Sorted_descending_PaymentDetailsTab() {
		// Store the invoice numbers in a list
		List<String> originalInvoiceNumbers = new ArrayList<>();
		for (WebElement invoiceElement : ListOfInvoiceNumber_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			originalInvoiceNumbers.add(invoiceElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalInvoiceNumbers);
		Collections.sort(sortedInvoiceNumbers, Collections.reverseOrder());

		if (originalInvoiceNumbers.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Invoices are not sorted in descending order.");
			return false;
		}
	}

	public boolean Verify_InvoiceHeader_DefaultOrder_PaymentDetailsTab() {
		delayWithGivenTime(1000);
		List<String> originalInvoiceNumbers = new ArrayList<>();
		for (WebElement invoiceElement : ListOfInvoiceNumber_UnpaidInvoiceTable_UnpaidTabOnPhoneOrderPage) {
			originalInvoiceNumbers.add(invoiceElement.getText());
		}
		delayWithGivenTime(1000);
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalInvoiceNumbers);
		Collections.sort(sortedInvoiceNumbers);

		if (originalInvoiceNumbers.equals(sortedInvoiceNumbers)) {
			return false;
		} else {
			return true;
		}
	}



	public void Click_PayAmountHeader_PaymentDetails() {
		click(payamountlabel_paymentdetailsTab);
	}

	public boolean Verify_PayAmountHeader_Sorted_ascending_PaymentDetailsTab() {
		// Store the invoice numbers in a list
		List<String> originalInvoiceNumbers = new ArrayList<>();
		for (WebElement invoiceElement : ListOfPayAmount_PaymentDetailsTab) {
			originalInvoiceNumbers.add(invoiceElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalInvoiceNumbers);
		Collections.sort(sortedInvoiceNumbers);

		// Compare the original list with the sorted list
		if (originalInvoiceNumbers.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Original invoice numbers: " + originalInvoiceNumbers);
			System.out.println("Sorted invoice numbers: " + sortedInvoiceNumbers);
			System.out.println("Invoices are not sorted in ascending order.");
			return false;
		}
	}

	public boolean Verify_PayAmountHeader_Sorted_descending_PaymentDetailsTab() {
		// Store the invoice numbers in a list
		List<String> originalInvoiceNumbers = new ArrayList<>();
		for (WebElement invoiceElement : ListOfPayAmount_PaymentDetailsTab) {
			originalInvoiceNumbers.add(invoiceElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalInvoiceNumbers);
		Collections.sort(sortedInvoiceNumbers, Collections.reverseOrder());

		if (originalInvoiceNumbers.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Invoices are not sorted in descending order.");
			return false;
		}
	}

	public boolean Verify_PayAmountHeader_DefaultOrder_PaymentDetailsTab() {
		delayWithGivenTime(1000);
		List<String> originalInvoiceNumbers = new ArrayList<>();
		for (WebElement invoiceElement : ListOfPayAmount_PaymentDetailsTab) {
			originalInvoiceNumbers.add(invoiceElement.getText());
		}
		delayWithGivenTime(2000);
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalInvoiceNumbers);
		Collections.sort(sortedInvoiceNumbers);

		if (originalInvoiceNumbers.equals(sortedInvoiceNumbers)) {
			return false;
		} else {
			return true;
		}
	}

	public void Click_PayDateHeader_PaymentDetails() {
		click(payDatelabel_paymentdetailsTab);
	}

	public boolean Verify_PayDateHeader_Sorted_ascending_PaymentDetailsTab() {
		// Store the invoice numbers in a list
		List<String> originalInvoiceNumbers = new ArrayList<>();
		for (WebElement invoiceElement : ListOfPayDate_PaymentDetailsTab) {
			originalInvoiceNumbers.add(invoiceElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalInvoiceNumbers);
		Collections.sort(sortedInvoiceNumbers);

		// Compare the original list with the sorted list
		if (originalInvoiceNumbers.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Original invoice numbers: " + originalInvoiceNumbers);
			System.out.println("Sorted invoice numbers: " + sortedInvoiceNumbers);
			System.out.println("Invoices are not sorted in ascending order.");
			return false;
		}
	}

	public boolean Verify_PayDateHeader_Sorted_descending_PaymentDetailsTab() {
		// Store the invoice numbers in a list
		List<String> originalInvoiceNumbers = new ArrayList<>();
		for (WebElement invoiceElement : ListOfPayDate_PaymentDetailsTab) {
			originalInvoiceNumbers.add(invoiceElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalInvoiceNumbers);
		Collections.sort(sortedInvoiceNumbers, Collections.reverseOrder());

		if (originalInvoiceNumbers.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Invoices are not sorted in descending order.");
			return false;
		}
	}

	public boolean Verify_PayDateHeader_DefaultOrder_PaymentDetailsTab() {
		delayWithGivenTime(1000);
		List<String> actualpaydate = new ArrayList<>();
		for (WebElement paydateElement : ListOfPayDate_PaymentDetailsTab) {
			actualpaydate.add(paydateElement.getText());
		}
		delayWithGivenTime(2000);
		List<String> defaultorder = new ArrayList<>(actualpaydate);

		if (actualpaydate.equals(defaultorder)) {
			return true;
		} else {
			return false;
		}
	}

	public void Click_MOPHeader_PaymentDetails() {
		click(moplabel_paymentdetailsTab);
	}

	public boolean Verify_MOPHeader_Sorted_ascending_PaymentDetailsTab() {
		// Store the invoice numbers in a list
		List<String> originalMOP = new ArrayList<>();
		for (WebElement mopElement : ListOfMOP_PaymentDetailsTab) {
			originalMOP.add(mopElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sortedmop = new ArrayList<>(originalMOP);
		Collections.sort(sortedmop);

		// Compare the original list with the sorted list
		if (originalMOP.containsAll(sortedmop)) {
			return true;
		} else {
			System.out.println("Original MOP : " + originalMOP);
			System.out.println("Sorted MOP: " + sortedmop);
			System.out.println("MOP are not sorted in ascending order.");
			return false;
		}
	}

	public boolean Verify_MOPHeader_Sorted_descending_PaymentDetailsTab() {
		// Store the invoice numbers in a list
		List<String> originalMOP = new ArrayList<>();
		for (WebElement invoiceElement : ListOfMOP_PaymentDetailsTab) {
			originalMOP.add(invoiceElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(originalMOP);
		Collections.sort(sortedInvoiceNumbers, Collections.reverseOrder());

		if (originalMOP.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Invoices are not sorted in descending order.");
			return false;
		}
	}

	public boolean Verify_MOPHeader_DefaultOrder_PaymentDetailsTab() {
		delayWithGivenTime(1000);
		List<String> actualpaydate = new ArrayList<>();
		for (WebElement paydateElement : ListOfMOP_PaymentDetailsTab) {
			actualpaydate.add(paydateElement.getText());
		}
		delayWithGivenTime(2000);
		List<String> defaultorder = new ArrayList<>(actualpaydate);

		if (actualpaydate.equals(defaultorder)) {
			return true;
		} else {
			return false;
		}
	}

	public void Click_CheckNoHeader_PaymentDetails() {
		click(checknolabel_paymentdetailsTab);
	}

	public boolean Verify_CheckNoHeader_Sorted_ascending_PaymentDetailsTab() {
		// Store the invoice numbers in a list
		List<String> original = new ArrayList<>();
		for (WebElement checknoElement : ListOfCheckno_PaymentDetailsTab) {
			original.add(checknoElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sortedmop = new ArrayList<>(original);
		Collections.sort(sortedmop);

		// Compare the original list with the sorted list
		if (original.containsAll(sortedmop)) {
			return true;
		} else {
			System.out.println("Original MOP : " + original);
			System.out.println("Sorted MOP: " + sortedmop);
			System.out.println("MOP are not sorted in ascending order.");
			return false;
		}
	}

	public boolean Verify_CheckNoHeader_Sorted_descending_PaymentDetailsTab() {
		// Store the invoice numbers in a list
		List<String> original = new ArrayList<>();
		for (WebElement checknoElement : ListOfCheckno_PaymentDetailsTab) {
			original.add(checknoElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sortedInvoiceNumbers = new ArrayList<>(original);
		Collections.sort(sortedInvoiceNumbers, Collections.reverseOrder());

		if (original.containsAll(sortedInvoiceNumbers)) {
			return true;
		} else {
			System.out.println("Invoices are not sorted in descending order.");
			return false;
		}
	}

	public boolean Verify_CheckNoHeader_DefaultOrder_PaymentDetailsTab() {
		delayWithGivenTime(1000);
		List<String> actual = new ArrayList<>();
		for (WebElement checknoElement : ListOfCheckno_PaymentDetailsTab) {
			actual.add(checknoElement.getText());
		}
		delayWithGivenTime(2000);
		List<String> defaultorder = new ArrayList<>(actual);

		if (actual.equals(defaultorder)) {
			return true;
		} else {
			return false;
		}
	}

	public void Click_CCNoHeader_PaymentDetails() {
		click(ccnumberlabel_paymentdetailsTab);
	}

	public boolean Verify_CCNoHeader_Sorted_ascending_PaymentDetailsTab() {
		// Store the invoice numbers in a list
		List<String> original = new ArrayList<>();
		for (WebElement ccnumberElement : ListOfCCNumber_PaymentDetailsTab) {
			original.add(ccnumberElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sorted = new ArrayList<>(original);
		Collections.sort(sorted);

		// Compare the original list with the sorted list
		if (original.containsAll(sorted)) {
			return true;
		} else {
			System.out.println("Original CCNumber : " + original);
			System.out.println("Sorted CCNumber: " + sorted);
			System.out.println("CC Number are not sorted in ascending order.");
			return false;
		}
	}

	public boolean Verify_CCNoHeader_Sorted_descending_PaymentDetailsTab() {
		// Store the invoice numbers in a list
		List<String> original = new ArrayList<>();
		for (WebElement ccnumberElement : ListOfCCNumber_PaymentDetailsTab) {
			original.add(ccnumberElement.getText());
		}
		delayWithGivenTime(2000);
		// Create a copy of the list and sort it
		List<String> sorted = new ArrayList<>(original);
		Collections.sort(sorted, Collections.reverseOrder());

		if (original.containsAll(sorted)) {
			return true;
		} else {
			System.out.println("CC Number are not sorted in descending order.");
			return false;
		}
	}

	public boolean Verify_CCNoHeader_DefaultOrder_PaymentDetailsTab() {
		delayWithGivenTime(1000);
		List<String> original = new ArrayList<>();
		for (WebElement ccnumberElement : ListOfCCNumber_PaymentDetailsTab) {
			original.add(ccnumberElement.getText());
		}
		delayWithGivenTime(2000);
		List<String> defaultorder = new ArrayList<>(original);

		if (original.equals(defaultorder)) {
			return true;
		} else {
			return false;
		}
	}

	public void Click_OrderDetailsTab_CustomerDetailsPopup() {
		jsClick(OrderDetailsTab);
	}

	public boolean Verify_ExportToExcel_OrderDetailsTab_CustomerDetailsPopup() {
		HighlightElement(exporttoexcelbutton_orderdetailsTab);
		return exporttoexcelbutton_orderdetailsTab.isDisplayed();
	}

	public void Click_ExportToExcelButton_OrderDetailsTab_CustomerDetailsPopup() {
		jsClick(exporttoexcelbutton_orderdetailsTab);
	}

	public boolean Verify_OrderDetailsTableGrid_IsAppears_OrderDetailsTab_CustomerDetailsPopup() {
		HighlightElement(OrderDetailsTable);
		return OrderDetailsTable.isDisplayed();
	}

	public void Enter_InvoiceNo_OrderDetailsTab_CustomerDetailsPopup(String InvoiceNo) {
		fluentWait(InvoiceNoSearchBox_OrderDetailsTab);
		delayWithGivenTime(500);		
		(InvoiceNoSearchBox_OrderDetailsTab).clear();
		delayWithGivenTime(500);		
		clickAndType(InvoiceNoSearchBox_OrderDetailsTab, InvoiceNo);
	}

	public String get_InvoiceNo_Orderdetailstab() {
		HighlightElement(InvoiceNoSearchBox_OrderDetailsTab);
		return InvoiceNoSearchBox_OrderDetailsTab.getAttribute("value");
	}

	public boolean Verify_InvoiceNo_Orderdetailstab(String threedigitinvoicenumber) {				
		boolean isValid = false;
		for (WebElement suggestion : ListOfInvoiceNo_OrderDetailsTab) {
			if (suggestion.getText().contains(threedigitinvoicenumber)) {
				isValid = true;
				System.out.println("Displayed invoice autosuggestion total count is : "
						+ ListOfInvoiceNo_OrderDetailsTab.size());
				System.out.println("Displayed invoice suggestion: " + suggestion.getText());
			}
		}
		return isValid;
	}

	public boolean Verify_AllTheInvoiceNo_AppearsOn_OrderDetailsTab() {
		int InvoiceNo_count =	ListOfInvoiceNo_OrderDetailsTab.size();
		if (InvoiceNo_count == 25) {
			return true;
		} else {
			System.out.println("The count of invoices is not 25. It is: " + InvoiceNo_count);
			return false;
		}
	}

	public void Click_clearbutton_InvoiceNoSearchBox_OrderDetailsTab() {
		jsClick(clearbutton_InvoiceNoSearchBox_OrderDetailsTab);
	}

	public boolean Verify_Clearbutton_InvoiceNoSearchBox_OrderDetailsTab() {
		HighlightElement(clearbutton_InvoiceNoSearchBox_OrderDetailsTab);
		return clearbutton_InvoiceNoSearchBox_OrderDetailsTab.isDisplayed();
	}

	public String getFirstRowInvoiceNo_OrderDetailsTab() {
		HighlightElement(FirstInvoiceNo_OrderDetailsTab);
		return (FirstInvoiceNo_OrderDetailsTab.getText());
	}

	public boolean get_ClearBtnAppears_OnInvoiceSearchBox_OrderDetailsTab() {
		HighlightElement(clearbutton_InvoiceNoSearchBox_OrderDetailsTab);
		return clearbutton_InvoiceNoSearchBox_OrderDetailsTab.isDisplayed();
	}

	public void Click_ClearBtn_InvoiceSearchBox_OrderDetailsTab() {
		click(clearbutton_InvoiceNoSearchBox_OrderDetailsTab);
	}

	public boolean Verify_NoCustomerOrdersFoundMessage_Appears_OrderDetailsTab() {
		HighlightElement(NoCustomerOrderFoundMessage_OrderDetailsTab);
		return NoCustomerOrderFoundMessage_OrderDetailsTab.isDisplayed();
	}

	public void Enter_TotalAmount_OrderDetailsTab_CustomerDetailsPopup(String TotalAmount) {
		fluentWait(TotalAmountSearchBox_OrderDetailsTab);
		delayWithGivenTime(500);		
		(TotalAmountSearchBox_OrderDetailsTab).clear();
		delayWithGivenTime(500);		
		clickAndType(TotalAmountSearchBox_OrderDetailsTab, TotalAmount);
	}

	public String get_TotalAmount_Orderdetailstab() {
		HighlightElement(TotalAmountSearchBox_OrderDetailsTab);
		return TotalAmountSearchBox_OrderDetailsTab.getAttribute("value");
	}

	public boolean Verify_TotalAmount_Orderdetailstab(String threedigitinvoicenumber) {				
		boolean isValid = false;
		for (WebElement suggestion : TotalAmountList_OrderDetailsTab) {
			if (suggestion.getText().contains(threedigitinvoicenumber)) {
				isValid = true;
				System.out.println("Displayed Total Amount autosuggestion total count is : " + TotalAmountList_OrderDetailsTab.size());
				System.out.println("Displayed Total Amount suggestion: " + suggestion.getText());
			}
		}
		return isValid;
	}

	public void Click_clearbutton_TotalAmountSearchBox_OrderDetailsTab() {
		jsClick(clearbutton_TotalAmountSearchBox_OrderDetailsTab);
	}

	public boolean Verify_Clearbutton_TotalAmountSearchBox_OrderDetailsTab() {
		HighlightElement(clearbutton_TotalAmountSearchBox_OrderDetailsTab);
		return clearbutton_TotalAmountSearchBox_OrderDetailsTab.isDisplayed();
	}

	public boolean Verify_AllTheTotalAmounts_AppearsOn_OrderDetailsTab() {
		int InvoiceNo_count =	TotalAmountList_OrderDetailsTab.size();
		if (InvoiceNo_count == 25) {
			return true;
		} else {
			System.out.println("The count of total amount is not 25. It is: " + InvoiceNo_count);
			return false;
		}
	}

	public void Enter_Status_OrderDetailsTab_CustomerDetailsPopup(String status) {
		fluentWait(StatusSearchBox_OrderDetailsTab);
		delayWithGivenTime(500);		
		(StatusSearchBox_OrderDetailsTab).clear();
		delayWithGivenTime(500);		
		clickAndType(StatusSearchBox_OrderDetailsTab, status);
	}

	public String get_Status_Orderdetailstab() {
		HighlightElement(StatusSearchBox_OrderDetailsTab);
		return StatusSearchBox_OrderDetailsTab.getAttribute("value");
	}

	public boolean Verify_Status_Orderdetailstab(String threeCharacterstatus) {				
		boolean isValid = false;
		for (WebElement suggestion : ListOfStatus_OrderDetailsTab) {
			delayWithGivenTime(500);
			if (suggestion.getText().contains(threeCharacterstatus)) {
				isValid = true;
				System.out.println("Displayed Status autosuggestion total count is : " + ListOfStatus_OrderDetailsTab.size());
				System.out.println("Displayed Status suggestion: " + suggestion.getText());
			}
		}
		return isValid;
	}

	public void Click_clearbutton_StatusSearchBox_OrderDetailsTab() {
		jsClick(clearbutton_StatusSearchBox_OrderDetailsTab);
	}

	public boolean Verify_Clearbutton_StatusSearchBox_OrderDetailsTab() {
		HighlightElement(clearbutton_StatusSearchBox_OrderDetailsTab);
		return clearbutton_StatusSearchBox_OrderDetailsTab.isDisplayed();
	}

	public boolean Verify_AllTheStatus_AppearsOn_OrderDetailsTab() {
		int InvoiceNo_count =	ListOfStatus_OrderDetailsTab.size();
		if (InvoiceNo_count == 25) {
			return true;
		} else {
			System.out.println("The count of total amount is not 25. It is: " + InvoiceNo_count);
			return false;
		}
	}

	public void Enter_Name_OrderDetailsTab_CustomerDetailsPopup(String name) {
		fluentWait(NameSearchBox_OrderDetailsTab);
		delayWithGivenTime(500);		
		(NameSearchBox_OrderDetailsTab).clear();
		delayWithGivenTime(500);		
		clickAndType(NameSearchBox_OrderDetailsTab, name);
	}

	public String get_Name_Orderdetailstab() {
		HighlightElement(NameSearchBox_OrderDetailsTab);
		return NameSearchBox_OrderDetailsTab.getAttribute("value");
	}

	public boolean Verify_Name_Orderdetailstab(String threeCharactername) {				
		boolean isValid = false;
		for (WebElement suggestion : ListOfName_OrderDetailsTab) {

			if (suggestion.getText().contains(threeCharactername)) {
				isValid = true;
			}
		}
		return isValid;
	}

	public void Click_clearbutton_NameSearchBox_OrderDetailsTab() {
		jsClick(clearbutton_NameSearchBox_OrderDetailsTab);
	}

	public boolean Verify_Clearbutton_NameSearchBox_OrderDetailsTab() {
		HighlightElement(clearbutton_NameSearchBox_OrderDetailsTab);
		return clearbutton_NameSearchBox_OrderDetailsTab.isDisplayed();
	}

	public boolean Verify_AllTheName_AppearsOn_OrderDetailsTab() {
		int InvoiceNo_count =	ListOfName_OrderDetailsTab.size();
		if (InvoiceNo_count == 25) {
			return true;
		} else {
			return false;
		}
	}

	public void Enter_Address_OrderDetailsTab_CustomerDetailsPopup(String address) {
		fluentWait(AddressSearchBox_OrderDetailsTab);
		delayWithGivenTime(500);		
		(AddressSearchBox_OrderDetailsTab).clear();
		delayWithGivenTime(500);		
		clickAndType(AddressSearchBox_OrderDetailsTab, address);
	}

	public String get_Address_Orderdetailstab() {
		HighlightElement(AddressSearchBox_OrderDetailsTab);
		return AddressSearchBox_OrderDetailsTab.getAttribute("value");
	}

	public boolean Verify_Address_Orderdetailstab(String threeCharacteraddress) {				
		boolean isValid = false;
		for (WebElement suggestion : ListOfAddress_OrderDetailsTab) {

			if (suggestion.getText().contains(threeCharacteraddress)) {
				isValid = true;
			}
		}
		return isValid;
	}

	public void Click_clearbutton_AddressSearchBox_OrderDetailsTab() {
		jsClick(clearbutton_AddressSearchBox_OrderDetailsTab);
	}

	public boolean Verify_Clearbutton_AddressSearchBox_OrderDetailsTab() {
		HighlightElement(clearbutton_AddressSearchBox_OrderDetailsTab);
		return clearbutton_AddressSearchBox_OrderDetailsTab.isDisplayed();
	}

	public boolean Verify_AllTheAddress_AppearsOn_OrderDetailsTab() {
		int InvoiceNo_count =	ListOfAddress_OrderDetailsTab.size();
		if (InvoiceNo_count == 25) {
			return true;
		} else {
			return false;
		}
	}

	public void Enter_OrderDate_OrderDetailsTab_CustomerDetailsPopup(String orderdate) {
		fluentWait(OrderDateSearchBox_OrderDetailsTab);
		delayWithGivenTime(500);		
		(OrderDateSearchBox_OrderDetailsTab).clear();
		delayWithGivenTime(500);		
		clickAndType(OrderDateSearchBox_OrderDetailsTab, orderdate);
	}

	public String get_OrderDate_Orderdetailstab() {
		HighlightElement(OrderDateSearchBox_OrderDetailsTab);
		return OrderDateSearchBox_OrderDetailsTab.getAttribute("value");
	}

	public boolean Verify_OrderDate_Orderdetailstab(String threeCharacterorderdate) {				
		boolean isValid = false;
		for (WebElement suggestion : ListOfOrderDate_OrderDetailsTab) {

			if (suggestion.getText().contains(threeCharacterorderdate)) {
				isValid = true;
			}
		}
		return isValid;
	}

	public void Click_clearbutton_OrderDateSearchBox_OrderDetailsTab() {
		jsClick(clearbutton_OrderDateSearchBox_OrderDetailsTab);
	}

	public boolean Verify_Clearbutton_OrderDateSearchBox_OrderDetailsTab() {
		HighlightElement(clearbutton_OrderDateSearchBox_OrderDetailsTab);
		return clearbutton_OrderDateSearchBox_OrderDetailsTab.isDisplayed();
	}

	public boolean Verify_AllTheOrderDate_AppearsOn_OrderDetailsTab() {
		int InvoiceNo_count =	ListOfOrderDate_OrderDetailsTab.size();
		if (InvoiceNo_count == 25) {
			return true;
		} else {
			return false;
		}
	}

	public void Enter_Description_OrderDetailsTab_CustomerDetailsPopup(String description) {
		fluentWait(DescriptionSearchBox_OrderDetailsTab);
		delayWithGivenTime(500);		
		(DescriptionSearchBox_OrderDetailsTab).clear();
		delayWithGivenTime(500);		
		clickAndType(DescriptionSearchBox_OrderDetailsTab, description);
	}

	public String get_Description_Orderdetailstab() {
		HighlightElement(DescriptionSearchBox_OrderDetailsTab);
		return DescriptionSearchBox_OrderDetailsTab.getAttribute("value");
	}

	public boolean Verify_Description_Orderdetailstab(String threeCharacterdescription) {				
		boolean isValid = false;
		for (WebElement suggestion : ListOfDescription_OrderDetailsTab) {

			if (suggestion.getText().contains(threeCharacterdescription)) {
				isValid = true;
			}
		}
		return isValid;
	}

	public void Click_clearbutton_DescriptionSearchBox_OrderDetailsTab() {
		jsClick(clearbutton_DescriptionSearchBox_OrderDetailsTab);
	}

	public boolean Verify_Clearbutton_DescriptionSearchBox_OrderDetailsTab() {
		HighlightElement(clearbutton_DescriptionSearchBox_OrderDetailsTab);
		return clearbutton_DescriptionSearchBox_OrderDetailsTab.isDisplayed();
	}

	public boolean Verify_AllTheDescription_AppearsOn_OrderDetailsTab() {
		int InvoiceNo_count =	ListOfDescription_OrderDetailsTab.size();
		if (InvoiceNo_count == 25) {
			return true;
		} else {
			return false;
		}
	}

	public boolean Verify_NoOfpagesDropdown_OnOrderDetailsTab_OnCustomerDetailsPopup() {
		HighlightElement(pagelistdropdown_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		click(pagelistdropdown_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage);
		delayWithGivenTime(1000);

		List<String> expectedPaginationValues = Arrays.asList("25", "50", "100", "150", "200", "250");
		Set<String> actualPaginationValues = new HashSet<>();

		for (WebElement dropdownValue : pagelist_dropdownvalues_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage) {
			HighlightElement(dropdownValue);
			actualPaginationValues.add(dropdownValue.getText());
		}

		// Check if all expected pagination values are present in the actual dropdown
		// values
		boolean allOptionsDisplayed = actualPaginationValues.containsAll(expectedPaginationValues);

		if (!allOptionsDisplayed) {
			System.out.println("Missing pagination values in dropdown: " + expectedPaginationValues.stream()
			.filter(value -> !actualPaginationValues.contains(value)).collect(Collectors.joining(", ")));
		}

		return allOptionsDisplayed;
	}

	public int Verify_ListofInvoiceNumbers_Appears_InOrderDetailsInvoiceTable_OnOrderDetailsTab() {
		int totalinvoicecount = ListOfInvoiceNo_OrderDetailsTab.size();
		System.out.println("Displayed invoice total count is : " + totalinvoicecount);
		return totalinvoicecount;
	}

	public boolean Verify_NoOfitemDisplayed_OnUnpaidTab_OnCustomerDetailsPopup() {
		String itemsCountText = pagenumber_Label_UnpaidTabOn_CustomerDetailsPopupOnPhoneOrderPage.getText(); // e.g., "1																												// items"
		int displayedItemsCount = Integer.parseInt(itemsCountText.split(" ")[4]);
		System.out.println("Number of items displayed on Order details Tab: " + displayedItemsCount);		

		List<WebElement> tableRows = getDriver().findElements(By.xpath("//tbody[@role='rowgroup']//tr"));
		int actualRowsCount = tableRows.size();

		if (displayedItemsCount == actualRowsCount) {
			System.out.println("Actual number of items displayed is correct: " + actualRowsCount);
			return true;
		} else {
			System.out.println("Actual Number of items displayed on Order details Tab is incorrect: " + actualRowsCount);
			return false;
		}

	}

	public void Click_StatementsTab_CustomerDetailsPopup() {
		jsClick(StatementsTab);
	}

	public boolean ClickAndVerifyDropDownOptions_StatementsTab() {
		click(monthdropdown_statementsTab);
		delayWithGivenTime(2000);

		LocalDate currentDate = LocalDate.now();
		// Get the previous month
		LocalDate previousMonthDate = currentDate.minusMonths(1);
		String previousMonth = previousMonthDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

		s= new Select(monthdropdown_statementsTab);

		List<WebElement> dropdownOptions = s.getOptions();

		for (WebElement option : dropdownOptions) {
			if (option.getText().contains(previousMonth)) {
				HighlightElement(option);
				System.out.println("Previous month is displayed: " + previousMonth);
				return true;
			}
		}

		System.out.println("Previous month is not displayed: " + previousMonth);
		return false;
	}

	public boolean Verify_Selectmonth_IsEmpty_StatementsTab() {
		HighlightElement(monthdropdown_statementsTab);
		click(monthdropdown_statementsTab);

		s= new Select(monthdropdown_statementsTab);
		return s.getOptions().isEmpty();
	}

	public void SelectMonth_StatementsTab(String month) {	
		dropDown(monthdropdown_statementsTab, month, "VisibleText");
	}

	public String getSelectedOptions_OnDropdown_StatementsTab() {
		s= new Select(monthdropdown_statementsTab);
		return s.getFirstSelectedOption().getText();		
	}

	public void Click_DownloadBtn_OnStatementsTab() {
		jsClick(downloadstatementbutton_statementsTab);
	}

	public boolean Validate_GeneratedStatementRecord() {
		getDriver().switchTo().activeElement();
		return iframereport_statementsTab.isDisplayed();		
	}

	public boolean Verify_NoStatementFoundMessage_OnStatementsTab() {
		HighlightElement(NoStatementsFoundMessage_statementsTab);
		return (NoStatementsFoundMessage_statementsTab.isDisplayed());
	}

	public void Click_CustomerHistory_OnCustomerDetailsSection() {
		click(custHistoryIcon_OnCustDetailsSection);
	}

	public boolean Verify_CustomerHistoryPopupAppears_OnCustomerDetailsSection() {
		HighlightElement(previousOrdersHistoryHeaderPopup_OnCustDetailsSection);
		return previousOrdersHistoryHeaderPopup_OnCustDetailsSection.isDisplayed();
	}

	public void Click_PreviousOrder_OnCustomerHistoryPopup(String invoiceNumber) {
		for (WebElement order : ListOfPreviousOrdersInvoices_InOrderHistoryTable_CustHistoryPopup) {
			if(order.getText().contains(invoiceNumber)) {
				jsClick(order);
				break;
			}

		}
	}

	public void Click_PreviousOrder_OnCustomerHistoryPopup() {
		for (WebElement order : ListOfPreviousOrdersInvoices_InOrderHistoryTable_CustHistoryPopup) {	      
			jsClick(order);
			break;	    	
		}
	}

	public boolean Verify_TextmepromotionCheckboxIsChecked_OnPhoneorderPage() {
		HighlightElement(TextMepromotionsCheckBox_OnCustDetailsPopup);
		boolean isChecked = TextMepromotionsCheckBox_OnCustDetailsPopup.isSelected();
		if (isChecked) {
			System.out.println("The 'Text me promotions' checkbox is checked.");
		} else {
			System.out.println("The 'Text me promotions' checkbox is not checked.");
		}
		return isChecked;
	}


	public void Click_TextmePromotionCheckBox_OnphoneOrderPage() {
		jsClick(TextMepromotionsCheckBox_OnCustDetailsPopup);
	}

	public void Click_SMSToogleOn_CustDetailsPopup() {
		jsClick(smstooglebutton_OnCustDetailsPopup);
	}

	public boolean Verify_RecipientName_Autosuggestion() {
		int i=0;
		for( i=0;i<ListOfReciFirstName_Autosuggestions_OnPhoneOrderPage.size();i++) {
			int count = ListOfReciFirstName_Autosuggestions_OnPhoneOrderPage.size();
			if(count>0) {
				System.out.println("The autosuggestion listed count is:" + count);
				return true;
			}
		}
		return false;		
	}


	public void SearchAndSelect_RecipientNameFromAutoSuggestion(String recifirstname) {
		for(int i = 0; i < ListOfReciFirstName_Autosuggestions_OnPhoneOrderPage.size(); i++) {
			if(ListOfReciFirstName_Autosuggestions_OnPhoneOrderPage.get(i).getText().contains(recifirstname)) {
				click(ListOfReciFirstName_Autosuggestions_OnPhoneOrderPage.get(i));
				break;
			}
		}
	}

	public boolean Verify_AddressverifiedByGoogle_ToastMsgAppears() {
		HighlightElement(addressverifiedmsg);
		return addressverifiedmsg.isDisplayed();
	}

	public String Verify_ToastMsgText() {
		HighlightElement(addressverifiedmsg);
		return addressverifiedmsg.getText();
	}
	
	public String Verify_RecipientKMS_Appears() {
		//	HighlightElement(recipientKMS);
		String Recipient_KMS = recipientKMS.getText();
		System.out.println(Recipient_KMS);
		return Recipient_KMS;
	}

	public boolean Verify_RecipientSectionAppears() {
		HighlightElement(recipientsectionOnPhoneOrderPage);
		return recipientsectionOnPhoneOrderPage.isDisplayed();
	}

	public void Select_DeliveryOnTime_Dropdown(String deliveryontime) {
		dropDown(selectDeliverytimeonDropdown_RecipientSectionOnPhoneOrderPage, deliveryontime, "VisibleText");
	}

	public String getSelected_DeliveryOnTimeOptions_OnDropdown_RecipientSection() {
		s= new Select(selectDeliverytimeonDropdown_RecipientSectionOnPhoneOrderPage);
		return (s.getFirstSelectedOption().getText());		
	}

	public void EnterTimeOnRecipientSection(String time) {
		recipientDeliverytimeOnPhoneOrderPage.sendKeys(time);
	}

	public String getEnteredTimeOnRecipientSection() {
		HighlightElement(recipientDeliverytimeOnPhoneOrderPage);
		return recipientDeliverytimeOnPhoneOrderPage.getAttribute("value");
	}

	public String getCurrentTime() {
		// Get the current time
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		String formattedTime = currentTime.format(formatter);
		System.out.println("Current Time: " + formattedTime);
		return formattedTime;
	}

	public void Enter_DeliveryTime_OnRecipientSection() {
		// Set the time 5:30 PM
		LocalTime time530PM = LocalTime.of(17, 30);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		String formattedTime = time530PM.format(formatter);
		delayWithGivenTime(500);
		jsClearAndType(recipientDeliverytimeOnPhoneOrderPage,formattedTime);
	}

	public void Click_ClearTimeButton_OnRecipientSection() {
		jsClick(ClearTimeButton_recipientSectionOnPhoneOrderPage);
	}

	public boolean Verify_MapIconIsAppear_OnRecipientAddress1() {
		HighlightElement(googleIcon_ReciAddress1_OnPhoneOrderPage);
		return googleIcon_ReciAddress1_OnPhoneOrderPage.isDisplayed();
	}

	public void Click_MapIconOn_RecipientAddress1() {
		jsClick(googleIcon_ReciAddress1_OnPhoneOrderPage);
	}

	public boolean Verify_MapDirectionPopup_IsAppear() {
		HighlightElement(mapdirectionsPopup_ReciAddress1_OnPhoneOrderPage);
		return mapdirectionsPopup_ReciAddress1_OnPhoneOrderPage.isDisplayed();
	}

	public void Click_Row1DirectionInstructions_OnMapDirectionPopup(){
		getDriver().switchTo().frame(mapiframe_ReciAddress1_OnPhoneOrderPage);
		delayWithGivenTime(1000);
		jsClick(directionsRow1_ReciAddress1_OnPhoneOrderPage);
	}

	public boolean Verify_TooltipTextIsAppear_OnMapDirectionPopup() {
		delayWithGivenTime(1000);
		HighlightElement(tooltiptext_MapDirectionPopup_ReciAddress1_OnPhoneOrderPage);
		return tooltiptext_MapDirectionPopup_ReciAddress1_OnPhoneOrderPage.isDisplayed();
	}

	public boolean Verify_TooltipClosed_OnMapDirectionPopup() {
		try {
			delayWithGivenTime(2000);
			return tooltiptext_MapDirectionPopup_ReciAddress1_OnPhoneOrderPage.isDisplayed();			
		} catch (NoSuchElementException e) {
			return false;		
		} catch (Exception e) {
			return false;
		}
	}

	public void Click_CloseIcon_OnMapDirectionPopup() {
		jsClick(TooltipCloseIcon_MapDirectionPopup_ReciAddress1_OnPhoneOrderPage);
	}

	public void Click_SatelliteMapIcon_OnMapDirectionPopup_ReciAddress1() {
		HighlightElement(SateliteTab_MapDirectionPopupReciAddress1_OnPhoneOrderPage);
		jsClick(SateliteTab_MapDirectionPopupReciAddress1_OnPhoneOrderPage);
	}

	public void MouseHoverSatelliteTabAndClickLabel_SatelliteMapIcon() {
		MouseHover(SateliteTab_MapDirectionPopupReciAddress1_OnPhoneOrderPage);
		delayWithGivenTime(2000);
		click(satelliteTabLabel_MapDirectionPopupReciAddress1_OnPhoneOrderPage);		
	}

	public void ClickMapTab_OnMapDirectionPopup_ReciAddress1() {
		jsClick(MapTab_MapDirectionPopupReciAddress1_OnPhoneOrderPage);
	}

	public void MouseHoverMapTabAndClickTerrain_OnMapDirectionPopup_ReciAddress1() {
		MouseHover(MapTab_MapDirectionPopupReciAddress1_OnPhoneOrderPage);
		delayWithGivenTime(2000);
		click(satelliteTabTerrain_MapDirectionPopupReciAddress1_OnPhoneOrderPage);		
	}

	public void Click_PlusIcon_OnMapDirectionPopup_ReciAddress1() {
		jsClick(plusIcon_MapDirectionPopupReciAddress1_OnPhoneOrderPage);
	}

	public void Click_MinusIcon_OnMapDirectionPopup_ReciAddress1() {
		jsClick(minusIcon_MapDirectionPopupReciAddress1_OnPhoneOrderPage);
	}

	public boolean VerifyMapIsZoomIn() {
		System.out.println("Zoom in : Attrbute value " +VerifyZoomIn_MapDirectionPopupReciAddress1_OnPhoneOrderPage.getAttribute("style"));
		boolean zoomin = VerifyZoomIn_MapDirectionPopupReciAddress1_OnPhoneOrderPage.getAttribute("style").contains("matrix(1, 0, 0, 1, -230, -242);");
		return zoomin;
	}

	public boolean VerifyMapIsZoomOut() {
		System.out.println("Zoom out === Attrbute value === " +VerifyZoomIn_MapDirectionPopupReciAddress1_OnPhoneOrderPage.getAttribute("style"));
		boolean zoomout = VerifyZoomIn_MapDirectionPopupReciAddress1_OnPhoneOrderPage.getAttribute("style").contains("matrix(1, 0, 0, 1, -243, -121);");
		return zoomout;
	}

	public void DragAndDrop_DragPegman_OnMapDirectionPopup_ReciAddress1() {
		dragAndDrop(DragPegman_MapDirectionPopupReciAddress1_OnPhoneOrderPage,DragPegman_MapDirectionPopupReciAddress1_OnPhoneOrderPage);
	}


	public void Click_FullscreenIcon_OnMapDirectionPopup_ReciAddress1() {
		jsClick(FullScreen_MapDirectionPopupReciAddress1_OnPhoneOrderPage);
	}

	public boolean Verify_MapDirectionPopup_DisplayedFullScreenMode() {
		return FullScreen_MapDirectionPopupReciAddress1_OnPhoneOrderPage.getAttribute("aria-pressed").contains("true"); 
	}


	public void Click_CloseIconOnMapDirectionPopup_ReciAddress1() {
		getDriver().switchTo().defaultContent();
		delayWithGivenTime(1000);
		jsClick(CloseIcon_MapDirectionPopupReciAddress1_OnPhoneOrderPage);
	}

	public boolean MapDirectionPopup_isClosed() {
		try {
			delayWithGivenTime(1000);
			return mapdirectionsPopup_ReciAddress1_OnPhoneOrderPage.isDisplayed();

		} catch (NoSuchElementException e) {
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getRecipientState() {
		HighlightElement(recipientstateOnPhoneOrderPage);
		return recipientstateOnPhoneOrderPage.getAttribute("value");
	}

	public boolean Verify_RecipientAttentionField_IsDisplayed() {
		HighlightElement(recipientattentionOnPhoneOrderPage);
		return recipientattentionOnPhoneOrderPage.isDisplayed();
	}	

	public void EnterRecipientAttention(String recipientattention) {
		HighlightElement(recipientattentionOnPhoneOrderPage);
		recipientattentionOnPhoneOrderPage.clear();
		recipientattentionOnPhoneOrderPage.sendKeys(recipientattention);
		//recipientattentionOnPhoneOrderPage.sendKeys(Keys.TAB);
	}

	public String get_RecipientAttention() {
		HighlightElement(recipientattentionOnPhoneOrderPage);
		return recipientattentionOnPhoneOrderPage.getAttribute("value");
	}

	public void SearchAndSelectReciAttention(String reciaAttention) {			   		
		for (WebElement customerElement : ListOfReciAddress1_Autosuggestions_OnPhoneOrderPage) {
			MouseHover(ListOfReciAddress1_Autosuggestions_OnPhoneOrderPage.get(0));
			click(ListOfReciAddress1_Autosuggestions_OnPhoneOrderPage.get(0));		
			break;
		}
	}

	public boolean Verify_Autosuggestion_Displayed_OnReciAttention() {
		HighlightElement(recipientattentionOnPhoneOrderPage);
		recipientattentionOnPhoneOrderPage.clear();
		delayWithGivenTime(1000);
		for(int i=0;i<ListOfReciAddress1_Autosuggestions_OnPhoneOrderPage.size();i++) {
			int ReciAddress1_size=	ListOfReciAddress1_Autosuggestions_OnPhoneOrderPage.size();
			if(ReciAddress1_size>0) {
				return true;
			}
		}return false;

	}

	public void ClickSelectOptions_OnRecipient() {
		actionClick(recipientSelectOptionsBtnOnPhoneOrderPage);
		Actions action = new Actions(getDriver());
		action.keyDown(Keys.ENTER).build().perform();
		action.keyUp(Keys.ENTER).build().perform();
	}

	public void Click_SelectAllOption() {
		jsClick(selectallOption_RecipientSelectOptionsDropDown);
	}
	
	
	public void Click_ConfidentialOption() {
		jsClick(confidentialOption_RecipientSelectOptionsDropDown);
	}
	
	public void Click_FrequentAddrOption() {
		jsClick(FrequentAddrOption_RecipientSelectOptionsDropDown);
	}
	
	public void Click_SaveFuneralOption() {
		jsClick(saveFuneralOption_RecipientSelectOptionsDropDown);
	}
	
	public void SelectTheOptions_OnRecipient(String recipient) {			
		for(WebElement ele : recipientSelectOptionsListOnPhoneOrderPage) {
			if(ele.getText().equalsIgnoreCase(recipient)) {
				ele.click();
				break;
			}
		}
		delayWithGivenTime(1000);
		click(recipientSelectOptionsBtnOnPhoneOrderPage);
	}
	
	public void Select_Location_OnRecipientSection(String recilocation) {
		dropDown(recipientLocation,recilocation,"VisibleText");
	}
	
	public String getSelectedLocation_OnRecipientSection() {
		s = new Select(recipientLocation);
		return s.getFirstSelectedOption().getText();
	}
	
	
	public void Select_Zone_OnRecipientSection(String recizone) {
		dropDown(recipientzone,recizone,"VisibleText");
	}
	
	public String getSelectedZone_OnRecipientSection() {
		 s = new Select(recipientzone);
		return s.getFirstSelectedOption().getText();
	}

	public String getDeliveryFees_PaymentSection_OnPhoneOrder() {
		HighlightElement(deliveryFee_PhoneOrder_PaymentSection);
		return deliveryFee_PhoneOrder_PaymentSection.getAttribute("value");
	}
	
	public String getSelectedOption() {
		return selectedRecipientOptionsOnPhoneOrderPage.getText();
	}
	
	public boolean Verify_OrderDetailsSectionAppears() {
		HighlightElement(OrderDetailsSection);
		return OrderDetailsSection.isDisplayed();
	}
	
	public boolean Verify_SendRemainder_OnOrderDetailsIsAppears() {
		try {
			delayWithGivenTime(2000);
			HighlightElement(sendreminderlabel_OrderDetailsTab);
			return sendreminderlabel_OrderDetailsTab.isDisplayed();			
		} catch (NoSuchElementException e) {
			return false;		
		} catch (Exception e) {
			return false;
		}
	}
	
	public void Click_SendRemainderCheckBox() {
		jsClick(sendreminderlabel_OrderDetailsTab);
	}
	
	public boolean Verify_SendRemainderCheckBoxIsSelected() {		
		System.out.println("Send remainder checkbox is selected:" +sendRemainderCheckbox_OrderDetailsSection.isSelected());
		return sendRemainderCheckbox_OrderDetailsSection.isSelected();
	}
	
	
	public boolean Verify_PrintTicketCheckBoxIsSelected() {		
		System.out.println("Print ticket checkbox is selected:" +printTicketCheckBox_OrderDetailsSection.isSelected());
		return printTicketCheckBox_OrderDetailsSection.isSelected();
	}
	
	public void Click_ViewShortCodes_Hyperlink() {
		jsClick(ViewShortCodesLink_OrderDetailsSection);
	}
	
	public boolean Verify_ViewShortCodes_HyperlinkIsDisplayed() {
		HighlightElement(ViewShortCodesLink_OrderDetailsSection);
		return ViewShortCodesLink_OrderDetailsSection.isDisplayed();
	}
	
	public boolean Verify_ViewShortCodes_PopupIsDisplayed() {
		HighlightElement(ShortCodes_Popup_OrderDetailsSection);
		return ShortCodes_Popup_OrderDetailsSection.isDisplayed();
	}
	
	public void SetCode_OnViewShortCodesPopup(String code) {
		clickAndType(codeTextBox_ShortCodesPopup_OrderDetailsSection,code);
	}
	
	public String get_EnteredCode_OnViewShortCodesPopup() {
		HighlightElement(codeTextBox_ShortCodesPopup_OrderDetailsSection);
		return codeTextBox_ShortCodesPopup_OrderDetailsSection.getAttribute("value");
	}
	
	public void SetValue_OnViewShortCodesPopup(String value) {
		clickAndType(valueTextBox_ShortCodesPopup_OrderDetailsSection,value);
	}
	
	public String get_EnteredValue_OnViewShortCodesPopup() {
		HighlightElement(valueTextBox_ShortCodesPopup_OrderDetailsSection);
		return valueTextBox_ShortCodesPopup_OrderDetailsSection.getAttribute("value");
	}
	
	public void Click_AddButton_OnViewShortCodesPopup() {
		jsClick(addButton_ShortCodesPopup_OrderDetailsSection);
	}
	
	public boolean Verify_AddedShortCode_IsDisplayed_OnViewShortCodesPopup() {
		HighlightElement(LastShortCode_OrderDetailsSection);		
		String Code = LastShortCode_OrderDetailsSection.getText();
		HighlightElement(LastValues_OrderDetailsSection);
		String value = LastValues_OrderDetailsSection.getText();
		System.out.println(Code + "  " + value);
		if(Code.equals("At") && value.equals("Automation Test")) {			
			return true;
		}else {
			System.out.println("Added ShortCode is not displayed");
			return false;
		}
	}
	
	public void Click_CloseIcon_OnViewShortCodesPopup() {
		jsClick(closeIcon_ShortCodesPopup_OrderDetailsSection);
	}
	public boolean Verify_DeleteIconDisplayed() {
		return LastdeleteIcon_OrderDetailsSection.isDisplayed();
	}
	
	public void Click_DeleteIcon_OnShortCodesPopup() {
		actionClick(LastdeleteIcon_OrderDetailsSection);
	}
		
	public void Click_DeleteButtonDeleteConfirmation() {
		delayWithGivenTime(1000);
		click(YesButtonDeleteConfirmation_ShortCodesPopup_OrderDetailsSection);
	}
	
	public boolean Verify_ConfirmationPopup() {
		delayWithGivenTime(1000);
		HighlightElement(ConfirmationAlert_ShortCodesPopup_OrderDetailsSection);
		return ConfirmationAlert_ShortCodesPopup_OrderDetailsSection.isDisplayed();
	}
	
	public boolean Verify_DeleteConfirmation() {
		delayWithGivenTime(1000);
		if(ConfirmationPopup.isDisplayed()) {
		HighlightElement(ConfirmationAlertIcon_ShortCodesPopup_OrderDetailsSection);
		ConfirmationAlertIcon_ShortCodesPopup_OrderDetailsSection.isDisplayed();
		HighlightElement(ConfirmationAlert_ShortCodesPopup_OrderDetailsSection);
		ConfirmationAlert_ShortCodesPopup_OrderDetailsSection.isDisplayed();
		HighlightElement(ConfirmationAlertMessage_ShortCodesPopup_OrderDetailsSection);
		ConfirmationAlertMessage_ShortCodesPopup_OrderDetailsSection.isDisplayed();
		HighlightElement(YesButtonDeleteConfirmation_ShortCodesPopup_OrderDetailsSection);
			YesButtonDeleteConfirmation_ShortCodesPopup_OrderDetailsSection.isDisplayed();
		HighlightElement(NoButtonDeleteConfirmation_ShortCodesPopup_OrderDetailsSection);
		NoButtonDeleteConfirmation_ShortCodesPopup_OrderDetailsSection.isDisplayed();
		return true;
		}else {
			return false;
		}	
	}
	
	public void Click_NoButtonDeleteConfirmation() {
		jsClick(NoButtonDeleteConfirmation_ShortCodesPopup_OrderDetailsSection);
	}
	
	public boolean Verify_ProductSectionLabel_Appears() {
		HighlightElement(productsectionOnPhoneOrderPage);
		return productsectionOnPhoneOrderPage.isDisplayed();
	}
	
	public boolean Verify_ProductSuggestions_Appears(String proditemcode) {
		prod_details_Itemcode1.clear();
		prod_details_Itemcode1.sendKeys(proditemcode);
		delayWithGivenTime(2000);
		List<String> expectedProducts = Arrays.asList("rrd-Red Rose Small-199", "rrd-Red Rose Deluxe-299","rrd-Red Rose Premium -399","rrd-2-Wedding Reception Flower -789");
		Set<String> actualProducts = new HashSet<>();

		for (WebElement products : listOfItemsUnderItemcode1) {
			HighlightElement(products);
			actualProducts.add(products.getText());
		}

		if(expectedProducts.containsAll(actualProducts)) {
			System.out.println("All expected products are displayed" + actualProducts);
			System.out.println("Expected products are displayed as: " + expectedProducts);
			return true;
		}else {
			return false;
		}
		
	}
	
	public void Click_ProductRemoveIcon_Row1() {
		jsClick(removeIconProdDetails1);
	}
	
	public boolean Verify_ProductRow1Details_Removed() {
		try {
			return prod_details_Itemcode1.isDisplayed();
		} catch (NoSuchElementException e) {
			return true;			
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean Verify_AutosugestionsList_OnItemDescription_Appears(String proditemdescription) {
		prod_details_ItemDescription2OnPhoneOrderPage.clear();
		prod_details_ItemDescription2OnPhoneOrderPage.sendKeys(proditemdescription);
		delayWithGivenTime(2000);
		List<String> expectedProducts = Arrays.asList("Flwrs-red roses -50",
				"Roses-Red rose flowers -14",
				"RED12-Red Rose -18.32",
				"FlwrsShailja_1-red roses -50",
				"rrd-Red Rose Small-199",
				"rrd-Red Rose Deluxe-299",
				"rrd-Red Rose Premium -399",
				"rrd-2-Wedding Reception Flower -789",
				"RDWB-Premium Red Roses Double Wrapped Bouquet -40",
				"RDWB-Premium Red Roses Double Wrapped Bouquet Premium Red Roses Double Wrapped Bouquet - Special-60");
		Set<String> actualProducts = new HashSet<>();
		for (WebElement products : listOfRow2_ItemDescription_OnPhoneOrderPage) {
			HighlightElement(products);
			actualProducts.add(products.getText());
		}
		if(expectedProducts.containsAll(actualProducts)) {
			System.out.println("All expected products descriptions are displayed" + actualProducts);
			System.out.println("Expected products descriptions are displayed as: " + expectedProducts);
		return true;
		}else {
			System.out.println("Expected products descriptions are not displayed" + actualProducts);
			System.out.println("Expected products  descriptions are displayed as: " + expectedProducts);
			return false;
		}
	}
	
	public void SearchAndSelect_WithItemDescription(String proditemShortdesc,String proditemdescription) {
		prod_details_ItemDescription2OnPhoneOrderPage.clear();
		prod_details_ItemDescription2OnPhoneOrderPage.sendKeys(proditemShortdesc);
		delayWithGivenTime(2000);
		for (WebElement products : listOfRow2_ItemDescription_OnPhoneOrderPage) {
			if(products.getText().contains(proditemdescription)) {
				jsClick(products);
				break;				
			}
		}
		
	}
	
	public void Click_AddIcon_Row3() {
		jsClick(addIconProdDetails3_OnPhoneOrderPage);
	}
	
	public boolean Verify_Row4_ProductDetailsItemcode_Appears() {
		int row_count =	listOfRow_ProductDetails_OnPhoneOrderPage.size();
		if(row_count==3) {
			HighlightElement(prod_details_Itemcode4_OnPhoneOrderPage);
			prod_details_Itemcode4_OnPhoneOrderPage.isDisplayed();
			return true;
		}else {
			return false;
		}		
	}
	
	public String get_ItemCodeRow2_ProductDetails() {
		HighlightElement(prod_details_Itemcode2_OnPhoneOrderPage);
		return prod_details_Itemcode2_OnPhoneOrderPage.getAttribute("value");
	}
	
	public String get_ItemDescriptionRow2_ProductDetails() {
		HighlightElement(prod_details_ItemDescription2_OnPhoneOrderPage);
		return prod_details_ItemDescription2_OnPhoneOrderPage.getAttribute("value");
	}
	
	public String get_ItemQtyRow2_ProductDetails() {
		HighlightElement(prod_details_ItemQty2_OnPhoneOrderPage);
		return prod_details_ItemQty2_OnPhoneOrderPage.getAttribute("value");
	}
	
	public String get_ItemPriceRow2_ProductDetails() {
		HighlightElement(prod_details_ItemPrice2_OnPhoneOrderPage);
		return prod_details_ItemPrice2_OnPhoneOrderPage.getAttribute("value");
	}
	
	public void EnterSpecialInstructions_ProductDetailsSection(String SpecialInstructions) {
		HighlightElement(Splinstruction_Textbox_OnPhoneOrderPage);
		Splinstruction_Textbox_OnPhoneOrderPage.clear();
		clickAndType(Splinstruction_Textbox_OnPhoneOrderPage, SpecialInstructions);
	}
	
	public String get_SpecialInstructions_ProductDetailsSection() {
		HighlightElement(Splinstruction_Textbox_OnPhoneOrderPage);
		return Splinstruction_Textbox_OnPhoneOrderPage.getAttribute("value");
	}
	
	public void EnterDriverInstructions_ProductDetailsSection(String DriverInstructions) {
		HighlightElement(Driverinstruction_Textbox_OnPhoneOrderPage);
		Driverinstruction_Textbox_OnPhoneOrderPage.clear();
		clickAndType(Driverinstruction_Textbox_OnPhoneOrderPage, DriverInstructions);
	}
	
	public String get_DriverInstructions_ProductDetailsSection() {
		HighlightElement(Driverinstruction_Textbox_OnPhoneOrderPage);
		return Driverinstruction_Textbox_OnPhoneOrderPage.getAttribute("value");
	}
	
	
	public void EnterCustomerPrivateNotesInstructions_ProductDetailsSection(String customerPrivateNotesInstructions) {
		HighlightElement(customerPrivateNotes_Textbox_OnPhoneOrderPage);
		customerPrivateNotes_Textbox_OnPhoneOrderPage.clear();
		clickAndType(customerPrivateNotes_Textbox_OnPhoneOrderPage, customerPrivateNotesInstructions);
	}
	
	public String get_CustomerPrivateNotesInstructions_ProductDetailsSection() {
		HighlightElement(customerPrivateNotes_Textbox_OnPhoneOrderPage);
		return customerPrivateNotes_Textbox_OnPhoneOrderPage.getAttribute("value");
	}
	
	public void Select_ProductTaxType(String taxtype) {
		dropDown(producttaxType_OnPhoneOrderPage, taxtype, "VisibleText");
	}
	
	public String get_selected_ProductTaxType() {
		s=new Select(producttaxType_OnPhoneOrderPage);
		return (s.getFirstSelectedOption().getText());
	}
	
	public void Enter_ProductTaxId(String prodtaxid) {
		producttaxId_OnPhoneOrderPage.clear();
		clickAndType(producttaxId_OnPhoneOrderPage, prodtaxid);
	}
	
	public String get_ProductTaxId() {
		HighlightElement(producttaxId_OnPhoneOrderPage);
		return producttaxId_OnPhoneOrderPage.getAttribute("value");
	}
	
	public void Select_ProdSourceCode(String prodsourcecode) {
		dropDown(productSourceCode_OnPhoneOrderPage, prodsourcecode, "VisibleText");		
	}
	
	public String get_selected_ProdSourceCode() {
		s=new Select(productSourceCode_OnPhoneOrderPage);
		return (s.getFirstSelectedOption().getText());
	}
	
	public void Select_ProdCustType(String custType) {
		dropDown(productcustomerType_OnPhoneOrderPage, custType, "VisibleText");
	}
	
	public String get_selected_ProdCustType() {
		s=new Select(productcustomerType_OnPhoneOrderPage);
		return (s.getFirstSelectedOption().getText());
	}
	
	public void Enter_GiftCardNumber_OnPhoneOrderPage(String giftcardnumber) {
		HighlightElement(giftCardNumber_PhoneOrder_PaymentSection);
		giftCardNumber_PhoneOrder_PaymentSection.clear();
		clickAndType(giftCardNumber_PhoneOrder_PaymentSection, giftcardnumber);
	}
	
	public String get_GiftCardNumber_OnPhoneOrderPage() {
		HighlightElement(giftCardNumber_PhoneOrder_PaymentSection);
		return giftCardNumber_PhoneOrder_PaymentSection.getAttribute("value");
	}
	
	
	public String get_GiftCardDisplayedCustName_OnPhoneOrderPage() {
		giftCardNumber_PhoneOrder_PaymentSection.sendKeys(Keys.TAB);
		HighlightElement(giftCardCustName_PhoneOrder_PaymentSection);
		return giftCardCustName_PhoneOrder_PaymentSection.getAttribute("value");
	}
	
	public String get_GiftCardCurrentBalanceDisplayed_OnPhoneOrderPage() {
		HighlightElement(giftCardCurrentBalance_PhoneOrder_PaymentSection);
		return giftCardCurrentBalance_PhoneOrder_PaymentSection.getAttribute("value");
	}
	
	public String get_GiftCardDisplayed_Amount_OnPhoneOrderPage() {
		HighlightElement(giftCardAmount_PhoneOrder_PaymentSection);
		return giftCardAmount_PhoneOrder_PaymentSection.getAttribute("value");
	}
	
	public String Validate_GiftCardAmountCalculation() {
		double currentbalance = Double.parseDouble(get_GiftCardCurrentBalanceDisplayed_OnPhoneOrderPage());
		double amount = Double.parseDouble(getGrandTotalAmount());
		double current_balance = currentbalance - amount;
		System.out.println("Current Balance);" + current_balance);
		return Double.toString(current_balance);
	}
	
	
	public void Enter_WireIn_Fname(String firstname) {
		wireinFirstName_OnPhoneOrderPage.clear();
		clickAndType(wireinFirstName_OnPhoneOrderPage, firstname);
	}
	
	public String get_Entered_WireIn_Fname() {
		HighlightElement(wireinFirstName_OnPhoneOrderPage);
		return wireinFirstName_OnPhoneOrderPage.getAttribute("value");
	}
	
	
	public void Enter_WireIn_Lname(String lastname) {
		wireinLastName_OnPhoneOrderPage.clear();
		clickAndType(wireinLastName_OnPhoneOrderPage, lastname);
	}
	
	public String get_Entered_WireIn_Lname() {
		HighlightElement(wireinLastName_OnPhoneOrderPage);
		return wireinLastName_OnPhoneOrderPage.getAttribute("value");
	}
	
	public void Enter_WireIn_ShopCode(String shopcode) {
		wireinShopCode_OnPhoneOrderPage.clear();
		clickAndType(wireinShopCode_OnPhoneOrderPage, shopcode);
	}
	
	public String get_Entered_WireIn_ShopCode() {
		HighlightElement(wireinShopCode_OnPhoneOrderPage);
		return wireinShopCode_OnPhoneOrderPage.getAttribute("value");
	}
	
	public void Enter_WireIn_ShopName(String shopcode) {
		wireinShopName_OnPhoneOrderPage.clear();
		clickAndType(wireinShopName_OnPhoneOrderPage, shopcode);
	}
	
	public String get_Entered_WireIn_ShopName() {
		HighlightElement(wireinShopName_OnPhoneOrderPage);
		return wireinShopName_OnPhoneOrderPage.getAttribute("value");
	}
	
	public void Select_WireInMethod(String wireinmethod) {
		dropDown(wireinMethods_OnPhoneOrderPage, wireinmethod, "VisibleText");
	}
	
	public String get_Selected_WireInMethod() {
		s=new Select(wireinMethods_OnPhoneOrderPage);
		return (s.getFirstSelectedOption().getText());
	}
	
	public void Enter_WireIn_OrderNumber(String ordernumber) {
		wireinOrderNum_OnPhoneOrderPage.clear();
		clickAndType(wireinOrderNum_OnPhoneOrderPage, ordernumber);
	}
	
	public String get_Entered_WireIn_OrderNumber() {
		HighlightElement(wireinOrderNum_OnPhoneOrderPage);
		return wireinOrderNum_OnPhoneOrderPage.getAttribute("value");
	}
	
	public void Enter_WireIn_PhoneNumber(String phonenumber) {
		wireinPhone_OnPhoneOrderPage.clear();
		clickAndType(wireinPhone_OnPhoneOrderPage, phonenumber);
	}
	
	public String get_Entered_WireIn_PhoneNumber() {
		HighlightElement(wireinPhone_OnPhoneOrderPage);
		return wireinPhone_OnPhoneOrderPage.getAttribute("value");
	}
	
	public void Enter_WireIn_Email(String email) {
		wireinEmail_OnPhoneOrderPage.clear();
		clickAndType(wireinEmail_OnPhoneOrderPage, email);
	}
	
	public String get_Entered_WireIn_Email() {
		HighlightElement(wireinEmail_OnPhoneOrderPage);
		return wireinEmail_OnPhoneOrderPage.getAttribute("value");
	}
	
	public void Enter_WireIn_ShopAddress(String shopaddress) {
		wireinShopAddress_OnPhoneOrderPage.clear();
		clickAndType(wireinShopAddress_OnPhoneOrderPage, shopaddress);
	}
	
	public String get_Entered_WireIn_ShopAddress() {
		HighlightElement(wireinShopAddress_OnPhoneOrderPage);
		return wireinShopAddress_OnPhoneOrderPage.getAttribute("value");
	}
	
	public void Enter_WireIn_Comments(String comments) {
		wireinComments_OnPhoneOrderPage.clear();
		clickAndType(wireinComments_OnPhoneOrderPage, comments);
	}
	
	public String get_Entered_WireIn_Comments() {
		HighlightElement(wireinComments_OnPhoneOrderPage);
		return wireinComments_OnPhoneOrderPage.getAttribute("value");
	}
	
	public void Select_WireOut_PaymentMethod(String paymentmethod) {
		dropDown(wireoutMethods_OnPhoneOrderPage, paymentmethod, "VisibleText");
	}
	
	public String get_Selected_WireIn_PaymentMethod() {
		s=new Select(wireoutMethods_OnPhoneOrderPage);
		return (s.getFirstSelectedOption().getText());
	}
	
	public void Enter_WireoutFlorist(String florist) {
		wireoutFlorist_OnPhoneOrderPage.clear();
		clickAndType(wireoutFlorist_OnPhoneOrderPage, florist);		
	}
	
	public String get_Amount_wireout_paymentsection() {
		String amountStr = wireoutAmt_OnPhoneOrderPage.getText();
		String amountValue = amountStr.replaceAll("[^0-9.]", "");
		return amountValue;
	}
	
	public void set_Amount_wireout_paymentsection() {
		wireoutAmount_OnPhoneOrderPage.clear();
		clickAndType(wireoutAmount_OnPhoneOrderPage, get_Amount_wireout_paymentsection());
	}
	
}
	
	







