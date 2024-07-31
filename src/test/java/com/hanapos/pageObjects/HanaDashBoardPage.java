package com.hanapos.pageObjects;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hanapos.seleniumProjectBase.TestBaseClass;

public class HanaDashBoardPage extends TestBaseClass {
	public HanaDashBoardPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[@class='li_Hana navbar-brand']")
	private WebElement HanaLogo;

	@FindBy(xpath = "(//button[@id='dropdownMenu1'])[1]")
	private WebElement NewOrderMenuBtn;

	@FindBy(xpath = "//a[@class='li_NewOrder']")
	private WebElement OrderEntry;

	@FindBy(xpath = "//a[@class='li_CashAndCarry']")
	private WebElement CashAndCarry;

	@FindBy(xpath = "//span[normalize-space()='Orders']")
	private WebElement OrdersMenu;

	@FindBy(xpath = "//a[normalize-space()='All Orders']")
	private WebElement AllOrdersSubMenu;

	@FindBy(xpath = "//select[@id='ddlShop']")
	private WebElement ShopNameDropDown;
	
	@FindBy(xpath="//div[@id='dashboard_datepicker']//div[@class='dashborad-tabs']")
	private WebElement DateSelection;
	
	@FindBy(xpath="//span[contains(text(),' Wait Queue ')]")
	private WebElement WaitQueueTab;
	
	@FindBy(xpath="//span[@id='lblWaitQueue']")
	private WebElement WaitQueueCount;
	
	@FindBy(xpath="//span[contains(text(),' Pending Pickups ')]")
	private WebElement PendingPickupsTab;
	
	@FindBy(xpath="//span[@id='lblPickupOrders']")
	private WebElement PendingPickupsCount;
	
	@FindBy(xpath="//span[contains(text(),' Pending Deliveries ')]")
	private WebElement PendingDeliveriesTab;
	
	@FindBy(xpath="//span[@id='lblAwaitingDispatch']")
	private WebElement PendingDeliveriesCount;
	
	@FindBy(xpath="//span[contains(text(),' Pending Confirmations ')]")
	private WebElement PendingConfirmationsTab;
	
	@FindBy(xpath="//span[@id='lblUnconfirm']")
	private WebElement PendingConfirmationsCount;
	
	@FindBy(xpath="//label[@id='lblWaitcnt']")
	private WebElement WaitQueueIconCount;
	
	@FindBy(xpath="//a[@id='idWaitQueue']")
	private WebElement WaitQueueIcon;
	
	@FindBy(xpath="(//i[@class='fa fa-2x fa-shopping-basket'])[1]")
	private WebElement PendingPickupIcon;
	
	@FindBy(xpath="//span[@id='spnPickupCnt']")
	private WebElement PendingPickupIconCount;
	
	@FindBy(xpath="(//i[@class='fa fa-2x fa-clipboard'])[1]")
	private WebElement ViewDraftIcon;
	
	@FindBy(xpath="//label[@id='lblDraftcnt']")
	private WebElement ViewDraftIconCount;
	
	@FindBy(xpath="(//i[@class='fa fa-2x fa-comment'])[1]")
	private WebElement NewMessageIcon;
	
	@FindBy(xpath="//label[@id='lblUnRead']")
	private WebElement NewMessageIconCount;
	
	@FindBy(xpath="(//button[normalize-space()='Dispatch'])[1]")
	private WebElement DispatchMenu;
	
	@FindBy(xpath="//a[normalize-space()='Advanced Dispatch']")
	private WebElement AdvancedDispatch;
	
	@FindBy(xpath="//a[normalize-space()='Quick Dispatch']")
	private WebElement QuickDispatch;
	
	@FindBy(xpath="(//i[@data-toggle='tooltip'])[1]")
	private WebElement NewTabPlusIcon;
	
	@FindBy(xpath="(//input[@id='top-search1'])[1]")
	private WebElement DashboardSearchBox;
	
	@FindBy(xpath="//a[@id='idEmail']")
	private WebElement EmailIcon;
	
	@FindBy(xpath="//label[@id='lblEmail']")
	private WebElement EmailIconCount;
	
