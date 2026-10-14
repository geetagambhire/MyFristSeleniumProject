package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	
	
	
/*	@FindBy(xpath = "//img[@alt='CarWale']")
    private WebElement carWaleLogo;

    @FindBy(xpath = "//div[text()='NEW CARS']")
    private WebElement newCarsTab;

    @FindBy(xpath = "//div[contains(text(),'Upcoming Cars')]")
    private WebElement upcomingCarsLink;

    @FindBy(xpath = "//div[text()='Honda Elevate']/following-sibling::div//a[text()='Know More']")
    private WebElement hondaElevateKnowMoreBtn;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchBar;*/
	
	
	@FindBy(xpath ="")
	WebElement carWaleLogo;
	
	@FindBy(xpath="")
	WebElement newCars;
	
	@FindBy(xpath = "//div[text()='NEW CARS']")
    private WebElement newCarsTab;
	
	@FindBy(xpath="")
	WebElement usedCars;
	
	@FindBy(xpath="")
	WebElement upcomingCarsLink;
	
	
	@FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchBar;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public boolean isLogoDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(carWaleLogo));
        return carWaleLogo.isDisplayed();
    }
    
    



	public void hoverOrClickNewCarsMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(newCarsTab));
        Actions actions = new Actions(driver);
        actions.moveToElement(newCarsTab).perform();
    }
	
	public void clickUpcomingCars() {
        hoverOrClickNewCarsMenu();
        wait.until(ExpectedConditions.elementToBeClickable(upcomingCarsLink));
        upcomingCarsLink.click();
    }



}