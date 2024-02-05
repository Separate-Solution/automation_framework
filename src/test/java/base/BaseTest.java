package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void startSession() {
        setUp();
        driver.get("https://mvnrepository.com/");
    }

    private WebDriver setUp() {
        driver = new ChromeDriver();
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
