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

@Feature("Registration new user")
@DisplayName("Registration")
@RunWith(Parameterized.class)
public class RegistrationTest extends BaseTest {

    private String browser;
    public RegistrationTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Browser: {0}")
    public static Object[][] getTestData() {
        return TestData.CHROME_YA_BROWSERS;
    }

    @Before
    public void beforeSuite() {
        setBrowser(browser);
        openMainPage();
    }

    @Test
    @DisplayName("Registration > happy path")
    @Description("Registration with correct values")
    public void regHappyPathTest() {
        openRegPage();
        generateNewTestUserData();
        regPage.fillRegFormByRandomData(driver, userCard);
        regPage.clickRegButton(driver);
        loginPage.checkThatLoginPageOpened(driver);
    }

    @Test
    @DisplayName("Registration > pass less than 6 symbols")
    @Description("Pass should be more than 6 symbols")
    public void regPassLessThan6SymbolsErrorTest() {
        openRegPage();
        generateNewTestUserData(TestData.COUNT_OF_SYMBOLS_4);
        regPage.fillRegFormByRandomData(driver, userCard);
        regPage.clickRegButton(driver);
        regPage.checkErrorIncorrectPassShown(driver);
    }

    @After
    public void teardown() {
        driver.quit();
        removeTestUser();
    }
}
