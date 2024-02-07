package page_objects;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ABTestingPage extends BasePage {
    public ABTestingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "A/B Testing")
    private WebElement abTestingLink;

    public ABTestingPage redirectToABTestingPage() {
        abTestingLink.click();
        return new ABTestingPage(driver);
    }
}
