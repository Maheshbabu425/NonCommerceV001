package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver driver;

	public AddCustomerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By linCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By linkCustomers_menuItem = By
			.xpath("//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]");

	By btnAddNew = By.xpath("//a[@href='/Admin/Customer/Create']");

	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");

	By rbMaleGneder = By.id("Gender_Male");
	By rbFemaleGender = By.id("Gender_Female");

	By txtDateofBirth = By.name("DateOfBirth");

	By txtCompany = By.cssSelector("input[name='Company']");

	By cbTaxExempt = By.xpath("//input[@id='IsTaxExempt']");

	By txtNewsLetter = By.xpath(
			"//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[1]/div[1]/div[1]");
	By lstNewsYourStoreName = By.xpath("//li[contains(text(),'Your store name')]");
	By lstNewsTestStore2 = By.xpath("//li[contains(text(),'Test store 2')]");

	By txtCustomerRole = By.xpath(
			"//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]");
	By lstCustomerRoleAdminisrator = By.xpath("//li[contains(text(),'Administrators')]");
	By lstCustomerRoleForumModerators = By.xpath("//li[contains(text(),'Forum Moderators')]");
	By lstCustomerRoleGusts = By.xpath("//li[contains(text(),'Guests')]");
	By lstCustomreRoleRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By lstCustomerRoleVendors = By.xpath("//li[contains(text(),'Vendors')]");

	By txtManageofVendor = By.xpath("//select[@id='VendorId']");

	By cbActive = By.xpath("//input[@id='Active']");

	By txtAdminComment = By.xpath("//textarea[@id='AdminComment']");

	By btnSave = By.xpath("//body/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]");
	By btnSaveandEdit = By.xpath("//body/div[3]/div[1]/form[1]/div[1]/div[1]/button[2]");

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void clickOnCustomersMenu() {
		driver.findElement(linCustomers_menu).click();
	}

	public void clickOnCustomerMenuItem() {
		driver.findElement(linkCustomers_menuItem).click();
	}

	public void clickOnAddNewItem() {
		driver.findElement(btnAddNew).click();
	}

	public void setEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String password) {
		driver.findElement(txtPassword).sendKeys(password);
	}

	public void setFirstName(String firstName) {
		driver.findElement(txtFirstName).sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		driver.findElement(txtLastName).sendKeys(lastName);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			driver.findElement(rbMaleGneder).click();
		} else if (gender.equals("Female")) {
			driver.findElement(rbFemaleGender).click();
		} else {
			driver.findElement(rbMaleGneder).click();
		}
	}

	public void setDoB(String dob) {
		driver.findElement(txtDateofBirth).sendKeys(dob);
	}

	public void setCompanyName(String companyName) {
		driver.findElement(txtCompany).sendKeys(companyName);
	}

	public void setIsTaxExempt() {
		// boolean cb = driver.findElement(cbTaxExempt).isDisplayed();
		// Assert.assertTrue(cb);
		driver.findElement(cbTaxExempt).click();
	}

	public void setNewsLetter(String newsLetter) {
		driver.findElement(txtNewsLetter).click();
		if (newsLetter.equals("Your store name")) {
			driver.findElement(lstNewsYourStoreName).click();
		} else {
			driver.findElement(lstNewsTestStore2).click();
		}
	}

	public void setCustomerRoles(String customerRole) throws InterruptedException {
	/*
		if (!customerRole.equals("Vendors")) {
			driver.findElement(By.xpath(
					"//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[2]"));
		}
		*/
		driver.findElement(By.xpath(
				"//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[2]"));
		driver.findElement(txtCustomerRole).click();
		WebElement listItem;
		Thread.sleep(3000);
		 if (customerRole.equals("Administrators")) {
			listItem = driver.findElement(lstCustomerRoleAdminisrator);
		} else if (customerRole.equals("Forum Moderators")) {
			listItem = driver.findElement(lstCustomerRoleForumModerators);
		} else if (customerRole.equals("Guests")) {
			listItem = driver.findElement(lstCustomerRoleGusts);
		} else if (customerRole.equals("Vendors")) {
			listItem = driver.findElement(lstCustomerRoleVendors);
		} else {
			listItem = driver.findElement(lstCustomerRoleGusts);
		}
		listItem.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", listItem);
	}

	public void setManagerofVendor(String value) {
		Select dropdown = new Select(driver.findElement(txtManageofVendor));
		dropdown.selectByVisibleText(value);
	}

	public void setActive() {
		if (driver.findElement(cbActive).isSelected()) {
			Assert.assertTrue(true);
		} else {
			driver.findElement(cbActive).click();
		}
	}

	public void setAdminComment(String adminComment) {
		driver.findElement(txtAdminComment).sendKeys(adminComment);
	}

	public void clickSave() {
		driver.findElement(btnSave).click();
	}
}
