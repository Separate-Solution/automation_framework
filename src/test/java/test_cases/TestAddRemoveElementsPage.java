package test_cases;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.AddRemoveElementsPage;

public class TestAddRemoveElementsPage extends BaseTest {
    private AddRemoveElementsPage addRemoveElementsPage;
    private UtilizeBasePage utilizeBasePageInstance;

    private AddRemoveElementsPage createAddRemoveElementsInstance() {
        return addRemoveElementsPage = new AddRemoveElementsPage(driver);
    }

    private UtilizeBasePage createUtilizeBasePageInstance() {
        return utilizeBasePageInstance = new UtilizeBasePage(driver);
    }

    @Test
    public void testAddRemoveElementsFunctionality() {
        createAddRemoveElementsInstance();
        createUtilizeBasePageInstance();
        addRemoveElementsPage.redirectToAddRemoveElementsPage();
        addRemoveElementsPage.clickAddElement();
        Assert.assertTrue(utilizeBasePageInstance.someMethod());
        addRemoveElementsPage.clickDeleteElement();
    }

    class UtilizeBasePage extends AddRemoveElementsPage {
        UtilizeBasePage(WebDriver driver) {
            super(driver);
        }

        public Boolean someMethod() {
            return super.webElementExists(deleteElementButton);
        }
    }
}