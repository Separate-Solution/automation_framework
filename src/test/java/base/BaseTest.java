package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
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
                driver = launchChromeDriver();
                break;
            case "firefox":
                driver = launchFirefoxDriver();
                break;
            case "safari":
                driver = launchSafariDriver();
                break;
            case "edge":
                driver = launchEdgeDriver();
                break;
            default:
                System.out.println("unrecognized browser");
                driver = null;
        }
    }

    private ChromeDriver launchChromeDriver() {
        return new ChromeDriver(setChromeOptions());
    }

    private FirefoxDriver launchFirefoxDriver() {
        String os = System.getProperty("os.name");
        if (os.contains("Linux")) {
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");
        } else if (os.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", "C:/Program Files/Mozilla Firefox");
        } else if (os.contains("Mac")) {
            System.setProperty("webdriver.gecko.driver", "");
        }
        return new FirefoxDriver(setFirefoxOptions());
    }

    private WebDriver launchSafariDriver() {
        return new SafariDriver(setSafariOptions());
    }

    private WebDriver launchEdgeDriver() {
        return new EdgeDriver(setEdgeOptions());
    }

    private ChromeOptions setChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");
        return chromeOptions;
    }

    private FirefoxOptions setFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("incognito");
        firefoxOptions.addArguments("--start-maximized");
        return firefoxOptions;
    }

    private SafariOptions setSafariOptions() {
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.getBrowserName();
        return safariOptions;
    }

    private EdgeOptions setEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless");
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");
        return edgeOptions;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
