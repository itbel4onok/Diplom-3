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

@Feature("Login user")
@DisplayName("Login user")
@RunWith(Parameterized.class)
public class LoginTest extends BaseTest {
    private String browser;
    private String element;
    public LoginTest(String browser, String element) {
        this.browser = browser;
        this.element = element;
    }

    @Parameterized.Parameters(name = "Login button from {1}, browser: {0}")
    public static Object[][] getTestData() {
        return new Object[][] {
                { TestData.CHROME, TestData.LOGIN_MAIN },
                { TestData.CHROME, TestData.LOGIN_ACCOUNT },
                { TestData.CHROME, TestData.LOGIN_REG_FORM },
                { TestData.CHROME, TestData.LOGIN_RESET_PASS },
                { TestData.YA, TestData.LOGIN_MAIN  },
                { TestData.YA, TestData.LOGIN_ACCOUNT },
                { TestData.YA, TestData.LOGIN_REG_FORM },
                { TestData.YA, TestData.LOGIN_RESET_PASS },
        };
    }

    @Before
    public void beforeSuite() {
        setBrowser(browser);
        createTestUserByApi();
        openMainPage();
    }

    @Test
    @DisplayName("Login > happy path")
    @Description("Login from different button located")
    public void loginHappyPathTest() {
        openLoginPage(element);
        loginPage.fillLoginForm(driver, userCard);
        loginPage.clickLoginButton(driver);
        constructorPage.checkPlaceOrderButtonShown(driver);
    }

    @After
    public void teardown() {
        driver.quit();
        removeTestUser();
    }
}
