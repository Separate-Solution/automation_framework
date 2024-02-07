package page_objects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemoveElementsPage extends BasePage {
    @FindBy(linkText = "Add/Remove Elements")
    private WebElement addRemoveElementLink;

    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement addElementButton;

    @FindBy(xpath = "//button[text()='Delete']")
    protected WebElement deleteElementButton;


    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AddRemoveElementsPage redirectToAddRemoveElementsPage() {
        addRemoveElementLink.click();
        return new AddRemoveElementsPage(driver);
    }

    public void clickAddElement() {
        addElementButton.click();
    }

    public void clickDeleteElement() {
        deleteElementButton.click();
    }
}
