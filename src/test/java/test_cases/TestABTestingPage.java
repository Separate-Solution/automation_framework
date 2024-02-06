package test_cases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ABTesting;
import page_objects.HomePage;

public class TestABTestingPage extends BaseTest {
    private HomePage homePage = new HomePage(driver);
    private ABTesting abTesting = new ABTesting(driver);

    @Test
    public void testUserIsOnABTestingPage() {
        abTesting = abTesting.redirectToABTestingPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/abtest", "user is not on ab testing page");
        homePage = homePage.redirectToHomePage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/", "user is not on home page");
    }
}
