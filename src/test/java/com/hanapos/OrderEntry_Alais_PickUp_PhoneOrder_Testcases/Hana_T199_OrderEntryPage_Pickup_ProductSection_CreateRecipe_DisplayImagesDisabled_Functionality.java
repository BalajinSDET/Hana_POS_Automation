package com.hanapos.OrderEntry_Alais_PickUp_PhoneOrder_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hanapos.pageObjects.Configuration_SettingsPage;
import com.hanapos.pageObjects.DashboardOrderPage;
import com.hanapos.pageObjects.HanaDashBoardPage;
import com.hanapos.pageObjects.LoginPage;
import com.hanapos.pageObjects.ManageProposalPage;
import com.hanapos.pageObjects.Marketing_RemaindersPage;
import com.hanapos.pageObjects.OrderEntry_Alais_PhoneOrderPage;
import com.hanapos.pageObjects.Order_Confirmation_Page;
import com.hanapos.pageObjects.ProposalsPage;
import com.hanapos.seleniumProjectBase.TestBaseClass;
import com.hanapos.utilities.CustomSoftAssert;

public class Hana_T199_OrderEntryPage_Pickup_ProductSection_CreateRecipe_DisplayImagesDisabled_Functionality extends TestBaseClass {
	private LoginPage lp;
	private HanaDashBoardPage dashboard;
	private OrderEntry_Alais_PhoneOrderPage phoneorder;
	private ProposalsPage proposal;
	private ManageProposalPage manageproposal;
	
	//,dataProvider="fetch_Excel_Data"
	@Test(enabled=true,groups= {"Regression"}) 
	public void Validate_Hana_T199_OrderEntryPage_Pickup_ProductSection_CreateRecipe_DisplayImagesDisabled_Functionality_Test() {
		// SoftAssert softassert = new SoftAssert(); - I have modified this to use CustomSoftAssert
		CustomSoftAssert softassert = new CustomSoftAssert();
		
		logger.info("**** Starting  Validate_Hana_T199_OrderEntryPage_Pickup_ProductSection_CreateRecipe_DisplayImagesDisabled_Functionality_Test ****");
		logger.debug("capturing application debug logs....");
		try {
			
			// Test Step - 1
			lp = new LoginPage();
			softassert.assertTrue(lp.LoginPageIsDisplayed(),"Login page is not displayed");
			logger.info("User on the hana pos login page");
			
			// Test Step - 2
			lp.EnterUserName(prop.getProperty("username"));
			logger.info("User entered the username as "+prop.getProperty("username"));
			lp.EnterPassword(prop.getProperty("password"));
			logger.info("User entered the password as "+prop.getProperty("password"));
			lp.ClickLoginButton();
			logger.info("User clicked on Login button");

			dashboard = new HanaDashBoardPage();
			softassert.assertTrue(dashboard.VerifyHanaDashBoardPage(),"Page does not navigated to hana dashboard page");
			logger.info("User navigated to hana dashboard page");
			dashboard.SelectShopNameDropDown(prop.getProperty("shopname"));
			logger.info("User select the shopname on dashbaord page as "+prop.getProperty("shopname"));
			
			// Test Step - 3
			delayWithGivenTime(2000);
			softassert.assertTrue(dashboard.VerifyOrderEntryOptionIsDisplayed(),"Order entry option is not displayed");
			softassert.assertTrue(dashboard.Verify_Cashandcarry_OptionIsDisplayed(),"Cash and carry option is not displayed");
				
			// Test Step - 4
			dashboard.ClickOrderEntry();
			logger.info("User hover the mouse on New order and clicked on order entry");
		
			// Test Step - 5
			phoneorder = new OrderEntry_Alais_PhoneOrderPage();
			softassert.assertTrue(phoneorder.Verify_ProductSection_Appears_OnPhoneorder(),"Test Step - 5 - Product section is not displayed on phoneorder page");
		
			// Test Step - 6
			phoneorder.ClickPickupTypeOnPhoneOrderPage();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getHighlightedColorOnPickupTypeOnPhoneOrderPage(),"#2f9bc8", "Test Step - 6 - Pickup type is not highlighted in blue color");		
		
			// Test Step - 7
			phoneorder.Select_SalesPersonOn_PhoneOrderEntryPage("Stuart Markwood");
			softassert.assertTrue(phoneorder.VerifyCustSectionAppears(), "Test Step - 7 - Customer section is not displayed on phone order page");
			phoneorder.SearchAndSelectCustomerOnCust_Section("Abish");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getFirstnameOnPhoneOrderPage(),"Abish", "Test Step - 7 - First name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getLastnameOnPhoneOrderPage(),"David", "Test Step - 7 - Last name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCompanyNameOnPhoneOrderPage(),"Hana_Sisterchicks", "Test Step - 7 - Company name is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getEmailIdOnPhoneOrderPage(),"hanaposqateam@gmail.com", "Test Step - 7 - email id is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress1OnPhoneOrderPage(),"3402 Park Blvd", "Test Step - 7 - address 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAddress2OnPhoneOrderPage(),"", "Test Step - 7 - Address 2 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getZipCodeOnPhoneOrderPage(),"92103", "Test Step - 7 - Zipcode is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getCityOnPhoneOrderPage(),"San Diego", "Test Step - 7 - city is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 7 - phone number 1 is not displayed on phone order page");
			softassert.assertEquals(phoneorder.getAltPhoneNumberOnPhoneOrderPage(),"956-655-0756", "Test Step - 7 - Alt phone number is not displayed on phone order page");
			delayWithGivenTime(2000);
			
			// Test Step - 8
			phoneorder.EnterReciFirstName("Abi");
			phoneorder.SearchAndSelect_RecipientNameFromAutoSuggestion("Abish David 114 N CHURCH ST PICK UP (9566550756,9566550756)");
			delayWithGivenTime(2000);
			phoneorder.SelectReciCountry("United States");
			phoneorder.EnterReciPhone("956-655-0756");
			delayWithGivenTime(1000);
			phoneorder.SelectReciLocation("Church");
			delayWithGivenTime(1000);
			phoneorder.EnterDeliveryDateOnReciSection();
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getReciFirstName(),"Abish","Test Step - 8 - Entered first name is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciLastName(),"David","Test Step - 8 - Entered last name is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress1(),"114 N CHURCH ST","Test Step - 8 - Entered address 1 is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciAddress2(),"PICK UP","Test Step - 8 - Entered address 2 is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciZipcode(),"63084","Test Step - 8 - Entered zipcode is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciCity(),"UNION","Test Step - 8 - Entered city is not displayed on phone order page recipient section");
			softassert.assertEquals(phoneorder.getReciPhone(),"956-655-0756","Test Step - 8 - Recipient phone number is not displayed on phone order page recipient section");

			// Test Step - 9
			phoneorder.SelectOccasion_On_OrderDetails_In_PhoneOrderPage("Birthday");
			phoneorder.EnterViewShortCode();			
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getSelectedOccasionOnPhoneOrderPage(),"Birthday","Test Step - 9 - Selected Occasion is not displayed on phone order page order details section");
			softassert.assertTrue(phoneorder.getEnteredViewShortCode().equalsIgnoreCase("Happy Birthday! Hope You Have An Amazing Day!"),"Test Step - 9 -Entered Short code is not displayed on phone order page order details section");
			delayWithGivenTime(2000);	
			
