package forms;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import locators.WebLocators;
import utilities.PropertyManager;
import wrappers.PageBase;
import wrappers.TestBase;

public class LoadInfoPage extends PageBase implements WebLocators {

	PropertyManager propertyManager = new PropertyManager();
	TestBase base = new TestBase();

	public LoadInfoPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = LOADINFO_TAB)
	private WebElement loadInfoTab;

	public WebElement getLoadInfoTab() {
		return loadInfoTab;
	}

	@FindBy(xpath = CHASSISPICKUP_DD)
	private WebElement chassisPickup_DD;

	@FindBy(xpath = CHASSISTERMINATION_DD)
	private WebElement chassisTermination_DD;
	
	@FindBy(xpath = UPDATED_SUCCESSMSG)
	private WebElement updatedSuccessMsg;
	
	public WebElement getUpdatedSuccessMsg() {
		return updatedSuccessMsg;
	}

	public WebElement getChassispickup_DD() {
		return chassisPickup_DD;
	}

	public WebElement getChassistermination_DD() {
		return chassisTermination_DD;
	}

	public void selectChassisPickUpLicationFrom_DD(String pickupAddress) {

		base.waitForElementVisible(10, getChassispickup_DD());
		base.waitForElementToBeClickable(10, getChassispickup_DD());
		getChassispickup_DD().click();

		List<WebElement> pickupAdd = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']//div"));

		for (WebElement ele : pickupAdd) {

			if (ele.getText().equalsIgnoreCase(pickupAddress)) {
				System.out.println(ele.getText());
				ele.click();
				break;
			}
		}
	}
	
	public void selectChassisTerminationLicationFrom_DD(String terminationAddress) {

		base.waitForElementVisible(10, getChassistermination_DD());
		base.waitForElementToBeClickable(10, getChassistermination_DD());
		getChassistermination_DD().click();

		List<WebElement> terminationAdd = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']//div"));

		for (WebElement ele : terminationAdd) {

			if (ele.getText().equalsIgnoreCase(terminationAddress)) {
				System.out.println(ele.getText());
				ele.click();
				break;
			}
		}
	}
	
	public void verifyUpdateSuccessMessage(String text) {
		
		base.waitForElementVisible(10, getUpdatedSuccessMsg());
		assertEquals(getUpdatedSuccessMsg().getText().trim(), text);
	}
}
