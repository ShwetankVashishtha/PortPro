package forms;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.github.javafaker.Faker;

import locators.WebLocators;
import utilities.DateUtils;
import utilities.FunLibrary;
import utilities.PropertyManager;
import wrappers.PageBase;
import wrappers.TestBase;

public class DriversPage extends PageBase implements WebLocators{

	public DriversPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	PropertyManager propertyManager = new PropertyManager();
    TestBase base = new TestBase();
    
    @FindBy(xpath = DRIVER_LEFT_ICON)
    private WebElement driverLeftIcon;
    
    @FindBy(xpath = DIVER_LEFT_MENU )
    private WebElement driverLeftMenu;
    
    @FindBy(xpath = DRIVER_PROFILE)
    private WebElement driverProfile;
    
    @FindBy(xpath = FIRSTNAME)
    private WebElement firstName;
    
    @FindBy(xpath = LASTNAME)
    private WebElement lastName;
    
    @FindBy(xpath = MOBILE)
    private WebElement mobile;
    
    @FindBy(xpath = EMAIL_ADDDRIVER)
    private WebElement email;
    
    @FindBy(xpath = PASSWORD_ADDDRIVER)
    private WebElement password;
    
    @FindBy(xpath = LICENSENUMBER)
    private WebElement licenseNumber;
    
    @FindBy(xpath = LICENSESTATE)
    private WebElement licenseState;
    
    @FindBy(xpath = USERNAME_DD)
    private WebElement userName_DD;
    
    @FindBy(xpath = TIMEZONE_DD)
    private WebElement timeZone_DD;
    
    @FindBy(xpath = TERMINATION_DATE)
    private WebElement terminationDate;
    
    public WebElement getTerminationDate() {
		return terminationDate;
	}

	public WebElement getDriverLeftIcon() {
		return driverLeftIcon;
	}

	public WebElement getDriverLeftMenu() {
		return driverLeftMenu;
	}

	public WebElement getDriverProfile() {
		return driverProfile;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getLicenseNumber() {
		return licenseNumber;
	}

	public WebElement getLicenseState() {
		return licenseState;
	}

	public WebElement getUserName_DD() {
		return userName_DD;
	}

	public WebElement getTimeZone_DD() {
		return timeZone_DD;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public void navigateToDriversProfilePage() {
    	base.waitForElementVisible(10, getDriverLeftIcon());
		Actions action = new Actions(base.getdriver());
		action.moveToElement(getDriverLeftIcon()).build().perform();
		base.waitForElementVisible(10, getDriverLeftMenu());
		base.waitForElementToBeClickable(10, getDriverLeftMenu());
		action.moveToElement(getDriverLeftMenu()).click().build().perform();
		base.waitForElementToBeClickable(10, getDriverProfile());
		action.moveToElement(getDriverProfile()).click().build().perform();
		base.waitForElementVisible(10, getDriverProfile());
    }
	
	public void enterGeneralDetails() {
		Faker faker = new Faker();
		String fname = faker.name().firstName();
		String lname = faker.name().lastName();
		String email = fname+lname+"@test.com";
		String mobileNo = faker.phoneNumber().cellPhone();
		base.waitForElementVisible(20, getFirstName());
		base.waitForElementToBeClickable(10, getFirstName());
		getFirstName().sendKeys(fname);
		getLastName().sendKeys(lname);
		getEmail().sendKeys(email);
		getMobile().sendKeys(mobileNo);
		getPassword().sendKeys("123456789");
	}
	
	public void selectUserName_DD() {
		base.waitForElementVisible(10, getUserName_DD());

		base.waitForElementToBeClickable(10, getUserName_DD());
		getUserName_DD().sendKeys(new Faker().name().username());
//		base.waitForElementToBeClickable(10, getUserName_DD());
//		getUserName_DD().click();
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<WebElement> usernames = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));
//		if(usernames.size()>0) {
//
//			usernames.get(FunLibrary.getRandomNumber(usernames.size()-1)).click();
//		}
//		else {
//
//			Assert.fail("No username is available");
//		}
	}
	
	public void selectTimeZone_DD() {
		base.waitForElementToBeClickable(10, getTimeZone_DD());
		getTimeZone_DD().click();
		
		List<WebElement> timezone = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));
		if(timezone.size()>0) {
			
			timezone.get(FunLibrary.getRandomNumber(timezone.size()-1)).click();
		}
		else {
			
			Assert.fail("No timezone is available");
		}
	}
	
	public void selectLicenseState_DD(){
		base.waitForElementToBeClickable(10, getLicenseState());
		getLicenseState().click();
		
		List<WebElement> state = driver.findElements(By.xpath("//div[@class='css-guqdj4-menu']/div/div"));
		if(state.size()>0) {
			
			state.get(FunLibrary.getRandomNumber(state.size()-1)).click();
		}
		else {
			
			Assert.fail("No timezone is available");
		}
	}
	
	public void inputLicenseNumber() {
		base.waitForElementVisible(10, getLicenseNumber());
		base.waitForElementToBeClickable(10, getLicenseNumber());
		Random rnd = new Random();
		int n = 999999 + rnd.nextInt(111111);
		getLicenseNumber().sendKeys(String.valueOf(n));
	}
	
	public void provideExpirtionDate() {
		base.waitForElementVisible(10, getTerminationDate());
        base.waitForElementToBeClickable(10, getTerminationDate());
        getTerminationDate().click();
        getTerminationDate().clear();
        driver.findElement(By.xpath("(//label[text()='Termination Date']/..//table)[2]//th[@class='rdtNext']")).click();
        driver.findElement(By.xpath("(//label[text()='Termination Date']/..//table)[2]//td[@data-value='15'] ")).click();
		
	}
	
	public void driverCreationMsg(String str) {
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'"+str+"')]"));
		base.waitForElementVisible(15, ele);
		assertEquals(ele.getText().trim(), str);
	}
}
