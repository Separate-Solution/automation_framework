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
import utils.ReadProperties;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        startDriverSession();
        String aut = ReadProperties.getValue("application_under_test");
        driver.get(aut);
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
        if (Boolean.parseBoolean(ReadProperties.getValue("headless"))) {
            chromeOptions.addArguments("--headless");
        }
        if (Boolean.parseBoolean(ReadProperties.getValue("incognito"))) {
            chromeOptions.addArguments("--incognito");
        }
        if (Boolean.parseBoolean(ReadProperties.getValue("launch-in-fullscreen"))) {
            chromeOptions.addArguments("--start-maximized");
        }
        return chromeOptions;
    }

    private FirefoxOptions setFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (Boolean.parseBoolean(ReadProperties.getValue("headless"))) {
            firefoxOptions.addArguments("--headless");
        }
        if (Boolean.parseBoolean(ReadProperties.getValue("incognito"))) {
            firefoxOptions.addArguments("incognito");
        }
        if (Boolean.parseBoolean(ReadProperties.getValue("launch-in-fullscreen"))) {
            firefoxOptions.addArguments("--start-maximized");
        }
        return firefoxOptions;
    }

    private SafariOptions setSafariOptions() {
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.getBrowserName();
        return safariOptions;
    }

    private EdgeOptions setEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        if (Boolean.parseBoolean(ReadProperties.getValue("headless"))) {
            edgeOptions.addArguments("--headless");
        }
        if (Boolean.parseBoolean(ReadProperties.getValue("incognito"))) {
            edgeOptions.addArguments("--incognito");
        }
        if (Boolean.parseBoolean(ReadProperties.getValue("launch-in-fullscreen"))) {
            edgeOptions.addArguments("--start-maximized");
        }
        return edgeOptions;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
