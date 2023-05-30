package site.nomoreparties.stellarburgers;

import site.nomoreparties.stellarburgers.base.BaseTest;
import site.nomoreparties.stellarburgers.constants.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@Feature("Opening constructor sections")
@DisplayName("Constructor")
@RunWith(Parameterized.class)
public class ConstructorSectionsTest extends BaseTest {
    private String browser;
    private String element;
    public ConstructorSectionsTest(String browser, String element) {
        this.browser = browser;
        this.element = element;
    }

    @Parameterized.Parameters(name = "Open {1}, browser: {0}")
    public static Object[][] getTestData() {
        return new Object[][] {
                { TestData.CHROME, TestData.BUN_SECTION },
                { TestData.CHROME, TestData.SAUCE_SECTION },
                { TestData.CHROME, TestData.FILLING_SECTION },
                { TestData.YA, TestData.BUN_SECTION },
                { TestData.YA, TestData.SAUCE_SECTION },
                { TestData.YA, TestData.FILLING_SECTION },
        };
    }

    @Before
    public void beforeSuite() {
        setBrowser(browser);
        openMainPage();
    }

    @Test
    @DisplayName("Constructor > open sections")
    @Description("Open constructor sections")
    public void constructorSectionHappyPathTest() {
        constructorPage.clickSectionButton(driver, element);
        constructorPage.checkThatSectionDisplayed(driver, element);

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
