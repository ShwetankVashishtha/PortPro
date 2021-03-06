package locators;

public interface WebLocators {

	String USERNAME = "//input[@name='email' and @placeholder='Email*']";
	String PASSWORD = "//input[@placeholder='Password*']";
	String LOGIN = "//button[@type='submit']";
	String DASHBOARD_LOGO = "//img[@class='navbar-brand__logo-big' and @src='https://axle-logistics.s3.amazonaws.com/carrier/11.jpeg']";
	String DISPATCHER_LEFT_MENU = "//a[contains(@class,'sidebar-link') and @href='/tms/Dispatcher']";//"//a[@class='sidebar-link active' and @href='/tms/Dispatcher']";
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
	String SELECT_DRIVER_DD = "//div[@class='css-gdmhik-control']//div[text()='Select Driver']";
	String SELECT_DATE = "//div[contains(@class, 'rdt w-auto')]//input";
	String SELECT_PULLCONTAINER_DD = "//div[@class='form-group mb-0 col' and descendant::*[text()='From']]//div[@class='css-gdmhik-control']";
	String SELECT_DELIVERLOAD_DD = "//*[@class='d-flex align-items-center mb-10' and descendant::*[text()='DELIVERLOAD']]//following-sibling::div/div[descendant::*[text()='To']]//div[@class='css-gdmhik-control']";
	String SELECT_RETURNCONTAINER_DD = "//*[@class='d-flex align-items-center mb-10' and descendant::*[text()='RETURNCONTAINER']]//following-sibling::div/div[descendant::*[text()='To']]//div[@class='css-gdmhik-control']";
	String SAVE_CHANGES = "//*[text()='Save Changes']";
	String SAVE_CHANGES_ALERT = "//*[text()='Alert']";
	String SAVE_CHANGES_YES = "//*[text()='Yes']";
	String COMPLETE_LOAD = "//button[@class='btn btn-outline-error-100 btn-block']";
	String LOAD_NUMBERS = "//span[@class='mb-0 pointer text-primary']";
	String ALL_LOAD_TITLE = "//h4[@id='displayDate']";
	String LOADINFO_TAB = "//a[@class='nav-link active']//div[text()='Load Info']";
	String CHASSISPICKUP_DD = "//label[text()='Chassis Pickup']/..//div[@class='css-gdmhik-control']";
	String CHASSISTERMINATION_DD = "//label[text()='Chassis Termination']/..//div[@class='css-gdmhik-control']";
	String UPDATED_SUCCESSMSG = "//*[contains(text(),'Updated!')]";
	String UPLOAD_DOCUMENTS = "//button[contains(text(),'Upload Document')]";
	String UPLOAD_DOCUMENT_AREA = "//div[@class='border-0 w-100']/input";
	String BILL_TYPE_DD = "//div[@class='css-bg1rzq-control']/div[@class='css-1hwfws3']";
	
	//===============BILLING TAB================
	String BILLING_TAB = "//div[text()='Billing']";
	String MAINCUSTOMER = "//a[text()='Main Customer']";
	String SUBCUSTOMER = "//a[text()='Sub Customer']";
	String ADDCHARGE = "//a[text()='Add Charge']";
	String SELECTCHARGE_DD = "(//div[text()='Select...']//ancestor::div[@class='css-1pcexqc-container'])[1]";
	String ENTERPRICE_BILLING = "//input[@name='finalAmount' and @value='0']";
	String UPDATEBILLINGSUCCESSMSG = "//*[contains(text(),'Your pricing has been updated!')]";
	String ADDSUBBILL = "//button[@class='btn btn-primary']";
	String SELECTSUBCUSTOMER_DD = "//div[text()='Select Sub Customer...']//ancestor::div[@class='css-gdmhik-control']";
	String UPDATEBILLINGSUCCESSMSG_SUBCUSTOMER = "//*[contains(text(),'Updated Successfully')]";
	String DELETEPRICIMSG = "//*[contains(text(), 'Your pricing has been deleted!')]";
	String APPOVED_CHECKBOX = "//input[@id='chkApproved']";
	String APPROVED_INVOICE_CHECKBOX = "//input[@id='chkApprovedBilling']";
	String UNAPPROVED_CHECKBOX = "//input[@id='chkUnapproved']";
	String REBILL_CHECKBOX = "//input[@id='chkRebill']";
	String CANELBTN_SENDMAIL = "//button[@class='btn btn-close']";
	//=============PAYMENT TAB==================
	String PAYMENTTAB = "//div[text()='Payment']";
	String ADDPAYMENT_BTN = "//button[@class='ml-auto btn btn-primary' and text()='Add Payment']";
	String ENTERAMOUNT_ADDPAYMENTPOPUP = "//label[text()='Amount']//following-sibling::input";
	String PAYMENTDATE_TXTBOX = "//div[contains(@class,'rdt')]/input";
	String ADDPAYMENTBTN_POPUP = "//button[@class='btn btn-primary' and text()='Add Payment']";
	String SUCCESSMSG_ADDPAYMENT = "//*[contains(text()='You have added a payment')]";
	