			// Test Step - 10			
			softassert.assertTrue(phoneorder.Verify_ProductSuggestions_Appears("rrd"),"Test Step - 10 - In Item code row 1 on product section autosuggestions are not displayed");
			
			// Test Step - 11
			phoneorder.SearchandSelectItemcodeOnPhoneOrderPage("rrd","rrd-Red Rose Small");
			delayWithGivenTime(2000);
			softassert.assertEquals(phoneorder.getProdDetailsItemcode1OnPhoneOrderPage(),"rrd","Test Step - 11 - Item code is not displayed on phone order page product details section");
			softassert.assertEquals(phoneorder.getProdDetailsItemDescription1OnPhoneOrderPage(),"Red Rose Small","Test Step - 11 - Item description is not displayed on phone order page product details section"); 
			softassert.assertEquals(phoneorder.getProdItemQty1OnPhoneOrderPage(),"1","Test Step - 11 - Item quantity is not displayed on phone order page product details section");
			
			if(phoneorder.getUnitPriceOnProdDetails()=="199.00"){ 
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"199.00","Test Step - 11 - Item price is not displayed on phone order page product details section");
			}else if (phoneorder.getUnitPriceOnProdDetails()=="209.00") {
				softassert.assertEquals(phoneorder.getUnitPriceOnProdDetails(),"209.00","Test Step - 11 - Item price is not displayed on phone order page product details section");
			}
			
			// Test Step - 12
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.Verify_ProductDetails_Row1_Recipe(),"Test Step - 12 - Recipe icon is not displayed on row 1 product");		
			
			// Test Step - 13
			phoneorder.Click_ProductDetails_Row1_Recipe();
			delayWithGivenTime(2000);
			softassert.assertTrue(phoneorder.Verify_CreateRecipe_Popup(),"Test Step - 13 - Create Recipe popup is not displayed");
			
			// Test Step - 14
			phoneorder.Enter_RecipeNameTextboxField("Test QA");
			softassert.assertEquals(phoneorder.get_recipename_OnRecipenameTextbox(),"Test QA","Test Step - 14 - Entered Recipe name is not displayed on create recipe popup");
			
			// Test Step - 15
			phoneorder.Select_ItemGallery_onCreateRecipe("Designer's Choice Seasonal Arrangement");
			softassert.assertEquals(phoneorder.get_Selected_ItemGallery_onCreateRecipe(),"Designer's Choice Seasonal Arrangement","Test Step - 15 - Selected item is not displayed on item gallery dropdown at create recipe popup");
			
			// Test Step - 16
			phoneorder.SearchandSelect_ItemGallery_CreateRecipePopup("Lily - Gloriosa : Blue");
			
			// Test Step - 17
			softassert.assertEquals(phoneorder.Verify_RecipeItemRow3_OnTableIsDisplayed(),"Lily - Gloriosa Blue","Test Step - 17 - Recipe item row 3 is not displayed on item gallery table");

			// Test Step - 18
			phoneorder.Click_DisplayImage_ToogleButton_On_CreateRecipePopup();
			
			// Test Step - 19
			phoneorder.Click_Recipe_SaveBtn();
			delayWithGivenTime(1000);
			phoneorder.Click_SaveOption_RecipePopup();
			
			// Test Step - 20
			proposal = new ProposalsPage();
			proposal.ClickOnProposalsMenu();
			
			// Test Step - 21
			delayWithGivenTime(3000);
			proposal.Click_AddProposalBtn();
			delayWithGivenTime(2000);
			softassert.assertTrue(proposal.Verify_CreateProposalHeader_Popup(),"Test Step - 21 - Create a Proposal popup is not displayed");
			
			// Test Step - 22
			proposal.SearchandSelect_Customer_OnProposal("Abish");
			
			// Test Step - 23
			proposal.Click_AddProposal_On_CreateProposal_Popup();
			
			// Test Step - 24
			delayWithGivenTime(2000);
			
			manageproposal = new ManageProposalPage();
			softassert.assertEquals(manageproposal.get_ManageProposalPageTitle(), "Hana | ManageProposal","Test Step - 24 - Manage Proposal page is not displayed");
			delayWithGivenTime(2000);
			manageproposal.Click_CoupleDetailsTab();
			manageproposal.Select_Bride_Groom_DropDown1("Groom");
			delayWithGivenTime(2000);
			softassert.assertEquals(manageproposal.get_Entered_Bride_FirstName(), "Abish","Test Step - 24 - Entered bride first name is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Bride_LastName(), "David","Test Step - 24 - Entered bride last name is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Bride_PhoneNumber(), "956-655-0756","Test Step - 24 -Entered bride phone number is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Bride_Email(), "hanaposqateam@gmail.com","Test Step - 24 -Entered bride email is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Bride_City(), "San Diego","Test Step - 24 -Entered bride city is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Bride_State(), "CA","Test Step - 24 -Entered bride state is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Bride_Address(), "3402 Park Blvd","Test Step - 24 -Entered bride address is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Bride_Zip(), "92103","Test Step - 24 -Entered bride zip code is not displayed");
			delayWithGivenTime(2000);
			manageproposal.Select_Bride_Groom_DropDown2("Bride");
			delayWithGivenTime(2000);
			manageproposal.Enter_Groom_FirstName("O'Brien");
			manageproposal.Enter_Groom_LastName("John");
			manageproposal.Enter_Groom_PhoneNumber("925-456-2305");
			manageproposal.Enter_Groom_Email("hanaposqateam@gmail.com");
			manageproposal.Enter_Groom_City("El Cajon");
			manageproposal.Enter_Groom_State("CA");
			manageproposal.Enter_Groom_Address("Blossom Valley");
			manageproposal.Enter_Groom_Zip("92021");
			
			delayWithGivenTime(2000);
			softassert.assertEquals(manageproposal.get_Entered_Groom_FirstName(), "O'Brien","Test Step - 24 -Entered groom first name is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Groom_LastName(), "John","Test Step - 24 -Entered groom last name is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Groom_PhoneNumber(), "925-456-2305","Test Step - 24 -Entered groom phone number is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Groom_Email(), "hanaposqateam@gmail.com","Test Step - 24 -Entered groom email is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Groom_City(), "El Cajon","Test Step - 24 -Entered groom city is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Groom_State(), "CA","Test Step - 24 -Entered groom state is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Groom_Address(), "Blossom Valley","Test Step - 24 -Entered groom address is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Groom_Zip(), "92021","Test Step - 24 -Entered groom zip code is not displayed");
			delayWithGivenTime(2000);
			manageproposal.Click_Weddings_eventDetails_Tab();
			manageproposal.Enter_CeremonyLocation("The Ritz-Carlton, Lake Tahoe");
			manageproposal.Enter_CeremonyDate_WithInNext30Days();
			manageproposal.Enter_CeremonyTime();
			manageproposal.Enter_Ceremony_Address("13031 Ritz Carlton Highlands Court");
			manageproposal.Enter_Ceremony_City("Truckee");
			manageproposal.Enter_Ceremony_State("CA");
			manageproposal.Enter_Ceremony_Zip("96161");
			delayWithGivenTime(2000);
			softassert.assertEquals(manageproposal.get_Entered_CeremonyLocation(), "The Ritz-Carlton, Lake Tahoe","Test Step - 24 -Entered ceremony location is not displayed");
		//	softassert.assertEquals(manageproposal.get_Entered_CeremonyDate(), "Wed, 01 Oct 2022","Test Step - 24 -Entered ceremony date is not displayed");
		//	softassert.assertEquals(manageproposal.get_Entered_CeremonyTime(), "11:00 AM","Test Step - 24 -Entered ceremony time is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Ceremony_Address(), "13031 Ritz Carlton Highlands Court","Test Step - 24 -Entered ceremony address is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Ceremony_City(), "Truckee","Test Step - 24 -Entered ceremony city is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Ceremony_State(), "CA","Test Step - 24 -Entered ceremony state is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Ceremony_Zip(), "96161","Test Step - 24 -Entered ceremony zip code is not displayed");
			delayWithGivenTime(2000);
			manageproposal.Enter_ReceptionLocation("Rutherford Wedding Venue");
			manageproposal.Enter_ReceptionDate_WithInNext30Days();
			manageproposal.Enter_ReceptionTime();
			manageproposal.Enter_Reception_Address("180 Rutherford Hill Rd, Rutherford");
			manageproposal.Enter_Reception_City("Rutherford");
			manageproposal.Enter_Reception_State("CA");
			manageproposal.Enter_Reception_Zip("94573");
			delayWithGivenTime(2000);
			softassert.assertEquals(manageproposal.get_Entered_ReceptionLocation(), "Rutherford Wedding Venue","Test Step - 24 -Entered reception location is not displayed");
		//	softassert.assertEquals(manageproposal.get_Entered_CeremonyDate(), "Wed, 01 Oct 2022","Test Step - 24 -Entered ceremony date is not displayed");
		//	softassert.assertEquals(manageproposal.get_Entered_CeremonyTime(), "11:00 AM","Test Step - 24 -Entered ceremony time is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Reception_Address(), "180 Rutherford Hill Rd, Rutherford","Test Step - 24 -Entered reception address is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Reception_City(), "Rutherford","Test Step - 24 -Entered reception city is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_reception_State(), "CA","Test Step - 24 -Entered reception state is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_Reception_Zip(), "94573","Test Step - 24 -Entered reception zip code is not displayed");
			delayWithGivenTime(2000);
			manageproposal.Enter_WeddingCoordinator_FirstName("Daniel");
			manageproposal.Enter_WeddingCoordinator_LastName("Wilton");
			manageproposal.Enter_WeddingCoordinator_PhoneNumber("604-685-5761");
			manageproposal.Enter_WeddingCoordinator_Email("hanaposqateam@gmail.com");
			manageproposal.Enter_WeddingCoordinator_City("North Vancouver");
			manageproposal.Enter_WeddingCoordinator_State("BC");
			manageproposal.Enter_WeddingCoordinator_Address("1433 Pemberton Ave");
			manageproposal.Enter_WeddingCoordinator_Zip("V7P 2R8");
			
			delayWithGivenTime(2000);
			softassert.assertEquals(manageproposal.get_Entered_WeddingCoordinator_FirstName(), "Daniel","Test Step - 24 -Entered Wedding Coordinator first name is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_WeddingCoordinator_LastName(), "Wilton","Test Step - 24 -Entered Wedding Coordinator last name is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_WeddingCoordinator_PhoneNumber(), "604-685-5761","Test Step - 24 -Entered Wedding Coordinator phone number is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_WeddingCoordinator_Email(), "hanaposqateam@gmail.com","Test Step - 24 -Entered Wedding Coordinator email is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_WeddingCoordinator_City(), "North Vancouver","Test Step - 24 -Entered Wedding Coordinator city is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_WeddingCoordinator_State(), "BC","Test Step - 24 -Entered Wedding Coordinator state is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_WeddingCoordinator_Address(), "1433 Pemberton Ave","Test Step - 24 -Entered Wedding Coordinator address is not displayed");
			softassert.assertEquals(manageproposal.get_Entered_WeddingCoordinator_Zip(), "V7P 2R8","Test Step - 24 -Entered Wedding Coordinator zip code is not displayed");

			// Test Step - 25
			delayWithGivenTime(2000);
			manageproposal.Click_DocumentsAndImages_Tab();
			delayWithGivenTime(2000);
			manageproposal.UploadFiles("roses red.jpg");
			manageproposal.UploadFiles("samplepdf.pdf");
			
			// Test Step - 26
			manageproposal.Click_ItemsAndProducts_Tab();
			
			// Test Step - 27
			delayWithGivenTime(2000);
			manageproposal.Select_CategoryDropdown_On_ItemsAndProducts("Mother's Day");
			manageproposal.Enter_ItemName_On_ItemsAndProducts("rrd","rrd Small");
			manageproposal.Click_AddBtn_On_ItemsAndProducts();
			delayWithGivenTime(2000);
			softassert.assertEquals(manageproposal.get_Row1_ItemCategory(), "Mother's Day","Test Step - 27 - Selected category is not displayed on row 1 product table grid");
			softassert.assertEquals(manageproposal.get_row1_itemCode(), "rrd","Test Step - 27 - Item code is not displayed on row 1 product table grid");
			softassert.assertEquals(manageproposal.get_row1_itemDescription(), "Red Rose Small","Test Step - 27 - Item description is not displayed on row 1 product table grid");
			softassert.assertEquals(manageproposal.get_row1_itemQuantity(), "1","Test Step - 27 - Item quantity is not displayed on row 1 product table grid");
			softassert.assertEquals(manageproposal.get_row1_item_TotalPrice(), "$199.00","Test Step - 27 - Item total price is not displayed on row 1 product table grid");
			
			// Test Step - 28
			manageproposal.Click_Publish_Pending_Changes();
			softassert.assertTrue(manageproposal.Verify_Proposal_Pending_Changes_AlertIsDisplayed(), "Test Step - 28 - Publish pending changes alert popup is not displayed");
			
			// Test Step - 29
			delayWithGivenTime(2000);
			manageproposal.Click_PublishBtn_On_AlertPopup();
			proposal = new ProposalsPage();
			delayWithGivenTime(3000);
			softassert.assertEquals(proposal.get_ProposalsViewPageTitle(), "Hana | View Proposal","Test Step - 29 - View proposal page is not displayed");
			
			// Test Step - 30
			proposal.Click_Proposal_Id_Label();
			delayWithGivenTime(5000);
			softassert.assertTrue(proposal.Verify_Proposal_Id_Sort_asc_Icon(), "Test Step - 19 - Proposal Id ascending order arrow up icon is not displayed");
		
			proposal.Click_Proposal_Id_Label();
			delayWithGivenTime(2000);
			softassert.assertTrue(proposal.Verify_Proposal_Id_Sort_desc_Icon(), "Test Step - 29 - Proposal status type is not displayed");
			delayWithGivenTime(2000);
			softassert.assertEquals(proposal.get_Selected_Proposal_StatusType(), "Accepted","Test Step - 29 - Selected proposal status type is not displayed");
			delayWithGivenTime(3000);
			proposal.Click_Proposal_Action_Button();			
			
			// Test Step - 31
			proposal.Click_Proposal_CustProposalView_Button();
			delayWithGivenTime(2000);
			softassert.assertTrue(proposal.Verify_ItemNameIsDisplayed_on_CustProposalView(),"Test Step - 31 - Item name is not displayed on customer proposal view");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Test case failed due to exception " + e.getMessage());
			logger.error("Test case failed due to exception " + e.getMessage());
		} finally {
			softassert.assertAll();
		}
	}
}