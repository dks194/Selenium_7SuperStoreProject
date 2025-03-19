package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashboardPage {
	
	GeneralUtilities utilities = new GeneralUtilities();
	WebDriver driver;
	DashboardPage dash;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/home']")
	WebElement homeLink;

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admin;

	@FindBy(xpath = "//div[contains(@class,'col-lg-3')]")
	List<WebElement> allTiles;
	
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'])[2]")
	WebElement manageProduct;
	
	@FindBy(xpath=("//div[@class='col-lg-3 col-6'][3]/child::div/child::a"))
	WebElement categoryProductLink;

	public String getTextOfAdmin() {
		return utilities.getTextOfElement(admin);
	}

	public boolean isAllTilesDisplayed() {
		// List<WebElement> tiles=allTiles;already provided in
		// @findBy(xpath=.......)webelement allTiles;
		for (WebElement tile : allTiles) {
			if (!utilities.isElementDisplayed(tile)) {
				return false;
			}
		}
		return true;
	}

	public int getAllTilesCount() {
		return allTiles.size();
	}
	
	public ListProductsPage clickOnManageProducts() {
		utilities.clickOnAnElement(manageProduct);
		return new ListProductsPage(driver);
	}
	
	public CategoryPage navigateToCategoryPage() {
		categoryProductLink.click();
		//chaining of pages
		return new CategoryPage(driver);
	}

}
