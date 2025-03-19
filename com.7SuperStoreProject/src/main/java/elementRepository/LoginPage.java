package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {

	WebDriver driver;

	GeneralUtilities utilities = new GeneralUtilities();

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locating and declaring elements
	@FindBy(name = "username")
	WebElement userNameTextBox;

	@FindBy(name = "password")
	WebElement passwordTextBox;

	@FindBy(className = "btn")
	WebElement signInButton;

	@FindBy(id = "remember")
	WebElement rememberMeCheckBox;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/login']")
	WebElement headingOfLogin;

	@FindBy(className = "alert-dismissible")
	WebElement alert;


	public String getTitleOfLoginPage() {
		return driver.getTitle();
	}

	public String getTextOf7martHeading() {
		return utilities.getTextOfElement(headingOfLogin);
	}

	public DashboardPage login(String userName, String password) {
		userNameTextBox.sendKeys(userName);
		passwordTextBox.sendKeys(password);
		signInButton.click();
		return new DashboardPage(driver); // returning to the page and is called chaining of pages
	}

	public String getTextOferrorMessage() {
		return utilities.getTextOfElement(alert);
	}

	public boolean isRememberMeCheckboxSelected() {
		return utilities.isElementSelected(rememberMeCheckBox);
	}

}
