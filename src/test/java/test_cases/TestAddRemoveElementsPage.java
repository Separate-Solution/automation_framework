package test_cases;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.AddRemoveElementsPage;

public class TestAddRemoveElementsPage extends BaseTest {
    private AddRemoveElementsPage addRemoveElementsPage;
    private HelperClass helperClassInstance;
    private AddRemoveElementsPage createAddRemoveElementsInstance() {
        return addRemoveElementsPage = new AddRemoveElementsPage(driver);
    }
    private HelperClass createSomethingInstance(){
        return helperClassInstance = new HelperClass(driver);
    }
    @Test
    public void testAddRemoveElementsFunctionality() {
        createAddRemoveElementsInstance();
        createSomethingInstance();
        addRemoveElementsPage.redirectToAddRemoveElementsPage();
        addRemoveElementsPage.clickAddElement();
        System.out.println(helperClassInstance.someMethod());
        Assert.assertTrue(helperClassInstance.someMethod());
        addRemoveElementsPage.clickDeleteElement();
    }
    class HelperClass extends AddRemoveElementsPage {
        HelperClass(WebDriver driver) {
            super(driver);
        }
        public Boolean someMethod() {
            return super.webElementExists(deleteElementButton);
        }
    }
}