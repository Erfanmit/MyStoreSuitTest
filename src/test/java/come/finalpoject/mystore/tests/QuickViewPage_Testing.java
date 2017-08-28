package come.finalpoject.mystore.tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import come.finalproject.mystore.pages.AddressesPage;
import come.finalproject.mystore.pages.AuthenticationPage;
import come.finalproject.mystore.pages.CreateAnAccountPage;
import come.finalproject.mystore.pages.HomePage;
import come.finalproject.mystore.pages.IframeSwitching;
import come.finalproject.mystore.pages.MyAccountPage;
import come.finalproject.mystore.pages.OrderConfirmationPage;
import come.finalproject.mystore.pages.OrderHistoryDetailPage;
import come.finalproject.mystore.pages.OrderSummaryPage;
import come.finalproject.mystore.pages.PaymentPage;
import come.finalproject.mystore.pages.QuickViewPage;
import come.finalproject.mystore.pages.ShippingPage;
import come.finalproject.mystore.pages.ShoppingCart;
import come.finalproject.mystore.pages.WishListPage;
import jdk.nashorn.internal.runtime.options.LoggingOption.LoggerInfo;


public class QuickViewPage_Testing {
	
	final static Logger logger = Logger.getLogger(QuickViewPage_Testing.class);
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
	WishListPage myWishList;
	QuickViewPage myQuickView;
	IframeSwitching myIframe;
	
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

	@Test (enabled = true) //Test case 5.01
	
	public void verifySize_Medium () throws InterruptedException
	{
		logger.info("Changes testing in github");
		System.out.println("Yooooooooooo");
		
		
		
		
		
		
		logger.info("Test Case 5.01 is starting...");
		myhomepage = new HomePage(driver);
		myhomepage.homepageVerification();
		myhomepage.click_SignInTab();
		myAuthentication = new AuthenticationPage(driver);
		myAuthentication.verifyAuthenticationPage();
		myAuthentication.enteringEmailPassword("oooooo222@gmail.com", "3412333");
		myAuthentication.click_SignInBtn();
		myAccountPage = new MyAccountPage(driver);
		myAccountPage.verify_AccountPage();
		myAccountPage.go_HomePage_AfterLogIn();
		myhomepage.homepageVerification();
		myQuickView = new QuickViewPage(driver);
		myQuickView.click_QuickViewBtn();
		myIframe = new IframeSwitching(driver);
		myIframe.SwitchtoIframe();
		myQuickView.verify_QuickViewPage();
		myQuickView.selectsize_Medium();
		myQuickView.click_AddToCart();
		myIframe.SwitchBackToDefaultFrame();
		myQuickView.click_ProceedToCheckOut();
		myShoppingCart = new ShoppingCart(driver);
		myShoppingCart.verify_CartPage();
		myShoppingCart.verifySize_Medium();
		logger.info("Test Case 5.01 is ending...");
	}
	
	@Test (enabled = false) // Test case 5.02
	
	public void verifySize_Large() throws InterruptedException
	{
		logger.info("Test Case 5.02 is starting...");
		myhomepage = new HomePage(driver);
		myhomepage.homepageVerification();
		myhomepage.click_SignInTab();
		myAuthentication = new AuthenticationPage(driver);
		myAuthentication.verifyAuthenticationPage();
		myAuthentication.enteringEmailPassword("oooooo222@gmail.com", "3412333");
		myAuthentication.click_SignInBtn();
		myAccountPage = new MyAccountPage(driver);
		myAccountPage.verify_AccountPage();
		myAccountPage.go_HomePage_AfterLogIn();
		myhomepage.homepageVerification();
		myQuickView = new QuickViewPage(driver);
		myQuickView.click_QuickViewBtn();
		myIframe = new IframeSwitching(driver);
		myIframe.SwitchtoIframe();
		myQuickView.verify_QuickViewPage();
		myQuickView.selectsize_Large();
		myQuickView.click_AddToCart();
		myIframe.SwitchBackToDefaultFrame();
		myQuickView.click_ProceedToCheckOut();
		myShoppingCart = new ShoppingCart(driver);
		myShoppingCart.verify_CartPage();
		myShoppingCart.verifySize_Large();
		logger.info("Test Case 5.02 is ending...");
	}
	
	@Test (enabled = false)//test case 5.03
	
	public void IncreasingAmount() throws InterruptedException
	{
		logger.info("Test Case 5.02 is starting...");
		myhomepage = new HomePage(driver);
		myhomepage.homepageVerification();
		myhomepage.click_SignInTab();
		myAuthentication = new AuthenticationPage(driver);
		myAuthentication.verifyAuthenticationPage();
		myAuthentication.enteringEmailPassword("oooooo222@gmail.com", "3412333");
		myAuthentication.click_SignInBtn();
		myAccountPage = new MyAccountPage(driver);
		myAccountPage.verify_AccountPage();
		myAccountPage.go_HomePage_AfterLogIn();
		myhomepage.homepageVerification();
		myQuickView = new QuickViewPage(driver);
		myQuickView.click_QuickViewBtn();
		myIframe = new IframeSwitching(driver);
		myIframe.SwitchtoIframe();
		myQuickView.verify_QuickViewPage();
		myQuickView.increasingAmountOfItem();
		myQuickView.click_AddToCart();
		myIframe.SwitchBackToDefaultFrame();
		myQuickView.click_ProceedToCheckOut();
		myShoppingCart = new ShoppingCart(driver);
		myShoppingCart.verify_CartPage();
		myShoppingCart.verify_AmountIncreasedFromQuickViewPAge();
		logger.info("Test Case 5.03 is ending...");
		
	}
	
	
}
