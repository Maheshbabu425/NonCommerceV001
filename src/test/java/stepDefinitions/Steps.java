package stepDefinitions;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

@RunWith(Cucumber.class)
public class Steps extends BaseClass {

	@Given("user launches Chrome browser")
	public void user_launches_chrome_browser() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException {
		lp.setUserName(email);
		lp.setPassword(password);
		Thread.sleep(3000);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		lp.clickLogin();
		System.out.println("Log in Successfully");
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {

		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000);
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		lp.clickLogout();
		System.out.println("Log out Successfully");
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		acp = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", acp.getPageTitle());
	}

	@When("User click on customer Menu")
	public void user_click_on_customer_menu() throws InterruptedException {
		Thread.sleep(3000);
		acp.clickOnCustomersMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(5000);
		acp.clickOnCustomerMenuItem();

	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		acp.clickOnAddNewItem();
		Thread.sleep(3000);

	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", acp.getPageTitle());

	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = "mahesh" + randomstring() + "@gmail.com"; // Random email method calling here

		acp.setEmail(email);
		Thread.sleep(3000);
		acp.setPassword("test123");
		Thread.sleep(3000);
		acp.setFirstName("Mahesh");
		Thread.sleep(3000);
		acp.setLastName("Babu");
		Thread.sleep(3000);
		acp.setGender("Male");
		Thread.sleep(3000);
		acp.setDoB("09/24/1993");
		Thread.sleep(3000);
		acp.setCompanyName("EMC2 Contractors");
		Thread.sleep(3000);
		acp.setIsTaxExempt();
		Thread.sleep(3000);
		acp.setNewsLetter("Your store name");
		Thread.sleep(3000);
		acp.setCustomerRoles("Guests");
		Thread.sleep(3000);
		acp.setManagerofVendor("Vendor 2");
		Thread.sleep(3000);
		acp.setActive();
		Thread.sleep(3000);
		acp.setAdminComment("This is for Testing...");
		Thread.sleep(3000);

	}

	@When("Click on Save button")
	public void click_on_save_button() throws InterruptedException {
		acp.clickSave();
		Thread.sleep(3000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));
	}

	@And("Enter customer Email")
	public void enter_customer_Email() {
		scp = new SearchCustomerPage(driver);
		scp.setEmail("maheshkalluri686@gmail.com");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		scp.clickSearch();
		Thread.sleep(3000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_Email_in_the_Search_table() {
		boolean status = scp.searchCustomerByEmail("maheshkalluri686@gmail.com");
		Assert.assertEquals(true, status);
	}

}
