package page_objects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject extends BasePage {
    public PageObject(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@class='button']")
    private WebElement searchButton;
    public void clickSearch(){
        searchButton.click();
    }
}