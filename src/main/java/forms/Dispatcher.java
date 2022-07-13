package forms;

import locators.WebLocators;
import requests.getLoads;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.DateUtils;
import utilities.FunLibrary;
import utilities.PropertyManager;
import wrappers.PageBase;
import wrappers.TestBase;

import java.util.List;

public class Dispatcher extends PageBase implements WebLocators {

	PropertyManager propertyManager = new PropertyManager();
	TestBase base = new TestBase();
	static String load_Number = null;

	/**
	 * Instantiates a new adds the feedback page.
	 *
	 * @param driver the driver
	 */
	public Dispatcher(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = USERNAME)
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}

	@FindBy(xpath = PASSWORD)
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(xpath = LOGIN)
	private WebElement login;

	public WebElement getLogin() {
		return login;
	}

	@FindBy(xpath = DASHBOARD_LOGO)
	private WebElement dashboardLogo;

	public WebElement getDashboardLogo() {
		return dashboardLogo;
	}

	@FindBy(xpath = DISPATCHER_LEFT_MENU)
	private WebElement dispatcherLeftMenu;

	public WebElement getDispatcherLeftMenu() {
		return dispatcherLeftMenu;
	}

	@FindBy(xpath = ADD_NEW_LOAD_BUTTON)
	private WebElement addNewLoadNutton;

	public WebElement getAddNewLoadNutton() {
		return addNewLoadNutton;
	}

	@FindBy(xpath = CUSTOMER_DROPDOWN)
	private WebElement customerDropdown;

	public WebElement getCustomerDropdown() {
		return customerDropdown;
	}

	@FindBy(xpath = PORT_DROPDOWN)
	private WebElement portDropdown;

	public WebElement getPortDropdown() {
		return portDropdown;
	}

	@FindBy(xpath = CONSIGNEE_DROPDOWN)
	private WebElement consigneeDropdown;

	public WebElement getConsigneeDropdown() {
		return consigneeDropdown;
	}

	@FindBy(xpath = PROFILE_LINK)
	private WebElement profileLink;

	public WebElement getProfileLink() {
		return profileLink;
	}

	@FindBy(xpath = SELECT_DRIVER)
	private WebElement selectDriver;

	public WebElement getSelectDriver() {
		return selectDriver;
	}

	@FindBy(xpath = DRIVER_NAME)
	private WebElement driverName;

	public WebElement getDriverName() {
		return driverName;
	}

	@FindBy(xpath = CLOSE_POP_UP)
	private WebElement closePopup;

	public WebElement getClosePopup() {
		return closePopup;
	}

	@FindBy(xpath = SUCCESS_MSG)
	private WebElement successMsg;

	public WebElement getSuccessMsg() {
		return successMsg;
	}

	@FindBy(xpath = LOAD_CREATE_SUCCESS_MSG)
	private WebElement loadCreateSuccessMsg;

	public WebElement getLoadCreateSuccessMsg() {
		return loadCreateSuccessMsg;
	}

	@FindBy(xpath = NOTE_CREATE_SUCCESS_MSG)
	private WebElement noteCreateSuccessMsg;

	public WebElement getNoteCreateSuccessMsg() {
		return noteCreateSuccessMsg;
	}

	@FindBy(xpath = NEW_ITEM)
	private WebElement newItem;

	public WebElement getNewItem() {
		return newItem;
	}

	@FindBy(xpath = CREATE_LOAD_BTN)
	private WebElement createLoadBtn;

	public WebElement getCreateLoadBtn() {
		return createLoadBtn;
	}

	@FindBy(xpath = NOTES)
	private WebElement notes;

	public WebElement getNotes() {
		return notes;
	}

	@FindBy(xpath = DRIVER_NOTES)
	private WebElement driverNotes;

	public WebElement getDriverNotes() {
		return driverNotes;
	}

	@FindBy(xpath = ADD_NOTE_BTN)
	private WebElement addNoteBtn;

	public WebElement getAddNoteBtn() {
		return addNoteBtn;
	}

	@FindBy(xpath = BILLING)
	private WebElement billing;

	public WebElement getBilling() {
		return billing;
	}

	@FindBy(xpath = PRICE)
	private WebElement price;

	public WebElement getPrice() {
		return price;
	}

	@FindBy(xpath = SUMMARY_TOTAL)
	private WebElement summaryTotal;

	public WebElement getSummaryTotal() {
		return summaryTotal;
	}

	@FindBy(xpath = SELECT_DRIVER_DD)
	private WebElement selectDriverDD;

	public WebElement getSelectDriverDD() {
		return selectDriverDD;
	}

	@FindBy(xpath = SELECT_DATE)
	private WebElement selectDate;

	public WebElement getSelectDate() {
		return selectDate;
	}

	@FindBy(xpath = SELECT_PULLCONTAINER_DD)
	private WebElement pullContainerFromAddressDD;

	public WebElement getPullContainerFromAddressDD() {
		return pullContainerFromAddressDD;
	}

	@FindBy(xpath = SELECT_DELIVERLOAD_DD)
	private WebElement deliverLoadToAddressDD;

	public WebElement getDeliverLoadToAddressDD() {
		return deliverLoadToAddressDD;
	}

	@FindBy(xpath = SELECT_RETURNCONTAINER_DD)
	private WebElement returnContainerAddressDD;

	public WebElement getReturnContainerAddressDD() {
		return returnContainerAddressDD;
	}

	@FindBy(xpath = SAVE_CHANGES)
	private WebElement btnSaveChanges;

	public WebElement getBtnSaveChanges() {
		return btnSaveChanges;
	}

	@FindBy(xpath = SAVE_CHANGES_ALERT)
	private WebElement saveChangesAlert;

	public WebElement getSaveChangesAlert() {
		return saveChangesAlert;
	}

	@FindBy(xpath = SAVE_CHANGES_YES)
	private WebElement btnSaveChangesYes;

	public WebElement getBtnSaveChangesYes() {
		return btnSaveChangesYes;
	}

	@FindBy(xpath = COMPLETE_LOAD)
	private WebElement completeLoad;

	public WebElement getCompleteLoad() {
		return completeLoad;
	}

	@FindBy(xpath = LOAD_NUMBERS)
	private List<WebElement> loadNumbers;

	public List<WebElement> getLoadNumbers() {
		return loadNumbers;
	}

	@FindBy(xpath = ALL_LOAD_TITLE)
	private WebElement allLoadTitle;

	public WebElement getAllLoadTitle() {
		return allLoadTitle;
	}

	@FindBy(xpath = UPLOAD_DOCUMENTS)
	private WebElement uploadDocument;

	public WebElement getUploadDocument() {
		return uploadDocument;
	}

	@FindBy(xpath = BILL_TYPE_DD)
	private WebElement docTypeDD;

	public WebElement getDocTypeDD() {
		return docTypeDD;
	}

	@FindBy(xpath = UPLOAD_DOCUMENT_AREA)
	private WebElement uploadFileArea;

	public WebElement getUploadFileArea() {
		return uploadFileArea;
	}
	
	@FindBy(xpath=LOAD_NUMBER)
	private WebElement loadNumber;

	public WebElement getLoadNumber() {
		return loadNumber;
	}

	public PropertyManager getPropertyManager() {
		return propertyManager;
	}

	public TestBase getBase() {
		return base;
	}

	public void openAUT() {
		base.setupBrowser(propertyManager.getResourceBundle.getProperty("OperatingSystem"),
				propertyManager.getResourceBundle.getProperty("BROWSER"),
				propertyManager.getResourceBundle.getProperty("PROD_BASE_URL"));
	}

	public void closeAUT() {
		base.clearCache();
		base.closeBrowser();
	}

	public void enterCredentials(String username, String password) {
		base.waitForElementVisible(10, getUsername());
		base.waitForElementToBeClickable(10, getUsername());
		getUsername().clear();
		getUsername().sendKeys(username);
		base.waitForElementToBeClickable(10, getPassword());
		getPassword().clear();
		getPassword().sendKeys(password);
	}

	public void loginUser(String username, String password) {
		enterCredentials(username, password);
		base.waitForElementToBeClickable(10, getLogin());
		getLogin().click();
		base.implicitWait(10);
	}

	public void redirectToDispatcher() {
		base.waitForElementVisible(30, getDispatcherLeftMenu());
		base.waitForElementToBeClickable(30, getDispatcherLeftMenu());
		getDispatcherLeftMenu().click();
		base.implicitWait(10);
	}

	public void clickAddNewLoadButton() {
		base.waitForElementToBeClickable(30, getAddNewLoadNutton());
		getAddNewLoadNutton().click();
	}

	public void clickCustomerDropdown() {
		base.waitForElementVisible(10, getCustomerDropdown());
		base.waitForElementToBeClickable(10, getCustomerDropdown());
		getCustomerDropdown().click();
		List<WebElement> Cust = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));
		Cust.get(0).click();
	}

	public void clickPortDropdown() {
		base.waitForElementVisible(10, getPortDropdown());
		base.waitForElementToBeClickable(10, getPortDropdown());
		getPortDropdown().click();
		List<WebElement> Cust = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));
		Cust.get(0).click();
	}

	public void clickConsigneeDropdown() {
		base.waitForElementVisible(10, getConsigneeDropdown());
		base.waitForElementToBeClickable(10, getConsigneeDropdown());
		getConsigneeDropdown().click();
		List<WebElement> Cust = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));
		Cust.get(0).click();
	}

	public void clickCreateLoadButton() {
		base.waitForElementVisible(10, getCreateLoadBtn());
		base.waitForElementToBeClickable(10, getCreateLoadBtn());
		getCreateLoadBtn().click();
	}

	public void addNewLoad() {
		clickAddNewLoadButton();
		clickCustomerDropdown();
		clickPortDropdown();
		clickConsigneeDropdown();
		clickCreateLoadButton();
	}

	public void clickProfileLink() {
		base.waitForElementVisible(30, getProfileLink());
		base.waitForElementToBeClickable(10, getProfileLink());
		getProfileLink().click();
	}

	public void closePopUp() {
		base.waitForElementVisible(10, getClosePopup());
		base.waitForElementToBeClickable(10, getClosePopup());
		getClosePopup().click();
	}

	public void clickDriver() {
		base.waitForElementVisible(10, getDriverName());
		base.waitForElementToBeClickable(10, getDriverName());
		getDriverName().click();
	}

	public void selectDriverFromDD(String driverName) {
		base.waitForElementVisible(10, getSelectDriverDD());
		base.waitForElementToBeClickable(10, getSelectDriverDD());
		base.pause(3000);
		getSelectDriverDD().click();

		List<WebElement> Cust = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));

		for (WebElement ele : Cust) {

			if (ele.getText().equalsIgnoreCase(driverName)) {
				System.out.println(ele.getText());
				ele.click();
				break;
			}
		}
	}

	public void selectDate() {
		base.waitForElementVisible(10, getSelectDate());
		base.waitForElementToBeClickable(10, getSelectDate());
		getSelectDate().click();
		getSelectDate().clear();
		String tomorrowDate = DateUtils.getFormattedDate(DateUtils.getTomorrowDate(), "MM-DD-YY h:mm a");
		getSelectDate().sendKeys(tomorrowDate);
	}

	public void selectPullContainerFromDD(String fromAddress) {
		base.waitForElementVisible(10, getPullContainerFromAddressDD());
		base.waitForElementToBeClickable(10, getPullContainerFromAddressDD());
		getPullContainerFromAddressDD().click();

		List<WebElement> fromAddresses = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));

		for (WebElement ele : fromAddresses) {

			if (ele.getText().equalsIgnoreCase(fromAddress)) {
				System.out.println(ele.getText());
				ele.click();
				break;
			}
		}
	}

	public void selectDeliverLoadFromDD(String toAddress) {
		base.waitForElementVisible(10, getDeliverLoadToAddressDD());
		base.waitForElementToBeClickable(10, getDeliverLoadToAddressDD());
		getDeliverLoadToAddressDD().click();

		List<WebElement> toAddresses = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));

		for (WebElement ele : toAddresses) {

			if (ele.getText().equalsIgnoreCase(toAddress)) {
				System.out.println(ele.getText());
				ele.click();
				break;
			}
		}
	}

	public void selectReturnContainerFromDD(String returnAddress) {
		base.waitForElementVisible(10, getReturnContainerAddressDD());
		base.waitForElementToBeClickable(10, getReturnContainerAddressDD());
		getReturnContainerAddressDD().click();

		List<WebElement> returnAddresses = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));

		for (WebElement ele : returnAddresses) {

			if (ele.getText().equalsIgnoreCase(returnAddress)) {
				System.out.println(ele.getText());
				ele.click();
				break;
			}
		}
	}

	public void assignDriver(String driverName) {
		clickProfileLink();
		selectDriver(driverName);
		clickDriver();
	}

	public void clickNotes() {
		base.waitForElementVisible(10, getNotes());
		base.waitForElementToBeClickable(10, getNotes());
		getNotes().click();
	}

	public void enterDriverNotes(String driverNotes) {
		base.waitForElementVisible(10, getDriverNotes());
		base.waitForElementToBeClickable(10, getDriverNotes());
		getDriverNotes().click();
		getDriverNotes().sendKeys(driverNotes);
	}

	public void clickAddNote() {
		base.waitForElementVisible(10, getAddNoteBtn());
		base.waitForElementToBeClickable(10, getAddNoteBtn());
		getAddNoteBtn().click();
	}

	public void addNewNotes(String driverNotes) {
		clickNotes();
		enterDriverNotes(driverNotes);
		clickAddNote();
	}

	public void selectLoadOptions(String loadOption) {
		List<WebElement> loadOptions = base.getdriver().findElements(By.xpath(
				"//ul[@class='nav nav-tabs nav-tabs-custom nav-justified nav-border-bottom']/li/a/div[@class='nav-link__text']"));
		for (WebElement option : loadOptions) {
			if (option.getText().equalsIgnoreCase(loadOption)) {
				option.click();
			}
		}
	}

	public void selectDriver(String loadOption) {
		List<WebElement> loadOptions = base.getdriver().findElements(By.xpath(
				"//ul[@class='nav nav-tabs nav-tabs-custom nav-justified nav-border-bottom']/li/a/div[@class='nav-link__text']"));
		for (WebElement option : loadOptions) {
			if (option.getText().equalsIgnoreCase(loadOption)) {
				option.click();
			}
		}
	}

	public boolean validateLoadCreateSuccessMessage() {
		base.waitForElementVisible(10, getLoadNumber());
		boolean loadNum = getLoadNumber().isDisplayed();
		
		if(loadNum) {
			load_Number = getLoadNumber().getText().trim();
			return true;
		}
		else {
			Assert.fail();
			return false;
		}
		
	}

	public boolean validateNoteCreateSuccessMessage() {
		base.waitForElementVisible(10, getNoteCreateSuccessMsg());
		String msg = getNoteCreateSuccessMsg().getText();
		if (msg.equals("Notes Added")) {
			return true;
		}
		return false;
	}

	public boolean validateSuccessMessage() {
		base.waitForElementVisible(10, getSuccessMsg());
		String msg = getSuccessMsg().getText();
		if (msg.equals("Successfully assign")) {
			closePopUp();
			return true;
		}
		return false;
	}

	public boolean validateBillingSummary() {
		List<WebElement> charges = driver.findElements(By.xpath("//table[@class='table table-card mb-1']/tbody/tr"));
		String price = getPrice().getAttribute("value");
		String summaryTotal = getSummaryTotal().getText();
		StringBuilder MyString = new StringBuilder(summaryTotal);
		MyString.deleteCharAt(0);
		if (price.equals(MyString)) {
			return true;
		}
		return false;
	}

	public void clickSaveChanges() {
		base.waitForElementVisible(10, getBtnSaveChanges());
		base.waitForElementToBeClickable(10, getBtnSaveChanges());
		getBtnSaveChanges().click();
	}

	public void clickSaveChangesYes() {
		base.waitForElementVisible(10, getSaveChangesAlert());
		base.waitForElementToBeClickable(10, getBtnSaveChangesYes());
		getBtnSaveChangesYes().click();
	}

	public boolean validateRouteAssignSuccessMessage() {
		base.waitForElementVisible(10, getSuccessMsg());
		String msg = getSuccessMsg().getText();
		System.out.println("Message: " + msg);
		if (msg.equals("Successfully assign")) {
			closePopUp();
			return true;
		}
		return false;
	}

	public void clickCompleteLoad() {
		base.waitForElementToBeClickable(10, getCompleteLoad());
		getCompleteLoad().click();
	}

	public void selectLoad() {

		base.waitForElementVisible(20, getAllLoadTitle());
		// base.getdriver().findElement(By.id("Available1")).click();
		JavascriptExecutor js = (JavascriptExecutor) base.getdriver();
		js.executeScript("arguments[0].click()", base.getdriver().findElement(By.id("Available1")));
		base.pause(3000);
		List<WebElement> loadNumbers2 = getLoadNumbers();
		int loaNo = FunLibrary.getRandomNumber(loadNumbers2.size());
		loadNumbers2.get(loaNo).click();
	}

	public void updateChanges() {

		base.waitForElementVisible(10, getBtnSaveChanges());
		base.waitForElementToBeClickable(10, getBtnSaveChanges());
		getBtnSaveChanges().click();
	}

	public String getTotalAmount() {

		base.waitForElementVisible(10, getSummaryTotal());
		String total = getSummaryTotal().getText().replace("$", "").trim();
		//total = total.replace(".00", "");
		total = total.replace(",", "");
		// --Operation on UI are very fae so to verify the update and delete messages
		// put 5 sec wait
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	public void clickUploadDoc() {
		base.waitForElementVisible(10, getUploadDocument());
		base.waitForElementToBeClickable(10, getUploadDocument());
		getUploadDocument().click();
		base.waitForElementVisible(10, getUploadFileArea());
	}

	public void uploadFile() {

		String filePath = propertyManager.getResourceBundle.getProperty("FILE_PATH");
		base.waitForElementVisible(15, getUploadFileArea());
		base.waitForElementToBeClickable(15, getUploadFileArea());
		System.out.println(filePath);
		getUploadFileArea().sendKeys(filePath);
		// 5 scond wait for completing the file upload
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * try { String filePath = System.getProperty("user.dir") +
		 * "/src/main/resources/Upload.csv"; StringSelection stringSelection = new
		 * StringSelection(filePath);
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,
		 * null); Robot robot; robot = new Robot(); robot.keyPress(KeyEvent.VK_CONTROL);
		 * robot.keyPress(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_V);
		 * robot.keyRelease(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER); } catch (AWTException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

	public void selectDocumentType_DD() {

		base.waitForElementVisible(10, getDocTypeDD());
		base.waitForElementToBeClickable(10, getDocTypeDD());
		getDocTypeDD().click();
		List<WebElement> doc = driver.findElements(By.xpath("//div[@class='css-kj6f9i-menu']/div/div"));
		if (doc.size() > 0) {

			doc.get(FunLibrary.getRandomNumber(doc.size())).click();
		}
	}

	public void saveDocuments() {

		base.waitForElementVisible(10, getAddNoteBtn());
		base.waitForElementToBeClickable(10, getAddNoteBtn());
		getAddNoteBtn().click();
	}
	
	public void deleteLoad() {
		System.out.println("=======>" +load_Number);
		load_Number = load_Number.replace("Load #:", "").trim();
		getLoads.deleteCreatedLoad(load_Number);
		
	}
}
