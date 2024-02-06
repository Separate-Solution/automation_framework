package base;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void wait(int timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException interruptedException) {
            System.out.println(interruptedException.getMessage());
        }
    }
}
