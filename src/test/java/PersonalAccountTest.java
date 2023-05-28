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

@Feature("Open personal account")
@DisplayName("Personal account")
@RunWith(Parameterized.class)
public class PersonalAccountTest extends BaseTest {
    private String browser;
    public PersonalAccountTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Browser: {0}")
    public static Object[][] getTestData() {
        return TestData.CHROME_YA_BROWSERS;
    }

    @Before
    public void beforeSuite() {
        setBrowser(browser);
        createTestUserByApi();
        openMainPage();
    }

    @Test
    @DisplayName("Open Personal account > happy path")
    @Description("Open personal account, created user is needed")
    public void openPersonalPageHappyPathTest() {
        loginTestUser();
        openPersonalAccount();
        personalPage.checkProfileTextShown(driver);
    }

    @After
    public void teardown() {
        driver.quit();
        removeTestUser();
    }
}
