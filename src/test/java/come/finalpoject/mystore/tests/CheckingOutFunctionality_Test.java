package come.finalpoject.mystore.tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import come.finalproject.mystore.pages.AddingNewAddressPage;
import come.finalproject.mystore.pages.AddressesPage;
import come.finalproject.mystore.pages.AuthenticationPage;
import come.finalproject.mystore.pages.CreateAnAccountPage;
import come.finalproject.mystore.pages.HomePage;
import come.finalproject.mystore.pages.MyAccountPage;
import come.finalproject.mystore.pages.OrderConfirmationPage;
import come.finalproject.mystore.pages.OrderHistoryDetailPage;
import come.finalproject.mystore.pages.OrderSummaryPage;
import come.finalproject.mystore.pages.PaymentPage;
import come.finalproject.mystore.pages.QuickViewPage;
import come.finalproject.mystore.pages.ShippingPage;
import come.finalproject.mystore.pages.ShoppingCart;
import come.finalproject.mystore.pages.WishListPage;



public class CheckingOutFunctionality_Test {
	
	final static Logger logger = Logger.getLogger(CheckingOutFunctionality_Test.class);
	public static WebDriver driver;
	private String homepageURL = "http://automationpractice.com/index.php";

	HomePage myhomepage;
	CreateAnAccountPage myNewAccountPage;
	AuthenticationPage myAuthentication;
	MyAccountPage myAccountPage;
	OrderHistoryDetailPage myOrderHistoryPage;
	ShoppingCart myShoppingCart;
	AddressesPage myAddresses;
	ShippingPage myShipping;
	PaymentPage myPayment;
	OrderSummaryPage mySummary;
	OrderConfirmationPage myConfirmation;
	AddingNewAddressPage myNewAddress;
	
