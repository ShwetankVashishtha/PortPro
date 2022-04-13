package locators;

public interface WebLocators {

    String USERNAME = "//input[@name='email' and @placeholder='Email*']";
    String PASSWORD = "//input[@placeholder='Password*']";
    String LOGIN = "//button[@type='submit']";
    String DASHBOARD_LOGO = "//img[@class='navbar-brand__logo-big' and @src='https://axle-logistics.s3.amazonaws.com/carrier/11.jpeg']";
    String DISPATCHER_LEFT_MENU = "//a[@class='sidebar-link' and @href='/tms/Dispatcher']";
    String ADD_NEW_LOAD_BUTTON = "//button[@class='btn btn-success']";
    String CUSTOMER_DROPDOWN = "//label[text()=' Customer']/following-sibling::div";
    String PORT_DROPDOWN = "//label[text()='Port']/following-sibling::div";
    String CONSIGNEE_DROPDOWN = "//label[text()='Consignee']/following-sibling::div";
    String PROFILE_LINK = "//div[@class='text-center']/div[@class='position-relative d-inline-block']/div[@class='pointer']";
    String SELECT_DRIVER = "//input[@placeholder='Search Driver..']";
    String DRIVER_NAME = "//li[@id='driver-0']";
    String CLOSE_POP_UP = "//button[@class='btn btn-white shadow-none mr-10']";
    String SUCCESS_MSG = "//div[@class='toast toast-success']";
    String LOAD_CREATE_SUCCESS_MSG = "//div[@class='toast-message']";
    String NOTE_CREATE_SUCCESS_MSG = "//div[@class='toast-message']";
    String NEW_ITEM = "//div[@class='css=guqdj4-menu']";
    String CREATE_LOAD_BTN = "//button[text()='Create Load']";
    String NOTES = "//span[@class='position-relative']//*[name()='svg']";
    String DRIVER_NOTES = "//textarea[@placeholder='Notes for driver']";
    String ADD_NOTE_BTN = "//button[@class='btn btn-primary']";
    String BILLING = "//a[@class='nav-link active']//*[name()='svg']";
    String PRICE = "//input[@name='finalAmount']";
    String SUMMARY_TOTAL = "//div[@class='summary']//div[@class='col-6 font-size-medium font-weight-500 text-primary text-right']/span";
}
