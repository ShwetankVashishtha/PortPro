package wrappers;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.*;
import utilities.PropertyManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * @author shwetankvashishtha
 */
public class TestBase extends WebDriverTestBase {

    PropertyManager propertyManager = new PropertyManager();

    @Override
    public WebDriver getdriver() {
        return driver;
    }

    @Override
    public void setupBrowser(String OperatingSystem, String browser, String URL) {
        if (OperatingSystem.equalsIgnoreCase("mac")) {
            if (browser.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", propertyManager.getResourceBundle.getProperty("IE_DRIVER_PATH_MAC"));
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("ff")) {
                System.setProperty("webdriver.gecko.driver",
                        propertyManager.getResourceBundle.getProperty("GECKO_DRIVER_PATH_MAC"));
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        propertyManager.getResourceBundle.getProperty("CHROME_DRIVER_PATH_MAC"));
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("headless") || browser.equalsIgnoreCase("phantomjs")) {
                System.setProperty("phantomjs.binary.path",
                        propertyManager.getResourceBundle.getProperty("PHANTOMJS_DRIVER_PATH_MAC"));
                driver = new PhantomJSDriver();
                driver.manage().window().maximize();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("safari")) {
                driver = new SafariDriver();
                driver.manage().window().maximize();
                openURL(URL);
            }
        } else if (OperatingSystem.equalsIgnoreCase("win") || OperatingSystem.equalsIgnoreCase("window")) {
            if (browser.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", propertyManager.getResourceBundle.getProperty("IE_DRIVER_PATH_WIN"));
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("ff")) {
                System.setProperty("webdriver.gecko.driver",
                        propertyManager.getResourceBundle.getProperty("GECKO_DRIVER_PATH_WIN"));
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        propertyManager.getResourceBundle.getProperty("CHROME_DRIVER_PATH_WIN"));
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                openURL(URL);
            } else if (browser.equalsIgnoreCase("headless") || browser.equalsIgnoreCase("phantomjs")) {
                System.setProperty("phantomjs.binary.path",
                        propertyManager.getResourceBundle.getProperty("PHANTOMJS_DRIVER_PATH_WIN"));
                driver = new PhantomJSDriver();
                driver.manage().window().maximize();
                openURL(URL);
            }
        }
    }

    @Override
    public void setUpiOS() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app", "iOS");
        desiredCapabilities.setCapability("platformName", propertyManager.getResourceBundle.getProperty("IOS_PLATFORM_NAME"));
        desiredCapabilities.setCapability("platformVersion", propertyManager.getResourceBundle.getProperty("IOS_PLATFORM_VERSION"));
        desiredCapabilities.setCapability("deviceName", propertyManager.getResourceBundle.getProperty("IOS_DEVICE_NAME"));
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
    }

    @Override
    public void setUpAndroid(Boolean skipUnlock, Boolean noReset) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("browserName", propertyManager.getResourceBundle.getProperty("BROWSER_NAME"));
        desiredCapabilities.setCapability("platformName", propertyManager.getResourceBundle.getProperty("ANDROID_PLATFORM_NAME"));
        desiredCapabilities.setCapability("platformVersion", propertyManager.getResourceBundle.getProperty("ANDROID_PLATFORM_VERSION"));
        desiredCapabilities.setCapability("deviceName", propertyManager.getResourceBundle.getProperty("ANDROID_DEVICE_NAME"));
        desiredCapabilities.setCapability("noReset", noReset);
        desiredCapabilities.setCapability("skipUnlock", skipUnlock);
        desiredCapabilities.setCapability("appPackage", propertyManager.getResourceBundle.getProperty("ANDROID_APP_PACKAGE"));
        desiredCapabilities.setCapability("appActivity", propertyManager.getResourceBundle.getProperty("ANDROID_APP_ACTIVITY"));
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
    }

    @Override
    public void openURL(String AUT_URL) {
        driver.get(AUT_URL);
    }

    @Override
    public void teardownTest() {
        refreshPage();
        shutdownBrowser();
        generateTestReport();
    }

    @Override
    public void shutdownBrowser() {
        clearCache();
        closeBrowser();
    }

    @Override
    public void refreshPage() {
        driver.navigate().refresh();
    }

    @Override
    public void clearCache() {
        driver.manage().deleteAllCookies();
    }

    @Override
    public void closeBrowser() {
        driver.quit();
    }

    @Override
    public void generateTestReport() {
        setupBrowser(propertyManager.getResourceBundle.getProperty("OS"), propertyManager.getResourceBundle.getProperty("BROWSER"),
                propertyManager.getResourceBundle.getProperty("REPORT_LOCATION"));
    }

    @Override
    public void openCurrentBrowserInstance() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
    }

    @Override
    public void openNewBrowserTab() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
    }

    @Override
    public void pause(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void implicitWait(long timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    @Override
    public void fluentWait(long timeout, long polling) {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(polling)).ignoring(NoSuchElementException.class);
    }

    @Override
    public void waitForPageLoad(long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    @Override
    public void waitForElementVisible(long timeout, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
    }

    @Override
    public void waitForElementDisappear(long timeout, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.invisibilityOf(element));
    }

    @Override
    public void waitForElementToBeClickable(long timeout, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));
    }

    @Override
    public void waitForPageExpire(long timeout) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
    }

    @Override
    public void setAsyncScriptTimeout(long timeout) {
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(timeout));
    }

    @Override
    public void waitForTextToBePresentInElement(long timeout, WebElement element, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    @Override
    public void waitForAlertPresent(long timeout, WebElement element) {

    }

    @Override
    public void waitForPageTitle(long timeout, String pageTitle) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.titleIs(pageTitle));
    }

    @Override
    public void frameToBeAvailableAndSwitch(long timeout, String frameID) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(frameID)));
    }

	@Override
	public void attributeToBe(long timeout, WebElement element, String attribute, String value) {
		// TODO Auto-generated method stub
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.attributeContains(element, attribute, value));
	}
}