	//==========CUSTOMER PAGE====================]
	String CUSTOMER_LEFT_MENU_ICON = "(//div[contains(@class,'sidebar-item')])[8]/div[1]"; 
	String CUSTOMER_LEFT_MENU = "//span[text()='Customers']";
	String CUSTOMER_PROFILE = "//a[text()='Customer Profile']";
	String CUSTOMERPROFILE_TAB = "//li[@id='tabCustomer_Profile']";
	String ADDNEWCUSTOMER_BUTTON = "//*[@class='btn btn-success']";
	String ADDNEWCUSTOMER_POPUPBTN = "(//*[@class='btn btn-success'])[2]";
	String CUSTOMER_CHECKBOX = "//input[@id='caller']";
	String COMPANYNAME_TEXTBOX = "//input[@name='company_name']";
	String ADDRESS_TEXTBOX = "//input[@name='address1']";
	String CITY_TEXTBOX = "//input[@name='city']";
	String STATE_TEXTBOX = "//input[@name='state']";
	String ZIPCODE_TEXTBOX = "//input[@name='zip_code']";
	String COUNTRY_TEXTBOX = "//input[@name='country']";
	String EMAIL_TEXTBOX = "//input[@name='email']";
	String PASSWORD_TEXTBOX = "//input[@name='password']";
	String ADDNEWCUSTOMER_TITlE = "//h4[@class='modal-title']";
	String CUSTOMERADDEDMESSAGE = "//*[contains(text(),'Successfully added')]";
	String RECEIVEREMAIL = "//input[@name='receiverEmail']";
	String CUSTOMERFILTERBUTTON = "//h6[text()='Customers']/parent::div";
	String SUCCESFULLYUPDATED_MSG = "//*[contains(text(),'Successfully updated')]";
	String LOAD_NUMBER = "//h5[@class='mb-0 mr-2']";
	String SEARCH_CUSTOMER = "//input[@id='customerSearchInput']";
	String DELETECUSTOMER_BTN = "(//*[@class='btn btn-none text-muted'])[2]";
	String DELETECSOMER_POPUPBTN = "//button[text()='Yes']";
	String CUSTOMERS_COUNT = "//h6[text()='Customers']//preceding-sibling::div";
	String BACKBUTTON = "//div[@class='d-flex flex-row align-items-center']/button";
	
	//===============DRIVER PAGE===========================
	String DRIVER_LEFT_ICON = "(//div[contains(@class,'sidebar-item')])[6]/div[1]";
	String DIVER_LEFT_MENU = "//span[text()='Drivers']";
	String DRIVER_PROFILE = "//a[text()='Driver Profiles']";
	String FIRSTNAME = "(//input[@name='name'])[2]";
	String LASTNAME = "(//input[@name='lastName'])[2]";
	String MOBILE = "(//input[@name='mobile'])[2]";
	String EMAIL_ADDDRIVER = "(//input[@name='email'])[2]";
	String PASSWORD_ADDDRIVER = "(//input[@name='password'])[2]";
	String LICENSENUMBER = "(//input[@name='licenceNumber'])[2]";
	String LICENSESTATE = "(//label[contains(text(),'License State')]/..//following-sibling::div[1]//div[@class='css-1pcexqc-container'])[2]";
	String USERNAME_DD = "(//input[@name='username'])[2]";
	String TIMEZONE_DD = "(//label[contains(text(),'Time Zone')]/..//following-sibling::div[1]//div[@class='css-gdmhik-control'])[2]";
	String TERMINATION_DATE = "(//label[text()='Termination Date']/..//div[contains(@class,'rdt')]/input)[2]";
	String EDIT_DRIVER = "//table[@class='table table-card']//td[1]/button";
	String ONHOLD_STATUS = "//h3[text()='ON HOLD']";
	String ONHOLD_BUTTON = "//input[@name='accountHold']";
	String DRIVERONHOLD_LABEL = "//label[text()='Driver On Hold']";
	String DRIVERTYPE_DROPDOWN = "//*[@class='css-gdmhik-control']";
	
	//===============APPLY PAYMENT=========================
	String ACCOUNT_RECEIVABLE_LEFT_ICON = "(//div[contains(@class,'sidebar-item')])[4]/div[1]";
	String ACCOUNT_RECEIVABLE_LEFT_MENU = "//span[text()='Accounts Receivable']";
	String APPLYPAYMENTS = "//a[text()='Apply Payments']";
	String APPLYPAYMENT_TAB = "//li[@id='tabApply_Payments']";
	String SELECTCUSTOMER_DD = "//div[text()='Select Customer']/parent::div";
	String APPLYPAYMENT_BUTTON = "//button[text()='Apply Payment']";
	String DATANOTFOUND = "//*[contains(text(),'Data not found')]";
}
