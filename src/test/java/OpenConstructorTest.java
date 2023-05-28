import base.BaseTest;
import constants.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@Feature("Open constructor from personal account")
@DisplayName("Constructor")
@RunWith(Parameterized.class)
public class OpenConstructorTest extends BaseTest {
    private String browser;
    private String element;
    public OpenConstructorTest(String browser, String element) {
        this.browser = browser;
        this.element = element;
    }

    @Parameterized.Parameters(name = "Open constructor from {1}, browser: {0}")
    public static Object[][] getTestData() {
        return new Object[][] {
                { TestData.CHROME, TestData.SITE_LOGO },
                { TestData.CHROME, TestData.CONSTRUCTOR_BUTTON },
                { TestData.YA, TestData.SITE_LOGO  },
                { TestData.YA, TestData.CONSTRUCTOR_BUTTON },
        };
    }

    @Before
    public void beforeSuite() {
        setBrowser(browser);
        createTestUserByApi();
        openMainPage();
        loginTestUser();
    }

    @Test
    @DisplayName("Open constructor > happy path")
    @Description("Open constructor from personal account")
    public void openConstructorHappyPathTest() {
        openPersonalAccount();
        openConstructor(element);
        constructorPage.checkPlaceOrderButtonShown(driver);
    }

    @After
    public void teardown() {
        driver.quit();
        removeTestUser();
    }
}
