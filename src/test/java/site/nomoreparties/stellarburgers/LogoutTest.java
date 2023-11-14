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

@Feature("Logout user")
@DisplayName("Logout user")
@RunWith(Parameterized.class)
public class LogoutTest extends BaseTest {
    private String browser;
    public LogoutTest(String browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "browser: {0}")
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
    @DisplayName("Logout > happy path")
    @Description("Logout from personal account")
    public void logoutHappyPathTest() {
        loginTestUser();
        openPersonalAccount();
        personalPage.clickLogoutButton(driver);
        loginPage.checkThatLoginPageOpened(driver);
    }

    @After
    public void teardown() {
        driver.quit();
        removeTestUser();
    }
}
