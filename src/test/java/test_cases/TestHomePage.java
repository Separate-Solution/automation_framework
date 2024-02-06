package test_cases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomePage extends BaseTest {
    @Test
    public void testUserIsOnHomePage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/", "user is not on the homepage");
    }
}
