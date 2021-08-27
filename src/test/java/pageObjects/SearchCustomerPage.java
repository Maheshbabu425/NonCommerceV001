package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {

	public WebDriver driver;
	WaitHelper waithelper;

	public SearchCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);

	}

	@FindBy(how = How.ID, using = "SearchEmail")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(how = How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement txtSearchFirstName;

	@FindBy(how = How.ID, using = "SearchLastName")
	@CacheLookup
	WebElement txtSearchLastName;

	@FindBy(how = How.ID, using = "SearchMonthOfBirth")
	@CacheLookup
	WebElement drpdobMonth;

	@FindBy(how = How.ID, using = "SearchDayOfBirth")
	@CacheLookup
	WebElement drpdobDate;

	@FindBy(how = How.ID, using = "SearchCompany")
	@CacheLookup
	WebElement txtSearchCompany;

	@FindBy(how = How.ID, using = "SearchIpAddress")
	@CacheLookup
	WebElement txtSearchIpAddress;

	@FindBy(how = How.XPATH, using = "//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement txtCustomerRoles;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement listItemAdministrators;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Forum Moderators')]")
	@CacheLookup
	WebElement listItemForumModerator;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement listItemGuests;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Registered')]")
	@CacheLookup
	WebElement listItemRegistered;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement listItemVendors;

	@FindBy(how = How.ID, using = "search-customers")
	@CacheLookup
	WebElement btnSearch;

	@FindBy(how = How.XPATH, using = "//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResult;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
	WebElement table;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;

	public void setEmail(String email) {
		waithelper.waitForElement(txtEmail, 30);
		// txtEmail.click();
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setFirstName(String firstName) {
		waithelper.waitForElement(txtSearchFirstName, 30);
		txtSearchFirstName.clear();
		txtSearchFirstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		waithelper.waitForElement(txtSearchLastName, 30);
		txtSearchLastName.clear();
		txtSearchLastName.sendKeys(lastName);
	}

	public void clickSearch() {
		btnSearch.click();
		waithelper.waitForElement(btnSearch, 30);
	}

	public int getNoOfRows() {
		int rowsNo = tableRows.size();
		return rowsNo;
	}

	public int getNoOfColumns() {
		return (tableColumns.size());
	}

	public boolean searchCustomerByEmail(String email) {
		boolean flag = false;
		for (int i = 1; i <= getNoOfRows(); i++) {
			String emailId = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println(emailId);
			if (emailId.equals(email)) {
				flag = true;
			}
		}
		return flag;

	}

}
