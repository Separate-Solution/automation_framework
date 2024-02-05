package test_cases;

import base.BaseTest;
import org.testng.annotations.Test;
import page_objects.PageObject;

public class InitialTest extends BaseTest {
    @Test
    public void initialTestCase(){
        PageObject pageObject = new PageObject();
        pageObject.clickSearch();
    }
}