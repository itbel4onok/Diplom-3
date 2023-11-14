package site.nomoreparties.stellarburgers.objects;

import site.nomoreparties.stellarburgers.base.BaseActions;
import site.nomoreparties.stellarburgers.constants.ExpectedMessage;
import site.nomoreparties.stellarburgers.resources.UserCard;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class RegPage extends BaseActions {
    // Поле "Имя"
    private final By nameField = By.xpath("//label[contains(@class, 'input__placeholder') " +
            "and text() ='Имя']/following::input[1]");

    // Поле "Email"
    private final By emailField = By.xpath("//label[contains(@class, 'input__placeholder') " +
            "and text() ='Email']/following::input[1]");

    // Кнопка "Пароль"
    private final By passField = By.xpath("//label[contains(@class, 'input__placeholder') " +
            "and text() ='Пароль']/following::input[1]");

    // Кнопка "Зарегистрироваться"
    private final By regButton  = By.xpath("//button[contains(text(),'Зарегистрироваться')]");

    // Кнопка "Войти"
    private final By loginButton  = By.xpath("//a[contains(@class,'Auth_link')" +
            " and contains(@href, '/login')]");

    // Ошибка "Некорректный пароль"
    private final By incorrectPassError  = By.xpath("//p[contains(@class, 'input__error')]");

    @Step("Reg page -> fill name/email/password by correct data")
    public void fillRegFormByRandomData(WebDriver driver, UserCard userCard){
        fillField(driver, nameField, userCard.getName());
        fillField(driver, emailField, userCard.getEmail());
        fillField(driver, passField, userCard.getPassword());
    }

    @Step("Reg page -> click to reg button")
    public void clickRegButton(WebDriver driver){
        click(driver, regButton);
    }

    @Step("Reg page -> click to login button")
    public void clickLoginButton(WebDriver driver){
        click(driver, loginButton);
    }

    @Step("Reg page -> check error of incorrect password")
    public void checkErrorIncorrectPassShown(WebDriver driver){
        assertTrue(ExpectedMessage.INCORRECT_PASS,
                isElementPresent(driver, incorrectPassError));
    }
}