	@FindBy(xpath="//a[@id='CalenderList']")
	private WebElement IntegrateCalenderIcon;
	
	@FindBy(xpath="//a[@id='btnRemoteConnect']")
	private WebElement RemoteConnectIcon;
	
	@FindBy(xpath="//a[@class='open-small-chat']")
	private WebElement HelpIcon;
	
	@FindBy(xpath="//a[@id='hana-profile-menu-link']")
	private WebElement ProfileIcon;
	
	@FindBy(xpath="//a[@class='li_LogoutNew common-dynamic-font-size']")
	private WebElement LogoutIcon;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']//li//a")
	private List <WebElement> NewOrderList;
	
	@FindBy(id="CustomersMenu")
	private WebElement CustomersMenu;

	public String VerifyPageTitleonDashboard() {
		return getDriver().getTitle();
	}

	public HanaDashBoardPage SelectShopNameDropDown(String shopname) {
		 Select select = new Select(ShopNameDropDown);
		 select.selectByVisibleText(shopname);
		// dropDown(ShopNameDropDown, shopname, "VisibleText");
		 return this;
	}
	
	public boolean VerifyHanaDashBoardPage() {		
		HighlightElement(HanaLogo);
		fluentWait(HanaLogo);
		HanaLogo.isDisplayed();
		
		return HanaLogo.isDisplayed();
	}
	
	public void ClickOnHomeIcon() {
		jsClick(HanaLogo);
	}
	
	public OrderEntry_Alais_PhoneOrderPage NewOrderMenuClick() {
		HighlightElement(NewOrderMenuBtn);
		MouseHover(NewOrderMenuBtn);
		HighlightElement(OrderEntry);
		click(OrderEntry);
		return new OrderEntry_Alais_PhoneOrderPage();
	}

	public CashAndCarryPage CashAndCarryMenuClick() {	
		ThreadWait(2000);
		fluentWait(NewOrderMenuBtn);
		Actions action = new Actions(getDriver());			
		action.moveToElement(NewOrderMenuBtn).build().perform();					
		delayWithGivenTime(2000);	
		fluentWait(CashAndCarry);
		HighlightElement(CashAndCarry);	
		action.moveToElement(CashAndCarry).click().build().perform();	 
		return new CashAndCarryPage();
	}

	
	public CashAndCarryPage ClickOrderEntry() {	
		ThreadWait(2000);
		fluentWait(NewOrderMenuBtn);
		Actions action = new Actions(getDriver());			
		action.moveToElement(NewOrderMenuBtn).build().perform();					
		delayWithGivenTime(1500);	
		fluentWait(CashAndCarry);
		ThreadWait(500);
		HighlightElement(OrderEntry);	
		action.moveToElement(OrderEntry).click().build().perform();	
		
		
		//MouseHoverAndClick(NewOrderMenuBtn, OrderEntry);
		return new CashAndCarryPage();
	}
	public void ClickOrder() {
		fluentWait(OrdersMenu);
		click(OrdersMenu);
	}

	public DashboardOrderPage ClickAllOrder() {
		explicitWait(OrdersMenu);
		MouseHoverAndClick(OrdersMenu, AllOrdersSubMenu);
		return new DashboardOrderPage();
	}

	public HanaDashBoardPage SelectShopName(String shopname) {
		dropDown(ShopNameDropDown, shopname, "VisibleText");
		return this;
	}
	
	public boolean VerifyOrderEntryOptionIsDisplayed() {
		MouseHover(NewOrderMenuBtn);
		HighlightElement(OrderEntry);
		return OrderEntry.isDisplayed();
	}
	
	public boolean Verify_Cashandcarry_OptionIsDisplayed() {
		MouseHover(NewOrderMenuBtn);
		HighlightElement(CashAndCarry);
		return CashAndCarry.isDisplayed();
	}
	
	public void ClickCustomersMenu() {
		ThreadWait(2000);
		fluentWait(CustomersMenu);
		CustomersMenu.click();
		//jsClick(CustomersMenu);
	}
}