	@BeforeMethod
	public void beforeTest() {
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get(homepageURL);

		} catch (Exception e) {

			assertTrue(false);
		}
	}
	
	@AfterMethod
	public void afterEachTest() throws InterruptedException {
		Thread.sleep(5 * 1000);
		driver.close();
		driver.quit();
	}
	
	@Test (enabled = false) //Test Case 3.01
	
	public void Verify_AddNewAddressBar () throws InterruptedException
	{
		logger.info("Test Case 3.01 is starting...");
		myhomepage = new HomePage(driver);
		myhomepage.homepageVerification();
		myhomepage.click_addToCart1();
		myhomepage.click_continueShopping_Btn();
		myhomepage.click_ProceedtoCheckOut();
		myShoppingCart = new ShoppingCart(driver);
		myShoppingCart.verify_CartPage();
		myShoppingCart.verify_Item1();
		myShoppingCart.click_ProceedToCheckOut();
		myAuthentication = new AuthenticationPage(driver);
		myAuthentication.verifyAuthenticationPage();
		myAuthentication.enteringEmailPassword("my123321@gmail.com", "123321");
		myAuthentication.click_SignInBtn();
		myAddresses = new AddressesPage(driver);
		myAddresses.verifyAddressPage();
		myAddresses.unCheck_UsingSameAddress();
		myAddresses.verifyNewAddressBar();
		logger.info("Test Case 3.01 is ending...");
	}
	
	@Test (enabled = false) //Test Case 3.02
	
	public void EnteringNewAddress() throws InterruptedException
	{
		logger.info("Test Case 3.02 is starting...");
		myhomepage = new HomePage(driver);
		myhomepage.homepageVerification();
		myhomepage.click_addToCart1();
		myhomepage.click_continueShopping_Btn();
		myhomepage.click_ProceedtoCheckOut();
		myShoppingCart = new ShoppingCart(driver);
		myShoppingCart.verify_CartPage();
		myShoppingCart.verify_Item1();
		myShoppingCart.click_ProceedToCheckOut();
		myAuthentication = new AuthenticationPage(driver);
		myAuthentication.verifyAuthenticationPage();
		myAuthentication.enteringEmailPassword("my123321@gmail.com", "123321");
		myAuthentication.click_SignInBtn();
		myAddresses = new AddressesPage(driver);
		myAddresses.verifyAddressPage();
		myAddresses.unCheck_UsingSameAddress();
		myAddresses.verifyNewAddressBar();
		myAddresses.click_AddingNewAddress();
		myNewAddress = new AddingNewAddressPage(driver);
		myNewAddress.verifyNewAddressPage();
		myNewAddress.entering_Address();
		myNewAddress.entering_City();
		myNewAddress.selecting_State();
		myNewAddress.entering_ZipCode();
		myNewAddress.entering_CellNumber();
		myNewAddress.entering_HomeNumber();
		myNewAddress.add_addressTitle();
		myNewAddress.clicking_SaveBtn();
		myAddresses.verify_NewAddressAdded();
		logger.info("Test Case 3.02 is ending...");
		
	}

	
	@ Test(enabled = false)//Test Case 3.03
	
	public void updating_DerliveryAddress() throws InterruptedException
	{
		logger.info("Test Case 3.03 is starting...");
		myhomepage = new HomePage(driver);
		myhomepage.homepageVerification();
		myhomepage.click_addToCart1();
		myhomepage.click_continueShopping_Btn();
		myhomepage.click_ProceedtoCheckOut();
		myShoppingCart = new ShoppingCart(driver);
		myShoppingCart.verify_CartPage();
		myShoppingCart.verify_Item1();
		myShoppingCart.click_ProceedToCheckOut();
		myAuthentication = new AuthenticationPage(driver);
		myAuthentication.verifyAuthenticationPage();
		myAuthentication.enteringEmailPassword("my123321@gmail.com", "123321");
		myAuthentication.click_SignInBtn();
		myAddresses = new AddressesPage(driver);
		myAddresses.verifyAddressPage();
		myAddresses.click_UpdateAddressBtn();
		myNewAddress = new AddingNewAddressPage(driver);
		myNewAddress.verifyNewAddressPage();
		myNewAddress.changeAddress_UpdatingAddress();
		myNewAddress.clicking_SaveBtn();
		myAddresses.verifyAddressPage();
		logger.info("Test Case 3.03 is ending...");
	}
	

	@Test (enabled = false)// Test Case 3.04
	
	public void verify_TermsCondition() throws InterruptedException
	{
		logger.info("Test Case 3.04 is starting...");
		myhomepage = new HomePage(driver);
		myhomepage.homepageVerification();
		myhomepage.click_addToCart1();
		myhomepage.click_continueShopping_Btn();
		myhomepage.click_ProceedtoCheckOut();
		myShoppingCart = new ShoppingCart(driver);
		myShoppingCart.verify_CartPage();
		myShoppingCart.verify_Item1();
		myShoppingCart.click_ProceedToCheckOut();
		myAuthentication = new AuthenticationPage(driver);
		myAuthentication.verifyAuthenticationPage();
		myAuthentication.enteringEmailPassword("my123321@gmail.com", "123321");
		myAuthentication.click_SignInBtn();
		myAddresses = new AddressesPage(driver);
		myAddresses.verifyAddressPage();
		myAddresses.click_ProceedCheckOut();
		myShipping = new ShippingPage(driver);
		myShipping.verify_ShippingPage();
		myShipping.click_ShippingProceedCheckOut();
		myShipping.verify_ErrorBox();
		myShipping.close_ErrorBox();
		myShipping.verify_ShippingPage();
		logger.info("Test Case 3.04 is ending...");
		
	}
	

	@Test (enabled = false) //Test Case 3.05
	
	public void verify_TotalPrice() throws InterruptedException
	{
		logger.info("Test Case 3.02 is starting...");
		myhomepage = new HomePage(driver);
		myhomepage.homepageVerification();
		myhomepage.click_addToCart1();
		myhomepage.click_continueShopping_Btn();
		myhomepage.click_ProceedtoCheckOut();
		myShoppingCart = new ShoppingCart(driver);
		myShoppingCart.verify_CartPage();
		myShoppingCart.verify_Item1();
		myShoppingCart.click_ProceedToCheckOut();
		myAuthentication = new AuthenticationPage(driver);
		myAuthentication.verifyAuthenticationPage();
		myAuthentication.enteringEmailPassword("my123321@gmail.com", "123321");
		myAuthentication.click_SignInBtn();
		myAddresses = new AddressesPage(driver);
		myAddresses.verifyAddressPage();
		myAddresses.click_ProceedCheckOut();
		myShipping = new ShippingPage(driver);
		myShipping.verify_ShippingPage();
		myShipping.check_TermsConditions();
		myShipping.click_ShippingProceedCheckOut();
		myPayment = new PaymentPage(driver);
		myPayment.verifyPaymentPage();
		myPayment.verify_PriceConsistant();
		logger.info("Test Case 3.05 is ending...");
		
	}

	@Test(enabled = true) //Test Case 3.06
	public void confirmingFinalOrder() throws InterruptedException
	{
		logger.info("Test Case 3.06 is starting...");
		myhomepage = new HomePage(driver);
		myhomepage.homepageVerification();
		myhomepage.click_addToCart1();
		myhomepage.click_continueShopping_Btn();
		myhomepage.click_ProceedtoCheckOut();
		myShoppingCart = new ShoppingCart(driver);
		myShoppingCart.verify_CartPage();
		myShoppingCart.verify_Item1();
		myShoppingCart.click_ProceedToCheckOut();
		myAuthentication = new AuthenticationPage(driver);
		myAuthentication.verifyAuthenticationPage();
		myAuthentication.enteringEmailPassword("my123321@gmail.com", "123321");
		myAuthentication.click_SignInBtn();
		myAddresses = new AddressesPage(driver);
		myAddresses.verifyAddressPage();
		myAddresses.click_ProceedCheckOut();
		myShipping = new ShippingPage(driver);
		myShipping.verify_ShippingPage();
		myShipping.check_TermsConditions();
		myShipping.click_ShippingProceedCheckOut();
		myPayment = new PaymentPage(driver);
		myPayment.verifyPaymentPage();
		myPayment.verify_PriceConsistant();
		mySummary = new OrderSummaryPage(driver);
		mySummary.verify_OrderSummeryPage();
		mySummary.click_ConfirmMyOrder();
		myConfirmation = new OrderConfirmationPage(driver);
		myConfirmation.verify_ConfirmationPage();
		logger.info("Test Case 3.06 is ending...");
		
	}

	
	
}