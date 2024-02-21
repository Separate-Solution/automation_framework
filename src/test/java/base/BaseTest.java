package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        startDriverSession();
        driver.get("https://the-internet.herokuapp.com/");
    }

    private void startDriverSession() {
        String browser = System.getProperty("browser");
        switch (browser.toLowerCase()) {
            case "chrome":
                launchChromeDriver();
                break;
            case "firefox":
                launchFirefoxDriver();
                break;
            case "safari":
                launchSafariDriver();
                break;
            case "edge":
                launchEdgeDriver();
                break;
            default:
                System.out.println("unrecognized browser");
        }
    }

    private WebDriver launchChromeDriver() {
        driver = new ChromeDriver();
        return driver;
    }

    private WebDriver launchFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");
        driver = new FirefoxDriver();
        return driver;
    }

    private WebDriver launchSafariDriver() {
        driver = new SafariDriver();
        return driver;
    }

    private WebDriver launchEdgeDriver() {
        driver = new EdgeDriver();
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
