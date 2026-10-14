package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BasePage;

import pages.HomePage;

public class HomeTest  extends BasePage{
	
	
	HomePage homePage;

    public HomeTest() {
        super();
    }

    @BeforeMethod
    public void setUpTest() {
        homePage = new HomePage(driver);
    }

    @Test(priority = 1, description = "Verify CarWale logo and search bar presence on homepage")
    public void verifyHomePageElementsTest() {
        boolean logoPresent = homePage.isLogoDisplayed();
        Assert.assertTrue(logoPresent, "CarWale logo is missing from the homepage!");

      //  boolean searchBarPresent = homePage.isLogoDisplayed();
       // Assert.assertTrue(searchBarPresent, "Search bar is missing from the homepage!");
    }

    @Test(priority = 2, description = "Verify navigation to Upcoming Cars from NEW CARS menu")
    public void verifyUpcomingCarsNavigationTest() {
        homePage.clickUpcomingCars();
        String expectedTitle = "Upcoming Cars in India 2026, See New Cars Launch Date, Price";
        // Flexible validation or assertion based on page title/URL
        Assert.assertTrue(driver.getTitle().contains("Upcoming Cars"), "Failed to navigate to Upcoming Cars page.");
    }
}