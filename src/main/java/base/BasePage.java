package base;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    protected Boolean webElementExists(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println(noSuchElementException.getMessage());
            return false;
        }
    }

    protected void navigateBack() {
        driver.navigate().back();
    }

    protected void navigateForward() {
        driver.navigate().forward();
    }

    protected void refreshPage() {
        driver.navigate().refresh();
    }

    private void clearText(WebElement textField) {
        textField.clear();
    }

    protected void enterText(WebElement textField, String text) {
        clearText(textField);
        textField.sendKeys(text);
    }

    protected String getText(WebElement textField) {
        return textField.getText();
    }

    protected void clickButton(WebElement button) {
        button.click();
    }
}
