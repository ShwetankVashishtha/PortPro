package forms;

import locators.WebLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.PropertyManager;
import wrappers.PageBase;
import wrappers.TestBase;
import java.util.List;

public class Dispatcher extends PageBase implements WebLocators {

    PropertyManager propertyManager = new PropertyManager();
    TestBase base = new TestBase();

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

    public void openAUT() {
        base.setupBrowser(propertyManager.getResourceBundle.getProperty("OperatingSystem"), propertyManager.getResourceBundle.getProperty("BROWSER"),
                propertyManager.getResourceBundle.getProperty("BASE_URL"));
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

    public boolean verifyDashboardLogo() {
        if (getDashboardLogo().isDisplayed()) {
            return true;
        }
        return false;
    }

    public void redirectToDispatcher() {
        base.waitForElementVisible(10, getDispatcherLeftMenu());
        base.waitForElementToBeClickable(10, getDispatcherLeftMenu());
        getDispatcherLeftMenu().click();
        base.implicitWait(10);
    }

    public void clickAddNewLoadButton() {
        base.waitForElementToBeClickable(10, getAddNewLoadNutton());
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
        base.waitForElementVisible(10, getProfileLink());
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

    public void selectDriver(String driverName) {
        base.waitForElementVisible(10, getSelectDriver());
        base.waitForElementToBeClickable(10, getSelectDriver());
        getSelectDriver().sendKeys(driverName);
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
        List<WebElement> loadOptions = base.getdriver().findElements(By.xpath("//ul[@class='nav nav-tabs nav-tabs-custom nav-justified nav-border-bottom']/li/a/div[@class='nav-link__text']"));
        for (WebElement option : loadOptions) {
            if (option.getText().equalsIgnoreCase(loadOption)) {
                option.click();
            }
        }
    }

    public boolean validateLoadCreateSuccessMessage() {
        base.waitForElementVisible(10, getLoadCreateSuccessMsg());
        String msg = getLoadCreateSuccessMsg().getText();
        if (msg.equals("Load created")) {
            return true;
        }
        return false;
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
}
