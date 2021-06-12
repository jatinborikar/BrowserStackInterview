package interview.browserStack;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipKart {
	WebDriver driver;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	WebElement loginClose;
	
	@FindBy(xpath = "//*[@title='Search for products, brands and more']")
	WebElement searchTextBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;
	
	@FindBy(xpath = "//a[@title='Mobiles']")
	WebElement mobilesCategory;
	
	@FindBy(xpath = "//div[text()='SAMSUNG']")
	WebElement samsungBrand;
	
	@FindBy(xpath = "//label[@class='_2iDkf8 shbqsL']/input[@type='checkbox']")
	WebElement flipkartAssured;
	
	@FindBy(xpath = "//div[text()='Price -- High to Low']")
	WebElement hightolow;
	
	@FindBy(xpath = "//div[@class='_4rR01T']")
	List<WebElement> productName;
	
	@FindBy(xpath = "//div[@class='_30jeq3 _1_WHN1']")
	List<WebElement> productPrice;
	
	@FindBy(xpath = "//a[@class='_1fQZEK']")
	List<WebElement> productLink;
	

	public FlipKart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementToBeVisible(WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	public void waitForElementToBeClickable(WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}
	
	public void searchPhone(String phoneName) throws InterruptedException {
		
		waitForElementToBeVisible(loginClose);
		loginClose.click();
		searchTextBox.sendKeys(phoneName);
		searchButton.click();
		
		waitForElementToBeVisible(mobilesCategory);
		mobilesCategory.click();
	
		waitForElementToBeVisible(samsungBrand);
		samsungBrand.click();
		
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", flipkartAssured);
		
		waitForElementToBeVisible(hightolow);
		hightolow.click();
		
		Thread.sleep(2000);
		List<WebElement> productNameText = productName;
		List<WebElement> productPriceText = productPrice;
		List<WebElement> productLinkText = productLink;
		for(int i=0;i<productName.size()-1;i++) {
			System.out.println("Product Name: " + productNameText.get(i).getText());
			System.out.println("Display Price: " + productPriceText.get(i).getText().substring(1));
			System.out.println("Product Link: " + productLinkText.get(i).getAttribute("href"));
			System.out.println("============================================================================================================================");
		}
	}
	
	
}