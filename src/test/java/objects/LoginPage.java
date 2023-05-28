package objects;

import base.BaseActions;
import constants.ExpectedMessage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resources.UserCard;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BaseActions {
    // Поле "Email"
    private final By emailField = By.xpath("//label[contains(@class, 'input__placeholder') " +
            "and text() ='Email']/following::input[1]");

    // Поле "Пароль"
    private final By passField = By.xpath("//label[contains(@class, 'input__placeholder') " +
            "and text() ='Пароль']/following::input[1]");

    //Кнопка "Зарегистрироваться"
    private final By regButton  = By.xpath("//a[contains(text(),'Зарегистрироваться')]");

    //Кнопка "Войти"
    private final By loginButton  = By.xpath("//button[contains(text(),'Войти')]");

    //Кнопка "Восстановить пароль"
    private final By recoverPass  = By.xpath("//a[contains(@href,'/forgot-password')]");

    @Step("Login page -> click to reg button")
    public void clickRegButton(WebDriver driver){
        click(driver, regButton);
    }

    @Step("Login page -> click to login button")
    public void clickLoginButton(WebDriver driver){
        click(driver, loginButton);
    }

    @Step("Login page -> click to recover password button")
    public void clickRecoverPassButton(WebDriver driver){
        click(driver, recoverPass);
    }

    @Step("Login page -> wait page loading")
    public void waitForLoadLoginPage(WebDriver driver) {
        waitForLoadPage(driver, loginButton);
    }

    @Step("Login page -> check that page opens")
    public void checkThatLoginPageOpened(WebDriver driver) {
        waitForLoadLoginPage(driver);
        assertTrue(ExpectedMessage.LOGIN_PAGE_OPENS, isElementPresent(driver, loginButton));
    }

    @Step("Login page -> fill fields by test-user data")
    public void fillLoginForm(WebDriver driver, UserCard userCard) {
        fillField(driver, emailField, userCard.getEmail());
        fillField(driver, passField, userCard.getPassword());
    }
}
