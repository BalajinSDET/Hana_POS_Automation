package com.hanapos.seleniumProjectBase;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface FrameworkDesign {

	/** @author  Balaji N - Dream Corp
	 * @param browserName - This will load the specified browser to launch
	 * @Description - This method will launch the application
	 * */

	public void launchApplication(String browserName);

	/** @author  Balaji N - Dream Corp 
	 * @Description - This method will load the config properties file
	 */

	public void loadConfig();
	/** @author  Balaji N - Dream Corp 
	 * @Description - This method will highlight the field of element
	 * */

	public void HighlightElement(WebElement ele);

	/**
	 * This method will click the element 
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @author Balaji N - Dream Corp
	 * @throws StaleElementReferenceException
	 */

	public void click(WebElement ele);

	/**
	 * This method will scroll and click the element using javascript executor
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @author Balaji N - Dream Corp
	 * @throws StaleElementReferenceException
	 */

	public void jsScrollClick(WebElement ele);

	/**
	 * This method will click the element using action class
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @author Balaji N - Dream Corp
	 * @throws StaleElementReferenceException
	 */
	public  void actionClick(WebElement ele);
	/**
	 * This method will scroll and click the element using action class
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @author Balaji N - Dream Corp
	 * @throws StaleElementReferenceException
	 */

	public void actionScrollClick(WebElement ele);

	/**
	 * This method will click the element using javascript executor
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @author Balaji N - Dream Corp
	 */
	public void jsClick(WebElement ele);
	/**
	 * This method will enter the value in the given text field 
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Balaji N - Dream Corp
	 * @throws ElementNotInteractable,IllegalArgumentException(throws if keysToSend is null)	
	 */

	public void append(WebElement ele, String data);

	/**
	 * This method will clear the data in text field using action class
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @author Balaji N - Dream Corp
	 */
	public  void actionClear(WebElement ele);

	/**
	 * This method will click and enter the value in the given text field 
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Balaji N - Dream Corp
	 */
	public void clickAndType(WebElement ele, String data);

	/**
	 * This method will enter the value in the given text field using action class
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Balaji N - Dream Corp
	 */
	public void actionType(WebElement ele,String data);

	/**
	 * This method will clear and type the value in the given text field 
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Balaji N - Dream Corp
	 * @throws ElementNotInteractable,IllegalArgumentException(throws if keysToSend is null)		 
	 */
	public  void clearAndType(WebElement ele, String data);

	/**
	 * This method will clear and type the value in the given text field using javascript executor
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Balaji N - Dream Corp
	 * @throws ElementNotInteractable,IllegalArgumentException(throws if keysToSend is null)		 
	 */
	public  void jsClearAndType(WebElement ele, String data);
	/**
	 * This method will enter the value in the given text field using javascript executor
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Balaji N - Dream Corp
	 */
	public void jsTypeAndEnter(WebElement ele, String data);

	/**
	 * This method will scroll and enter the value in the given text field using javascript executor
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @author Balaji N - Dream Corp
	 */
	public void jsScrollClickAndEnter(WebElement ele, String data);

	/**
	 * This method will wait for the given time using robot class
	 * @param timeInterval   - The int (time in milliseconds) to be waited
	 * @author Balaji N - Dream Corp
	 */

	public void delayWithGivenTime(int timeInterval);

	/**
	 * This method will select the value in the given dropdown using select class
	 * @param ele   - This element will find the dropdown field
	 * @param value  - The value to be sent to the webelement
	 * @param usingmethod  - The type of method to be used to select the value
	 * @author Balaji N - Dream Corp
	 */

	public void dropDown(WebElement ele, String value, String usingmethod);

	/** 
	 * This method will switch to the alert
	 * @author Balaji N - Dream Corp
	 * @throws NoAlertPresentException*/

	public void switchToAlert();

	/** 
	 * This method will switch to the alert and accept the alert
	 * @author Balaji N - Dream Corp
	 * @throws NoAlertPresentException*/

	public void acceptAlert();

	/** 
	 * This method will switch to the alert and dismiss the alert
	 * @author Balaji N - Dream Corp
	 * @throws NoAlertPresentException*/

	public void dismissAlert();

	/**
	 * This method will switch to the alert and get the text
	 * @author Balaji N - Dream Corp
	 * @return - The text of the alert message
	 * @throws NoAlertPresentException*/

	public String getAlertText();

	/** 
	 * This method will wait for the element to be visible explicitly
	 * @author Balaji N - Dream Corp
	 * @param ele   - The Webelement to wait of presence
	 * @throws ElementNotVisibleException*/

	public void explicitWait(WebElement ele);

	/** 
	 * This method will wait for the element to be visible using fluent wait
	 * @author Balaji N - Dream Corp
	 * @param ele   - The Webelement to wait of presence
	 * @throws ElementNotVisibleException*/

	public void fluentWait(WebElement ele);

	/**
	 * This method will switch to the specific frame using index
	 * @param index   - The int (frame) to be switched
	 * @author Balaji N - Dream Corp
	 * @throws NoSuchFrameException 
	 */
	public void switchToFrame(int index);	

	/**
	 * This method will switch to the specific frame
	 * @param ele   - The Webelement (frame) to be switched
	 * @author Balaji N - Dream Corp
	 * @throws NoSuchFrameException, StaleElementReferenceException 
	 */
	public void switchToFrame(WebElement ele);

	/**
	 * This method will switch to the specific frame using Id (or) Name
	 * @param idOrName   - The String (frame) to be switched
	 * @author Balaji N - Dream Corp
	 * @throws NoSuchFrameException 
	 */
	public void switchToFrame(String idOrName);

	/**
	 * This method will switch to the first frame on the page
	 * @author Balaji N - Dream Corp
	 * @return This driver focused on the top window/first frame.
	 */
	public void defaultContent();

	/**
	 * This method will verify browser actual url with expected
	 * @param url   - The url to be checked
	 * @author Balaji N - Dream Corp
	 * @return true if the given object represents a String equivalent to this url, false otherwise
	 */
	public boolean verifyUrl(String url);

	/**
	 * This method will verify browser actual title with expected
	 * @param title - The expected title of the browser
	 * @author Balaji N - Dream Corp
	 * @return true if the given object represents a String equivalent to this title, false otherwise
	 */
	public boolean verifyTitle(String title);

	/**
	 * This method will get the visible text of the element
	 * @param ele   - The Webelement (button/link/element) in which text to be retrieved
	 * @author Balaji N - Dream Corp
	 */
	public String getElementText(WebElement ele);	

	/**
	 * This method will get the text of the element textbox
	 * @param ele   - The Webelement (button/link/element) in which text to be retrieved
	 * @author Balaji N - Dream Corp
	 * @return The attribute/property's current value (or) null if the value is not set.
	 */
	public String getTypedText(WebElement ele);

	/**
	 * This method is used to search and select the element
	 * @param ele - This is a list of web elements
	 * @param data - This is the data to be searched
	 * @author Balaji N - Dream Corp
	 */
	public void searchAndSelect(List<WebElement> ele, String data);

	/**
	 * This method is used to draw the signature on the element
	 * @param ele - This is a list of web elements
	 * @param data - This is the data to be searched
	 * @author Balaji N - Dream Corp
	 */
	public void drawSignature(WebElement ele);

	/**
	 * This method will switch to the specific window
	 * @param index   - The int (window) to be switched
	 * @author Balaji N - Dream Corp
	 */
	public void switchToWindowbyIndex(int index);

	/**
	 * This method will get the Color values of the element
	 * @param ele   - The Webelement (button/link/element) in which text to be retrieved
	 * @author Balaji N - Dream Corp
	 * @return The visible text of this element.
	 */
	public String getBackgroundColor(WebElement ele);

	/**
	 * This method will handle date picker using javascript executor
	 * @param ele   - The date picker element to be interacted 
	 * @param dateval - The data to be searched
	 * @author Balaji N - Dream Corp
	 */

	public void jsDatePicker(WebElement ele, String dateval);

	/**
	 * This method will handle date picker using javascript executor
	 * @param ele   - The date picker element to be interacted 
	 * @author Balaji N - Dream Corp
	 */

	public void datePicker(WebElement ele,WebElement ActualMonthYear,WebElement NextArrow,List<WebElement> alldates, String date);
	/**
	 * This method will perform the scroll action using action class
	 * @param ele   - The element to be scrolled  
	 * @author Balaji N - Dream Corp
	 */
	
	public void scrollAction(WebElement ele);

	/**
	 * This method will mouse hover the specific element using action class
	 * @param ele   - The element to be hovered  
	 * @author Balaji N - Dream Corp
	 */

	public void MouseHover(WebElement ele);

	/**
	 * This method will mouse hover the specific element using javascript executor
	 * @param ele   - The element to be hovered  
	 * @author Balaji N - Dream Corp
	 */

	public boolean mouseHoverByJavaScript(WebElement ele);
	/**
	 * This method will hover the mouse on specified element and click on the specified element
	 * @param hoverele   - The element to be hovered on page
	 * @param clickeele - The element to be clicked on page
	 * @author Balaji N - Dream Corp
	 */
	
	public void MouseHoverAndClick(WebElement hoverele,WebElement clickeele);
	/**
	 * This method will take the screenshot of the page
	 * @param tname   - The test name will be passed as parameter
	 * @author Balaji N - Dream Corp
	 */	
	
	public String captureScreen(String tname);

	/**
	 * This method will upload the file to the element
	 * @param ele   - The element to be uploaded
	 * @param filepath - The file path to be uploaded the element
	 * @author Balaji N - Dream Corp
	 */	

	public void uploadFile(WebElement ele, String filepath);

	/**
	 * This method will upload the file to the element
	 * @param ele   - The element to be uploaded
	 * @param filepath - The file path to be downloaded location
	 * filename - The downloaded file name 
	 * @author Balaji N - Dream Corp
	 */	

	public void VerifyFileDownLoad(WebElement ele, String pathfile, String filename);

	/**
	 * This method will handle the analog clock time
	 * @param TimeValue - The time value to be passed as parameter
	 * @param ele   - The element to be verified
	 * @author Balaji N - Dream Corp
	 */

	public void HandleAnalogClock(String TimeValue, WebElement ele);

	/**
	 * This method will get the current time from the system
	 * @author Balaji N - Dream Corp
	 */

	public String GetCurrentTime();

	/**
	 * This method will verify the element is displayed on page or not
	 * @author Balaji N - Dream Corp
	 */

	public boolean verifyIsDisplayed(WebElement ele);

	/**
	 * This method will verify the element is enabled on page or not
	 * @author Balaji N - Dream Corp
	 */

	public boolean verifyIsEnabled(WebElement ele);

	/**
	 * This method will verify the element is selected on page or not
	 * @author Balaji N - Dream Corp
	 */

	public boolean verifyIsSelected(WebElement ele);

	/**
	 * This method will perform right click action
	 * @author Balaji N - Dream Corp
	 */

	public void rightClickAction();

	/**
	 * This method will handle the drag and drop actions using action class
	 * @author Balaji N - Dream Corp
	 */

	public void dragAndDrop(WebElement source, WebElement target);

	/**
	 * This method will return the column count of the table
	 * @param ele   - The table column element
	 * @author Balaji N - Dream Corp
	 */

	public int getColumncount(WebElement ele);

	/**
	 * This method will return the row count of the table
	 * @param ele   - The table row element
	 * @author Balaji N - Dream Corp
	 */

	public int getRowCount(WebElement ele);

	public void HandleAutocomplete(WebElement ele,String data);
}
