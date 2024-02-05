package page_objects;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObject extends BasePage {
    @FindBy(xpath = "//input[@class='button']")
    private WebElement searchButton;
    public void clickSearch(){
        searchButton.click();
    }
}
